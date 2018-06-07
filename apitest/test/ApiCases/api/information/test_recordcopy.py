#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/19 0019 下午 4:55
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''dataflow复制记录数据"
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow复制
        '''
        tableID = "DFMoRenPeiZhiHanCong"#表ID
        recordID='8'#记录ID
        json={"mainzifuchuan":"","mainshuzi":"","mainwenben":"","maindiqu":"","maindanxuan":"","mainduoxuan":[],"mainzuzhijiagou":""}
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/information/recordcopy/'+tableID+'/'+recordID)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow复制记录数据"')  # 断言(检查返回值status是否为200)
        self.assertNotEqual(json, sendrequest.json()['result'], msg='【response】dataflow复制记录数据"')  # 断言(检查返回值status是否为200)
