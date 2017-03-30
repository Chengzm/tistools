
/* Drop Tables */

DROP TABLE OM_APPGROUP CASCADE CONSTRAINTS;
DROP TABLE OM_APPPOSI CASCADE CONSTRAINTS;
DROP TABLE AC_APPLICATION CASCADE CONSTRAINTS;
DROP TABLE AC_ROLEDATAPRIV CASCADE CONSTRAINTS;
DROP TABLE AC_DATASCOPE CASCADE CONSTRAINTS;
DROP TABLE AC_ENTITYFIELDROLE CASCADE CONSTRAINTS;
DROP TABLE AC_ENTITYFIELD CASCADE CONSTRAINTS;
DROP TABLE AC_ENTITYROLE CASCADE CONSTRAINTS;
DROP TABLE AC_ENTITY CASCADE CONSTRAINTS;
DROP TABLE AC_FUNCRESOURCE CASCADE CONSTRAINTS;
DROP TABLE AC_OPERFUNC CASCADE CONSTRAINTS;
DROP TABLE AC_ROLEFUNC CASCADE CONSTRAINTS;
DROP TABLE AC_FUNCTION CASCADE CONSTRAINTS;
DROP TABLE AC_FUNCGROUP CASCADE CONSTRAINTS;
DROP TABLE AC_APPLICATION CASCADE CONSTRAINTS;
DROP TABLE AC_IDENTITYRES CASCADE CONSTRAINTS;
DROP TABLE AC_IDENTITY CASCADE CONSTRAINTS;
DROP TABLE AC_MENU CASCADE CONSTRAINTS;
DROP TABLE AC_OPERATOR CASCADE CONSTRAINTS;
DROP TABLE AC_OPERATORROLE CASCADE CONSTRAINTS;
DROP TABLE AC_OPERCONFIG CASCADE CONSTRAINTS;
DROP TABLE AC_OPERCUSTMENU CASCADE CONSTRAINTS;
DROP TABLE AC_OPERSHORTCUT CASCADE CONSTRAINTS;
DROP TABLE AC_OPERATOR CASCADE CONSTRAINTS;
DROP TABLE OM_PARTYROLE CASCADE CONSTRAINTS;
DROP TABLE AC_ROLE CASCADE CONSTRAINTS;
DROP TABLE AC_ROLE CASCADE CONSTRAINTS;
DROP TABLE new_table CASCADE CONSTRAINTS;
DROP TABLE OM_BUSIORG CASCADE CONSTRAINTS;
DROP TABLE OM_GROUPPOSI CASCADE CONSTRAINTS;
DROP TABLE OM_POSITION CASCADE CONSTRAINTS;
DROP TABLE OM_DUTY CASCADE CONSTRAINTS;
DROP TABLE OM_EMPGROUP CASCADE CONSTRAINTS;
DROP TABLE OM_EMPORG CASCADE CONSTRAINTS;
DROP TABLE OM_EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE OM_GROUP CASCADE CONSTRAINTS;
DROP TABLE OM_ORGANIZATION CASCADE CONSTRAINTS;




/* Create Tables */

-- 应用系统注册表
CREATE TABLE AC_APPLICATION
(
	APPID number(10) NOT NULL,
	APPCODE varchar2(10),
	APPNAME varchar2(50),
	APPTYPE varchar2(255),
	ISOPEN char(1),
	OPENDATE date,
	URL varchar2(256),
	APPDESC varchar2(512),
	MAINTENANCE number(10),
	MANAROLE varchar2(64),
	DEMO varchar2(512),
	-- 0:否,1:是
	INIWP char(1),
	-- 0:否,1:是
	INTASKCENTER char(1),
	IPADDR varchar2(50),
	IPPORT varchar2(10),
	PRIMARY KEY (APPID)
);


-- 应用系统注册表
CREATE TABLE AC_APPLICATION
(
	APPID number(10) NOT NULL,
	APPCODE varchar2(10),
	APPNAME varchar2(50),
	APPTYPE varchar2(255),
	ISOPEN char(1),
	OPENDATE date,
	URL varchar2(256),
	APPDESC varchar2(512),
	MAINTENANCE number(10),
	MANAROLE varchar2(64),
	DEMO varchar2(512),
	-- 0:否,1:是
	INIWP char(1),
	-- 0:否,1:是
	INTASKCENTER char(1),
	IPADDR varchar2(50),
	IPPORT varchar2(10),
	PRIMARY KEY (APPID)
);


-- 定义能够操作某个表数据的范围
CREATE TABLE AC_DATASCOPE
(
	PRIVILEGEID number(10) NOT NULL,
	ENTITYID number(10),
	PRIVNAME varchar2(64) NOT NULL,
	-- 增加、修改、删除、查询
	OPTYPE varchar2(20),
	ENTITYNAME varchar2(64),
	-- 例： (orgSEQ IS NULL or orgSEQ like '$[SessionEntity/orgSEQ]%') 
	FILTERSTRING varchar2(1024),
	PRIMARY KEY (PRIVILEGEID)
);


-- 数据实体定义表
CREATE TABLE AC_ENTITY
(
	ENTITYID number(10) NOT NULL,
	APPID number(10),
	ENTITYNAME varchar2(50) NOT NULL,
	TABLENAME varchar2(64) NOT NULL,
	ENTITYDESC varchar2(512),
	DISPLAYORDER number(4) DEFAULT 0 NOT NULL,
	-- 0-表
	-- 1-视图
	-- 2-查询实体
	ENTITYTYPE varchar2(255) DEFAULT '''0''' NOT NULL,
	-- Y/N
	ISADD char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISDEL char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISMODIFY char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISVIEW char(1) DEFAULT '''Y''' NOT NULL,
	-- Y/N
	ISPAGE char(1) DEFAULT '''Y''' NOT NULL,
	PAGELEN number(5),
	CHECK_REF varchar2(1024),
	PRIMARY KEY (ENTITYID)
);


