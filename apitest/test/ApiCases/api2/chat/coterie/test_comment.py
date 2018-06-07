#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/23 0023 下午 1:56
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_SendComment(self):
        '''工作圈评论
           平台应用场景：APP工作圈评论
           帖子内容：今天早点回家
        '''
        values={
            'replyUser':'',
            'commentId':'',
            'content':666,
            'postId':'2',
            'userId':'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/comment/sendcomment',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈评论')  # 断言(检查返回值status是否为200)
        self.assertEqual('评论成功', sendrequest.json()['msg'], msg='【response】工作圈评论')


    def test_DeleteComment(self):
        '''工作圈删除评论
           平台应用场景：APP工作圈评论
           帖子内容：今天早点回家
        '''
        values={
            'commentId':2,
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/comment/deletecomment',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈删除评论')  # 断言(检查返回值status是否为200)
        self.assertEqual('删除成功', sendrequest.json()['msg'], msg='【response】工作圈删除评论')

    def test_SendComment_case01(self):
        '''工作圈回复评论
           平台应用场景：APP工作圈评论
           帖子内容：今天星期四
           回复人:张宗超
        '''
        values = {
            'replyUser':'Uzzc',
            'commentId': 2,
            'content':'get',
            'postId':'4',
            'userId':'Uwcm'
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/coterie/comment/sendcomment', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】工作圈删除评论')  # 断言(检查返回值status是否为200)
        self.assertEqual('评论成功', sendrequest.json()['msg'], msg='【response】工作圈删除评论')

