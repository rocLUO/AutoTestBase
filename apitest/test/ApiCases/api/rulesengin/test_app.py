#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/20 0020 上午 9:15
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''规则引擎列表获取
           应用访问地址：/rulesengine#!/category/1
           目录：固定资产库管理
           平台应用场景：进入规则引擎配置页面，获取列表
        '''
        params = {
            'start': 0,
            'perPage': 15,
            'parent_id[]': 1,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/rulesengin/app/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual('0', sendrequest.json()['iTotalDisplayRecords'],
                            msg='【response】规则引擎列表获取')  # 断言(检查返回值response)

    def test_actionCopyRule(self):
        '''规则引擎复制
           应用访问地址：/rulesengine#!/category/0
           规则名称：dataflow添加触发消息提醒
           平台应用场景：规则引擎复制
        '''
        values = {
            'id': 6,
            'name': 'copy rule',
            'description': 'this is my description',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/rulesengin/app/copyrule', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('复制成功', sendrequest.json()['result'], msg='【response】规则引擎列表获取')  # 断言(检查返回值response)
