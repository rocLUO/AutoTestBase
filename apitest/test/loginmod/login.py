#! /usr/bin/env/python3
# coding=utf-8
import requests
import yaml,os,json

# 用requests库模拟登录启业云平台
if 'ApiCases' in os.getcwd():
    splitpath = os.getcwd().split('\\')
    joinpath = '\\'.join(splitpath[0:splitpath.index('Requests')])  # 重组目录
    env = open(joinpath+r'\Requests\apitest\test\config\environment.yaml', 'r')
else:
    env = open(os.getcwd() + '\config\environment.yaml', 'r')
getenv = yaml.load(env)
runenv = 'integration'


class Login():
    url = getenv.get(runenv)['config']['host']
    user = getenv.get(runenv)['config']['user']

    def login(self, name, url=url):
        self.name = name
        self.session = requests.session()
        r = self.session.get(url + "/api2/user/token", timeout=10)
        gettoken = r.json()['result']
        values = {'username': Login.user[name][0], 'password': Login.user[name][1], 'token': gettoken}
        self.session.post(url + '/api2/user/login', data=values, timeout=10)
        return self.session






