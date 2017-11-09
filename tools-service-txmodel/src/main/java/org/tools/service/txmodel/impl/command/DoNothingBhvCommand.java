/**
 * 
 */
package org.tools.service.txmodel.impl.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tis.tools.rservice.txmodel.TxModelEnums.BHVCODE;
import org.tis.tools.rservice.txmodel.spi.message.ITxResponse;
import org.tools.service.txmodel.impl.handler.DefaultOperatorBhvHandler;
import org.tools.service.txmodel.spi.engine.IOperatorBhvCommand;
import org.tools.service.txmodel.spi.engine.IOperatorBhvHandler;
import org.tools.service.txmodel.spi.engine.TxContext;

/**
 * 操作行为命令：空操作
 * @author megapro
 *
 */
public class DoNothingBhvCommand implements IOperatorBhvCommand {

	protected final Logger logger = LoggerFactory.getLogger(DoNothingBhvCommand.class);
	private IOperatorBhvHandler handler = null ; 

	@Override
	public BHVCODE getBhvCode() {
		return BHVCODE.NONOPERATOR;
	}

	@Override
	public void setOperatorBhvHandler(IOperatorBhvHandler handler) {
		this.handler = new  DefaultOperatorBhvHandler();
	}

	@Override
	public ITxResponse execute(TxContext txContext) {
		logger.warn("收到交易操作请求:"+txContext.getTxRequest()+".但不能识别操作命令<"+this.getBhvCode()+">");
		return handler.handle(txContext);
	}
}
