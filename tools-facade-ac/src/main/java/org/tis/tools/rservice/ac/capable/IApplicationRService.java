/**
 * 
 */
package org.tis.tools.rservice.ac.capable;

import org.tis.tools.base.WhereCondition;
import org.tis.tools.model.po.ac.*;
import org.tis.tools.rservice.ac.exception.AppManagementException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * 
 * 应用（Application，缩写App）管理.</br>
 * 
 * 关于‘应用’：
 * <li>一个“应用（App）”由多个“功能（Func）”组成；
 * <li>每个“功能”可细分为多个“操作行为（Behavior）”；
 * <li>按照分类，将多个功能集合为“功能组（FuncGroup）”；
 * <li>应用、功能、操作行为是权限控制的‘权限资源’；
 * 
 * 关于‘权限控制’：
 * <li>“功能”是权限控制的基础单元；
 * <li>角色权限分配：将“功能”分配给“角色（Role）”，再把“角色”指派给主体（机构、工作组、职务、岗位、操作员）；
 * <li>特殊权限分配：可以将“功能”或“功能行为”直接分配给主体（只考虑‘操作员’）；
 * <li>系统通过判断操作员是否具备某个功能的权限，进行功能、行为的访问控制，实现权限认证；
 * <li>操作员的权限范围，来自所处机构，所兼职务、岗位，所在工作组具有的角色权限，以及操作员自身特殊权限的（并集）集合；
 * 
 * 另外，
 * <li>“功能”可以与菜单相关联，一些功能有可操作界面可以作为菜单的执行入口；
 * <li>也可通过命令方式启动某个功能；
 * 
 * “应用”概念，涉及以下表模型：
 * <li>应用系统（AC_APP）
 * <li>功能组（AC_FUNCGROUP）
 * <li>功能（AC_FUNC），及功能资源（AC_FUNC_RESOURCE）、功能行为（AC_BEHAVIOR）
 * </pre>
 * @author megapro
 */
public interface IApplicationRService {

	/** 
	 * 新增应用系统(AC_APP)
	 * @param acApp 应用对象
	 * @return  acApp
	 */
	 AcApp createAcApp(AcApp acApp) throws AppManagementException;
	
	
	/**
	 * 删除应用系统(AC_APP)
	 * @param guid 应用系统的guid
	 * @return  acApp
	 */
	 AcApp deleteAcApp(String guid) throws AppManagementException;


	/**
	 * 更新应用系统(AC_APP)
	 * @param acApp
	 * @return
	 */
	AcApp updateAcApp(AcApp acApp) throws AppManagementException;

	/**
	 * 根据条件查询应用系统(AC_APP)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	 List<AcApp> queryAcAppList(WhereCondition wc) throws AppManagementException;
	
	/**
	 * 根据GUID应用系统(AC_APP)
	 * @param guid 
	 * @return 满足条件的记录
	 */
	 AcApp queryAcApp(String guid) throws AppManagementException;

	/**
	 * 根据应用代码查询应用系统(AC_APP)
	 * @param appCode
	 * @return
	 * @throws AppManagementException
	 */
	 AcApp queryAcAppByCode(String appCode) throws AppManagementException;

	
	/**
	 * 根据条件查询应用系统(AC_APP)
	 * @param 
	 * @return 根目录list
	 */
	 List<AcApp> queryAcRootList() throws AppManagementException;
	
	
	/**
	 * 根据应用id查询功能组(AC_FUNCGROUP)
	 * @param appGuid
	 * @return 
	 */
	 List<AcFuncgroup> queryAcRootFuncgroup(String appGuid) throws AppManagementException;
	
	
	/**
	 * 根据功能组ID(AC_FUNCGROUP)
	 * @param guidParent
	 * @return 
	 */
	 List<AcFuncgroup> queryAcChildFuncgroup(String guidParent) throws AppManagementException;
	
	/**
	 * 新增功能组(AC_FUNCGROUP)
	 * @param acFuncgroup 功能组对象
	 * return  AcFuncgroup
	 */
	 AcFuncgroup createAcFuncGroup(AcFuncgroup acFuncgroup) throws AppManagementException;


	/**
	 * 删除功能组(AC_FUNCGROUP)
	 * @param guid
	 * @return
	 */
	AcFuncgroup deleteAcFuncGroup(String guid) throws AppManagementException;

	/**
	 * 更新功能组(AC_FUNCGROUP)
	 * @param t
	 * @return
	 */
	 AcFuncgroup updateAcFuncgroup(AcFuncgroup t) throws AppManagementException;
	
	/**
	 * 根据条件查询功能组(AC_FUNCGROUP)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	 List<AcFuncgroup> queryAcFuncgroup(WhereCondition wc) throws AppManagementException;
	
	/**
	 * 根据条件查询功能组(AC_FUNCGROUP)
	 * @param guid 条件
	 * @return 满足条件的记录list
	 */
	 AcFuncgroup queryFuncgroup(String guid) throws AppManagementException;
	
	
	/**
	 * 新增功能(AC_FUNC)
	 * @param acFunc 功能对象
	 * @return  AcFunc
	 */
	 AcFunc createAcFunc(AcFunc acFunc) throws AppManagementException;

	
	/**
	 * 删除功能(AC_FUNC)
	 * @param guid 记录guid
	 * @return 删除的功能对象信息
	 */
	 AcFunc deleteAcFunc(String guid) throws AppManagementException;
	
