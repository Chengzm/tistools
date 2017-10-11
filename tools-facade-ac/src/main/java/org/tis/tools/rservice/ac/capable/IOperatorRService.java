/**
 * 
 */
package org.tis.tools.rservice.ac.capable;

import org.springframework.expression.spel.ast.Operator;
import org.tis.tools.model.po.ac.*;
import org.tis.tools.model.vo.ac.AcOperatorFuncDetail;
import org.tis.tools.rservice.ac.exception.AuthManagementException;
import org.tis.tools.rservice.ac.exception.OperatorManagementException;

import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 * 
 * 操作员（Operator）管理.</br>
 * 
 * 操作员是功能的操作主体，也是权限控制的针对对象.</br>
 * 
 * 关于“操作员”：
 * <li>每个员工有一个唯一的操作员；
 * <li>操作员身份：每个操作员可有多个角色，有时这些角色不能全部生效，</br>根据需要为操作员设定多个身份，身份代表了部分权限集合，在登陆应用系统时只生效其中某个身份；
 * <li>特殊权限：可直接将功能，或多个功能的操作功能特殊指派给操作员；
 * <li>自定义菜单：操作员根据自身需要，对应用系统默认菜单进行重组，自定义菜单只有操作员登陆时生效；
 * <li>快捷键：将常用功能指定为快捷键启动，目前提供的快捷键设置范围为 ctrl + 0 ~ 9，可按应用系统区分；
 * <li>个性化配置：有些应用系统提供给操作员的首选项配置，允许操作员作出适合使用系统的配置；
 * 
 * </pre>
 * 
 * @author megapro
 *
 */
public interface IOperatorRService {

    /**
     * 新增操作员
     * @param acOperator
     * @throws OperatorManagementException
     */
    void createOperator(AcOperator acOperator) throws OperatorManagementException;

    /**
     * 修改操作员
     * @param acOperator
     * @throws OperatorManagementException
     */
    void editOperator(AcOperator acOperator) throws OperatorManagementException;

    /**
     * 删除操作员
     * @param operatorGuid
     *              操作员GUID
     * @throws OperatorManagementException
     */
    void deleteOperator(String operatorGuid) throws OperatorManagementException;

    /**
     * 查询操作员列表
     * @return 操作员对象集合
     * @throws OperatorManagementException
     */
    List<AcOperator> queryOperators() throws OperatorManagementException;

    /**
     * 查询操作员对应的身份集合
     * @param operatorGuid
     * @return
     * @throws OperatorManagementException
     */
    List<AcOperatorIdentity> queryOperatorIdentities(String operatorGuid) throws OperatorManagementException;

    /**
     * 新增操作员身份
     * @param operatorIdentity
     * @throws OperatorManagementException
     */
    void createOperatorIdentity(AcOperatorIdentity operatorIdentity) throws OperatorManagementException;

    /**
     * 修改操作员身份
     * @param operatorIdentity
     * @throws OperatorManagementException
     */
    void editOperatorIdentity(AcOperatorIdentity operatorIdentity) throws OperatorManagementException;

    /**
     * 删除操作员身份
     * @param operatorIdenGuid
     * @throws OperatorManagementException
     */
    void deleteOperatorIdentity(String operatorIdenGuid) throws OperatorManagementException;

    /**
     * 设置默认操作员身份
     * @param operatorIdenGuid
     * @throws OperatorManagementException
     */
    void setDefaultOperatorIdentity(String operatorIdenGuid) throws OperatorManagementException;


    /**
     * 新增操作员身份权限
     * @param operatorIdentityresList
     * @throws OperatorManagementException
     */
    void createOperatorIdentityres(List<AcOperatorIdentityres> operatorIdentityresList) throws OperatorManagementException;

    /**
     * 修改操作员身份权限
     * @param operatorIdentityres
     * @throws OperatorManagementException
     */
    void editOperatorIdentityres(AcOperatorIdentityres operatorIdentityres) throws OperatorManagementException;

    /**
     * 删除操作员身份权限
     * @param identityresList 身份权限资源集合，每个资源包含资源类型GUID和资源GUID
     * @throws OperatorManagementException
     */
    void deleteOperatorIdentityres(List<AcOperatorIdentityres> identityresList) throws OperatorManagementException;

    /**
     * 查询操作员身份对应的权限集合
     * @param operatorIdentityGuid
     * @return
     * @throws OperatorManagementException
     */
    List<Map> queryOperatorIdentityreses(String operatorIdentityGuid) throws OperatorManagementException;