-- 数据实体的字段（属性）定义表
CREATE TABLE AC_ENTITYFIELD
(
	FIELDID number(10) NOT NULL,
	FIELDNAME varchar2(50) NOT NULL,
	ENTITYID number(10) NOT NULL,
	FIELDDESC varchar2(100),
	DISPLAYFORMAT varchar2(64),
	DOCLISTCODE varchar2(20),
	CHECKBOXVALUE varchar2(128),
	FK_INPUTURL varchar2(64),
	FK_FIELDDESC varchar2(64),
	FK_COLUMNNAME varchar2(64),
	FK_TABLENAME varchar2(64),
	DESC_FIELDNAME varchar2(64),
	-- 0 业务字典
	-- 1 其他表
	REFTYPE varchar2(2),
	-- 0 字符串
	-- 1 整数
	-- 2 小数
	-- 3 日期
	-- 4 日期时间
	-- 5 CHECKBOX
	-- 6 引用
	FIELDTYPE varchar2(255) NOT NULL,
	DISPLAYORDER number(4) DEFAULT 0 NOT NULL,
	COLUMNNAME varchar2(64) NOT NULL,
	WIDTH number(4),
	DEFAULTVALUE varchar2(128),
	MINVALUE varchar2(20),
	MAXVALUE varchar2(20),
	LENGTH number(4),
	PRECISION number(4),
	VALIDATETYPE varchar2(64),
	-- Y/N
	ISMODIFY char(1) DEFAULT '''Y''' NOT NULL,
	-- Y/N
	ISDISPLAY char(1) DEFAULT '''Y''' NOT NULL,
	-- Y/N
	ISINPUT char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISPK char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISAUTOKEY char(1) DEFAULT '''N''',
	PRIMARY KEY (FIELDID)
);


-- 角色与实体字段（属性）的对应关系
CREATE TABLE AC_ENTITYFIELDROLE
(
	FIELDID number(10) NOT NULL,
	ROLEID varchar2(64) NOT NULL,
	-- Y/N
	ISMODIFY char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISVIEW char(1) DEFAULT '''Y''' NOT NULL,
	PRIMARY KEY (FIELDID, ROLEID)
);


-- 角色与数据实体的对应关系
CREATE TABLE AC_ENTITYROLE
(
	ENTITYID number(10) NOT NULL,
	ROLEID varchar2(64) NOT NULL,
	-- Y/N
	ISADD char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISDEL char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISMODIFY char(1) DEFAULT '''N''' NOT NULL,
	-- Y/N
	ISVIEW char(1) DEFAULT '''Y''' NOT NULL,
	PRIMARY KEY (ENTITYID, ROLEID)
);


-- 功能组可以理解为功能模块或者构件包，是指一类相关功能的集合。定义功能组主要是为了对系统的功能进行归类管理
-- 功能组隶属于某个应用
-- 
-- 功能组支持层次
CREATE TABLE AC_FUNCGROUP
(
	FUNCGROUPID number(10) NOT NULL,
	APPID number(10) NOT NULL,
	FUNCGROUPNAME varchar2(40),
	PARENTGROUP number(10) NOT NULL,
	GROUPLEVEL number,
	FUNCGROUPSEQ varchar2(256),
	ISLEAF char(1),
	SUBCOUNT number(10),
	PRIMARY KEY (FUNCGROUPID)
);


-- 功能点包含的系统资源内容，如jsp、页面流、逻辑流等资源
CREATE TABLE AC_FUNCRESOURCE
(
	RESID number(10) NOT NULL,
	FUNCCODE varchar2(255),
	-- JSP、页面流、逻辑流等
	RESTYPE varchar2(255),
	RESPATH varchar2(256),
	COMPACKNAME varchar2(40),
	RESNAME varchar2(40),
	PRIMARY KEY (RESID)
);


-- 功能定义表，每个功能属于一个功能点，隶属于某个应用系统，同时也隶属于某个功能组
CREATE TABLE AC_FUNCTION
(
	FUNCCODE varchar2(255) NOT NULL,
	FUNCGROUPID number(10),
	FUNCNAME varchar2(128) NOT NULL,
	FUNCDESC varchar2(512),
	FUNCACTION varchar2(256),
	-- 需要定义参数规范
	PARAINFO varchar2(256),
	ISCHECK char(1),
	-- 前台功能、后台服务、报表功能...
	FUNCTYPE varchar2(255) DEFAULT '''1''',
	-- 该功能是否可以作为菜单入口
	ISMENU char(1),
	PRIMARY KEY (FUNCCODE)
);


-- 操作员对自己的权限进行组合形成一个固定的登录身份
-- 供登录时选项，每一个登录身份是员工操作员的权限子集
CREATE TABLE AC_IDENTITY
(
	IDENTITYID number(10) NOT NULL,
	IDENTITYNAME varchar2(255),
	OPERATORID number(18) NOT NULL,
	IDENTITYFLAG char(1),
	SEQNO number,
	PRIMARY KEY (IDENTITYID)
);


-- 操作员身份对应的权限子集
-- 可配置内容包括 
-- 角色
-- 组织
CREATE TABLE AC_IDENTITYRES
(
	IDENTITYID number(10) NOT NULL,
	-- 角色编号或者组织编号如机构编号，工作组编号
	RESOURCEID varchar2(255) NOT NULL,
	-- 取值范围为字典ABF_RESTYPE
	RESOURCETYPE varchar2(255) NOT NULL,
	PRIMARY KEY (IDENTITYID, RESOURCEID, RESOURCETYPE)
);


