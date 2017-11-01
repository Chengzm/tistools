package org.tis.tools.rservice.ac.capable;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.util.CollectionUtils;
import org.tis.tools.base.WhereCondition;
import org.tis.tools.base.exception.ToolsRuntimeException;
import org.tis.tools.common.utils.BasicUtil;
import org.tis.tools.common.utils.BeanFieldValidateUtil;
import org.tis.tools.core.exception.ExceptionCodes;
import org.tis.tools.model.def.ACConstants;
import org.tis.tools.model.def.GUID;
import org.tis.tools.model.po.ac.*;
import org.tis.tools.model.po.om.*;
import org.tis.tools.rservice.BaseRService;
import org.tis.tools.rservice.ac.exception.RoleManagementException;
import org.tis.tools.service.ac.*;
import org.tis.tools.service.ac.exception.ACExceptionCodes;
import org.tis.tools.service.om.*;

import java.util.*;

public class RoleRServiceImpl extends BaseRService implements IRoleRService {

    @Autowired
    AcRoleEntityService acRoleEntityService;

    @Autowired
    AcRoleEntityfieldService acRoleEntityfieldService;

    @Autowired
    AcRoleDatascopeService acRoleDatascopeService;

    @Autowired
    AcRoleFuncService acRoleFuncService;

    @Autowired
    AcOperatorRoleService acOperatorRoleService;

    @Autowired
    AcPartyRoleService acPartyRoleService;

    @Autowired
    AcRoleService acRoleService;

    @Autowired
    OmEmpOrgService omEmpOrgService;

    @Autowired
    OmEmpPositionService omEmpPositionService;

    @Autowired
    OmEmpGroupService omEmpGroupService;

    @Autowired
    OmDutyService omDutyService;

    @Autowired
    OmOrgService omOrgService;

    @Autowired
    AcOperatorService acOperatorService;

    @Autowired
    OmPositionService omPositionService;

    @Autowired
    OmGroupService omGroupService;

    @Autowired
    OmEmployeeService omEmployeeService;

    @Autowired
    AcRoleServiceExt acRoleServiceExt;

    @Autowired
    AcRoleBhvService acRoleBhvService;

