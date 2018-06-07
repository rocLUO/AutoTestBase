#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/28 0028 下午 3:56
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_deletegroup(self):
        '''个人设置——删除用户组
           角色组名为：删除用户组
        '''
        values = {'group[0][groupId]': 3}  # 删除用户组请求所需参数
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api/user/group', data=values)  # 删除用户组请求
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect = '1'  # 期望返回值
        actual = sendrequest.text  # 实际返回值
        self.assertEqual(expect, actual, msg='个人设置——删除用户组')  # 断言

    def test_actionGet(self):
        '''获取角色组
           应用访问地址：/user/setting#!/group/
           平台应用场景：个人设置——>角色组编辑——>选择一条记录点击编辑获取
        '''
        params = {'id': 1}
        json = '"name":"产品测试组-组员-张宗超"'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/group', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertIn(json, sendrequest.text, msg='【response】获取角色组')  # assertIn字符串之间包含比较

    def test_actionPost(self):
        '''添加角色组
           应用访问地址：/user/setting#!/group/
           角色组名称：小组十号
           平台应用场景：个人设置——>角色组编辑
        '''
        values = {
            'group': '[{"userGroupName":"小组十号","to_user_id":{"list":[{"id":"Uzzc","parent_id":7,"type":"member",'
                     '"checked":true,"groupBelong":false,"name":"产品测试组-组员-张宗超","checkedOrder":1,'
                     '"Parent":7,"parent":7,"Type":"member"},{"id":"UIDdulei","parent_id":7,"type":"member",'
                     '"checked":true,"groupBelong":false,"name":"产品测试组-组员-杜磊","checkedOrder":2,'
                     '"Parent":7,"parent":7,"Type":"member"},{"id": "Uzyw", "parent_id": 7, "type": "member", '
                     '"checked": true, "groupBelong": false,"name": "产品测试组-组员-张译文", "checkedOrder": 3, '
                     '"Parent": 7, "parent": 7, "Type": "member"}]},"isPublic": "FALSE"}]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/user/group', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)

    def test_group(self):
        '''获取角色组
           应用访问地址：/user/setting#!/group/
           平台应用场景：个人设置——>角色组编辑——>进入列表获取
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/group')  # 删除用户组请求
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
