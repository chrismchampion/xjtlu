# CSE316 Assessment 1: Coursework

## Tasks

In this assignment, students are asked to improve the efficiency or security of authenticated key exchange (AKE) protocols. Codes of AKE protocols in TLS, IEEE 802.15.6 and Bluetooth will be given as examples; and methods to improve the efficiency and security will be introduced. Students are going to realize lightweight AKE protocols or security-enhanced AKE protocols using the introduced methods or their own proposed methods.

In particular, each student should

1. Realize a lightweight AKE protocol or a security-enhanced AKE protocol of his/her choice;
2. Write a short report (in MS word, single column, 11 font size, and in Calibri font style). The
report is expected to include the following parts: a) a brief description of protocol; b) experimental platform (e.g., hardware, software); c) results, e.g., runtime, screenshots for the experiment.

The example codes are in Python, but students can use their preferred programming language for the tasks.

## Marking Scheme

Total points: 100 (contribute 20% to the overall assessment)

| Item | Marks |
| ------------- | ------------- |
| Realisation  | 30 |
| Testing  | 30 |
| Quality of implementation  | 20 |
| Quality of report  | 20 |

## Submission

Each student should submit a short report and codes to ICE, without coursework cover.
Deadline: Sunday, 17 May 2020, 23:59



## Description of Protocol and Implementation

Wireless Body Area Networks (WBAN) can be conceptually compared to potentially more familiar Wireless Local Area Networks (WLAN) in that they consist of a network of wirelessly connected devices (e.g. PCs, smartphones) communicating with each other via a centralized hub (e.g. WLAN router). The key difference is that WBANs use short-range wireless communication standards to enable much smaller devices, e.g. sensors worn on (or implanted in) the human body, to communicate via a WBAN coordinator (hub) that can in turn use a more powerful device such as a smartphone as an internet gateway.[1] WBANs thus have a clear use case in the medical and healthcare fields as a breakthrough technology: granting extended patient mobility, i.e. less time spent confined to healthcare facilities, and providing physicians a continuous and up-to-date data steam of patient health conditions.[2] 

IEEE 802.15.6 is the current international standard for WBANs. As compared to the IEEE 802.11 WLAN standard, it documents the specification of, e.g. frequency bands for WBAN device communications approved by national medical and governing regulatory authorities.[3] For example, the 2009 standard 802.15.4 was amended as 802.15.4c to support additional frequency bands to comply with Chinese regulations for using within P.R. China.[4] At its core, 802.15.6 applies four elliptic curve-based key agreement protocols with the goal of providing established network security concepts—namely confidentiality, authentication, integrity, privacy protection, and replay defense—in WBANs.[5] All four ECDH-based protocols have all been shown to be vulnerable to various attacks including man-in-the-middle, impersonation, and offline dictionary attacks.[5], [6]

> *Figure 1: Password authenticated association procedure[7]*

This implementation targets the IEEE 802.15.6 standard’s password authenticated key exchange (PAKE) ECDH-based protocol, also known as IEEE 802.15.6 Password Authenticated Association (PW-AKE), in which a sensor/initiator node (A) and hub/responder node (B) both contribute information, i.e. use public and private key keypairs and scalar multiplication to generate an agreed upon shared secret master key MK. This procedure is depicted in Figure 1. From a security standpoint, this is beneficial over using a key transport protocol since, as such, a single point of attack exists when one party alone is responsible for generating the secret master key MK.

An abstracted version of the standard key exchange procedure focusing on the protocol’s message passing sequence has been implemented and is depicted in Figure 2, allowing for a visual comparison to the standard procedure. Each operation below is equally labeled as such within the code files. 

> *Figure 2: Implementation – Abstracted protocol procedure*

## Experiment Environment

The implementation was developed using Python3 using the included ecc python library in the PyCharm 2020.1 IDE for macOS version 10.15.4. The localhost IP (127.0.0.1) was used during development for testing and debugging the abstracted implementation protocol’s key generation and message passing procedures as depicted in Figure 2. The final implementation was then tested between two standalone virtual machine (VM) environments running standard configurations of Linux Ubuntu 19.10 in VirtualBox 6.0.20 for macOS version 10.15.4. Both VMs were allotted 4GB of base system memory and configured to use the host device’s network adapter settings, i.e. run in “bridged mode”, to ease the establishment of communication between VMs.

## Results

> *Figure 3: Results – Initiator node A*

> *Figure 4: Results – Responder node B*

Further methods for improving the security of the protocol have been researched. For example, via the introduction of two random values chosen by the initiator (A) and responder (B), thus allowing for the obfuscation of the initiating node’s public key throughout the protocol’s complete sequence.[8]

## References

[1]	H. Khan, B. Dowling, and K. M. Martin, “Highly Efficient Privacy-Preserving Key Agreement for Wireless Body Area Networks,” in 2018 17th IEEE International Conference On Trust, Security And Privacy In Computing And Communications/ 12th IEEE International Conference On Big Data Science And Engineering (TrustCom/BigDataSE), 2018, pp. 1064–1069.

[2]	B. Latré, B. Braem, I. Moerman, C. Blondia, and P. Demeester, “A survey on wireless body area networks,” Wirel. Networks, vol. 17, no. 1, pp. 1–18, 2011.

[3]	IEEE, “802.15.6-2012 - IEEE Standard for Local and metropolitan area networks - Part 15.6: Wireless Body Area Networks.” .
[4]	IEEE, “802.15.4c-2009 - IEEE Standard for Information technology-- Local and metropolitan area networks-- Specific requirements-- Part 15.4: Amendment 2: Alternative Physical Layer Extension to support one or more of the Chinese 314-316 MHz, 430-434 MHz, and 779.”
[5]	Mohsen Toorani, “On Vulnerabilities of the Security Association in the IEEE 802.15.6 Standard,” vol. 8976, no. October 2016, pp. 49–62, 2015.
[6]	J. Zhang, N. Xue, and X. Huang, “A Secure System for Pervasive Social Network-Based Healthcare,” IEEE Access, vol. 4, no. c, pp. 9239–9250, 2016.
[7]	Mohsen Toorani, “Security analysis of the IEEE 802.15.6 standard,” Int. J. Commun. Syst., vol. 23, no. 5, pp. 633–652, 2010.
[8]	J. Zhang, X. Huang, P. Craig, A. Marshall, and D. Liu, “An Improved Protocol for the Password Authenticated Association of IEEE 802.15.6 Standard That Alleviates Computational Burden on the Node,” Symmetry (Basel)., vol. 8, no. 11, p. 131, 2016.