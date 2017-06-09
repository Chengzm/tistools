/**
 * 
 */
package org.tools.design.test.ac;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.model.po.ac.AcApp;
import org.tis.tools.rservice.ac.capable.IAppRService;
import org.tools.design.SpringJunitSupport;

/**
 * 
 * 单元测试：测试AC权限管理（Appliction）概念对象的管理服务功能
 * 
 * @author megapro
 * 
 */
public class AppRServiceTest extends SpringJunitSupport{
	
	@Autowired
	IAppRService appRService;
	
	/*
	 * 测试数据: 生成应用代码所需的数据
	 */
	private static String appCode = "APP0001"; //应用代码
	private static String appName = "ZZC" ; //应用名称
	private static String appType = "local" ; //应用类型
	private static String appDesc = "zzc" ; //描述
	private static String isOpen = "Y" ; //是否开通
	private static String openDate = "2017/06/06" ; //开通时间
	private static String url = "http://www.baidu.com/appserver" ; //地址
	private static String ipAddr = "127.0.0.1" ; //IP地址
	private static String ipPort = "8083" ; //IP端口
	
	
	@Before
	public void before(){
		//增加应用数据
	
	}
	
	@After
    public void after(){
//		sysDictRService.delete(null);
		
    }
	
	/**
	 * <pre>
	 * 案例1:生成应用代码成功
	 * 判断：应用代码满足既定规则
	 * 应用代码规则：
	 * 1.共7位；
	 * 2.组成结构：  应用类型(三位) + 序号(四位)
	 * </pre>
	 */
	@Test
	public void genAppCodeSucc() {
		
		AcApp app = appRService.createAcApp(appCode, appName, appType, appDesc, isOpen, openDate, url, ipAddr, ipPort);
		Assert.assertNotNull("创建APP成功",app);
		Assert.assertEquals("返回的代码应该相等","APP0001", app.getGuid());		
	}
	
	/**
	 * 案例2:生成应用代码失败，缺少所需的业务字典
	 */
	@Test
	public void genFailureCase() {
		
	}
	
	
	
	
	
}
