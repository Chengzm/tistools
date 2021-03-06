
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcRoleDatascope;
import org.tis.tools.rservice.ac.basic.IAcRoleDatascopeRService;
import org.tis.tools.service.ac.AcRoleDatascopeService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 角色数据范围权限对应(AC_ROLE_DATASCOPE) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "ac", version = "1.0", interfaceClass = IAcRoleDatascopeRService.class, timeout = 2000, document = "角色数据范围权限对应的基础远程服务")
public class AcRoleDatascopeRServiceImpl implements IAcRoleDatascopeRService {

	@Autowired
	AcRoleDatascopeService acRoleDatascopeService;

	@Override
	public void insert(AcRoleDatascope t) {
		acRoleDatascopeService.insert(t);
	}

	@Override
	public void update(AcRoleDatascope t) {
		acRoleDatascopeService.update(t);
	}

	@Override
	public void updateForce(AcRoleDatascope t) {
		acRoleDatascopeService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		acRoleDatascopeService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		acRoleDatascopeService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, AcRoleDatascope t) {
		acRoleDatascopeService.updateByCondition(wc,t);
	}

	@Override
	public List<AcRoleDatascope> query(WhereCondition wc) {
		return acRoleDatascopeService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return acRoleDatascopeService.count(wc);
	}

	@Override
	public AcRoleDatascope loadByGuid(String guid) {
		return acRoleDatascopeService.loadByGuid(guid);
	}

}
