Scenarios:
---
###client and server locates on the same machine(192.168.1.222):

* `python udp_remote.py server 192.168.1.224`(not the same ip) outputs `socket.error: [Errno 99] Cannot assign requested address`.

* `python udp_remote.py server 127.0.0.1` and `python udp_remote.py client  127.0.0.1`,communicate successfully

* `python udp_remote.py server 127.0.0.1` and `python udp_remote.py client  127.0.0.1 192.168.1.222`, communicate successfully

* `python udp_remote.py server 127.0.0.1` and `python udp_remote.py client 127.0.0.1 0.0.0.251`,the server might receive the several messages,but client never receives the message from server.

* `python udp_remote.py server 127.0.0.1` and `python udp_remote.py client  127.0.0.1 192.168.2.222`(submask is `255.255.255.0`), outputs:`socket.error: [Errno 99] Cannot assign requested address`

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py client  127.0.0.1`,client outputs:`    socket.error: [Errno 111] Connection refused`

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py www.google.com`, server receive nothing(of course) and client guess `RuntimeError: [client] I think the server is down`

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py www.google.com 127.0.0.1`,client outputs `socket.error: [Errno 22] Invalid argument`

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py www.google.com www.google.com`,client outputs `socket.error: [Errno 99] Cannot assign requested address`.

###client and server locates on different machines(server:_192.168.1.222_,client _192.168.1.224_)

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py 192.168.1.224 `,client outputs `socket.error:[Errno 10054] An existing connection was forcibly closed by the remote host`.

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py 192.168.1.222 127.0.0.1`,client outputs `socket.error: [Errno 100051] A socket operation was attempted to an unreachable network`.

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py 192.168.1.222 192.168.1.222`,client outputs `socket.error:[Errno 10049] The requested address is notvalid in its context.`

* `python udp_remote.py server 192.168.1.222` and `python udp_remote.py 192.168.1.222 192.168.2.224`,communicate successfully.