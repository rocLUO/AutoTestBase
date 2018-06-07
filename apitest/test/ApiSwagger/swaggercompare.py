#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/6/4 0004 下午 5:19
# @Author  : Dulei
import Apitool
import Swagger

swaggeradd = open('swaggeradd.txt', 'w+')
swaggerdel = open('swaggerdel.txt', 'w+')
with open('hasmethodapi.txt') as swapi:
    swaggerlist = swapi.readlines()
    swaggerlist = sorted(swaggerlist)

with open('qycloudallapi.txt') as qyapi:
    qycloudlist = qyapi.readlines()
    qycloudlist = sorted(qycloudlist)

swaggerhasapi = []  # 已补Swagger文档的API
for swaggerapi in swaggerlist:  # 判断swagger中API是否在平台所有API中
    for qycloudapi in qycloudlist:
        if swaggerapi == qycloudapi:
            swaggerhasapi.extend([qycloudapi])
print('已补Swagger文档API数:', len(swaggerhasapi))
swaggerlackapi = list(set(qycloudlist) - set(swaggerhasapi))  # 未补充Swagger文档的API
print('未补充Swagger文档API数：', len(swaggerlackapi))
for needadd in swaggerlackapi:
    swaggeradd.write(needadd)  # 需要补充swagger文档的API写入文件
swaggeradd.close()

swaggerapidelete = list(set(swaggerlist) - set(swaggerhasapi))  # swagger文档中的API平台已不存在，需要调整swagger文档
print('Swagger文档中API平台不存在数：', len(swaggerapidelete))
for needdel in swaggerapidelete:
    swaggerdel.write(needdel)  # 需要修改swagger文档的API写入文件
swaggerdel.close()
