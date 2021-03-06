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

import org.tis.tools.dao.ac.AcEntityMapper;
import org.tis.tools.model.po.ac.AcEntity;


/**
 * 实体(AC_ENTITY)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class AcEntityService {

	@Autowired
	AcEntityMapper acEntityMapper;
	
    public void insert(AcEntity t){
    	acEntityMapper.insert(t);
    }
    
    public void update(AcEntity t){
    	acEntityMapper.update(t); 
    }
   
    public void updateForce(AcEntity t){
    	acEntityMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	acEntityMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	acEntityMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,AcEntity t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	acEntityMapper.updateByCondition(map); 
    }

    public List<AcEntity> query(WhereCondition wc){
    	return acEntityMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return acEntityMapper.count(wc);
    }
   
    public AcEntity loadByGuid(String guid){
    	return acEntityMapper.loadByGuid(guid);
    }
}
