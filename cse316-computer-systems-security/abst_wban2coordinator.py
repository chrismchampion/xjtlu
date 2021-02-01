#import serial
import socket
import time
import random
import hmac

from collections import OrderedDict
from ecc.Key import Key
from hashlib import sha256
from ecc.elliptic import mul,add,neg
from ecc.curves import get_curve

DOMAINS = {
    # Bits : (p, order of E(GF(P)), parameter b, base point x, base point y)
    256: (0xffffffff00000001000000000000000000000000ffffffffffffffffffffffff,
          0xffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551,
          0x5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b,
          0x6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296,
          0x4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5)
}

if __name__ == '__main__':

    print("---Responder (B)---")

    global Ta, Rb, p, n, b, x, y, c_p, c_q, c_n, F1, F2, F3, MK

    HOST = '127.0.0.1'
    PORT = 9004

    # Initialization - A,B share Group parameters and password PW
    p, n, b, x, y = DOMAINS[256]

    # Group parameters
    c_p = 3
    c_n = p
    c_q = p - b

    # Address_A and Address_B
    idA = '00000001'
    idB = '00000002'

    # Password used to hide/scramble A's public key
    PW = (1234,5678)
    token = 0

    print('\nBegin')

    # TCP link
    sock = socket.socket(socket.AF_INET,socket.SOCK_STREAM)
    sock.bind((HOST,PORT))

    print('Listen to the connection from client...')
    sock.listen(5)

    try:
        while token == 0:
            connection, address = sock.accept()
            print('Connected. Got connection from ', address)

            # (0A)
            # Select private key SKb
            # Compute public key PKb
            # PKb  = (PKbx, PKby) = SKb * G
            keypair = Key.generate(256)
            PKbx = keypair._pub[1][0]
            PKby = keypair._pub[1][1]
            SKb = keypair._priv[1]


            # (2B)
            # Select 128-bit Nonce_B [Nb]
            Nb = random.randint(000000, 999999)

            # Received First Security Association frame sent in (3A)
            # F1 = Address_B || Address_A || Nonce_A || PK'ax || PK'ay
            F1 = connection.recv(1024).decode()


            # (4B)
            print("\nReceived 1st Security Association frame from A containing PK'a")


            # (5B)
            # Retrieve Pkapw = PK'a = A's password-scrambled public key
            Na = F1.split(',')[2]
            PKapwx = F1.split(',')[3]
            PKapwy = F1.split(',')[4]
            PKapw = (int(PKapwx), int(PKapwy))

            # Recover A's public key
            # PKa = PK'a + Q(PW) [PKa = PKapw + PW]
            PKa = add(c_p, c_q, c_n, PKapw, PW)


            # (6B)
            # Compute shared secret key MK = PKa * SKb
            MK = mul(c_p, c_q, c_n, PKa, SKb)


            # (7B)
            # B-->A: Second Security Association frame
            # F2 = Address_A || Address_B || Nonce_B || PKbx || PKby
            F2 = idA + ',' + idB + ',' + str(Nb) + ',' + str(PKbx) + ',' + str(PKby)
            connection.send(F2.encode())
            print('\n2. B-->A: Second Security Association frame')
            print("\F2 = Address_A || Address_B || Nonce_B || PKbx || PKby")


            # (9B)
            # Compute MAC_3B
            hmac_stringa = idB+idA+str(Nb)+Na
            newhash = hmac.new(str(MK[0]).encode(), ''.encode(), sha256)
            newhash.update(hmac_stringa.encode())
            MAC_3B = newhash.hexdigest()


            # (10B)
            # B-->A: Third Security Association Frame
            F3 = MAC_3B
            connection.send(F3.encode())
            print('\n3. B-->A: Third Security Association frame')
            print("F3 = MAC_3B")


            # (15B)
            # Receive Fourth Security Association frame send in (14A)
            # M4 = MAC_4A
            F4 = connection.recv(1024).decode()
            MAC_4A = F4


            # (16B)
            # Compute MAC_4B
            hmac_stringb = idA+idB+Na+str(Nb)
            newhash = hmac.new(str(MK[0]).encode(), ''.encode(), sha256)
            newhash.update(hmac_stringb.encode())
            MAC_4B = newhash.hexdigest()


            # (17B)
            # Check if MAC_4A = MAC_4B
            # Do not proceed if check fails
            if str(MAC_4B) == MAC_4A:
                print('MAC_A is valid')


                # (18)
                print('\nSuccess! The shared secret key MK is', MK)
            else:
                print('\nFail: MAC_A is invalid, end protocol')
            token=1

    except KeyboardInterrupt:
        print('>>>quit')
    #sys.exit(0)
