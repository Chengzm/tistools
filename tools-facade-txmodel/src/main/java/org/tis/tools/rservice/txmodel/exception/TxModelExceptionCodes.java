/**
 * 
 */
package org.tis.tools.rservice.txmodel.exception;

/**
 * <pre>
 * 交易模式服务模块的异常码定义.</br>
 * 范围： TXMODEL-0001 ~ TXMODEL-9999
 * </pre>
 * 
 * @author megapro
 *
 */
public class TxModelExceptionCodes {

	/**
	 * 异常码前缀： TXMODEL
	 */
	private static final String R_EX_PREFIX = "TXMODEL";
	
	/**
	 * 以烤串方式拼接异常码
	 * @param code 业务域范围内的异常编码
	 * @return
	 */
	private static String R_EX_CODE(String code) {
		return R_EX_PREFIX + "-" + code;
	}
	
	/**
	 * 异常：引擎执行时，缺少操作行为命令.<br>
	 */
	public static final String LACK_OPERATOR_BHV_COMMAND = R_EX_CODE("0001");
	
	
}