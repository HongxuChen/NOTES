Backup
======
Using deja-dup to backup the data; if simply copying files to other disk, be careful that NTFS doesn't preserve permission flags in EXT4 file system.

USB Installer
=============

## The Branches

Refer to <https://www.debian.org/devel/debian-installer/>

1. stable: Official release
1. testing: Current weekly snapshots
1. unstable: not used

## Desktop Environment
1. Gnome image(this should have better offical support for)
1. install LXDE with apt-get after the installation has accomplished

## How to burn the startup USB 

  ```bash
  dd if=<file> of=<device> bs=4M; sync
  ```

Dual Boot
================

1. (For UEFI BIOS)Turn on EFI on BIOS by pressing "F2"(or Fn+F2 for some BIOS settings); this can keep Windows and Debian boot within one grub
1. Make USB boot the first choice on BIOS
1. Disable security boot so there is a message like "cannot boot USB because one of your boot settings"

Installation
============

1. graphical install
1. language settings: English(to avoid indistinguishable code)
1. region: China/Singapore(to have time zone set correctly)
1. without LVM for personal usage
1. hostname: debian
1. Don't download any packages during installation(slow)

# Network config
================
After entering the desktop environment(gnome in this case) as a normal user, you are not supposed to be in the sudoers list, but as we need to customize the settings as the administrator, change to root by using "su" before setting "sudo".

1. Check whether the wireless is enabled(according to Debian Social Contract, this is typically disable).

  ```bash
  apt-get wireless-tools network-manager-gnome
  # to confirm that wlan0 is not enabled
  ifconfig wlan0
  iwconfig wlan0
  lspci | grep -i -E 'wlan0|wifi|wireless'
  ```
1. Install the firmware: <https://wiki.debian.org/Firmware>
1. Turn on wifi <https://wiki.debian.org/WiFi>

> kernel < 3.12 will not support "Intel Wireless N 7200"(which lenovo U430P is using)[fn: <http://forums.lenovo.com/t5/Linux-Discussion/Ideapad-U430p-and-Linux-issues-Solutions/td-p/1250431>]

Privileges
===========

1. add the normal user into sudo group:

  ```bash
  usermod -aG sudo <username>
  ```    

1. **sudo** without password

  ```bash
  export EDITOR=vi
  visudo
  -> %sudo   ALL=(ALL) NOPASSWD:ALL
  ```

> "sudo" setting does not take effect immediately; so a reboot/logout should be necessary.

Performance
===========
More swap percentage:

  ```bash
  vm.swappiness = 10 # add or change the value in /etc/sysctl.conf
  ```

Set Mirrors
===============

1. List Generator: <http://debgen.simplylinux.ch/>

1. For Singapore(other countries are similar, as long there are mirrors):

  ```bash
  # /etc/apt/sources.list
  deb http://mirror.0x.sg/debian/ jessie main contrib non-free
  deb-src http://mirror.0x.sg/debian/ jessie main contrib non-free
  
  deb http://ftp.debian.org/debian/ jessie-updates main contrib non-free
  deb-src http://ftp.debian.org/debian/ jessie-updates main contrib non-free
  
  deb http://security.debian.org/ jessie/updates main contrib non-free
  deb-src http://security.debian.org/ jessie/updates main contrib non-free
  
  deb http://dl.google.com/linux/chrome/deb/ stable main
  deb http://dl.google.com/linux/talkplugin/deb/ stable main
  
  deb http://www.deb-multimedia.org jessie main non-free
  ```

  ```bash
  sudo apt-get update
  sudo apt-get install git zsh tmux aptitude synaptic -y
  ```

Personal Customization
======================

1. dotfiles, clone from github repo

  ```bash
  # always without any browser running
  git clone git@github.com:HongxuChen/dotfiles.git && ./install.sh
  ```

1. change to zsh

  ```bash
  # DONT sudo it, that's for root's default shell!
  chsh -s /usr/bin/zsh
  ```

1. Right locales

  ```bash
  #make sure necessary locales are selected: en_US.UTF-8
  sudo dpkg-reconfigure locales
  sudo locale-gen zh_CN.UTF-8 zh_SG.UTF-8 en_SG.UTF-8
  ```

1. Install LXDE environment

  ```bash
  # kupfer is for command/file search, default keybing "Super+Space" should be changed
  sudo apt-get install --install-recommends lxde kupfer -y
  ```

   Logout and re-login to get the LXDE environment; press <kbd>Ctrl</kbd>+<kbd>Alt</kbd>+</kbd>T</kbd> to get tmux enabled "xterm" with zsh as the shell

1. Dual monitors

  ```bash
  sudo apt-get install arandr -y
  ## open and save as current settings to ~/.screenlayout/single.sh and ~/.screenlayout/dual.sh respectively
  ```

  Customize the shortcuts for them by editing ~/.config/openbox/lxde-rc.xml

  ```xml
  <keybind key="W-1">
    <action name="Execute">
      <command>sh ~/.screenlayout/single.sh</command>
    </action>
  </keybind>
  <keybind key="W-2">
    <action name="Execute">
      <command>sh ~/.screenlayout/dual.sh</command>
    </action>
  </keybind>
  ```

1. Dropbox, refer to [Dropbox for Linux Page](https://www.dropbox.com/install?os=lnx)

1. Add Printer(samba, hp)

  ```bash
  sudo apt-get install sambda cups hplip system-config-printer -y
  sudo service cups restart
  sudo service sambd restart
  system-config-printer
  # manually add the printer address if not found
  ```

1. ssh access

  ```bash
  sudo apt-get install openssh-server -y
  ```

1. manpages for library calls

  ```bash
  sudo apt-get install manpages-dev manpages-posix-dev -y
  ```

1. Editors:

  ```bash
  sudo apt-get install vim emacs24 debian-el -y
  # use vim to see whether anything goes wrong
  ```

Emacs
============

1.  start emacs to get plugins from ELPA

1.  rtags for C++

  ```bash
  cd dotfiles/_builds
  ./rtags.sh
  which rdm # rtags daemon
  # these 4 bin should be all inside ~/.bin
  which clang
  which clang++
  which gcc
  which g++
  ```

1.  doxymacs for C++

  ```bash
  cd dotfiles/_builds
  ./doxymacs.sh
  ```

1.  known issues
     1. ~/.emacs.d/config/init-linum.el will corrupt Emacs(presently disable it)

Python
======

  ```bash
  sudo apt-get install python-dev python3-dev python-pip python3-pip -y
  ```

ruby
====

  ```bash
  sudo apt-get install ruby ruby-dev nodejs -y # (for jekyll)
  sudo gem install jekyll rdiscount -y
  ```
