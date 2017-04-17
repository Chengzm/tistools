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

import org.tis.tools.dao.om.OmDutyMapper;
import org.tis.tools.model.po.om.OmDuty;


/**
 * 职务定义表(OM_DUTY)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class OmDutyService {

	@Autowired
	OmDutyMapper omDutyMapper;
	
    public void insert(OmDuty t){
    	omDutyMapper.insert(t);
    }
    
    public void update(OmDuty t){
    	omDutyMapper.update(t); 
    }
   
    public void updateForce(OmDuty t){
    	omDutyMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	omDutyMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	omDutyMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,OmDuty t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	omDutyMapper.updateByCondition(map); 
    }

    public List<OmDuty> query(WhereCondition wc){
    	return omDutyMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return omDutyMapper.count(wc);
    }
   
    public OmDuty loadByGuid(String guid){
    	return omDutyMapper.loadByGuid(guid);
    }
}
