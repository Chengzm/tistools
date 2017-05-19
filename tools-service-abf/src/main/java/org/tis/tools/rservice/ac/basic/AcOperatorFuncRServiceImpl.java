
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcOperatorFunc;
import org.tis.tools.rservice.ac.basic.IAcOperatorFuncRService;
import org.tis.tools.service.ac.AcOperatorFuncService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 操作员特殊权限配置(AC_OPERATOR_FUNC) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "ac", version = "1.0", interfaceClass = IAcOperatorFuncRService.class, timeout = 2000, document = "操作员特殊权限配置的基础远程服务")
public class AcOperatorFuncRServiceImpl implements IAcOperatorFuncRService {

	@Autowired
	AcOperatorFuncService acOperatorFuncService;

	@Override
	public void insert(AcOperatorFunc t) {
		acOperatorFuncService.insert(t);
	}

	@Override
	public void update(AcOperatorFunc t) {
		acOperatorFuncService.update(t);
	}

	@Override
	public void updateForce(AcOperatorFunc t) {
		acOperatorFuncService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		acOperatorFuncService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		acOperatorFuncService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, AcOperatorFunc t) {
		acOperatorFuncService.updateByCondition(wc,t);
	}

	@Override
	public List<AcOperatorFunc> query(WhereCondition wc) {
		return acOperatorFuncService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return acOperatorFuncService.count(wc);
	}

	@Override
	public AcOperatorFunc loadByGuid(String guid) {
		return acOperatorFuncService.loadByGuid(guid);
	}

}