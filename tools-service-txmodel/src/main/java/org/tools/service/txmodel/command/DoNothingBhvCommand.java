/**
 * 
 */
package org.tools.service.txmodel.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tis.tools.rservice.txmodel.message.ITxResponse;
import org.tools.service.txmodel.IOperatorBhvCommand;
import org.tools.service.txmodel.IOperatorBhvHandler;
import org.tools.service.txmodel.ITxEngine;
import org.tools.service.txmodel.TxContext;
import org.tools.service.txmodel.TxModelConstants.BHVCODE;
import org.tools.service.txmodel.TxModelConstants.BHVTYPE;
import org.tools.service.txmodel.handler.DefaultOperatorBhvHandler;

/**
 * 操作行为命令：空操作
 * @author megapro
 *
 */
public class DoNothingBhvCommand implements IOperatorBhvCommand {

	protected final Logger logger = LoggerFactory.getLogger(DoNothingBhvCommand.class);
	private IOperatorBhvHandler handler = new  DefaultOperatorBhvHandler() ; 

	@Override
	public BHVCODE getBhvCode() {
		return BHVCODE.NONOPERATOR;
	}

	@Override
	public void setOperatorBhvHandler(IOperatorBhvHandler handler) {
		return ; 
	}

	@Override
	public boolean canEngine(ITxEngine engine) {
		return true;//所有交易引擎都能处理空命令
	}

	@Override
	public BHVTYPE[] getBhvTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ITxResponse execute(TxContext txContext) {
		logger.info("交易引擎执行空操作！");
		logger.debug("当前正在处理交易<"+txContext.getTxDefinition()+">操作请求:"+txContext.getTxRequest());
		return handler.handle(txContext);
	}


}
