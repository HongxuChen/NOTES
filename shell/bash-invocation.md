# Bash Shell启动方式与rc脚本

## Shell的不同分类

根据启动Bash Shell的方式不同，对Shell有两种分类方式

### 登录Shell与非登录Shell

根据Shell的启动方式不同，可以将Shell分为

1. Login Shell
2. Non-login Shell

Login Shell的定义是，当前shell的`argv[0]`的第一个字符是`-`，或当前shell使用了`-l` ( `--login` ) 选项。

只要满足以上的两个条件的任意一个，bash就会表现得Login Shell一样。例如，以下列出的场景下，bash都是login shell：

1. 执行`bash -l -c 'w'` ( 使用了-l选项 )
2. 执行`su -l admin` ( 运行的Shell的`argv[0]`第一个字符是`-` )
3. 执行`login -f` ( 运行的Shell的`argv[0]`第一个字符是`-` )
4. 将当前目录加入到`$PATH`，根据以下命令创建到bash的链接并执行 ( 运行的Shell的`argv[0]`第一个字符是`-` )

```bash
export PATH=".:$PATH"
ln -s -- $(which bash) -bash   
-bash
```

### 交互与非交互Shell

同时，根据Shell启动参数的不同，还可以将Shell分为

1. Interactive Shell
2. Non-interactive Shell

Interactive Shell的定义很明确：`$-`环境变量中包含字符`i`的Shell就是Interactive Shell

以下场景中，bash属于Interactive Shell  

1. bash执行时没有加上非选项参数 [^noa] 
2. bash执行时没有加上`-c`选项
3. bash执行时，加上了`-i`选项

以下场景中，bash属于Non-interactive Shell

1. 使用`rsync -e ssh`同步文件（`-c`选项）
2. 其他基于ssh的文件传输，如git、svn等（基本都启用了`-c`选项）

## 不同Shell中启动时执行的文件

Bash启动时会按照一定的顺序载入rc文件，定义`PS1`、`JAVA_HOME`等环境变量，执行特定的脚本等。

按照两种Shell分类排列组合，一共有4种组合。各个组合下启动载入rc文件的顺序和数量有区别，以下分别列出：

### 登录/非交互Shell & 登录/交互Shell  

bash会依次执行以下文件

1. `/etc/profile` `[^sysconfdir]`
2. `~/.bash_profile`
3. `~/.bash_login`
4. `~/.profile`

### 非登录/非交互Shell

执行`$BASH_ENV`环境变量中指定的脚本

### 非登录/交互Shell

1. “全局”bashrc（编译时定义`SYS_BASHRC`，默认为`/etc/bash.bashrc`）
2. `~/.bashrc` [^exception_bashrc]