	/**
	 * 更新功能(AC_FUNC)
	 * @param acFunc 功能
	 */
	 AcFunc updateAcFunc(AcFunc acFunc) throws AppManagementException;

	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	 List<AcFunc> queryAcFunc(WhereCondition wc) throws AppManagementException;
	
	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param guid 条件
	 * @return 满足条件的记录list
	 */
	 AcFunc queryFunc(String guid) throws AppManagementException;
	
	
	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param guid 条件
	 * @return 满足条件的记录
	 */
	 List<AcFunc> queryAcFunc(String guid) throws AppManagementException;
	
	
	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param groupGuid 条件
	 * @return 满足条件的记录list
	 */
	 List<AcFunc> queryAcGroupFunc(String groupGuid) throws AppManagementException;
	

	/**
	 * 新增菜单(AC_MENU)
	 * @param acMenu 菜单对象
	 * return  AcMenu
	 */
	 AcMenu createAcMenu(AcMenu acMenu) throws AppManagementException;
	
	/**
	 * 删除菜单(AC_MENU)
	 * @param guid 记录guid
	 */
	 void deleteAcMenu(String guid) throws AppManagementException;
	
	/**
	 * 更新菜单(AC_MENU),只修改t对象有值的字段
	 * @param t 新值
	 */
	 void updateAcMenu(AcMenu t) throws AppManagementException;
	
	/**
	 * 根据条件查询菜单(AC_MENU)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	 List<AcMenu> queryAcMenu(WhereCondition wc) throws AppManagementException;
	
	/**
	 * 新增功能资源对应(AC_FUNC_RESOURCE),新增t对象有值的字段
	 * @param t 新值
	 */
	 AcFuncResource createAcFuncResource(AcFuncResource t) throws AppManagementException;

	/**
	 * 删除功能资源对应(AC_FUNC_RESOURCE)
	 * @param acFuncResourceList 需要删除的资源集合
	 */
	List<AcFuncResource> deleteAcFuncResource(List<AcFuncResource> acFuncResourceList) throws AppManagementException;

	/**
	 * 更新功能资源对应(AC_FUNC_RESOURCE),只修改t对象有值的字段
	 * @param t 新值
	 */
	AcFuncResource updateAcFuncResource(AcFuncResource t) throws AppManagementException;
	
	/**
	 * 根据条件查询功能资源对应(AC_FUNC_RESOURCE)
	 * @param funcGuid 功能GUID
	 * @return 满足条件的记录list
	 */
	 List<AcFuncResource> queryAcFuncResource(String funcGuid) throws AppManagementException;
	
	/**
	 * 根据条件查询功能资源对应(AC_FUNC_RESOURCE)
	 * @param guid 条件
	 * @return 满足条件的记录
	 */
	 AcFuncResource queryFuncResource(String  guid) throws AppManagementException;
	
	/**
	 * 新增操作员(AC_OPERATOR),新增t对象有值的字段
	 * @param t 新值
	 */
	 void createAcOperator(AcOperator t) throws AppManagementException;
	
	/**
	 * 删除操作员(AC_OPERATOR)
	 * @param guid 记录guid
	 */
	 void deleteAcOperator(String guid) throws AppManagementException;
	
	/**
	 * 更新操作员(AC_OPERATOR),只修改t对象有值的字段
	 * @param t 新值
	 */
	 void updateAcOperator(AcOperator t) throws AppManagementException;
		
	/**
	 * 根据条件查询操作员(AC_OPERATOR)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	 List<AcOperator> queryAcOperator(WhereCondition wc) throws AppManagementException;
	
	/**
	 * 增加功能操作行为(AC_FUNC_BEHAVIOR),增加t对象有值的字段
	 * @param t 新值
	 */
	 void createAcFuncBehavior(AcFuncBehavior t) throws AppManagementException;
	
	/**
	 * 删除功能操作行为(AC_FUNC_BEHAVIOR)
	 * @param guid 记录guid
	 */
	 void deleteAcFuncBehavior(String guid) throws AppManagementException;
	
	/**
	 * 更新功能操作行为(AC_FUNC_BEHAVIOR),只修改t对象有值的字段
	 * @param t 新值
	 */
	 void updateAcFuncBehavior(AcFuncBehavior t) throws AppManagementException;
	
	/**
	 * 根据条件查询功能操作行为(AC_FUNC_BEHAVIOR)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	 List<AcFuncBehavior> queryAcFuncBehavior(WhereCondition wc) throws AppManagementException;
		
	
	
	/**
	 * 根据条件查询功能操作行为(AC_FUNC_BEHAVIOR)
	 * @return 满足条件的记录list
	 */
	 List<AcFunc> queryAllFunc() throws AppManagementException;
	
