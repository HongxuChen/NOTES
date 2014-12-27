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
