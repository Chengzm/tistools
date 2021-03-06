/**
 * auto generated
 * Copyright (C) 2017 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.jnl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.tis.tools.common.utils.StringUtil;

/**
 * 
 * <pre>
 * 排队流水
 * 模型文件 ： E:\tools\tistools\tools-core-basic\model\JNL-mysql.erm
 * 业务域：jnl
 * 模型：JNL_ENQUEUE 排队流水
 *
 * 每新开始一次排队，会生成一笔对应的服务流水。
如果是客户服务内取号排队，则计入同一个客户服务过程内；
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class JnlEnqueue implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 对应的数据库表名称 */
	public static final String TABLE_NAME = "JNL_ENQUEUE" ; 
	/* JNL_ENQUEUE table's columns definition */
	/** GUID ：数据主键<br/><br/>全局唯一标识符（GUID，Globally Unique Identifier） */
	public static final String COLUMN_GUID = "guid" ; 
	/** GUID_CUST_SERVICE ：服务流水ID<br/><br/>关联服务流水记录 */
	public static final String COLUMN_GUID_CUST_SERVICE = "guid_cust_service" ; 
	/** SERVICE_SNO ：服务流水号<br/><br/> */
	public static final String COLUMN_SERVICE_SNO = "service_sno" ; 
	/** ENQUEUE_NO ：排队号<br/><br/>排队顺序号 */
	public static final String COLUMN_ENQUEUE_NO = "enqueue_no" ; 
	/** ENQUEUE_BIZ_TYPE ：排队业务类型<br/><br/>见业务字典：DICT_QUEUE_BIZ_TYPE */
	public static final String COLUMN_ENQUEUE_BIZ_TYPE = "enqueue_biz_type" ; 
	/** CHN_CODE ：渠道代码<br/><br/>记录接触系统对应的渠道代码； 来自渠道参数控制表： SYS_CHANNEL_CTL */
	public static final String COLUMN_CHN_CODE = "chn_code" ; 
	/** ENQUEUE_IN_TIME ：开始排队时间<br/><br/>yyyyMMddHHmmSSsss */
	public static final String COLUMN_ENQUEUE_IN_TIME = "enqueue_in_time" ; 
	/** ENQUEUE_CODE ：排队机编号<br/><br/>每台排队机都有唯一的编号，类似工作站编号； 但是，不一定每次排队都有排队机编号 */
	public static final String COLUMN_ENQUEUE_CODE = "enqueue_code" ; 
	/** CUST_NO ：客户编号<br/><br/>系统中的客户编号 */
	public static final String COLUMN_CUST_NO = "cust_no" ; 
	/** CUST_NAME ：客户名称<br/><br/> */
	public static final String COLUMN_CUST_NAME = "cust_name" ; 
	/** CUST_LEVEL ：客户级别<br/><br/>银行对客户的评级 */
	public static final String COLUMN_CUST_LEVEL = "cust_level" ; 
	/** PAPER_TYPE ：证件类型<br/><br/>证件类型，见业务字典： DICT_PAPER_TYPE */
	public static final String COLUMN_PAPER_TYPE = "paper_type" ; 
	/** PAPER_NO ：证件号<br/><br/>证件号码 */
	public static final String COLUMN_PAPER_NO = "paper_no" ; 
	/** CALL_TELLER ：叫号柜员<br/><br/> */
	public static final String COLUMN_CALL_TELLER = "call_teller" ; 
	/** CALL_TIME ：叫号时间<br/><br/>yyyyMMddHHmmSSsss */
	public static final String COLUMN_CALL_TIME = "call_time" ; 
	/** CALL_INSTNO ：叫号机构<br/><br/> */
	public static final String COLUMN_CALL_INSTNO = "call_instno" ; 
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier） */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：服务流水ID<br/>描述：关联服务流水记录 */
	private String guidCustService ;
	
	/** 字段类型：varchar<br/>字段名：服务流水号<br/>描述： */
	private String serviceSno ;
	
	/** 字段类型：int<br/>字段名：排队号<br/>描述：排队顺序号 */
	private Integer enqueueNo ;
	
	/** 字段类型：varchar<br/>字段名：排队业务类型<br/>描述：见业务字典：DICT_QUEUE_BIZ_TYPE */
	private String enqueueBizType ;
	
	/** 字段类型：varchar<br/>字段名：渠道代码<br/>描述：记录接触系统对应的渠道代码； 来自渠道参数控制表： SYS_CHANNEL_CTL */
	private String chnCode ;
	
	/** 字段类型：varchar<br/>字段名：开始排队时间<br/>描述：yyyyMMddHHmmSSsss */
	private String enqueueInTime ;
	
	/** 字段类型：varchar<br/>字段名：排队机编号<br/>描述：每台排队机都有唯一的编号，类似工作站编号； 但是，不一定每次排队都有排队机编号 */
	private String enqueueCode ;
	
	/** 字段类型：varchar<br/>字段名：客户编号<br/>描述：系统中的客户编号 */
	private String custNo ;
	
	/** 字段类型：varchar<br/>字段名：客户名称<br/>描述： */
	private String custName ;
	
	/** 字段类型：varchar<br/>字段名：客户级别<br/>描述：银行对客户的评级 */
	private String custLevel ;
	
	/** 字段类型：char<br/>字段名：证件类型<br/>描述：证件类型，见业务字典： DICT_PAPER_TYPE */
	private String paperType ;
	
	/** 字段类型：varchar<br/>字段名：证件号<br/>描述：证件号码 */
	private String paperNo ;
	
	/** 字段类型：varchar<br/>字段名：叫号柜员<br/>描述： */
	private String callTeller ;
	
	/** 字段类型：varchar<br/>字段名：叫号时间<br/>描述：yyyyMMddHHmmSSsss */
	private String callTime ;
	
	/** 字段类型：varchar<br/>字段名：叫号机构<br/>描述： */
	private String callInstno ;

	/**
	* Default Constructor
	*/
	public JnlEnqueue() {
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
	 * Set the 服务流水ID.
	 * 
	 * @param guidCustService
	 *            服务流水ID
	 */
	public void setGuidCustService(String guidCustService) {
 		this.guidCustService = guidCustService == null ? null : guidCustService.trim() ;
    }
    
    /**
	 * Get the 服务流水ID.
	 * 
	 * @return 服务流水ID
	 */
	public String getGuidCustService(){
		return this.guidCustService ;
    }
	
	/**
	 * Set the 服务流水号.
	 * 
	 * @param serviceSno
	 *            服务流水号
	 */
	public void setServiceSno(String serviceSno) {
 		this.serviceSno = serviceSno == null ? null : serviceSno.trim() ;
    }
    
    /**
	 * Get the 服务流水号.
	 * 
	 * @return 服务流水号
	 */
	public String getServiceSno(){
		return this.serviceSno ;
    }
	
	/**
	 * Set the 排队号.
	 * 
	 * @param enqueueNo
	 *            排队号
	 */
	public void setEnqueueNo(Integer enqueueNo) {
 		this.enqueueNo = enqueueNo ;
    }
    
    /**
	 * Get the 排队号.
	 * 
	 * @return 排队号
	 */
	public Integer getEnqueueNo(){
		return this.enqueueNo ;
    }
	
	/**
	 * Set the 排队业务类型.
	 * 
	 * @param enqueueBizType
	 *            排队业务类型
	 */
	public void setEnqueueBizType(String enqueueBizType) {
 		this.enqueueBizType = enqueueBizType == null ? null : enqueueBizType.trim() ;
    }
    
    /**
	 * Get the 排队业务类型.
	 * 
	 * @return 排队业务类型
	 */
	public String getEnqueueBizType(){
		return this.enqueueBizType ;
    }
	
	/**
	 * Set the 渠道代码.
	 * 
	 * @param chnCode
	 *            渠道代码
	 */
	public void setChnCode(String chnCode) {
 		this.chnCode = chnCode == null ? null : chnCode.trim() ;
    }
    
    /**
	 * Get the 渠道代码.
	 * 
	 * @return 渠道代码
	 */
	public String getChnCode(){
		return this.chnCode ;
    }
	
	/**
	 * Set the 开始排队时间.
	 * 
	 * @param enqueueInTime
	 *            开始排队时间
	 */
	public void setEnqueueInTime(String enqueueInTime) {
 		this.enqueueInTime = enqueueInTime == null ? null : enqueueInTime.trim() ;
    }
    
    /**
	 * Get the 开始排队时间.
	 * 
	 * @return 开始排队时间
	 */
	public String getEnqueueInTime(){
		return this.enqueueInTime ;
    }
	
	/**
	 * Set the 排队机编号.
	 * 
	 * @param enqueueCode
	 *            排队机编号
	 */
	public void setEnqueueCode(String enqueueCode) {
 		this.enqueueCode = enqueueCode == null ? null : enqueueCode.trim() ;
    }
    
    /**
	 * Get the 排队机编号.
	 * 
	 * @return 排队机编号
	 */
	public String getEnqueueCode(){
		return this.enqueueCode ;
    }
	
	/**
	 * Set the 客户编号.
	 * 
	 * @param custNo
	 *            客户编号
	 */
	public void setCustNo(String custNo) {
 		this.custNo = custNo == null ? null : custNo.trim() ;
    }
    
    /**
	 * Get the 客户编号.
	 * 
	 * @return 客户编号
	 */
	public String getCustNo(){
		return this.custNo ;
    }
	
	/**
	 * Set the 客户名称.
	 * 
	 * @param custName
	 *            客户名称
	 */
	public void setCustName(String custName) {
 		this.custName = custName == null ? null : custName.trim() ;
    }
    
    /**
	 * Get the 客户名称.
	 * 
	 * @return 客户名称
	 */
	public String getCustName(){
		return this.custName ;
    }
	
	/**
	 * Set the 客户级别.
	 * 
	 * @param custLevel
	 *            客户级别
	 */
	public void setCustLevel(String custLevel) {
 		this.custLevel = custLevel == null ? null : custLevel.trim() ;
    }
    
    /**
	 * Get the 客户级别.
	 * 
	 * @return 客户级别
	 */
	public String getCustLevel(){
		return this.custLevel ;
    }
	
	/**
	 * Set the 证件类型.
	 * 
	 * @param paperType
	 *            证件类型
	 */
	public void setPaperType(String paperType) {
 		this.paperType = paperType == null ? null : paperType.trim() ;
    }
    
    /**
	 * Get the 证件类型.
	 * 
	 * @return 证件类型
	 */
	public String getPaperType(){
		return this.paperType ;
    }
	
	/**
	 * Set the 证件号.
	 * 
	 * @param paperNo
	 *            证件号
	 */
	public void setPaperNo(String paperNo) {
 		this.paperNo = paperNo == null ? null : paperNo.trim() ;
    }
    
    /**
	 * Get the 证件号.
	 * 
	 * @return 证件号
	 */
	public String getPaperNo(){
		return this.paperNo ;
    }
	
	/**
	 * Set the 叫号柜员.
	 * 
	 * @param callTeller
	 *            叫号柜员
	 */
	public void setCallTeller(String callTeller) {
 		this.callTeller = callTeller == null ? null : callTeller.trim() ;
    }
    
    /**
	 * Get the 叫号柜员.
	 * 
	 * @return 叫号柜员
	 */
	public String getCallTeller(){
		return this.callTeller ;
    }
	
	/**
	 * Set the 叫号时间.
	 * 
	 * @param callTime
	 *            叫号时间
	 */
	public void setCallTime(String callTime) {
 		this.callTime = callTime == null ? null : callTime.trim() ;
    }
    
    /**
	 * Get the 叫号时间.
	 * 
	 * @return 叫号时间
	 */
	public String getCallTime(){
		return this.callTime ;
    }
	
	/**
	 * Set the 叫号机构.
	 * 
	 * @param callInstno
	 *            叫号机构
	 */
	public void setCallInstno(String callInstno) {
 		this.callInstno = callInstno == null ? null : callInstno.trim() ;
    }
    
    /**
	 * Get the 叫号机构.
	 * 
	 * @return 叫号机构
	 */
	public String getCallInstno(){
		return this.callInstno ;
    }
	
	public String toString(){
		return StringUtil.toString(this) ; 
	}
}