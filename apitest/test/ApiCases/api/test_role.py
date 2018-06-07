#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/23 0023 上午 11:21
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''角色权限获取(角色授权-角色权限)
           应用访问地址：/role/authorization
           平台应用场景：PaaS后台管理界面进入，权限引擎——>角色权限
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/role')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】角色权限获取(角色授权-角色权限)')  # 断言(检查返回值status是否为200)

    def test_actionPost(self):
        '''角色分级授权——用户授权
           应用访问地址：/role/authorization
           平台应用场景：权限引擎——>角色权限，给用户设置权限，保存提交
        '''
        values = {
            'id': 'undefined',
            'category': 'orgEdit',
            'depId': 2,
            'roles[0][id]': 'Uzongjingli',
            'roles[0][parent_id]': 3,
            'roles[0][type]': 'member',
            'roles[0][checked]': 'true',
            'roles[0][groupBelong]': 'contacts',
            'roles[0][name]': '总经理 - 王三明',
            'roles[0][checkedOrder]': 3,
            'roles[0][Parent]': 3,
            'roles[0][parent]': 3,
            'roles[0][Type]': 'member'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/role', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】角色分级授权——用户授权')  # 断言(检查返回值status是否为200)
        self.assertEqual('保存成功!', sendrequest.json()['msg'], msg='【response】角色分级授权——用户授权')

    def test_actionGet_case01(self):
        '''角色分级授权——用户有权限查看组织架构
           应用访问地址：/role/authorization
           平台应用场景：权限引擎——>角色权限，给用户设置权限后，有权限的用户应该可以访问组织架构
        '''
        params = {
            'operation': 'orgEdit'
        }
        nowlogin = Login().login('zzc')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/role/isRoleAuthorization', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】角色分级授权——用户有权限查看组织架构')  # 断言(检查返回值status是否为200)
        self.assertEqual('true', sendrequest.json()['result'], msg='【response】角色分级授权——用户有权限查看组织架构')

    def test_actionGet_case02(self):
        '''角色分级授权——用户有无权限查看组织架构
           应用访问地址：/role/authorization
           平台应用场景：权限引擎——>角色权限，没有给用户设置权限，无权限的用户应该不可以访问组织架构
        '''
        params = {
            'operation': 'orgEdit'
        }
        nowlogin = Login().login('yrr')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/role/isRoleAuthorization', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(400, sendrequest.json()['status'], msg='【status】角色分级授权——用户有权限查看组织架构')  # 断言(检查返回值status是否为200)
        self.assertEqual('false', sendrequest.json()['result'], msg='【response】角色分级授权——用户有权限查看组织架构')