-- 应用菜单表
CREATE TABLE AC_MENU
(
	MENUID varchar2(40) NOT NULL,
	MENUNAME varchar2(40) NOT NULL,
	MENULABEL varchar2(40) NOT NULL,
	MENUCODE varchar2(40),
	ISLEAF char(1),
	APPCODE varchar2(10),
	-- 冗余字段
	PARAMETER varchar2(256),
	-- 针对EXT模式提供，例如abf_auth/function/module.xml
	UIENTRY varchar2(256),
	-- 原类型smalint
	MENULEVEL number,
	ROOTID varchar2(40),
	PARENTSID varchar2(40) NOT NULL,
	-- 原类型smalint
	DISPLAYORDER number,
	IMAGEPATH varchar2(100),
	EXPANDPATH varchar2(100),
	MENUSEQ varchar2(256),
	-- 主窗口打开、弹出窗口打开...
	OPENMODE varchar2(255),
	SUBCOUNT number(10),
	APPID number(10),
	FUNCCODE varchar2(255),
	PRIMARY KEY (MENUID)
);


-- 系统登录用户表
CREATE TABLE AC_OPERATOR
(
	OPERATORID number(18) NOT NULL,
	USERID varchar2(64) NOT NULL,
	PASSWORD varchar2(100),
	INVALDATE date,
	OPERATORNAME varchar2(64),
	AUTHMODE varchar2(255),
	STATUS varchar2(255),
	UNLOCKTIME date,
	MENUTYPE varchar2(255),
	LASTLOGIN timestamp,
	ERRCOUNT number(10),
	STARTDATE date,
	ENDDATE date,
	VALIDTIME varchar2(255),
	MACCODE varchar2(128),
	IPADDRESS varchar2(128),
	EMAIL varchar2(255),
	PRIMARY KEY (OPERATORID)
);


-- 系统登录用户表
CREATE TABLE AC_OPERATOR
(
	OPERATORID number(18) NOT NULL,
	USERID varchar2(64) NOT NULL,
	PASSWORD varchar2(100),
	INVALDATE date,
	OPERATORNAME varchar2(64),
	-- 本地密码认证、LDAP认证、等
	AUTHMODE varchar2(255),
	-- 正常，挂起，注销，锁定...
	STATUS varchar2(255),
	-- 当状态为锁定时，解锁的时间
	UNLOCKTIME date,
	-- 用户登录后菜单的风格
	MENUTYPE varchar2(255),
	LASTLOGIN timestamp,
	ERRCOUNT number(10),
	STARTDATE date,
	ENDDATE date,
	-- 定义一个规则表达式，表示允许操作的有效时间范围
	VALIDTIME varchar2(255),
	-- 允许设置多个MAC
	MACCODE varchar2(128),
	-- 允许设置多个IP地址
	IPADDRESS varchar2(128),
	-- 邮箱地址
	EMAIL varchar2(255),
	PRIMARY KEY (OPERATORID)
);


-- 操作员与权限集（角色）对应关系表
CREATE TABLE AC_OPERATORROLE
(
	OPERATORID number(18) NOT NULL,
	ROLEID varchar2(64) NOT NULL,
	-- 预留字段，暂不使用
	AUTH number(255),
	PRIMARY KEY (OPERATORID, ROLEID)
);


-- 操作员个性化配置
-- 如颜色配置
--     登录风格
--     是否使用重组菜单
--     默认身份
--     等
CREATE TABLE AC_OPERCONFIG
(
	OPERATORID number(18) NOT NULL,
	CONFIGNAME varchar2(255) NOT NULL,
	CONFIGVALUE varchar2(255),
	CONFIGTYPE varchar2(255) NOT NULL,
	ISVALID char(1),
	PRIMARY KEY (OPERATORID, CONFIGNAME, CONFIGTYPE)
);


-- 重组菜单
CREATE TABLE AC_OPERCUSTMENU
(
	OPERATORID number(18),
	MENUID varchar2(40) NOT NULL,
	MENUNAME varchar2(40) NOT NULL,
	MENULABEL varchar2(40) NOT NULL,
	FUNCCODE varchar2(255),
	ISLEAF char(1),
	-- 冗余字段
	MENUACTION varchar2(256),
	-- 冗余字段
	PARAMETER varchar2(256),
	-- 针对EXT模式提供，例如abf_auth/function/module.xml
	UIENTRY varchar2(256),
	-- 原类型smallint
	MENULEVEL number,
	ROOTID varchar2(40),
	PARENTSID varchar2(40) NOT NULL,
	-- 原类型smallint
	DISPLAYORDER number,
	IMAGEPATH varchar2(100),
	EXPANDPATH varchar2(100),
	MENUSEQ varchar2(256),
	-- 主窗口打开、弹出窗口打开...
	OPENMODE varchar2(255),
	SUBCOUNT number(10),
	PRIMARY KEY (MENUID)
);


-- 针对人员配置的特殊权限，如特别开通的功能，或者特别禁止的功能
CREATE TABLE AC_OPERFUNC
(
	OPERATORID number(18) NOT NULL,
	FUNCCODE varchar2(255) NOT NULL,
	-- 1：特别开通，2：特别禁止
	AUTHTYPE varchar2(255) NOT NULL,
	-- 冗余字段
	APPID number(10) NOT NULL,
	-- 冗余字段
	FUNCGROUPID number(10) NOT NULL,
	STARTDATE date,
	ENDDATE date,
	PRIMARY KEY (OPERATORID, FUNCCODE, AUTHTYPE)
);


-- 用户自定义的快捷菜单
CREATE TABLE AC_OPERSHORTCUT
(
	OPERATORID number(18) NOT NULL,
	FUNCCODE varchar2(255) NOT NULL,
	-- 冗余字段
	APPID number(10) NOT NULL,
	-- 冗余字段
	FUNCGROUPID number(10),
	-- 原类型smallint
	ORDERNO number NOT NULL,
	IMAGEPATH varchar2(128),
	PRIMARY KEY (OPERATORID, FUNCCODE)
);


-- 权限集（角色）定义表
CREATE TABLE AC_ROLE
(
	ROLEID varchar2(64) NOT NULL,
	ROLENAME varchar2(64),
	-- 全局型角色、应用级角色
	ROLETYPE varchar2(255),
	ROLEDESC varchar2(256),
	PRIMARY KEY (ROLEID)
);


