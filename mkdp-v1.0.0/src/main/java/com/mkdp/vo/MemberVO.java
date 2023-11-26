package com.mkdp.vo;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	 String kiwoom_id;
	 String kiwoom_account;
	 String kiwoom_password;
	 String mem_name;
	 Date mem_birth;
	 Date mem_join_date;
	 Date mem_edit_date;
	 String mem_st_cd;
	 String mem_mobile_num;
	 String ip_address;
	 Date final_access_date;
	 String access_type;
	 
	public String getKiwoom_id() {
		return kiwoom_id;
	}
	public void setKiwoom_id(String kiwoom_id) {
		this.kiwoom_id = kiwoom_id;
	}
	public String getKiwoom_account() {
		return kiwoom_account;
	}
	public void setKiwoom_account(String kiwoom_account) {
		this.kiwoom_account = kiwoom_account;
	}
	public String getKiwoom_password() {
		return kiwoom_password;
	}
	public void setKiwoom_password(String kiwoom_password) {
		this.kiwoom_password = kiwoom_password;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public Date getMem_join_date() {
		return mem_join_date;
	}
	public void setMem_join_date(Date mem_join_date) {
		this.mem_join_date = mem_join_date;
	}
	public Date getMem_edit_date() {
		return mem_edit_date;
	}
	public void setMem_edit_date(Date mem_edit_date) {
		this.mem_edit_date = mem_edit_date;
	}
	public String getMem_st_cd() {
		return mem_st_cd;
	}
	public void setMem_st_cd(String mem_st_cd) {
		this.mem_st_cd = mem_st_cd;
	}
	public String getMem_mobile_num() {
		return mem_mobile_num;
	}
	public void setMem_mobile_num(String mem_mobile_num) {
		this.mem_mobile_num = mem_mobile_num;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public Date getFinal_access_date() {
		return final_access_date;
	}
	public void setFinal_access_date(Date final_access_date) {
		this.final_access_date = final_access_date;
	}
	public String getAccess_type() {
		return access_type;
	}
	public void setAccess_type(String access_type) {
		this.access_type = access_type;
	}
	 
	 
	 
}