    /**
     * <p>查询所有角色</p>
     * <p>
     * <pre>
     *     用于展示角色列表
     * </pre>
     *
     * @return
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryAllRole() throws RoleManagementException {
        try {
            return acRoleService.query(new WhereCondition());
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * <p>查询所有角色</p>
     * <p>
     * <pre>
     *     用于展示角色列表,添加应用名称
     * </pre>
     *
     * @return
     * @throws RoleManagementException
     */
    @Override
    public List<Map> queryAllRoleExt() throws RoleManagementException {
        try {
            return acRoleServiceExt.queryAllRoleExt();
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * <p>新增角色</p>
     * <p>
     * <pre>
     *    1.验证传入的对象不能为空
     *    2.验证新增角色所需的必要信息
     *          a.隶属应用:’guidApp’;
     *          b.角色代码:’roleCode’ ;
     *          c.角色名称:’roleName’;  XXX 是否需要唯一
     *          d.角色类别:‘roleType’;
     *    3.添加新增角色所需的其他信息
     *          a.GUID(调用方法)
     *
     *
     * </pre>
     *
     * @param acRole 新增的角色对象
     * @return 完成新增的角色对象
     * @throws RoleManagementException
     */
    @Override
    public AcRole createAcRole(AcRole acRole) throws RoleManagementException {
        try {
            if (null == acRole) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("AC_ROLE", "AcRole"));
            }
            // 校验必要参数
            if (StringUtils.isBlank(acRole.getGuidApp())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_APP", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getRoleCode())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("ROLE_CODE", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getRoleName())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("ROLE_NAME", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getRoleType())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("ROLE_TYPE", "AC_ROLE"));
            }

            acRole.setGuid(GUID.role());
            acRoleService.insert(acRole);
            return acRole;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_INSERT,
                    BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * <p>修改角色</p>
     * <p>
     * <pre>
     *     业务逻辑
     *    1.验证传入的对象不能为空
     *    2.验证修改角色所需的必要信息
     *          a.隶属应用:’guidApp’;
     *          b.角色代码:’roleCode’ ;
     *          c.角色名称:’roleName’;  XXX 是否需要唯一
     *          d.角色类别:‘roleType’;
     *          e.角色GUID
     *    3.添加修改角色所需的其他信息
     *          无
     *
     *
     * </pre>
     *
     * @param acRole 修改的角色对象
     * @return 完成修改的角色对象
     * @throws RoleManagementException
     */
    @Override
    public AcRole eidtAcRole(AcRole acRole) throws RoleManagementException {
        try {
            if (null == acRole) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_UPDATE, BasicUtil.wrap("AcRole", "AcRole"));
            }
            // 校验必要参数
            if (StringUtils.isBlank(acRole.getGuid())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, BasicUtil.wrap("GUID", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getGuidApp())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, BasicUtil.wrap("GUID_APP", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getRoleCode())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, BasicUtil.wrap("ROLE_CODE", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getRoleName())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, BasicUtil.wrap("ROLE_NAME", "AC_ROLE"));
            }
            if (StringUtils.isBlank(acRole.getRoleType())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_UPDATE, BasicUtil.wrap("ROLE_TYPE", "AC_ROLE"));
            }
            acRoleService.update(acRole);
            return acRole;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_UPDATE,
                    BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * <p>删除角色</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     1.验证传入GUID是否为空
     *     2.验证传入GUID对应的角色是否存在
     *     3.删除与待删角色相关
     *          a.角色与实体属性关系 AC_ROLE_ENTITYFIELD
     *          b.角色与实体关系 AC_ROLE_ENTITY
     *          c.角色与数据范围权限关系 AC_ROLE_DATASCOPE
     *          d.角色与功能对应关系 AC_ROLE_FUNC
     *          e.操作员与权限集（角色）对应关系 AC_OPERATOR_ROLE
     *          f.组织对象与角色对应关系 AAC_PARTY_ROLE
     *     4.删除角色
     *     XXX 删除角色逻辑是否完整
     * </pre>
     *
     * @param guid 角色的GUID
     * @throws RoleManagementException
     */
    @Override
    public void deleteAcRole(String guid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(guid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID", "AC_ROLE"));
            }
            //验证传入GUID对应的角色是否存在
            if (acRoleService.count(new WhereCondition().andEquals("GUID", guid)) != 1) {
                throw new RoleManagementException(ACExceptionCodes.AC_ROLE_IS_NOT_FOUND, BasicUtil.wrap(guid));
            }
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                public void doInTransactionWithoutResult(TransactionStatus status) {
                    try {
                        WhereCondition wc = new WhereCondition();
                        wc.andEquals("GUID_ROLE", guid);
                        // 角色与实体关系 AC_ROLE_ENTITY
                        acRoleEntityService.deleteByCondition(wc);
                        // 角色与实体属性关系 AC_ROLE_ENTITYFIELD
                        acRoleEntityfieldService.deleteByCondition(wc);
                        // 角色与数据范围权限关系 AC_ROLE_DATASCOPE
                        acRoleDatascopeService.deleteByCondition(wc);
                        // 角色与功能对应关系 AC_ROLE_FUNC
                        acRoleFuncService.deleteByCondition(wc);
                        // 操作员与权限集（角色）对应关系 AC_OPERATOR_ROLE
                        acOperatorRoleService.deleteByCondition(wc);
                        // 组织对象与角色对应关系 AC_PARTY_ROLE
                        acPartyRoleService.deleteByCondition(wc);
                        // 角色与功能行为对应关系 AC_ROLE_BHV
                        acRoleBhvService.deleteByCondition(wc);

                        acRoleService.delete(guid);
                    } catch (Exception e) {
                        status.setRollbackOnly();
                        e.printStackTrace();
                        throw new RoleManagementException(
                                ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_ROLE", e));
                    }
                }
            });
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * <p>角色添加功能权限</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     1.验证传入的对象不能为空
     *     2.验证添加角色的功能权限所需的必要信息 XXX 是否需要验证角色、功能是否存在
     *          a.角色GUID
     *          b.功能GUID
     *
     * </pre>
     *
     * @param acRoleFunc
     * @throws RoleManagementException
     */
    @Override
    public void addRoleFunc(AcRoleFunc acRoleFunc) throws RoleManagementException {
        try {
            if (null == acRoleFunc) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("AC_ROLE_FUNC", "AC_ROLE_FUNC"));
            }
            // 校验必要参数
            if (StringUtils.isBlank(acRoleFunc.getGuidFunc())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_FUNC", "AC_ROLE_FUNC"));
            }
            if (StringUtils.isBlank(acRoleFunc.getGuidRole())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_ROLE", "AC_ROLE_FUNC"));
            }
            acRoleFuncService.insert(acRoleFunc);
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_INSERT,
                    BasicUtil.wrap("AC_ROLE_FUNC", e));
        }
    }

    /**
     * <p>角色移除功能权限</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID和功能GUID移除角色功能权限
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid 角色GUID
     * @param funcGuid 功能GUID
     * @throws RoleManagementException
     */
    @Override
    public void removeRoleFunc(String roleGuid, String funcGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_ROLE", "AC_ROLE_FUNC"));
            }
            if (StringUtils.isBlank(funcGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_FUNC", "AC_ROLE_FUNC"));
            }
            acRoleFuncService.deleteByCondition(new WhereCondition().andEquals("GUID_ROLE", roleGuid).andEquals("GUID_FUNC", funcGuid));
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_ROLE_FUNC", e));
        }
    }

    /**
     * <p>角色移除某应用的全部功能权限</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID和功能GUID移除角色功能权限
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid 角色GUID
     * @param appGuid  应用GUID
     * @throws RoleManagementException
     */
    @Override
    public void removeRoleFuncWithApp(String roleGuid, String appGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_ROLE", "AC_ROLE_FUNC"));
            }
            if (StringUtils.isBlank(appGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_APP", "AC_ROLE_FUNC"));
            }
            acRoleFuncService.deleteByCondition(new WhereCondition().andEquals("GUID_ROLE", roleGuid).andEquals("GUID_APP", appGuid));
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_ROLE_FUNC", e));
        }
    }

    /**
     * <p>查询角色的功能权限集合</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID查询对应角色功能权限集合
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid 角色GUID
     * @throws RoleManagementException
     */
    @Override
    public List<AcRoleFunc> queryAllRoleFunByRoleGuid(String roleGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_ROLE", "AC_ROLE_FUNC"));
            }
            return acRoleFuncService.query(new WhereCondition().andEquals("GUID_ROLE", roleGuid));
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_ROLE_FUNC", e));
        }
    }

    /**
     * <p>角色添加组织对象权限</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     1.验证传入的对象不能为空
     *     2.验证添加角色的组织对象权限所需的必要信息 XXX 是否需要验证角色、组织对象是否存在
     *          a.角色GUID
     *          b.组织对象类型
     *          c.组织对象GUID
     *
     * </pre>
     *
     * @param acPartyRole
     * @throws RoleManagementException
     */
    @Override
    public AcPartyRole addRoleParty(AcPartyRole acPartyRole) throws RoleManagementException {
        try {
            if (null == acPartyRole) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("acPartyRole", "AC_PARTY_ROLE"));
            }
            // 校验必要参数
            if (StringUtils.isBlank(acPartyRole.getGuidParty())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_PARTY", "AC_PARTY_ROLE"));
            }
            if (StringUtils.isBlank(acPartyRole.getGuidRole())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_ROLE", "AC_PARTY_ROLE"));
            }
            if (StringUtils.isBlank(acPartyRole.getPartyType())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("PARTY_TYPE", "AC_PARTY_ROLE"));
            }
            if (acPartyRoleService.count(new WhereCondition()
                    .andEquals("GUID_PARTY", acPartyRole.getGuidParty())
                    .andEquals("GUID_ROLE", acPartyRole.getGuidRole())
                    .andEquals("PARTY_TYPE", acPartyRole.getPartyType())) > 0) {
                throw new RoleManagementException(ExceptionCodes.DUPLICATE_WHEN_INSERT, BasicUtil.wrap("GUID_PARTY", "AC_PARTY_ROLE"));
            }
            acPartyRoleService.insert(acPartyRole);
            return acPartyRole;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_INSERT,
                    BasicUtil.wrap("AC_PARTY_ROLE", e));
        }
    }

    /**
     * <p>角色移除组织对象权限</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID和组织对象GUID移除角色组织对象权限
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid  角色GUID
     * @param partyGuid 组织对象GUID
     * @throws RoleManagementException
     */
    @Override
    public void removeRoleParty(String roleGuid, String partyGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_ROLE", "AC_PARTY_ROLE"));
            }
            if (StringUtils.isBlank(partyGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_PARTY", "AC_PARTY_ROLE"));
            }
            acPartyRoleService.deleteByCondition(new WhereCondition().andEquals("GUID_ROLE", roleGuid).andEquals("GUID_PARTY", partyGuid));
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_PARTY_ROLE", e));
        }
    }

    /**
     * <p>角色批量移除组织对象权限</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID和组织对象GUID移除角色组织对象权限
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid
     *          角色GUID
     * @param partyGuidList
     *          组织对象GUID集合
     * @throws RoleManagementException
     */
    @Override
    public void removeRolePartyList(String roleGuid, List<String> partyGuidList) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_ROLE", "AC_PARTY_ROLE"));
            }
            if (CollectionUtils.isEmpty(partyGuidList)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_PARTY LIST", "AC_PARTY_ROLE"));
            }
            acPartyRoleService.deleteByCondition(new WhereCondition().andEquals("GUID_ROLE", roleGuid).andIn("GUID_PARTY", partyGuidList));
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_PARTY_ROLE", e));
        }
    }

    /**
     * <p>查询角色的组织对象权限集合</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID查询对应角色组织对象权限集合
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid  角色GUID
     * @param partyType 组织对象类型
     * @throws RoleManagementException
     */
    @Override
    public List<AcPartyRole> queryAllRoleParty(String roleGuid, String partyType) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_ROLE", "AC_PARTY_ROLE"));
            }
            if (StringUtils.isBlank(partyType)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("PARTY_TYPE", "AC_PARTY_ROLE"));
            }
            return acPartyRoleService.query(new WhereCondition().andEquals("GUID_ROLE", roleGuid).andEquals("PARTY_TYPE", partyType));
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_PARTY_ROLE", e));
        }
    }

    /**
     * <p>查询角色的组织对象权限集合</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID查询对应角色组织对象权限集合
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid  角色GUID
     * @param partyType 组织对象类型
     * @throws RoleManagementException
     */
    @Override
    public List<Map> queryAllRolePartyExt(String roleGuid, String partyType) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_ROLE", "AC_PARTY_ROLE"));
            }
            if (StringUtils.isBlank(partyType)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("PARTY_TYPE", "AC_PARTY_ROLE"));
            }
            return acRoleServiceExt.queryAllRolePartyExt(roleGuid, partyType);
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_PARTY_ROLE", e));
        }
    }

    /**
     * <p>角色关联操作员</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     1.验证传入的对象不能为空
     *     2.验证添加角色与操作员关联所需的必要信息 XXX 是否需要验证角色、操作员是否存在
     *          a.角色GUID
     *          b.操作员GUID
     *
     * </pre>
     *
     * @param acOperatorRole
     * @throws RoleManagementException
     */
    @Override
    public void addOperatorRole(AcOperatorRole acOperatorRole) throws RoleManagementException {
        try {
            if (null == acOperatorRole) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("acOperatorRole", "AC_OPERATOR_ROLE"));
            }
            // 校验必要参数
            if (StringUtils.isBlank(acOperatorRole.getGuidOperator())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_OPERATOR", "AC_OPERATOR_ROLE"));
            }
            if (StringUtils.isBlank(acOperatorRole.getGuidRole())) {
                throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap("GUID_ROLE", "AC_OPERATOR_ROLE"));
            }
            if (acOperatorRoleService.count(new WhereCondition()
                    .andEquals("GUID_OPERATOR", acOperatorRole.getGuidOperator())
                    .andEquals("GUID_ROLE", acOperatorRole.getGuidRole())) > 0) {
                throw new RoleManagementException(ExceptionCodes.DUPLICATE_WHEN_INSERT, BasicUtil.wrap("GUID_OPERATOR", "AC_OPERATOR_ROLE"));
            }
            acOperatorRoleService.insert(acOperatorRole);
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_INSERT,
                    BasicUtil.wrap("AC_OPERATOR_ROLE", e));
        }
    }

    /**
     * <p>查询角色的操作员权限集合</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID查询对应操作员集合
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid 角色GUID
     * @throws RoleManagementException
     */
    @Override
    public List<AcOperatorRole> queryAllOperatorRole(String roleGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_ROLE", "AC_OPERATOR_ROLE"));
            }
            return acOperatorRoleService.query(new WhereCondition().andEquals("GUID_ROLE", roleGuid));
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_OPERATOR_ROLE", e));
        }
    }

    /**
     * 查询与角色直接授予的操作员
     * @param roleGuid
     *          角色GUID
     * @return
     * @throws RoleManagementException
     */
    @Override
    public List<Map> queryAllOperatorRoleExt(String roleGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_ROLE", "AC_OPERATOR_ROLE"));
            }
            return acRoleServiceExt.queryAllOperatorRoleExt(roleGuid);
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_OPERATOR_ROLE", e));
        }
    }

    /**
     * <p>角色移除操作员</p>
     * <p>
     * <pre>
     *     业务逻辑
     *     传入角色的GUID和操作员GUID移除关联
     *     1.验证传入的对象不能为空
     *
     * </pre>
     *
     * @param roleGuid     角色GUID
     * @param operatorGuid 操作员GUID
     * @throws RoleManagementException
     */
    @Override
    public void removeOperatorRole(String roleGuid, String operatorGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(roleGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_ROLE", "AC_OPERATOR_ROLE"));
            }
            if (StringUtils.isBlank(operatorGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("GUID_OPERATOR", "AC_OPERATOR_ROLE"));
            }
            acOperatorRoleService.deleteByCondition(new WhereCondition().andEquals("GUID_ROLE", roleGuid).andEquals("GUID_OPERATOR", operatorGuid));
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap("AC_OPERATOR_ROLE", e));
        }
    }

    /**
     * 查询操作员所有的权限集合
     *
     * @param userId
     * @return
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryAllRoleByUserId(String userId) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(userId)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("USER_ID", "AC_ROLE"));
            }
            // 查询用户对应的操作员信息
            List<AcOperator> operatorList = acOperatorService.query(new WhereCondition().andEquals("USER_ID", userId));
            if (CollectionUtils.isEmpty(operatorList)) {
                throw new RoleManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap("USER_ID " + userId, "AC_OPERATOR"));
            }
            AcOperator acOperator = operatorList.get(0);
            // 用于保存返回的角色集合
            List<AcRole> acRoleList = new ArrayList<>();
            // 用于存放所有角色的GUID
            Set<String> roleGuids = new HashSet<>();

            //查询用户对应的员工的组织对象角色
            List<OmEmployee> employees = omEmployeeService.query(new WhereCondition().andEquals("USER_ID", userId));
            // 如果该操作员有对应的员工
            if (!CollectionUtils.isEmpty(employees)) {
                String empGuid = employees.get(0).getGuid();
                // 用于存放所有组织GUID的集合
                Set<String> partyGuids = new HashSet<>();
                // 机构
                List<OmEmpOrg> omEmpOrgList = omEmpOrgService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                for (OmEmpOrg empOrg : omEmpOrgList) {
                    partyGuids.add(empOrg.getGuidOrg());
                }
                // 岗位
                List<OmEmpPosition> omEmpPositionList = omEmpPositionService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                // 用于存放岗位guid
                List<String> posiGuids = new ArrayList<>();
                for (OmEmpPosition empPosition : omEmpPositionList) {
                    partyGuids.add(empPosition.getGuidPosition());
                    posiGuids.add(empPosition.getGuidPosition());
                }
                // 职务
                if (posiGuids.size() > 0) {
                    List<OmPosition> omPositions = omPositionService.query(new WhereCondition().andIn("GUID", empGuid));
                    for (OmPosition omPosition : omPositions) {
                        partyGuids.add(omPosition.getGuidDuty());
                    }
                }
                // 工作组
                List<OmEmpGroup> omEmpGroupList = omEmpGroupService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                for (OmEmpGroup omEmpGroup : omEmpGroupList) {
                    partyGuids.add(omEmpGroup.getGuidGroup());
                }
                // 查询所有组织机构角色
                if (partyGuids.size() > 0) {
                    List<AcPartyRole> acPartyRoles = acPartyRoleService.query(new WhereCondition()
                            .andIn("GUID_PARTY", new ArrayList<String>(partyGuids)));
                    for (AcPartyRole acPartyRole : acPartyRoles) {
                        roleGuids.add(acPartyRole.getGuidRole());
                    }
                }
            }
            // 查询操作员直接相关的角色
            List<AcOperatorRole> acOperatorRoles = acOperatorRoleService.query(new WhereCondition().andEquals("GUID_OPERATOR", acOperator.getGuid()));
            for (AcOperatorRole acOperatorRole : acOperatorRoles) {
                roleGuids.add(acOperatorRole.getGuidRole());
            }
            if (roleGuids.size() > 0) {
                acRoleList = acRoleService.query(new WhereCondition().andIn("GUID", new ArrayList<String>(roleGuids)));
            }
            return acRoleList;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("AC_ROLE", e));
        }
    }


    /**
     * 查询员工对应组织对象下的权限集合
     *
     * @param empGuid
     * @return
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryEmpPartyRole(String partyType, String empGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(partyType)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("PARTY_TYPE", "AC_PARTY_ROLE"));
            }
            if (StringUtils.isBlank(empGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_EMP", "AC_PARTY_ROLE"));
            }
            // 用于存放所有组织GUID的集合
            Set<String> partyGuids = new HashSet<>();
            // 查询员工隶属的组织对象
            switch (partyType) {
                case ACConstants.PARTY_TYPE_ORGANIZATION: //机构
                    List<OmEmpOrg> omEmpOrgList = omEmpOrgService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                    for (OmEmpOrg empOrg : omEmpOrgList) {
                        partyGuids.add(empOrg.getGuidOrg());
                    }
                    break;
                case ACConstants.PARTY_TYPE_POSITION: // 岗位
                    List<OmEmpPosition> omEmpPositionList = omEmpPositionService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                    for (OmEmpPosition empPosition : omEmpPositionList) {
                        partyGuids.add(empPosition.getGuidPosition());
                    }
                    break;
                case ACConstants.PARTY_TYPE_WORKGROUP: // 工作组
                    List<OmEmpGroup> omEmpGroupList = omEmpGroupService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                    for (OmEmpGroup omEmpGroup : omEmpGroupList) {
                        partyGuids.add(omEmpGroup.getGuidGroup());
                    }
                    break;
                case ACConstants.PARTY_TYPE_DUTY: // 职务
                    // 首先查询员工对应的岗位
                    List<OmEmpPosition> omEmpPositions = omEmpPositionService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
                    List<String> posiGuids = new ArrayList<>();
                    // 查询岗位信息
                    for (OmEmpPosition empPosition : omEmpPositions) {
                        posiGuids.add(empPosition.getGuidPosition());
                    }
                    if (posiGuids.size() > 0) {
                        List<OmPosition> omPositions = omPositionService.query(new WhereCondition().andIn("GUID", posiGuids));
                        for (OmPosition omPosition : omPositions) {
                            partyGuids.add(omPosition.getGuidDuty());
                        }
                    }
                    break;
                default:
                    throw new RoleManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap("PARTY_TYPE", "AC_PARTY_ROLE"));
            }
            // 用于保存返回的角色集合
            List<AcRole> acRoleList = new ArrayList<>();
            //查询所有权限
            if (partyGuids.size() > 0) {
                List<AcPartyRole> acPartyRoles = acPartyRoleService.query(new WhereCondition()
                        .andEquals("PARTY_TYPE", partyType)
                        .andIn("GUID_PARTY", new ArrayList<String>(partyGuids)));
                // 用于存放所有角色的GUID
                Set<String> roleGuids = new HashSet<>();
                for (AcPartyRole acPartyRole : acPartyRoles) {
                    roleGuids.add(acPartyRole.getGuidRole());
                }
                if (roleGuids.size() > 0) {
                    acRoleList = acRoleService.query(new WhereCondition().andIn("GUID", new ArrayList<String>(roleGuids)));
                }
            }
            return acRoleList;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * 查询应用下的所有角色
     *
     * @param appGuid 应用GUID
     * @return 角色集合
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryRoleListInApp(String appGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(appGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_APP", "AC_ROLE"));
            }
            return acRoleService.query(new WhereCondition().andEquals(AcRole.COLUMN_GUID_APP, appGuid));
        } catch (Exception e) {
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY,
                    BasicUtil.wrap("AC_ROLE_FUNC", e));
        }
    }

    /**
     * 查询操作员所在工作组和岗位相关应用下所有角色
     * 来源  操作员对应员工的工作组和岗位相关应用下所有的角色
     *
     * @param employeeGuid
     *          员工GUID
     * @return 角色集合
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryEmployeeAllPartyRoleList(String employeeGuid) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(employeeGuid)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("GUID_EMPLOYEE", "OperatorInheritRoleList"));
            }
            return acRoleServiceExt.queryEmployeeAllPartyRoleList(employeeGuid);
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY, BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * 查询操作员未授权角色
     * 来源  操作员对应员工的工作组和岗位相关应用下非继承的未授权给该操作员的角色
     *
     * @param userId 用户ID
     * @return 角色集合
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryOperatorUnauthorizedRoleList(String userId) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(userId)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("USER_ID", "OperatorInheritRoleList"));
            }

            /** 查询对应操作员*/
            List<AcOperator> acOperators = acOperatorService.query(new WhereCondition().andEquals(AcOperator.COLUMN_USER_ID, userId));
            if (acOperators.size() != 1) {
                throw new RoleManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap(userId, "AC_OPERATOR"));
            }
            AcOperator operator = acOperators.get(0);
            /** 查询用户对应员工*/
            List<OmEmployee> employees = omEmployeeService.query(new WhereCondition().andEquals(OmEmployee.COLUMN_USER_ID, userId));
            if (employees.size() != 1) {
                throw new RoleManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap(userId, "AC_EMPLOYEE"));
            }
            OmEmployee emp = employees.get(0);

            /** 查询员工所在工作组或岗位下拥有应用下的所有角色*/
            List<AcRole> allRoleList = queryEmployeeAllPartyRoleList(emp.getGuid());
            /** 查询员工已授权的所有角色*/
            List<AcRole> authorizedRoleList = queryOperatorAuthorizedRoleList(userId);
            /** 查询员工继承的所有角色*/
            List<AcRole> inheritRoleList = queryOperatorInheritRoleList(userId);

            /** 未授权的角色 应为：所有角色去除继承的角色和已授权的角色 */
            Set<String> compareGuids = new HashSet<>();
            for(AcRole acRole : authorizedRoleList) {
                compareGuids.add(acRole.getGuid());
            }
            for(AcRole acRole : inheritRoleList) {
                compareGuids.add(acRole.getGuid());
            }
            Iterator<AcRole> roleIterator = allRoleList.iterator();
            while (roleIterator.hasNext()) {
                AcRole role = roleIterator.next();
                if (compareGuids.contains(role.getGuid()))
                    roleIterator.remove();//这里要使用Iterator的remove方法移除当前对象，如果使用List的remove方法，会出现ConcurrentModificationException
            }
            return allRoleList;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY, BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * 查询操作员已授权角色
     * 来源  操作员对应的工作组和岗位的应用下非继承的已授权给该操作员的角色
     *
     * 业务逻辑：查询角色与操作员有直接关联关系的角色集合
     *
     * @param userId 用户ID
     * @return 角色集合
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryOperatorAuthorizedRoleList(String userId) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(userId)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("USER_ID", "OperatorInheritRoleList"));
            }
            /** 查询用户对应操作员*/
            List<AcOperator> acOperators = acOperatorService.query(new WhereCondition().andEquals(AcOperator.COLUMN_USER_ID, userId));
            if (acOperators.size() != 1) {
                throw new RoleManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap(userId, "AC_OPERATOR"));
            }
            AcOperator operator = acOperators.get(0);
            //查询所有权限
            List<AcOperatorRole> acOperatorRoles = acOperatorRoleService.query(new WhereCondition().andEquals(AcOperatorRole.COLUMN_GUID_OPERATOR, operator.getGuid()));
            List<String> roleGuids = new ArrayList<>();
            for (AcOperatorRole operatorRole : acOperatorRoles) {
                roleGuids.add(operatorRole.getGuidRole());
            }
            List<AcRole> roleList = new ArrayList<>();
            if (roleGuids.size() > 0) {
                roleList = acRoleService.query(new WhereCondition().andIn(AcRole.COLUMN_GUID, roleGuids));
            }
            return roleList;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY, BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * 查询操作员继承角色
     * 来源  操作员对应员工所属机构、岗位、职务、工作组直接关联的角色、无需授权默认拥有
     *
     * @param userId 用户ID
     * @return 角色集合
     * @throws RoleManagementException
     */
    @Override
    public List<AcRole> queryOperatorInheritRoleList(String userId) throws RoleManagementException {
        try {
            if (StringUtils.isBlank(userId)) {
                throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("USER_ID", "OperatorInheritRoleList"));
            }
            /** 查询用户对应员工*/
            List<OmEmployee> employees = omEmployeeService.query(new WhereCondition().andEquals(OmEmployee.COLUMN_USER_ID, userId));
            if (employees.size() != 1) {
                throw new RoleManagementException(ExceptionCodes.NOT_FOUND_WHEN_QUERY, BasicUtil.wrap(userId, "AC_OPERATOR"));
            }
            OmEmployee emp = employees.get(0);
            String empGuid = emp.getGuid();
            /** 查询用户对应员工的所有组织对象*/
            // 用于存放所有组织GUID的集合
            Set<String> partyGuids = new HashSet<>();
            // 查询员工隶属的组织对象
            //机构
            List<OmEmpOrg> omEmpOrgList = omEmpOrgService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
            for (OmEmpOrg empOrg : omEmpOrgList) {
                partyGuids.add(empOrg.getGuidOrg());
            }
            // 岗位
            Set<String> posiGuids = new HashSet<>();
            List<OmEmpPosition> omEmpPositionList = omEmpPositionService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
            for (OmEmpPosition empPosition : omEmpPositionList) {
                partyGuids.add(empPosition.getGuidPosition());
                posiGuids.add(empPosition.getGuidPosition());
            }
            // 工作组
            List<OmEmpGroup> omEmpGroupList = omEmpGroupService.query(new WhereCondition().andEquals("GUID_EMP", empGuid));
            for (OmEmpGroup omEmpGroup : omEmpGroupList) {
                partyGuids.add(omEmpGroup.getGuidGroup());
            }
            // 职务
            if (posiGuids.size() > 0) {
                List<OmPosition> omPositions = omPositionService.query(new WhereCondition().andIn("GUID", new ArrayList<>(posiGuids)));
                for (OmPosition omPosition : omPositions) {
                    partyGuids.add(omPosition.getGuidDuty());
                }
            }
            // 用于保存返回的角色集合
            List<AcRole> acRoleList = new ArrayList<>();
            //查询所有权限
            if (partyGuids.size() > 0) {
                List<AcPartyRole> acPartyRoles = acPartyRoleService.query(new WhereCondition()
                        .andIn("GUID_PARTY", new ArrayList<String>(partyGuids)));
                // 用于存放所有角色的GUID
                Set<String> roleGuids = new HashSet<>();
                for (AcPartyRole acPartyRole : acPartyRoles) {
                    roleGuids.add(acPartyRole.getGuidRole());
                }
                if (roleGuids.size() > 0) {
                    acRoleList = acRoleService.query(new WhereCondition().andIn("GUID", new ArrayList<String>(roleGuids)));
                }
            }
            return acRoleList;
        } catch (ToolsRuntimeException ae) {
            throw ae;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY, BasicUtil.wrap("AC_ROLE", e));
        }
    }

    /**
     * 查询角色在功能下的行为列表
     *
     * @param roleGuid 需要查询的角色GUID
     * @param funcGuid 查询的功能GUID
     * @return 返回该角色拥有此功能的行为列表 {@link AcRoleBhv}
     * @throws RoleManagementException
     */
    @Override
    public List<AcBhvDef> queryAcRoleBhvsByFuncGuid(String roleGuid, String funcGuid) throws RoleManagementException {
        if (StringUtils.isBlank(roleGuid)) {
            throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("roleGuid", "queryAcRoleBhvsByFuncGuid"));
        }
        if (StringUtils.isBlank(funcGuid)) {
            throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_QUERY, BasicUtil.wrap("funcGuid", "queryAcRoleBhvsByFuncGuid"));
        }
        try {
            return acRoleServiceExt.queryAcRoleBhvsByFuncGuid(roleGuid, funcGuid);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RoleManagementException(
                    ExceptionCodes.FAILURE_WHEN_QUERY, BasicUtil.wrap("queryAcRoleBhvsByFuncGuid", e));
        }
    }

    /**
     * 批量添加角色在功能下的行为列表
     *
     * @param acRoleBhvs 需要添加的行为列表 {@link AcRoleBhv}
     * @return 返回添加的该行为列表 {@link AcRoleBhv}
     * @throws RoleManagementException
     */
    @Override
    public void addAcRoleBhvs(List<AcRoleBhv> acRoleBhvs) throws RoleManagementException {
        if(CollectionUtils.isEmpty(acRoleBhvs)) {
            throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_INSERT, BasicUtil.wrap("acRoleBhvs", AcRoleBhv.TABLE_NAME));
        }
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    for(AcRoleBhv acRoleBhv : acRoleBhvs) {
                        String validateStr = BeanFieldValidateUtil.checkObjFieldNotRequired(acRoleBhv, new String[]{"guidApp"});
                        if(StringUtils.isNotBlank(validateStr)) {
                            throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_INSERT, BasicUtil.wrap(validateStr, AcRoleBhv.TABLE_NAME));
                        }
                        // 防止重复添加
                        if(acRoleBhvService.count(new WhereCondition().andEquals(AcRoleBhv.COLUMN_GUID_ROLE, acRoleBhv.getGuidRole())
                                .andEquals(AcRoleBhv.COLUMN_GUID_FUNC_BHV, acRoleBhv.getGuidFuncBhv())) > 0) {
                            throw new RoleManagementException(ExceptionCodes.DUPLICATE_WHEN_INSERT, BasicUtil.wrap(
                                    BasicUtil.surroundBracketsWithLFStr(AcRoleBhv.COLUMN_GUID_FUNC_BHV, acRoleBhv.getGuidFuncBhv()), AcRoleBhv.TABLE_NAME));
                        }
                        acRoleBhvService.insert(acRoleBhv);
                    }
                } catch (ToolsRuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                } catch (Exception e) {
                    status.setRollbackOnly();
                    e.printStackTrace();
                    throw new RoleManagementException(
                            ExceptionCodes.FAILURE_WHEN_INSERT, BasicUtil.wrap(AcBhvDef.TABLE_NAME, e));
                }
            }
        });
    }

    /**
     * 批量移除角色在功能下的行为列表
     *
     * @param acRoleBhvs 需要移除的行为列表 {@link AcRoleBhv}
     * @return 返回移除的该行为列表 {@link AcRoleBhv}
     * @throws RoleManagementException
     */
    @Override
    public void removeAcRoleBhvs(List<AcRoleBhv> acRoleBhvs) throws RoleManagementException {
        if(CollectionUtils.isEmpty(acRoleBhvs)) {
            throw new RoleManagementException(ExceptionCodes.NOT_ALLOW_NULL_WHEN_DELETE, BasicUtil.wrap("acRoleBhvs", AcRoleBhv.TABLE_NAME));
        }
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            public void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    for(AcRoleBhv acRoleBhv : acRoleBhvs) {
                        String validateStr = BeanFieldValidateUtil.checkObjFieldNotRequired(acRoleBhv, new String[]{"guidApp"});
                        if(StringUtils.isNotBlank(validateStr)) {
                            throw new RoleManagementException(ExceptionCodes.LACK_PARAMETERS_WHEN_DELETE, BasicUtil.wrap(validateStr, AcRoleBhv.TABLE_NAME));
                        }
                        acRoleBhvService.deleteByCondition(new WhereCondition()
                                .andEquals(AcRoleBhv.COLUMN_GUID_ROLE, acRoleBhv.getGuidRole())
                                .andEquals(AcRoleBhv.COLUMN_GUID_FUNC_BHV, acRoleBhv.getGuidFuncBhv()));
                    }
                } catch (ToolsRuntimeException e) {
                    status.setRollbackOnly();
                    throw e;
                } catch (Exception e) {
                    status.setRollbackOnly();
                    e.printStackTrace();
                    throw new RoleManagementException(
                            ExceptionCodes.FAILURE_WHEN_DELETE, BasicUtil.wrap(AcBhvDef.TABLE_NAME, e));
                }
            }
        });
    }
}
