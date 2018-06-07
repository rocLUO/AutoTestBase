#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/12 0012 下午 7:30
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''主表数字相加--不满足条件不统计
           应用访问地址：/app/!/information/ShuZiTongJi
           平台应用场景：数字统计计算
           统计条件：新建dataflow，当姓名等于'杜磊'时统计A+B+C
        '''

        params = {
            'command': 'compute',
            'tableId': 'dfmainshuzitongji',
            'recordId': -1,
            'map[shuzia]': 1,
            'map[shuzib]': 2,
            'map[shuzic]': 3,
            'map[a127f]': '',
            'map[a2c6b]': '',
            'map[xingming]': '杜磊'
        }
        json = '6'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】主表数字相加--不满足条件不统计')  # 断言(检查返回值status是否为200)
        self.assertEqual(json, sendrequest.json()['result']['ajiabjiac'],
                         msg='【response】主表数字相加--不满足条件不统计')  # 断言(检查返回值response)

    def test_actionGET_case01(self):
        '''从表数字相加
           应用访问地址：/app/!/information/ShuZiTongJi
           平台应用场景：数字统计计算
           统计条件：新建dataflow，从表数字相加统计到主表字段中
        '''

        params = {
            'command': 'compute',
            'tableId': 'dfsubshuzitongji',
            'recordId': -1,
            'map[subshuzia]': 3,
            'map[subshuzib]': 4,
            'map[subshuzic]': 5,
        }
        json = '12'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】从表数字相加')  # 断言(检查返回值status是否为200)
        self.assertEqual(json, sendrequest.json()['result']['subajiabjiac'],
                         msg='【response】从表数字相加')  # 断言(检查返回值response)


    def test_actionGET_case02(self):
        '''从表2数字字段相加统计到主表
           应用访问地址：/app/!/information/ShuZiTongJi
           平台应用场景：数字统计计算
           统计条件：已存在的dataflow,从表2数字字段相加统计到主表
           记录：数字A:11,数字B:2,数字C:5
        '''

        params = {
            'command': 'compute',
            'tableId': 'dfmainshuzitongji',
            'recordId': 6,
            'map[sub01shuzia]': 4,
            'map[sub01shuzib]': 5,
        }
        json = '9'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】从表2数字字段相加统计到主表')  # 断言(检查返回值status是否为200)
        self.assertEqual(json, sendrequest.json()['result']['sub01ab'],
                         msg='【response】从表2数字字段相加统计到主表')  # 断言(检查返回值response)


    def test_actionGET_case03(self):
        '''3.00*9小数点后带0计算
           应用访问地址：/app/!/information/ShuZiTongJi
           平台应用场景：数字统计计算
           统计条件：新建dataflow，3.00*9小数点后带0计算
        '''

        params = {
            'command': 'compute',
            'tableId': 'dfmainshuzitongji',
            'recordId': -1,
            'map[a127f]': 3.00,
            'map[a2c6b]': 9,
        }
        json = '27'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】3.00*9小数点后带0计算')  # 断言(检查返回值status是否为200)
        self.assertEqual(json, sendrequest.json()['result']['a1xa2'],
                         msg='【response】3.00*9小数点后带0计算')  # 断言(检查返回值response)


    def test_validate_case01(self):
        '''普通用户新建dataflow提交验证字段唯一性
           应用访问地址：/app/!/information/YanZhengZiDuanWeiYiX
           平台应用场景：普通用户新建dataflow提交验证字段唯一性
           触发条件：新增"字段唯一性测试"填写：字符串1
        '''

        params = {
            'command': 'validate',
            'data[ziduanweiyixingceshi]': '字符串1',
        }
        json = '您好，【字段唯一性测试】已存在，请重新填写。'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/yanzhengziduanweiyix/-1/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(500, sendrequest.json()['status'], msg='【status】普通用户新建dataflow提交验证字段唯一性')  # 断言(检查返回值status是否为500)
        self.assertEqual(json, sendrequest.json()['msg']['HAS_REPEAT_DATA']['msg'],
                         msg='【response】普通用户新建dataflow提交验证字段唯一性')  # 断言(检查返回值response)


    def test_validate_case02(self):
        '''普通用户新建dataflow提交验证字段唯一性(未存在字段，提交成功)
           应用访问地址：/app/!/information/YanZhengZiDuanWeiYiX
           平台应用场景：普通用户新建dataflow提交验证字段唯一性(未存在字段，提交成功)
           触发条件：新增"字段唯一性测试"填写：字符串11
        '''

        params = {
            'command': 'validate',
            'data[ziduanweiyixingceshi]': '字符串11',
        }
        json = 'success'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/yanzhengziduanweiyix/-1/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】普通用户新建dataflow提交验证字段唯一性(未存在字段，提交成功)')  # 断言(检查返回值status是否为200)
        self.assertEqual(json, sendrequest.json()['result'],
                         msg='【response】普通用户新建dataflow提交验证字段唯一性(未存在字段，提交成功)')  # 断言(检查返回值response)
