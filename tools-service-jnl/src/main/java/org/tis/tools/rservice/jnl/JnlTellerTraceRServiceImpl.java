
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.jnl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.jnl.JnlTellerTrace;
import org.tis.tools.rservice.jnl.IJnlTellerTraceRService;
import org.tis.tools.service.jnl.JnlTellerTraceService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 柜员操作日志(JNL_TELLER_TRACE) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "jnl", version = "1.0", interfaceClass = IJnlTellerTraceRService.class, timeout = 2000, document = "柜员操作日志的基础远程服务")
public class JnlTellerTraceRServiceImpl implements IJnlTellerTraceRService {

	@Autowired
	JnlTellerTraceService jnlTellerTraceService;

	@Override
	public void insert(JnlTellerTrace t) {
		jnlTellerTraceService.insert(t);
	}

	@Override
	public void update(JnlTellerTrace t) {
		jnlTellerTraceService.update(t);
	}

	@Override
	public void updateForce(JnlTellerTrace t) {
		jnlTellerTraceService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		jnlTellerTraceService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		jnlTellerTraceService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, JnlTellerTrace t) {
		jnlTellerTraceService.updateByCondition(wc,t);
	}

	@Override
	public List<JnlTellerTrace> query(WhereCondition wc) {
		return jnlTellerTraceService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return jnlTellerTraceService.count(wc);
	}

	@Override
	public JnlTellerTrace loadByGuid(String guid) {
		JnlTellerTrace test = new JnlTellerTrace() ; 
		test.setGuid("123");
		test.setActionTime("12345678907654");
		test.setActionType("111");
		test.setInstno("55566677");
		return test ;
		//return jnlTellerTraceService.loadByGuid(guid);
	}

}
