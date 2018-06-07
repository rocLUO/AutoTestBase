#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 2:11
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPOST(self):
        '''流程存草稿
           应用访问地址：/app/!/workflow/WeiTuoYongLiYi
           平台应用场景：流程存草稿
        '''
        params1 = {
            'action': 'run',
            'workflowid': 'WeiTuoYongLiYi'
        }
        params2 = {
            'w_act': 'save',
            'node': 'WorkNode_1'
        }
        values = {
            'data': '{"wtmaincase01_weituoceshi":"测试啊","wtmaincase01_shenheren1":"",'
                    '"wtmaincase01_shenheneirong1":"","wtmaincase01_shenheren2":"",'
                    '"wtmaincase01_shenheneirong2":"","button":"save","send_user_cc":[],'
                    '"parameter":{"WeiTuoYongLiYi_WorkNode_2":{"AssignedTo":[],"AssignedMethods":"automatic"}}}',
            'operate': 'new'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest1 = nowlogin.get(Login().url + '/api2/workflow/permission', params=params1)
        instantid = sendrequest1.json()['result']['instantid']
        sendrequest = nowlogin.post(
            Login().url + '/api2/workflow/instance_node_exec/WeiTuoYongLiYi/' + str(instantid) + '/WorkNode_1/',
            params=params2, data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程存草稿')
