package com.xingxi.netty;

/**
 * @author xingxi
 * @date 2019-03-01 17:08:52 星期五
 *
 * 第一个操作:
 * 新增的文件,IDEA自动加到了暂存区,再用sourceTree提交,sourceTree提交的时候,默认将暂存区的全部commit;
 * 默认将commit之后的推到远程仓库去了,
 * 添加但是不想提交的代码就直接上了远程仓库
 *
 * 应该的操作:push到远程仓库的时候用idea
 *
 *
 * 第二个操作
 * 从master分支拿下来的分支,想合到测试分支20190301-DEV.
 * 发现合不上去,本地idea是我自己的分支,将远程20190301-dev分支合到自己的上面了,自己的分支就被污染了.
 * 不知道怎么回退这个merge的操作
 *
 * 应该的操作: 本地idea打开20190301-dev分支,将远程的我自己的分支合过来,然后提交20190301到远程,再打包
 *
 * 第三个操作
 * 想把.gitignore创建后不生效
 * git rm -r --cache . #当前目录下的缓存删除 之前绿色的文件都变成红色的了
 * git add . #将当前目录下的文件加入到暂存区.被过滤掉的文件就不会再git status中显示了
 *
 */
public class Netty2 {


    public static void main(String[] args) {

    }
}
