#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 10:00
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取流程调试器信息
           应用访问地址：/workflow/auto/#!/GongZuoXieTong/1
           平台应用场景：流程调试器
        '''
        params = {
            'action': 'define',
            'id': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/auto/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程调试器信息')

    def test_actionGET_case01(self):
        '''流程调试器查看执行日志
           应用访问地址：/workflow/auto/#!/GongZuoXieTong/1
           平台应用场景：流程调试器
        '''
        params = {
            'action': 'log'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/auto/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程调试器信息')

    def test_actionPOST(self):
        '''流程调试器执行用例(主表必填验证未通过)
           应用访问地址：/workflow/auto/#!/CongBiaoYinQiXiaYiBu/19
           平台应用场景：流程调试器
           发起人：杜磊——>赋值：表单填写填入wfzxrsub的选择人：张宗超，断言：审批的执行人：张宗超
        '''
        values = {
            'postData[name]': 'CongBiaoYinQiXiaYiBu',
            'postData[executor][0][id]': 'UIDdulei',
            'postData[executor][0][parent_id]': 7,
            'postData[executor][0][type]': 'member',
            'postData[executor][0][checked]': 'true',
            'postData[executor][0][groupBelong]': 'contacts',
            'postData[executor][0][name]': '产品测试组 - 组员 - 杜磊',
            'postData[executor][0][checkedOrder]': 1,
            'postData[executor][0][Parent]': 7,
            'postData[executor][0][parent]': 7,
            'postData[executor][0][Type]': 'member',
            'postData[conditions][0][node]': 'WorkNode_1',
            'postData[conditions][0][tableId]': 'wfzxrsub',
            'postData[conditions][0][fieldId]': 'xuanzeren',
            'postData[conditions][0][condition]': '张宗超',
            'postData[isDelete]': 'true',
            'postData[resultNode]': 'WorkNode_2',
            'postData[resultExecutor][0][id]': 'Uzzc',
            'postData[resultExecutor][0][parent_id]': 7,
            'postData[resultExecutor][0][type]': 'member',
            'postData[resultExecutor][0][checked]': 'true',
            'postData[resultExecutor][0][groupBelong]': 'contacts',
            'postData[resultExecutor][0][name]': '产品测试组 - 组员 - 张宗超',
            'postData[resultExecutor][0][checkedOrder]': 1,
            'postData[resultExecutor][0][Parent]': 7,
            'postData[resultExecutor][0][parent]': 7,
            'postData[resultExecutor][0][Type]': 'member',
            'postData[id]': 19
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/auto/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(500, sendrequest.json()['status'], msg='【status】流程调试器执行用例(必填验证未通过)')
        self.assertEqual([], sendrequest.json()['result'], msg='【response】流程调试器执行用例(必填验证未通过)')


    def test_actionPOST_case01(self):
        '''流程调试器执行用例(主表必填验证通过)
           应用访问地址：/workflow/auto/#!/CongBiaoYinQiXiaYiBu/19
           平台应用场景：流程调试器
           发起人：杜磊——>赋值：表单填写填入wfzxrmain的选择人：张宗超，断言：审批的执行人：张宗超
        '''
        values = {
            'postData[name]': 'CongBiaoYinQiXiaYiBu',
            'postData[executor][0][id]': 'UIDdulei',
            'postData[executor][0][parent_id]': 7,
            'postData[executor][0][type]': 'member',
            'postData[executor][0][checked]': 'true',
            'postData[executor][0][groupBelong]': 'contacts',
            'postData[executor][0][name]': '产品测试组 - 组员 - 杜磊',
            'postData[executor][0][checkedOrder]': 1,
            'postData[executor][0][Parent]': 7,
            'postData[executor][0][parent]': 7,
            'postData[executor][0][Type]': 'member',
            'postData[conditions][0][node]': 'WorkNode_1',
            'postData[conditions][0][tableId]': 'wfzxrmain',
            'postData[conditions][0][fieldId]': 'ceshi',
            'postData[conditions][0][condition]': '张宗超',
            'postData[isDelete]': 'true',
            'postData[resultNode]': 'WorkNode_2',
            'postData[resultExecutor][0][id]': 'Uzzc',
            'postData[resultExecutor][0][parent_id]': 7,
            'postData[resultExecutor][0][type]': 'member',
            'postData[resultExecutor][0][checked]': 'true',
            'postData[resultExecutor][0][groupBelong]': 'contacts',
            'postData[resultExecutor][0][name]': '产品测试组 - 组员 - 张宗超',
            'postData[resultExecutor][0][checkedOrder]': 2,
            'postData[resultExecutor][0][Parent]': 7,
            'postData[resultExecutor][0][parent]': 7,
            'postData[resultExecutor][0][Type]': 'member',
            'postData[id]': 19
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/auto/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程调试器执行用例(必填验证通过)')
