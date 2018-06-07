#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 6:45
# @Author  : Dulei
temp='''<html>
<head><title>%(title)s</title></head>
<body>
<h1>%(title)s</h1>
<p>%(text)s</p>
</body>
</html>
'''
data={'title':'My Home Page','text':'Welcome to my home page'}
print(temp % data)
print(type(data))