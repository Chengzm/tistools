/**
 * 
 */
package org.tools.service.txmodel.command;

import org.tis.tools.rservice.txmodel.TxModelConstants.BHVCODE;
import org.tis.tools.rservice.txmodel.TxModelConstants.BHVTYPE;

/**
 * 操作行为命令：打开交易
 * 
 * @author megapro
 *
 */
public class OpenTxBhvCommand extends AbstractBhvCommand {


	OpenTxBhvCommand(){
		this(BHVCODE.OPEN_TX) ; //使用默认的代码
	}
	
	OpenTxBhvCommand(BHVCODE bhvCode) {
		super(bhvCode);
	}

	@Override
	public BHVTYPE[] getBhvTypes() {
		// TODO Auto-generated method stub
		return null;
	}
}
