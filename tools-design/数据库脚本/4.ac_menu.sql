﻿/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-09-12 14:31:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- ----------------------------
INSERT INTO `ac_menu` VALUES ('MENU1502333254', 'APP1500799366', null, '测试12', '测试123', 'cs123', 'N', '21', '1', null, null, '0', '123', '123', 'MENU1502333254', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953640', 'APP1499956132', null, 'ABF应用管理', 'ABF应用管理', 'Menu001', 'N', '', '0', null, 'MENU1502953640', '0', 'fa fa-cubes', 'fa fa-cubes', 'MENU1502953640', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953641', 'APP1499956132', null, '组织机构管理', '组织机构管理', 'Menu01', 'N', null, '0', 'MENU1502953640', 'MENU1502953640', '0', 'fa fa-university', 'fa fa-university', 'MENU1502953640.MENU1502953641', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953642', 'APP1499956132', null, '权限管理', '权限管理', 'Menu02', 'N', null, '0', 'MENU1502953640', 'MENU1502953640', '1', 'fa fa-lock', 'fa fa-lock', 'MENU1502953640.MENU1502953642', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953643', 'APP1499956132', null, '操作员管理', '操作员管理', 'Menu03', 'N', null, '0', 'MENU1502953640', 'MENU1502953640', '2', 'icon-user', 'icon-user', 'MENU1502953640.MENU1502953643', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953644', 'APP1499956132', null, '其他管理', '其他管理', 'Menu05', 'N', null, '0', 'MENU1502953640', 'MENU1502953640', '4', 'fa fa-asterisk', 'fa fa-asterisk', 'MENU1502953640.MENU1502953644', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953646', 'APP1499956132', 'FUNC1500601486', '组织机构', '组织机构', 'Menu011', 'Y', 'abftree.html', '0', 'MENU1502953641', 'MENU1502953640', '0', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953641.MENU1502953646', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953647', 'APP1499956132', 'FUNC1500601487', '员工管理', '员工管理', 'menu012', 'Y', 'Emp.html', '0', 'MENU1502953641', 'MENU1502953640', '1', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953641.MENU1502953647', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953648', 'APP1499956132', 'FUNC1500601488', '业务机构', '业务机构', 'Menu013', 'Y', 'busiorg.html', '0', 'MENU1502953641', 'MENU1502953640', '2', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953641.MENU1502953648', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953649', 'APP1499956132', 'FUNC1500601505', '工作组', '工作组', 'Menu014', 'Y', 'Workgroup.html', '0', 'MENU1502953641', 'MENU1502953640', '3', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953641.MENU1502953649', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953650', 'APP1499956132', 'FUNC1500601528', '职务定义', '职务定义', 'Menu015', 'Y', 'duty.html', '0', 'MENU1503438532', 'MENU1502953640', '1', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1503438532.MENU1502953650', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953651', 'APP1499956132', 'FUNC1500601529', '应用功能管理', '应用功能管理', 'Menu021', 'Y', 'applicationFun.html', '0', 'MENU1502953642', 'MENU1502953640', '0', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953642.MENU1502953651', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953652', 'APP1499956132', 'FUNC1500601530', '菜单管理', '菜单管理', 'Menu022', 'Y', 'menuManagement.html', '0', 'MENU1502953642', 'MENU1502953640', '1', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953642.MENU1502953652', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953653', 'APP1499956132', 'FUNC1500601531', '数据形体管理', '数据形体管理', 'Menu023', 'Y', null, '0', 'MENU1502953642', 'MENU1502953640', '2', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953642.MENU1502953653', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953654', 'APP1499956132', 'FUNC1500601532', '数据范围管理', '数据范围管理', 'Menu024', 'Y', null, '0', 'MENU1502953642', 'MENU1502953640', '3', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953642.MENU1502953654', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953655', 'APP1499956132', 'FUNC1500601534', '功能行为类型定义', '功能行为类型定义', 'Menu025', 'Y', 'behavior.html', '0', 'MENU1503438532', 'MENU1502953640', '2', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1503438532.MENU1502953655', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953656', 'APP1499956132', 'FUNC1500601535', '角色管理', '角色管理', '角色管理', 'Y', 'roleManagement.html', '0', 'MENU1502953642', 'MENU1502953640', '4', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953642.MENU1502953656', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953657', 'APP1499956132', 'FUNC1500601536', '操作员管理', '操作员管理', 'Menu031', 'Y', 'opManage.html', '0', 'MENU1502953643', 'MENU1502953640', '0', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953643.MENU1502953657', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953658', 'APP1499956132', 'FUNC1500601537', '重组菜单', '重组菜单', 'Menu032', 'Y', 'Reorganizemenu.html', '0', 'MENU1502953643', 'MENU1502953640', '1', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953643.MENU1502953658', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953660', 'APP1499956132', 'FUNC1500601539', '操作员身份', '操作员身份', 'Menu034', 'Y', 'operstatus.html', '0', 'MENU1502953643', 'MENU1502953640', '2', 'icon-puzzle', 'icon-puzzle', 'MENU1502953640.MENU1502953643.MENU1502953660', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953661', 'APP1499956132', 'FUNC1500601540', '业务字典', '业务字典', 'Menu041', 'Y', 'dictionary.html', '0', 'MENU1503438532', 'MENU1502953640', '0', 'fa fa-fax', 'fa fa-fax', 'MENU1502953640.MENU1503438532.MENU1502953661', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953662', 'APP1499956132', 'FUNC1500601543', '序号资源表管理', '序号资源表管理', 'Menu042', 'Y', 'numberResources.html', '0', 'MENU1502953644', 'MENU1502953640', '0', 'fa fa-fax', 'fa fa-fax', 'MENU1502953640.MENU1502953644.MENU1502953662', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1502953663', 'APP1499956132', 'FUNC1502354964', '系统运行参数', '系统运行参数', 'Menu043', 'Y', 'Systempara.html', '0', 'MENU1502953644', 'MENU1502953640', '1', 'fa fa-fax', 'fa fa-fax', 'MENU1502953640.MENU1502953644.MENU1502953663', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1503438532', 'APP1499956132', null, '基础数据', '基础数据', 'Menu04', 'N', null, '0', 'MENU1502953640', 'MENU1502953640', '3', 'icon-user', 'icon-user', 'MENU1502953640.MENU1503438532', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1504577391', 'APP1499956132', null, '运行管理', '运行管理', 'Menuyun', 'N', null, '0', 'MENU1502953640', 'MENU1502953640', '5', 'fa fa-lg fa-tasks', 'fa fa-lg fa-spinner', 'MENU1502953640.MENU1504577391', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1504577392', 'APP1499956132', 'FUNC1504581747', '定时器', '定时器', 'Menutimer', 'Y', 'transtimeer.html', '0', 'MENU1504577391', 'MENU1502953640', '0', 'fa fa-lg fa-bell-o', 'fa fa-lg fa-clock-o', 'MENU1502953640.MENU1504577391.MENU1504577392', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1504889259', 'APP1502700977', null, 'nlknkl', '11313', '1313', 'N', null, '0', null, 'MENU1504889259', '0', null, '', 'MENU1504889259', null, '0');
INSERT INTO `ac_menu` VALUES ('MENU1504890620', 'APP1499956132', 'FUNC1504890587', '日志管理', '日志管理', 'Menulog', 'Y', 'journal.html', '0', 'MENU1502953644', 'MENU1502953640', '2', null, 'fa fa-lg fa-book', 'MENU1502953640.MENU1502953644.MENU1504890620', null, '0');
