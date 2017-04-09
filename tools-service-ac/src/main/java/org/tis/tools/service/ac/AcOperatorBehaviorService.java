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

import org.tis.tools.dao.ac.AcOperatorBehaviorMapper;
import org.tis.tools.model.po.ac.AcOperatorBehavior;


/**
 * 操作员特殊功能行为配置(AC_OPERATOR_BEHAVIOR)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class AcOperatorBehaviorService {

	@Autowired
	AcOperatorBehaviorMapper acOperatorBehaviorMapper;
	
    public void insert(AcOperatorBehavior t){
    	acOperatorBehaviorMapper.insert(t);
    }
    
    public void update(AcOperatorBehavior t){
    	acOperatorBehaviorMapper.update(t); 
    }
   
    public void updateForce(AcOperatorBehavior t){
    	acOperatorBehaviorMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	acOperatorBehaviorMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	acOperatorBehaviorMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,AcOperatorBehavior t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	acOperatorBehaviorMapper.updateByCondition(map); 
    }

    public List<AcOperatorBehavior> query(WhereCondition wc){
    	return acOperatorBehaviorMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return acOperatorBehaviorMapper.count(wc);
    }
   
    public AcOperatorBehavior loadByGuid(String guid){
    	return acOperatorBehaviorMapper.loadByGuid(guid);
    }
}
