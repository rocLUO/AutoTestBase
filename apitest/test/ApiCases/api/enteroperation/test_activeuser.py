#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/17 0017 下午 8:39
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''企业运营概况——人员概况——统计方式：组织架构实时获取在线人员
           应用访问地址：/companyinfo/index
           平台应用场景：企业运营概况——>人员概况——>统计方式：组织架构实时获取在线人员
        '''
        params={
            'params[page][start]':1,
            'params[page][perPage]':15,
            'params[method]':'org',
            'params[value]':1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/enteroperation/activeuser',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】企业运营概况——人员概况——统计方式：组织架构实时获取在线人员')  # 断言(检查返回值status是否为200)
        self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】企业运营概况——人员概况——统计方式：组织架构实时获取在线人员')  # 断言(检查返回值response)
