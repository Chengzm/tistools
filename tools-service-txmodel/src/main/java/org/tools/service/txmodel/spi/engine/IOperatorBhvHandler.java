/**
 * 
 */
package org.tools.service.txmodel.spi.engine;

import org.tis.tools.rservice.txmodel.spi.message.ITxResponse;

/**
 * 
 * <pre>
 * 交易操作行为处理器接口
 * 
 * 操作行为处理器，是具体执行交易操作处理逻辑的接口，每个操作都有具体的处理实现类，
 * 
 * 同一个行为，在不同渠道<code>channelID</code>，有不同的处理实现。
 * </pre>
 * 
 * @author megapro
 *
 */
public interface IOperatorBhvHandler {
	
	/**
	 * 处理器名称
	 * @return
	 */
	public String getName() ; 
	
	public void setName(String name) ; 
	
	/**
	 * 我能处理那个渠道
	 * 
	 * @param context
	 *            {@link TxContext 交易上下文}
	 * @return true 能处理渠道channelID请求来的操作行为 </br> false 不支持
	 */
	public boolean canHandle(TxContext context);
	
	/**
	 * 处理交易操作行为
	 * 
	 * @param context
	 *            {@link TxContext 交易上下文}
	 * @return 交易响应
	 */
	public ITxResponse handle(TxContext context);
	
}
