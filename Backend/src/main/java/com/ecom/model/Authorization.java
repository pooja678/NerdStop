package com.ecom.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Authorization {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int  roleId;
	private String roleName;
	private String role="ROLE_USER";
	public int getRoleId() {
		return roleId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	
	
}
