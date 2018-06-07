#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/28 0028 上午 9:29
# @Author  : Dulei
import unittest,os,sys,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_get_message(self):
        '''获取单个用户信息
           应用访问地址：/organization/manage
           平台应用场景：管理员编辑某个用户时触发
           用户：王聪明
        '''
        params = {
            'userid': 'Uwcm',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/user/message', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('王聪明', sendrequest.json()['real_name'], msg='【response】获取单个用户信息')

    def test_actionPOST(self):
        '''新增组织架构岗位/部门
           应用访问地址：/organization/manage
           平台应用场景：新增组织架构岗位/部门
           节点：董事长，新增“政府事业部”部门
        '''
        values = {
            'target_org_id': 12,
            'type': 'add',
            'units': '{"assign": {}, "base": [{"name": "政府事业部", "Type": "department", '
                     '"Parent": "12", "description": "", "iconSkin": "department","order": 8, "id": "12", "leader": ""}]}',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/organization/node/org', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['status'], msg='【response】新增组织架构岗位/部门')

    def test_actionPUT(self):
        '''修改组织架构岗位/部门
           应用访问地址：/organization/manage
           平台应用场景：修改组织架构岗位/部门
           节点：1000people修改
        '''
        values = {
            'target_org_id': 37,
            'type': 'update',
            'units': '{"assign": {}, "base": [{"name": "1000people", "Type": "role", "Parent": "36", "description": "", '
                     '"iconSkin": "role","order": "1", "id": "37", "leader": ""}]}',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/service_org/organization/node/org', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['status'], msg='【response】修改组织架构岗位/部门')

    def test_actionDELETE(self):
        '''删除组织架构岗位/部门
           应用访问地址：/organization/manage
           平台应用场景：删除组织架构岗位/部门
           节点：测试删除岗位.删除岗位
        '''
        values = {
            'type': 'del',
            'id': 32,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/service_org/organization/node/org', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['status'], msg='【response】删除组织架构岗位/部门')

    def test_sortPUT(self):
        '''组织架构节点排序
           应用访问地址：/organization/manage
           平台应用场景：组织架构管理列表页面左侧岗位部门拖动时触发
           拖动岗位、部门：3000people与4000people交换位置
        '''
        values = {
            'units': '[{"id":"37","name":"1000people","Type":"role","Parent":"36","description":"","order":1},'
                     '{"id":"39","name":"2000people","Type":"role","Parent":"36","description":"","order":2},'
                     '{"id":"41","name":"4000people","Type":"role","Parent":"36","description":"","order":3},'
                     '{"id":"40","name":"3000people","Type":"role","Parent":"36","description":"","order":4}]',
            'type': 'sort',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/service_org/organization/node/sort', data=values)
        outputrequest(sendrequest, os.path.abspath(__file__), sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['status'], msg='【response】组织架构节点排序')

    def test_node_users(self):
        '''获取组织架构用户列表接口
           应用访问地址：/organization/manage
           平台应用场景：进入组织架构管理列表触发
        '''
        params = {
            'start': 0,
            'perPage': 15,
            'role_id': 1,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/node/users', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['result']['iTotalDisplayRecords'], msg='【response】获取组织架构用户列表接口')

    def test_info(self):
        '''获取组织架构树以及所有用户信息
           应用访问地址：/organization/manage
           平台应用场景：进入组织架构管理列表触发
        '''
        params = {
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/org/info', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json()['units'], msg='【response】获取组织架构树以及所有用户信息')

    def test_appoint(self):
        '''获取用户任命信息(岗位部门必须有直接上级点击编辑才会请求)
           应用访问地址：/organization/manage
           平台应用场景：岗位部门必须有直接上级点击编辑才会触发
           编辑岗位：产品测试组—组长
        '''
        params = {
            'vUserId': 'Uwcm',
            'vAppointId': 4,
            'vType': 'true',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/user/appoint', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['success'], msg='【response】获取用户任命信息')
        self.assertEqual('王聪明', sendrequest.json()['result']['vName'], msg='【response】获取用户任命信息')

    def test_extra(self):
        '''添加组织架构节点构扩展信息
           应用访问地址：/organization/manage
           平台应用场景：编辑或添加岗位部门时触发
           编辑部门：云平台研发部
        '''
        values = {
            'org_id': 2
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/organization/getextra', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('userbaseinfo', sendrequest.json()['tablename'], msg='【response】添加组织架构节点构扩展信息')

    def test_getnodes(self):
        '''获取组织架构节点
           应用访问地址：/role/authorization
           平台应用场景：角色分析授权新建角色弹框时触发
        '''
        params = {
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/popups/nodes', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json()[0], msg='【response】获取组织架构节点')

    def test_search_case01(self):
        '''组织架构树搜索人——(显示所有多选)
           应用访问地址：/app/!/information/ZuZhiJiaGouZiDuan
           平台应用场景：组织架构字段弹框搜索
           字段：所有多选
        '''
        values = {
            'text': 'mao',
            'type': 'all'
        }
        json = ["平台一组", "组长", "毛佳"]
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/organization/search', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(json, sendrequest.json()['result']['Umj']['25']['name'], msg='【response】组织架构树搜索人——(显示所有多选)')

    def test_search_case02(self):
        '''组织架构树搜索——(显示部门岗位)
           应用访问地址：/app/!/information/ZuZhiJiaGouZiDuan
           平台应用场景：组织架构字段弹框搜索
           字段：部门岗位（多选）
        '''
        values = {
            'text': 'yun',
            'type': 'node'
        }
        json = ["云平台研发部"]
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/organization/search', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(json, sendrequest.json()['result']['2']['12']['name'], msg='【response】组织架构树搜索——(显示部门岗位)')

    def test_search_case03(self):
        '''组织架构树搜索——(显示姓名单选)
           应用访问地址：/app/!/information/ZuZhiJiaGouZiDuan
           平台应用场景：组织架构字段弹框搜索
           字段：所有单选
        '''
        values = {
            'text': 'mao',
            'type': 'user',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        json = ["平台一组", "组长", "毛佳"]
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/organization/search', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(json, sendrequest.json()['result']['Umj']['25']['name'], msg='【response】组织架构树搜索——(显示部门岗位)')

    def test_leader(self):
        '''组织架构获取用户上级领导
           应用访问地址：/organization/manage#!/2
           平台应用场景：编辑用户时触发
           编辑用户：袁凤
        '''
        params = {
            'user_id': 'Uyuanfeng',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/tree/leader', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('Uwcm', sendrequest.json()['leader']['user_id'], msg='【response】组织架构获取用户上级领导')

    def test_ValidateUserId(self):
        '''校验用户id是否存在
           应用访问地址：/organization/manage#!/2
           平台应用场景：新增用户填写用户ID后提交触发
        '''
        values = {
            'userid': 'Uzzc',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/organization/user/validate', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('error', sendrequest.json()['status'], msg='【status】校验用户id是否存在')

    def test_filter(self):
        '''组织架构弹框搜索用户
           平台应用场景：工作协同交办，选择组织架构弹框后搜索用户时触发
        '''
        values = {
            'limit': 20,
            'text': '杜',
            'd': '-1',
            'page': 1,
            'type': 'department',
            'user': ''
        }
        json = ['产品测试组', '组员', '杜磊']
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/organization/user/filter', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】组织架构弹框搜索用户')
        self.assertEqual(json, sendrequest.json()['users']['UIDdulei']['7']['name'], msg='【status】组织架构弹框搜索用户')

    def test_SaveNewEnterpriseUsers(self):
        '''组织架构新增用户
           应用访问地址：/organization/manage
           平台应用场景：管理员新建用户
           节点：平台一组——>组长——>组员
        '''
        values = {
            'target_org_id': 26,
            'usermessage[login_user_id]': 'LWED',
            'usermessage[real_name]': '王二大',
            'usermessage[password]': 11111111,
            'usermessage[birthday]': '1992-1-25',
            'usermessage[birth_type]': 0,
            'usermessage[entry]': '2016-06-11',
            'usermessage[phone]': '',
            'usermessage[email]': '464961613@qq.com',
            'usermessage[sex]': 0,
            'usermessage[isSecurity]': 'false',
            'usermessage[qq]': '79466132',
            'usermessage[ext]': '8003',
            'usermessage[idcard]': '320281199545202555',
            'usermessage[addr]': '南京',
            'usermessage[jobdesc]': '',
            'usermessage[main_job]': '云平台研发部-平台一组-组员',
            'userid': 'UWED',
            'mainjob': 26,
            'appointment': '[]',
            'extra_id': 33,
            'leader': '',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/organization/user/user', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('创建成功', sendrequest.json()['message'], msg='【status】组织架构新增用户')

    def test_EditUser(self):
        '''组织架构编辑用户
           应用访问地址：/organization/manage
           平台应用场景：管理员编辑用户
           编辑用户ID：utest08
        '''
        values = {
            'target_org_id': 37,
            'usermessage[login_user_id]': 'utest08',
            'usermessage[real_name]': 'test08',
            'usermessage[password]': '',
            'usermessage[birthday]': '2000-1-1',
            'usermessage[birth_type]': 0,
            'usermessage[entry]': '2017-06-16',
            'usermessage[phone]': '',
            'usermessage[email]': '100000007@qq.com',
            'usermessage[sex]': 0,
            'usermessage[isSecurity]': 'true',
            'usermessage[qq]': '79466132',
            'usermessage[ext]': '8003',
            'usermessage[idcard]': '320281199545202555',
            'usermessage[addr]': '南京',
            'usermessage[jobdesc]': '测试',
            'usermessage[main_job]': 'performance-1000people',
            'userid': 'utest08',
            'mainjob': 37,
            'appointment': '[{"user_id":"utest08","role_id":"2"}]',
            'leader': '',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/service_org/organization/user/user', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)

    def test_DisableUser(self):
        '''禁用用户
           应用访问地址：/organization/manage
           平台应用场景：管理员禁用用户
           禁用用户ID：Uryj
        '''
        values = {
            'userid': 'Uryj',
            'target_org_id': 1,
            'role_id': 9,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/service_org/organization/user/disable', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('该用户已被禁用！', sendrequest.json()['msg'], msg='【status】禁用用户')

    def test_ActivationUser(self):
        '''激活用户
           应用访问地址：/organization/manage
           平台应用场景：管理员激活用户
           禁用用户ID：Uryj
        '''
        values = {
            'userid': 'Uryj',
            'target_org_id': 1,
            'role_id': 9,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/service_org/organization/user/activation', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['status'], msg='【status】激活用户')

    def test_SaveAppointment(self):
        '''激活用户
           应用访问地址：/organization/manage
           平台应用场景：管理员激活用户
           禁用用户ID：Uryj
        '''
        values = {
            'target_org_id': 37,
            'userid': 'utest10',
            'appointment': '[{"user_id": "utest10", "role_id": "37"}, {"user_id": "utest10", "role_id": "2"}]',
            'oldMainJobId': 37,
            'mainJobName': '',
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/organization/user/appoint', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)

    def test_actionGet(self):
        '''弹框-获取组织架构用户
           应用访问地址：/user/setting#!/group/
           平台应用场景：个人设置，组织架构弹框点击部门触发
           点击部门：云平台研发部
        '''
        params = {
            'id': 2,
            'page': 1,
            'limit': 15,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/service_org/organization/popups/users', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】弹框-获取组织架构用户')

    def test_actionPost(self):
        '''弹框-获取组织架构用户(点击部门)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：工作协同交办组织架构弹框，点击部门触发
           点击部门：云平台研发部
        '''
        values = {
            'id': 2,
            'page': 1,
            'limit': 15,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/organization/popups/users', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】弹框-获取组织架构用户(点击部门)')

    def test_getOrgNodes(self):
        '''弹框-获取组织架构岗位部门节点
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：工作协同交办组织架构弹框时触发
        '''
        params = {
            'id': 2,
            'page': 1,
            'limit': 15,
            'entId': 'APICeShiQiYe',
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/organization/getOrgNodes', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json(), msg='【response】弹框-获取组织架构岗位部门节点')

    def test_parentsPost(self):
        '''弹框-获取组织架构用户(勾选部门)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：工作协同交办组织架构弹框，勾选部门触发
           勾选部门：云平台研发部
        '''
        values = {
            'nodes[0][id]': 2,
            'nodes[0][parent_id]': 12,
            'nodes[0][type]': 'department',
            'nodes[0][checked]': 'true',
            'nodes[0][name]': '云平台研发部'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/organization/orgtree/parents', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】弹框-获取组织架构用户(勾选部门)')
