#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 上午 11:02
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionDelete(self):
        '''清除主表数据提醒
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：清除主表数据提醒（点击查看数据时触发）
           main_字符串：袁凤
        '''
        values = {
            'appId': 'DFMoRenPeiZhiHanCong'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api2/dataflow/remind/dfmaindefault/6', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】清除主表数据提醒')
