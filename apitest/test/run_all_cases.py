#! /usr/bin/env/python3
# coding=utf-8

import unittest, sys, os
import zipfile, shutil, datetime

cmdmodulepath = os.path.dirname(os.path.dirname((os.path.abspath(os.curdir))))
sys.path.append(cmdmodulepath)  # 将apitest动态加入到环境变量中
from apitest.test.loginmod import login

# 将apicases模块动态加入到环境变量中--------------
path = os.path.abspath(os.curdir)  # 返回绝对路径

casepath = path + r'\ApiCases'  # 用例目录
sys.path.append(casepath)
# ----------------------------------------------



# 将HTMLTestReportCN模块动态加入到环境变量中--------------
reportpath = os.path.join(path + '\HtmlReportMod')

sys.path.append(reportpath)
import HTMLTestRunnerCN


# ------------------------------------------------------

def all_case():
    discover = unittest.defaultTestLoader.discover(casepath, top_level_dir=None)
    print('Running api cases count:', discover.countTestCases())
    print('Now running,please wait.....')
    return discover


if os.path.exists(path + r'\report\report.html'):
    pass
else:
    file = open(path + r'\report\report.html','w')

with open(path + r'\report\report.html', 'wb') as f:
    runner = HTMLTestRunnerCN.HTMLTestReportCN(
        stream=f,
        title='自动化测试报告',
        # description='详细测试用例结果',
        tester='杜磊'
    )
    print('Now running api environment:' + login.getenv.get(login.runenv)['config']['host'])
    runner.run(all_case())

env = login.getenv.get(login.runenv)['config']['host']

# 压缩报告
path = os.path.abspath(os.curdir)
yadir = path + r'\report'  # 压缩的文件所在的目录
Interceptenv = (env[7:-10])  # 截取请求地址
zipfilepath = Interceptenv + '.zip'
print('Report directory:' + r'D:\API_Feature_Report' + '\\' + Interceptenv + '.zip')  # 报告目录
filelists = os.listdir(yadir)  # 文件夹下的所有文件名
if filelists == None or len(filelists) < 1:
    print(">>>>>>待压缩的文件目录：" + yadir + " 里面不存在文件,无需压缩. <<<<<<")
else:
    z = zipfile.ZipFile(zipfilepath, 'w', zipfile.ZIP_DEFLATED)
    for fil in filelists:
        filefullpath = os.path.join(yadir, fil)
        # filefullpath是文件的全路径，fil是文件名，这样就不会带目录了
        z.write(filefullpath, fil)
    z.close()
if os.path.exists('D:\API_Feature_Report'):
    shutil.copy(Interceptenv + '.zip', 'D:\API_Feature_Report')
else:
    os.mkdir('D:\API_Feature_Report')
    shutil.copy(Interceptenv + '.zip', 'D:\API_Feature_Report')
