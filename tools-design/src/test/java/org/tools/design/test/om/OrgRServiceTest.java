/**
 * 
 */
package org.tools.design.test.om;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.exception.ToolsRuntimeException;
import org.tis.tools.model.po.om.OmOrg;
import org.tis.tools.rservice.om.capable.IOrgRService;
import org.tools.design.SpringJunitSupport;

/**
 * 
 * 单元测试：测试OM组织模块中机构（Organization）概念对象的管理服务功能
 * 
 * @author megapro
 * 
 */
public class OrgRServiceTest extends SpringJunitSupport{
	
	@Autowired
	IOrgRService orgRService;
	
//	@Autowired
//	IDictRService sysDictRService ;
//
//	@Autowired
//	ISysDictItemRService sysDictItemRService ;
	
	
	
	/*
	 * 测试数据: 生成机构代码所需的数据
	 */
	/*private static String orgDegree = "0"; //机构等级
	private static String areaCode = "" ; //区域代码
	private static String orgType = "" ; //机构类型
	
	// 对表 SYS_DICT 清理的条件
	private WhereCondition wcSysDict = new WhereCondition() ; 
	// 对表 SYS_DICT_ITEM 清理的条件
	private WhereCondition wcSysDictItem = new WhereCondition() ; 
	
	@Before
	public void before(){
		//增加业务字典:机构等级
		SysDict dictOrgDegree = new SysDict() ; 
		dictOrgDegree.setGuid(SequenceSimpleUtil.instance.GUID("TEST_SYSDICT"));
		dictOrgDegree.setDictKey("DICT_OM_ORGDEGREE");
		dictOrgDegree.setDictType("A");
		sysDictRService.insert(dictOrgDegree);
		wcSysDict.andIn(SysDict.COLUMN_GUID, dictOrgDegree.getGuid());
		
		//增加业务字典项目
		SysDictItem itemOrgDegree = new SysDictItem() ; 
		itemOrgDegree.setGuid(SequenceSimpleUtil.instance.GUID("TEST_SYSDICT_ITEM"));
		itemOrgDegree.setGuidDict(dictOrgDegree.getGuid());
		itemOrgDegree.setItemName("总行");
		itemOrgDegree.setItemValue("0");
		itemOrgDegree.setSendValue("BS");
		sysDictItemRService.insert(itemOrgDegree);
		wcSysDictItem.andIn(SysDictItem.COLUMN_GUID, itemOrgDegree.getGuid()) ;
		
		//增加业务字典:地区代码
		SysDict dictAreaCode = new SysDict() ; 
		dictAreaCode.setGuid(SequenceSimpleUtil.instance.GUID("TEST_SYSDICT"));
		dictAreaCode.setDictKey("DICT_SD_AREA");
		dictAreaCode.setDictType("A");
		sysDictRService.insert(dictAreaCode);
		wcSysDict.andIn(SysDict.COLUMN_GUID, dictAreaCode.getGuid());
		
		//增加业务字典项目
		SysDictItem itemOrgArea = new SysDictItem() ; 
		itemOrgArea.setGuid(SequenceSimpleUtil.instance.GUID("TEST_SYSDICT_ITEM"));
		itemOrgArea.setGuidDict(dictAreaCode.getGuid());
		itemOrgArea.setItemName("上海");
		itemOrgArea.setItemValue("021");
		itemOrgArea.setSendValue("021");
		sysDictItemRService.insert(itemOrgArea);
		wcSysDictItem.andIn(SysDictItem.COLUMN_GUID, itemOrgArea.getGuid()) ;
	}
	
	@After
    public void after(){
		sysDictRService.deleteByCondition(wcSysDict);
		sysDictItemRService.deleteByCondition(wcSysDictItem);
    }
	
	*//**
	 * <pre>
	 * 案例1:生成机构代码成功
	 * 判断：机构代码满足既定规则
	 * 机构代码规则：
	 * 1.共10位；
	 * 2.组成结构： 机构等级(两位) + 地区码(三位) + 序号(五位)
	 * </pre>
	 *//*
	@Test
	public void genOrgCodeSucc() {
		
		//调用生成机构代码
		String orgCodeStr = orgRService.genOrgCode(areaCode, orgDegree, orgType) ;
		
		Assert.assertNotNull("成功生成机构代码不能为空", orgCodeStr);
		Assert.assertEquals("机构代码共10位",10, orgCodeStr.length());
		Assert.assertEquals("前两位是机构等级",orgCodeStr.substring(0, 2), orgDegree);
		Assert.assertEquals("三四五位是地区码",orgCodeStr.substring(3, 5), areaCode);
		
	}
	
	*//**
	 * 案例2:生成机构代码失败，缺少所需的业务字典
	 *//*
	@Test
	public void genFailureCase() {
		
	}*/

	@Test
	public void copyOrg() throws ToolsRuntimeException {
		try {
			String copyCode = "ORGBS01000016";
			OmOrg omOrg = orgRService.copyOrg(copyCode);
			System.out.println(omOrg);
		} catch (ToolsRuntimeException e) {
			System.out.println("错误码：" + e.getCode());
			System.out.println("错误信息：" + e.getMessage());
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	
}
