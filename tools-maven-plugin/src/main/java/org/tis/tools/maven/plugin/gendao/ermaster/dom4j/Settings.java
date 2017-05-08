/**
 * 
 */
package org.tis.tools.maven.plugin.gendao.ermaster.dom4j;

import java.util.ArrayList;
import java.util.List;

/**
 * ERMaster定义文件中的settings对象
 * @author megapro
 *
 */
public class Settings {

	private String dataBase ; 
	
	private String capital ; 
	
	/**
	 * 生成代码所在的package包路径,会被映射为BizModel的主包路径
	 */
	private String packageName ; 
	
	private String srcFileEncoding ; 
	
	/**
	 * 模型分类
	 */
	private List<Category> categories = new ArrayList<Category>();
	
	/**
	 * 模型属性
	 */
	private List<ModelProperty> modelProperties = new ArrayList<ModelProperty>();
	
	
	public String getSrcFileEncoding() {
		return srcFileEncoding;
	}

	public void setSrcFileEncoding(String srcFileEncoding) {
		this.srcFileEncoding = srcFileEncoding;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDataBase() {
		return dataBase;
	}

	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}
	
	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public List<ModelProperty> getModelProperties() {
		return modelProperties;
	}

	public void setModelProperties(List<ModelProperty> modelProperties) {
		this.modelProperties = modelProperties;
	}
	
	public void addModelProperty(ModelProperty mp ){
		
		if( this.modelProperties.contains(mp)){
			return ; //过滤重复
		}
		this.modelProperties.add(mp) ;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	public void addCategoriy(Category c){
		
		if( this.categories.contains(c) ){
			return ;//过滤重复
		}
		
		this.categories.add(c) ;
	}

	@Override
	public String toString() {
		return "Settings [dataBase=" + dataBase + ", capital=" + capital + ", packageName=" + packageName
				+ ", srcFileEncoding=" + srcFileEncoding + ", categories=" + categories + ", modelProperties="
				+ modelProperties + "]";
	}
}
