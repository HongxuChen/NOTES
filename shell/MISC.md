### generate 5 passwords with the length of 5
```bash
pwgen 10 -N5 
```
### ort process by cmd name
```bash
ps -e --sort cmd
```
### kill all process matching PROCESS
```bash
ps -ef | grep PROCESS | grep -v grep | awk '{print $2}' | xargs kill -9
```
### list running process id
```bash
ps -eo pid --no-headers   #ps -e | awk '{print $1}'
```
### print outputs to console and files
```bash
(cmd | tee stdout.log) 3>&1 1>&2 2>&3 | tee stderr.log
```
### used in scripts, get self name
```bash
basename "$(test -L "$0" && readlink "$0" || echo "$0")"
```
### Print all lines of files in a certain directory
```bash
(find ./ -name '*.java' -print0 | xargs -0 cat) | wc -l
```

### sort file by file length
```bash
find . -name "*.sh" | awk -F"/" '{ print length($NF),$NF} | "sort -nr" }'
```

### Remove executable
```bash
#remove files do not containing a dot(should use *ls* instead of *rm* first)
ls | grep -v "\." | xargs rm
find . -not -name "*.*" -exec ls -l {} \;find . -not -name "*.*" -exec rm -i {} \;
#remove executable(exclude dirs)
find . -type f -executable -exec rm '{}' \;
find . -executable -delete
find . -perm /111 -delete
find . -perm /ugo+x -delete
find . -perm +100 -type f -delete
```
### Find broken symlinks and delete them
```bash
 find . -type l -exec test ! -e {} \; -delete
```
### Generate thumbnails of jpg images
```bash
$ for i in *.JPG ; do ( djpeg -scale 1/16 -ppm "${i}" | pnmscale -pixels 50246 | cjpeg -optimize -progressive > /preview/"${i%%.*}".jpeg ) ; done
```
### System and resources
```bash
uname -m                     #or *arch*,Check if system is 32bit or 64bit
chkconfig --list|grep 1:on   #List all system service that is *on* on Level 1:
grep MemFree /proc/meminfo   #free memory
cat /etc/lsb-release         #*head -n 1 /etc/issue* or *lsb_release -d*
lspci -tv                    #list all pci device
cat /proc/loadavg            #view system  average load
swapon -s                    #view swap
sudo iptables -L             #view firewall settings
id                           #view user id
last                         #login log
crontab -l                   #view jobs for current user
cut -d: -f1 /etc/passwd      # view all users
cut -d: -f1 /etc/group       # all groups
```

### turn off ipv6(debian)
```bash
#append /etc/sysctl.conf with the following
net.ipv6.conf.all.disable_ipv6 = 1
net.ipv6.conf.default.disable_ipv6 = 1
net.ipv6.conf.lo.disable_ipv6 = 1
```

### using sudowith an alias
```bash
alias sudo='sudo ' #a blank!
```

### Close shell keeping all subprocess running
```bash
disown -a && exit
```

### Display the top ten memory usage running processes
```bash
ps aux | sort -nk +4 | tail
```

### list `.conf` sorted by size
```
ls -lSrp | grep [^/]$ | grep [\.]conf$ | head -n 5
```

### recover corrupted tar.gz file
http://www.urbanophile.com/arenn/coding/gzrt/gzrt.html
```
gzrecover corrupted-file.tar.gz
cpio -F corrupted-file.tar.gz.recovered -i -v
```

### find the deleted but still taking place files
```
sudo su <<EOF
lsof |grep deleted
EOF
```
