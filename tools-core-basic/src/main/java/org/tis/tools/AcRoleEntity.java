package org.tis.tools;

import java.io.Serializable;

/**
 * Model class of 角色实体关系.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class AcRoleEntity implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 权限集(角色). */
	private AcRole roleacRole;

	/** 实体. */
	private AcEntity entityacEntity;

	/** 可增加. */
	private String isadd;

	/** 可删除. */
	private String isdel;

	/** 可修改. */
	private String ismodify;

	/** 可查看. */
	private String isview;

	/**
	 * Constructor.
	 */
	public AcRoleEntity() {
	}

	/**
	 * Set the 权限集(角色).
	 * 
	 * @param roleacRole
	 *            权限集(角色)
	 */
	public void setroleacRole(AcRole roleacRole) {
		this.roleacRole = roleacRole;
	}

	/**
	 * Get the 权限集(角色).
	 * 
	 * @return 权限集(角色)
	 */
	public AcRole getroleacRole() {
		return this.roleacRole;
	}

	/**
	 * Set the 实体.
	 * 
	 * @param entityacEntity
	 *            实体
	 */
	public void setentityacEntity(AcEntity entityacEntity) {
		this.entityacEntity = entityacEntity;
	}

	/**
	 * Get the 实体.
	 * 
	 * @return 实体
	 */
	public AcEntity getentityacEntity() {
		return this.entityacEntity;
	}

	/**
	 * Set the 可增加.
	 * 
	 * @param isadd
	 *            可增加
	 */
	public void setIsadd(String isadd) {
		this.isadd = isadd;
	}

	/**
	 * Get the 可增加.
	 * 
	 * @return 可增加
	 */
	public String getIsadd() {
		return this.isadd;
	}

	/**
	 * Set the 可删除.
	 * 
	 * @param isdel
	 *            可删除
	 */
	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	/**
	 * Get the 可删除.
	 * 
	 * @return 可删除
	 */
	public String getIsdel() {
		return this.isdel;
	}

	/**
	 * Set the 可修改.
	 * 
	 * @param ismodify
	 *            可修改
	 */
	public void setIsmodify(String ismodify) {
		this.ismodify = ismodify;
	}

	/**
	 * Get the 可修改.
	 * 
	 * @return 可修改
	 */
	public String getIsmodify() {
		return this.ismodify;
	}

	/**
	 * Set the 可查看.
	 * 
	 * @param isview
	 *            可查看
	 */
	public void setIsview(String isview) {
		this.isview = isview;
	}

	/**
	 * Get the 可查看.
	 * 
	 * @return 可查看
	 */
	public String getIsview() {
		return this.isview;
	}


}