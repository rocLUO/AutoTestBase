#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/6/4 0004 下午 5:19
# @Author  : Dulei
import requests, re


def replacespace(modulestring):
    return modulestring.replace(r".cn", '')

class Qycloudapi():
    url = 'https://www.qycloud.com.cn'
    session = requests.session()
    r = session.get(url + "/api2/user/token", timeout=10)
    gettoken = r.json()['result']
    values = {'username': 'admin_pretest', 'password': '11111111', 'token': gettoken}
    session.post(url + '/api2/user/login', data=values, timeout=10)
    get_api = session.get('https://www.qycloud.com.cn/api2/tool/api/list?downloadList')
    f3 = open('allapi.txt', 'w+')
    f4 = open('qycloudallapi.txt', 'w+')
    f3.write(get_api.text)
    f3.close()
    REGAPI = r'.cn/[a-z0-9_/]+'
    with open('allapi.txt') as  f03:
        lines = f03.readlines()
        allapilist = lines[1:]
        for n in range(0, len(allapilist)):
            splitapi = allapilist[n].split(',')
            remodule = re.findall(REGAPI, splitapi[1])
            newapi = list(map(replacespace, remodule))
            for strnewapi in newapi:
                apimethod = splitapi[0]  # 字符串类型API方法
                if apimethod != 'custom':  # 过滤请求方式为custom类型的接口
                    apiandmethod = strnewapi + ' ' + apimethod
                    f4.write(apiandmethod + '\n')
                else:
                    pass
    f4.close()
    with open('qycloudallapi.txt') as  f04:
        lines = f04.readlines()
        print('平台输出的API数(过滤custom请求方式API):', len(lines))#带请求方式
