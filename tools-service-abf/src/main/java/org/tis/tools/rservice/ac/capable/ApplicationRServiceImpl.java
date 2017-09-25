/**
 * 
 */
package org.tis.tools.rservice.ac.capable;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.util.CollectionUtils;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.common.utils.BasicUtil;
import org.tis.tools.common.utils.BeanFieldValidateUtil;
import org.tis.tools.common.utils.StringUtil;
import org.tis.tools.core.exception.ExceptionCodes;
import org.tis.tools.model.def.CommonConstants;
import org.tis.tools.model.def.GUID;
import org.tis.tools.model.po.ac.*;
import org.tis.tools.model.po.om.OmEmployee;
import org.tis.tools.model.vo.ac.AcAppVo;
import org.tis.tools.model.vo.ac.AcFuncVo;
import org.tis.tools.model.vo.ac.AcOperatorFuncDetail;
import org.tis.tools.rservice.BaseRService;
import org.tis.tools.rservice.ac.exception.AppManagementException;
import org.tis.tools.service.ac.*;
import org.tis.tools.service.ac.exception.ACExceptionCodes;
import org.tis.tools.service.om.OmEmployeeService;

/**
 * <pre>
 * 权限（Application）管理服务功能的实现类
 * 
 * <pre>
 * 
 * @author zzc
 *
 */
