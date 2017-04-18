/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.ac;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * <pre>
 * 操作员个性配置
 * 模型文件 ： /Users/megapro/Develop/tis/tools/tools-core/model/ABF-mysql.erm
 * 业务域：ac
 * 模型：AC_OPERATOR_CONFIG 操作员个性配置
 *
 * 操作员个性化配置
如颜色配置
    登录风格
    是否使用重组菜单
    默认身份
    等

“操作员＋应用系统”，将配置按应用系统进行区分。
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class AcOperatorConfig implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述： */
	private String guidOperator ;
	
	/** 字段类型：varchar<br/>字段名：应用GUID<br/>描述： */
	private String guidApp ;
	
	/** 字段类型：varchar<br/>字段名：配置类型<br/>描述：见业务字典： DICT_AC_CONFIGTYPE */
	private String configType ;
	
	/** 字段类型：varchar<br/>字段名：配置名<br/>描述： */
	private String configName ;
	
	/** 字段类型：varchar<br/>字段名：配置值<br/>描述： */
	private String configValue ;
	
	/** 字段类型：char<br/>字段名：是否启用<br/>描述：见业务菜单： DICT_YON */
	private String isvalid ;
	
	
	/**
	 * Set the 数据主键.
	 * 
	 * @param guid
	 *            数据主键
	 */
	public void setGuid(String guid) {
 		this.guid = guid == null ? null : guid.trim() ;
    }
    
    /**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuid(){
		return this.guid ;
    }
	
	/**
	 * Set the 数据主键.
	 * 
	 * @param guidOperator
	 *            数据主键
	 */
	public void setGuidOperator(String guidOperator) {
 		this.guidOperator = guidOperator == null ? null : guidOperator.trim() ;
    }
    
    /**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuidOperator(){
		return this.guidOperator ;
    }
	
	/**
	 * Set the 应用GUID.
	 * 
	 * @param guidApp
	 *            应用GUID
	 */
	public void setGuidApp(String guidApp) {
 		this.guidApp = guidApp == null ? null : guidApp.trim() ;
    }
    
    /**
	 * Get the 应用GUID.
	 * 
	 * @return 应用GUID
	 */
	public String getGuidApp(){
		return this.guidApp ;
    }
	
	/**
	 * Set the 配置类型.
	 * 
	 * @param configType
	 *            配置类型
	 */
	public void setConfigType(String configType) {
 		this.configType = configType == null ? null : configType.trim() ;
    }
    
    /**
	 * Get the 配置类型.
	 * 
	 * @return 配置类型
	 */
	public String getConfigType(){
		return this.configType ;
    }
	
	/**
	 * Set the 配置名.
	 * 
	 * @param configName
	 *            配置名
	 */
	public void setConfigName(String configName) {
 		this.configName = configName == null ? null : configName.trim() ;
    }
    
    /**
	 * Get the 配置名.
	 * 
	 * @return 配置名
	 */
	public String getConfigName(){
		return this.configName ;
    }
	
	/**
	 * Set the 配置值.
	 * 
	 * @param configValue
	 *            配置值
	 */
	public void setConfigValue(String configValue) {
 		this.configValue = configValue == null ? null : configValue.trim() ;
    }
    
    /**
	 * Get the 配置值.
	 * 
	 * @return 配置值
	 */
	public String getConfigValue(){
		return this.configValue ;
    }
	
	/**
	 * Set the 是否启用.
	 * 
	 * @param isvalid
	 *            是否启用
	 */
	public void setIsvalid(String isvalid) {
 		this.isvalid = isvalid == null ? null : isvalid.trim() ;
    }
    
    /**
	 * Get the 是否启用.
	 * 
	 * @return 是否启用
	 */
	public String getIsvalid(){
		return this.isvalid ;
    }
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this) ; 
	}
}