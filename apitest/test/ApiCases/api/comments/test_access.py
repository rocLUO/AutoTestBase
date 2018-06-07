#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/11 0011 下午 7:05
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPOST_case01(self):
        '''用于获取@的人 是否有权限查看对应的实例(无权限)
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           主要字段值为：从表已填
           平台应用场景：在流程评论时。有些流程所@的人没有查看权限
        '''
        values = {
            'appId': 'QuanZiDuanLiuCheng',
            'instanceId': 16,
            'msg': '@[杜磊](at:UIDdulei)(type:member) 你好'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/comments/access/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'],
                         msg='【status】用于获取@的人 是否有权限查看对应的实例(无权限)')  # 断言(检查返回值status是否为200)
        json = {'cannot': [{'name': '杜磊', 'userId': 'UIDdulei'}], 'can': []}
        self.assertEqual(json, sendrequest.json()['result'],
                         msg='【response】用于获取@的人 是否有权限查看对应的实例(无权限)')  # 断言(检查返回值response)

    def test_actionPOST_case02(self):
        '''用于获取@的人 是否有权限查看对应的实例(有权限)
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           主要字段值为：复制流程
           平台应用场景：在流程评论时。有些流程所@的人有查看权限
        '''
        values = {
            'appId': 'QuanZiDuanLiuCheng',
            'instanceId': 21,
            'msg': '@[王聪明](at:Uwcm)(type:member) 你好'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/comments/access/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'],
                         msg='【status】用于获取@的人 是否有权限查看对应的实例(有权限)')  # 断言(检查返回值status是否为200)
        json = {'cannot': [], 'can': [{'name': '王聪明', 'userId': 'Uwcm'}]}
        self.assertEqual(json, sendrequest.json()['result'],
                         msg='【response】用于获取@的人 是否有权限查看对应的实例(有权限)')  # 断言(检查返回值response)

    def test_actionPOST_case03(self):
        '''流程第一步节点提交@判断权限
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程第一步节点提交时文本@某人判断该用户是否有流程查看权限
        '''
        values1 = {
            'action': 'run',
            'workflowid': 'GongZuoXieTong',
        }  # 获取流程实例ID所需参数
        nowlogin = Login().login('admin')  # 登录系统
        permission = nowlogin.get(Login().url + '/api2/workflow/permission/', params=values1)
        instanceId = permission.json()['result']['instantid']
        value2 = {
            'appId': 'GongZuoXieTong',
            'instanceId': instanceId,
            'msg': '@[杜磊](at:UIDdulei)(type:member) at啦啦',
            'nextExecutors': {
                '0': {
                    '0': {
                        'id': 'Uwcm',
                        'parent_id': '4',
                        'type': 'member',
                        'checked': 'true',
                        'groupBelong': 'false',
                        'name': '云平台研发部-领导-王聪明',
                        'checkedOrder': '1',
                        'Parent': '4',
                        'parent': '4',
                        'Type': 'member'
                    }
                }
            }
        }  # 获取流程权限所需参数
        sendrequest = nowlogin.post(Login().url + '/api/comments/access/', data=value2)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'],
                         msg='【status】流程第一步节点提交@判断权限')  # 断言(检查返回值status是否为200)
        json = {'can': [{'name': '杜磊', 'userId': 'UIDdulei'}], 'cannot': []}
        self.assertEqual(json, sendrequest.json()['result'],
                         msg='【response】流程第一步节点提交@判断权限')  # 断言(检查返回值response)
