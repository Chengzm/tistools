
/**
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.rservice.log.basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.log.LogAbfKeyword;
import org.tis.tools.rservice.log.basic.ILogAbfKeywordRService;
import org.tis.tools.service.log.LogAbfKeywordService;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * 记录关键值(LOG_ABF_KEYWORD) 基本远程服务实现(服务提供者)
 * 
 * @author by generated by tools:gen-dao
 *
 */
//TEMPLATES
@Service(group = "log", version = "1.0", interfaceClass = ILogAbfKeywordRService.class, timeout = 2000, document = "记录关键值的基础远程服务")
public class LogAbfKeywordRServiceImpl implements ILogAbfKeywordRService {

	@Autowired
	LogAbfKeywordService logAbfKeywordService;

	@Override
	public void insert(LogAbfKeyword t) {
		logAbfKeywordService.insert(t);
	}

	@Override
	public void update(LogAbfKeyword t) {
		logAbfKeywordService.update(t);
	}

	@Override
	public void updateForce(LogAbfKeyword t) {
		logAbfKeywordService.updateForce(t);
	}

	@Override
	public void delete(String guid) {
		logAbfKeywordService.delete(guid);
	}

	@Override
	public void deleteByCondition(WhereCondition wc) {
		logAbfKeywordService.deleteByCondition(wc);
	}

	@Override
	public void updateByCondition(WhereCondition wc, LogAbfKeyword t) {
		logAbfKeywordService.updateByCondition(wc,t);
	}

	@Override
	public List<LogAbfKeyword> query(WhereCondition wc) {
		return logAbfKeywordService.query(wc);
	}

	@Override
	public int count(WhereCondition wc) {
		return logAbfKeywordService.count(wc);
	}

	@Override
	public LogAbfKeyword loadByGuid(String guid) {
		return logAbfKeywordService.loadByGuid(guid);
	}

}
