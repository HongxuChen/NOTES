###wget
```bash
wget -r -np -nd --accept=iso http://example.com/centos-5/i386/    #recursively,don't traverse parent dir,don't re-construct locally,only accept iso files
wget -i filename.txt                         #get urls from filename.txt
wget -c http://example.com/really-big-file.iso  #Continue getting a partially-downloaded file
wget -m -k (-H) http://www.example.com/      #mirror a site
```