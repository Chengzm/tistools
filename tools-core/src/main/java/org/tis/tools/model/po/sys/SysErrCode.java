/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.sys;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * <pre>
 * 错误码表
 * 模型文件 ： /Users/megapro/Develop/tis/tools/tools-core/model/ABF-mysql.erm
 * 业务域：sys
 * 模型：SYS_ERR_CODE 错误码表
 *
 * 记录系统中的各种错误代码信息，如系统抛出的错误信息，交易执行时的错误码等
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class SysErrCode implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier） */
	private String guid ;
	
	/** 字段类型：char<br/>字段名：错误代码分类<br/>描述：见业务字典： DICT_ERRCODE_KIND SYS 系统错误码 TRANS 交易错误码 */
	private String errcodeKind ;
	
	/** 字段类型：varchar<br/>字段名：错误代码<br/>描述： */
	private String errCode ;
	
	/** 字段类型：varchar<br/>字段名：错误信息<br/>描述： */
	private String errMsg ;
	
	
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
	 * Set the 错误代码分类.
	 * 
	 * @param errcodeKind
	 *            错误代码分类
	 */
	public void setErrcodeKind(String errcodeKind) {
 		this.errcodeKind = errcodeKind == null ? null : errcodeKind.trim() ;
    }
    
    /**
	 * Get the 错误代码分类.
	 * 
	 * @return 错误代码分类
	 */
	public String getErrcodeKind(){
		return this.errcodeKind ;
    }
	
	/**
	 * Set the 错误代码.
	 * 
	 * @param errCode
	 *            错误代码
	 */
	public void setErrCode(String errCode) {
 		this.errCode = errCode == null ? null : errCode.trim() ;
    }
    
    /**
	 * Get the 错误代码.
	 * 
	 * @return 错误代码
	 */
	public String getErrCode(){
		return this.errCode ;
    }
	
	/**
	 * Set the 错误信息.
	 * 
	 * @param errMsg
	 *            错误信息
	 */
	public void setErrMsg(String errMsg) {
 		this.errMsg = errMsg == null ? null : errMsg.trim() ;
    }
    
    /**
	 * Get the 错误信息.
	 * 
	 * @return 错误信息
	 */
	public String getErrMsg(){
		return this.errMsg ;
    }
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this) ; 
	}
}