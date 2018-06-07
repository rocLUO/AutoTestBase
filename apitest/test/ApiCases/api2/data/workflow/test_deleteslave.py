#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 上午 11:32
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_Delete(self):
        '''【APP】流程从表记录删除
           应用访问地址：/app/!/workflow/YiDongDuanZhuCong
           平台应用场景：APP流程从表记录删除
        '''
        params = {
            'workflowId': 'YiDongDuanZhuCong',
            'instanceId': 49,
            'nodeId': 'WorkNode_1',
            'slaveId': 'yidongduanzhucongco',
            'id': 3
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api2/data/workflow/deleteslave', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP流程从表记录删除')  # 断言(检查返回值status是否为200)
