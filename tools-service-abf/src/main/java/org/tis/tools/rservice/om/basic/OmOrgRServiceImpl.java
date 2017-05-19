
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.om.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.om.OmOrg;
import org.tis.tools.rservice.om.basic.IOmOrgRService;
import org.tis.tools.service.om.OmOrgService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 机构信息表(OM_ORG) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "om", version = "1.0", interfaceClass = IOmOrgRService.class, timeout = 2000, document = "机构信息表的基础远程服务")
public class OmOrgRServiceImpl implements IOmOrgRService {

	@Autowired
	OmOrgService omOrgService;

	@Override
	public void insert(OmOrg t) {
		omOrgService.insert(t);
	}

	@Override
	public void update(OmOrg t) {
		omOrgService.update(t);
	}

	@Override
	public void updateForce(OmOrg t) {
		omOrgService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		omOrgService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		omOrgService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, OmOrg t) {
		omOrgService.updateByCondition(wc,t);
	}

	@Override
	public List<OmOrg> query(WhereCondition wc) {
		return omOrgService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return omOrgService.count(wc);
	}

	@Override
	public OmOrg loadByGuid(String guid) {
		return omOrgService.loadByGuid(guid);
	}

}