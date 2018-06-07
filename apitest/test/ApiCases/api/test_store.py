#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/23 0023 上午 11:23
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_StoreOrganization(self):
        '''获得文件存储组织架构
           应用访问地址：/store/permissionmanage
           平台应用场景：PaaS后台管理界面进入，权限引擎——>文档权限
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/store/StoreOrganization')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='获得文件存储组织架构')  # 断言(判断返回值是否为json格式)

    def test_getUMFSize(self):
        '''获取php.ini配置upload_max_filesize单位为M
           应用访问地址：/store/permissionmanage
           平台应用场景：附件上传时触发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/store/getUMFSize/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='获取php.ini配置upload_max_filesize单位为M')  # 断言(判断返回值是否为json格式)

    def test_details(self):
        '''文件详情
           应用访问地址：/store/#foldertree/store
           文件夹：抓包文档/工作报告
           平台应用场景：文档管理点击查看详情
        '''
        fileId = 39
        params = {
            'sEcho': 1,
            'iColumns': 5,
            'sColumns': '',
            'iDisplayStart': 0,
            'iDisplayLength': 15,
            'mDataProp_0': 'type',
            'mDataProp_1': 'realName',
            'mDataProp_2': 'time',
            'mDataProp_3': 'ip',
            'mDataProp_4': 'description',
            'sSearch': '',
            'bRegex': 'false',
            'sSearch_0': '',
            'bRegex_0': 'false',
            'bSearchable_0': 'true',
            'sSearch_1': '',
            'bRegex_1': 'false',
            'bSearchable_1': 'true',
            'sSearch_2': '',
            'bRegex_2': 'false',
            'bSearchable_2': 'true',
            'sSearch_3': '',
            'bRegex_3': 'false',
            'bSearchable_3': 'true',
            'sSearch_4': '',
            'bRegex_4': 'false',
            'bSearchable_4': 'true',
            'iSortingCols': 0,
            'bSortable_0': 'true',
            'bSortable_1': 'true',
            'bSortable_2': 'true',
            'bSortable_3': 'false',
            'bSortable_4': 'false',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/store/details/' + str(fileId), params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='文件详情')


    def test_extract_case01(self):
        '''压缩包在线解析json结构(压缩包预览——压缩包中不包含子压缩文件)
           应用访问地址：/store/permissionmanage
           平台应用场景：压缩包格式文件预览
        '''
        params={
            'child':''
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/store/extract/extract/54/0',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='压缩包在线解析json结构(压缩包预览——压缩包中不包含子压缩文件)')  # 断言(判断返回值是否为json格式)



    def test_extract_case02(self):
        '''压缩包在线解析json结构(压缩包预览——压缩包中包含子压缩文件)
           应用访问地址：/store/permissionmanage
           平台应用场景：压缩包格式文件预览
        '''
        params={
            'child':'1'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/store/extract/extract/54/0',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='压缩包在线解析json结构(压缩包预览——压缩包中包含子压缩文件)')  # 断言(判断返回值是否为json格式)
