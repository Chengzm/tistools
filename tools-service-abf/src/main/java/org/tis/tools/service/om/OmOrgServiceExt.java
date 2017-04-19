/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.service.om;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tis.tools.dao.om.OmOrgMapper;
import org.tis.tools.dao.om.OmOrgMapperExt;
import org.tis.tools.model.po.om.OmOrg;


/**
 * 机构信息扩展业务逻辑
 * @author megapro
 *
 */
@Service
public class OmOrgServiceExt {

	@Autowired
	OmOrgMapper omOrgMapper;
	@Autowired
	OmOrgMapperExt omOrgMapperExt;
	
	/**
	 * 取机构记录
	 * 
	 * @param orgCode
	 *            机构代码
	 * @return 机构记录
	 */
	public OmOrg loadByOrgCode(String orgCode) {

		return omOrgMapperExt.loadByOrgCode(orgCode);
	}

	/**
	 * 判断机构代码（orgCode）对应的机构记录是否已经存在
	 * 
	 * @param orgCode
	 *            机构代码
	 * @return true 存在 false 不存在
	 */
	public boolean isExit(String orgCode) {

		OmOrg org = omOrgMapperExt.loadByOrgCode(orgCode);
		if (null != org) {
			return true;
		}
		return false;
	}
}
