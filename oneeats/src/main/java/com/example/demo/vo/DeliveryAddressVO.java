package com.example.demo.vo;

import org.springframework.stereotype.Component;

@Component("deliveryAddressVO")
public class DeliveryAddressVO {
	private String receiver_name;
	private String receiver_phone;
	private String zipCode;
	private String address;
	private String address_detail;
	private int memberNo;
	private int deliveryNo;
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_detail() {
		return address_detail;
	}
	public void setAddress_detail(String address_detail) {
		this.address_detail = address_detail;
	}
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public int getDeliveryNo() {
		return deliveryNo;
	}
	public void setDeliveryNo(int deliveryNo) {
		this.deliveryNo = deliveryNo;
	}
	@Override
	public String toString() {
		return "DeliveryAddressVO [receiver_name=" + receiver_name + ", receiver_phone=" + receiver_phone + ", zipCode="
				+ zipCode + ", address=" + address + ", address_detail=" + address_detail + ", memberNo=" + memberNo
				+ ", deliveryNo=" + deliveryNo + "]";
	}
	
	
	
}
