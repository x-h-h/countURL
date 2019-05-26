# -*- coding:utf-8 -*-
#将大文件分割成小文件
#这里的分割文件做的是边读边写的操作，对test1每读一个字符，就写入一个字符。
# 用word记录文件的大小，达到一定限制后取后面一个URL作为文件的结束
#每个文件大小是10000字节左右

f = open("test1.txt", 'r', True)
n = 1
while True:
    f1 = open(str(n)+".txt",'w+')
    word = ""
    ch2 = f.read(1)
    if not ch2:
        break
    f1.write(ch2)
    while(1):
        ch = f.read(1)
        f1.write(ch)
        word = word + ch
        if len(word)>10000 and ch == " ":
            n = n + 1
            break
        if not ch:
            break
    #print(ch)
