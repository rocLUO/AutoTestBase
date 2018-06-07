#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 3:11
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPOST(self):
        '''流程批量抄送
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程勾选多条记录批量抄送
        '''
        values = {
            'type': 'CC',
            'assigned': '[{"checked": true, "id": "UIDdulei", "type": "member", "name": "产品测试组-组员-杜磊", "parent_id": 7}]',
            'message': '抄送测试',
            'records': '[{"nodeId": "", "instanceId": "80", "workflowId": "GongZuoXieTong"}]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_send_copy', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程批量抄送')
        self.assertEqual(True, sendrequest.json()['result']['allSuccess'], msg='【response】流程批量抄送')

    def test_actionPOST_case01(self):
        '''流程单条抄送
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程单条抄送
        '''
        values = {
            'type': 'CC',
            'assigned': '[{"checked":true,"id":"UIDdulei","type":"member","name":"产品测试组-组员-杜磊","parent_id":7}]',
            'message': '抄送测试',
            'workflowId': 'GongZuoXieTong',
            'instanceId': 82
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_send_copy', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程单条抄送')
