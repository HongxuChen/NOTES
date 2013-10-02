#!/usr/bin/python

import urllib
import sys


def extractURLFromGoogle(urlStr):
    base, query = urllib.splitquery(urlStr)
    parameters = query.split('&')
    keyValue = [urllib.splitvalue(p) for p in parameters]
    url = urllib.unquote_plus(dict(keyValue)['url'])
    return url

if __name__ == '__main__':
    if len(sys.argv) < 2:
        sys.stderr.write('Usage:\n%s URL1[, URL2, ...]\n' % sys.argv[0])
        sys.exit(1)

    for urlStr in sys.argv[1:]:
        print extractURLFromGoogle(urlStr)
    sys.exit(0)