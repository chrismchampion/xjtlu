import errno
import socket
import time
import random
import hmac

from collections import OrderedDict
from ecc.Key import Key
from hashlib import sha256
from ecc.elliptic import mul, add, neg

DOMAINS = {
    # Bits : (p, order of E(GF(P)), parameter b, base point x, base point y)

    256: (0xffffffff00000001000000000000000000000000ffffffffffffffffffffffff,
          0xffffffff00000000ffffffffffffffffbce6faada7179e84f3b9cac2fc632551,
          0x5ac635d8aa3a93e7b3ebbd55769886bc651d06b0cc53b0f63bce3c3e27d2604b,
          0x6b17d1f2e12c4247f8bce6e563a440f277037d812deb33a0f4a13945d898c296,
          0x4fe342e2fe1a7f9b8ee7eb4a7c0f9e162bce33576b315ececbb6406837bf51f5)
}

if __name__ == '__main__':

    print("---Initiator (A)---")

    global Ra, Tb, p, n, b, x, y, c_p, c_q, c_n, F1, F2, F3, MK

    server_ip = "127.0.0.1"
    server_port = 9004

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
    PW = (1234, 5678)
    token = 0

    # TCP connection to responder B
    sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sock.setblocking(1)
    print('\nbegin connection')
    sock.connect((server_ip, server_port))

    try:
        while token == 0:
            print('connected to ', server_ip)

            # (0A)
            # Select private key SKa
            # Compute public key
            # PKa  = (PKax, PKay) = SKa * G
            keypair = Key.generate(256)
            PKax = keypair._pub[1][0]
            PKay = keypair._pub[1][1]
            PKa = (PKax, PKay)
            SKa = keypair._priv[1]


            # (1A)
            # Compute password-scrambled public key PK'a [PKapw]
            # PK'a [PKapw] = PKa - Q(PW) [PKa + negPW]
            negPW = neg(PW, c_n)
            PKapw = add(c_p, c_q, c_n, PKa, negPW)


            # (2A)
            # Select 128-bit Nonce_A [Na]
            Na = random.randint(000000, 999999)


            # (3A)
            # A->B: First Security Association frame
            # F1 = Address_B || Address_A || Nonce_A || PK'ax || PK'ay
            F1 = idB + ',' + idA + ',' + str(Na) + ',' + str(PKapw[0]) + ',' + str(PKapw[1])
            sock.send(F1.encode())
            print('\n1. A-->B: First Security Association frame')
            print("F1 = Address_B || Address_A || Nonce_A || PK'ax || PK'ay")


            # (8A)
            # Received Second Security Association frame sent in (7B)
            # F2 = Address_A || Address_B || Nonce_B || PKbx || PKby
            F2 = sock.recv(1024).decode()
            print('\nReceived 2nd Security Association frame from B containing PKb')

            # Retrieve B's public key PKb from F2:
            # needed for computing shared secret key MK in step 9A
            Nb = F2.split(',')[2]
            PKbx = F2.split(',')[3]
            PKby = F2.split(',')[4]
            PKb = (int(PKbx), int(PKby))


            # (9A)
            # Compute shared secret key MK = PKb * SKa
            MK = mul(c_p, c_q, c_n, PKb, SKa)

            # Compute MAC_3A
            print('\nComputing MAC_3A...')
            hmac_stringa = idB + idA + Nb + str(Na)
            newhash = hmac.new(str(MK[0]).encode(), ''.encode(), sha256)
            newhash.update(hmac_stringa.encode())
            MAC_3A = newhash.hexdigest()


            # (11A)
            # Received Third Security Association frame sent in (10B)
            # F3 = MAC_3B
            F3 = sock.recv(1024).decode()
            print('\nReceived 3rd Security Association frame from B containing MAC_3B')
            MAC_3B = F3
            print('MAC_3A: ',MAC_3A)
            print('MAC_3B: ', MAC_3B)


            # (12A)
            # Check if MAC_3A = MAC_3B
            # Do not proceed if check fails
            if str(MAC_3A) == MAC_3B:
                print('MAC_B is valid')


                # (13A) Compute MAC_4A
                print('\nComputing MAC_4A...')
                hmac_stringb = idA + idB + str(Na) + Nb
                newhash = hmac.new(str(MK[0]).encode(), ''.encode(), sha256)
                newhash.update(hmac_stringb.encode())
                MAC_4A = newhash.hexdigest()


                # (14A)
                # A-->B: Fourth Security Association frame
                F4 = MAC_4A
                sock.send(F4.encode())
                print('\n4. A-->B: Fourth Security Association frame')


                # (18)
                print('\nSuccess! The shared secret key MK is', MK)
            else:
                print('\nFail: MAC_B is invalid, end protocol')
            token = 1

    except KeyboardInterrupt:
        sock.close()
        print("KeyboardInterrupt")
    # sys.exit(0)
