
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcBehavior;
import org.tis.tools.rservice.ac.basic.IAcBehaviorRService;
import org.tis.tools.service.ac.AcBehaviorService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 功能操作行为(AC_BEHAVIOR) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "ac", version = "1.0", interfaceClass = IAcBehaviorRService.class, timeout = 2000, document = "功能操作行为的基础远程服务")
public class AcBehaviorRServiceImpl implements IAcBehaviorRService {

	@Autowired
	AcBehaviorService acBehaviorService;

	@Override
	public void insert(AcBehavior t) {
		acBehaviorService.insert(t);
	}

	@Override
	public void update(AcBehavior t) {
		acBehaviorService.update(t);
	}

	@Override
	public void updateForce(AcBehavior t) {
		acBehaviorService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		acBehaviorService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		acBehaviorService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, AcBehavior t) {
		acBehaviorService.updateByCondition(wc,t);
	}

	@Override
	public List<AcBehavior> query(WhereCondition wc) {
		return acBehaviorService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return acBehaviorService.count(wc);
	}

	@Override
	public AcBehavior loadByGuid(String guid) {
		return acBehaviorService.loadByGuid(guid);
	}

}
