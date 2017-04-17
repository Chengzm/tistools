
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.om.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.om.OmAppPosition;
import org.tis.tools.rservice.om.basic.IOmAppPositionRService;
import org.tis.tools.service.om.OmAppPositionService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 应用岗位列表(OM_APP_POSITION) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "om", version = "1.0", interfaceClass = IOmAppPositionRService.class, timeout = 2000, document = "应用岗位列表的基础远程服务")
public class OmAppPositionRServiceImpl implements IOmAppPositionRService {

	@Autowired
	OmAppPositionService omAppPositionService;

	@Override
	public void insert(OmAppPosition t) {
		omAppPositionService.insert(t);
	}

	@Override
	public void update(OmAppPosition t) {
		omAppPositionService.update(t);
	}

	@Override
	public void updateForce(OmAppPosition t) {
		omAppPositionService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		omAppPositionService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		omAppPositionService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, OmAppPosition t) {
		omAppPositionService.updateByCondition(wc,t);
	}

	@Override
	public List<OmAppPosition> query(WhereCondition wc) {
		return omAppPositionService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return omAppPositionService.count(wc);
	}

	@Override
	public OmAppPosition loadByGuid(String guid) {
		return omAppPositionService.loadByGuid(guid);
	}

}
