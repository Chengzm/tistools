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

	/**
	 * 异常：交易引擎｛0｝中没有定义｛1｝这种操作行为.<br>
	 */
	public static final String UNDEFINED_BHV_IN_TXENGINE = R_EX_CODE("0002");

	/**
	 * 异常：系统没有定义这种行为类型｛0｝.<br>
	 */
	public static final String UNDEFINED_BHV_TYPE = R_EX_CODE("0003");
	
	/**
	 * 异常：交易请求对象中，缺少请求ID. <br>
	 * lcak request id to be a normal TxReqeust Object.<br>
	 */
	public static final String LACK_REQUEST_ID = R_EX_CODE("0004");

	/**
	 * 异常：交易请求对象中，缺少交易代码. <br>
	 * lcak tx_code to be a normal TxReqeust Object.<br>
	 */
	public static final String LACK_TX_CODE = R_EX_CODE("0005");

	/**
	 * 异常：交易请求对象中，缺少操作行为代码.<br>
	 * lcak bhv_code to be a normal TxReqeust Object.<br>
	 */
	public static final String LACK_BHV_CODE = R_EX_CODE("0006");
	
	/**
	 * 异常：交易请求对象中，缺少渠道代码.<br>
	 * lcak channel id be a normal TxReqeust Object.<br>
	 */
	public static final String LACK_CHANNEL_ID = R_EX_CODE("0007");
	
	
}