-- 权限集（角色）定义表
CREATE TABLE AC_ROLE
(
	ROLEID varchar2(64) NOT NULL,
	ROLENAME varchar2(64),
	ROLETYPE varchar2(255),
	ROLEDESC varchar2(256),
	APPID number(10),
	PRIMARY KEY (ROLEID)
);


-- 配置角色具有的数据权限
CREATE TABLE AC_ROLEDATAPRIV
(
	ROLEID varchar2(64) NOT NULL,
	PRIVILEGEID number(10) NOT NULL,
	PRIMARY KEY (ROLEID, PRIVILEGEID)
);


-- 角色所包含的功能清单
CREATE TABLE AC_ROLEFUNC
(
	ROLEID varchar2(64) NOT NULL,
	FUNCCODE varchar2(255) NOT NULL,
	-- 冗余字段
	APPID number(10) NOT NULL,
	-- 冗余字段
	FUNCGROUPID number(10) NOT NULL,
	PRIMARY KEY (ROLEID, FUNCCODE)
);


-- 定义人员和岗位的对应关系，需要注明，一个人员可以设定一个基本岗位
CREATE TABLE new_table
(
	EMPID number(10) NOT NULL,
	EMPID number(10) NOT NULL,
	ISMAIN char(1),
	PRIMARY KEY (EMPID, EMPID)
);


-- 应用包含的工作组列表
CREATE TABLE OM_APPGROUP
(
	APPID number(10) NOT NULL,
	GROUPID number(10) NOT NULL,
	PRIMARY KEY (APPID)
);


-- 应用包含的岗位列表信息
CREATE TABLE OM_APPPOSI
(
	APPID number(10) NOT NULL,
	EMPID number(10),
	PRIMARY KEY (APPID)
);


-- 比如审计条线，在总行有审计部，各分行也有审计部，总行审计部是审计条线的主管部门
-- 
-- 允许添加虚拟节点
CREATE TABLE OM_BUSIORG
(
	-- 取值范围业务子弹ABF_BUSIDOMAIN
	BUSIDOMAIN varchar2(255) NOT NULL,
	BUSIORGID number(10) NOT NULL,
	ORGNAME varchar2(64),
	PARENTID number(10),
	ORGLEVEL number,
	ORGID number(10),
	OM__BUSIORGID number(10) NOT NULL,
	-- 业务字典ABF_NODETYPE
	-- 虚拟节点，机构节点，如果是机构节点，则对应机构信息表的一个机构
	NODETYPE varchar2(255),
	ORGCODE varchar2(32),
	SEQNO varchar2(256),
	MANAPOS number(10),
	SORTNO number,
	ISLEAF char(1),
	SUBCOUNT number(10),
	PRIMARY KEY (BUSIORGID)
);


-- 定义职务及上下级关系
CREATE TABLE OM_DUTY
(
	DUTYID number(10) NOT NULL,
	DUTYCODE varchar2(20),
	DUTYNAME varchar2(30),
	PARENTDUTY number(10) NOT NULL,
	DUTYLEVEL number,
	DUTYSEQ varchar2(256),
	-- 例如科技类，审计类等
	DUTYTYPE varchar2(255),
	ISLEAF char(10),
	SUBCOUNT number(10),
	REMARK varchar2(256),
	PRIMARY KEY (DUTYID)
);


-- 定义工作组包含的人员
CREATE TABLE OM_EMPGROUP
(
	GROUPID number(10) NOT NULL,
	EMPID number(10) NOT NULL,
	PRIMARY KEY (GROUPID)
);


-- 人员信息表
CREATE TABLE OM_EMPLOYEE
(
	EMPID number(10) NOT NULL,
	EMPCODE varchar2(30),
	OPERATORID number(10),
	USERID varchar2(30),
	EMPNAME varchar2(50),
	REALNAME varchar2(50),
	GENDER varchar2(255),
	BIRTHDATE date,
	POSITION number(10),
	EMPSTATUS varchar2(255),
	CARDTYPE varchar2(255),
	CARDNO varchar2(20),
	INDATE date,
	OUTDATE date,
	OTEL varchar2(12),
	OADDRESS varchar2(255),
	OZIPCODE varchar2(10),
	OEMAIL varchar2(128),
	FAXNO varchar2(14),
	MOBILENO varchar2(14),
	MSN varchar2(16),
	HTEL varchar2(12),
	HADDRESS varchar2(128),
	HZIPCODE varchar2(10),
	PEMAIL varchar2(128),
	PARTY varchar2(255),
	DEGREE varchar2(255),
	MAJOR number(10),
	SPECIALTY varchar2(1024),
	WORKEXP varchar2(512),
	REGDATE date,
	CREATETIME timestamp,
	LASTMODYTIME date,
	ORGIDLIST varchar2(128),
	ORGID number(10),
	REMARK varchar2(512),
	PRIMARY KEY (EMPID)
);


-- 定义人员和机构的关系表
CREATE TABLE OM_EMPORG
(
	ORGID number(10) NOT NULL,
	EMPID number(10) NOT NULL,
	ISMAIN char(1),
	PRIMARY KEY (ORGID, EMPID)
);


-- 工作组定义表，用于定义临时组、虚拟组，跨部门的项目组等
CREATE TABLE OM_GROUP
(
	GROUPID number(10) NOT NULL,
	ORGID number(10),
	PARENTGROUPID number(10) NOT NULL,
	GROUPLEVEL number,
	GROUPNAME varchar2(50),
	GROUPDESC varchar2(512),
	GROUPTYPE varchar2(255),
	GROUPSEQ varchar2(256),
	STARTDATE date,
	ENDDATE date,
	GROUPSTATUS varchar2(255),
	MANAGER varchar2(30),
	CREATETIME timestamp,
	LASTUPDATE date,
	UPDATOR number(10),
	ISLEAF char(1),
	SUBCOUNT number(10),
	PRIMARY KEY (GROUPID)
);


-- 工作组岗位列表:一个工作组允许定义多个岗位，岗位之间允许存在层次关系
CREATE TABLE OM_GROUPPOSI
(
	GROUPID number(10) NOT NULL,
	EMPID number(10) NOT NULL,
	PRIMARY KEY (GROUPID)
);


