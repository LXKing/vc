package com.ccclubs.quota.inf.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import com.alibaba.dubbo.config.annotation.Service;
import com.ccclubs.frm.spring.constant.ApiEnum;
import com.ccclubs.frm.spring.exception.ApiException;
import com.ccclubs.quota.inf.UserInf;
import com.ccclubs.quota.vo.UserInput;
import com.ccclubs.quota.vo.UserMenu;
import com.ccclubs.quota.vo.UserOutput;
import com.ccclubs.usr.orm.mapper.VcObjectsMapper;
import com.ccclubs.usr.orm.mapper.VcPermissionObjectMapper;
import com.ccclubs.usr.orm.mapper.VcRolePermissionMapper;
import com.ccclubs.usr.orm.mapper.VcRolesMapper;
import com.ccclubs.usr.orm.mapper.VcUserRoleMapper;
import com.ccclubs.usr.orm.mapper.VcUsersMapper;
import com.ccclubs.usr.orm.model.VcObjects;
import com.ccclubs.usr.orm.model.VcObjectsExample;
import com.ccclubs.usr.orm.model.VcPermissionObject;
import com.ccclubs.usr.orm.model.VcPermissionObjectExample;
import com.ccclubs.usr.orm.model.VcRolePermission;
import com.ccclubs.usr.orm.model.VcRolePermissionExample;
import com.ccclubs.usr.orm.model.VcRoles;
import com.ccclubs.usr.orm.model.VcRolesExample;
import com.ccclubs.usr.orm.model.VcUserRole;
import com.ccclubs.usr.orm.model.VcUserRoleExample;
import com.ccclubs.usr.orm.model.VcUsers;
import com.ccclubs.usr.orm.model.VcUsersExample;
@Service(version = "1.0.0")
public class UserInfImpl implements UserInf {
	@Resource
	private VcUsersMapper vcUsersMapper;
	@Resource
	private VcUserRoleMapper vcUserRoleMapper;
	@Resource
	private VcRolePermissionMapper vcRolePermissionMapper;
	@Resource
	private VcPermissionObjectMapper vcPermissionObjectMapper;
	@Resource
	private VcObjectsMapper vcObjectsMapper;
	@Resource
	private VcRolesMapper vcRolesMapper;
	
	
	@Override
	public UserOutput login(UserInput input) {
		UserOutput out = new UserOutput();
		VcUsersExample vex = new VcUsersExample();
		VcUsersExample.Criteria vcri = vex.createCriteria();
		String user = input.getAccount();
		String pwd = input.getPassword();
		if(StringUtils.isBlank(user)){
			throw new ApiException(ApiEnum.SYSTEM_ERROR);
		}else if(StringUtils.isBlank(pwd)){
			throw new ApiException(ApiEnum.SYSTEM_ERROR);
		}
		vcri.andAccountEqualTo(user.trim());
		vcri.andPasswordEqualTo(this.enc(user.trim(), pwd.trim()));
		List<VcUsers> ulist = vcUsersMapper.selectByExample(vex);
		if(null == ulist || ulist.size() == 0 || ulist.size() > 1){
			throw new ApiException(ApiEnum.SYSTEM_ERROR);
		}
		VcUsers vu = ulist.get(0);
		VcUserRoleExample urex = new VcUserRoleExample();
		VcUserRoleExample.Criteria urcri = urex.createCriteria();
		urcri.andUserIdEqualTo(vu.getUserId());
		List<VcUserRole> urlist = vcUserRoleMapper.selectByExample(urex);
		List<String> roleIds = new ArrayList<String>();
		for(VcUserRole vur : urlist){
			roleIds.add(vur.getRoleId());
		}
		VcRolesExample rrex = new VcRolesExample();
		VcRolesExample.Criteria rrcri = rrex.createCriteria();
		rrcri.andRoleIdIn(roleIds);
		List<VcRoles> rrlist = vcRolesMapper.selectByExample(rrex);
		List<String> roleNames = new ArrayList<String>();
		for(VcRoles rr : rrlist){
			roleNames.add(rr.getRoleName());
		}
		
		VcRolePermissionExample rpex = new VcRolePermissionExample();
		VcRolePermissionExample.Criteria rpcri = rpex.createCriteria();
		rpcri.andRoleIdIn(roleIds);
		List<VcRolePermission> rplist = vcRolePermissionMapper.selectByExample(rpex);
		List<String> permissionIds = new ArrayList<String>();
		for(VcRolePermission vrp : rplist){
			permissionIds.add(vrp.getPermissionId());
		}
		
		VcPermissionObjectExample poex = new VcPermissionObjectExample();
		VcPermissionObjectExample.Criteria pocri = poex.createCriteria();
		pocri.andPermissionIdIn(permissionIds);
		List<VcPermissionObject> polist = vcPermissionObjectMapper.selectByExample(poex);
		
		List<String> objectIds = new ArrayList<String>();
		for(VcPermissionObject vpo : polist){
			objectIds.add(vpo.getObjectId());
		}
		VcObjectsExample oex = new VcObjectsExample();
		VcObjectsExample.Criteria ocri = oex.createCriteria();
		ocri.andObjectIdIn(objectIds);
		List<VcObjects> olist = vcObjectsMapper.selectByExample(oex);
		
		List<UserMenu> menus = new ArrayList<UserMenu>();
		String key = null;
		for(VcObjects vo : olist){
			if("0".equals(vo.getObjectParentId())){
				UserMenu um = new UserMenu();
				um.setId(vo.getObjectId());
				um.setClassName(vo.getObjectCss());
				um.setName(vo.getObjectName());
				um.setPath(vo.getObjectPath());
				um.setActive(false);
				
				key = vo.getObjectId();
				VcObjectsExample example = new VcObjectsExample();
				VcObjectsExample.Criteria excri = example.createCriteria();
				excri.andObjectParentIdEqualTo(key);
				example.setOrderByClause("object_order asc");
				List<VcObjects> volist = vcObjectsMapper.selectByExample(example);
				List<UserMenu> vcm = new ArrayList<UserMenu>();
				for(VcObjects vco : volist){
					UserMenu vum = new UserMenu();
					vum.setId(vco.getObjectId());
					vum.setClassName(vco.getObjectCss());
					vum.setName(vco.getObjectName());
					vum.setPath(vco.getObjectPath());
					vum.setActive(false);
					vum.setClose(false);
					vcm.add(vum);
				}
				um.setSubmenu(vcm);
				
				menus.add(um);
			}
			
		}
		out.setMenus(menus);
		out.setNickname(vu.getNickname());
		out.setCreateTime(DateFormatUtils.format(vu.getCreateTime(), "yyyy-MM-dd HH:mm:ss"));
		out.setRoleNames(roleNames);
		return out;
	}
	
	private String enc(String user, String pwd){
		String seed = DigestUtils.md5Hex(user +  pwd + user);
		return DigestUtils.md5Hex(pwd+seed);
	}

}
