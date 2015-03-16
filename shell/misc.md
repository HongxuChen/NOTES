### generate 5 passwords with the length of 10
```bash
pwgen 10 -N5 
```
### sort process by cmd name
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

### convert YAML to JSON
```
python -c 'import sys, yaml, json; json.dump(yaml.load(sys.stdin), sys.stdout, indent=4)' < file.yaml > file.json
```

## previous until exit status is 0
```
!!; while [ $? -ne 0 ]; do !!; done
```

## more info about cpu
``` bash
grep 'model name' /proc/cpuinfo | wc -l  #cpu cores
```

## arp scan
```
arp-scan -I eth0 -l | grep 10.112.18.155
```

## combined several commands
```
$ lld ; echo "ok" ; lok
-bash: lld: command not found
ok
-bash: lok: command not found

$ echo "ok" && lld && echo "ok"
ok
-bash: lld: command not found

$ lld || echo "ok" || lok
bash: command not found: lld
ok
```

## html to pdf
```
wkhtmltopdf my_resume.html my_resume.pdf
```

### print latest modified contents
```
# fails when the last changed is a directory
watch 'ls -tr1 | tail -n1 | xargs tail'
```

### count LOC of a directory
```
find . -name '*.cc' | xargs wc -l
# works on names with space
( find ./ -name '*.[h|c|cc|cpp|php]' -print0 | xargs -0 cat ) | wc -l
```

###/etc/sudoers

```bash
user_name ALL=NOPASSWD:ALL #not in admin group
```

### progress

```bash
MAX=20

for (( i = 0; i < $MAX; i++ )); do
  SPC=$(($MAX-$i))
  printf "=%${i}s"|tr " " "="
  printf ">%${SPC}s%3s|"
  printf $(bc <<< "scale=2;100*$i/$MAX")
  printf "\r"
  sleep 0.1
done
```

### archive

```text
test
├── flx
│   └── flx.txt
└── flyer.txt
```
tar the directory into _test.tar.gz_, and get cetain depth file names.
```bash
tar tf test.tar.gz|cut -d/ -f2 |uniq
tar tf test.tar.gz|head -1|cut -d/ -f1
```

###wget
```bash
wget -r -np -nd --accept=iso http://example.com/centos-5/i386/    #recursively,don't traverse parent dir,don't re-construct locally,only accept iso files
wget -i filename.txt                         #get urls from filename.txt
wget -c http://example.com/really-big-file.iso  #Continue getting a partially-downloaded file
wget -m -k (-H) http://www.example.com/      #mirror a site
```

### change username

```bash
# logout from current username and log as root
su - username
kill -9 -1

# change username and directory
usermod -l new_username -d /home/new_username -m old_username

# change group
groupmod -n new_username old_username

# change fullname
chfn -f new_fullname new_username

# application settings
## firefox: `extension.ini` (might change, not for firefox 19 in my case)
## soft links inside home directory
## git submodules: need to deal with `.git/modules/`
## disks that mounted on some directory of home directory(`/etc/fstab`)
## auto login in LXDE: `/etc/lxdm/default.conf`
## remove auto generated folders in home directory

# sudo settings
username ALL=(ALL) NOPASSWD: ALL
```
