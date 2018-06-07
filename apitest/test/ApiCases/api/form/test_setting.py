#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/18 0018 下午 4:01
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''【管理员】获取form配置（form配置页面）
           应用访问地址：
           平台应用场景：管理员进入form配置字段绑定页面
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/form/setting/workflow/GongZuoXieTong/1/gongzuoxietong/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】管理员获取form配置（form配置页面）')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】管理员获取form配置（form配置页面）')


    def test_actionPOST(self):
        '''【管理员用户】form保存配置（form配置页面）
           应用访问地址：/appcenter/appsystem/181
           平台应用场景：管理员进入form配置(字段绑定)页面，保存配置
        '''
        values={
            'config':'{"cells":[{"parent":"0","id":"1","type":"group","font_color":"#000000",'
                     '"background_color":"#ffffff","font_family":"Microsoft Yahei","font_size":"medium",'
                     '"font_weight":"normal","font_italic":false,"font_throughline":false,"font_underline":false,'
                     '"text_align":"","input_font_color":"#000000","input_background_color":"#ffffff",'
                     '"input_font_size":"medium","input_font_family":"Microsoft Yahei","label_font_color":"#000000",'
                     '"label_background_color":"#ffffff","label_font_size":"medium","label_font_family":"Microsoft Yahei",'
                     '"index":0,"group_title":"","hide_title":false,"index_type":true,"auto_merge":true},{"parent":"1","id":"2",'
                     '"type":"row","index":0},{"parent":"2","id":"3","type":"cell","size":1,"index":0,"text_align":"right"},'
                     '{"parent":"2","id":"4","type":"cell","size":4,"index":1,"text_align":"left"},'
                     '{"parent":"2","id":"5","type":"cell","size":1,"index":2,"text_align":"right"},'
                     '{"parent":"2","id":"6","type":"cell","size":4,"index":3,"text_align":"left"},'
                     '{"parent":"3","id":"7","type":"label","title":"formtest","index":0},'
                     '{"parent":"4","id":"8","type":"field","for_field":"formtest","index":0}]}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/form/setting/information/formJieKouCeShi/0/formjiekouceshi/',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】管理员用户form保存配置（form配置页面）')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】管理员用户form保存配置（form配置页面）')