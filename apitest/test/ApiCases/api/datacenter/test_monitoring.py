#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/13 0013 下午 3:09
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''管理员,获取数据监控列表监控规则
           数据监控访问地址：/datacenter/monitoring
           平台应用场景：获取数据监控列表监控规则
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/monitoring/rules/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json()['rules'], msg='【response】获取数据监控列表监控规则')  # 断言(检查返回值)


    def test_actionPut(self):
        '''管理员,数据监控-规则修改/添加
           数据监控访问地址：/datacenter/monitoring
           平台应用场景：数据监控列表监控规则修改
        '''
        values={
            'parent_id':0,
            'rule':'{"monitor":[{"id":"UIDdulei","parent_id":7,"type":"member","checked":true,'
                   '"groupBelong":"contacts","name":"产品测试组-组员-杜磊","checkedOrder":1,"Parent":7,'
                   '"parent":7,"Type":"member"}],"monitored":[{"id":"2","parent_id":"12","type":"department",'
                   '"checked":true,"name":"云平台研发部","checkedOrder":1,"Parent":"12","parent":"12",'
                   '"Type":"department"}],"monitor_group":null,"monitored_group":null,'
                   '"tables":{"datasourcemain":{"fields_right":{},"conditions":{"type":"AND","groups":[]},'
                   '"table_id":"datasourcemain","table_right":"1|0|0"}}}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api/datacenter/monitoring/updateRule/',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】数据监控-规则修改/添加')  # 断言(检查返回值)
        self.assertEqual(4, sendrequest.json()['result'], msg='【response】数据监控-规则修改/添加')  # 断言(检查返回值)

    def test_actionDelete(self):
        '''管理员,数据监控-规则删除
           数据监控访问地址：/datacenter/monitoring
           平台应用场景：数据监控列表监控规则删除
        '''
        values = {
            'recordsid':'["3"]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api/datacenter/monitoring/DeleteRules/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('ok', sendrequest.json()['status'], msg='【status】数据监控-规则删除')  # 断言(检查返回值)
        self.assertEqual(['3'], sendrequest.json()['type'], msg='【response】数据监控-规则删除')  # 断言(检查返回值)