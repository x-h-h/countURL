# -*- coding:utf-8 -*-

#生成随机的URL供测试用，数据格式为URL+5-20位数字，生成的文件名为test1.txt
from xeger import Xeger
_x = Xeger()
#num = 300
for i in range(100000):#生成100000条URL
   testStr = _x.xeger(r'URL^[0-9]{5,20}$')
   f = open('./test1.txt', 'a')
   f.write(testStr + ' ')
   #print(testStr)
   i += 1
