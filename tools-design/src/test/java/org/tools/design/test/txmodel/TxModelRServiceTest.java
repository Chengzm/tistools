/**
 * 
 */
package org.tools.design.test.txmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.rservice.txmodel.ITxModelRService;
import org.tis.tools.rservice.txmodel.message.ITxRequest;
import org.tis.tools.rservice.txmodel.message.ITxResponse;
import org.tools.design.SpringJunitSupport;

import junit.framework.Assert;

/**
 * @author megapro
 *
 */
public class TxModelRServiceTest extends SpringJunitSupport {

	@Autowired
	ITxModelRService txModelRService;

	@Before
	public void before() {

	}

	@After
	public void after() {

	}

	/**
	 * 测试 交易模式服务：提交交易
	 */
	@Test
	public void testOpenTx() {

		ITxRequest request = null;
		ITxResponse response = txModelRService.execute(request);

//		Assert.assertEquals(expected, actual);
	}

}
