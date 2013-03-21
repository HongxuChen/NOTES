#include <locale.h>

#include "say.h"

int main(int argc, char *argv[])
{
// setlocale(LC_ALL, "zh_CN");
// bindtextdomain(PACKAGE,LOCALEDIR);
// textdomain(PACKAGE);
    say_hello();
    return 0;
}
