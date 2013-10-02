#-------------------------------------------------------------------------------
# Name:        module1
# Purpose:
#
# Author:      mami
#
# Created:     07/04/2012
# Copyright:   (c) mami 2012
# Licence:     <your licence>
#-------------------------------------------------------------------------------
#!/usr/bin/env python

import os
import itertools
import hashlib
import shutil

def file_hash(path):
    m = hashlib.md5()
    try:
        file = open(path, 'rb')
        m.update(file.read())
    except:
        return None
    return m.hexdigest()

def main():
    print("Populating walk")
    files = [[os.path.join(root, file)
             for file
             in files]
             for root, dirs, files
             in os.walk("c:")
             if not "users\\public" in root.lower() and not "programdata\\crashplan" in root.lower()]
    list = itertools.chain(*files)
    print("Generating hashes")
    hashes = {}
    for path in list:
        if not file_hash(path) is None:
            hashes[file_hash(path)] = path
            print(path)

    print("\n\n\n\n\n\n\n\n\n\n\n\nGoing over list")
    for root, dirs, files in os.walk("c:\\users\\public\\tmp"):
        for file in files:
            if(file_hash(os.path.join(root, file)) in hashes):
                print(os.path.join(root, file))

if __name__ == '__main__':
    main()