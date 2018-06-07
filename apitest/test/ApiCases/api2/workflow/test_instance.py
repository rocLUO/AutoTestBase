#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/29 0029 下午 4:48
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_instance_get(self):
        '''web流程——自定义筛选标签（筛选：发起人）
           应用访问地址：/app/!/workflow/GongZuoXieTong
           标签名称：发起人等于企业管理员
           平台应用场景：用户配置自定义筛选标签（筛选：发起人）
        '''
        values = {'params[paging][perPage]': 15,
                  'params[paging][start]': 0,
                  'params[labelId]': 781,
                  }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【respoonse】流程自定义筛选标签——筛选：发起人')  # 断言

    def test_Search(self):
        '''流程数据搜索
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程数据搜索
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 11,
            'params[searchText]': '日常工作',
            'params[appId]': 'GongZuoXieTong',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance/search', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程数据搜索')  # 断言
        self.assertEqual(1, sendrequest.json()['result']['count'], msg='【response】流程数据搜索')  # 断言

    def test_Label_case01(self):
        '''流程代办label数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程代办label数据获取
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 7,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程代办label数据获取')  # 断言
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】流程代办label数据获取')  # 断言

    def test_Label_case02(self):
        '''流程经办label数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程经办label数据获取
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 8,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程经办label数据获取')  # 断言
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】流程经办label数据获取')  # 断言

    def test_Label_case03(self):
        '''流程过往label数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程过往label数据获取
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 9,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程过往label数据获取')  # 断言
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】流程过往label数据获取')  # 断言

    def test_Label_case04(self):
        '''流程所有label数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程所有label数据获取
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 514,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程所有label数据获取')  # 断言
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】流程所有label数据获取')  # 断言

    def test_Label_case05(self):
        '''流程抄送给我的label数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程抄送给我的label数据获取
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 11,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程抄送给我的label数据获取')  # 断言

    def test_Label_case06(self):
        '''流程我抄送的label数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程我抄送的label数据获取
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 518,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程我抄送的label数据获取')  # 断言

    def test_Label_case07(self):
        '''流程监控标签列表数据获取（监控列表存在数据）
           应用访问地址：/app/!/workflow/XuQiuGongDan
           平台应用场景：流程监控标签列表数据获取（监控列表存在数据）
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 301,
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程监控标签列表数据获取（监控列表存在数据）')
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】流程监控标签列表数据获取（监控列表存在数据）')


    def test_Delete(self):
        '''删除流程实例
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：删除流程实例
        '''

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api2/workflow/instance/GongZuoXieTong/17')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】删除流程实例')  # 断言

    def test_actionGET(self):
        '''流程组合排序
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：流程组合排序
        '''
        params = {
            'params[order][0][field]': 'gongzuoxietong_gongzuobiaoti',
            'params[order][0][type]': 'asc',
            'params[order][1][field]': 'current_handlers',
            'params[order][1][type]': 'asc',
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 514
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程组合排序')  # 断言
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】流程组合排序')  # 断言
