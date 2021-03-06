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

import org.tis.tools.dao.ac.AcOperatorIdentityMapper;
import org.tis.tools.model.po.ac.AcOperatorIdentity;


/**
 * 操作员身份(AC_OPERATOR_IDENTITY)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class AcOperatorIdentityService {

	@Autowired
	AcOperatorIdentityMapper acOperatorIdentityMapper;
	
    public void insert(AcOperatorIdentity t){
    	acOperatorIdentityMapper.insert(t);
    }
    
    public void update(AcOperatorIdentity t){
    	acOperatorIdentityMapper.update(t); 
    }
   
    public void updateForce(AcOperatorIdentity t){
    	acOperatorIdentityMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	acOperatorIdentityMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	acOperatorIdentityMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,AcOperatorIdentity t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	acOperatorIdentityMapper.updateByCondition(map); 
    }

    public List<AcOperatorIdentity> query(WhereCondition wc){
    	return acOperatorIdentityMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return acOperatorIdentityMapper.count(wc);
    }
   
    public AcOperatorIdentity loadByGuid(String guid){
    	return acOperatorIdentityMapper.loadByGuid(guid);
    }
}
