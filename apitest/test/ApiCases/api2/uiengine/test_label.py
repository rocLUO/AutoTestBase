#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/5/2 0002 上午 10:08
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_defaultlabel(self):
        '''获取流程默认标签的配置
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：进入流程列表时触发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/uiengine/label/default/workflow/GongZuoXieTong/0')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程默认标签的配置')
        self.assertEqual('监控', sendrequest.json()['result']['name'], msg='【response】获取流程默认标签的配置')

    def test_addConfiglabel(self):
        '''管理员配置界面新增公共筛选标签
           应用访问地址：/uiengine/#!/workflow/GongZuoXieTong/16
        '''
        values = {
            'name': '新增公共筛选标签'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/label/workflow/GongZuoXieTong/16', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】管理员配置界面新增公共筛选标签')

    def test_addCustomlabel(self):
        '''普通用户新增自定义筛选标签
           应用访问地址：/app/!/workflow/GongZuoXieTong
        '''
        values = {
            'params': '{"name": "新增自定义标签", "condition": {"type": "AND", "value": []}}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/label/custom/workflow/GongZuoXieTong', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】普通用户新增自定义筛选标签')
        self.assertEqual('新增自定义标签', sendrequest.json()['result']['name'], msg='【response】普通用户新增自定义筛选标签')

    def test_Sortlabel(self):
        '''管理员标签拖动排序
           应用访问地址：/uiengine/#!/information/DFMoRenPeiZhiHanCong
        '''
        values = {
            'params': '["1","2","313","118"]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/label/sort/information/DFMoRenPeiZhiHanCong/0',
                                    data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】管理员标签拖动排序')

    def test_setdefaultlabel(self):
        '''默认标签设置
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
        '''
        values = {
            'labelId': 118,
            'default': 1,
            'module': 'information',
            'appId': 'DFMoRenPeiZhiHanCong'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/label/user',
                                    data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】默认标签设置')
