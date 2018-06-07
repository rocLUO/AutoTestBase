#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/28 0028 下午 3:56
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_data_post(self):
        '''dataflow——从表添加保存权限验证(主表无添加权限)
           应用访问地址：/app/!/information/DFCongBiaoTianJiaQua
           工作标题：DF测试从表添加权限
           平台应用场景：发布回顾总结从表点击添加填写完数据后提交
        '''
        values = {'params[data][0][name]': 'dfcong_congzifuchuan',
                  'params[data][0][value]': '从表添加保存',
                  'params[appId]': 'DFCongBiaoTianJiaQua',
                  'params[master][tableId]': 'dfzhu',
                  'params[master][recordId]': 1
                  }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/information/data/dfcong/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect = 200  # 期望返回值
        actual = sendrequest.json()['status']  # 实际返回值
        self.assertEqual(expect, actual, msg='【web】dataflow从表添加保存权限验证(主表无添加权限)')  # 断言

    def test_data_search_get(self):
        '''APP——蓝牙搜索
           应用访问地址：/app/!/information/LanYaQuYuBangDing
           平台应用场景：移动巡检
        '''
        values = {'params[paging][start]': 0,
                  'params[paging][perPage]': 1,
                  'params[condition][0][value]': '19:18:FC:06:2F:42',
                  'params[condition][0][symbol]': 'like',
                  'params[appId]': 'LanYaPeiZhi',
                  'params[condition][0][field]': 'macdizhi',
                  'params[tableId]': 'lanyaxinxibiao',
                  'params[condition][0][type]': 'string',
                  'params[condition][0][table]': 'lanyaxinxibiao'
                  }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/information/data/search/isMobile/android', params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect = 200  # 期望返回值
        actual = sendrequest.json()['status']  # 实际返回值
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(expect, actual, msg='APP蓝牙搜索')  # 断言

    def test_label(self):
        '''获得标签下的数据
           应用访问地址：/app/!/information/DFShuJuYuanBiao
           标签：获取'所有'标签下的数据
           平台应用场景：DF数据源表获取所有标签下的数据
        '''
        params = {
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[labelId]': 24,
            'params[tableId]': 'dfshujuyuanbiao',
            'params[appId]': 'DFShuJuYuanBiao'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/information/data/label/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获得标签下的数据')  # 断言
        self.assertNotEqual('0', sendrequest.json()['result']['count'], msg='【response】获得标签下的数据')  # 断言

    def test_actionPost(self):
        '''dataflow添加数据
           应用访问地址：/app/!/information/DFJiBenCaoZuo
           平台应用场景：dataflow添加数据
        '''
        values = {
            'params[appId]': 'DFJiBenCaoZuo',
            'params[data][0][name]': 'dfjichubiao_onlyzifuchuan',
            'params[data][0][value]': 'DF添加',
            'params[type]': 'add'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/information/data/dfjichubiao', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow添加数据')  # 断言

    def test_dataput(self):
        '''dataflow数据更新
           应用访问地址：/app/!/information/DFJiBenCaoZuo
           only字符串：修改过了
           平台应用场景：dataflow数据更新
        '''
        values = {
            'params[appId]': 'DFJiBenCaoZuo',
            'params[data][0][name]': 'dfjichubiao_onlyzifuchuan',
            'params[data][0][value]': '修改过了',
            'params[type]': 'edit'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api/information/data/dfjichubiao/1', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow数据更新')  # 断言

    def test_qrRecord(self):
        '''dataflow二维码获取数据接口
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           main字符串：杜磊
           平台应用场景：APP扫描dataflow中的二维码时会调用此接口
        '''
        recordId = '1'
        tableId = 'dfmaindefault'
        appId = 'DFMoRenPeiZhiHanCong'
        enterprise_id = 'APICeShiQiYe'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(
            Login().url + '/api/information/data/qrRecord/' + tableId + '/' + recordId + '/' + appId + '/' + enterprise_id)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow二维码获取数据接口')  # 断言
        self.assertNotEqual([], sendrequest.json()['result']['data'], msg='【response】dataflow二维码获取数据接口')  # 断言


    def test_export(self):
        '''流程从表导出
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           平台应用场景：流程从表导出
        '''
        params={
            'params':'{"masterTableId":"wfmain","masterRecordId":"3","appId":"QuanZiDuanLiuCheng","type":"workflow","records":["2"]}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(
            Login().url + '/api/information/data/export/wfsub01',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual('application/vnd.ms-excel', sendrequest.headers['Content-Type'], msg='【response】流程从表导出')  # 根据返回值heads中的Content-Type属性判断
