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
 * 功能操作行为
 * 模型文件 ： D:\tistools\tools-core-basic\model\ABF-mysql.erm
 * 业务域：ac
 * 模型：AC_FUNC_BHV 功能操作行为
 *
 * Behavior（BHV）操作行为，权限控制模块中最细粒度的授权、控制单位；一个功能中包括多个操作行为（operate behavior）；
如：
一个柜面交易功能，其中操作行为有 —— 打开交易、提交交易、取消交易、暂存交易....。
一个营销功能，操作行为有—— 展示营销信息、推介营销、收集营销反馈、....
某个功能的操作权限认定标识格式为： 功能:操作行为
如：TX001交易的提交权限认定标识为 TX001:commit，TX001:hold 则表示对TX001的暂存操作，也可以使用通配符， TX001:* 表示对TX001的所有操作行为
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class AcFuncBhv implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 对应的数据库表名称 */
	public static final String TABLE_NAME = "AC_FUNC_BHV" ; 
	/* AC_FUNC_BHV table's columns definition */
	/** GUID ：数据主键<br/><br/>全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	public static final String COLUMN_GUID = "guid" ; 
	/** GUID_FUNC ：功能GUID<br/><br/> */
	public static final String COLUMN_GUID_FUNC = "guid_func" ; 
	/** GUID_BHV ：行为GUID<br/><br/> */
	public static final String COLUMN_GUID_BHV = "guid_bhv" ; 
	/** ISEFFECTIVE ：是否有效<br/><br/>见业务字典： DICT_YON Y 有效（默认都是有效的操作行为） N 无效 */
	public static final String COLUMN_ISEFFECTIVE = "iseffective" ; 
	/** 对应的类名 */
	public static final String CLASS_NAME = "org.tis.tools.model.po.ac.AcFuncBhv";
    /** GUID字段名<br/> */
    public static final String NAME_GUID = "数据主键" ;
    /** GUID_FUNC字段名<br/> */
    public static final String NAME_GUID_FUNC = "功能GUID" ;
    /** GUID_BHV字段名<br/> */
    public static final String NAME_GUID_BHV = "行为GUID" ;
    /** ISEFFECTIVE字段名<br/> */
    public static final String NAME_ISEFFECTIVE = "是否有效" ;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：功能GUID<br/>描述： */
	private String guidFunc ;
	
	/** 字段类型：varchar<br/>字段名：行为GUID<br/>描述： */
	private String guidBhv ;
	
	/** 字段类型：char<br/>字段名：是否有效<br/>描述：见业务字典： DICT_YON Y 有效（默认都是有效的操作行为） N 无效 */
	private String iseffective ;

	/**
	* Default Constructor
	*/
	public AcFuncBhv() {
	}

	
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
	 * Set the 功能GUID.
	 * 
	 * @param guidFunc
	 *            功能GUID
	 */
	public void setGuidFunc(String guidFunc) {
 		this.guidFunc = guidFunc == null ? null : guidFunc.trim() ;
    }
    
    /**
	 * Get the 功能GUID.
	 * 
	 * @return 功能GUID
	 */
	public String getGuidFunc(){
		return this.guidFunc ;
    }
	
	/**
	 * Set the 行为GUID.
	 * 
	 * @param guidBhv
	 *            行为GUID
	 */
	public void setGuidBhv(String guidBhv) {
 		this.guidBhv = guidBhv == null ? null : guidBhv.trim() ;
    }
    
    /**
	 * Get the 行为GUID.
	 * 
	 * @return 行为GUID
	 */
	public String getGuidBhv(){
		return this.guidBhv ;
    }
	
	/**
	 * Set the 是否有效.
	 * 
	 * @param iseffective
	 *            是否有效
	 */
	public void setIseffective(String iseffective) {
 		this.iseffective = iseffective == null ? null : iseffective.trim() ;
    }
    
    /**
	 * Get the 是否有效.
	 * 
	 * @return 是否有效
	 */
	public String getIseffective(){
		return this.iseffective ;
    }
	
	public String toString(){
		return StringUtil.toString(this) ; 
	}
}