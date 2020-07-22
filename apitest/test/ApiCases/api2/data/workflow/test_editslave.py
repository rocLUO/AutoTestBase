#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 上午 11:53
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_Put(self):
        '''【APP】流程从表记录编辑
           应用访问地址：/app/!/workflow/YiDongDuanZhuCong
           平台应用场景：APP流程从表记录编辑
        '''
        values = {
            'recordId': 1,
            'instanceId': 49,
            'nodeId': 'WorkNode_1',
            'workflowId': 'YiDongDuanZhuCong',
            'subordinate_id': 'yidongduanzhucongco',
            'data': '{"subordinateId":"yidongduanzhucongco","subordinateKeyColumn":"","subordinateName":"移动端主从-从表",'
                    '"subordinate_item_fields":[{"schema":{"basic":"","belongs":"","controlledFields":"","created_time":"",'
                    '"creator":"","datasource":"","expression":"","expression_fields":"","formIndex":"","id":"id",'
                    '"index":"","last_modified":"","mainField":"","metadata":"","modifier":"","relationControlFields":"",'
                    '"relationMapFields":"","relationSearchFields":"","report":"","required":"","systemTime":"","title":"",'
                    '"type":"","unique":""},"table_id":"","table_title":"","table_type":"","value":{"access_button":"",'
                    '"access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"","last_modified":"",'
                    '"modified_method":"workflow/YiDongDuanZhuCong/49/WorkNode_1","modifier":"","owner":"","value":"1"},'
                    '"workProviderType":"STRING"},{"schema":{"basic":"","belongs":"","controlledFields":"",'
                    '"created_time":"","creator":"","datasource":"","expression":"","expression_fields":"","formIndex":"",'
                    '"id":"owner","index":"","last_modified":"","mainField":"","metadata":"","modifier":"",'
                    '"relationControlFields":"","relationMapFields":"","relationSearchFields":"","report":"","required":"",'
                    '"systemTime":"","title":"","type":"","unique":""},"table_id":"","table_title":"","table_type":"",'
                    '"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,'
                    '"id":"","last_modified":"","modified_method":"workflow/YiDongDuanZhuCong/49/WorkNode_1","modifier":"",'
                    '"owner":"","value":"ApiTest"},"workProviderType":"STRING"},{"schema":{"basic":"","belongs":"",'
                    '"controlledFields":"","created_time":"","creator":"","datasource":"","expression":"",'
                    '"expression_fields":"","formIndex":"","id":"modifier","index":"","last_modified":"","mainField":"","metadata":"",'
                    '"modifier":"","relationControlFields":"","relationMapFields":"","relationSearchFields":"","report":"","required":"",'
                    '"systemTime":"","title":"","type":"","unique":""},"table_id":"","table_title":"","table_type":"",'
                    '"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"",'
                    '"last_modified":"","modified_method":"workflow/YiDongDuanZhuCong/49/WorkNode_1","modifier":"","owner":"",'
                    '"value":"ApiTest"},"workProviderType":"STRING"},{"schema":{"basic":"","belongs":"","controlledFields":"",'
                    '"created_time":"","creator":"","datasource":"","expression":"","expression_fields":"","formIndex":"",'
                    '"id":"last_modified","index":"","last_modified":"","mainField":"","metadata":"","modifier":"",'
                    '"relationControlFields":"","relationMapFields":"","relationSearchFields":"","report":"","required":"",'
                    '"systemTime":"","title":"","type":"","unique":""},"table_id":"","table_title":"","table_type":"",'
                    '"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"",'
                    '"last_modified":"","modified_method":"workflow/YiDongDuanZhuCong/49/WorkNode_1","modifier":"","owner":"",'
                    '"value":"2017-03-09 14:54:06"},"workProviderType":"STRING"},{"schema":{"basic":"","belongs":"",'
                    '"controlledFields":"","created_time":"","creator":"","datasource":"","expression":"","expression_fields":"",'
                    '"formIndex":"","id":"modified_method","index":"","last_modified":"","mainField":"","metadata":"","modifier":"",'
                    '"relationControlFields":"","relationMapFields":"","relationSearchFields":"","report":"","required":"",'
                    '"systemTime":"","title":"","type":"","unique":""},"table_id":"","table_title":"","table_type":"",'
                    '"value":{"access_button":"","access_changeable":false,"access_deleteable":false,"access_readable":true,"id":"",'
                    '"last_modified":"","modified_method":"workflow/YiDongDuanZhuCong/49/WorkNode_1","modifier":"","owner":"",'
                    '"value":"workflow/YiDongDuanZhuCong/49/WorkNode_1"},"workProviderType":"STRING"},{"schema":{"basic":"",'
                    '"belongs":"","controlledFields":"","created_time":"","creator":"","datasource":"","expression":"",'
                    '"expression_fields":"","formIndex":"","id":"biaoti","index":"","last_modified":"","mainField":"","metadata":"",'
                    '"modifier":"","relationControlFields":"","relationMapFields":"","relationSearchFields":"","report":"",'
                    '"required":"","systemTime":"","title":"","type":"","unique":""},"table_id":"","table_title":"","table_type":"",'
                    '"value":{"access_button":"","access_changeable":true,"access_deleteable":false,"access_readable":true,"id":"",'
                    '"last_modified":"","modified_method":"workflow/YiDongDuanZhuCong/49/WorkNode_1","modifier":"","owner":"",'
                    '"value":"编辑从表记录新"},"workProviderType":"STRING"}],"subordinate_item_id":"1"}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/data/workflow/editsubordinate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP流程从表记录编辑')  # 断言(检查返回值status是否为1200)
