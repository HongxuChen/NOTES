##lftp
```
config files    global: `/etc/lftp`; user's: `~/.lftprc` or `~/.lftp/rc`  
login           `lftp user:password@site:port` `lftp site -p port -u user,password`  
Make bookmarks  echo 'uftp ftp://user:passwd@ftp.ubuntu.org.cn' >> ~/.lftp/bookmarks  
```
###interactive mode
```bash
mirror -R       #put fold directories recursively to remote
local cmd       begin with !(`lcd `,`lpwd`)   
transfer files  `mirror`,`mput`,`mget`  
bookmark        `add`,`list`  
```
settings:

```
set ftp:charset gbk
set file:charset utf8
set pget:default-n 10           #(default 5)
```
references: <http://ihavanna.org/linux/225>
