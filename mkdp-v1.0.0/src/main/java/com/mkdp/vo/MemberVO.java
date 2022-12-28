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
}