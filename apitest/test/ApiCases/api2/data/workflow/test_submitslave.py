#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 4:06
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_ActionPost(self):
        '''APP流程新增从表记录
           应用访问地址：/app/!/workflow/YiDongDuanZhuCong
           平台应用场景：APP流程新增从表记录
           标题：APP从表添加测试
        '''
        values = {
            'instanceId': 50,
            'nodeId': 'WorkNode_1',
            'workflowId': 'YiDongDuanZhuCong',
            'slave_id': 'yidongduanzhucongco',
            'data': r'{"slaveId":"yidongduanzhucongco","slaveKeyColumn":"","slaveName":"移动端主从-从表",'
                    r'"slave_item_fields":[{"schema":{"basic":"0","belongs":"yidongduanzhucongco",'
                    r'"controlledFields":"{\"required_rule\":[],\"unchangeable_rule\":[],\"displayable_rule\":[]}",'
                    r'"created_time":"2017-03-09 11:13:12","creator":"ApiTest","datasource":"","expression":"0",'
                    r'"expression_fields":"[]","formIndex":"","id":"id","index":"1","last_modified":"2017-03-09 11:13:12",'
                    r'"mainField":"0","metadata":"[]","modifier":"ApiTest","relationControlFields":"[]","relationMapFields":"[]",'
                    r'"relationSearchFields":"[]","report":"","required":"0","systemTime":"","title":"id","type":"system",'
                    r'"unique":"0"},"table_id":"yidongduanzhucongco","table_title":"移动端主从-从表","table_type":"",'
                    r'"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"",'
                    r'"last_modified":"","modified_method":"","modifier":"","owner":"","value":""},"workProviderType":"STRING"},'
                    r'{"schema":{"basic":"0","belongs":"yidongduanzhucongco","controlledFields":"{\"required_rule\":[],'
                    r'\"unchangeable_rule\":[],\"displayable_rule\":[]}","created_time":"2017-03-09 11:13:12","creator":"ApiTest",'
                    r'"datasource":"","expression":"0","expression_fields":"[]","formIndex":"","id":"modifier","index":"2",'
                    r'"last_modified":"2017-03-09 11:13:12","mainField":"0","metadata":"[]","modifier":"ApiTest",'
                    r'"relationControlFields":"[]","relationMapFields":"[]","relationSearchFields":"[]","report":"","required":"0",'
                    r'"systemTime":"","title":"修改人","type":"system","unique":"0"},"table_id":"yidongduanzhucongco",'
                    r'"table_title":"移动端主从-从表","table_type":"","value":{"access_button":"","access_changeable":false,'
                    r'"access_deleteable":false,"access_readable":true,"id":"","last_modified":"","modified_method":"","modifier":"",'
                    r'"owner":"","value":""},"workProviderType":"STRING"},{"schema":{"basic":"0","belongs":"yidongduanzhucongco",'
                    r'"controlledFields":"{\"required_rule\":[],\"unchangeable_rule\":[],\"displayable_rule\":[]}",'
                    r'"created_time":"2017-03-09 11:13:12","creator":"ApiTest","datasource":"","expression":"0",'
                    r'"expression_fields":"[]","formIndex":"","id":"last_modified","index":"3","last_modified":"2017-03-09 11:13:12",'
                    r'"mainField":"0","metadata":"[]","modifier":"ApiTest","relationControlFields":"[]","relationMapFields":"[]",'
                    r'"relationSearchFields":"[]","report":"","required":"0","systemTime":"","title":"最后修改时间","type":"system",'
                    r'"unique":"0"},"table_id":"yidongduanzhucongco","table_title":"移动端主从-从表","table_type":"",'
                    r'"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"",'
                    r'"last_modified":"","modified_method":"","modifier":"","owner":"","value":""},"workProviderType":"STRING"},'
                    r'{"schema":{"basic":"0","belongs":"yidongduanzhucongco","controlledFields":"{\"required_rule\":[],'
                    r'\"unchangeable_rule\":[],\"displayable_rule\":[]}","created_time":"2017-03-09 11:13:12","creator":"ApiTest",'
                    r'"datasource":"","expression":"0","expression_fields":"[]","formIndex":"","id":"modified_method","index":"4",'
                    r'"last_modified":"2017-03-09 11:13:12","mainField":"0","metadata":"[]","modifier":"ApiTest",'
                    r'"relationControlFields":"[]","relationMapFields":"[]","relationSearchFields":"[]","report":"","required":"0",'
                    r'"systemTime":"","title":"修改方法","type":"system","unique":"0"},"table_id":"yidongduanzhucongco",'
                    r'"table_title":"移动端主从-从表","table_type":"","value":{"access_button":"","access_changeable":false,'
                    r'"access_deleteable":false,"access_readable":true,"id":"","last_modified":"","modified_method":"","modifier":"",'
                    r'"owner":"","value":""},"workProviderType":"STRING"},{"schema":{"basic":"0","belongs":"yidongduanzhucongco",'
                    r'"controlledFields":"{\"required_rule\":[],\"unchangeable_rule\":[],\"displayable_rule\":[]}",'
                    r'"created_time":"2017-03-09 11:13:12","creator":"ApiTest","datasource":"","expression":"0",'
                    r'"expression_fields":"[]","formIndex":"","id":"owner","index":"5","last_modified":"2017-03-09 11:13:12",'
                    r'"mainField":"0","metadata":"[]","modifier":"ApiTest","relationControlFields":"[]","relationMapFields":"[]",'
                    r'"relationSearchFields":"[]","report":"","required":"0","systemTime":"","title":"记录拥有者","type":"system",'
                    r'"unique":"0"},"table_id":"yidongduanzhucongco","table_title":"移动端主从-从表","table_type":"",'
                    r'"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"",'
                    r'"last_modified":"","modified_method":"","modifier":"","owner":"","value":""},"workProviderType":"STRING"},'
                    r'{"schema":{"basic":"0","belongs":"yidongduanzhucongco","controlledFields":"{\"required_rule\":[],'
                    r'\"unchangeable_rule\":[],\"displayable_rule\":[]}","created_time":"2017-03-09 11:29:51","creator":"ApiTest",'
                    r'"datasource":"","expression":"0","expression_fields":"[]","formIndex":"","id":"biaoti","index":"6",'
                    r'"last_modified":"2017-03-09 11:29:51","mainField":"0","metadata":"{\"tips\":\"\",\"autocomplete\":\"0\",'
                    r'\"validate\":{\"rule\":\"\"},\"changeable\":\"1\",\"required\":\"0\",\"displayable\":\"1\"}","modifier":"ApiTest",'
                    r'"relationControlFields":"[]","relationMapFields":"[]","relationSearchFields":"[]","report":"","required":"0",'
                    r'"systemTime":"","title":"标题","type":"string","unique":"0"},"table_id":"yidongduanzhucongco",'
                    r'"table_title":"移动端主从-从表","table_type":"","value":{"access_button":"","access_changeable":true,'
                    r'"access_deleteable":false,"access_readable":true,"id":"","last_modified":"","modified_method":"","modifier":"","owner":"",'
                    r'"value":"从表新增测试"},"workProviderType":"STRING"}]}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/data/workflow/submitslave', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP流程新增从表记录')
