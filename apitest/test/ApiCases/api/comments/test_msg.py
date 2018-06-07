#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/11 0011 下午 7:59
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''通过应用ID获取评论消息
           应用访问地址：/app/!/workflow/GongZuoXieTong
           主要字段为：
           平台应用场景：点击某条流程数据获取评论消息
        '''
        values={
            'appId':'workflow_GongZuoXieTong_instance_12'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/comments/msg/',params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】通过应用ID获取评论消息')  # 断言(检查返回值status是否为200)


    def test_actionPOST_case01(self):
        '''发出评论消息(无权限，不抄送)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           主要字段为：
           平台应用场景：评论时@没有权限查看流程的用户，选择不抄送
        '''
        values={
            'appId':'workflow_GongZuoXieTong_instance_83',
            'msg':'@[王三明](at:Uzongjingli)(type:member) 你好啦啦啦',
            'ccMsg':''
        }
        json='@[王三明](at:Uzongjingli)(type:member) 你好啦啦啦'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/comments/msg/',params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】发出评论消息(无权限，不抄送)')  # 断言(检查返回值status是否为200)
        self.assertEqual(json,sendrequest.json()['result']['msg'],msg='【response】发出评论消息(无权限，不抄送)')

    def test_actionPOST_case02(self):
        '''发出评论消息(无权限，抄送)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           主要字段为：测试组必备技能
           平台应用场景：评论时@没有权限查看流程的用户，选择抄送
        '''
        values={
            'appId':'workflow_GongZuoXieTong_instance_12',
            'msg':'@[王三明](at:Uzongjingli)(type:member) hello',
            'ccUsers':'[{"id":"Uzongjingli","name":"王三明","type":"member"}]',
            'ccMsg':'@[王三明](at:Uzongjingli)(type:member) hello'
        }
        json='@[王三明](at:Uzongjingli)(type:member) hello'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/comments/msg/',params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】发出评论消息(无权限，抄送)')  # 断言(检查返回值status是否为200)
        self.assertEqual(json,sendrequest.json()['result']['msg'],msg='【response】发出评论消息(无权限，抄送)')

    def test_actionDELETE(self):
        '''删除的评论消息(这里指标记已读)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           主要字段为：测试组必备技能
           平台应用场景：查看流程评论消息并标记为已读
        '''

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api/comments/msg/workflow_GongZuoXieTong_instance_12')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】删除的评论消息(这里指标记已读)')  # 断言(检查返回值status是否为200)
