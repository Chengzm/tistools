package org.tis.tools.rservice.om.capable;

import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.base.exception.ToolsRuntimeException;
import org.tis.tools.common.utils.StringUtil;
import org.tis.tools.core.exception.ExceptionCodes;
import org.tis.tools.model.def.GUID;
import org.tis.tools.model.def.OMConstants;
import org.tis.tools.model.po.om.*;
import org.tis.tools.model.vo.om.OmEmployeeDetail;
import org.tis.tools.rservice.BaseRService;
import org.tis.tools.rservice.om.exception.EmployeeManagementException;
import org.tis.tools.rservice.om.exception.GroupManagementException;
import org.tis.tools.rservice.om.exception.OrgManagementException;
import org.tis.tools.service.ac.exception.ACExceptionCodes;
import org.tis.tools.service.om.*;
import org.tis.tools.service.om.exception.OMExceptionCodes;

import java.util.*;
import java.util.stream.Collectors;

import static org.tis.tools.common.utils.BasicUtil.wrap;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false, rollbackFor = Exception.class)
public class OmEmployeeRServicelmpl extends BaseRService implements IEmployeeRService {
	@Autowired
	OmEmployeeService omEmployeeService;
	@Autowired
	OmEmpOrgService omEmpOrgService;
	@Autowired
	OmEmpPositionService omEmpPositionService;
	@Autowired
	OmEmpGroupService omEmpGroupService;
	@Autowired
	OmOrgService OmOrgService;
	@Autowired
	IOrgRService orgRService;
	@Autowired
	OmPositionService omPositionService;
	@Autowired
	IPositionRService positionRService;
	@Autowired
	BOSHGenEmpCode boshGenEmpCode;
	@Autowired
	OmGroupService omGroupService;
	@Autowired
	OmDutyService omDutyService;

	@Autowired
	OmCommonRService omCommonRService;

	@Autowired
	OmOrgServiceExt orgServiceExt;

	@Override
	public String genEmpCode(String orgCode, String empDegree) throws ToolsRuntimeException {
		//todo
		return boshGenEmpCode.genEmpCode();
	}

