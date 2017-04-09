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

import org.tis.tools.dao.ac.AcOperatorRoleMapper;
import org.tis.tools.model.po.ac.AcOperatorRole;


/**
 * 操作员与权限集（角色）对应关系(AC_OPERATOR_ROLE)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class AcOperatorRoleService {

	@Autowired
	AcOperatorRoleMapper acOperatorRoleMapper;
	
    public void insert(AcOperatorRole t){
    	acOperatorRoleMapper.insert(t);
    }
    
    public void update(AcOperatorRole t){
    	acOperatorRoleMapper.update(t); 
    }
   
    public void updateForce(AcOperatorRole t){
    	acOperatorRoleMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	acOperatorRoleMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	acOperatorRoleMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,AcOperatorRole t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	acOperatorRoleMapper.updateByCondition(map); 
    }

    public List<AcOperatorRole> query(WhereCondition wc){
    	return acOperatorRoleMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return acOperatorRoleMapper.count(wc);
    }
   
    public AcOperatorRole loadByGuid(String guid){
    	return acOperatorRoleMapper.loadByGuid(guid);
    }
}
