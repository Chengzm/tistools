package org.tis.tools.dao.ac;

import org.apache.ibatis.annotations.Param;
import org.tis.tools.model.po.ac.AcMenu;

import java.math.BigDecimal;
import java.util.List;

public interface AcMenuMapperExt {

    /**
     * 获取用户下的菜单
     *
     * @param appGuid
     * @return
     */
    List<AcMenu> getMenuByUserId(@Param("userId") String userId, @Param("appGuid") String appGuid);

    List<AcMenu> getMenuByUserIdentity(@Param("identityGuid") String identityGuid, @Param("appGuid") String appGuid);

    void reorderMenu(@Param("targetGuid")String identityGuid, @Param("index") BigDecimal index, @Param("flag") String flag);

    void reorderOperatorMenu(@Param("targetGuid")String identityGuid, @Param("index") BigDecimal index, @Param("flag") String flag);

}
