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

import org.tis.tools.dao.om.OmAppPositionMapper;
import org.tis.tools.model.po.om.OmAppPosition;


/**
 * 应用岗位列表(OM_APP_POSITION)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class OmAppPositionService {

	@Autowired
	OmAppPositionMapper omAppPositionMapper;
	
    public void insert(OmAppPosition t){
    	omAppPositionMapper.insert(t);
    }
    
    public void update(OmAppPosition t){
    	omAppPositionMapper.update(t); 
    }
   
    public void updateForce(OmAppPosition t){
    	omAppPositionMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	omAppPositionMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	omAppPositionMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,OmAppPosition t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	omAppPositionMapper.updateByCondition(map); 
    }

    public List<OmAppPosition> query(WhereCondition wc){
    	return omAppPositionMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return omAppPositionMapper.count(wc);
    }
   
    public OmAppPosition loadByGuid(String guid){
    	return omAppPositionMapper.loadByGuid(guid);
    }
}