-- 机构部门表
-- 允许定义多个平行机构
CREATE TABLE OM_ORGANIZATION
(
	ORGID number(10) NOT NULL,
	ORGCODE varchar2(32) NOT NULL,
	ORGNAME varchar2(64),
	ORGLEVEL number(2) DEFAULT 1,
	-- 总行，分行，海外分行...
	ORGDEGREE nvarchar2(255),
	PARENTORGID number(10) NOT NULL,
	ORGSEQ varchar2(512),
	-- 总公司/总部部门/分公司/分公司部门...
	ORGTYPE varchar2(12),
	ORGADDR varchar2(256),
	ZIPCODE varchar2(10),
	MANAPOSITION number(10),
	MANAGERID number(10),
	-- 机构管理员能够给本机构的人员进行授权，多个机构管理员之间用,分隔
	ORGMANAGER varchar2(128),
	LINKMAN varchar2(30),
	LINKTEL varchar2(20),
	EMAIL varchar2(128),
	WEBURL varchar2(512),
	STARTDATE date,
	ENDDATE date,
	STATUS varchar2(255),
	AREA varchar2(30),
	CREATETIME timestamp,
	LASTUPDATE date,
	UPDATOR number(10),
	SORTNO number,
	ISLEAF char(1),
	SUBCOUNT number(10),
	REMARK varchar2(512),
	PRIMARY KEY (ORGID)
);


-- 设置机构、工作组、岗位、职务等组织对象与角色之间的对应关系
CREATE TABLE OM_PARTYROLE
(
	ROLEID varchar2(64) NOT NULL,
	-- 取值范围业务字典 ABF_PARTYTYPE
	-- 机构、工作组、岗位、职务
	PARTYTYPE varchar2(255) NOT NULL,
	PARTYID number(10) NOT NULL,
	PRIMARY KEY (ROLEID)
);


-- 岗位定义表
CREATE TABLE OM_POSITION
(
	EMPID number(10) NOT NULL,
	POSICODE varchar2(20),
	POSINAME varchar2(128) NOT NULL,
	POSILEVEL number(2),
	MANAPOSI number(10) NOT NULL,
	DUTYID number(10),
	ORGID number(10),
	POSITIONSEQ varchar2(512) NOT NULL,
	POSITYPE varchar2(255),
	CREATETIME timestamp,
	LASTUPDATE date,
	UPDATOR number(10),
	STARTDATE date,
	ENDDATE date,
	STATUS varchar2(255),
	ISLEAF char(1),
	SUBCOUNT number(10),
	PRIMARY KEY (EMPID)
);



/* Create Foreign Keys */

ALTER TABLE OM_APPGROUP
	ADD CONSTRAINT F_APP_GROUP FOREIGN KEY (APPID)
	REFERENCES AC_APPLICATION (APPID)
;


ALTER TABLE OM_APPPOSI
	ADD CONSTRAINT F_APP_POS FOREIGN KEY (APPID)
	REFERENCES AC_APPLICATION (APPID)
;


ALTER TABLE AC_ENTITY
	ADD CONSTRAINT F_APP_ENTITY FOREIGN KEY (ENTITYID)
	REFERENCES AC_APPLICATION (APPID)
;


ALTER TABLE AC_FUNCGROUP
	ADD CONSTRAINT F_APP_FUNCTION FOREIGN KEY (APPID)
	REFERENCES AC_APPLICATION (APPID)
;


ALTER TABLE AC_ROLEDATAPRIV
	ADD CONSTRAINT F_DATA_ROLE FOREIGN KEY (PRIVILEGEID)
	REFERENCES AC_DATASCOPE (PRIVILEGEID)
;


ALTER TABLE AC_DATASCOPE
	ADD CONSTRAINT F_ENTITY_DATA FOREIGN KEY (ENTITYID)
	REFERENCES AC_ENTITY (ENTITYID)
;


ALTER TABLE AC_ENTITYFIELD
	ADD CONSTRAINT F_ENTITY_FILED FOREIGN KEY (ENTITYID)
	REFERENCES AC_ENTITY (ENTITYID)
;


ALTER TABLE AC_ENTITYROLE
	ADD CONSTRAINT F_ENTITY_ROLE FOREIGN KEY (ENTITYID)
	REFERENCES AC_ENTITY (ENTITYID)
;


ALTER TABLE AC_ENTITYFIELDROLE
	ADD CONSTRAINT F_FIELD_ROLE FOREIGN KEY (FIELDID)
	REFERENCES AC_ENTITYFIELD (FIELDID)
;


ALTER TABLE AC_FUNCGROUP
	ADD CONSTRAINT F_FUNG_FUNG FOREIGN KEY (PARENTGROUP)
	REFERENCES AC_FUNCGROUP (FUNCGROUPID)
;


ALTER TABLE AC_FUNCTION
	ADD CONSTRAINT F_FUNGROUP_FUN FOREIGN KEY (FUNCGROUPID)
	REFERENCES AC_FUNCGROUP (FUNCGROUPID)
;


ALTER TABLE AC_FUNCRESOURCE
	ADD CONSTRAINT F_FUN_RES FOREIGN KEY (FUNCCODE)
	REFERENCES AC_FUNCTION (FUNCCODE)
;


ALTER TABLE AC_OPERFUNC
	ADD CONSTRAINT F_FUN_OPER FOREIGN KEY (FUNCCODE)
	REFERENCES AC_FUNCTION (FUNCCODE)
;


ALTER TABLE AC_ROLEFUNC
	ADD CONSTRAINT F_FUN_ROLE FOREIGN KEY (FUNCCODE)
	REFERENCES AC_FUNCTION (FUNCCODE)
;


ALTER TABLE AC_IDENTITYRES
	ADD CONSTRAINT F_STATUS_FUN FOREIGN KEY (IDENTITYID)
	REFERENCES AC_IDENTITY (IDENTITYID)
;


