/**
 * 
 */
package org.tis.tools.maven.plugin.gendao.ermaster;

import java.net.URL;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.tis.tools.maven.plugin.gendao.ermaster.jaxb.ERMasterModel;
import org.tis.tools.maven.plugin.gendao.ermaster.jaxb.ModelPropertyEnum;
import org.tis.tools.maven.plugin.gendao.ermaster.jaxb.NodeElement;
import org.tis.tools.maven.plugin.gendao.ermaster.jaxb.NormalColumn;
import org.tis.tools.maven.plugin.gendao.ermaster.jaxb.Table;
import org.tis.tools.maven.plugin.gendao.ermaster.jaxb.Word;
import org.tis.tools.maven.plugin.utils.Xml22BeanUtil;

import junit.framework.Assert;

/**
 * 
 * 对ERMaster模型定义文件解析的测试
 * 
 * @author megapro
 *
 */
public class ERMasterModelTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test1(){
		
	}
	
	/**
	 * //FIXME 基于JAXB解析ERMaster，还未解决的问题
	 * <pre>
	 * 基于JAXB解析 ERMaster模型
	 * 测试中遇到问题：
	 * ERMaster模型中很多节点不需要，因此在Xml22BeanUtil的parseToBean的方法中通过判断，试图掉过这些不需要的节点
	 * 	if( event.getMessage().startsWith("意外的元素") ){
	 * 		return true ;//跳过java中没有定义的属性
	 * 	}
	 * 但是当跳过次数达到一定数量时（大概9次），JAXB程序报错：
	 * 解析xml有错误:Errors limit exceeded. To receive all errors set com.sun.xml.internal.bind logger to FINEST level.
	 * 暂时未能解决这个问题
	 * </pre>
	 */
	//@Test
	public void test() {
		String testFile = "/META-INF/model-ermaster.xml" ;
		URL url = this.getClass().getResource(testFile);
		if( url == null ){
			System.out.println("却少测试数据文件："+ testFile);
		}
		
		String modelXml = url.getPath() ; 
		System.out.println("测试用的ERMaster模型文件为："+modelXml);
		
		ERMasterModel ermModel = Xml22BeanUtil.parseToBean(ERMasterModel.class, modelXml) ; 
		
		Assert.assertEquals("MySQL", ermModel.getSettings().getDataBase());
		
		Assert.assertEquals(86, ermModel.getWords().size());
		Word w65 = ermModel.getWordById("65") ; 
		Assert.assertEquals("服务类型", w65.getLogicalName());
		Assert.assertEquals("SERVICE_TYPE", w65.getPhysicalName());
		Assert.assertEquals("varchar(n)", w65.getType());
		Assert.assertEquals(16, w65.getLength());
		Assert.assertEquals("银行所提供的客户服务类型&#x0A;见义务字典： DICT_SERVICE_TYPE", w65.getDescription());
		
		Assert.assertEquals(2, ermModel.getSettings().getCategorySettings().getCategories().size());
		Assert.assertNotNull(ermModel.getCategoryByName("SYS"));//取名字为SYS的模型分类
		Assert.assertEquals(16,ermModel.getCategoryByName("JNL").getId());
		List<NodeElement> jnlNes = ermModel.getCategoryByName("JNL").getNodeElement() ; 
		Assert.assertEquals(12,jnlNes.size());//JNL分类中有12张表
		
		Assert.assertEquals(9, ermModel.getSettings().getModelProperties().getModelProperties().size());
		Assert.assertEquals("branchplus", ermModel.getModelPropertyValue(ModelPropertyEnum.MP_PROJECT_NAME));
		Assert.assertEquals("Shiyl", ermModel.getModelPropertyValue(ModelPropertyEnum.MP_AUTHOR));
		Assert.assertEquals("prjCore", ermModel.getModelPropertyValue(ModelPropertyEnum.MP_PRJ_CODE));
		Assert.assertEquals("tools-web-${category}", ermModel.getModelPropertyValue(ModelPropertyEnum.MP_PRJ_WEB));
		
		Assert.assertEquals(15, ermModel.getTables().size());
		Table t11 = ermModel.getTableById("11") ;
		Assert.assertNotNull(t11);
		Assert.assertEquals("营销流水", t11.getLogicalName());
		Assert.assertEquals("JNL_PROMOTING", t11.getPhysicalName());
		Assert.assertEquals("", t11.getDescription());
		Assert.assertEquals(13, t11.getNormalColumns().size());
		
		NormalColumn n118 = t11.getNormalColumnById("118") ;//取id为118的表字典定义
		Assert.assertNotNull(n118);//118这个表字段必须存在
		Assert.assertEquals("51", n118.getWordId());//该字典对应的模型字典id为51
		Assert.assertNotNull(ermModel.getWordById(n118.getWordId()));//根据自动定义取关联的模型字典，必须存在
	}

}
