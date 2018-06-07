#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/18 0018 下午 3:57
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGroup(self):
        '''【普通用户】获取form配置（form配置页面）
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：获取form配置———dataflow(移动端进入列表)
        '''
        params={
            'app_id':'DFMoRenPeiZhiHanCong',
            'table_id':'dfmaindefault',
            'version':'0',
            'application':'information'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/form/form/group',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取form配置———dataflow(移动端)')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取form配置———dataflow(移动端)')