public class ApplicationRServiceImpl extends BaseRService implements
		IApplicationRService {

	@Autowired
	AcAppService acAppService;
	@Autowired
	ApplicationService applicationService;	
	@Autowired
	AcFuncgroupService acFuncgroupService;
	@Autowired
	AcFuncService acFuncService;
	@Autowired
	AcMenuService acMenuService;
	@Autowired
	AcFuncResourceService acFuncResourceService;
	@Autowired
	AcOperatorService acOperatorService;
	@Autowired
	AcFuncBehaviorService acFuncBehaviorService;
	@Autowired
	AcBhvtypeDefService acBhvtypeDefService;
	@Autowired
	AcBhvDefService acBhvDefService;
	@Autowired
	AcFuncBhvtypeService acFuncBhvtypeService;
	@Autowired
	AcFuncBhvService acFuncBhvService;
	@Autowired
	OmEmployeeService omEmployeeService;
	@Autowired
	AcFuncServiceExt acFuncServiceExt;
	@Autowired
	IRoleRService roleRService;
	@Autowired
	AcRoleFuncService acRoleFuncService;
	@Autowired
	AcOperatorFuncService acOperatorFuncService;



	/**
	 * 新增应用系统(AC_APP)
	 * 
	 * @param acApp
	 *            应用对象
	 * @return acApp
	 */
	@Override
	public AcApp createAcApp(AcApp acApp) throws AppManagementException {
		try {
			if (null == acApp) {
				throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("AC_APP", AcApp.TABLE_NAME));
			}
			String[] validateField = {
					"appCode", "appName", "appType", "isopen"
			};
			String validate = BeanFieldValidateUtil.checkObjFieldNotRequired(acApp, validateField);
			if(StringUtils.isNotEmpty(validate)) {
				throw new AppManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap(validate, AcApp.TABLE_NAME));
			}
			acApp.setGuid(GUID.app());
			acAppService.insert(acApp);
			return acApp;
		} catch (AppManagementException ae) {
			throw ae;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(ExceptionCodes.FAILURE_WHEN_INSERT, BasicUtil.wrap(AcApp.TABLE_NAME, e));
		}
	}

	/**
	 * 删除应用系统(AC_APP)
	 * 
	 * @param guid
	 *            应用系统guid
	 */
	@Override
	public AcApp deleteAcApp(String guid) throws AppManagementException {
		if(StringUtils.isBlank(guid)) {
			throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap(AcApp.COLUMN_GUID, AcApp.TABLE_NAME));
		}
		try {
			List<AcApp> apps = acAppService.query(new WhereCondition().andEquals(AcApp.COLUMN_GUID, guid));
			if (apps.size() != 1) {
				throw new AppManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap(guid, AcApp.TABLE_NAME));
			}
			AcApp app = apps.get(0);
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				public void doInTransactionWithoutResult(TransactionStatus status) {
					try {
						WhereCondition wc = new WhereCondition();
						wc.andEquals("GUID_APP", guid);
						List<AcFuncgroup> funcgroup = acFuncgroupService.query(wc);
						List<String> groupList = funcgroup.stream().map(AcFuncgroup::getGuid).collect(Collectors.toList());
						if (!CollectionUtils.isEmpty(groupList)) {
							acFuncService.deleteByCondition(new WhereCondition().andIn(AcFunc.COLUMN_GUID_FUNCGROUP, groupList));

						}
						acFuncgroupService.deleteByCondition(wc);
						acAppService.delete(guid);
					} catch (Exception e) {
						throw new AppManagementException(ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AcApp(" + guid + ")", e));
					}
				}
			});
			return app;
		} catch (AppManagementException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_DELETE,
					BasicUtil.wrap("AcApp(" + guid + ")", e));
		}
	}

	/**
	 * 更新应用系统(AC_APP)
	 * @param acApp
	 * @return
	 * @throws AppManagementException
	 */
	@Override
	public AcApp updateAcApp(AcApp acApp) throws AppManagementException {
		if(acApp == null) {
			throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_UPDATE, BasicUtil.wrap("AcApp", AcApp.TABLE_NAME));
		}
		try {
			String[] validateField = {
					"guid", "appCode", "appName", "appType", "isopen"
			};
			String validate = BeanFieldValidateUtil.checkObjFieldNotRequired(acApp, validateField);
			if(StringUtils.isNotEmpty(validate)) {
				throw new AppManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, BasicUtil.wrap(validate, AcApp.TABLE_NAME));
			}
			acAppService.update(acApp);
			return acApp;
		} catch (AppManagementException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_UPDATE,
					BasicUtil.wrap(AcApp.TABLE_NAME, e));
		}
	}

	/**
	 * 根据条件查询应用系统(AC_APP)
	 * 
	 * @param wc
	 *            条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcApp> queryAcAppList(WhereCondition wc) throws AppManagementException {
		try {
			return acAppService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_QUERY,
					BasicUtil.wrap(AcApp.TABLE_NAME, e));
		}
	}
	
	/**
	 * 根据条件查询应用系统(AC_APP)
	 * 
	 * @param
	 * @return 满足条件的记录licd
	 */
	@Override
	public List<AcApp> queryAcRootList() throws AppManagementException {
		try {
			return acAppService.query(new WhereCondition());
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_QUERY,
					BasicUtil.wrap(AcApp.TABLE_NAME, e));
		}
	}
	

	/**
	 * 根据条件查询应用系统(AC_APP)
	 * 
	 * @param guid 条件
	 * @return 满足条件的记录
	 */
	@Override
	public AcApp queryAcApp(String guid) throws AppManagementException {
		try {
			List<AcApp> acAppList = acAppService.query(new WhereCondition().andEquals(AcApp.COLUMN_GUID, guid));
			if(acAppList.size()>0){
				return acAppList.get(0);
			}else{
				throw new AppManagementException(
						ExceptionCodes.NOT_FOUND_WHEN_QUERY,BasicUtil.wrap(guid, AcApp.TABLE_NAME));
			}
		} catch (AppManagementException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_QUERY,
					BasicUtil.wrap(AcApp.TABLE_NAME, e));
		}
	}
	
	/**
	 * 新增功能组(AC_FUNCGROUP)
	 * 
	 * @param acFuncgroup
	 *            功能组对象 return AcFuncgroup
	 */
	@Override
	public AcFuncgroup createAcFuncGroup(AcFuncgroup acFuncgroup) throws AppManagementException {
		if(acFuncgroup == null) {
			throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("acFuncgroup", AcFuncgroup.TABLE_NAME));
		}
		try {
			String[] validateFields = {
					"guidApp", "funcgroupName"
			};
			String validate = BeanFieldValidateUtil.checkObjFieldRequired(acFuncgroup, validateFields);
			if (StringUtils.isNotEmpty(validate)) {
				throw new AppManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap(validate, AcFuncgroup.TABLE_NAME));
			}
			String guid = GUID.funcGroup();
			acFuncgroup.setGuid(guid);
			// 根据父功能是否为空设置序列
			if (StringUtils.isEmpty(acFuncgroup.getGuidParents())) {
				acFuncgroup.setGuidParents(null);
				acFuncgroup.setFuncgroupSeq(acFuncgroup.getGuidApp() + "." + guid);
			} else {
				Optional<AcFuncgroup> funcgroupOptional = acFuncgroupService.query(new WhereCondition()
						.andEquals(AcFuncgroup.COLUMN_GUID, acFuncgroup.getGuidParents())).stream().findFirst();
				if (funcgroupOptional.isPresent()) {
					acFuncgroup.setFuncgroupSeq(acFuncgroup.getFuncgroupSeq() + "." + guid);
				} else {
					throw new AppManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY,
							BasicUtil.wrap("AcFuncgroup(" + acFuncgroup.getGuidParents() + ")", AcFuncgroup.TABLE_NAME));
				}
			}
			acFuncgroup.setIsleaf(CommonConstants.YES);// 默认叶子节点
			acFuncgroupService.insert(acFuncgroup);
			return acFuncgroup;
		} catch (AppManagementException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_INSERT,
					BasicUtil.wrap(AcFuncgroup.TABLE_NAME, e));
		}
	}

	/**
	 * 删除功能组(AC_FUNCGROUP)
	 * 
	 * @param guid
	 *            记录guid
	 */
	@Override
	public AcFuncgroup deleteAcFuncGroup(String guid) throws AppManagementException {
		if(StringUtils.isBlank(guid)) {
			throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE,
					BasicUtil.wrap(AcFuncgroup.COLUMN_GUID, AcFuncgroup.TABLE_NAME));
		}
		try {
			AcFuncgroup acFuncgroup;
			Optional<AcFuncgroup> funcgroupOptional = acFuncgroupService.query(new WhereCondition().andEquals(AcFuncgroup.COLUMN_GUID, guid)).stream().findFirst();
			if (funcgroupOptional.isPresent()) {
				acFuncgroup = funcgroupOptional.get();
			} else {
				throw new AppManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY,
						BasicUtil.wrap(BasicUtil.surroundBracketsWithLFStr(AcFuncgroup.COLUMN_GUID, guid), AcFuncgroup.TABLE_NAME));
			}
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				public void doInTransactionWithoutResult(TransactionStatus status) {
					try {
						//删除功能组下子功能组及功能
						WhereCondition wc =new WhereCondition();
						wc.andEquals("GUID_PARENTS", guid);
						List<String> funcgroupGuids = acFuncgroupService.query(new WhereCondition().andFullLike(AcFuncgroup.COLUMN_FUNCGROUP_SEQ, guid))
								.stream()
								.map(AcFuncgroup::getGuid)
								.collect(Collectors.toList());
						acFuncService.deleteByCondition(new WhereCondition().andIn(AcFunc.COLUMN_GUID_FUNCGROUP, funcgroupGuids));
						acFuncgroupService.deleteByCondition(new WhereCondition().andIn(AcFuncgroup.COLUMN_GUID, funcgroupGuids));

					} catch (Exception e) {
						throw new AppManagementException(ExceptionCodes.FAILURE_WHEN_DELETE,
								BasicUtil.wrap(BasicUtil.surroundBracketsWithLFStr(AcFuncgroup.TABLE_NAME, guid), e));
					}
				}
			});
			return acFuncgroup;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(ExceptionCodes.FAILURE_WHEN_DELETE,
					BasicUtil.wrap(BasicUtil.surroundBracketsWithLFStr(AcFuncgroup.TABLE_NAME, guid), e));
		}
	}

	/**
	 * 更新功能组(AC_FUNCGROUP)
	 * @param acFuncgroup 新值
	 */
	@Override
	public AcFuncgroup updateAcFuncgroup(AcFuncgroup acFuncgroup) throws AppManagementException {
		if(acFuncgroup == null) {
			throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_UPDATE, BasicUtil.wrap("acFuncgroup", AcFuncgroup.TABLE_NAME));
		}
		try {
			String[] validateFields = {
					"guid", "guidApp", "funcgroupName"
			};
			String validate = BeanFieldValidateUtil.checkObjFieldRequired(acFuncgroup, validateFields);
			if (StringUtils.isNotEmpty(validate)) {
				throw new AppManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_UPDATE, BasicUtil.wrap(validate, AcFuncgroup.TABLE_NAME));
			}
			acFuncgroupService.update(acFuncgroup);
			return acFuncgroup;
		} catch (AppManagementException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.NOT_ALLOW_NULL_WHEN_UPDATE,
					BasicUtil.wrap(AcFuncgroup.TABLE_NAME, e));
		}
	}
	
	
	/**
	 * 根据条件查询功能组(AC_FUNCGROUP)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcFuncgroup> queryAcFuncgroup(WhereCondition wc)throws AppManagementException {
		List<AcFuncgroup> acFuncgroupList = new ArrayList<AcFuncgroup>();
		
		try {
			acFuncgroupList = acFuncgroupService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCGROUP,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能组失败！{0}");
		}
		return acFuncgroupList;
	}
	
	/**
	 * 根据条件查询功能组(AC_FUNCGROUP)
	 * @param GUID 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public AcFuncgroup queryFuncgroup(String GUID)throws AppManagementException {
		List<AcFuncgroup> acFuncgroupList = new ArrayList<AcFuncgroup>();
		final String guid = GUID;
		try {
			WhereCondition wc = new WhereCondition();
			wc.andEquals("GUID", guid);
			acFuncgroupList = acFuncgroupService.query(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCGROUP,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能组失败！{0}");
		}
		if(acFuncgroupList.size()>0){
			return acFuncgroupList.get(0);
		}
		return null;
	}
	
	
	/**
	 * 根据应用id查询功能组(AC_FUNCGROUP)
	 * @param appGuid
	 * @return 
	 */
	@Override
	public List<AcFuncgroup> queryAcRootFuncgroup(String appGuid)throws AppManagementException {
		List<AcFuncgroup> acFuncList = new ArrayList<AcFuncgroup>();
		
		try {
			WhereCondition wc =new WhereCondition();
			wc.andEquals("GUID_APP", appGuid);
			wc.andIsNull("GUID_PARENTS");
			acFuncList = acFuncgroupService.query(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCGROUP,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能组失败！{0}");
		}
		return acFuncList;
	};
	
	
	/**
	 * 根据功能组ID(AC_FUNCGROUP)
	 * @param guidParent
	 * @return 
	 */
	@Override
	public List<AcFuncgroup> queryAcChildFuncgroup(String guidParent)throws AppManagementException {
		List<AcFuncgroup> acFuncList = new ArrayList<AcFuncgroup>();
		
		try {
			WhereCondition wc =new WhereCondition();
			wc.andEquals("GUID_PARENTS", guidParent);
			wc.setOrderBy("GROUP_LEVEL");
			acFuncList = acFuncgroupService.query(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCGROUP,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能组失败！{0}");
		}
		return acFuncList;
	};
	
	
	/**
	 * 新增功能(AC_FUNC) return AcFunc
	 * 
	 */
	@Override
	public AcFunc createAcFunc(AcFunc acFunc,AcFuncResource acFuncResource) {
		String guid=GUID.func();
		acFuncResource.setGuidFunc(guid);
		acFunc.setGuid(guid);
		final AcFunc newAcFunc = acFunc;
		try {
			acFunc = transactionTemplate
					.execute(new TransactionCallback<AcFunc>() {
						@Override
						public AcFunc doInTransaction(TransactionStatus arg0) {
							acFuncService.insert(newAcFunc);
							acFuncResourceService.insert(acFuncResource);
							return newAcFunc;
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_CREATE_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "新增功能失败！{0}");
		}
		return acFunc;
	}
	
	/**
	 * 删除功能(AC_FUNC)
	 * @param guid 记录guid
	 */
	@Override
	public void deleteAcFunc(String guid)  throws AppManagementException {
		try {
			// 新增事务提交机制
			transactionTemplate.execute(new TransactionCallback<AcFunc>() {
				@Override
				public AcFunc doInTransaction(TransactionStatus arg0) {
					acFuncService.delete(guid);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_DELETE_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "删除功能失败！{0}");
		}
	}

	/**
	 * 更新功能(AC_FUNC)
	 * @param acFunc 功能
	 */
	@Override
	public void updateAcFunc(AcFunc acFunc) throws AppManagementException {
		final AcFunc newAcFunc = acFunc; 
		try {
			transactionTemplate.execute(new TransactionCallback<AcFunc>() {
				@Override
				public AcFunc doInTransaction(TransactionStatus arg0) {
					acFuncService.updateForce(newAcFunc);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_UPDATE_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "更新功能失败！{0}");
		}
	}

	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcFunc> queryAcFunc(WhereCondition wc) throws AppManagementException {
		List<AcFunc> acFuncList = new ArrayList<AcFunc>();
		
		try {
			acFuncList = acFuncService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能失败！{0}");
		}
		return acFuncList;
	}
	
	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param guid 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public AcFunc queryFunc(String guid)throws AppManagementException {
		List<AcFunc> acFuncList = new ArrayList<AcFunc>();
		
		try {
			WhereCondition wc =new WhereCondition();
			wc.andEquals("GUID", guid);
			acFuncList = acFuncService.query(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能失败！{0}");
		}
		if(acFuncList.size()>0){
			return acFuncList.get(0);
		}
		return null;
	}
	
	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param groupGuid 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcFunc> queryAcGroupFunc(String groupGuid)throws AppManagementException {
		List<AcFunc> acFuncList = new ArrayList<AcFunc>();
		
		try {
			WhereCondition wc = new WhereCondition();
			wc.andEquals("GUID_FUNCGROUP", groupGuid);
			acFuncList = acFuncService.query(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能失败！{0}");
		}
		return acFuncList;
	};
	
	/**
	 * 新增菜单(AC_MENU)
	 * 
	 * @param acMenu
	 *            菜单代码 return acMenu
	 */
	@Override
	public AcMenu createAcMenu(AcMenu acMenu) throws AppManagementException{
		String guid = GUID.menu();
		acMenu.setGuid(guid);
		acMenu.setIsleaf(CommonConstants.YES);// 默认叶子菜单
		acMenu.setSubCount(new BigDecimal(0));
		String guidParent = acMenu.getGuidParents();
		String menuSeq = guid;// 默认菜单序列为跟guid
		AcMenu newAcMenu = acMenu;
		newAcMenu.setMenuSeq(menuSeq);
		try {
			acMenu = transactionTemplate
					.execute(new TransactionCallback<AcMenu>() {
						@Override
						public AcMenu doInTransaction(TransactionStatus arg0) {
							if (!guidParent.isEmpty()) {
								WhereCondition wc = new WhereCondition();
								List<AcMenu> parentMenulist = acMenuService
										.query(wc);
								AcMenu parentMenu = parentMenulist.get(0);
								String newmenuSeq = parentMenu.getMenuSeq()
										+ "." + menuSeq;
								newAcMenu.setMenuSeq(newmenuSeq);
								parentMenu
										.setSubCount(new BigDecimal(parentMenu
												.getSubCount().intValue() + 1));// 节点数加1
								acMenuService.update(parentMenu);
							}
							acMenuService.insert(newAcMenu);
							return newAcMenu;
						}
					});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_CREATE_AC_MENU,
					BasicUtil.wrap(e.getCause().getMessage()), "新增菜单失败！{0}");
		}
		return acMenu;
	}

	/**
	 * 删除菜单(AC_MENU)
	 * @param guid 记录guid
	 */
	@Override
	public void deleteAcMenu(String guid) throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcMenu>() {
				@Override
				public AcMenu doInTransaction(TransactionStatus arg0) {
					acMenuService.delete(guid);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_DELETE_AC_MENU,
					BasicUtil.wrap(e.getCause().getMessage()), "删除菜单失败！{0}");
		}
	}

	/**
	 * 更新菜单(AC_MENU),只修改t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void updateAcMenu(AcMenu t) throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcMenu>() {
				@Override
				public AcMenu doInTransaction(TransactionStatus arg0) {
					acMenuService.updateForce(t);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_UPDATE_AC_MENU,
					BasicUtil.wrap(e.getCause().getMessage()), "更新菜单失败！{0}");
		}
	}

	/**
	 * 根据条件查询菜单(AC_MENU)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcMenu> queryAcMenu(WhereCondition wc) throws AppManagementException {
		List<AcMenu> acMenuList = new ArrayList<AcMenu>();
		
		try {
			acMenuList = acMenuService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_MENU,
					BasicUtil.wrap(e.getCause().getMessage()), "查询菜单失败！{0}");
		}
		return acMenuList;
	}

	/**
	 * 新增功能资源对应(AC_FUNC_RESOURCE),新增t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void createAcFuncResource(AcFuncResource t) throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcFuncResource>() {
				@Override
				public AcFuncResource doInTransaction(TransactionStatus arg0) {
					acFuncResourceService.insert(t);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_CREATE_AC_FUNCRESOURCE,
					BasicUtil.wrap(e.getCause().getMessage()), "增加功能对应资源失败！{0}");
		}
	}

	/**
	 * 删除功能资源对应(AC_FUNC_RESOURCE)
	 * @param guid 记录guid
	 */
	@Override
	public void deleteAcFuncResource(String guid) throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcFuncResource>() {
				@Override
				public AcFuncResource doInTransaction(TransactionStatus arg0) {
					acFuncResourceService.delete(guid);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_DELETE_AC_FUNCRESOURCE,
					BasicUtil.wrap(e.getCause().getMessage()), "删除功能对应资源失败！{0}");
		}
	}

	/**
	 * 更新功能资源对应(AC_FUNC_RESOURCE),只修改t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void updateAcFuncResource(AcFuncResource t) throws AppManagementException {
		try {
			// 校验传入参数
			if(StringUtil.isEmpty(t.getGuidFunc())) {
				throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能资源GUID为空{0}");
			}
			acFuncResourceService.updateByCondition(new WhereCondition().andEquals("GUID_FUNC", t.getGuidFunc()), t);

		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_UPDATE_AC_FUNCRESOURCE,
					BasicUtil.wrap(e.getCause().getMessage()), "更新功能对应资源失败！{0}");
		}
	}

	/**
	 * 根据条件查询功能资源对应(AC_FUNC_RESOURCE)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcFuncResource> queryAcFuncResource(WhereCondition wc) throws AppManagementException {
		List<AcFuncResource> acFuncResourceList = new ArrayList<AcFuncResource>();

		try {
			acFuncResourceList = acFuncResourceService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCRESOURCE,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能对应资源失败！{0}");
		}
		return acFuncResourceList;
	}

	/**
	 * 根据条件查询功能资源对应(AC_FUNC_RESOURCE)
	 * @param guid 条件
	 * @return 满足条件的记录
	 */
	@Override
	public AcFuncResource queryFuncResource(String guid) throws AppManagementException {
		List<AcFuncResource> acFuncResourceList = new ArrayList<AcFuncResource>();

		try {
			WhereCondition wc = new WhereCondition();
			wc.andEquals("GUID", guid);
			acFuncResourceList = acFuncResourceService.query(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCRESOURCE,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能对应资源失败！{0}");
		}
		if(acFuncResourceList.size()>0){
			return acFuncResourceList.get(0);
		}
		return null;
	}
	
	/**
	 * 新增操作员(AC_OPERATOR),新增t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void createAcOperator(AcOperator t) throws AppManagementException {
		t.setGuid(GUID.operaor());
		try {
			transactionTemplate.execute(new TransactionCallback<AcOperator>() {
				@Override
				public AcOperator doInTransaction(TransactionStatus arg0) {
					acOperatorService.insert(t);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_CREATE_AC_OPERATOR,
					BasicUtil.wrap(e.getCause().getMessage()), "增加操作员失败！{0}");
		}
	}
		

	/**
	 * 删除操作员(AC_OPERATOR)
	 * @param guid 记录guid
	 */
	@Override
	public void deleteAcOperator(String guid) throws AppManagementException {
		//TODO 删除所有操作员相关资源
		try {
			transactionTemplate.execute(new TransactionCallback<AcOperator>() {
				@Override
				public AcOperator doInTransaction(TransactionStatus arg0) {
					acOperatorService.delete(guid);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_DELETE_AC_OPERATOR,
					BasicUtil.wrap(e.getCause().getMessage()), "删除操作员失败！{0}");
		}
	}

	/**
	 * 更新操作员(AC_OPERATOR),只修改t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void updateAcOperator(AcOperator t) throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcOperator>() {
				@Override
				public AcOperator doInTransaction(TransactionStatus arg0) {
					acOperatorService.updateForce(t);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_UPDATE_AC_OPERATOR,
					BasicUtil.wrap(e.getCause().getMessage()), "更新操作员失败！{0}");
		}
	}

		
	/**
	 * 根据条件查询操作员(AC_OPERATOR)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcOperator> queryAcOperator(WhereCondition wc) throws AppManagementException {
		List<AcOperator> acOperatorList = new ArrayList<AcOperator>();

		try {
			acOperatorList = acOperatorService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCRESOURCE,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能对应资源失败！{0}");
		}
		return acOperatorList;
	}

	/**
	 * 增加功能操作行为(AC_FUNC_BEHAVIOR),增加t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void createAcFuncBehavior(AcFuncBehavior t) throws AppManagementException {
		t.setGuid(GUID.funcBehavior());
		try {
			transactionTemplate.execute(new TransactionCallback<AcFuncBehavior>() {
				@Override
				public AcFuncBehavior doInTransaction(TransactionStatus arg0) {
					acFuncBehaviorService.insert(t);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_CREATE_AC_FUNCBEHAVIOR,
					BasicUtil.wrap(e.getCause().getMessage()), "增加功能操作行为失败！{0}");
		}
	}

	/**
	 * 删除功能操作行为(AC_FUNC_BEHAVIOR)
	 * @param guid 记录guid
	 */
	@Override
	public void deleteAcFuncBehavior(String guid) throws AppManagementException {
		//TODO 删除功能操作行为相关资源
		try {
			transactionTemplate.execute(new TransactionCallback<AcFuncBehavior>() {
				@Override
				public AcFuncBehavior doInTransaction(TransactionStatus arg0) {
					acFuncBehaviorService.delete(guid);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_DELETE_AC_FUNCBEHAVIOR,
					BasicUtil.wrap(e.getCause().getMessage()), "删除功能操作行为失败！{0}");
		}
	}

	/**
	 * 更新功能操作行为(AC_FUNC_BEHAVIOR),只修改t对象有值的字段
	 * @param t 新值
	 */
	@Override
	public void updateAcFuncBehavior(AcFuncBehavior t) throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcFuncBehavior>() {
				@Override
				public AcFuncBehavior doInTransaction(TransactionStatus arg0) {
					acFuncBehaviorService.updateForce(t);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_UPDATE_AC_FUNCBEHAVIOR,
					BasicUtil.wrap(e.getCause().getMessage()), "更新功能操作行为失败！{0}");
		}
	}

	/**
	 * 根据条件查询功能操作行为(AC_FUNC_BEHAVIOR)
	 * @param wc 条件
	 * @return 满足条件的记录list
	 */
	@Override
	public List<AcFuncBehavior> queryAcFuncBehavior(WhereCondition wc) throws AppManagementException {
		List<AcFuncBehavior> acFuncBehaviorList = new ArrayList<AcFuncBehavior>();

		try {
			acFuncBehaviorList = acFuncBehaviorService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNCBEHAVIOR,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能操作行为失败！{0}");
		}
		return acFuncBehaviorList;
	}

	/**
	 * 根据条件查询功能(AC_FUNC)
	 * @param guid 条件
	 * @return 满足条件的记录
	 */
	@Override
	public List<AcFuncVo> queryAcFuncVo(String guid) throws AppManagementException {
		List<AcFuncVo> acFuncVoList = new ArrayList<AcFuncVo>();
		WhereCondition wc = new WhereCondition();
		wc.andEquals("guid_funcgroup", guid);
		try {
			acFuncVoList = applicationService.queryAcFuncVo(wc );
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能失败！{0}");
		}
		return acFuncVoList;
	}

	@Override
	public List<AcFunc> queryAllFunc() throws AppManagementException {
		List<AcFunc> acFuncList = new ArrayList<AcFunc>();
		WhereCondition wc = new WhereCondition();
		try {
			acFuncList = acFuncService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能失败！{0}");
		}
		return acFuncList;
	}

	/**
	 * 导入功能(AC_FUNC)
	 * 
	 * @param guidFuncgroup 功能组guid
	 * @param list 功能列表
	 */
	@Override
	public void importFunc(String guidFuncgroup, List list)throws AppManagementException {
		try {
			transactionTemplate.execute(new TransactionCallback<AcFunc>() {
				@Override
				public AcFunc doInTransaction(TransactionStatus arg0) {
					WhereCondition wc =new WhereCondition();
					for(int i=0;i<list.size();i++){
						wc.clear();
						String guid=(String) list.get(i);
						wc.andEquals("GUID", guid);
						AcFunc acfunc = acFuncService.query(wc).get(0);
						acfunc.setGuidFuncgroup(guidFuncgroup);
						acFuncService.insert(acfunc);//导入功能
					}
					return null;
				}	
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_IMPORT_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()), "导入功能失败！{0}");
		}
	}

	/**
	 * 新增行为类型(AC_BHVTYPE_DEF)
	 * 
	 * @param acBhvtypeDef 行为类型
	 */
	@Override
	public void functypeAdd(AcBhvtypeDef acBhvtypeDef) throws AppManagementException{
		try {
			transactionTemplate.execute(new TransactionCallback<AcBhvtypeDef>() {
				@Override
				public AcBhvtypeDef doInTransaction(TransactionStatus arg0) {
					acBhvtypeDef.setGuid(GUID.bhvtypedef());
					acBhvtypeDefService.insert(acBhvtypeDef);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_CREATE_AC_BHVTYPE_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "新增行为类型失败！{0}");
		}
	}

	/**
	 * 删除行为类型(AC_BHVTYPE_DEF)
	 * 
	 * @param guid 行为类型
	 */
	@Override
	public void functypeDel(String guid) throws AppManagementException{
		try {
			transactionTemplate.execute(new TransactionCallback<AcBhvtypeDef>() {
				@Override
				public AcBhvtypeDef doInTransaction(TransactionStatus arg0) {
					acBhvtypeDefService.delete(guid);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_DELETE_AC_BHVTYPE_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "删除行为类型失败！{0}");
		}
	}

	/**
	 * 修改行为类型(AC_BHVTYPE_DEF)
	 * 
	 * @param acBhvtypeDef 行为类型
	 */
	@Override
	public void functypeEdit(AcBhvtypeDef acBhvtypeDef) throws AppManagementException{
		try {
			transactionTemplate.execute(new TransactionCallback<AcBhvtypeDef>() {
				@Override
				public AcBhvtypeDef doInTransaction(TransactionStatus arg0) {
					acBhvtypeDefService.update(acBhvtypeDef);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_UPDATE_AC_BHVTYPE_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "修改行为类型失败！{0}");
		}
	}

	/**
	 * 查询行为类型(AC_BHVTYPE_DEF)
	 *
	 * 返回list
	 */
	@Override
	public List<AcBhvtypeDef> functypequery() throws AppManagementException{
		List<AcBhvtypeDef> acBhvtypeDef=new ArrayList<AcBhvtypeDef>();
		try {
			WhereCondition wc =new WhereCondition();
			acBhvtypeDef = acBhvtypeDefService.query(wc);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_BHVTYPE_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "查询行为类型失败！{0}");
		}
		return acBhvtypeDef;
	}

	
	/**
	 * 新增功能操作行为(AC_BHV_DEF)
	 * 
	 * @param acBhvDef 功能操作行为
	 */
	@Override
	public void funactAdd(AcBhvDef acBhvDef)  throws AppManagementException{
		try {
			transactionTemplate.execute(new TransactionCallback<AcBhvtypeDef>() {
				@Override
				public AcBhvtypeDef doInTransaction(TransactionStatus arg0) {
					acBhvDef.setGuid(GUID.bhvdef());
					acBhvDefService.insert(acBhvDef);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_CREATE_AC_BHV_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "新增功能操作行为失败！{0}");
		}
	}

	/**
	 * 删除功能操作行为(AC_BHV_DEF)
	 * 
	 * @param guids 条件
	 */
	@Override
	public void funactDel(List guids) throws AppManagementException{

		if(CollectionUtils.isEmpty(guids)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能操作行为GUID数组为空");
		}
		WhereCondition wc = new WhereCondition();
		wc.andIn("GUID_FUNC", guids);
		if(acFuncBhvService.count(wc) > 0) {
			throw new AppManagementException(
					ACExceptionCodes.AC_BHV_DEF_CAN_NOT_DELETE_WHEN_ASSIGNED, "不能删除已经指配的行为类型");
		}
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					acBhvDefService.deleteByCondition(new WhereCondition().andIn("GUID",guids));
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					throw new AppManagementException(
							ACExceptionCodes.FAILURE_WHRN_DELETE_AC_BHV_DEF,
							BasicUtil.wrap(e.getCause().getMessage()), "删除功能操作行为失败！{0}");
				}
			}
		});
	}

	/**
	 * 修改功能操作行为(AC_BHV_DEF)
	 * 
	 * @param acBhvDef 行为类型
	 */
	@Override
	public void funactEdit(AcBhvDef acBhvDef) throws AppManagementException{
		try {
			transactionTemplate.execute(new TransactionCallback<AcBhvDef>() {
				@Override
				public AcBhvDef doInTransaction(TransactionStatus arg0) {
					
					WhereCondition wc =new WhereCondition();
					wc.andEquals("GUID", acBhvDef.getGuid());
					AcBhvDef acBhvDefdata = acBhvDefService.query(wc ).get(0);
					acBhvDefdata.setBhvCode(acBhvDef.getBhvCode());
					acBhvDefdata.setBhvName(acBhvDef.getBhvName());
					acBhvDefService.update(acBhvDefdata);
					return null;
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_UPDATE_AC_BHV_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "修改功能操作行为失败！{0}");
		}
	}

	/**
	 * 查询功能操作行为(AC_BHV_DEF)
	 * 
	 * @param guid 功能操作行为
	 * 返回list
	 */
	@Override
	public List<AcBhvDef> funactQuery(String guid) throws AppManagementException{
		List<AcBhvDef> acBhvDef=new ArrayList<AcBhvDef>();
		try {
			WhereCondition wc =new WhereCondition();
			wc.andEquals("GUID_BEHTYPE", guid);
			acBhvDef = acBhvDefService.query(wc);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_BHV_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "查询功能操作行为失败！{0}");
		}
		return acBhvDef;
	}


	/**
	 * 通过功能UID查询所有功能操作行为(AC_BHV_DEF)
	 *
	 * @param funcGuid 功能GUID
	 * 返回list
	 */
	@Override
	public List<AcBhvtypeDef> queryBhvtypeDefByFunc(String funcGuid) throws AppManagementException {
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		List<AcBhvtypeDef> acBhvtypeDefList = new ArrayList<>();
		try {
			WhereCondition wc =new WhereCondition();
			acBhvtypeDefList = applicationService.queryBhvtypeDefByFunc(funcGuid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_BHVTYPE_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "查询行为类型失败！{0}");
		}
		return acBhvtypeDefList;
	}

	/**
	 * 通过行为类型的GUID查询所有的操作行为
	 * @param bhvtypeGuid 行为类型GUID
	 * @return List<AcBhvDef>
	 */
	@Override
	public List<AcBhvDef> queryBhvDefByBhvType(String bhvtypeGuid) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(bhvtypeGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "行为类型GUID为空{0}");
		}
		List<AcBhvDef> acBhvDefList = new ArrayList<>();
		try {
			WhereCondition wc =new WhereCondition();
			wc.andEquals("GUID_BEHTYPE", bhvtypeGuid);
			acBhvDefList = acBhvDefService.query(wc);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_BHV_DEF,
					BasicUtil.wrap(e.getCause().getMessage()), "查询操作行为失败！{0}");
		}
		return acBhvDefList;
	}

	/**
	 * 功能添加行为类型
	 * @param funcGuid 功能GUID
	 * @param bhvtypeGuids 行为类型GUID数组
	 */
	@Override
	public void addBhvtypeForFunc(String funcGuid, List bhvtypeGuids) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		if(CollectionUtils.isEmpty(bhvtypeGuids)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "行为类型GUID数组为空{0}");
		}
		if(acFuncBhvtypeService.count(
				new WhereCondition()
						.andEquals("GUID_FUNC", funcGuid)
						.andIn("GUID_BHVTYPE", bhvtypeGuids)) > 0) {
			throw new AppManagementException(ACExceptionCodes.DUPLICATE_ADD_FUNC_BHVTYPE, "重复添加功能行为类型{0}");
		}
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					for(Object bhvtypeGuid : bhvtypeGuids) {
						AcFuncBhvtype afb = new AcFuncBhvtype();
						afb.setGuidBhvtype((String) bhvtypeGuid);
						afb.setGuidFunc(funcGuid);
						acFuncBhvtypeService.insert(afb);
					}
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					throw new AppManagementException(
							ACExceptionCodes.FAILURE_WHEN_CREATE_AC_FUNC_BHVTYPE,
							BasicUtil.wrap(e.getCause().getMessage()), "新增功能行为类型失败！{0}");
				}
			}
		});
	}

	/**
	 * 功能添加行为定义
	 * @param funcGuid 功能GUID
	 * @param bhvDefGuids 行为类型GUID数组
	 */
	@Override
	public void addBhvDefForFunc(String funcGuid, List bhvDefGuids) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		if(CollectionUtils.isEmpty(bhvDefGuids)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "行为定义GUID数组为空{0}");
		}
		if(acFuncBhvService.count(
				new WhereCondition()
						.andEquals("GUID_FUNC", funcGuid)
						.andIn("GUID_BHV", bhvDefGuids)) > 0) {
			throw new AppManagementException(ACExceptionCodes.DUPLICATE_ADD_FUNC_BHV_DEF, "重复添加功能行为定义{0}");
		}
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					for(Object bhvDefGuid : bhvDefGuids) {
						AcFuncBhv afb = new AcFuncBhv();
						afb.setGuid(GUID.funcBehavior());
						afb.setGuidBhv((String) bhvDefGuid);
						afb.setGuidFunc(funcGuid);
						afb.setIseffective(CommonConstants.YES);
						acFuncBhvService.insert(afb);
					}
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					throw new AppManagementException(
							ACExceptionCodes.FAILURE_WHEN_CREATE_AC_FUNC_BHV,
							BasicUtil.wrap(e.getCause().getMessage()), "新增功能行为定义失败！{0}");
				}
			}
		});
	}

	/**
	 * queryBhcDefForFunc 查询功能下的行为类型的行为定义
	 *
	 * @param funcGuid
	 * @param bhvtypeGuid
	 * @return List<AcBhvDef>
	 */
	@Override
	public List<Map> queryBhvDefInTypeForFunc(String funcGuid, String bhvtypeGuid) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		if(StringUtil.isEmpty(bhvtypeGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "行为类型GUID为空{0}");
		}
		return applicationService.queryBhvDefInTypeForFunc(funcGuid, bhvtypeGuid);
	}

	/**
	 * queryAllBhcDefForFunc 查询功能下的行所有行为定义
	 *
	 * @param funcGuid
	 * @return List<AcBhvDef>
	 */
	@Override
	public List<Map> queryAllBhvDefForFunc(String funcGuid) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		return applicationService.queryAllBhvDefForFunc(funcGuid);
	}

	/**
	 * 删除功能下的行为类型
	 *
	 * @param funcGuid
	 * @param bhvtypeGuid
	 */
	@Override
	public void delFuncBhvType(String funcGuid, List<String> bhvtypeGuid) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		if(CollectionUtils.isEmpty(bhvtypeGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "行为类型GUID数组为空{0}");
		}
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					WhereCondition wc = new WhereCondition();
					wc.andEquals("GUID_FUNC", funcGuid).andIn("GUID_BHVTYPE", bhvtypeGuid);
					acFuncBhvtypeService.deleteByCondition(wc);

					wc.clear();
					wc.andEquals("GUID_FUNC", funcGuid).andIn("GUID_BEHTYPE", bhvtypeGuid);
					List<Map> maps = applicationService.queryFuncBhvRelation(wc);
					List bhvGuids = new ArrayList();
					for(Map map : maps) {
						bhvGuids.add(map.get("GUID_BHV"));
					}
					if(!CollectionUtils.isEmpty(bhvGuids)) {
						acFuncBhvService.deleteByCondition(
								new WhereCondition()
										.andEquals("GUID_FUNC", funcGuid)
										.andIn("GUID_BHV", bhvGuids));
					}
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					throw new AppManagementException(
							ACExceptionCodes.FAILURE_WHEN_CREATE_AC_FUNC_BHV,
							BasicUtil.wrap(e.getCause().getMessage()), "删除功能行为类型失败！{0}");
				}
			}
		});
	}

	/**
	 * 删除功能下的行为定义
	 *
	 * @param funcGuid
	 * @param bhvDefGuid
	 */
	@Override
	public void delFuncBhvDef(String funcGuid, List<String> bhvDefGuid) throws AppManagementException{
		// 校验传入参数
		if(StringUtil.isEmpty(funcGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		if(CollectionUtils.isEmpty(bhvDefGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, "功能GUID为空{0}");
		}
		try {
			acFuncBhvService.deleteByCondition(
				new WhereCondition()
						.andEquals("GUID_FUNC", funcGuid)
						.andIn("GUID_BHV", bhvDefGuid));
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_CREATE_AC_FUNC_BHV,
					BasicUtil.wrap(e.getCause().getMessage()), "删除功能行为定义失败！{0}");
		}
	}

	/**
	 * 开通应用
	 *
	 * @param appGuid
	 * @param openDate
	 */
	@Override
	public void enableApp(String appGuid, Date openDate) {
		// 校验传入参数
		if(StringUtil.isEmpty(appGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, BasicUtil.wrap("appGuid"));
		}
		if(null == openDate) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, BasicUtil.wrap("openDate"));
		}
		try {
			AcApp app = new AcApp();
			app.setIsopen(CommonConstants.YES);//设置开通状态为YES
			app.setOpenDate(openDate); //设置开通时间
			acAppService.updateByCondition(
					new WhereCondition().andEquals("GUID", appGuid), app);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_ENABLE_ACAPP,
					BasicUtil.wrap(e.getCause().getMessage()));
		}
	}

	/**
	 * 关闭应用
	 *
	 * @param appGuid
	 */
	@Override
	public void disableApp(String appGuid) {
		// 校验传入参数
		if(StringUtil.isEmpty(appGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, BasicUtil.wrap("appGuid"));
		}
		try {
			AcApp app = new AcApp();
			app.setIsopen(CommonConstants.NO);//设置开通状态为YES
			app.setOpenDate(null); //设置开通时间为空
			acAppService.updateByCondition(
					new WhereCondition().andEquals("GUID", appGuid), app);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHEN_DISABLE_ACAPP,
					BasicUtil.wrap(e.getCause().getMessage()));
		}
	}

	/**
	 * 查询应用下所有功能
	 *
	 * @param appGuid 应用GUID
	 */
	@Override
	public List<AcFunc> queryFuncListInApp(String appGuid) {
		// 校验传入参数
		if(StringUtil.isEmpty(appGuid)) {
			throw new AppManagementException(ACExceptionCodes.PARMS_NOT_ALLOW_EMPTY, BasicUtil.wrap("appGuid"));
		}
		try {
			return applicationService.queryFuncListInApp(appGuid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ACExceptionCodes.FAILURE_WHRN_QUERY_AC_FUNC,
					BasicUtil.wrap(e.getCause().getMessage()));
		}
	}

	/**
	 * 查询操作员已拥有的应用集合
	 *
	 * @param userId 用户ID
	 * @return
	 * @throws AppManagementException
	 */
	@Override
	public List<AcApp> queryOperatorAllApp(String userId) throws AppManagementException {
		try {
			// 校验传入参数
			if(StringUtil.isEmpty(userId)) {
				throw new AppManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap("USER_ID", "AC_APP"));
			}
			/** 查询用户对应员工*/
			List<OmEmployee> employees = omEmployeeService.query(new WhereCondition().andEquals(OmEmployee.COLUMN_USER_ID, userId));
			if (employees.size() != 1) {
				throw new AppManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap(userId, "AC_EMPLOYEE"));
			}
			return applicationService.queryEmpAllApp(employees.get(0).getGuid());
		} catch (AppManagementException ae) {
			throw ae;
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppManagementException(
					ExceptionCodes.FAILURE_WHEN_QUERY,
					BasicUtil.wrap("AC_APP", e.getCause().getMessage()));
		}
	}

}
