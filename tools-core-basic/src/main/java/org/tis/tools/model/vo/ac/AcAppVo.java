package org.tis.tools.model.vo.ac;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.tis.tools.common.utils.StringUtil;
import org.tis.tools.model.po.ac.AcApp;
import org.tis.tools.model.po.om.OmBusiorg;
import org.tis.tools.model.po.om.OmOrg;

/**
 * 业务机构详情（360信息）
 * 
 * @author megapro
 */
public class AcAppVo{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 对应的数据库表名称 */
	public static final String TABLE_NAME = "AC_APP" ; 
	/* AC_APP table's columns definition */
	/** GUID ：数据主键<br/><br/>全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	public static final String COLUMN_GUID = "guid" ; 
	/** APP_CODE ：应用代码<br/><br/> */
	public static final String COLUMN_APP_CODE = "app_code" ; 
	/** APP_NAME ：应用名称<br/><br/> */
	public static final String COLUMN_APP_NAME = "app_name" ; 
	/** APP_TYPE ：应用类型<br/><br/>取值来自业务菜单： DICT_AC_APPTYPE 如：本地，远程 */
	public static final String COLUMN_APP_TYPE = "app_type" ; 
	/** ISOPEN ：是否开通<br/><br/>取值来自业务菜单： DICT_YON 默认为N，新建后，必须执行应用开通操作，才被开通。 */
	public static final String COLUMN_ISOPEN = "isopen" ; 
	/** OPEN_DATE ：开通时间<br/><br/>记录到时分秒 */
	public static final String COLUMN_OPEN_DATE = "open_date" ; 
	/** URL ：访问地址<br/><br/> */
	public static final String COLUMN_URL = "url" ; 
	/** APP_DESC ：应用描述<br/><br/> */
	public static final String COLUMN_APP_DESC = "app_desc" ; 
	/** GUID_EMP_MAINTENANCE ：管理维护人员<br/><br/> */
	public static final String COLUMN_GUID_EMP_MAINTENANCE = "guid_emp_maintenance" ; 
	/** GUID_ROLE_MAINTENANCE ：应用管理角色<br/><br/> */
	public static final String COLUMN_GUID_ROLE_MAINTENANCE = "guid_role_maintenance" ; 
	/** REMARK ：备注<br/><br/> */
	public static final String COLUMN_REMARK = "remark" ; 
	/** INIWP ：是否接入集中工作平台<br/><br/>取值来自业务菜单： DICT_YON */
	public static final String COLUMN_INIWP = "iniwp" ; 
	/** INTASKCENTER ：是否接入集中任务中心<br/><br/>取值来自业务菜单： DICT_YON */
	public static final String COLUMN_INTASKCENTER = "intaskcenter" ; 
	/** IP_ADDR ：IP<br/><br/> */
	public static final String COLUMN_IP_ADDR = "ip_addr" ; 
	/** IP_PORT ：端口<br/><br/> */
	public static final String COLUMN_IP_PORT = "ip_port" ; 
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：应用代码<br/>描述： */
	private String appCode ;
	
	/** 字段类型：varchar<br/>字段名：应用名称<br/>描述： */
	private String appName ;
	
	/** 字段类型：varchar<br/>字段名：应用类型<br/>描述：取值来自业务菜单： DICT_AC_APPTYPE 如：本地，远程 */
	private String appType ;
	
	/** 字段类型：char<br/>字段名：是否开通<br/>描述：取值来自业务菜单： DICT_YON 默认为N，新建后，必须执行应用开通操作，才被开通。 */
	private String isopen ;
	
	/** 字段类型：timestamp<br/>字段名：开通时间<br/>描述：记录到时分秒 */
	private Date openDate ;
	
	private String openDateStr ;
	
	public String getOpenDateStr() {
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		return sdf.format(this.openDate);
	}

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
	 * Set the 开通时间.
	 * 
	 * @param openDate
	 *            开通时间
	 */
	public void setOpenDate(Date openDate) {
		java.text.SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
		this.openDateStr = sdf.format(openDate);
 		this.openDate = openDate ;
    }
    
    /**
	 * Get the 开通时间.
	 * 
	 * @return 开通时间
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
		return StringUtil.toString(this) ; 
	}
}
