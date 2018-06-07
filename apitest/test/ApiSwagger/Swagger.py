#! /usr/bin/env/python3
# coding=utf-8
import requests
import re


def replacestr(modulestring):
    return modulestring.replace("' target='_blank'", '')


def removeparams(apiurl):
    reparams = r'\{[a-z]+\}'
    removedparamsurl = re.findall(reparams, apiurl)
    return str(removedparamsurl).replace(reparams, '')

class Swaggerapi():
    '''
    获取swagger 文档中所有API
    '''
    url = 'http://www.feature.apiaccess.aysaas.com:55555/api/doc/swagger/v2/auth'
    getswaggerres = requests.get(url)
    # 获取所有的模块
    getallapimodule = getswaggerres.json()['info']['description']
    MODULE = r"http:.*'"
    remodule = re.findall(MODULE, getallapimodule)

    mapresult = list(map(replacestr, remodule))  # API模块请求地址
    #print('API模块请求地址：', mapresult)
    print('Swagger API模块总数：', len(mapresult))

    f1 = open('hasmethodapi.txt', 'w+')
    f2 = open('nomethodapi.txt', 'w+')
    for getapi in mapresult:
        getswagger = requests.get(getapi)
        apipath = getswagger.json()['paths']
        listapipath = list(apipath)  # 模块下的API
        # print('当前API模块：', getapi)
        for apilist in listapipath:
            if '{' in apilist:#过滤接口请求中{}包含的参数
                apimethod = getswagger.json()['paths'][apilist]
                apilist = apilist[0:str(apilist).index('{') - 1]#截取请求
                listapimethod = list(apimethod)  # 请求方式
                for method in listapimethod:
                    hasmethod = apilist + ' ' + method
                    # print(apilist, method)
                    f1.write(hasmethod + '\n')  # 带请求方式输出的API
                f2.write(apilist + '\n')  # 不带请求方式输出的API
            elif '/'==str(apilist)[-1]:#过滤API以/结尾的API
                apimethod = getswagger.json()['paths'][apilist]
                apilist = str(apilist).rstrip('/')
                listapimethod = list(apimethod)  # 请求方式
                for method in listapimethod:
                    hasmethod = apilist + ' ' + method
                    f1.write(hasmethod + '\n')  # 带请求方式输出的API
                f2.write(apilist + '\n')  # 不带请求方式输出的API
            else:
                apimethod = getswagger.json()['paths'][apilist]
                listapimethod = list(apimethod)  # 请求方式
                for method in listapimethod:
                    hasmethod = apilist + ' ' + method
                    f1.write(hasmethod + '\n')  # 带请求方式输出的API
                f2.write(apilist + '\n')  # 不带请求方式输出的API

    f1.close()
    f2.close()

    with open('hasmethodapi.txt') as  f01:
        lines = f01.readlines()
        print('Swagger文档输出的API数:', len(lines))#带请求方式

    with open('nomethodapi.txt') as  f02:
        lines = f02.readlines()
        #print('Swagger文档不带请求方式输出的API数:', len(lines))
