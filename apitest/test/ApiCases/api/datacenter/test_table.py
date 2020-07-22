#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/16 0016 下午 3:30
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_CheckField(self):
        '''检查数据表字段是否有数据(有数据的字段不允许删除)
           应用访问地址：数据中心
           平台应用场景：数据中心删除字段时判断表是否有数据
        '''
        params = {
            'tableId': 'dfmaindefault',
            'fieldId': 'mainzifuchuan'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/table/checkfield', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['status'],
                         msg='【response】检查数据表字段是否有数据(有数据的字段不允许删除)')  # 断言(检查返回值response)

    def test_CheckTable(self):
        '''检查数据表是否被应用绑定(已绑定应用的数据表不允许被删除)
           应用访问地址：数据中心
           平台应用场景：数据中心删除数据表，检查是否被应用使用
        '''
        params = {
            'tableId': 'dfmaindefault',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/table/checktable', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json(), msg='【response】检查数据表是否被应用绑定(已绑定应用的数据表不允许被删除)')  # 断言(检查返回值response)

    def test_getMaterTable(self):
        '''获取这个表在数据中心所配的所有主表
           应用访问地址：数据中心
           平台应用场景：获取这个表在数据中心所配的所有主表
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/table/main/dfcong')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取这个表在数据中心所配的所有主表')  # # 断言(检查返回值status)
        self.assertEqual('DF主', sendrequest.json()['result']['dfzhu']['title'],
                         msg='【response】获取这个表在数据中心所配的所有主表')  # 断言(检查返回值response)

    def test_getsubordinateTable(self):
        '''获取这个表在数据中心所配的所有从表
           应用访问地址：数据中心
           平台应用场景：获取这个表在数据中心所配的所有从表
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/table/subordinate/dfzhu')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('DF从', sendrequest.json()['dfcong']['title'],
                         msg='【response】获取这个表在数据中心所配的所有从表')  # 断言(检查返回值response)

    def test_getlastmodified(self):
        '''获取这个表在数据中心最新的修改时间
           应用访问地址：数据中心
           平台应用场景：获取这个表在数据中心最新的修改时间
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/table/lastmodified/dfmaindefault')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'],
                         msg='【status】获取这个表在数据中心最新的修改时间')  # 断言(检查返回值status)
        self.assertNotEqual([], sendrequest.json()['result']['dfmaindefault'],
                         msg='【response】获取这个表在数据中心最新的修改时间')  # 断言(检查返回值response)


    def test_getdesc(self):
        '''获取这表的结构
           应用访问地址：数据中心
           表：'df_main_default'
           平台应用场景：获取这表的结构
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/table/desc/dfmaindefault')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)