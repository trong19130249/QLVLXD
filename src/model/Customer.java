package model;


public class Customer {
	private String userName;
	private String password;
	private String email;
	private String name;
	private String sex;
	private String phoneNumber;
	private String address;
	public Customer(String userName, String password, String email, String name, String sex, String phoneNumber,
			String address) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.name = name;
		this.sex = sex;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", password=" + password + ", email=" + email + ", name=" + name
				+ ", sex=" + sex + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	}
	public String toWrite() {
		return userName +"#" +password+"#"+email+"#"+name+"#"+sex+"#"+phoneNumber+"#"+address;
		
	}
	
}
