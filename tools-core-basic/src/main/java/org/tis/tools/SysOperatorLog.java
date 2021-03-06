package org.tis.tools;

import java.io.Serializable;
import java.util.Date;

/**
 * Model class of 操作日志.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class SysOperatorLog implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 数据主键. */
	private String guid;

	/** 操作类型. */
	private String operatorType;

	/** 操作时间. */
	private Date operatorTime;

	/** 操作结果. */
	private String operatorResult;

	/** 操作员姓名. */
	private String operatorName;

	/** 操作员. */
	private String userId;

	/** 应用代码. */
	private String appCode;

	/** 应用名称. */
	private String appName;

	/** 功能编号. */
	private String funcCode;

	/** 功能名称. */
	private String funcName;

	/** 服务地址. */
	private String restfulRul;

	/** 异常堆栈. */
	private String stackTrace;

	/** 处理描述. */
	private String procssDesc;

	/**
	 * Constructor.
	 */
	public SysOperatorLog() {
	}

	/**
	 * Set the 数据主键.
	 * 
	 * @param guid
	 *            数据主键
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuid() {
		return this.guid;
	}

	/**
	 * Set the 操作类型.
	 * 
	 * @param operatorType
	 *            操作类型
	 */
	public void setOperatorType(String operatorType) {
		this.operatorType = operatorType;
	}

	/**
	 * Get the 操作类型.
	 * 
	 * @return 操作类型
	 */
	public String getOperatorType() {
		return this.operatorType;
	}

	/**
	 * Set the 操作时间.
	 * 
	 * @param operatorTime
	 *            操作时间
	 */
	public void setOperatorTime(Date operatorTime) {
		this.operatorTime = operatorTime;
	}

	/**
	 * Get the 操作时间.
	 * 
	 * @return 操作时间
	 */
	public Date getOperatorTime() {
		return this.operatorTime;
	}

	/**
	 * Set the 操作结果.
	 * 
	 * @param operatorResult
	 *            操作结果
	 */
	public void setOperatorResult(String operatorResult) {
		this.operatorResult = operatorResult;
	}

	/**
	 * Get the 操作结果.
	 * 
	 * @return 操作结果
	 */
	public String getOperatorResult() {
		return this.operatorResult;
	}

	/**
	 * Set the 操作员姓名.
	 * 
	 * @param operatorName
	 *            操作员姓名
	 */
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}

	/**
	 * Get the 操作员姓名.
	 * 
	 * @return 操作员姓名
	 */
	public String getOperatorName() {
		return this.operatorName;
	}

	/**
	 * Set the 操作员.
	 * 
	 * @param userId
	 *            操作员
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Get the 操作员.
	 * 
	 * @return 操作员
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * Set the 应用代码.
	 * 
	 * @param appCode
	 *            应用代码
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	/**
	 * Get the 应用代码.
	 * 
	 * @return 应用代码
	 */
	public String getAppCode() {
		return this.appCode;
	}

	/**
	 * Set the 应用名称.
	 * 
	 * @param appName
	 *            应用名称
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}

	/**
	 * Get the 应用名称.
	 * 
	 * @return 应用名称
	 */
	public String getAppName() {
		return this.appName;
	}

	/**
	 * Set the 功能编号.
	 * 
	 * @param funcCode
	 *            功能编号
	 */
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	/**
	 * Get the 功能编号.
	 * 
	 * @return 功能编号
	 */
	public String getFuncCode() {
		return this.funcCode;
	}

	/**
	 * Set the 功能名称.
	 * 
	 * @param funcName
	 *            功能名称
	 */
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}

	/**
	 * Get the 功能名称.
	 * 
	 * @return 功能名称
	 */
	public String getFuncName() {
		return this.funcName;
	}

	/**
	 * Set the 服务地址.
	 * 
	 * @param restfulRul
	 *            服务地址
	 */
	public void setRestfulRul(String restfulRul) {
		this.restfulRul = restfulRul;
	}

	/**
	 * Get the 服务地址.
	 * 
	 * @return 服务地址
	 */
	public String getRestfulRul() {
		return this.restfulRul;
	}

	/**
	 * Set the 异常堆栈.
	 * 
	 * @param stackTrace
	 *            异常堆栈
	 */
	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	/**
	 * Get the 异常堆栈.
	 * 
	 * @return 异常堆栈
	 */
	public String getStackTrace() {
		return this.stackTrace;
	}

	/**
	 * Set the 处理描述.
	 * 
	 * @param procssDesc
	 *            处理描述
	 */
	public void setProcssDesc(String procssDesc) {
		this.procssDesc = procssDesc;
	}

	/**
	 * Get the 处理描述.
	 * 
	 * @return 处理描述
	 */
	public String getProcssDesc() {
		return this.procssDesc;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guid == null) ? 0 : guid.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		SysOperatorLog other = (SysOperatorLog) obj;
		if (guid == null) {
			if (other.guid != null) {
				return false;
			}
		} else if (!guid.equals(other.guid)) {
			return false;
		}
		return true;
	}

}
