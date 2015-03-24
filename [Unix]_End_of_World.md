Reference: [关于Unix世界末日的调查报告](http://www.soimort.org//posts/129/index.html)

View _date_ on the end of the world:
```bash
date -ud @2147483648  #right for linux-64,fail on linux-64
```

```cpp
#include <curses.h>
#include <time.h>
#include <unistd.h>
int main()
{
    time_t current_time = 2147483637; //seconds before the end >_<
    char *c_time_string;
    initscr();
    while (!sleep(1)) {
        current_time++;
        c_time_string = ctime(&current_time);
        printw("Unix epoch:  %ld\n", current_time);
        printw("Date / time: %s", c_time_string);
        move(0, 0);
        refresh();
    }
    endwin();
    return 0;
}
```

The following is only available for 64bit Linux with `export TZ="UTC"`:

```bash
touch -m -t 208010171017.50 nonoob
touch -a -t 210602070628.16 nonoob
$ stat nonoob
  File: ‘nonoob’
  Size: 9           Blocks: 8          IO Block: 4096   regular file
Device: 809h/2057d  Inode: 4089151     Links: 1
Access: (0644/-rw-r--r--)  Uid: ( 1000/ soimort)   Gid: (  100/   users)
Access: 2106-02-07 06:28:16.000000000 +0000
Modify: 2080-10-17 10:17:50.000000000 +0000
Change: 2012-12-23 05:10:08.676071207 +0000
 Birth:
```

The result of `Sleuth Kit`(`sleuthkit` in Ubuntu):

```bash
$ sudo istat /dev/sda1 `ls -i hongxuchen |cut -d" " -f1`
inode: 699798
Allocated
Group: 85
Generation Id: 615696007
uid / gid: 1000 / 1000
mode: rrw-rw-r--
Flags:
size: 0
num of links: 1

Inode Times:
Accessed:	Thu Jan  1 00:00:00 1970
File Modified:	Thu Oct 17 10:17:50 2080
Inode Modified:	Tue Dec 25 05:17:03 2012

Direct Blocks:
```
And the result of `debugfs`:

```bash
$ echo "stat `pwd`/nonoob" |sudo debugfs /dev/sda1
Inode: 699798   Type: regular    Mode:  0664   Flags: 0x80000
Generation: 615696007    Version: 0x00000000:00000001
User:  1000   Group:  1000   Size: 0
File ACL: 0    Directory ACL: 0
Links: 1   Blockcount: 0
Fragment:  Address: 0    Number: 0    Size: 0
 ctime: 0x50d936cf:3eaba628 -- Tue Dec 25 13:17:03 2012
 atime: 0x00000000:00000001 -- Thu Jan  1 08:00:00 1970
 mtime: 0xd0669d4e:00000000 -- Thu Oct 17 18:17:50 2080
crtime: 0x50d934a4:9fb34274 -- Tue Dec 25 13:07:48 2012
Size of extra inode fields: 28
EXTENTS:
```
Be aware of the odd `1970`! Neither `debugfs` or `istat` is compatible with `ext4` perfectly.

```cpp
// some complements for *stat*
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    struct stat sb;

    if (argc != 2) {
        fprintf(stderr, "Usage: %s <pathname>\n", argv[0]);
        exit(EXIT_FAILURE);
    }

    if (stat(argv[1], &sb) == -1) {
        perror("stat");
        exit(EXIT_FAILURE);
    }

    printf("File type:                ");

    switch (sb.st_mode & S_IFMT) {
    case S_IFBLK:  printf("block device\n");            break;
    case S_IFCHR:  printf("character device\n");        break;
    case S_IFDIR:  printf("directory\n");               break;
    case S_IFIFO:  printf("FIFO/pipe\n");               break;
    case S_IFLNK:  printf("symlink\n");                 break;
    case S_IFREG:  printf("regular file\n");            break;
    case S_IFSOCK: printf("socket\n");                  break;
    default:       printf("unknown?\n");                break;
    }

    printf("I-node number:            %ld\n", (long) sb.st_ino);

    printf("Mode:                     %lo (octal)\n",
            (unsigned long) sb.st_mode);

    printf("Link count:               %ld\n", (long) sb.st_nlink);
    printf("Ownership:                UID=%ld   GID=%ld\n",
            (long) sb.st_uid, (long) sb.st_gid);

    printf("Preferred I/O block size: %ld bytes\n",
            (long) sb.st_blksize);
    printf("File size:                %lld bytes\n",
            (long long) sb.st_size);
    printf("Blocks allocated:         %lld\n",
            (long long) sb.st_blocks);

    printf("Last status change:       %s", ctime(&sb.st_ctime));
    printf("Last file access:         %s", ctime(&sb.st_atime));
    printf("Last file modification:   %s", ctime(&sb.st_mtime));

    exit(EXIT_SUCCESS);
}
```

