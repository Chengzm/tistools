
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.jnl.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.jnl.JnlCustService;
import org.tis.tools.rservice.jnl.basic.IJnlCustServiceRService;
import org.tis.tools.service.jnl.JnlCustServiceService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 客户服务流水(JNL_CUST_SERVICE) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "jnl", version = "1.0", interfaceClass = IJnlCustServiceRService.class, timeout = 2000, document = "客户服务流水的基础远程服务")
public class JnlCustServiceRServiceImpl implements IJnlCustServiceRService {

	@Autowired
	JnlCustServiceService jnlCustServiceService;

	@Override
	public void insert(JnlCustService t) {
		jnlCustServiceService.insert(t);
	}

	@Override
	public void update(JnlCustService t) {
		jnlCustServiceService.update(t);
	}

	@Override
	public void updateForce(JnlCustService t) {
		jnlCustServiceService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		jnlCustServiceService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		jnlCustServiceService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, JnlCustService t) {
		jnlCustServiceService.updateByCondition(wc,t);
	}

	@Override
	public List<JnlCustService> query(WhereCondition wc) {
		return jnlCustServiceService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return jnlCustServiceService.count(wc);
	}

	@Override
	public JnlCustService loadByGuid(String guid) {
		return jnlCustServiceService.loadByGuid(guid);
	}

}
