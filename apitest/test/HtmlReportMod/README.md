[说明]
=========================

```
[如何使用]
=========================
一、TMLTestRunnerCN  使用 
--------------------------
import HTMLTestRunnerCN

if __name__ == '__main__':
    #确定生成报告的路径
    filePath =r'D:\PythonWorkspace\pythontest\Python\reportdir\report.html'
    fp = open(filePath,'wb')
    #生成报告的Title,描述
    runner = HTMLTestRunnerCN.HTMLTestReportCN(
        stream=fp,
        title='自动化测试报告',
        #description='详细测试用例结果',
        tester='Findyou'
        )
```
