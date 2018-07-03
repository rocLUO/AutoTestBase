*************************2018.5.24
优化驱动传参,各方法可不再封装至单例脚本中,方法全部封装在 AppBase.java中
demo使用 test_pre0502
----------------------
试用 关键字驱动 功能,主要对excel读写操作试用jxl和poi两种框架
目前倾向于试用poi,暂于demo阶段.框架思路见wiki

*************************2018.5.18
create /com.test_project/test_pre0502
优化AppBase方法库使用.传参优化完成
在test_pre0502类中不再伴随测试方法,使用AppBase类库方法,参数引用本地

*************************2018.4.20
加入qycloudWebTest 项目工程.支持对web进行自动化测试.依赖selenium框架进行
目前测试工程结构与android一致.
demo版本.等待后续完善模板内容,与参数封装引导

*************************2018.4.18

case1模板中注释了原截图方法.
增加新截图方法与其嵌套.
同事在appbase中留有基础备份.因drivri问题方法全部保留各用例中.减少因传参出现问题.
后续各用例参数变量应使用privrite.
TestInfo测试suit参数配置变量全局使用

*************************2018.4.17

reportNg版本依赖从1.14更新为1.16
修改reportNG源码.修改其报告输出内容,优化报告显示效果
增加饼状图显示
增加log print 输出显示
------
textprint输出修改为Report输出
测试模板case1操作使用方法输出.伴随日志打印
推荐使用case1为测试脚本模板使用

*************************2018.4.16
目前使用appiumTest 工程.需要配置本地jar依赖
本次更新将testbase/Activity.java 改名为TestInfo.java
将测试脚本配置信息归于TestInfo配置.提高多脚本suit运行配置xiaolv
添加多个测试方法.添加对坐标操作方法,
并将snapscreen与textprint等通用方法写入叫脚本内
将测试等待时间参数化.封装与脚本头部
工程内创建testngdemo文件验证reportNg报告输出效果.勿动

*************************2018.3.29
目前使用appiumTest工程.需要配置本地jar依赖
需要自行在src目录下创建package.并以自己名字命名.
可参考名为testcase的package下的case类语法与结构模板进行编写测试脚本
TestBase的package下有包含public method的AppBase类,以及包含qycloud基础控件参数的ActivityBase类
请不要对这两个类编辑.
具体是使用与配置文档,可参考:http://jira.aysaas.com:8766/pages/viewpage.action?pageId=6271974&moved=true
  
AppTest为使用maven的工程.不需要配置本地jar依赖
但目前对关联方法的配置依然需要优化,故目前不推荐使用.其中内容与appiumTest工程一致