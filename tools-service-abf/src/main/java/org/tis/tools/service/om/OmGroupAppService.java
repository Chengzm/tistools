/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.service.om;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.tis.tools.base.WhereCondition;

import org.tis.tools.dao.om.OmGroupAppMapper;
import org.tis.tools.model.po.om.OmGroupApp;


/**
 * 工作组应用列表(OM_GROUP_APP)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class OmGroupAppService {

	@Autowired
	OmGroupAppMapper omGroupAppMapper;
	
    public void insert(OmGroupApp t){
    	omGroupAppMapper.insert(t);
    }
    
    public void update(OmGroupApp t){
    	omGroupAppMapper.update(t); 
    }
   
    public void updateForce(OmGroupApp t){
    	omGroupAppMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	omGroupAppMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	omGroupAppMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,OmGroupApp t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	omGroupAppMapper.updateByCondition(map); 
    }

    public List<OmGroupApp> query(WhereCondition wc){
    	return omGroupAppMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return omGroupAppMapper.count(wc);
    }
   
    public OmGroupApp loadByGuid(String guid){
    	return omGroupAppMapper.loadByGuid(guid);
    }
}