    /**
     * 通过USER_ID 和 OPERATOR_NAME 查询 操作员身份列表
     * @param userId 操作员登录名
     *
     *
     * @return
     * @throws OperatorManagementException
     */
    List<AcOperatorIdentity> queryOperatorIdentitiesByUserId(String userId) throws OperatorManagementException;

    /**
     * 查询操作员资源类型下的所有角色
     * @param operatorGuid
     * @param resType
     * @return
     * @throws OperatorManagementException
     */
    List<AcRole> queryOperatorRoleByResType(String operatorGuid, String resType) throws OperatorManagementException;

    /**
     * 用户状态修改
     *
     * @param userId
     * @param status
     * @throws AuthManagementException
     */
    void updateUserStatus(String userId, String status) throws OperatorManagementException;


    /**
     * 根据用户名查询操作员信息
     * @param userId
     * @return
     * @throws OperatorManagementException
     */

    AcOperator queryOperatorByUserId(String userId) throws OperatorManagementException;

    /**
     * 查询操作员特殊功能权限集
     *     来源  操作员对应员工的工作组和岗位相关应用下未授权给该操作员的功能
     *
     *     业务逻辑  查询操作员已拥有应用的所有功能集合  操作员已授权和继承的所有角色拥有功能的并集 的差集
     *
     *     场景  1.用于操作员分配特殊功能权限时展示功能列表
     * @param userId
     *          用户ID
     * @return
     *
     * @throws OperatorManagementException
     */
    AcOperatorFuncDetail queryOperatorFuncInfoInApp(String userId) throws OperatorManagementException;

    /**
     * 查询用户的功能列表详情
     *  可用于展示特殊权限列表
     *
     * @param userId
     *          用户名
     * @return
     * @throws OperatorManagementException
     */
    List<Map> queryAcOperatorFunListByUserId(String userId) throws OperatorManagementException;

    /**
     * 添加特殊权限
     * @param acOperatorFunc
     * @throws OperatorManagementException
     */
    void addAcOperatorFun(AcOperatorFunc acOperatorFunc) throws OperatorManagementException;

    /**
     * 移除特殊权限
     *
     * @param operatorGuid
     *          操作员GUID
     *
     * @param funcGuid
     *          功能GUID
     * @throws OperatorManagementException
     */
    void removeAcOperatorFun(String operatorGuid, String funcGuid) throws OperatorManagementException;

    /**
     * 查询所有个性化配置
     * @return 配置集合
     * @throws OperatorManagementException
     */
    List<AcConfig> queryConfigList() throws OperatorManagementException;

    /**
     * 新增个性化配置
     * @param config
     * @return
     * @throws OperatorManagementException
     */
    AcConfig addConfig(AcConfig config) throws OperatorManagementException;

    /**
     * 批量删除个性化配置
     * @param cfgList
     * @return
     * @throws OperatorManagementException
     */
    List<AcConfig> deleteConfig(List<AcConfig> cfgList) throws OperatorManagementException;

    /**
     * 修改个性化配置
     * @param config
     * @return
     * @throws OperatorManagementException
     */
    AcConfig updateConfig(AcConfig config) throws OperatorManagementException;

    /**
     * 保存操作员配置
     * @param acOperatorConfig
     * @return
     * @throws OperatorManagementException
     */
    AcOperatorConfig saveOperatorLog(AcOperatorConfig acOperatorConfig) throws OperatorManagementException;

    /**
     * 查询操作员的个性化配置
     * @param userId 操作员
     * @param appGuid 应用
     * @return
     * @throws OperatorManagementException
     */
    List<AcConfig> queryOperatorConfig(String userId, String appGuid) throws OperatorManagementException;


    /**
     * 查询操作员在某功能的行为白名单和黑名单
     * @param funGuid
     * @param userId
     * @return
     * @throws OperatorManagementException
     */
    Map<String, Object> queryOperatorBhvListInFunc(String funGuid, String userId) throws OperatorManagementException;

    /**
     * 操作员功能行为添加黑名单
     * @param operatorBhvList
     * @return
     * @throws OperatorManagementException
     */
    List<AcOperatorBhv> addOperatorBhvBlackList(List<AcOperatorBhv> operatorBhvList) throws OperatorManagementException;

    /**
     * 操作员功能行为移除黑名单
     * @param operatorBhvList
     * @return
     * @throws OperatorManagementException
     */
    List<AcOperatorBhv> deleteOperatorBhvBlackList(List<AcOperatorBhv> operatorBhvList) throws OperatorManagementException;

    /**
     * 查询操作员在应用下已授权功能;
     * @param userId 操作员
     * @param appGuid 应用
     * @return
     * @throws OperatorManagementException
     */
    AcOperatorFuncDetail getOperatorFuncInfo(String userId, String appGuid) throws OperatorManagementException;




}
