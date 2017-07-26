/**
 * 
 */
package org.tis.tools.rservice.ac.capable;



import org.tis.tools.model.po.ac.AcApp;
import org.tis.tools.model.po.ac.AcFunc;
import org.tis.tools.model.po.ac.AcFuncgroup;
import org.tis.tools.model.po.ac.AcMenu;
import org.tis.tools.rservice.ac.exception.MenuManagementException;

import java.util.List;

/**
 * <pre>
 * 
 * 菜单（Menu）管理.</br>
 * 
 * 关于“菜单”：
 * <li>每个“应用（Application）”有自己的菜单树；
 * <li>菜单树可多层嵌套；
 * 
 * </pre>
 * 
 * @author megapro
 *
 */
public interface IMenuRService {

    /**
     * 查询所有应用系统
     * @return 应用系统集合
     */
    public List<AcApp> queryAllAcApp() throws MenuManagementException;

    /**
     * 查询应用下的根菜单
     * @param GUID_FUNC
     * @return
     */
    List<AcMenu> queryRootMenu(String GUID_FUNC) throws MenuManagementException;

    /**
     * 查询菜单下的子菜单
     * @param GUID_MENU
     * @return
     */
    List<AcMenu> queryChildMenu(String GUID_MENU) throws MenuManagementException;

    /**
     * 创建根菜单
     * @param acMenu
     * @throws MenuManagementException
     */
    void createRootMenu(AcMenu acMenu) throws MenuManagementException;

    /**
     * 创建子菜单
     * @param acMenu
     * @throws MenuManagementException
     */
    void createChildMenu(AcMenu acMenu) throws MenuManagementException;

    /**
     * 修改菜单
     * @param acMenu
     * @throws MenuManagementException
     */
    void editMenu(AcMenu acMenu) throws MenuManagementException;
    /**
     * 删除菜单
     * @param menuGuid
     * @throws MenuManagementException
     */
    void deleteMenu(String menuGuid) throws MenuManagementException;

}