ALTER TABLE AC_MENU
	ADD FOREIGN KEY (PARENTSID)
	REFERENCES AC_MENU (MENUID)
;


ALTER TABLE AC_IDENTITY
	ADD CONSTRAINT F_OPER_STATUS FOREIGN KEY (OPERATORID)
	REFERENCES AC_OPERATOR (OPERATORID)
;


ALTER TABLE AC_OPERATORROLE
	ADD CONSTRAINT F_OPER_ROLE FOREIGN KEY (OPERATORID)
	REFERENCES AC_OPERATOR (OPERATORID)
;


ALTER TABLE AC_OPERCONFIG
	ADD CONSTRAINT F_OPER_CONF FOREIGN KEY (OPERATORID)
	REFERENCES AC_OPERATOR (OPERATORID)
;


ALTER TABLE AC_OPERCUSTMENU
	ADD CONSTRAINT F_OPER_RMENU FOREIGN KEY (OPERATORID)
	REFERENCES AC_OPERATOR (OPERATORID)
;


ALTER TABLE AC_OPERFUNC
	ADD CONSTRAINT F_OPER_FUN FOREIGN KEY (OPERATORID)
	REFERENCES AC_OPERATOR (OPERATORID)
;


ALTER TABLE AC_OPERSHORTCUT
	ADD CONSTRAINT F_OPER_QMENU FOREIGN KEY (OPERATORID)
	REFERENCES AC_OPERATOR (OPERATORID)
;


ALTER TABLE AC_OPERCUSTMENU
	ADD CONSTRAINT F_ROM_ROM FOREIGN KEY (PARENTSID)
	REFERENCES AC_OPERCUSTMENU (MENUID)
;


ALTER TABLE OM_PARTYROLE
	ADD CONSTRAINT F_APP_ROLE FOREIGN KEY (ROLEID)
	REFERENCES AC_ROLE (ROLEID)
;


ALTER TABLE AC_ENTITYFIELDROLE
	ADD CONSTRAINT F_ROLENTY_ROLE FOREIGN KEY (ROLEID)
	REFERENCES AC_ROLE (ROLEID)
;


ALTER TABLE AC_ENTITYROLE
	ADD CONSTRAINT F_ROLE_ENTITY FOREIGN KEY (ROLEID)
	REFERENCES AC_ROLE (ROLEID)
;


ALTER TABLE AC_OPERATORROLE
	ADD CONSTRAINT F_ROLE_OPER FOREIGN KEY (ROLEID)
	REFERENCES AC_ROLE (ROLEID)
;


ALTER TABLE AC_ROLEDATAPRIV
	ADD CONSTRAINT F_ROLE_DATA FOREIGN KEY (ROLEID)
	REFERENCES AC_ROLE (ROLEID)
;


ALTER TABLE AC_ROLEFUNC
	ADD CONSTRAINT F_ROLE_FUN FOREIGN KEY (ROLEID)
	REFERENCES AC_ROLE (ROLEID)
;


ALTER TABLE OM_BUSIORG
	ADD CONSTRAINT F_BORG_BORG FOREIGN KEY (OM__BUSIORGID)
	REFERENCES OM_BUSIORG (BUSIORGID)
;


ALTER TABLE OM_DUTY
	ADD CONSTRAINT F_DUTY_DUTY FOREIGN KEY (PARENTDUTY)
	REFERENCES OM_DUTY (DUTYID)
;


ALTER TABLE OM_POSITION
	ADD CONSTRAINT F_DUTY_POS FOREIGN KEY (DUTYID)
	REFERENCES OM_DUTY (DUTYID)
;


ALTER TABLE new_table
	ADD CONSTRAINT F_EMP_POS FOREIGN KEY (EMPID)
	REFERENCES OM_EMPLOYEE (EMPID)
;


ALTER TABLE OM_EMPGROUP
	ADD CONSTRAINT F_EMP_GROUP FOREIGN KEY (EMPID)
	REFERENCES OM_EMPLOYEE (EMPID)
;


ALTER TABLE OM_EMPORG
	ADD FOREIGN KEY (EMPID)
	REFERENCES OM_EMPLOYEE (EMPID)
;


ALTER TABLE OM_APPGROUP
	ADD CONSTRAINT F_GROUP_APP FOREIGN KEY (GROUPID)
	REFERENCES OM_GROUP (GROUPID)
;


ALTER TABLE OM_EMPGROUP
	ADD FOREIGN KEY (GROUPID)
	REFERENCES OM_GROUP (GROUPID)
;


ALTER TABLE OM_GROUP
	ADD CONSTRAINT F_GROUP_GROUP FOREIGN KEY (PARENTGROUPID)
	REFERENCES OM_GROUP (GROUPID)
;


ALTER TABLE OM_GROUPPOSI
	ADD CONSTRAINT F_GROUP_POS FOREIGN KEY (GROUPID)
	REFERENCES OM_GROUP (GROUPID)
;


ALTER TABLE OM_BUSIORG
	ADD CONSTRAINT F_BIZ_ORG FOREIGN KEY (ORGID)
	REFERENCES OM_ORGANIZATION (ORGID)
;


ALTER TABLE OM_GROUP
	ADD CONSTRAINT F_ORG_GROUP FOREIGN KEY (ORGID)
	REFERENCES OM_ORGANIZATION (ORGID)
;


ALTER TABLE OM_ORGANIZATION
	ADD CONSTRAINT F_ORG_ORG FOREIGN KEY (PARENTORGID)
	REFERENCES OM_ORGANIZATION (ORGID)
;


ALTER TABLE OM_POSITION
	ADD CONSTRAINT F_ORG_POS FOREIGN KEY (ORGID)
	REFERENCES OM_ORGANIZATION (ORGID)
;


ALTER TABLE new_table
	ADD CONSTRAINT F_POS_EMP FOREIGN KEY (EMPID)
	REFERENCES OM_POSITION (EMPID)
;


ALTER TABLE OM_APPPOSI
	ADD FOREIGN KEY (EMPID)
	REFERENCES OM_POSITION (EMPID)
