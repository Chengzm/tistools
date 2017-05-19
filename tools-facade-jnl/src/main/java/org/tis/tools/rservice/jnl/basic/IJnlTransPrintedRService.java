
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.jnl.basic;

import java.util.List;

import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.jnl.JnlTransPrinted;

 
/**
 * <pre>
 * 交易输出凭证流水(JNL_TRANS_PRINTED)的基础远程服务接口定义
 * </pre>
 *
 * @autor generated by tools:gen-dao
 *
 */
public interface IJnlTransPrintedRService {
	
	/**
	 * 新增交易输出凭证流水(JNL_TRANS_PRINTED)
	 * @param t 新记录
	 */
	public void insert(JnlTransPrinted t);

	/**
	 * 更新交易输出凭证流水(JNL_TRANS_PRINTED),只修改t对象有值的字段
	 * @param t 新值
	 */
	public void update(JnlTransPrinted t);

	/**
	 * 强制更新交易输出凭证流水(JNL_TRANS_PRINTED)
	 * @param t 新值
	 */
	public void updateForce(JnlTransPrinted t);

	/**
	 * 删除交易输出凭证流水(JNL_TRANS_PRINTED)
	 * @param guid 记录guid
	 */
	public void delete(String guid);

	/**
	 * 根据条件删除交易输出凭证流水(JNL_TRANS_PRINTED)
	 * @param wc 条件
	 */
	public void deleteByCondition(WhereCondition wc);

	/**
	 * 根据条件更新交易输出凭证流水(JNL_TRANS_PRINTED)
	 * @param wc 条件
	 * @param t 新值
	 */
	public void updateByCondition(WhereCondition wc, JnlTransPrinted t);

	/**
	 * 根据条件查询交易输出凭证流水(JNL_TRANS_PRINTED)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	public List<JnlTransPrinted> query(WhereCondition wc);

	/**
	 * 根据条件统计交易输出凭证流水(JNL_TRANS_PRINTED)记录数
	 * @param wc 条件
	 * @return 记录数
	 */
	public int count(WhereCondition wc);

	/**
	 * 根据id查询交易输出凭证流水(JNL_TRANS_PRINTED)记录
	 * @param guid 记录guid
	 * @return 匹配的记录
	 */
	public JnlTransPrinted loadByGuid(String guid);
}