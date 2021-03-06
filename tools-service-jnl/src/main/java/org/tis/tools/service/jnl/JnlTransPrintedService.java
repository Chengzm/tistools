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

import org.tis.tools.dao.jnl.JnlTransPrintedMapper;
import org.tis.tools.model.po.jnl.JnlTransPrinted;


/**
 * 交易输出凭证流水(JNL_TRANS_PRINTED)数据的基础业务逻辑
 * @author by generated by tools:gen-dao
 *
 */
@Service
public class JnlTransPrintedService {

	@Autowired
	JnlTransPrintedMapper jnlTransPrintedMapper;
	
    public void insert(JnlTransPrinted t){
    	jnlTransPrintedMapper.insert(t);
    }
    
    public void update(JnlTransPrinted t){
    	jnlTransPrintedMapper.update(t); 
    }
   
    public void updateForce(JnlTransPrinted t){
    	jnlTransPrintedMapper.updateForce(t); 
    }
   
    public void delete(String guid){
    	jnlTransPrintedMapper.delete(guid);
    }
   
    public void deleteByCondition(WhereCondition wc){
    	jnlTransPrintedMapper.deleteByCondition(wc); 
    }
	
	public void updateByCondition(WhereCondition wc,JnlTransPrinted t){
    	Map map  = new HashMap();
    	map.put("domain", t);
    	map.put("wc", wc);
    	jnlTransPrintedMapper.updateByCondition(map); 
    }

    public List<JnlTransPrinted> query(WhereCondition wc){
    	return jnlTransPrintedMapper.query(wc); 
    }
    
    public int count(WhereCondition wc){
    	return jnlTransPrintedMapper.count(wc);
    }
   
    public JnlTransPrinted loadByGuid(String guid){
    	return jnlTransPrintedMapper.loadByGuid(guid);
    }
}
