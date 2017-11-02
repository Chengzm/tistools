/**
 * auto generated
 * Copyright (C) 2016 bronsp.com, All rights reserved.
 */
package org.tis.tools.service.ac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.dao.ac.AcRoleMapper;
import org.tis.tools.dao.ac.AcRoleMapperExt;
import org.tis.tools.model.po.ac.AcPartyRole;
import org.tis.tools.model.po.ac.AcRole;
import org.tis.tools.model.po.ac.AcRoleBhv;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * 权限集(角色)业务逻辑
 * @author megapro
 *
 */
@Service
public class AcRoleServiceExt {

	@Autowired
	AcRoleMapper acRoleMapper;

	@Autowired
	AcRoleMapperExt acRoleMapperExt;
	
	@Autowired
	AcPartyRoleService acPartyRoleService; 
	
	/**
	 * 拷贝指定组织类型的角色集
	 * @param partyType 对象类型
	 * @param copyFromGuidParty 参考组织对象guid
	 * @param toGuidParty 新增组织对象guid
	 * @return 拷贝生成的组织对象角色集
	 */
	public Set<AcPartyRole> copyPartyRole(String partyType, String copyFromGuidParty, String toGuidParty){
		
		WhereCondition wc = new WhereCondition() ;
		wc.andEquals(AcPartyRole.COLUMN_PARTY_TYPE, partyType) ; 
		wc.andEquals(AcPartyRole.COLUMN_GUID_PARTY, copyFromGuidParty) ; 
		List<AcPartyRole> lists = acPartyRoleService.query(wc) ; 
		
		Set<AcPartyRole> sets = new HashSet<AcPartyRole>() ; 
		for( AcPartyRole p : lists){
			p.setGuidParty(toGuidParty);
			acPartyRoleService.insert(p);
			sets.add(p) ; 
		}
		
		return sets ; 
	}

	/**
	 * 删除组织对象的角色集
	 * 
	 * @param partyType
	 *            组织对象类型
	 * @param guidParty
	 *            组织对象guid
	 */
	public void deletePartyRole(String partyType, String guidParty) {
		
		WhereCondition wc = new WhereCondition() ; 
		wc.andEquals(AcPartyRole.COLUMN_PARTY_TYPE, partyType) ; 
		wc.andEquals(AcPartyRole.COLUMN_GUID_PARTY, guidParty) ; 
		acPartyRoleService.deleteByCondition(wc);
	}


	/**
	 * <p>查询所有角色</p>
	 *
	 * <pre>
	 *     用于展示角色列表,添加应用名称
	 * </pre>
	 * @return
	 */
	public List<Map> queryAllRoleExt() {
		return acRoleMapperExt.queryAllRoleExt();
	}

	/**
	 * <p>根据角色和组织类型查询角色所有的组织机构信息</p>
	 *
	 * <pre>
	 *
	 * </pre>
	 * @return
	 */
	public List<Map> queryAllRolePartyExt(String roleGuid, String partyType) {
		return acRoleMapperExt.queryAllRolePartyExt(roleGuid, partyType);
	}

	/**
	 * 查询角色已经授权的角色列表
	 * @param roleGuid
	 * @return
	 */
	public List<Map> queryAllOperatorRoleExt(String roleGuid) {
		return acRoleMapperExt.queryAllOperatorRoleExt(roleGuid);
	}


	/**
	 * 查询操作员在所在工作组和岗位下的所有角色
	 *
	 * @param empGuid
	 * 			员工GUID
	 * @return
	 */
	public List<AcRole> queryEmployeeAllPartyRoleList(String empGuid) {
		return acRoleMapperExt.queryEmployeeAllPartyRoleList(empGuid);
	}

	/**
	 * 查询角色在功能下的行为列表
	 *
	 * @param roleGuid 需要查询的角色GUID
	 * @param funcGuid 查询的功能GUID
	 * @return 返回该角色拥有此功能的行为列表 {@link AcRoleBhv}
	 */
	public List<Map> queryAcRoleBhvsByFuncGuid(String roleGuid, String funcGuid) {
		return acRoleMapperExt.queryAcRoleBhvsByFuncGuid(roleGuid, funcGuid);
	}


}