;


ALTER TABLE OM_GROUPPOSI
	ADD FOREIGN KEY (EMPID)
	REFERENCES OM_POSITION (EMPID)
;


ALTER TABLE OM_POSITION
	ADD CONSTRAINT F_POS_POS FOREIGN KEY (MANAPOSI)
	REFERENCES OM_POSITION (EMPID)
;



/* Comments */

COMMENT ON TABLE AC_APPLICATION IS '应用系统注册表';
COMMENT ON COLUMN AC_APPLICATION.INIWP IS '0:否,1:是';
COMMENT ON COLUMN AC_APPLICATION.INTASKCENTER IS '0:否,1:是';
COMMENT ON TABLE AC_APPLICATION IS '应用系统注册表';
COMMENT ON COLUMN AC_APPLICATION.INIWP IS '0:否,1:是';
COMMENT ON COLUMN AC_APPLICATION.INTASKCENTER IS '0:否,1:是';
COMMENT ON TABLE AC_DATASCOPE IS '定义能够操作某个表数据的范围';
COMMENT ON COLUMN AC_DATASCOPE.OPTYPE IS '增加、修改、删除、查询';
COMMENT ON COLUMN AC_DATASCOPE.FILTERSTRING IS '例： (orgSEQ IS NULL or orgSEQ like ''$[SessionEntity/orgSEQ]%'') ';
COMMENT ON TABLE AC_ENTITY IS '数据实体定义表';
COMMENT ON COLUMN AC_ENTITY.ENTITYTYPE IS '0-表
1-视图
2-查询实体';
COMMENT ON COLUMN AC_ENTITY.ISADD IS 'Y/N';
COMMENT ON COLUMN AC_ENTITY.ISDEL IS 'Y/N';
COMMENT ON COLUMN AC_ENTITY.ISMODIFY IS 'Y/N';
COMMENT ON COLUMN AC_ENTITY.ISVIEW IS 'Y/N';
COMMENT ON COLUMN AC_ENTITY.ISPAGE IS 'Y/N';
COMMENT ON TABLE AC_ENTITYFIELD IS '数据实体的字段（属性）定义表';
COMMENT ON COLUMN AC_ENTITYFIELD.REFTYPE IS '0 业务字典
1 其他表';
COMMENT ON COLUMN AC_ENTITYFIELD.FIELDTYPE IS '0 字符串
1 整数
2 小数
3 日期
4 日期时间
5 CHECKBOX
6 引用';
COMMENT ON COLUMN AC_ENTITYFIELD.ISMODIFY IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYFIELD.ISDISPLAY IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYFIELD.ISINPUT IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYFIELD.ISPK IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYFIELD.ISAUTOKEY IS 'Y/N';
COMMENT ON TABLE AC_ENTITYFIELDROLE IS '角色与实体字段（属性）的对应关系';
COMMENT ON COLUMN AC_ENTITYFIELDROLE.ISMODIFY IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYFIELDROLE.ISVIEW IS 'Y/N';
COMMENT ON TABLE AC_ENTITYROLE IS '角色与数据实体的对应关系';
COMMENT ON COLUMN AC_ENTITYROLE.ISADD IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYROLE.ISDEL IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYROLE.ISMODIFY IS 'Y/N';
COMMENT ON COLUMN AC_ENTITYROLE.ISVIEW IS 'Y/N';
COMMENT ON TABLE AC_FUNCGROUP IS '功能组可以理解为功能模块或者构件包，是指一类相关功能的集合。定义功能组主要是为了对系统的功能进行归类管理
功能组隶属于某个应用

功能组支持层次';
COMMENT ON TABLE AC_FUNCRESOURCE IS '功能点包含的系统资源内容，如jsp、页面流、逻辑流等资源';
COMMENT ON COLUMN AC_FUNCRESOURCE.RESTYPE IS 'JSP、页面流、逻辑流等';
COMMENT ON TABLE AC_FUNCTION IS '功能定义表，每个功能属于一个功能点，隶属于某个应用系统，同时也隶属于某个功能组';
COMMENT ON COLUMN AC_FUNCTION.PARAINFO IS '需要定义参数规范';
COMMENT ON COLUMN AC_FUNCTION.FUNCTYPE IS '前台功能、后台服务、报表功能...';
COMMENT ON COLUMN AC_FUNCTION.ISMENU IS '该功能是否可以作为菜单入口';
COMMENT ON TABLE AC_IDENTITY IS '操作员对自己的权限进行组合形成一个固定的登录身份
供登录时选项，每一个登录身份是员工操作员的权限子集';
COMMENT ON TABLE AC_IDENTITYRES IS '操作员身份对应的权限子集
可配置内容包括 
角色
组织';
COMMENT ON COLUMN AC_IDENTITYRES.RESOURCEID IS '角色编号或者组织编号如机构编号，工作组编号';
COMMENT ON COLUMN AC_IDENTITYRES.RESOURCETYPE IS '取值范围为字典ABF_RESTYPE';
COMMENT ON TABLE AC_MENU IS '应用菜单表';
COMMENT ON COLUMN AC_MENU.PARAMETER IS '冗余字段';
COMMENT ON COLUMN AC_MENU.UIENTRY IS '针对EXT模式提供，例如abf_auth/function/module.xml';
COMMENT ON COLUMN AC_MENU.MENULEVEL IS '原类型smalint';
COMMENT ON COLUMN AC_MENU.DISPLAYORDER IS '原类型smalint';
COMMENT ON COLUMN AC_MENU.OPENMODE IS '主窗口打开、弹出窗口打开...';
COMMENT ON TABLE AC_OPERATOR IS '系统登录用户表';
COMMENT ON TABLE AC_OPERATOR IS '系统登录用户表';
COMMENT ON COLUMN AC_OPERATOR.AUTHMODE IS '本地密码认证、LDAP认证、等';
COMMENT ON COLUMN AC_OPERATOR.STATUS IS '正常，挂起，注销，锁定...';
COMMENT ON COLUMN AC_OPERATOR.UNLOCKTIME IS '当状态为锁定时，解锁的时间';
COMMENT ON COLUMN AC_OPERATOR.MENUTYPE IS '用户登录后菜单的风格';
COMMENT ON COLUMN AC_OPERATOR.VALIDTIME IS '定义一个规则表达式，表示允许操作的有效时间范围';
COMMENT ON COLUMN AC_OPERATOR.MACCODE IS '允许设置多个MAC';
COMMENT ON COLUMN AC_OPERATOR.IPADDRESS IS '允许设置多个IP地址';
COMMENT ON COLUMN AC_OPERATOR.EMAIL IS '邮箱地址';
COMMENT ON TABLE AC_OPERATORROLE IS '操作员与权限集（角色）对应关系表';
COMMENT ON COLUMN AC_OPERATORROLE.AUTH IS '预留字段，暂不使用';
COMMENT ON TABLE AC_OPERCONFIG IS '操作员个性化配置
如颜色配置
    登录风格
    是否使用重组菜单
    默认身份
    等';
