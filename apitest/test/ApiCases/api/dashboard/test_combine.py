#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/12 0012 上午 9:54
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_combine(self):
        '''获取组合分析(选择2张单应用图表组合后点击图表类型生成图表)
           应用访问地址：/dashboard/setting/#panelCouple/0/-1
           平台应用场景：组合分析生成图表分析
        '''
        params={
            'combine':'{"title":"","type":"line","status":true,"owner":"ApiTest","config":"",'
                      '"range":"middle","formIncYoY":"","formIncMoM":"","datasource":["16","17"],'
                      '"values":["16.mainshuzi + 16.subshuzi + 17.dfmaindefault + 17.subshuzi"],'
                      '"conditions":["16.mainzifuchuan.BASIC = 17.mainzifuchuan.BASIC"],'
                      '"valueTitles":["`df_主表+从表散点图[main_数字]` + `df_主表+从表散点图[sub_数字]` + '
                      '`df_主表+从表报表图[df_main_default]` + `df_主表+从表报表图[sub_数字]`"],'
                      '"conditionTitles":["`df_主表+从表散点图[main_字符串]` = `df_主表+从表报表图[main_字符串]`"],'
                      '"valueFieldIds":["16.mainshuzi","16.subshuzi","17.dfmaindefault","17.subshuzi"],"targets":{},'
                      '"xIncType":""}'
        }
        json={
            'result':[]
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/dashboard/combine',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取组合分析(选择2张单应用图表组合后点击图表类型生成图表)')  # 断言(检查返回值status是否为200)
        self.assertNotEqual(json,sendrequest.json(),msg='【response】获取组合分析(选择2张单应用图表组合后点击图表类型生成图表)')