/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.jnl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * <pre>
 * 客户接触日志
 * 模型文件 ： /Users/megapro/Develop/tis/tools/tools-core/model/JNLmysql.erm
 * 业务域：jnl
 * 模型：JNL_CONTACT_LOG 客户接触日志
 *
 * 记录客户与网点系统接触的所有日志明细，这些接触行为包括：
客户主动接触网点，如：使用自助设备；
柜员主动接触客户，如：厅堂经理介绍业务，高柜柜员为客户办理交易等；
客户间接接触网点，如：社区银行营销活动，客户通过商家积分兑换了银行理财优惠券；
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class JnlContactLog implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier） */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：接触时间<br/>描述：yyyyMMddHHmmssSSS */
	private String contactTime ;
	
	/** 字段类型：varchar<br/>字段名：渠道代码<br/>描述：记录接触系统对应的渠道代码 */
	private String chnCode ;
	
	/** 字段类型：varchar<br/>字段名：柜员代码<br/>描述：本次接触活动的柜员 */
	private String tellerNo ;
	
	/** 字段类型：varchar<br/>字段名：网点代码<br/>描述：本次接触的网点代码 */
	private String instno ;
	
	/** 字段类型：varchar<br/>字段名：接触方式<br/>描述：接触行为类型，见业务字典： DICT_CONTACT_MODE passive － 被动接触 active - 主动接触 */
	private String contactMode ;
	
	/** 字段类型：varchar<br/>字段名：客户编号<br/>描述：系统中的客户编号 */
	private String custNo ;
	
	/** 字段类型：varchar<br/>字段名：客户名称<br/>描述： */
	private String custName ;
	
	/** 字段类型：varchar<br/>字段名：业务类型<br/>描述：对银行业务的类型划分 见业务字典： DICT_BIZ_TYPE */
	private String bizType ;
	
	
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
	 * Set the 接触时间.
	 * 
	 * @param contactTime
	 *            接触时间
	 */
	public void setContactTime(String contactTime) {
 		this.contactTime = contactTime == null ? null : contactTime.trim() ;
    }
    
    /**
	 * Get the 接触时间.
	 * 
	 * @return 接触时间
	 */
	public String getContactTime(){
		return this.contactTime ;
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
	 * Set the 柜员代码.
	 * 
	 * @param tellerNo
	 *            柜员代码
	 */
	public void setTellerNo(String tellerNo) {
 		this.tellerNo = tellerNo == null ? null : tellerNo.trim() ;
    }
    
    /**
	 * Get the 柜员代码.
	 * 
	 * @return 柜员代码
	 */
	public String getTellerNo(){
		return this.tellerNo ;
    }
	
	/**
	 * Set the 网点代码.
	 * 
	 * @param instno
	 *            网点代码
	 */
	public void setInstno(String instno) {
 		this.instno = instno == null ? null : instno.trim() ;
    }
    
    /**
	 * Get the 网点代码.
	 * 
	 * @return 网点代码
	 */
	public String getInstno(){
		return this.instno ;
    }
	
	/**
	 * Set the 接触方式.
	 * 
	 * @param contactMode
	 *            接触方式
	 */
	public void setContactMode(String contactMode) {
 		this.contactMode = contactMode == null ? null : contactMode.trim() ;
    }
    
    /**
	 * Get the 接触方式.
	 * 
	 * @return 接触方式
	 */
	public String getContactMode(){
		return this.contactMode ;
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
	 * Set the 业务类型.
	 * 
	 * @param bizType
	 *            业务类型
	 */
	public void setBizType(String bizType) {
 		this.bizType = bizType == null ? null : bizType.trim() ;
    }
    
    /**
	 * Get the 业务类型.
	 * 
	 * @return 业务类型
	 */
	public String getBizType(){
		return this.bizType ;
    }
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this) ; 
	}
}