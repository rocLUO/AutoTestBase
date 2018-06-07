#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/24 0024 上午 10:51
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_GetPosts(self):
        '''获取帖子列表
           平台应用场景：工作圈获取帖子列表
        '''
        values={
            'postId':'',
            'userId':'',
            'perpage':10,
            'start':0
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/posts/getposts',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】获取帖子列表')  # 断言(检查返回值status是否为200)
        self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】获取帖子列表')  # 断言(检查返回值status是否为200)



    def test_SendPost_case01(self):
        '''工作圈发帖
           平台应用场景：工作圈发帖
        '''
        values={
            'content':'{"userId":"Uwcm","content":"testing","status":"0","location":"","linkUrl":"","linkTitle":""}'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/posts/sendpost',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈发帖')  # 断言(检查返回值status是否为200)
        self.assertEqual('发送成功', sendrequest.json()['msg'], msg='【response】工作圈发帖')  # 断言(检查返回值response)
        self.assertEqual('testing', sendrequest.json()['result']['content'], msg='【response】工作圈发帖')  # 断言(检查返回值内容)



    def test_SendPost_case02(self):
        '''工作圈删除帖子
           平台应用场景：工作圈删除帖子
        '''
        params={
            'postId':7
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/coterie/posts/deletepost',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈删除帖子')  # 断言(检查返回值status是否为200)
        self.assertEqual('删除成功', sendrequest.json()['msg'], msg='【response】工作圈删除帖子')  # 断言(检查返回值response)


