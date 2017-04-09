/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.service.ac;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.tis.tools.base.WhereCondition;

import org.tis.tools.dao.ac.AcOperatorFuncMapper;
import org.tis.tools.model.po.ac.AcOperatorFunc;


/**
 * 操作员特殊权限配置(AC_OPERATOR_FUNC)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class AcOperatorFuncService {

	@Autowired
	AcOperatorFuncMapper acOperatorFuncMapper;
	
    public void insert(AcOperatorFunc t){
    	acOperatorFuncMapper.insert(t);
    }
    
    public void update(AcOperatorFunc t){
    	acOperatorFuncMapper.update(t); 
    }
   
    public void updateForce(AcOperatorFunc t){
    	acOperatorFuncMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	acOperatorFuncMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	acOperatorFuncMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,AcOperatorFunc t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	acOperatorFuncMapper.updateByCondition(map); 
    }

    public List<AcOperatorFunc> query(WhereCondition wc){
    	return acOperatorFuncMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return acOperatorFuncMapper.count(wc);
    }
   
    public AcOperatorFunc loadByGuid(String guid){
    	return acOperatorFuncMapper.loadByGuid(guid);
    }
}
