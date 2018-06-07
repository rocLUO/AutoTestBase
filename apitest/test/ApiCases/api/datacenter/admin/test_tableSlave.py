#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/12 0012 下午 7:09
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''获取一张表的从表
           应用访问地址：/datacenter/#!showCategory/DataFlow/所有类型字段（默认配置）
           平台应用场景：数据中心管理员编辑主表时
           表名称：df_main_default
        '''
        json = [
            {'belongs_to': 'dfmaindefault', 'status': 0, 'index': 0, 'id': 1, 'table_id': 'dfsubdefault01'},
            {'belongs_to': 'dfmaindefault', 'status': 0, 'index': 1, 'id': 2, 'table_id': 'dfsubdefault'}
        ]
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/admin/tableSlave/dfmaindefault')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(json, sendrequest.json(), msg='【response】获取一张表的从表')  # 断言(检查返回值response)
