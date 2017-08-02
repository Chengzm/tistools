/**
 * 
 */
package org.tis.tools.rservice.om.exception;

import org.tis.tools.base.exception.ToolsRuntimeException;

/**
 * 
 * 人员管理服务异常对象
 * 
 * @author megapro
 *
 */
public class EmployeeManagementException extends ToolsRuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmployeeManagementException(){
		
	}
	public EmployeeManagementException(String code) {
		super(code);
	}
	
	public EmployeeManagementException(String code, Object[] placeholders) {
		super(code,placeholders) ;
	}
	
	public EmployeeManagementException(String code, Object[] params, String message) {
		super(code,params,message) ;
	}

	public EmployeeManagementException(String code, String message) {
		super(code,message) ;
	}

}
