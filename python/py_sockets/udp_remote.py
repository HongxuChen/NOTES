'''
Created on Oct 7, 2012

@author: nonoob
'''

import random
import socket
import sys

s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

MAX = 65535
SERVER_PORT = 1062
CLIENT_PORT = 43221

if ((2 <= len(sys.argv) <=3) and (sys.argv[1] == 'server')):
    interface = sys.argv[2] if len(sys.argv) > 2 else ''
    s.bind((interface,SERVER_PORT))
    print '[server] Listening at',s.getsockname()
    while True:
        data,address = s.recvfrom(MAX)
        if random.randint(0,1):
            print '[server] The client at',address, 'says:',repr(data)
            s.sendto('Your data was %d bytes:%s'% (len(data),data),address)
        else:
            print '[server] Pretending to drop packet from',address
        
elif 3<=len(sys.argv)<=4 and sys.argv[1] == 'client':
    hostname=sys.argv[2]
    bind_ip = sys.argv[3] if len(sys.argv)==4 else ''
    s.bind((bind_ip,CLIENT_PORT))
    s.connect((hostname,SERVER_PORT))
    print 'Client socket name is',s.getsockname(),'connected to',s.getpeername()
    delay = 0.1
    while True:
        s.send('This is another message')
        print '[client] Waiting up to',delay,'seconds for a reply'
        s.settimeout(delay)
        try:
            data = s.recvfrom(MAX)
        except socket.timeout:
            delay *= 2
            if delay >4.0:
                raise RuntimeError('[client] I think the server is down')
        except:
            raise
        else:
            break
    print '[client] The server says',repr(data)
    
else:
    print >>sys.stderr, '[stderr] usage: udp_remote.py server [<listen_interface>]'
    print >>sys.stderr,'           or:  udp_remote.py client <server_host> [<bind_addr>]'
