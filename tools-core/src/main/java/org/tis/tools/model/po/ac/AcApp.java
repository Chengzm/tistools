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
 * 应用系统
 * 模型文件 ： /Users/megapro/Develop/tis/tools/tools-core/model/ABF-mysql.erm
 * 业务域：ac
 * 模型：AC_APP 应用系统
 *
 * 应用系统（Application）注册表
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class AcApp implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：记录的全局性唯一ID，系统自动生成； */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：应用代码<br/>描述： */
	private String appCode ;
	
	/** 字段类型：varchar<br/>字段名：应用名称<br/>描述： */
	private String appName ;
	
	/** 字段类型：varchar<br/>字段名：应用类型<br/>描述：取值来自业务菜单： DICT_AC_APPTYPE 如：本地，远程 */
	private String appType ;
	
	/** 字段类型：char<br/>字段名：是否开通<br/>描述：取值来自业务菜单： DICT_YON 默认为N，新建后，必须执行应用开通操作，才被开通。 */
	private String isopen ;
	
	/** 字段类型：date<br/>字段名：开通日期<br/>描述： */
	private Date openDate ;
	
	/** 字段类型：varchar<br/>字段名：访问地址<br/>描述： */
	private String url ;
	
	/** 字段类型：varchar<br/>字段名：应用描述<br/>描述： */
	private String appDesc ;
	
	/** 字段类型：varchar<br/>字段名：管理维护人员<br/>描述： */
	private String guidEmpMaintenance ;
	
	/** 字段类型：varchar<br/>字段名：应用管理角色<br/>描述： */
	private String guidRoleMaintenance ;
	
	/** 字段类型：varchar<br/>字段名：备注<br/>描述： */
	private String remark ;
	
	/** 字段类型：char<br/>字段名：是否接入集中工作平台<br/>描述：取值来自业务菜单： DICT_YON */
	private String iniwp ;
	
	/** 字段类型：char<br/>字段名：是否接入集中任务中心<br/>描述：取值来自业务菜单： DICT_YON */
	private String intaskcenter ;
	
	/** 字段类型：varchar<br/>字段名：IP<br/>描述： */
	private String ipAddr ;
	
	/** 字段类型：varchar<br/>字段名：端口<br/>描述： */
	private String ipPort ;
	
	
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
	 * Set the 应用代码.
	 * 
	 * @param appCode
	 *            应用代码
	 */
	public void setAppCode(String appCode) {
 		this.appCode = appCode == null ? null : appCode.trim() ;
    }
    
    /**
	 * Get the 应用代码.
	 * 
	 * @return 应用代码
	 */
	public String getAppCode(){
		return this.appCode ;
    }
	
	/**
	 * Set the 应用名称.
	 * 
	 * @param appName
	 *            应用名称
	 */
	public void setAppName(String appName) {
 		this.appName = appName == null ? null : appName.trim() ;
    }
    
    /**
	 * Get the 应用名称.
	 * 
	 * @return 应用名称
	 */
	public String getAppName(){
		return this.appName ;
    }
	
	/**
	 * Set the 应用类型.
	 * 
	 * @param appType
	 *            应用类型
	 */
	public void setAppType(String appType) {
 		this.appType = appType == null ? null : appType.trim() ;
    }
    
    /**
	 * Get the 应用类型.
	 * 
	 * @return 应用类型
	 */
	public String getAppType(){
		return this.appType ;
    }
	
	/**
	 * Set the 是否开通.
	 * 
	 * @param isopen
	 *            是否开通
	 */
	public void setIsopen(String isopen) {
 		this.isopen = isopen == null ? null : isopen.trim() ;
    }
    
    /**
	 * Get the 是否开通.
	 * 
	 * @return 是否开通
	 */
	public String getIsopen(){
		return this.isopen ;
    }
	
	/**
	 * Set the 开通日期.
	 * 
	 * @param openDate
	 *            开通日期
	 */
	public void setOpenDate(Date openDate) {
 		this.openDate = openDate ;
    }
    
    /**
	 * Get the 开通日期.
	 * 
	 * @return 开通日期
	 */
	public Date getOpenDate(){
		return this.openDate ;
    }
	
	/**
	 * Set the 访问地址.
	 * 
	 * @param url
	 *            访问地址
	 */
	public void setUrl(String url) {
 		this.url = url == null ? null : url.trim() ;
    }
    
    /**
	 * Get the 访问地址.
	 * 
	 * @return 访问地址
	 */
	public String getUrl(){
		return this.url ;
    }
	
	/**
	 * Set the 应用描述.
	 * 
	 * @param appDesc
	 *            应用描述
	 */
	public void setAppDesc(String appDesc) {
 		this.appDesc = appDesc == null ? null : appDesc.trim() ;
    }
    
    /**
	 * Get the 应用描述.
	 * 
	 * @return 应用描述
	 */
	public String getAppDesc(){
		return this.appDesc ;
    }
	
	/**
	 * Set the 管理维护人员.
	 * 
	 * @param guidEmpMaintenance
	 *            管理维护人员
	 */
	public void setGuidEmpMaintenance(String guidEmpMaintenance) {
 		this.guidEmpMaintenance = guidEmpMaintenance == null ? null : guidEmpMaintenance.trim() ;
    }
    
    /**
	 * Get the 管理维护人员.
	 * 
	 * @return 管理维护人员
	 */
	public String getGuidEmpMaintenance(){
		return this.guidEmpMaintenance ;
    }
	
	/**
	 * Set the 应用管理角色.
	 * 
	 * @param guidRoleMaintenance
	 *            应用管理角色
	 */
	public void setGuidRoleMaintenance(String guidRoleMaintenance) {
 		this.guidRoleMaintenance = guidRoleMaintenance == null ? null : guidRoleMaintenance.trim() ;
    }
    
    /**
	 * Get the 应用管理角色.
	 * 
	 * @return 应用管理角色
	 */
	public String getGuidRoleMaintenance(){
		return this.guidRoleMaintenance ;
    }
	
	/**
	 * Set the 备注.
	 * 
	 * @param remark
	 *            备注
	 */
	public void setRemark(String remark) {
 		this.remark = remark == null ? null : remark.trim() ;
    }
    
    /**
	 * Get the 备注.
	 * 
	 * @return 备注
	 */
	public String getRemark(){
		return this.remark ;
    }
	
	/**
	 * Set the 是否接入集中工作平台.
	 * 
	 * @param iniwp
	 *            是否接入集中工作平台
	 */
	public void setIniwp(String iniwp) {
 		this.iniwp = iniwp == null ? null : iniwp.trim() ;
    }
    
    /**
	 * Get the 是否接入集中工作平台.
	 * 
	 * @return 是否接入集中工作平台
	 */
	public String getIniwp(){
		return this.iniwp ;
    }
	
	/**
	 * Set the 是否接入集中任务中心.
	 * 
	 * @param intaskcenter
	 *            是否接入集中任务中心
	 */
	public void setIntaskcenter(String intaskcenter) {
 		this.intaskcenter = intaskcenter == null ? null : intaskcenter.trim() ;
    }
    
    /**
	 * Get the 是否接入集中任务中心.
	 * 
	 * @return 是否接入集中任务中心
	 */
	public String getIntaskcenter(){
		return this.intaskcenter ;
    }
	
	/**
	 * Set the IP.
	 * 
	 * @param ipAddr
	 *            IP
	 */
	public void setIpAddr(String ipAddr) {
 		this.ipAddr = ipAddr == null ? null : ipAddr.trim() ;
    }
    
    /**
	 * Get the IP.
	 * 
	 * @return IP
	 */
	public String getIpAddr(){
		return this.ipAddr ;
    }
	
	/**
	 * Set the 端口.
	 * 
	 * @param ipPort
	 *            端口
	 */
	public void setIpPort(String ipPort) {
 		this.ipPort = ipPort == null ? null : ipPort.trim() ;
    }
    
    /**
	 * Get the 端口.
	 * 
	 * @return 端口
	 */
	public String getIpPort(){
		return this.ipPort ;
    }
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this) ; 
	}
}