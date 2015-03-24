tool name    |  description   |
:------------|:---------------|
iostat|
cat /proc/meminfo|
mpstat|
nmon|
pmap|
ps|
pstree|
sar|
strace|
tcddump|
htop|
uptime|
vmstat|
arp | 操作arp的cache
curl | 传输url；非常强大
dhclient/dhcpd | dhcp客户端
dig | dns查看工具；有人建议以此取代nslookup
doscan | 网络DoS能力审计
dsniff | 密码嗅探器；这。。。
etherape | 图形化网络流量浏览器；很直观
etherwake | 发送wake-on-lan“魔力报文”
ethstats | 快速显示网络接口统计信息；不仅eth
ethstatus | 基于终端的以太网统计监控；只对eth
ettercap | 用于中间人攻击的多目的嗅探/内容过滤；这这这。。。
ftp/lftp | ftp客户端；lftp比ftp爽很多
ftpgrab |（ftp）文件镜像工具
host | dns查看工具；没nslookup强
httping | 度量web服务器延迟和吞吐
hunt | 网络安全审计工具；兵来将挡水来土掩:-)
ifconfig | 配置网络接口；应该都用过吧
iftop | 显示主机接口带宽使用情况；名气挺大呀
ifup/ifdown | 开启/禁用网络端口；脚本，一般用ifconfig取代
ip | 查看/操作路由信息、设备、策略路由和隧道信息；和ifconfig类似，据说更为强大
ifmetric | ipv4路由度量操作
ifplugd | 以太网设备连接检测守护进程
ifscheme | 网络接口模式控制
ipband | ip带宽监控器
iperf | 网络吞吐性能测试
iptables | ipv4包过滤器和nat工具
iwconfig | 配置无线网络接口；试过但没配置成功过
iwlist | 由无线接口获取更多无线信息细节
mtr | 网络分析工具；可以有X和终端两种GUI
netstat | 打印网络连接、路由表、接口统计分析、伪装连接、多播成员信息；强大，常用
nc | TCP/IP瑞士军刀；对得起这描述，起源于bsd，net cat
nmap | 网络查看、端口扫描；network mapper，传说非常牛逼
nslookup | (可交互式)查询网络服务器；众所周知
ntpdate | 通过ntp更新时间
openssl | openSSL的cli
ping/ping6 | 发送ICMP ECHO_REQUEST给网络主机；地球人都知道
pppoeconf | 配置PPPoE连接；现在大家用的不多了
rarp | 操作rarp表；据说linux内核2.3开始不再支持
rdesktop | 远程桌面协议客户端；linux远程windows必备
route | 显示/操作ip路由表；添加删除路由
rsync | 快速、灵活、远程或本地文件复制工具；只闻其名
scp | 安全远程文件拷贝；和ssh连起来用
sftp | 安全ftp
slurm | 网络负载监控器；终端下的GUI，直观
socat | 多用途套接字应答；socket cat
snmpd | 请求SNMP请求报文的守护进程
snmpget/snmpgetnext | 通过SNMP GET/GETNEXT和网络实例通信
snmpset | 设置远程主机一个MIB对象的值
snmptable | 检索并显示来自远程主机的snmp表
snmpwalk | 获取snmp表并以表格形式显示
ss | 套接字统计分析；socket statistics[这里提到用ss来取代netstats]
ssh | openSSH 客户端；据说远程无所不能
tcpdump | 抓取网络信息；不仅仅只针对tcp，可以和Wireshark联合使用
telnet | telnet client
traceroute/traceroute6 | 跟踪路由信息；大名鼎鼎
ufw | 管理网络过滤防火墙；太有名了
vnc4server/vnc4passwd/vnc4config | 被远程X window时用
webalizer | web服务器log文件分析工具
wget | 非交互式网络数据读取工具；赫赫有名
wireshark(ethereal) | 交互式网络抓取分析工具，图形化界面；非常强大
xinetd | 扩展网络服务守护进程；重口味

reference:

- [Debian Network Tools For Administrators](http://www.debianhelp.co.uk/networktools1.htm)
- [TCP/IP Essentials](http://book.douban.com/subject/1807753/)
