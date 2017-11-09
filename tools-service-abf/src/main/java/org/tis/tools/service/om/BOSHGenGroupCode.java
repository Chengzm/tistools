package org.tis.tools.service.om;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tis.tools.rservice.om.exception.GroupManagementException;
import org.tis.tools.rservice.sys.capable.ISeqnoRService;
import org.tis.tools.service.base.SequenceService;
import org.tis.tools.service.om.exception.OMExceptionCodes;
import org.tis.tools.spi.om.IGroupCodeGenerator;

@Service
public class BOSHGenGroupCode implements IGroupCodeGenerator{

	@Autowired
	SequenceService sequenceService ;

	@Autowired
	ISeqnoRService seqnoRService;

	/**
	 *
	 * @param groupType
	 * @return
	 * @throws GroupManagementException
	 */
	@Override
	public String genGroupCode(String groupType) throws GroupManagementException {
//		String groupType = parms.get("groupType") ;
		if(StringUtils.isEmpty(groupType)) {
			throw new GroupManagementException(OMExceptionCodes.LAKE_PARMS_FOR_GEN_GROUPCODE,new Object[]{"groupType"}) ; 
		}
		/**
		 * <pre>
		 * 工作组代码规则：
		 * 1.共10位+GROUP前缀；
		 * 2.组成结构： 工作组类别(两位) + 序号(八位)
		 * 序号：全行范围内职务数量顺序排号
		 * </pre>
		 */
		StringBuffer sb = new StringBuffer() ;
		//翻译类型-NORMAL=01 PROJECT=02 AFFAIR=03
		String type = "";
		if(groupType.equals("normal")){
			type = "01";
		}else if(groupType.equals("project")){
			type = "02";
		}else if(groupType.equals("affair")){
			type = "03";
		}else{
			throw new GroupManagementException(OMExceptionCodes.LAKE_PARMS_FOR_GEN_GROUPCODE,new Object[]{"groupType"}) ; 
		}
		// 开始生成
		sb.append(type) ;
//		sb.append(toSeqNO(sequenceService.getNextSeqNo(BOSHGenGroupCode.class.getName()))) ;//五位机构顺序号
		sb.append(toSeqNO(seqnoRService.getNextSequence("GROUP_CODE", "工作组代码序号")));
		return "GROUP"+sb.toString();
	}
	
	/**
	 * 把当前工作组数量转为8位字符串，不足部分以0左补齐
	 * @param totalOrgCount
	 * @return
	 */
	private Object toSeqNO(long totalOrgCount) {
		
		String t = String.valueOf(totalOrgCount) ;
		
		return org.tis.tools.common.utils.StringUtil.leftPad(t, 8, '0');
		
	}
	
}