	@Override
	public OmEmployee createEmployee(String empCode, String empName, String gender, String empDegree, String orgCode,
			String positionCode) throws ToolsRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * <pre>
	 * 新增员工
	 * 
	 * 说明：
	 * 系统检查“员工代码、员工姓名、性别...”等必输字段，通过后，补充其余必要字段（如：员工状态）后新建员工；
	 * 新建后，员工状态停留在‘在招’；
	 * </pre>
	 * 
	 * @param newEmployee
	 *            新员工信息
	 * @return 新建员工
	 * @throws ToolsRuntimeException
	 */
	@Override
	public OmEmployee createEmployee(OmEmployee newEmployee) throws ToolsRuntimeException {
		// 验证传入参数
		if (StringUtil.isEmpty(newEmployee.getEmpName())) {
			throw new OrgManagementException(OMExceptionCodes.LAKE_PARMS_FOR_CREATE_EMPLOYEE,
					new Object[] { "EmpName" });
		}
		if (StringUtil.isEmpty(newEmployee.getGender())) {
			throw new OrgManagementException(OMExceptionCodes.LAKE_PARMS_FOR_CREATE_EMPLOYEE,
					new Object[] { "Gender" });
		}
		if (StringUtil.isEmpty(newEmployee.getEmpDegree())) {
			throw new OrgManagementException(OMExceptionCodes.LAKE_PARMS_FOR_CREATE_EMPLOYEE,
					new Object[] { "EmpDegree" });
		}
//		if (StringUtil.isEmpty(newEmployee.getGuidPosition())) {
//			throw new OrgManagementException(OMExceptionCodes.LAKE_PARMS_FOR_CREATE_EMPLOYEE,
//					new Object[] { "GuidPosition" });
//		}
		// 补充信息
		newEmployee.setGuid(GUID.employee());
		newEmployee.setEmpCode(boshGenEmpCode.genEmpCode());
		newEmployee.setEmpstatus(OMConstants.EMPLOYEE_STATUS_OFFER);
		newEmployee.setRegdate(new Date());
		newEmployee.setCreatetime(new Date());
		newEmployee.setLastmodytime(new Date());
//		OmEmpOrg eoe = new OmEmpOrg();
//		eoe.setGuidEmp(newEmployee.getGuid());
//		eoe.setGuidOrg(newEmployee.getGuidOrg());
//		eoe.setIsmain("Y");
//		OmEmpPosition oep = new OmEmpPosition();
//		oep.setGuidPosition(newEmployee.getGuidPosition());
//		oep.setGuidEmp(newEmployee.getGuid());
//		oep.setIsmain("Y");
		// 新增人员
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			public void doInTransactionWithoutResult(TransactionStatus status) {
				try {
					omEmployeeService.insert(newEmployee);
//					omEmpOrgService.insert(eoe);
//					omEmpPositionService.insert(oep);
				} catch (Exception e) {
					status.setRollbackOnly();
					e.printStackTrace();
					throw new OrgManagementException(OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
							wrap(e.getCause().getMessage()), "新增员工失败！{0}");
				}
			}
		});
		return newEmployee;
	}

	@Override
	public OmEmployee copyEmployee(String fromEmpCode) throws ToolsRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OmEmployee copyEmployee(String fromOrgCode, String fromEmpCode, String toOrgCode)
			throws ToolsRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OmEmployee copyEmployeeDeep(String fromEmpCode, EmployeeCopyConfig copyConfig)
			throws ToolsRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 指派
	 * @param empCode
	 *            员工代码
	 * @param orgCode
	 *            所属机构代码
	 * @param isMain
	 *            是否为主机构 </br>
	 *            true - 指定为主机构</br>
	 * @throws ToolsRuntimeException
	 */
	@Override
	public void assignOrg(String empCode, String orgCode, boolean isMain) throws ToolsRuntimeException {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(orgCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		//isMain,是主机构先更新员工信息
		OmEmployee emp = queryEmployeeBrief(empCode);
		OmOrg org = orgRService.queryOrg(orgCode);
		if(isMain){
			//指定新的主机构
			fixMainOrg(empCode, orgCode);
		}else{//不是主机构,仅操作emporg
			OmEmpOrg newOeo = new OmEmpOrg();
			newOeo.setGuidEmp(emp.getGuid());
			newOeo.setGuidOrg(org.getGuid());
			newOeo.setIsmain("N");
			omEmpOrgService.insert(newOeo);
		}


	}

	/**
	 *
	 * @param empCode
	 *            员工代码
	 * @param mainOrgCode
	 *            机构代码，作为员工的最新主机构
	 * @throws ToolsRuntimeException
	 */
	@Override
	public OmEmpOrg fixMainOrg(String empCode, String mainOrgCode) throws ToolsRuntimeException {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(mainOrgCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		// 返回的员工机构对象
		OmEmpOrg[] retObj = new OmEmpOrg[1];
		OmEmployee emp = queryEmployeeBrief(empCode);
		OmOrg org = orgRService.queryOrg(mainOrgCode);
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmpOrg.COLUMN_ISMAIN, "Y");
		wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, emp.getGuid());
		List<OmEmpOrg> oeoList = omEmpOrgService.query(wc);

		//判断是新增信息,还是已经存在
		wc.clear();
		wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, emp.getGuid());
		wc.andEquals(OmEmpOrg.COLUMN_GUID_ORG, org.getGuid());
		List<OmEmpOrg> list = omEmpOrgService.query(wc);
		if(list.size() != 1){
			//新增
			//插入新信息
			OmEmpOrg newOeo = new OmEmpOrg();
			newOeo.setGuidEmp(emp.getGuid());
			newOeo.setGuidOrg(org.getGuid());
			newOeo.setIsmain("Y");
			// 启动事务
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				public void doInTransactionWithoutResult(TransactionStatus status) {
					try {
						//判断是否有主机构
						if (!oeoList.isEmpty()) {
							OmEmpOrg oeo = oeoList.get(0);
							oeo.setIsmain("N");
							wc.clear();
							wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, oeo.getGuidEmp());
							wc.andEquals(OmEmpOrg.COLUMN_GUID_ORG, oeo.getGuidOrg());
							omEmpOrgService.updateByCondition(wc,oeo);
						}
						//插入一条新信息
						omEmpOrgService.insert(newOeo);
						retObj[0] = newOeo;
						//更新员工信息
						emp.setGuidOrg(newOeo.getGuidOrg());
						omEmployeeService.update(emp);
					} catch (Exception e) {
						status.setRollbackOnly();
						e.printStackTrace();
						throw new EmployeeManagementException(
								OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
								wrap(e.getCause().getMessage()), "指派失败{0}");
					}
				}
			});
		}else{
			//修改
			if(list.get(0).getIsmain().equals("Y")){
				//本身数据为主机构,抛出异常,不做任何处理
				throw new EmployeeManagementException(
						OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
						wrap("已经为主机构"));
			}else{
				//更新数据
				OmEmpOrg newOeo = list.get(0);
				newOeo.setIsmain("Y");
				// 启动事务
				transactionTemplate.execute(new TransactionCallbackWithoutResult() {
					@Override
					public void doInTransactionWithoutResult(TransactionStatus status) {
						try {
							//判断是否有主机构
							if(!oeoList.isEmpty()){
								OmEmpOrg oeo = oeoList.get(0);
								oeo.setIsmain("N");
								wc.clear();
								wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, oeo.getGuidEmp());
								wc.andEquals(OmEmpOrg.COLUMN_GUID_ORG, oeo.getGuidOrg());
								omEmpOrgService.updateByCondition(wc,oeo);
							}
							wc.clear();
							wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, newOeo.getGuidEmp());
							wc.andEquals(OmEmpOrg.COLUMN_GUID_ORG, newOeo.getGuidOrg());
							omEmpOrgService.updateByCondition(wc,newOeo);
							retObj[0] = newOeo;
							//更新员工信息
							emp.setGuidOrg(newOeo.getGuidOrg());
							omEmployeeService.update(emp);
						} catch (Exception e) {
							status.setRollbackOnly();
							e.printStackTrace();
							throw new EmployeeManagementException(
									OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
									wrap(e.getCause().getMessage()), "指派失败{0}");
						}
					}
				});
			}
		}
		return retObj[0];
	}

	@Override
	public OmEmpPosition assignPosition(String empCode, String positionCode, boolean isMain) throws ToolsRuntimeException {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(positionCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		//isMain,是主机构先更新员工信息
		OmEmpPosition newOep = new OmEmpPosition();
		OmEmployee emp = queryEmployeeBrief(empCode);
		OmPosition op = positionRService.queryPosition(positionCode);
		if(isMain){
			//指定新的主机构
			fixMainPosition(empCode, positionCode);
		}else{//不是主机构,仅操作emporg
			newOep.setGuidEmp(emp.getGuid());
			newOep.setGuidPosition(op.getGuid());
			newOep.setIsmain("N");
			omEmpPositionService.insert(newOep);
		}
		return newOep;
	}

	@Override
	public OmEmpPosition fixMainPosition(String empCode, String positionCode) throws ToolsRuntimeException {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(positionCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		final OmEmpPosition[] retObj = {new OmEmpPosition()};
		OmEmployee emp = queryEmployeeBrief(empCode);
		OmPosition op = positionRService.queryPosition(positionCode);
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmpPosition.COLUMN_ISMAIN, "Y");
		wc.andEquals(OmEmpPosition.COLUMN_GUID_EMP, emp.getGuid());
		List<OmEmpPosition> oepList = omEmpPositionService.query(wc);

		//判断是新增信息,还是已经存在
		wc.clear();
		wc.andEquals(OmEmpPosition.COLUMN_GUID_EMP, emp.getGuid());
		wc.andEquals(OmEmpPosition.COLUMN_GUID_POSITION, op.getGuid());
		List<OmEmpPosition> list = omEmpPositionService.query(wc);
		if(list.size() != 1){
			//新增
			//插入新信息
			OmEmpPosition newOep = new OmEmpPosition();
			newOep.setGuidEmp(emp.getGuid());
			newOep.setGuidPosition(op.getGuid());
			newOep.setIsmain("Y");
			// 启动事务
			transactionTemplate.execute(new TransactionCallbackWithoutResult() {
				@Override
				public void doInTransactionWithoutResult(TransactionStatus status) {
					try {
						if(!oepList.isEmpty()){
							OmEmpPosition oep = oepList.get(0);
							oep.setIsmain("N");
							wc.clear();
							wc.andEquals(OmEmpPosition.COLUMN_GUID_EMP, oep.getGuidEmp());
							wc.andEquals(OmEmpPosition.COLUMN_GUID_POSITION, oep.getGuidPosition());
							omEmpPositionService.updateByCondition(wc,oep);
						}

						//插入一条新信息
						omEmpPositionService.insert(newOep);
						retObj[0] = newOep;
						//更新员工信息
						emp.setGuidPosition(newOep.getGuidPosition());
						omEmployeeService.update(emp);
					} catch (Exception e) {
						status.setRollbackOnly();
						e.printStackTrace();
						throw new EmployeeManagementException(
								OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
								wrap(e.getCause().getMessage()), "指派失败{0}");
					}
				}
			});
		}else{
			//修改
			if(list.get(0).getIsmain().equals("Y")){
				//本身数据为主机构,抛出异常,不做任何处理
				throw new EmployeeManagementException(
						OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
						wrap("已经为主机构"));
			}else{
				//更新数据
				OmEmpPosition newOep = list.get(0);
				newOep.setIsmain("Y");
				// 启动事务
				transactionTemplate.execute(new TransactionCallbackWithoutResult() {
					@Override
					public void doInTransactionWithoutResult(TransactionStatus status) {
						try {
							if(!oepList.isEmpty()){
								OmEmpPosition oep = oepList.get(0);
								oep.setIsmain("N");
								wc.clear();
								wc.andEquals(OmEmpPosition.COLUMN_GUID_EMP, oep.getGuidEmp());
								wc.andEquals(OmEmpPosition.COLUMN_GUID_POSITION, oep.getGuidPosition());
								omEmpPositionService.updateByCondition(wc,oep);
							}
							wc.clear();
							wc.andEquals(OmEmpPosition.COLUMN_GUID_EMP, newOep.getGuidEmp());
							wc.andEquals(OmEmpPosition.COLUMN_GUID_POSITION, newOep.getGuidPosition());
							omEmpPositionService.updateByCondition(wc,newOep);
							retObj[0] = newOep;
							//更新员工信息
							emp.setGuidPosition(newOep.getGuidPosition());
							omEmployeeService.update(emp);
						} catch (Exception e) {
							status.setRollbackOnly();
							e.printStackTrace();
							throw new EmployeeManagementException(
									OMExceptionCodes.FAILURE_WHRN_CREATE_ROOT_ORG,
									wrap(e.getCause().getMessage()), "指派失败{0}");
						}
					}
				});
			}
		}
		return retObj[0];
	}

	@Override
	public OmEmployee updateEmployee(OmEmployee newEmployee) throws ToolsRuntimeException {
		WhereCondition wc = new WhereCondition();
		wc.andEquals("EMP_CODE", newEmployee.getEmpCode());
		List<OmEmployee> empList = omEmployeeService.query(wc);
		if (empList.size() != 1) {
			throw new OrgManagementException(OMExceptionCodes.EMPANIZATION_NOT_EXIST_BY_EMP_CODE,
					wrap(newEmployee.getEmpCode()), "员工代码代码{0}对应的员工不存在");
		}
		OmEmployee oldEmp = empList.get(0);
		String oldEmpStatus = oldEmp.getEmpstatus();
		String EmpStatus = newEmployee.getEmpstatus();
		if (!oldEmpStatus.equals(EmpStatus)) {
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHEN_UPDATE_EMP_STATUS, null,
					"员工状态不能直接通过修改而更新！{0}");
		}
		try {
			omEmployeeService.update(newEmployee);
			return newEmployee;
		} catch (Exception e) {
			e.printStackTrace();
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHEN_UPDATE_ORG_APP,
					wrap(e));
		}

	}

	@Override
	public OmEmployee moveToNewOrg(String empCode, String fromOrgCode, String toOrgCode, boolean isMain)
			throws ToolsRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OmEmployee moveToNewPosition(String empCode, String fromPositionCode, String toPositionCode, boolean isMain)
			throws ToolsRuntimeException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过员工编号删除员工信息
	 */
	@Override
	public OmEmployee deleteEmployee(String empCode) throws ToolsRuntimeException {
		WhereCondition wc = new WhereCondition();
		wc.andEquals("EMP_CODE", empCode);
		List<OmEmployee> empList = omEmployeeService.query(wc);
		if(empList.size() != 1){
			throw new EmployeeManagementException(OMExceptionCodes.EMPANIZATION_NOT_EXIST_BY_EMP_CODE,
					wrap(empCode));
		}
		OmEmployee employee = empList.get(0);
		if (StringUtils.equals(OMConstants.EMPLOYEE_STATUS_ONJOB, employee.getEmpstatus())) {
			throw new EmployeeManagementException(OMExceptionCodes.FAILURE_WHEN_DEL_NOT_ONJOB,
					wrap(empCode, employee.getEmpstatus()));
		}

		final String guid =employee.getGuid();
		try {
			transactionTemplate.execute(new TransactionCallback<String>() {
				@Override
				public String doInTransaction(TransactionStatus arg0) {
					// 删除员工信息
					omEmployeeService.delete(guid);
					//删除员工-岗位信息
					wc.clear();
					wc.andEquals("GUID_EMP", guid);
					omEmpPositionService.deleteByCondition(wc);
					//删除员工-机构信息
					omEmpOrgService.deleteByCondition(wc);
					//删除员工-工作组
					omEmpGroupService.deleteByCondition(wc);
					return null;
				}
			});

		} catch (Exception e) {
			e.printStackTrace();
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHRN_DEEP_COPY_ORG,
					wrap(employee.getEmpCode(), e.getCause().getMessage()));
		} finally {
			return employee;
		}
	}

	@Override
	public OmEmployee queryEmployeeBrief(String empCode) {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmployee.COLUMN_EMP_CODE,empCode);
		List<OmEmployee> empList = omEmployeeService.query(wc);
		if(empList.size() != 1){
			throw new EmployeeManagementException(OMExceptionCodes.EMPANIZATION_NOT_EXIST_BY_EMP_CODE,
					wrap(empCode));
		}
		return empList.get(0);
	}

	@Override
	public OmEmployeeDetail queryEmployeeDetail(String empCode) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过orgCode查询机构下员工列表
	 */
	@Override
	public List<OmEmployee> queryEmployeeByOrg(String orgCode, OmEmployee empCondition) {
		//校验入参
		if(StringUtil.isEmpty(orgCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		WhereCondition wc = new WhereCondition();
		wc.andEquals("ORG_CODE", orgCode);
		List<OmOrg> ogList = OmOrgService.query(wc);
		if(ogList.size() != 1){
			throw new EmployeeManagementException(OMExceptionCodes.ORGANIZATION_NOT_EXIST_BY_ORG_CODE,
					wrap(orgCode));
		}
		String orgGuid = ogList.get(0).getGuid();
		List<OmEmployee> empList = queryEmployeeByGuid(orgGuid);
		return empList;
	}

	@Override
	public List<OmEmployee> queryEmployeeByGuid(String orgGuid) {
		WhereCondition wc = new WhereCondition();
		wc.andEquals("GUID_ORG", orgGuid);
		List<OmEmpOrg> list = omEmpOrgService.query(wc);
		if(list.isEmpty()){
			return null;
		}else{
			List<String> list2 = new ArrayList<>();
			for (OmEmpOrg oeo : list) {
				list2.add(oeo.getGuidEmp());
			}
			wc.clear();
			wc.andIn("GUID", list2);
			List<OmEmployee> l = omEmployeeService.query(wc);
			return l;
		}
		
	}
	/**
	 * 查询不在此机构下的人员信息
	 */
	@Override
	public List<OmEmployee> queryEmployeeNotinGuid(String orgGuid) {
		WhereCondition wc = new WhereCondition();
		wc.andEquals("GUID_ORG", orgGuid);
		List<OmEmpOrg> list = omEmpOrgService.query(wc);
		List<String> list2 = new ArrayList<>();
		for (OmEmpOrg oeo : list) {
			list2.add(oeo.getGuidEmp());
		}
		wc.clear();
		wc.andNotIn("GUID", list2);
		List<OmEmployee> l = omEmployeeService.query(wc);
		return l;
	}
	/**
	 * 添加人员-机构关系表数据
	 */
	@Override
	public OmEmpOrg insertEmpOrg(String orgGuid, String empGuid) {
		//校验入参
		if(StringUtil.isEmpty(orgGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(empGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		OmEmpOrg oeo = new OmEmpOrg();
		oeo.setGuidEmp(empGuid);
		oeo.setGuidOrg(orgGuid);
		oeo.setIsmain("N");//默认为否
		omEmpOrgService.insert(oeo);
		return oeo;
	}
	/**
	 * 删除
	 */
	@Override
	public OmEmpOrg deleteEmpOrg(String orgGuid, String empGuid) {
		//校验入参
		if(StringUtil.isEmpty(orgGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(empGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmployee.COLUMN_GUID, empGuid);
		List<OmEmployee> list = omEmployeeService.query(wc);
		String guidOrg = list.get(0).getGuidOrg();
		if (orgGuid.equals(guidOrg)) {
			//TODO
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHRN_CREAT_BUSIORG,null,"不可直接取消主岗位指派");
			//不可直接取消主机构指派
		}
		wc.clear();
		wc.andEquals("GUID_ORG", orgGuid);
		wc.andEquals("GUID_EMP", empGuid);
		omEmpOrgService.deleteByCondition(wc);
		// 删除对应操作员身份资源下的机构
		String userId = list.get(0).getUserId();
		omCommonRService.deleteOperatorIdentityRes(userId, orgGuid);
		OmEmpOrg empOrg = new OmEmpOrg();
		empOrg.setGuidEmp(empGuid);
		empOrg.setGuidOrg(orgGuid);
		return empOrg;
	}
	

	@Override
	public void insertEmpPosition(String positionGuid, String empGuid) {
		//校验入参
		if(StringUtil.isEmpty(positionGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(empGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		OmEmpPosition oep = new OmEmpPosition();
		oep.setGuidEmp(empGuid);
		oep.setGuidPosition(positionGuid);
		oep.setIsmain("N");
		omEmpPositionService.insert(oep);
	}

	@Override
	public void deleteEmpPosition(String positionGuid, String empGuid) {
		//校验入参
		if(StringUtil.isEmpty(positionGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(empGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmployee.COLUMN_GUID, empGuid);
		List<OmEmployee> list = omEmployeeService.query(wc);
		String posGuid = list.get(0).getGuidPosition();
		if (positionGuid.equals(posGuid)) {
			//TODO
			throw new OrgManagementException(OMExceptionCodes.FAILURE_WHRN_CREAT_BUSIORG,null,"不可直接取消主岗位指派");
			//不可直接取消主机构指派
		}
		wc.clear();
		wc.andEquals("GUID_POSITION", positionGuid);
		wc.andEquals("GUID_EMP", empGuid);
		omEmpPositionService.deleteByCondition(wc);
		// 删除对应操作员身份关联资源
		omCommonRService.deleteOperatorIdentityRes(list.get(0).getUserId(), positionGuid);
		omCommonRService.deleteOperatorIdentityRes(list.get(0).getUserId(), posGuid);
	}

	@Override
	public void insertEmpGroup(String groupGuid, String empGuid) throws EmployeeManagementException {
		//校验入参
		if(StringUtil.isEmpty(groupGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(empGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		try {
			OmEmpGroup oeg = new OmEmpGroup();
			oeg.setGuidEmp(empGuid);
			oeg.setGuidGroup(groupGuid);
			omEmpGroupService.insert(oeg);
		} catch (Exception e) {
			logger.error("insertEmpGroup exception: ", e);
			throw new EmployeeManagementException(ExceptionCodes.FAILURE_WHEN_INSERT, wrap(OmEmpGroup.TABLE_NAME, e));
		}
	}

	@Override
	public void deleteEmpGroup(String groupGuid, String empGuid) {
		//校验入参
		if(StringUtil.isEmpty(groupGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if(StringUtil.isEmpty(empGuid)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		WhereCondition wc = new WhereCondition();
		wc.andEquals("GUID_GROUP", groupGuid);
		wc.andEquals("GUID_EMP", empGuid);
		omEmpGroupService.deleteByCondition(wc);
		// 删除对应操作员身份关联资源
		OmEmployee omEmployee = omEmployeeService.loadByGuid(empGuid);
		omCommonRService.deleteOperatorIdentityRes(omEmployee.getUserId(), groupGuid);
	}

	/**
	 * 查询所有员工信息
	 */
	@Override
	public List<OmEmployee> queryAllEmployyee() {
		WhereCondition wc = new WhereCondition();
		List<OmEmployee> list = omEmployeeService.query(wc);
		return list;
	}

	@Override
	public List<OmOrg> queryOrgbyEmpCode(String empCode) {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		List<OmOrg> orgList = new ArrayList<>();
		OmEmployee emp = queryEmployeeBrief(empCode);
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, emp.getGuid());
		List<OmEmpOrg> oeoList = omEmpOrgService.query(wc);
		//找出主机构GUID
		String mainguid = "";
		if(oeoList == null){
			return orgList;
		}
		List<String> guidList = new ArrayList<>();
		for (OmEmpOrg oeo : oeoList) {
			guidList.add(oeo.getGuidOrg());
			if(oeo.getIsmain().equals("Y")){
				mainguid = oeo.getGuidOrg();
			}
		}
		wc.clear();
		wc.andIn(OmOrg.COLUMN_GUID, guidList);
		orgList = OmOrgService.query(wc);
		for(OmOrg org:orgList){
			if (org.getGuid().equals(mainguid)) {
				org.setOrgName(org.getOrgName()+"(主)");
			}
		}
		return orgList;
	}

	@Override
	public List<OmPosition> queryPosbyEmpCode(String empCode) {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		List<OmPosition> opList = new ArrayList<>();
		OmEmployee emp = queryEmployeeBrief(empCode);
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, emp.getGuid());
		List<OmEmpPosition> oepList = omEmpPositionService.query(wc);
		//找出主岗位GUID
		String mainguid = "";
		if(oepList == null){
			return opList;
		}
		List<String> guidList = new ArrayList<>();
		for (OmEmpPosition oep : oepList) {
			guidList.add(oep.getGuidPosition());
			if(oep.getIsmain().equals("Y")){
				mainguid = oep.getGuidPosition();
			}
		}
		wc.clear();
		wc.andIn(OmOrg.COLUMN_GUID, guidList);
		opList = omPositionService.query(wc);
		for(OmPosition op:opList){
			if (op.getGuid().equals(mainguid)) {
				op.setPositionName(op.getPositionName()+"(主)");
				break;
			}
		}
		return opList;
	}

	/**
	 * 查询员工所有的岗位及对应的职务
	 *
	 * @param empCode
	 * @return
	 */
	@Override
	public List<Map> queryPosDutybyEmpCode(String empCode) throws EmployeeManagementException{
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new EmployeeManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		List<Map> list = new ArrayList<>();
		OmEmployee emp = queryEmployeeBrief(empCode);
		WhereCondition wc = new WhereCondition();
		wc.andEquals(OmEmpOrg.COLUMN_GUID_EMP, emp.getGuid());
		List<OmEmpPosition> oepList = omEmpPositionService.query(wc);
		//找出主岗位GUID
		String mainguid = "";
		if (oepList == null) {
			return list;
		}
		List<String> guidList = new ArrayList<>();
		for (OmEmpPosition oep : oepList) {
			guidList.add(oep.getGuidPosition());
			if (oep.getIsmain().equals("Y")) {
				mainguid = oep.getGuidPosition();
			}
		}
		wc.clear();
		wc.andIn(OmOrg.COLUMN_GUID, guidList);
		list = orgServiceExt.queryPosDutybyEmpCode(guidList);
		for (Map map: list) {
			if (StringUtils.equals((String) map.get("guid"), mainguid)) {
				map.put("positionName", map.get("positionName")+"(主)");
				break;
			}
		}
		return list;
	}

	/**
	 * 查询指定人员所在所有工作组
	 *
	 * @param empCode
	 */
	@Override
	public List<OmGroup> queryGroupByEmpCode(String empCode) throws EmployeeManagementException {
		if (StringUtils.isBlank(empCode))
			throw new EmployeeManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_CALL,
					wrap("empCode(String)", "queryGroupByEmpCode"));
		OmEmployee emp = queryEmployeeBrief(empCode);
		try {
			Set<String> groupGuids = omEmpGroupService.query(new WhereCondition()
					.andEquals(OmEmpGroup.COLUMN_GUID_EMP, emp.getGuid()))
					.stream().map(OmEmpGroup::getGuidGroup).collect(Collectors.toSet());
			List<OmGroup> list = new ArrayList<>();
			if(CollectionUtils.isNotEmpty(groupGuids))
				list.addAll(omGroupService.query(new WhereCondition().andIn(OmGroup.COLUMN_GUID, new ArrayList<>(groupGuids))));
			return list;
		} catch (Exception e) {
			logger.error("queryGroupbyEmpCode exception: ", e);
			throw new EmployeeManagementException(ExceptionCodes.FAILURE_WHEN_CALL, wrap("queryGroupByEmpCode", e));
		}
	}
	/**
	 * 查询指定人员所在所有职务
	 *
	 * @param empCode
	 */
	@Override
	public List<OmDuty> queryDutyByEmpCode(String empCode) throws EmployeeManagementException {
		if (StringUtils.isBlank(empCode))
			throw new EmployeeManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_CALL,
					wrap("empCode(String)", "queryDutyByEmpCode"));
		List<OmPosition> positions = queryPosbyEmpCode(empCode);
		try {
			Set<String> dutyGuids = positions.stream().map(OmPosition::getGuidDuty).collect(Collectors.toSet());
			List<OmDuty> list = new ArrayList<>();
			if(CollectionUtils.isNotEmpty(dutyGuids))
				list.addAll(omDutyService.query(new WhereCondition().andIn(OmDuty.COLUMN_GUID, new ArrayList<>(dutyGuids))));
			return list;
		} catch (Exception e) {
			logger.error("queryDutyByEmpCode exception: ", e);
			throw new EmployeeManagementException(ExceptionCodes.FAILURE_WHEN_CALL, wrap("queryGroupByEmpCode", e));
		}
	}

	@Override
	public List<OmOrg> queryCanAddOrgbyEmpCode(String empCode) {
		//校验入参
		if(StringUtil.isEmpty(empCode)){
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		List<OmOrg> orgList = orgRService.queryAllOrg();
		Set<String> inorgList = queryOrgbyEmpCode(empCode).stream().map(OmOrg::getGuid).collect(Collectors.toSet());
		return orgList.stream().filter(o -> !inorgList.contains(o.getGuid())).collect(Collectors.toList());
	}

	@Override
	public List<OmPosition> queryCanAddPosbyEmpCode(String empCode, String orgGuid) {
		//校验入参
		if (StringUtil.isEmpty(empCode)) {
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if (StringUtil.isEmpty(orgGuid)) {
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		List<String> inopList = queryPosbyEmpCode(empCode).stream().map(OmPosition::getGuid).collect(Collectors.toList());
		return omPositionService.query(new WhereCondition()
				.andEquals(OmPosition.COLUMN_GUID_ORG, orgGuid)
				.andNotIn(OmPosition.COLUMN_GUID, inopList));
	}

	/**
	 * 查询机构下可以为人员添加的工作组
	 *
	 * @param empCode
	 * @param orgGuid
	 */
	@Override
	public List<OmGroup> queryCanAddGroupbyEmpCode(String empCode, String orgGuid) {
		//校验入参
		if (StringUtil.isEmpty(empCode)) {
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		if (StringUtil.isEmpty(orgGuid)) {
			throw new GroupManagementException(OMExceptionCodes.PARMS_NOT_ALLOW_EMPTY);
		}
		List<String> inopList = queryGroupByEmpCode(empCode).stream().map(OmGroup::getGuid).collect(Collectors.toList());
		return omGroupService.query(new WhereCondition()
				.andEquals(OmGroup.COLUMN_GUID_ORG, orgGuid)
				.andNotIn(OmGroup.COLUMN_GUID, inopList));
	}

	/**
	 * 改变员工状态
	 *
	 * @param empGuid 员工GUID
	 * @param status  员工状态
	 * @return
	 * @throws EmployeeManagementException
	 * @see OMConstants#EMPLOYEE_STATUS_OFFER 在招
	 * @see OMConstants#EMPLOYEE_STATUS_OFFJOB 离职
	 * @see OMConstants#EMPLOYEE_STATUS_ONJOB 在职
	 */
	@Override
	public OmEmployee changeEmpStatus(String empGuid, String status, Date date) throws EmployeeManagementException {
		if(StringUtils.isBlank(empGuid)) {
			throw new EmployeeManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_CALL, wrap(OmEmployee.COLUMN_GUID, "changeEmpStatus"));
		}
		if(StringUtils.isBlank(status)) {
			throw new EmployeeManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_CALL, wrap(OmEmployee.COLUMN_EMPSTATUS, "changeEmpStatus"));
		}
		if(date == null) {
			throw new EmployeeManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_CALL, wrap("Date date", "changeEmpStatus"));
		}
		try {
			OmEmployee omEmployee = omEmployeeService.loadByGuid(empGuid);
			String old_status = omEmployee.getEmpstatus();
			switch (status) {
                /*改变状态为 在职
                * 限制当前状态为： 在招
                * */
				case OMConstants.EMPLOYEE_STATUS_ONJOB :
					if (!StringUtils.equals(old_status, OMConstants.EMPLOYEE_STATUS_OFFER)) {
						throw new EmployeeManagementException(ACExceptionCodes.CURRENT_STATUS_IS_NOT_ALLOWED_CHANGE, wrap(old_status, OMConstants.EMPLOYEE_STATUS_ONJOB));
					}
					omEmployee.setEmpstatus(status);
					omEmployee.setIndate(date);
					break;
                /*改变状态为 离职
                * 限制当前状态为： 在职
                * */
				case OMConstants.EMPLOYEE_STATUS_OFFJOB :
					if (!StringUtils.equals(old_status, OMConstants.EMPLOYEE_STATUS_ONJOB)) {
						throw new EmployeeManagementException(ACExceptionCodes.CURRENT_STATUS_IS_NOT_ALLOWED_CHANGE, wrap(old_status, OMConstants.EMPLOYEE_STATUS_OFFJOB));
					}
					omEmployee.setEmpstatus(status);
					omEmployee.setOutdate(date);
					break;
				default:
					throw new EmployeeManagementException(ACExceptionCodes.OPERATOR_STATUS_ERROR, old_status);
			}
			omEmployeeService.update(omEmployee);
			return omEmployee;
		} catch (ToolsRuntimeException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new EmployeeManagementException(ExceptionCodes.FAILURE_WHEN_CALL, wrap("changeEmpStatus", e));
		}
	}
}
