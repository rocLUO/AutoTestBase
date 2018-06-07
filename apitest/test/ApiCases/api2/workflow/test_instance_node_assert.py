#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 11:04
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPOST_case01(self):
        '''新建流程从表未添加(检查下一步执行人)
           应用访问地址：/app/!/workflow/CongBiaoYinQiXiaYiBu
           平台应用场景：流程发起检查下一步执行人
        '''
        params = {
            'action': 'run',
            'workflowid': 'CongBiaoYinQiXiaYiBu'
        }
        values = {
            'form_data': '[{"name":"wfzxrmain_ceshi","value":""},'
                         '{"name":"wfzxrmain_shenpiren1","value":""},'
                         '{"name":"wfzxrmain_shenpiren2","value":""},'
                         '{"name":"wfzxrmain_congbiaojilutiaoshu","value":"0"}]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        # 获取流程实例ID
        sendrequest1 = nowlogin.get(Login().url + '/api2/workflow/permission', params=params)
        instantid = sendrequest1.json()['result']['instantid']
        # 流程发起
        sendrequest = nowlogin.post(
            Login().url + '/api2/workflow/instance_node_assert/CongBiaoYinQiXiaYiBu/' + str(instantid) + '/WorkNode_1',
            data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程发起检查下一步执行人')
        self.assertEqual('云平台研发部-经理-王聪明', sendrequest.json()['result'][0]['assignto']['fixed'][0]['name'],
                         msg='【response】流程发起检查下一步执行人')
        self.assertEqual('总经理-王三明', sendrequest.json()['result'][0]['assignto']['fixed'][1]['name'],
                         msg='【response】流程发起检查下一步执行人')

    def test_actionPOST_case02(self):
        '''从表组织架构字段引起下一步执行人
           应用访问地址：/app/!/workflow/CongBiaoYinQiXiaYiBu
           平台应用场景：从表组织架构字段引起下一步执行人
           测试：从表选择杜磊-web端存草稿
        '''
        values = {
            'form_data': '[{"name":"wfzxrmain_ceshi","value":"从表选择杜磊-web端存草稿"},'
                         '{"name":"wfzxrmain_shenpiren1","value":""},'
                         '{"name":"wfzxrmain_shenpiren2","value":""},'
                         '{"name":"wfzxrmain_congbiaojilutiaoshu","value":"1"}]'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(
            Login().url + '/api2/workflow/instance_node_assert/CongBiaoYinQiXiaYiBu/24/WorkNode_1',
            data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】从表组织架构字段引起下一步执行人')
        self.assertEqual('UIDdulei', sendrequest.json()['result'][0]['assignto']['form'][0]['id'],
                         msg='【response】从表组织架构字段引起下一步执行人')

    def test_actionPOST_case03(self):
        '''流程下一步执行人为同一个人多个节点
           应用访问地址：/app/!/workflow/YiGeRenDaiBanShuYuDu
           平台应用场景：流程下一步执行人为同一个人多个节点
           字符串1：代办存在多节点
        '''
        values = {
            'form_data': '[{"name":"yigerendaibanshuyudu_zifuchuan1",'
                         '"value":"代办存在多节点"},{"name":"yigerendaibanshuyudu_zifuchuan2",'
                         '"value":"节点2填写内容"},{"name":"yigerendaibanshuyudu_zifuchuan3","value":""},'
                         '{"name":"yigerendaibanshuyudu_zifuchuan4","value":""},'
                         '{"name":"yigerendaibanshuyudu_zifuchuan5","value":""}]'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(
            Login().url + '/api2/workflow/instance_node_assert/CongBiaoYinQiXiaYiBu/78/WorkNode_2',
            data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程下一步执行人为同一个人多个节点')
        self.assertEqual('WorkNode_3', sendrequest.json()['result'][0]['key'],
                         msg='【response】流程下一步执行人为同一个人多个节点')
        self.assertEqual('WorkNode_4', sendrequest.json()['result'][1]['key'],
                         msg='【response】流程下一步执行人为同一个人多个节点')
        self.assertEqual('云平台研发部-经理-王聪明', sendrequest.json()['result'][0]['assignto']['fixed'][0]['name'],
                         msg='【response】流程下一步执行人为同一个人多个节点')
        self.assertEqual('云平台研发部-经理-王聪明', sendrequest.json()['result'][1]['assignto']['fixed'][0]['name'],
                         msg='【response】流程下一步执行人为同一个人多个节点')
