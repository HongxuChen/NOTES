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