COMMENT ON TABLE AC_OPERCUSTMENU IS '重组菜单';
COMMENT ON COLUMN AC_OPERCUSTMENU.MENUACTION IS '冗余字段';
COMMENT ON COLUMN AC_OPERCUSTMENU.PARAMETER IS '冗余字段';
COMMENT ON COLUMN AC_OPERCUSTMENU.UIENTRY IS '针对EXT模式提供，例如abf_auth/function/module.xml';
COMMENT ON COLUMN AC_OPERCUSTMENU.MENULEVEL IS '原类型smallint';
COMMENT ON COLUMN AC_OPERCUSTMENU.DISPLAYORDER IS '原类型smallint';
COMMENT ON COLUMN AC_OPERCUSTMENU.OPENMODE IS '主窗口打开、弹出窗口打开...';
COMMENT ON TABLE AC_OPERFUNC IS '针对人员配置的特殊权限，如特别开通的功能，或者特别禁止的功能';
COMMENT ON COLUMN AC_OPERFUNC.AUTHTYPE IS '1：特别开通，2：特别禁止';
COMMENT ON COLUMN AC_OPERFUNC.APPID IS '冗余字段';
COMMENT ON COLUMN AC_OPERFUNC.FUNCGROUPID IS '冗余字段';
COMMENT ON TABLE AC_OPERSHORTCUT IS '用户自定义的快捷菜单';
COMMENT ON COLUMN AC_OPERSHORTCUT.APPID IS '冗余字段';
COMMENT ON COLUMN AC_OPERSHORTCUT.FUNCGROUPID IS '冗余字段';
COMMENT ON COLUMN AC_OPERSHORTCUT.ORDERNO IS '原类型smallint';
COMMENT ON TABLE AC_ROLE IS '权限集（角色）定义表';
COMMENT ON COLUMN AC_ROLE.ROLETYPE IS '全局型角色、应用级角色';
COMMENT ON TABLE AC_ROLE IS '权限集（角色）定义表';
COMMENT ON TABLE AC_ROLEDATAPRIV IS '配置角色具有的数据权限';
COMMENT ON TABLE AC_ROLEFUNC IS '角色所包含的功能清单';
COMMENT ON COLUMN AC_ROLEFUNC.APPID IS '冗余字段';
COMMENT ON COLUMN AC_ROLEFUNC.FUNCGROUPID IS '冗余字段';
COMMENT ON TABLE new_table IS '定义人员和岗位的对应关系，需要注明，一个人员可以设定一个基本岗位';
COMMENT ON TABLE OM_APPGROUP IS '应用包含的工作组列表';
COMMENT ON TABLE OM_APPPOSI IS '应用包含的岗位列表信息';
COMMENT ON TABLE OM_BUSIORG IS '比如审计条线，在总行有审计部，各分行也有审计部，总行审计部是审计条线的主管部门

允许添加虚拟节点';
COMMENT ON COLUMN OM_BUSIORG.BUSIDOMAIN IS '取值范围业务子弹ABF_BUSIDOMAIN';
COMMENT ON COLUMN OM_BUSIORG.NODETYPE IS '业务字典ABF_NODETYPE
虚拟节点，机构节点，如果是机构节点，则对应机构信息表的一个机构';
COMMENT ON TABLE OM_DUTY IS '定义职务及上下级关系';
COMMENT ON COLUMN OM_DUTY.DUTYTYPE IS '例如科技类，审计类等';
COMMENT ON TABLE OM_EMPGROUP IS '定义工作组包含的人员';
COMMENT ON TABLE OM_EMPLOYEE IS '人员信息表';
COMMENT ON TABLE OM_EMPORG IS '定义人员和机构的关系表';
COMMENT ON TABLE OM_GROUP IS '工作组定义表，用于定义临时组、虚拟组，跨部门的项目组等';
COMMENT ON TABLE OM_GROUPPOSI IS '工作组岗位列表:一个工作组允许定义多个岗位，岗位之间允许存在层次关系';
COMMENT ON TABLE OM_ORGANIZATION IS '机构部门表
允许定义多个平行机构';
COMMENT ON COLUMN OM_ORGANIZATION.ORGDEGREE IS '总行，分行，海外分行...';
COMMENT ON COLUMN OM_ORGANIZATION.ORGTYPE IS '总公司/总部部门/分公司/分公司部门...';
COMMENT ON COLUMN OM_ORGANIZATION.ORGMANAGER IS '机构管理员能够给本机构的人员进行授权，多个机构管理员之间用,分隔';
COMMENT ON TABLE OM_PARTYROLE IS '设置机构、工作组、岗位、职务等组织对象与角色之间的对应关系';
COMMENT ON COLUMN OM_PARTYROLE.PARTYTYPE IS '取值范围业务字典 ABF_PARTYTYPE
机构、工作组、岗位、职务';
COMMENT ON TABLE OM_POSITION IS '岗位定义表';



