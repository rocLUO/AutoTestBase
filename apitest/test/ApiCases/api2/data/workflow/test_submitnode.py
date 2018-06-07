#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 3:43
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''APP流程提交
           应用访问地址：/app/!/workflow/WeiTuoYongLiYi
           平台应用场景：APP流程提交
        '''
        params = {
            'workflowId': 'WeiTuoYongLiYi'
        }
        nowlogin = Login().login('admin')  # 登录系统
        # APP获取流程实例ID
        sendrequest1 = nowlogin.get(Login().url + '/api2/data/workflow/newflowinstance', params=params)
        getinstanceid = sendrequest1.json()['node']['instance_id']
        strinstanceid = '"' + str(getinstanceid) + '"'
        # APP提交流程
        values = {
            'data': r'{"button":"","fields":[{"schema":{"basic":"0","belongs":"wtmaincase01","controlledFields":"{\"required_rule\":[],'
                    r'\"unchangeable_rule\":[],\"displayable_rule\":[]}","created_time":"2016-12-08 20:15:19","creator":"ApiTest",'
                    r'"datasource":"","expression":"0","expression_fields":"[]","formIndex":"","id":"weituoceshi","index":"6",'
                    r'"last_modified":"2016-12-08 20:15:26","mainField":"0","metadata":"{\"tips\":\"\",\"autocomplete\":\"0\",'
                    r'\"validate\":{\"tips\":\"\",\"rule\":\"\"},\"changeable\":\"1\",\"required\":\"1\",\"displayable\":\"1\"}",'
                    r'"modifier":"ApiTest","relationControlFields":"[]","relationMapFields":"[]","relationSearchFields":"[]",'
                    r'"report":"","required":"1","systemTime":"","title":"委托测试","type":"string","unique":"0"},'
                    r'"table_id":"wtmaincase01","table_title":"wt_main_case01","table_type":"0","value":{"access_button":"",'
                    r'"access_changeable":true,"access_deleteable":false,"access_readable":true,"id":"","last_modified":"",'
                    r'"modified_method":"","modifier":"","owner":"","value":"流程提交"},"workProviderType":"STRING"}],'
                    r'"instance_id":' + strinstanceid + ','
                                                        r'"is_current_node":true,"listen_form_fields":[],'
                                                        r'"next_step":"{\"WeiTuoYongLiYi_WorkNode_2\":{\"AssignedMethod\":\"solo\",\"Type\":\"general\",\"Valid\":false,'
                                                        r'\"ExecutorMethod\":\"all\",\"Condition\":[],\"AssignedMethods\":\"automatic\",'
                                                        r'\"Deadline\":{\"timeout\":{\"nextnode\":\"\",\"remind\":\"\",\"select\":\"remind\",\"checked\":true,'
                                                        r'\"end\":\"\"},\"deadline_able\":false,\"expired_remain\":3,\"deadline_type\":\"fixedTime\",\"deadline\":604800,'
                                                        r'\"expired_able\":true,\"expired_remain_unit\":\"day\"},\"Executor\":{\"defaultExecutor\":\"1\",\"records\":[],'
                                                        r'\"anonymous\":\"0\",\"autoSearch\":\"0\"},\"NodeId\":\"WorkNode_2\",\"ConditionLogic\":\"and\",'
                                                        r'\"needAssign\":false,\"Label\":\"委托审核\"}}","node_id":"WorkNode_1","node_name":"委托填写",'
                                                        r'"node_next_user":[{"AssignedMethods":"manual","AssignedTo":[{"Type":"member","id":"UIDdulei","parent_id":"7",'
                                                        r'"name":["产品测试组","组员","杜磊"],"type":"member","parent":"7","Parent":"7"}],"isDraft":true,'
                                                        r'"node_id":"WorkNode_2","node_name":"委托审核","workflow_id":"WeiTuoYongLiYi"}],"slaves":[],'
                                                        r'"users":[{"user_id":"ApiTest","user_name":"企业管理员"}],"workflow_id":"WeiTuoYongLiYi"}'
        }
        sendrequest = nowlogin.post(Login().url + '/api2/data/workflow/submitnode', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP流程提交')
