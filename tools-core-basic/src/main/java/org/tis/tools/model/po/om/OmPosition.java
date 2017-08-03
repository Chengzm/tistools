/**
 * auto generated
 * Copyright (C) 2017 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.om;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.tis.tools.common.utils.StringUtil;

/**
 * 
 * <pre>
 * 岗位
 * 模型文件 ： E:\tools\tistools\tools-core-basic\model\ABF-mysql.erm
 * 业务域：om
 * 模型：OM_POSITION 岗位
 *
 * 岗位定义表
岗位是职务在机构上的实例化表现（某个机构／部门中对某个职务（Responsibility）的工作定义）；
一般情况下，每个岗位都需要配置一个职务系统当然出于业务上扩展考虑，并没有限制岗位一定要对应上职务；
例如，一个公司有三个部门A，B，C，每个部门都设置了管理岗位 A部门经理，B部门经理，C部门经理。同时可在三个岗位上设置共同的职务为“经理”
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class OmPosition implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	/** 对应的数据库表名称 */
	public static final String TABLE_NAME = "OM_POSITION" ; 
	/* OM_POSITION table's columns definition */
	/** GUID ：数据主键<br/><br/>全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	public static final String COLUMN_GUID = "guid" ; 
	/** GUID_ORG ：隶属机构GUID<br/><br/> */
	public static final String COLUMN_GUID_ORG = "guid_org" ; 
	/** POSITION_CODE ：岗位代码<br/><br/>业务上对岗位的编码 */
	public static final String COLUMN_POSITION_CODE = "position_code" ; 
	/** POSITION_NAME ：岗位名称<br/><br/> */
	public static final String COLUMN_POSITION_NAME = "position_name" ; 
	/** POSITION_TYPE ：岗位类别<br/><br/>见业务字典： DICT_OM_POSITYPE 机构岗位，工作组岗位 */
	public static final String COLUMN_POSITION_TYPE = "position_type" ; 
	/** POSITION_STATUS ：岗位状态<br/><br/>见业务字典： DICT_OM_POSISTATUS */
	public static final String COLUMN_POSITION_STATUS = "position_status" ; 
	/** ISLEAF ：是否叶子岗位<br/><br/>见业务字典： DICT_YON */
	public static final String COLUMN_ISLEAF = "isleaf" ; 
	/** SUB_COUNT ：子节点数<br/><br/> */
	public static final String COLUMN_SUB_COUNT = "sub_count" ; 
	/** POSITION_LEVEL ：岗位层次<br/><br/> */
	public static final String COLUMN_POSITION_LEVEL = "position_level" ; 
	/** POSITION_SEQ ：岗位序列<br/><br/>岗位的面包屑定位信息 */
	public static final String COLUMN_POSITION_SEQ = "position_seq" ; 
	/** GUID_PARENTS ：父岗位GUID<br/><br/> */
	public static final String COLUMN_GUID_PARENTS = "guid_parents" ; 
	/** GUID_DUTY ：所属职务GUID<br/><br/> */
	public static final String COLUMN_GUID_DUTY = "guid_duty" ; 
	/** START_DATE ：岗位有效开始日期<br/><br/> */
	public static final String COLUMN_START_DATE = "start_date" ; 
	/** END_DATE ：岗位有效截止日期<br/><br/> */
	public static final String COLUMN_END_DATE = "end_date" ; 
	/** CREATETIME ：创建时间<br/><br/> */
	public static final String COLUMN_CREATETIME = "createtime" ; 
	/** LASTUPDATE ：最近更新时间<br/><br/> */
	public static final String COLUMN_LASTUPDATE = "lastupdate" ; 
	/** UPDATOR ：最近更新人员<br/><br/> */
	public static final String COLUMN_UPDATOR = "updator" ; 
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述：全局唯一标识符（GUID，Globally Unique Identifier），系统自动生成； */
	private String guid ;
	
	/** 字段类型：varchar<br/>字段名：隶属机构GUID<br/>描述： */
	private String guidOrg ;
	
	/** 字段类型：varchar<br/>字段名：岗位代码<br/>描述：业务上对岗位的编码 */
	private String positionCode ;
	
	/** 字段类型：varchar<br/>字段名：岗位名称<br/>描述： */
	private String positionName ;
	
	/** 字段类型：varchar<br/>字段名：岗位类别<br/>描述：见业务字典： DICT_OM_POSITYPE 机构岗位，工作组岗位 */
	private String positionType ;
	
	/** 字段类型：varchar<br/>字段名：岗位状态<br/>描述：见业务字典： DICT_OM_POSISTATUS */
	private String positionStatus ;
	
	/** 字段类型：char<br/>字段名：是否叶子岗位<br/>描述：见业务字典： DICT_YON */
	private String isleaf ;
	
	/** 字段类型：decimal<br/>字段名：子节点数<br/>描述： */
	private BigDecimal subCount ;
	
	/** 字段类型：decimal<br/>字段名：岗位层次<br/>描述： */
	private BigDecimal positionLevel ;
	
	/** 字段类型：varchar<br/>字段名：岗位序列<br/>描述：岗位的面包屑定位信息 */
	private String positionSeq ;
	
	/** 字段类型：varchar<br/>字段名：父岗位GUID<br/>描述： */
	private String guidParents ;
	
	/** 字段类型：varchar<br/>字段名：所属职务GUID<br/>描述： */
	private String guidDuty ;
	
	/** 字段类型：date<br/>字段名：岗位有效开始日期<br/>描述： */
	private Date startDate ;
	
	/** 字段类型：date<br/>字段名：岗位有效截止日期<br/>描述： */
	private Date endDate ;
	
	/** 字段类型：timestamp<br/>字段名：创建时间<br/>描述： */
	private Date createtime ;
	
	/** 字段类型：timestamp<br/>字段名：最近更新时间<br/>描述： */
	private Date lastupdate ;
	
	/** 字段类型：varchar<br/>字段名：最近更新人员<br/>描述： */
	private String updator ;

	/**
	* Default Constructor
	*/
	public OmPosition() {
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
	 * Set the 隶属机构GUID.
	 * 
	 * @param guidOrg
	 *            隶属机构GUID
	 */
	public void setGuidOrg(String guidOrg) {
 		this.guidOrg = guidOrg == null ? null : guidOrg.trim() ;
    }
    
    /**
	 * Get the 隶属机构GUID.
	 * 
	 * @return 隶属机构GUID
	 */
	public String getGuidOrg(){
		return this.guidOrg ;
    }
	
	/**
	 * Set the 岗位代码.
	 * 
	 * @param positionCode
	 *            岗位代码
	 */
	public void setPositionCode(String positionCode) {
 		this.positionCode = positionCode == null ? null : positionCode.trim() ;
    }
    
    /**
	 * Get the 岗位代码.
	 * 
	 * @return 岗位代码
	 */
	public String getPositionCode(){
		return this.positionCode ;
    }
	
	/**
	 * Set the 岗位名称.
	 * 
	 * @param positionName
	 *            岗位名称
	 */
	public void setPositionName(String positionName) {
 		this.positionName = positionName == null ? null : positionName.trim() ;
    }
    
    /**
	 * Get the 岗位名称.
	 * 
	 * @return 岗位名称
	 */
	public String getPositionName(){
		return this.positionName ;
    }
	
	/**
	 * Set the 岗位类别.
	 * 
	 * @param positionType
	 *            岗位类别
	 */
	public void setPositionType(String positionType) {
 		this.positionType = positionType == null ? null : positionType.trim() ;
    }
    
    /**
	 * Get the 岗位类别.
	 * 
	 * @return 岗位类别
	 */
	public String getPositionType(){
		return this.positionType ;
    }
	
	/**
	 * Set the 岗位状态.
	 * 
	 * @param positionStatus
	 *            岗位状态
	 */
	public void setPositionStatus(String positionStatus) {
 		this.positionStatus = positionStatus == null ? null : positionStatus.trim() ;
    }
    
    /**
	 * Get the 岗位状态.
	 * 
	 * @return 岗位状态
	 */
	public String getPositionStatus(){
		return this.positionStatus ;
    }
	
	/**
	 * Set the 是否叶子岗位.
	 * 
	 * @param isleaf
	 *            是否叶子岗位
	 */
	public void setIsleaf(String isleaf) {
 		this.isleaf = isleaf == null ? null : isleaf.trim() ;
    }
    
    /**
	 * Get the 是否叶子岗位.
	 * 
	 * @return 是否叶子岗位
	 */
	public String getIsleaf(){
		return this.isleaf ;
    }
	
	/**
	 * Set the 子节点数.
	 * 
	 * @param subCount
	 *            子节点数
	 */
	public void setSubCount(BigDecimal subCount) {
 		this.subCount = subCount ;
    }
    
    /**
	 * Get the 子节点数.
	 * 
	 * @return 子节点数，如果setSubCount时原值为空，返回BigDecimal(0d)
	 */
	public BigDecimal getSubCount(){
		if(subCount==null){
			return new BigDecimal(0d);
		}
		return subCount;
    }
	
	/**
	 * Set the 岗位层次.
	 * 
	 * @param positionLevel
	 *            岗位层次
	 */
	public void setPositionLevel(BigDecimal positionLevel) {
 		this.positionLevel = positionLevel ;
    }
    
    /**
	 * Get the 岗位层次.
	 * 
	 * @return 岗位层次，如果setPositionLevel时原值为空，返回BigDecimal(0d)
	 */
	public BigDecimal getPositionLevel(){
		if(positionLevel==null){
			return new BigDecimal(0d);
		}
		return positionLevel;
    }
	
	/**
	 * Set the 岗位序列.
	 * 
	 * @param positionSeq
	 *            岗位序列
	 */
	public void setPositionSeq(String positionSeq) {
 		this.positionSeq = positionSeq == null ? null : positionSeq.trim() ;
    }
    
    /**
	 * Get the 岗位序列.
	 * 
	 * @return 岗位序列
	 */
	public String getPositionSeq(){
		return this.positionSeq ;
    }
	
	/**
	 * Set the 父岗位GUID.
	 * 
	 * @param guidParents
	 *            父岗位GUID
	 */
	public void setGuidParents(String guidParents) {
 		this.guidParents = guidParents == null ? null : guidParents.trim() ;
    }
    
    /**
	 * Get the 父岗位GUID.
	 * 
	 * @return 父岗位GUID
	 */
	public String getGuidParents(){
		return this.guidParents ;
    }
	
	/**
	 * Set the 所属职务GUID.
	 * 
	 * @param guidDuty
	 *            所属职务GUID
	 */
	public void setGuidDuty(String guidDuty) {
 		this.guidDuty = guidDuty == null ? null : guidDuty.trim() ;
    }
    
    /**
	 * Get the 所属职务GUID.
	 * 
	 * @return 所属职务GUID
	 */
	public String getGuidDuty(){
		return this.guidDuty ;
    }
	
	/**
	 * Set the 岗位有效开始日期.
	 * 
	 * @param startDate
	 *            岗位有效开始日期
	 */
	public void setStartDate(Date startDate) {
 		this.startDate = startDate ;
    }
    
    /**
	 * Get the 岗位有效开始日期.
	 * 
	 * @return 岗位有效开始日期
	 */
	public Date getStartDate(){
		return this.startDate ;
    }
	
	/**
	 * Set the 岗位有效截止日期.
	 * 
	 * @param endDate
	 *            岗位有效截止日期
	 */
	public void setEndDate(Date endDate) {
 		this.endDate = endDate ;
    }
    
    /**
	 * Get the 岗位有效截止日期.
	 * 
	 * @return 岗位有效截止日期
	 */
	public Date getEndDate(){
		return this.endDate ;
    }
	
	/**
	 * Set the 创建时间.
	 * 
	 * @param createtime
	 *            创建时间
	 */
	public void setCreatetime(Date createtime) {
 		this.createtime = createtime ;
    }
    
    /**
	 * Get the 创建时间.
	 * 
	 * @return 创建时间
	 */
	public Date getCreatetime(){
		return this.createtime ;
    }
	
	/**
	 * Set the 最近更新时间.
	 * 
	 * @param lastupdate
	 *            最近更新时间
	 */
	public void setLastupdate(Date lastupdate) {
 		this.lastupdate = lastupdate ;
    }
    
    /**
	 * Get the 最近更新时间.
	 * 
	 * @return 最近更新时间
	 */
	public Date getLastupdate(){
		return this.lastupdate ;
    }
	
	/**
	 * Set the 最近更新人员.
	 * 
	 * @param updator
	 *            最近更新人员
	 */
	public void setUpdator(String updator) {
 		this.updator = updator == null ? null : updator.trim() ;
    }
    
    /**
	 * Get the 最近更新人员.
	 * 
	 * @return 最近更新人员
	 */
	public String getUpdator(){
		return this.updator ;
    }
	
	public String toString(){
		return StringUtil.toString(this) ; 
	}


	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (this == obj) {
			return true;
		}
		if (obj instanceof OmPosition) {
			OmPosition other = (OmPosition) obj;
			return (other.getGuid()).equals(this.getGuid());
		}
		return false;
	}
	
	
}