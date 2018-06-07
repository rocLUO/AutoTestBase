#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/29 0029 下午 1:33
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_instance_oprate_post(self):
        '''web流程——委托
           应用访问地址：/app/!/workflow/WeiTuoYongLiYi
           工作标题：提交给杜磊，由杜磊委托给王聪明，再由王聪明接受委托，然后委托给王三明
           平台应用场景：委托，A委托给B，B接受，又委托给C
        '''
        values = {'action': 'doCommissioned',
                  'assigned': '[{"checked":true,"id":"Uzongjingli","type":"member","name":"总经理-王三明","parent_id":3}]',
                  'message': '',
                  'workflowid': 'WeiTuoYongLiYi',
                  'instantid': 10087,
                  'nodeid': 'WorkNode_2'
                  }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_oprate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect = 200  # 期望返回值
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        actual = sendrequest.json()['status']  # 实际返回值
        self.assertEqual(expect, actual, msg='【web】流程委托——A委托给B，B接受，又委托给C')  # 断言

    def test_interrupt(self):
        '''流程中断
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：用于流程中断
           平台应用场景：流程中断
        '''
        values = {
            'action': 'interrupt',
            'workflowid': 'GongZuoXieTong',
            'instantid': 67,
            'message': '暂不处理',
            'nodeid[]': 'WorkNode_2'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_oprate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程中断')  # 断言

    def test_resume(self):
        '''流程恢复
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：测试恢复流程
           平台应用场景：流程恢复
        '''
        values = {
            'action': 'resume',
            'workflowid': 'GongZuoXieTong',
            'instantid': 22,
            'message': '现在可以处理了'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_oprate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程恢复')  # 断言

    def test_quhui(self):
        '''流程取回
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：测试流程取回
           平台应用场景：流程取回
        '''
        values = {
            'action': 'quhui',
            'workflowid': 'GongZuoXieTong',
            'instantid': 33,
            'nodeid': 'WorkNode_1'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_oprate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程取回')  # 断言

    def test_doCommissioned(self):
        '''流程委托
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：测试存草稿流程委托
           平台应用场景：流程委托
        '''
        values = {
            'action': 'doCommissioned',
            'assigned': '[{"checked": true, "id": "UIDdulei", "type": "member", "name": "产品测试组-组员-杜磊", "parent_id": 7}]',
            'message': '交给你了',
            'workflowid': 'GongZuoXieTong',
            'instantid': 34,
            'nodeid': 'WorkNode_1'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_oprate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程委托')  # 断言

    def test_cancelCommissioned(self):
        '''流程取消委托
           应用访问地址：/app/!/workflow/WeiTuoYongLiYi
           委托测试:取消委托测试
           平台应用场景：流程取消委托
        '''
        values = {
            'action': 'cancelCommissioned',
            'workflowid': 'WeiTuoYongLiYi',
            'instantid': 10084,
            'nodeid': 'WorkNode_2'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/instance_oprate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程取消委托')  # 断言
