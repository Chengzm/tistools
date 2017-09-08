
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.log.basic;

import java.util.List;

import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.log.LogAbfOperate;

 
/**
 * <pre>
 * 操作日志(LOG_ABF_OPERATE)的基础远程服务接口定义
 * </pre>
 *
 * @autor generated by tools:gen-dao
 *
 */
public interface ILogAbfOperateRService {
	
	/**
	 * 新增操作日志(LOG_ABF_OPERATE)
	 * @param t 新记录
	 */
	public void insert(LogAbfOperate t);

	/**
	 * 更新操作日志(LOG_ABF_OPERATE),只修改t对象有值的字段
	 * @param t 新值
	 */
	public void update(LogAbfOperate t);

	/**
	 * 强制更新操作日志(LOG_ABF_OPERATE)
	 * @param t 新值
	 */
	public void updateForce(LogAbfOperate t);

	/**
	 * 删除操作日志(LOG_ABF_OPERATE)
	 * @param guid 记录guid
	 */
	public void delete(String guid);

	/**
	 * 根据条件删除操作日志(LOG_ABF_OPERATE)
	 * @param wc 条件
	 */
	public void deleteByCondition(WhereCondition wc);

	/**
	 * 根据条件更新操作日志(LOG_ABF_OPERATE)
	 * @param wc 条件
	 * @param t 新值
	 */
	public void updateByCondition(WhereCondition wc, LogAbfOperate t);

	/**
	 * 根据条件查询操作日志(LOG_ABF_OPERATE)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	public List<LogAbfOperate> query(WhereCondition wc);

	/**
	 * 根据条件统计操作日志(LOG_ABF_OPERATE)记录数
	 * @param wc 条件
	 * @return 记录数
	 */
	public int count(WhereCondition wc);

	/**
	 * 根据id查询操作日志(LOG_ABF_OPERATE)记录
	 * @param guid 记录guid
	 * @return 匹配的记录
	 */
	public LogAbfOperate loadByGuid(String guid);
}