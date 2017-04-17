/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.model.po.om;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Time;
import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 * <pre>
 * 人员工作组对应关系
 * 模型文件 ： /Users/megapro/Develop/tis/tools/tools-core/model/ABF-mysql.erm
 * 业务域：om
 * 模型：OM_EMP_GROUP 人员工作组对应关系
 *
 * 定义工作组包含的人员（工作组中有哪些人员）
如：某个项目组有哪些人员
 *
 * </pre>
 * @author generated by tools:gen-dao
 *
 */
public class OmEmpGroup implements Serializable {

 	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述： */
	private String guidEmp ;
	
	/** 字段类型：varchar<br/>字段名：数据主键<br/>描述： */
	private String guidGroup ;
	
	
	/**
	 * Set the 数据主键.
	 * 
	 * @param guidEmp
	 *            数据主键
	 */
	public void setGuidEmp(String guidEmp) {
 		this.guidEmp = guidEmp == null ? null : guidEmp.trim() ;
    }
    
    /**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuidEmp(){
		return this.guidEmp ;
    }
	
	/**
	 * Set the 数据主键.
	 * 
	 * @param guidGroup
	 *            数据主键
	 */
	public void setGuidGroup(String guidGroup) {
 		this.guidGroup = guidGroup == null ? null : guidGroup.trim() ;
    }
    
    /**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuidGroup(){
		return this.guidGroup ;
    }
	
	public String toString(){
		return ToStringBuilder.reflectionToString(this) ; 
	}
}