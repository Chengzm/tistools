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

import org.tis.tools.dao.ac.AcFuncResourceMapper;
import org.tis.tools.model.po.ac.AcFuncResource;


/**
 * 功能资源对应(AC_FUNC_RESOURCE)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class AcFuncResourceService {

	@Autowired
	AcFuncResourceMapper acFuncResourceMapper;
	
    public void insert(AcFuncResource t){
    	acFuncResourceMapper.insert(t);
    }
    
    public void update(AcFuncResource t){
    	acFuncResourceMapper.update(t); 
    }
   
    public void updateForce(AcFuncResource t){
    	acFuncResourceMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	acFuncResourceMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	acFuncResourceMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,AcFuncResource t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	acFuncResourceMapper.updateByCondition(map); 
    }

    public List<AcFuncResource> query(WhereCondition wc){
    	return acFuncResourceMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return acFuncResourceMapper.count(wc);
    }
   
    public AcFuncResource loadByGuid(String guid){
    	return acFuncResourceMapper.loadByGuid(guid);
    }
}
