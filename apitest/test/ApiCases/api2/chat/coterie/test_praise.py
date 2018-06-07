#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/24 0024 上午 11:09
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_SendPraise(self):
        '''工作圈点赞
           平台应用场景：工作圈点赞
           帖子名称：今天早点回家
        '''
        values={
            'postId':'2',
            'userId':'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/praise/sendpraise',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈点赞')  # 断言(检查返回值status是否为200)
        self.assertEqual('点赞成功', sendrequest.json()['msg'], msg='【response】工作圈点赞')  # 断言(检查返回值status是否为200)



    def test_DeletePraise(self):
        '''工作圈取消点赞
           平台应用场景：工作圈取消点赞
           帖子名称：今天早点回家
        '''
        values={
            'postId':'2',
            'userId':'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/praise/deletepraise',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈取消点赞')  # 断言(检查返回值status是否为200)
        self.assertEqual('取消点赞', sendrequest.json()['msg'], msg='【response】工作圈取消点赞')  # 断言(检查返回值status是否为200)

