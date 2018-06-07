#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/29 0029 下午 5:16
# @Author  : Dulei
import json, os

path = os.path.abspath(os.curdir)


def isJson(jsonstr):
    try:
        json.loads(jsonstr.text)
        return True
    except:
        return False


def statusmsg(msg):
    return '【status】' + msg


def responsemsg(msg):
    return '【response】' + msg


def savehtml(file_name, contents):
    f = open(file_name, 'w', encoding="utf-8")
    f.write(contents)
    f.close()



def outputrequest(requestparams,casepath,casename):
    #输出请求方式、请求API、响应时长至报告中
    responsetext = requestparams.text
    method = str(requestparams.request)[17:-1]
    print(' 请求方式:', method, '\n', '请求API:', requestparams.url, '\n', '响应时长【毫秒】',
          requestparams.elapsed.microseconds / 1000)
    #输出API用例中请求至文件中
    apicaserequest=requestparams.url+''+ method
    splitpath = os.getcwd().split('\\')
    joinpath = '\\'.join(splitpath[0:splitpath.index('Requests')])  # 重组目录
    apicasefile = open(joinpath+r'\Requests\apitest\test\ApiSwagger\apicase.txt', 'w+')
    apicasefile.write(apicaserequest)
    apicasefile.close()

    #增加额外错误报告输出
    if 'handleError' in responsetext or 'Undefined index' in responsetext or 'not found' in responsetext or "'status': 500" in responsetext and isJson(
            jsonstr=responsetext):  # 判断返回值是否包含错误
        if path.split('\\')[-1]=='test':
            errorreportpath = path + r'\report\\'#所有用例运行时使用
        else:
            errorreportpath = r'D:\Pythonworkspace\Requests\apitest\test\report'#本地单用例运行接口崩溃时使用
        splitpath = casepath.split('\\')  # 分隔用例目录为数组
        joinpath = '.'.join(splitpath[splitpath.index('ApiCases') + 1:])  # 重组用例目录
        errorreportname = errorreportpath + '\\'+joinpath + '.' + casename + '.html'
        savehtml(errorreportname, requestparams.text)

    else:
        pass


