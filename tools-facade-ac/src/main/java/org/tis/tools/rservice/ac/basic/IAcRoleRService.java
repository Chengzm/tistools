
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcRole;

 
/**
 * <pre>
 * 权限集(角色)(AC_ROLE)的基础远程服务接口定义
 * </pre>
 *
 * @autor generated by tools:gen-dao
 *
 */
public interface IAcRoleRService {
	
	/**
	 * 新增权限集(角色)(AC_ROLE)
	 * @param t 新记录
	 */
	public void insert(AcRole t);

	/**
	 * 更新权限集(角色)(AC_ROLE),只修改t对象有值的字段
	 * @param t 新值
	 */
	public void update(AcRole t);

	/**
	 * 强制更新权限集(角色)(AC_ROLE)
	 * @param t 新值
	 */
	public void updateForce(AcRole t);

	/**
	 * 删除权限集(角色)(AC_ROLE)
	 * @param guid 记录guid
	 */
	public void delete(String guid);

	/**
	 * 根据条件删除权限集(角色)(AC_ROLE)
	 * @param wc 条件
	 */
	public void deleteByCondition(WhereCondition wc);

	/**
	 * 根据条件更新权限集(角色)(AC_ROLE)
	 * @param wc 条件
	 * @param t 新值
	 */
	public void updateByCondition(WhereCondition wc, AcRole t);

	/**
	 * 根据条件查询权限集(角色)(AC_ROLE)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	public List<AcRole> query(WhereCondition wc);

	/**
	 * 根据条件统计权限集(角色)(AC_ROLE)记录数
	 * @param wc 条件
	 * @return 记录数
	 */
	public int count(WhereCondition wc);

	/**
	 * 根据id查询权限集(角色)(AC_ROLE)记录
	 * @param guid 记录guid
	 * @return 匹配的记录
	 */
	public AcRole loadByGuid(String guid);
}
