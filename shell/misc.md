### print outputs to console and files
```bash
(cmd | tee stdout.log) 3>&1 1>&2 2>&3 | tee stderr.log
```

### script gets self name
```bash
basename "$(test -L "$0" && readlink "$0" || echo "$0")"
```

### System and resources
```bash
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

# tr
```bash
## usage
# tr [OPTION] SET1 [SET2]  
# CHAR1-CHAR2,[CHAR*],[CHAR*REPEAT],[:alnum:],[:alpha:],[:blank:],[:cntrl:],[:digit:],[:graph:],[:lower:],[:print:],[:punct:],[:space:],[:upper:],[:xdigit:]

## interactive mode
tr abcdefghijklmnopqrstuvwxyz ABCDEFGHIJKLMNOPQRSTUVWXYZ
tr [:lower:] [:upper:]
tr a-z A-Z

## pipe mode
tr '{}' '()' < inputfile > outputfile
echo  -e "This\t is for or testing" | tr [:space:] | wc -l
echo "my number is 19890806" | tr -d [:digit:]
echo "my number is 19890806" | tr -cd [:digit:]
echo $PATH | tr ":" "\n"
```
