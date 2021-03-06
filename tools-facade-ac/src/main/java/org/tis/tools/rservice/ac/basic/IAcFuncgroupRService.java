
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcFuncgroup;

 
/**
 * <pre>
 * 功能组(AC_FUNCGROUP)的基础远程服务接口定义
 * </pre>
 *
 * @autor generated by tools:gen-dao
 *
 */
public interface IAcFuncgroupRService {
	
	/**
	 * 新增功能组(AC_FUNCGROUP)
	 * @param t 新记录
	 */
	public void insert(AcFuncgroup t);

	/**
	 * 更新功能组(AC_FUNCGROUP),只修改t对象有值的字段
	 * @param t 新值
	 */
	public void update(AcFuncgroup t);

	/**
	 * 强制更新功能组(AC_FUNCGROUP)
	 * @param t 新值
	 */
	public void updateForce(AcFuncgroup t);

	/**
	 * 删除功能组(AC_FUNCGROUP)
	 * @param guid 记录guid
	 */
	public void delete(String guid);

	/**
	 * 根据条件删除功能组(AC_FUNCGROUP)
	 * @param wc 条件
	 */
	public void deleteByCondition(WhereCondition wc);

	/**
	 * 根据条件更新功能组(AC_FUNCGROUP)
	 * @param wc 条件
	 * @param t 新值
	 */
	public void updateByCondition(WhereCondition wc, AcFuncgroup t);

	/**
	 * 根据条件查询功能组(AC_FUNCGROUP)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	public List<AcFuncgroup> query(WhereCondition wc);

	/**
	 * 根据条件统计功能组(AC_FUNCGROUP)记录数
	 * @param wc 条件
	 * @return 记录数
	 */
	public int count(WhereCondition wc);

	/**
	 * 根据id查询功能组(AC_FUNCGROUP)记录
	 * @param guid 记录guid
	 * @return 匹配的记录
	 */
	public AcFuncgroup loadByGuid(String guid);
}
