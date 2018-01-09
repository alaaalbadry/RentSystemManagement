package model;

//import javax.swing.JTextField;

public class AccountModel {
	 
	private String name;
	private String phone;
	private String email;
	private String address;
	private String NatID;

public AccountModel() {
}

public 	AccountModel(String name) {
	this.name=name;
}

public 	AccountModel(String name,String phone){
	this.name=name;
	this.phone=phone;
}
public 	AccountModel(String name,String phone,String email) {
	this.name=name;
	this.phone=phone;
	this.email=email;
}


public AccountModel(String name, String phone, String email, String address, String NatID){
	
	this.name = name;
	this.phone = phone;
	this.email = email;
	this.address = address;
this.NatID=NatID;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name=name;
	
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone=phone;
	
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email=email;
	
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address=address;
	
}

public String getNatID() {
	return NatID;
}

public void setNatID(String NatID) {
	this.NatID=NatID;
	
}




}