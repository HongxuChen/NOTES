CPPFLAGS=-Wall -W -pedantic -o0 -fprofile-arcs -ftest-coverage

xmpl: xmpl.cpp

gcov: xmpl
	./xmpl
	./xmpl xxx xxx
	./xmpl Hey\! xxx
	gcov xmpl

.PHONY: clean zip
clean:
	rm -f xmpl *.bb *.bbg *.gcov *.da gmon.out *.tar.gz *.gcda *.gcno
zip: README.org Makefile xmpl.cpp
	tar czvf gcov.tar.gz *
