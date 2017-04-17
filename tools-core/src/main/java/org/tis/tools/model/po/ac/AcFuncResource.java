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
 * 功能资源对应
 * 模型文件 ： /Users/megapro/Develop/tis/tools/tools-core/model/ABF-mysql.erm
 * 业务域：ac
 * 模型：AC_FUNC_RESOURCE 功能资源对应
 *
 * 功能点包含的系统资源内容，如jsp、页面流、逻辑流等资源。
功能点对应实际的代码资源。
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class AcFuncResource implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：记录的全局性唯一ID，系统自动生成； */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述： */
	private String guidFunc ;
	
	/** 字段类型：varchar<br/>字段名：资源类型<br/>描述：见业务字典： DICT_AC_FUNCRESTYPE 如：JSP、页面流、逻辑流等 */
	private String resType ;
	
	/** 字段类型：varchar<br/>字段名：资源路径<br/>描述： */
	private String resPath ;
	
	/** 字段类型：varchar<br/>字段名：构件包名<br/>描述： */
	private String compackName ;
	
	/** 字段类型：varchar<br/>字段名：资源显示名称<br/>描述： */
	private String resShowName ;
	
	
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
	 * @param guidFunc
	 *            数据主键
	 */
	public void setGuidFunc(String guidFunc) {
 		this.guidFunc = guidFunc == null ? null : guidFunc.trim() ;
    }
    
    /**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuidFunc(){
		return this.guidFunc ;
    }
	
	/**
	 * Set the 资源类型.
	 * 
	 * @param resType
	 *            资源类型
	 */
	public void setResType(String resType) {
 		this.resType = resType == null ? null : resType.trim() ;
    }
    
    /**
	 * Get the 资源类型.
	 * 
	 * @return 资源类型
	 */
	public String getResType(){
		return this.resType ;
    }
	
	/**
	 * Set the 资源路径.
	 * 
	 * @param resPath
	 *            资源路径
	 */
	public void setResPath(String resPath) {
 		this.resPath = resPath == null ? null : resPath.trim() ;
    }
    
    /**
	 * Get the 资源路径.
	 * 
	 * @return 资源路径
	 */
	public String getResPath(){
		return this.resPath ;
    }
	
	/**
	 * Set the 构件包名.
	 * 
	 * @param compackName
	 *            构件包名
	 */
	public void setCompackName(String compackName) {
 		this.compackName = compackName == null ? null : compackName.trim() ;
    }
    
    /**
	 * Get the 构件包名.
	 * 
	 * @return 构件包名
	 */
	public String getCompackName(){
		return this.compackName ;
    }
	
	/**
	 * Set the 资源显示名称.
	 * 
	 * @param resShowName
	 *            资源显示名称
	 */
	public void setResShowName(String resShowName) {
 		this.resShowName = resShowName == null ? null : resShowName.trim() ;
    }
    
    /**
	 * Get the 资源显示名称.
	 * 
	 * @return 资源显示名称
	 */
	public String getResShowName(){
		return this.resShowName ;
    }
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this) ; 
	}
}