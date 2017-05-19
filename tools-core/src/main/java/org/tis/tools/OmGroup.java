package org.tis.tools;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Model class of 工作组.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class OmGroup implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 数据主键. */
	private String guid;

	/** 工作组代码. */
	private String groupCode;

	/** 工作组名称. */
	private String groupName;

	/** 工作组类型. */
	private String groupType;

	/** 工作组状态. */
	private String groupStatus;

	/** 工作组描述. */
	private String groupDesc;

	/** 负责人. */
	private String guidEmpManager;

	/** 机构信息表. */
	private OmOrg orgomOrg;

	/** 工作组. */
	private OmGroup parentsomGroup;

	/** 是否叶子节点. */
	private String isleaf;

	/** 子节点数. */
	private Integer subCount;

	/** 工作组层次. */
	private Integer groupLevel;

	/** 工作组序列. */
	private String groupSeq;

	/** 工作组有效开始日期. */
	private Date startDate;

	/** 工作组有效截止日期. */
	private Date endDate;

	/** 创建时间. */
	private Date createtime;

	/** 最近更新时间. */
	private Date lastupdate;

	/** 最近更新人员. */
	private String updator;

	/** The set of 应用工作组列表. */
	private Set<OmAppGroup> omAppGroupSet;

	/** The set of 人员工作组对应关系. */
	private Set<OmEmpGroup> omEmpGroupSet;

	/** The set of 工作组. */
	private Set<OmGroup> omGroupSet;

	/** The set of 工作组岗位列表. */
	private Set<OmGroupPosition> omGroupPositionSet;

	/**
	 * Constructor.
	 */
	public OmGroup() {
		this.omAppGroupSet = new HashSet<OmAppGroup>();
		this.omEmpGroupSet = new HashSet<OmEmpGroup>();
		this.omGroupSet = new HashSet<OmGroup>();
		this.omGroupPositionSet = new HashSet<OmGroupPosition>();
	}

	/**
	 * Set the 数据主键.
	 * 
	 * @param guid
	 *            数据主键
	 */
	public void setGuid(String guid) {
		this.guid = guid;
	}

	/**
	 * Get the 数据主键.
	 * 
	 * @return 数据主键
	 */
	public String getGuid() {
		return this.guid;
	}

	/**
	 * Set the 工作组代码.
	 * 
	 * @param groupCode
	 *            工作组代码
	 */
	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	/**
	 * Get the 工作组代码.
	 * 
	 * @return 工作组代码
	 */
	public String getGroupCode() {
		return this.groupCode;
	}

	/**
	 * Set the 工作组名称.
	 * 
	 * @param groupName
	 *            工作组名称
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * Get the 工作组名称.
	 * 
	 * @return 工作组名称
	 */
	public String getGroupName() {
		return this.groupName;
	}

	/**
	 * Set the 工作组类型.
	 * 
	 * @param groupType
	 *            工作组类型
	 */
	public void setGroupType(String groupType) {
		this.groupType = groupType;
	}

	/**
	 * Get the 工作组类型.
	 * 
	 * @return 工作组类型
	 */
	public String getGroupType() {
		return this.groupType;
	}

	/**
	 * Set the 工作组状态.
	 * 
	 * @param groupStatus
	 *            工作组状态
	 */
	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}

	/**
	 * Get the 工作组状态.
	 * 
	 * @return 工作组状态
	 */
	public String getGroupStatus() {
		return this.groupStatus;
	}

	/**
	 * Set the 工作组描述.
	 * 
	 * @param groupDesc
	 *            工作组描述
	 */
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	/**
	 * Get the 工作组描述.
	 * 
	 * @return 工作组描述
	 */
	public String getGroupDesc() {
		return this.groupDesc;
	}

	/**
	 * Set the 负责人.
	 * 
	 * @param guidEmpManager
	 *            负责人
	 */
	public void setGuidEmpManager(String guidEmpManager) {
		this.guidEmpManager = guidEmpManager;
	}

	/**
	 * Get the 负责人.
	 * 
	 * @return 负责人
	 */
	public String getGuidEmpManager() {
		return this.guidEmpManager;
	}

	/**
	 * Set the 机构信息表.
	 * 
	 * @param orgomOrg
	 *            机构信息表
	 */
	public void setorgomOrg(OmOrg orgomOrg) {
		this.orgomOrg = orgomOrg;
	}

	/**
	 * Get the 机构信息表.
	 * 
	 * @return 机构信息表
	 */
	public OmOrg getorgomOrg() {
		return this.orgomOrg;
	}

	/**
	 * Set the 工作组.
	 * 
	 * @param parentsomGroup
	 *            工作组
	 */
	public void setparentsomGroup(OmGroup parentsomGroup) {
		this.parentsomGroup = parentsomGroup;
	}

	/**
	 * Get the 工作组.
	 * 
	 * @return 工作组
	 */
	public OmGroup getparentsomGroup() {
		return this.parentsomGroup;
	}

	/**
	 * Set the 是否叶子节点.
	 * 
	 * @param isleaf
	 *            是否叶子节点
	 */
	public void setIsleaf(String isleaf) {
		this.isleaf = isleaf;
	}

	/**
	 * Get the 是否叶子节点.
	 * 
	 * @return 是否叶子节点
	 */
	public String getIsleaf() {
		return this.isleaf;
	}

	/**
	 * Set the 子节点数.
	 * 
	 * @param subCount
	 *            子节点数
	 */
	public void setSubCount(Integer subCount) {
		this.subCount = subCount;
	}

	/**
	 * Get the 子节点数.
	 * 
	 * @return 子节点数
	 */
	public Integer getSubCount() {
		return this.subCount;
	}

	/**
	 * Set the 工作组层次.
	 * 
	 * @param groupLevel
	 *            工作组层次
	 */
	public void setGroupLevel(Integer groupLevel) {
		this.groupLevel = groupLevel;
	}

	/**
	 * Get the 工作组层次.
	 * 
	 * @return 工作组层次
	 */
	public Integer getGroupLevel() {
		return this.groupLevel;
	}

	/**
	 * Set the 工作组序列.
	 * 
	 * @param groupSeq
	 *            工作组序列
	 */
	public void setGroupSeq(String groupSeq) {
		this.groupSeq = groupSeq;
	}

	/**
	 * Get the 工作组序列.
	 * 
	 * @return 工作组序列
	 */
	public String getGroupSeq() {
		return this.groupSeq;
	}

	/**
	 * Set the 工作组有效开始日期.
	 * 
	 * @param startDate
	 *            工作组有效开始日期
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * Get the 工作组有效开始日期.
	 * 
	 * @return 工作组有效开始日期
	 */
	public Date getStartDate() {
		return this.startDate;
	}

	/**
	 * Set the 工作组有效截止日期.
	 * 
	 * @param endDate
	 *            工作组有效截止日期
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * Get the 工作组有效截止日期.
	 * 
	 * @return 工作组有效截止日期
	 */
	public Date getEndDate() {
		return this.endDate;
	}

	/**
	 * Set the 创建时间.
	 * 
	 * @param createtime
	 *            创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	/**
	 * Get the 创建时间.
	 * 
	 * @return 创建时间
	 */
	public Date getCreatetime() {
		return this.createtime;
	}

	/**
	 * Set the 最近更新时间.
	 * 
	 * @param lastupdate
	 *            最近更新时间
	 */
	public void setLastupdate(Date lastupdate) {
		this.lastupdate = lastupdate;
	}

	/**
	 * Get the 最近更新时间.
	 * 
	 * @return 最近更新时间
	 */
	public Date getLastupdate() {
		return this.lastupdate;
	}

	/**
	 * Set the 最近更新人员.
	 * 
	 * @param updator
	 *            最近更新人员
	 */
	public void setUpdator(String updator) {
		this.updator = updator;
	}

	/**
	 * Get the 最近更新人员.
	 * 
	 * @return 最近更新人员
	 */
	public String getUpdator() {
		return this.updator;
	}

	/**
	 * Set the set of the 应用工作组列表.
	 * 
	 * @param omAppGroupSet
	 *            The set of 应用工作组列表
	 */
	public void setOmAppGroupSet(Set<OmAppGroup> omAppGroupSet) {
		this.omAppGroupSet = omAppGroupSet;
	}

	/**
	 * Add the 应用工作组列表.
	 * 
	 * @param omAppGroup
	 *            应用工作组列表
	 */
	public void addOmAppGroup(OmAppGroup omAppGroup) {
		this.omAppGroupSet.add(omAppGroup);
	}

	/**
	 * Get the set of the 应用工作组列表.
	 * 
	 * @return The set of 应用工作组列表
	 */
	public Set<OmAppGroup> getOmAppGroupSet() {
		return this.omAppGroupSet;
	}

	/**
	 * Set the set of the 人员工作组对应关系.
	 * 
	 * @param omEmpGroupSet
	 *            The set of 人员工作组对应关系
	 */
	public void setOmEmpGroupSet(Set<OmEmpGroup> omEmpGroupSet) {
		this.omEmpGroupSet = omEmpGroupSet;
	}

	/**
	 * Add the 人员工作组对应关系.
	 * 
	 * @param omEmpGroup
	 *            人员工作组对应关系
	 */
	public void addOmEmpGroup(OmEmpGroup omEmpGroup) {
		this.omEmpGroupSet.add(omEmpGroup);
	}

	/**
	 * Get the set of the 人员工作组对应关系.
	 * 
	 * @return The set of 人员工作组对应关系
	 */
	public Set<OmEmpGroup> getOmEmpGroupSet() {
		return this.omEmpGroupSet;
	}

	/**
	 * Set the set of the 工作组.
	 * 
	 * @param omGroupSet
	 *            The set of 工作组
	 */
	public void setOmGroupSet(Set<OmGroup> omGroupSet) {
		this.omGroupSet = omGroupSet;
	}

	/**
	 * Add the 工作组.
	 * 
	 * @param omGroup
	 *            工作组
	 */
	public void addOmGroup(OmGroup omGroup) {
		this.omGroupSet.add(omGroup);
	}

	/**
	 * Get the set of the 工作组.
	 * 
	 * @return The set of 工作组
	 */
	public Set<OmGroup> getOmGroupSet() {
		return this.omGroupSet;
	}

	/**
	 * Set the set of the 工作组岗位列表.
	 * 
	 * @param omGroupPositionSet
	 *            The set of 工作组岗位列表
	 */
	public void setOmGroupPositionSet(Set<OmGroupPosition> omGroupPositionSet) {
		this.omGroupPositionSet = omGroupPositionSet;
	}

	/**
	 * Add the 工作组岗位列表.
	 * 
	 * @param omGroupPosition
	 *            工作组岗位列表
	 */
	public void addOmGroupPosition(OmGroupPosition omGroupPosition) {
		this.omGroupPositionSet.add(omGroupPosition);
	}

	/**
	 * Get the set of the 工作组岗位列表.
	 * 
	 * @return The set of 工作组岗位列表
	 */
	public Set<OmGroupPosition> getOmGroupPositionSet() {
		return this.omGroupPositionSet;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((guid == null) ? 0 : guid.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		OmGroup other = (OmGroup) obj;
		if (guid == null) {
			if (other.guid != null) {
				return false;
			}
		} else if (!guid.equals(other.guid)) {
			return false;
		}
		return true;
	}

}