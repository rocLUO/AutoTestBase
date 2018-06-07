#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 4:57
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取流程版本列表
           应用访问地址：/app/edit?id=15&type=workflow#!/step_1/GongZuoXieTong
           平台应用场景：管理员配置页面——>版本管理
        '''
        params = {
            'workflowid': 'GongZuoXieTong',
            'action': 'data'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/version/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程版本列表')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取流程版本列表')

    def test_actionPUT(self):
        '''更改流程版本
           应用访问地址：/app/edit?id=15&type=workflow#!/step_1/GongZuoXieTong
           平台应用场景：管理员配置页面——>版本管理
           版本号：160929112339
        '''
        params = {
            'action': 'update',
            'versionid': 16,
            'versioncode': 160929112339,
            'versiondesc': '更改过的描述',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/workflow/version', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】更改流程版本')

    def test_publish(self):
        '''发布版本
           应用访问地址：/app/edit?id=15&type=workflow#!/step_1/GongZuoXieTong
           平台应用场景：管理员配置页面——>版本管理
           版本号：160929112339
        '''
        values = {
            'action': 'publish',
            'workflow_id': 'GongZuoXieTong',
            'version_id': 16
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/version', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】发布版本')

    def test_save(self):
        '''流程版本保存
           应用访问地址：/workflow/setting/#!/CongBiaoYinQiXiaYiBu/19
           平台应用场景：管理员配置页面——>版本管理
           版本号：V1.0
        '''
        values = {
            'action': 'save',
            'workflowid': 'CongBiaoYinQiXiaYiBu',
            'versionid': 19,
            'datatable': '{"wfzxrsub": true, "wfzxrmain": true}',
            'config': '{"branchOnoff": "on"}',
            'workflownodes': '{"WorkNode_-1":{"Label":"结束","Type":"system","Datafield":[],'
                             '"Deadline":{"deadline_able":false,"deadline":604800,"expired_able":true,"expired_remain":3,'
                             '"expired_remain_unit":"day"},"Executor":[],"Position":{"x":650,"y":650},'
                             '"Size":{"width":70,"height":70},"Midpoint":{"x":685,"y":685},"BranchType":"",'
                             '"Previous":{"WorkNode_4":[]},"NextStep":{},"Function":[],"Completion":"","Regression":{},'
                             '"AssignMethod":"all","ExecutorMethod":"all","DataCenterMethod":null,"PushMethod":[],"Button":[],'
                             '"Note":"","nodeId":"WorkNode_-1"},"WorkNode_0":{"Label":"开始","Type":"system","Datafield":[],'
                             '"Deadline":{"deadline_able":false,"deadline":604800,"expired_able":true,"expired_remain":3,'
                             '"expired_remain_unit":"day"},"Executor":[],"Position":{"x":650,"y":31},"Size":{"width":70,"height":70},'
                             '"Midpoint":{"x":685.1,"y":66},"BranchType":"","Previous":{},'
                             r'"NextStep":{"WorkNode_1":{"Id":596,"Path":"[{\"x\":685.1,\"y\":66},{\"x\":685.1,\"y\":209}]",'
                             '"type":"and","ConditionLogic":"and","conditionGroup":[],"Timeout":false}},"Function":[],'
                             '"Completion":"","Regression":{},"AssignMethod":"all","ExecutorMethod":"all","DataCenterMethod":null,'
                             '"PushMethod":[],"Button":[],"Note":"","nodeId":"WorkNode_0"},"WorkNode_1":{"Label":"表单填写",'
                             '"Type":"general","Datafield":{"wfzxrmain":{"ceshi":"write","congbiaojilutiaoshu":"write"},'
                             '"wfzxrsub":{"xuanzeren":"write"}},"Deadline":{"deadline":604800,"deadline_able":false,'
                             '"deadline_type":"fixedTime","expired_able":true,"expired_remain":3,"expired_remain_unit":"day",'
                             '"timeout":{"checked":true,"end":"","nextnode":"","remind":"","select":"remind"}},'
                             '"Executor":{"records":[{"executor":{"fixed":[{"id":"1","parent_id":"0","type":"department",'
                             '"checked":true,"name":"API测试企业","checkedOrder":1,"Parent":"0","parent":"0","Type":"department"}],'
                             '"form":{"tableId":"","fieldId":""},"specific":{"node":"upnode","type":"1","range":[]},'
                             '"checkgroup":["0"],"appGroup":[]},"conditions":[],"order":0}],"autoSearch":"0","defaultExecutor":"1",'
                             '"anonymous":"0"},"Position":{"x":620.1,"y":184},"Size":{"width":130,"height":50},'
                             '"Midpoint":{"x":685.2,"y":209},"BranchType":"condition","Previous":{"WorkNode_0":[]},'
                             r'"NextStep":{"WorkNode_2":{"Id":597,"Path":"[{\"x\":685.1,\"y\":209},'
                             r'{\"x\":509.20000000000005,\"y\":209},{\"x\":509.1,\"y\":386}]","type":"condition",'
                             r'"ConditionLogic":"and","conditionGroup":{"conditionGroupList_0":{"condition":[{"Table":"wfzxrmain",'
                             r'"Field":"congbiaojilutiaoshu","Operator":"notless","Reference":"1","ReferenceField":""}],'
                             r'"conditionExecutor":[],"conditionLogic":"and"}},"Timeout":false},'
                             r'"WorkNode_5":{"Id":599,"Path":"[{\"x\":685.2,\"y\":209},{\"x\":935.1,\"y\":209}]",'
                             r'"type":"condition","ConditionLogic":"and","conditionGroup":{"conditionGroupList_0":{"condition":[{"Table":"wfzxrmain","Field":"congbiaojilutiaoshu","Operator":"less","Reference":"1","ReferenceField":""}],"conditionExecutor":[],"conditionLogic":"and"}},"Timeout":false}},"Function":[],"Completion":"","Regression":{},"AssignMethod":"all","ExecutorMethod":"all",'
                             r'"DataCenterMethod":{"wfzxrsub":{"access":"showAll","orgField":"xuanzeren"}},"PushMethod":[],"Button":[],"Note":"","nodeId":"WorkNode_1"},'
                             r'"WorkNode_2":{"Label":"审批","Type":"general","Datafield":{"wfzxrmain":{"shenpiren1":"write"},"wfzxrsub":[]},"Deadline":{"deadline":604800,"deadline_able":false,"deadline_type":"fixedTime","expired_able":true,"expired_remain":3,"expired_remain_unit":"day","timeout":{"checked":true,"end":"",'
                             r'"nextnode":"","remind":"","select":"remind"}},"Executor":{"records":[{"executor":{"fixed":[],"form":{"tableId":"wfzxrsub","fieldId":"xuanzeren"},"specific":{"node":"upnode","type":"1","range":[]},"checkgroup":["1"],"appGroup":[]},"conditions":{"type":"and","assign_list":[],"form_list":[]},"order":0}],"autoSearch":"0","defaultExecutor":"1","anonymous":"0"},"Position":{"x":444.1,"y":361},'
                             r'"Size":{"width":130,"height":50},"Midpoint":{"x":509.1,"y":386},"BranchType":"","Previous":{"WorkNode_1":[]},'
                             r'"NextStep":{"WorkNode_4":{"Id":598,"Path":"[{\"x\":509.1,\"y\":386},{\"x\":509.1,\"y\":525},{\"x\":685,\"y\":525}]","type":"and","ConditionLogic":"and","conditionGroup":[],"Timeout":false}},"Function":[],"Completion":"","Regression":{},"AssignMethod":"all","ExecutorMethod":"all","DataCenterMethod":[],"PushMethod":[],'
                             r'"Button":[],"Note":"","nodeId":"WorkNode_2"},"WorkNode_4":{"Label":"审批告知","Type":"general","Datafield":{"wfzxrmain":[],"wfzxrsub":[]},'
                             r'"Deadline":{"deadline":604800,"deadline_able":false,"deadline_type":"fixedTime","expired_able":true,"expired_remain":3,"expired_remain_unit":"day","timeout":{"checked":true,"end":"","nextnode":"","remind":"","select":"remind"}},"Executor":{"records":[{"executor":{"fixed":[],"form":{"tableId":"","fieldId":""},"specific":{"node":"WorkNode_1","type":"0","range":[]},"checkgroup":["2"],'
                             r'"appGroup":[]},"conditions":[],"order":0}],"autoSearch":"0","defaultExecutor":"1","anonymous":"0"},"Position":{"x":620,"y":500},'
                             r'"Size":{"width":130,"height":50},"Midpoint":{"x":685,"y":525},"BranchType":"","Previous":{"WorkNode_2":[],"WorkNode_5":[]},"NextStep":{"WorkNode_-1":{"Id":594,"Path":"[{\"x\":685,\"y\":525},{\"x\":685,\"y\":685}]","type":"and","ConditionLogic":"and","conditionGroup":[],"Timeout":false}},"Function":[],"Completion":"","Regression":{},'
                             r'"AssignMethod":"all","ExecutorMethod":"all","DataCenterMethod":[],"PushMethod":[],"Button":[],"Note":"","nodeId":"WorkNode_4"},"WorkNode_5":{"Label":"默认执行人","Type":"general","Datafield":{"wfzxrmain":[],"wfzxrsub":[]},'
                             r'"Deadline":{"deadline":604800,"deadline_able":false,"deadline_type":"fixedTime","expired_able":true,"expired_remain":3,"expired_remain_unit":"day","timeout":{"checked":true,"end":"","nextnode":"","remind":"","select":"remind"}},"Executor":{"records":[{"executor":{"fixed":[{"id":"Uwcm","parent_id":4,"type":"member","checked":true,'
                             r'"groupBelong":false,"name":"云平台研发部-经理-王聪明","checkedOrder":1,"Parent":4,"parent":4,"Type":"member"},{"id":"Uzongjingli","parent_id":3,"type":"member","checked":true,"groupBelong":false,"name":"总经理-王三明","checkedOrder":2,"Parent":3,"parent":3,"Type":"member"}],"form":{"tableId":"","fieldId":""},"specific":{"node":"upnode",'
                             r'"type":"1","range":[]},"checkgroup":["0"],"appGroup":[]},"conditions":[],"order":0}],"autoSearch":"0","defaultExecutor":"1","anonymous":"0"},"Position":{"x":870.1,"y":184},"Size":{"width":130,"height":50},"Midpoint":{"x":935.1,"y":209},"BranchType":"","Previous":{"WorkNode_1":[]},'
                             r'"NextStep":{"WorkNode_4":{"Id":598,"Path":"[{\"x\":935.1,\"y\":209},{\"x\":935.1,\"y\":525},{\"x\":685,\"y\":525}]","type":"and","ConditionLogic":"and","conditionGroup":[],"Timeout":false}},"Function":[],"Completion":"","Regression":{},"AssignMethod":"all","ExecutorMethod":"all","DataCenterMethod":[],"PushMethod":[],"Button":[],"Note":"","nodeId":"WorkNode_5"}}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/workflow/version', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程版本保存')

    def test_default(self):
        '''设置流程默认版本
           应用访问地址：/app/edit?id=46&type=workflow#!/step_1/QuanZiDuanLiuCheng
           平台应用场景：管理员配置页面——>版本管理
           版本号：161216102552
        '''
        values = {
            'action': 'default',
            'workflow_id': 'QuanZiDuanLiuCheng',
            'version_id': 23
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/workflow/version', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】设置流程默认版本')
