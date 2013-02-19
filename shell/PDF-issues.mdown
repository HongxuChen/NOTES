##Merge and split pdf:

1. `gs -dNOPAUSE -sDEVICE=pdfwrite -sOUTPUTFILE=combinedpdf.pdf -dBATCH 1.pdf 2.pdf 3.pdf``

1. Split large pdf into many one-page files: `pdftk largepdfile.pdf burst`; as the result you will get many small files like pg_0001.pdf, pg_0002.pdf and so on).

1. Merge files into one PDF file: `pdftk *.pdf cat output onelargepdfile.pdf`
