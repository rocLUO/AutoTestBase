#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/11 0011 下午 6:55
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionTop(self):
        '''常用应用Top5
           应用访问地址：/companyinfo/index
           平台应用场景：企业运营概况，常用应用Top5
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/app/usecount/top/5')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('操作成功', sendrequest.json()['msg'], msg='【web】常用应用Top5')  # 断言(检查返回值msg)


    def test_actionPost(self):
        '''应用使用统计
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：访问应用列表时会记录使用频率
        '''
        values={'appId':'GongZuoXieTong','appType':'workflow'}
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/app/usecount',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('操作成功', sendrequest.json()['msg'], msg='【web】应用使用统计')  # 断言(检查返回值msg)
