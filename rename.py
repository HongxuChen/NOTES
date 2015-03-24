#!/usr/bin/env python

from __future__ import print_function
import os
import sys

if len(sys.argv) < 2:
    rootdir = os.curdir
else:
    rootdir=sys.argv[1]
for root, dirs, files in os.walk(rootdir):
    if '.git' in root:
        continue
    for f in files:
        new_f = f.replace('-', '_')
        abs_f = os.path.join(root, f)
        abs_new_f = os.path.join(root, new_f)
        os.rename(abs_f, abs_new_f)
