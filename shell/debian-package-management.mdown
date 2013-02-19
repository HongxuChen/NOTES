```bash
apt-cache pkgnames indent    #apt-cache search indent | awk '{if($1~/^indent$/) print $0}'
dpkg --get-selections > install.list
dpkg --set-selections <install.list   
apt-get dselect-upgrade 
apt-get source $package_name --download-only  #--compile
apt-get --ignore-hold --allow-unauthenticated -s dist-upgrade | grep ^Inst | cut -d ' ' -f2 | sort #list upgrade-able packages
```