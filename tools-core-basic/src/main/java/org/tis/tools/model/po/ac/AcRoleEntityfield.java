/**
 * auto generated
 * Copyright (C) 2017 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.ac;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.tis.tools.common.utils.StringUtil;

/**
 * 
 * <pre>
 * 角色与实体属性关系
 * 模型文件 ： D:\tistools\tools-core-basic\model\ABF-mysql.erm
 * 业务域：ac
 * 模型：AC_ROLE_ENTITYFIELD 角色与实体属性关系
 *
 * 角色与实体字段（属性）的对应关系。
说明某个角色拥有哪些属性的操作权。
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class AcRoleEntityfield implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 对应的数据库表名称 */
	public static final String TABLE_NAME = "AC_ROLE_ENTITYFIELD" ; 
	/* AC_ROLE_ENTITYFIELD table's columns definition */
	/** GUID_ROLE ：角色GUID<br/><br/> */
	public static final String COLUMN_GUID_ROLE = "guid_role" ; 
	/** GUID_ENTITYFIELD ：拥有实体属性GUID<br/><br/> */
	public static final String COLUMN_GUID_ENTITYFIELD = "guid_entityfield" ; 
	/** ISMODIFY ：可修改<br/><br/>取值来自业务菜单： DICT_YON */
	public static final String COLUMN_ISMODIFY = "ismodify" ; 
	/** ISVIEW ：可查看<br/><br/>取值来自业务菜单： DICT_YON */
	public static final String COLUMN_ISVIEW = "isview" ; 
	/** 对应的类名 */
	public static final String CLASS_NAME = "org.tis.tools.model.po.ac.AcRoleEntityfield";
    /** GUID_ROLE字段名<br/> */
    public static final String NAME_GUID_ROLE = "角色GUID" ;
    /** GUID_ENTITYFIELD字段名<br/> */
    public static final String NAME_GUID_ENTITYFIELD = "拥有实体属性GUID" ;
    /** ISMODIFY字段名<br/> */
    public static final String NAME_ISMODIFY = "可修改" ;
    /** ISVIEW字段名<br/> */
    public static final String NAME_ISVIEW = "可查看" ;
	
	
	/** 字段类型：varchar<br/>字段名：角色GUID<br/>描述： */
	private String guidRole ;
	
	/** 字段类型：varchar<br/>字段名：拥有实体属性GUID<br/>描述： */
	private String guidEntityfield ;
	
	/** 字段类型：char<br/>字段名：可修改<br/>描述：取值来自业务菜单： DICT_YON */
	private String ismodify ;
	
	/** 字段类型：char<br/>字段名：可查看<br/>描述：取值来自业务菜单： DICT_YON */
	private String isview ;

	/**
	* Default Constructor
	*/
	public AcRoleEntityfield() {
	}

	
	/**
	 * Set the 角色GUID.
	 * 
	 * @param guidRole
	 *            角色GUID
	 */
	public void setGuidRole(String guidRole) {
 		this.guidRole = guidRole == null ? null : guidRole.trim() ;
    }
    
    /**
	 * Get the 角色GUID.
	 * 
	 * @return 角色GUID
	 */
	public String getGuidRole(){
		return this.guidRole ;
    }
	
	/**
	 * Set the 拥有实体属性GUID.
	 * 
	 * @param guidEntityfield
	 *            拥有实体属性GUID
	 */
	public void setGuidEntityfield(String guidEntityfield) {
 		this.guidEntityfield = guidEntityfield == null ? null : guidEntityfield.trim() ;
    }
    
    /**
	 * Get the 拥有实体属性GUID.
	 * 
	 * @return 拥有实体属性GUID
	 */
	public String getGuidEntityfield(){
		return this.guidEntityfield ;
    }
	
	/**
	 * Set the 可修改.
	 * 
	 * @param ismodify
	 *            可修改
	 */
	public void setIsmodify(String ismodify) {
 		this.ismodify = ismodify == null ? null : ismodify.trim() ;
    }
    
    /**
	 * Get the 可修改.
	 * 
	 * @return 可修改
	 */
	public String getIsmodify(){
		return this.ismodify ;
    }
	
	/**
	 * Set the 可查看.
	 * 
	 * @param isview
	 *            可查看
	 */
	public void setIsview(String isview) {
 		this.isview = isview == null ? null : isview.trim() ;
    }
    
    /**
	 * Get the 可查看.
	 * 
	 * @return 可查看
	 */
	public String getIsview(){
		return this.isview ;
    }
	
	public String toString(){
		return StringUtil.toString(this) ; 
	}
}