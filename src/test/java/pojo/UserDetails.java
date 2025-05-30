package pojo;

import java.util.List;

public class UserDetails {

	private int id;
	private int locCode;
	private String userName;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailId;
	private String mobileNo;
	private String profilePhoto;
	private String createdBy;
	private CreatedOn createdOn;
	private String authToken;
	private String fcmKey;
	private int locationTypeId;
	private String otpRequired;
	private List<RolePermissionMap> rolePermissionMap;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getLocCode() {
		return locCode;
	}
	public void setLocCode(int locCode) {
		this.locCode = locCode;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public CreatedOn getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(CreatedOn createdOn) {
		this.createdOn = createdOn;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getFcmKey() {
		return fcmKey;
	}
	public void setFcmKey(String fcmKey) {
		this.fcmKey = fcmKey;
	}
	public int getLocationTypeId() {
		return locationTypeId;
	}
	public void setLocationTypeId(int locationTypeId) {
		this.locationTypeId = locationTypeId;
	}
	public String getOtpRequired() {
		return otpRequired;
	}
	public void setOtpRequired(String otpRequired) {
		this.otpRequired = otpRequired;
	}
	public List<RolePermissionMap> getRolePermissionMap() {
		return rolePermissionMap;
	}
	public void setRolePermissionMap(List<RolePermissionMap> rolePermissionMap) {
		this.rolePermissionMap = rolePermissionMap;
	}

	
	
}
