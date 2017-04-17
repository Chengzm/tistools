
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcOperatorRole;
import org.tis.tools.rservice.ac.basic.IAcOperatorRoleRService;
import org.tis.tools.service.ac.AcOperatorRoleService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 操作员与权限集（角色）对应关系(AC_OPERATOR_ROLE) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "ac", version = "1.0", interfaceClass = IAcOperatorRoleRService.class, timeout = 2000, document = "操作员与权限集（角色）对应关系的基础远程服务")
public class AcOperatorRoleRServiceImpl implements IAcOperatorRoleRService {

	@Autowired
	AcOperatorRoleService acOperatorRoleService;

	@Override
	public void insert(AcOperatorRole t) {
		acOperatorRoleService.insert(t);
	}

	@Override
	public void update(AcOperatorRole t) {
		acOperatorRoleService.update(t);
	}

	@Override
	public void updateForce(AcOperatorRole t) {
		acOperatorRoleService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		acOperatorRoleService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		acOperatorRoleService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, AcOperatorRole t) {
		acOperatorRoleService.updateByCondition(wc,t);
	}

	@Override
	public List<AcOperatorRole> query(WhereCondition wc) {
		return acOperatorRoleService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return acOperatorRoleService.count(wc);
	}

	@Override
	public AcOperatorRole loadByGuid(String guid) {
		return acOperatorRoleService.loadByGuid(guid);
	}

}
