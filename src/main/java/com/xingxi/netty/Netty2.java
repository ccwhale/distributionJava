package com.xingxi.netty;

import lombok.extern.slf4j.Slf4j;

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
 * 第四个操作:
 * 两个分支合到master分支上会有冲突
 * 我想把另一个分支的功能合过来解决冲突
 *
 * 合并分支的时候有冲突: Git不会自动创建提交,没有冲突的文件在暂存区(to be commited)有冲突的文件在工作区
 * 问题:另一个分支的提交的记录(另一个作者commit的注释等等内容)是不是就不会合并到当前分支了
 *
 * 大佬说这样不行,一个分支一个内容,有问题的时候好通过分支去发现问题
 *
 * 然后:
 * 有冲突的文件在工作区: git checkout *
 * 没有冲突的文件在暂存区: git reset HEAD * (暂存区的文件重新回到工作区)
 * 工作区的文件撤销修改: git checkout -- *
 *
 * 已经commit的内容想回退:git reset --hard "HEAD^" 回退上上个版本(内容会丢失,只能从IDEA的localHistory中获取数据了)
 *
 *
 */
public class Netty2 {


    public static void main(String[] args) {

    }
}
