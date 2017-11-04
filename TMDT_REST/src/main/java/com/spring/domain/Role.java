package com.spring.domain;
/**
 * <p>Domain class cho table QUYEN</p>
 * @author ttlang
 *
 */
public class Role {
	private String roleID;
	private String roleName;
	private String roleDescription;
	public Role(String roleID, String roleName, String roleDescription) {
		super();
		this.roleID = roleID;
		this.roleName = roleName;
		this.roleDescription = roleDescription;
	}
	public Role() {
	}
	
	
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDescription() {
		return roleDescription;
	}
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}
	@Override
	public String toString() {
		return "Role [roleID=" + roleID + ", roleName=" + roleName + ", roleDescription=" + roleDescription + "]";
	}
	

}
