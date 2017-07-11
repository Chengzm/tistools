
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.ac.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.AcBhvtypeDef;
import org.tis.tools.rservice.ac.basic.IAcBhvtypeDefRService;
import org.tis.tools.service.ac.AcBhvtypeDefService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 行为类型定义(AC_BHVTYPE_DEF) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "ac", version = "1.0", interfaceClass = IAcBhvtypeDefRService.class, timeout = 2000, document = "行为类型定义的基础远程服务")
public class AcBhvtypeDefRServiceImpl implements IAcBhvtypeDefRService {

	@Autowired
	AcBhvtypeDefService acBhvtypeDefService;

	@Override
	public void insert(AcBhvtypeDef t) {
		acBhvtypeDefService.insert(t);
	}

	@Override
	public void update(AcBhvtypeDef t) {
		acBhvtypeDefService.update(t);
	}

	@Override
	public void updateForce(AcBhvtypeDef t) {
		acBhvtypeDefService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		acBhvtypeDefService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		acBhvtypeDefService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, AcBhvtypeDef t) {
		acBhvtypeDefService.updateByCondition(wc,t);
	}

	@Override
	public List<AcBhvtypeDef> query(WhereCondition wc) {
		return acBhvtypeDefService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return acBhvtypeDefService.count(wc);
	}

	@Override
	public AcBhvtypeDef loadByGuid(String guid) {
		return acBhvtypeDefService.loadByGuid(guid);
	}

}
