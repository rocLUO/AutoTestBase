#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/13 0013 下午 3:32
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPost(self):
        '''dataflow数据共享
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow数据共享
        '''
        values={
            'records[]':3,
            'appId':'DFMoRenPeiZhiHanCong',
            'ruleinfo':'[{"blacklist":{"member_UIDdulei":{}},"fields":[],"right":"1|0","sharers":"member_UIDdulei"}]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/datacenter/share/dfmaindefault',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow数据共享')  # 断言(检查返回值status是否为200)
        self.assertEqual('共享成功', sendrequest.json()['result'], msg='【response】dataflow数据共享')  # 断言(检查返回值status是否为200)


    def test_actionDelete(self):
        '''dataflow数据共享--删除
           应用访问地址：/app/!/information/DFShuJuYuanBiao
           删除共享主要字段名称：测试9990
           操作方式：勾选数据———>点击共享按钮————>点击删除
           平台应用场景：dataflow数据共享--删除
        '''
        values={
            'appId':'DFShuJuYuanBiao',
       }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api/datacenter/share/dfshujuyuanbiao/9990',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow数据共享--删除')  # 断言(检查返回值status是否为200)