	/**
	 * 导入功能(AC_FUNC)
	 * 
	 * @param guidFuncgroup 功能组guid
	 * @param list 功能列表
	 */
	 void importFunc(String guidFuncgroup,List list) throws AppManagementException;
	
	/**
	 * 新增行为类型(AC_BHVTYPE_DEF)
	 * 
	 * @param acBhvtypeDef 行为类型
	 */
	AcBhvtypeDef functypeAdd(AcBhvtypeDef acBhvtypeDef) throws AppManagementException;
	
	
	/**
	 * 修改行为类型(AC_BHVTYPE_DEF)
	 * 
	 * @param acBhvtypeDef 行为类型
	 */
	AcBhvtypeDef functypeEdit(AcBhvtypeDef acBhvtypeDef) throws AppManagementException;
	
	
	
	/**
	 * 删除行为类型(AC_BHVTYPE_DEF)
	 * 
	 * @param guid 行为类型
	 */
	AcBhvtypeDef functypeDel(String guid) throws AppManagementException;
	
	/**
	 * 查询行为类型(AC_BHVTYPE_DEF)
	 *
	 * 返回list
	 */
	 List<AcBhvtypeDef> functypequery() throws AppManagementException;
	
	
	
	/**
	 * 新增功能操作行为(AC_BHV_DEF)
	 * 
	 * @param acBhvDef 功能操作行为
	 */
	AcBhvDef funactAdd(AcBhvDef acBhvDef) throws AppManagementException;
	

	/**
	 * 删除功能操作行为(AC_BHV_DEF)
	 * 
	 * @param guids 条件
	 */
	List<AcBhvDef> funactDel(List guids) throws AppManagementException;
	
	
	/**
	 * 修改功能操作行为(AC_BHV_DEF)
	 * 
	 * @param acBhvDef 功能操作行为
	 */
	AcBhvDef funactEdit(AcBhvDef acBhvDef) throws AppManagementException;
	
	
	/**
	 * 查询功能操作行为(AC_BHV_DEF)
	 * 
	 * @param guid 功能操作行为
	 * 返回list
	 */
	 List<AcBhvDef> funactQuery(String guid) throws AppManagementException;

	/**
	 * 通过功能GUID查询功能操作行为(AC_BHVTYPE_DEF)
	 *
	 * @param funcGuid 功能GUID
	 * 返回list
	 */
	 List<AcBhvtypeDef> queryBhvtypeDefByFunc(String funcGuid) throws AppManagementException;

	/**
	 * queryBhvDefByBhvType 根据行为类型的GUID查询所有的操作行为(AC_BHV_DEF)
	 *
	 * @param bhvtypeGuid 行为类型GUID
	 * 返回list
	 */
	 List<AcBhvDef> queryBhvDefByBhvType(String bhvtypeGuid) throws AppManagementException;


	/**
	 * addBhvDefForFunc 功能添加行为定义(AC_BHV_DEF)
	 *
	 * @param funcGuid 功能GUID
	 * @param bhvDefGuids 功能GUID数组
	 * 返回list
	 */
	 List<AcFuncBhv> addBhvDefForFunc(String funcGuid, List bhvDefGuids) throws AppManagementException;

	/**
	 * 设置功能行为定义是否有效
	 * @param funcBhvGuid
	 * @param isEffective
	 * @return
	 * @throws AppManagementException
	 */
	 AcFuncBhv setFuncBhvStatus(String funcBhvGuid, String isEffective) throws AppManagementException;

	/**
	 * 修改功能的行为类别
	 * @param funcGuid 功能GUID
	 * @param bhvtypeDefGuid 行为类别GUID
	 * @return
	 * @throws AppManagementException
	 */
	 AcFunc updateFuncBhvType(String funcGuid, String bhvtypeDefGuid) throws AppManagementException;


	/**
	 * queryAllBhvDefForFunc 查询功能下所有行为定义
	 * @param funcGuid 功能GUID
	 * @return list
	 */
	 List<Map> queryAllBhvDefForFunc(String funcGuid) throws AppManagementException;

	/**
	 * 删除功能下的行为定义
	 * @param funcGuid
	 * @param bhvDefGuid
	 */
	 List<AcFuncBhv> delFuncBhvDef(String funcGuid, List<String> bhvDefGuid) throws AppManagementException;

	/**
	 * 开通应用
	 * @param appGuid
	 * @param openDate
	 */
	 AcApp enableApp(String appGuid, Date openDate) throws AppManagementException;

	/**
	 * 关闭应用
	 * @param appGuid
	 */
	AcApp disableApp(String appGuid) throws AppManagementException;

	/**
	 * 查询应用下所有功能
	 *
	 * @param  appGuid 应用GUID
	 */
	List<AcFunc> queryFuncListInApp(String appGuid) throws AppManagementException;

	/**
	 * 查询操作员已拥有的应用集合
	 * @param userId
	 * 			用户ID
	 * @return
	 * @throws AppManagementException 应用
	 */
	List<AcApp> queryOperatorAllApp(String userId) throws AppManagementException;



}
