/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.service.jnl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.tis.tools.base.WhereCondition;

import org.tis.tools.dao.jnl.JnlHosttransMsgMapper;
import org.tis.tools.model.po.jnl.JnlHosttransMsg;


/**
 * 主机交易报文(JNL_HOSTTRANS_MSG)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class JnlHosttransMsgService {

	@Autowired
	JnlHosttransMsgMapper jnlHosttransMsgMapper;
	
    public void insert(JnlHosttransMsg t){
    	jnlHosttransMsgMapper.insert(t);
    }
    
    public void update(JnlHosttransMsg t){
    	jnlHosttransMsgMapper.update(t); 
    }
   
    public void updateForce(JnlHosttransMsg t){
    	jnlHosttransMsgMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	jnlHosttransMsgMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	jnlHosttransMsgMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,JnlHosttransMsg t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	jnlHosttransMsgMapper.updateByCondition(map); 
    }

    public List<JnlHosttransMsg> query(WhereCondition wc){
    	return jnlHosttransMsgMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return jnlHosttransMsgMapper.count(wc);
    }
   
    public JnlHosttransMsg loadByGuid(String guid){
    	return jnlHosttransMsgMapper.loadByGuid(guid);
    }
}