/**
 * 
 */
package org.tis.tools.rservice.txmodel.message;

import java.io.Serializable;

/**
 * <pre>
 * 交易请求对象
 * 
 * 一个完整的请求对象由交易头{@link TxHeader}、交易控制 {@link TxControl}、交易请求数据{@link TxData}三部分组成
 * </pre>
 * 
 * @author megapro
 *
 */
public class TxRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TxControl getTxControl () {
		
		return null ; 
	}
	
	public TxHeader getTxHeader(){
		
		return null ;
	}
	
	public TxData getRequestData(){
		
		return null ; 
	}
}
