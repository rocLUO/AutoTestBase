#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/28 0028 下午 3:56
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_instance_node_datacenter(self):
        '''web流程——从表添加权限验证(主表无添加权限)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：流程从表添加权限用例
           平台应用场景：工作协同
        '''
        values = {'record_id': 10020,
                  'table_id': 'gongzuoxietong',
                  'data': '[]'
                  }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(
            Login().url + '/api2/workflow/instance_node_datacenter/GongZuoXieTong/10085/WorkNode_4/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect = 'SUCCESS'  # 期望返回值
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        actual = sendrequest.json()['message']  # 实际返回值
        self.assertEqual(expect, actual, msg='【web】流程从表添加权限验证(主表无添加权限)')  # 断言


    def test_actionGET(self):
        '''获取流程从表数据
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：测试组必备技能
           平台应用场景：工作协同获取从表数据
        '''
        params = {
            'table_id': 'gongzuoshouli',
            'action': 0,
            'targetId': 0,
            'scId': 0,
            'params[appId]': 'GongZuoXieTong',
            'params[slaveTableId]': 'gongzuoshouli',
            'params[paging][perPage]': 15,
            'params[paging][start]': 0,
            'params[condition]': '',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(
            Login().url + '/api2/workflow/instance_node_datacenter/GongZuoXieTong/12/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual('3', sendrequest.json()['count'], msg='【response】获取流程从表数据')  # 断言

    def test_actionPost(self):
        '''添加流程从表数据
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           main_字符串：杜磊测试
           平台应用场景：添加流程从表数据
        '''
        values = {
            'record_id': '-1',
            'table_id': 'wfsub01',
            'data': r'[{"name":"wfsub01_sub01zifuchuan","value":"新增一条数据"},'
                    r'{"name":"wfsub01_sub01shuzi","value":"2"},'
                    r'{"name":"wfsub01_sub01jingweidu","value":{"x":118.77807441,"y":32.0572355,"mark":"江苏省南京市鼓楼区广州路189",'
                    r'"province":"江苏省","city":"南京市","district":"鼓楼区","street":"广州路","streetNumber":"189"}},'
                    r'{"name":"wfsub01_sub01bianhao","value":""},{"name":"wfsub01_sub01wenben","value":"文本2"},'
                    r'{"name":"wfsub01_sub01diqu","value":"河北省 唐山市 市辖区"},{"name":"wfsub01_sub01danxuan","value":"选项2"},'
                    r'{"name":"wfsub01_sub01duoxuan","value":["B"]},{"name":"wfsub01_sub01fujian","value":[]},'
                    r'{"name":"wfsub01_sub01riqishijian","value":"2018-04-27 14:04:02"},'
                    r'{"name":"wfsub01_sub01zuzhijiagou","value":"{\"displayValue\":\"  云平台研发部  \",\"real\":{\"orgs\":{\"2\":{\"id\":\"2\",\"parent_id\":\"12\",\"Type\":\"department\"}},\"blacklist\":{}}}"}]',
            'master_table_id': 'wfmain',
            'master_record_id': 2
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(
            Login().url + '/api2/workflow/instance_node_datacenter/QuanZiDuanLiuCheng/15/WorkNode_1/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual('ok', sendrequest.json()['status'], msg='【status】添加流程从表数据')  # 断言

    def test_actionDelete(self):
        '''删除流程从表数据
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           main_字符串：杜磊测试
           平台应用场景：删除流程从表数据
        '''
        values = {
            'record_id': 1,
            'table_id': 'wfsub01',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(
            Login().url + '/api2/workflow/instance_node_datacenter/QuanZiDuanLiuCheng/15/WorkNode_1/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        self.assertEqual('ok', sendrequest.json()['status'], msg='【status】删除流程从表数据')  # 断言
