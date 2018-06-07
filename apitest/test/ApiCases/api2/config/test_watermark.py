#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/25 0025 上午 10:36
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''获取水印图片(未使用)
           应用访问地址：/config
           平台应用场景：管理员config——>水印设置
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/config/watermark/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取水印图片(未使用)')  # 断言(检查返回值status是否为200)
        self.assertEqual('qycloud.png', sendrequest.json()['result']['data'], msg='【response】获取水印图片(未使用)')

    def test_actionPost(self):
        '''使用当前水印图片
           应用访问地址：/config
           平台应用场景：管理员config——>水印设置
        '''
        values={
            'data[data]':'qycloud.png',
            'data[status]':'true'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/config/watermark/save',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】使用当前水印图片')  # 断言(检查返回值status是否为200)
        self.assertEqual('qycloud.png', sendrequest.json()['result']['data'], msg='【response】使用当前水印图片')


    def test_actionDelete(self):
        '''取消使用当前水印图片
           应用访问地址：/config
           平台应用场景：管理员config——>水印设置
        '''
        values={
            'data[data]':'qycloud.png',
            'data[status]':'false'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/config/watermark/save',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】取消使用当前水印图片')  # 断言(检查返回值status是否为200)
        self.assertEqual('qycloud.png', sendrequest.json()['result']['data'], msg='【response】取消使用当前水印图片')

