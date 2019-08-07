package com.cafe24.cat24frontend.vo;

import java.util.Date;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.cafe24.cat24frontend.validator.constraints.ValidGender;


public class UsersVo 
{
	/** 회원번호 **/
	private Long member_no;
	
	/** 아이디 **/
	@NotEmpty
	private String id;
	
	/** 비밀번호 **/
	@NotEmpty
	@Pattern(regexp="(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,20}", message="비밀번호는 8자 이상 20자 이하의 알파벳, 숫자, 특수문자를 조합하여 작성해야 합니다.") 
	@Length(min=8, max=20, message="비밀번호는 8자 이상 20자 이하로 입력해야 합니다.")
	private String password;		
	
	/** 성명 **/
	@NotEmpty
	@Length(min=2, max=8, message="이름은 2자 이상 5자 이하로 입력해야 합니다.")
	private String name;

	/** 성별 **/
	@ValidGender
	private String gender;
	
	/** 우편번호 **/
	private String zipcode;
	
	/** 주소 **/
	private String address;
	
	/** 상세주소 **/
	private String address_detail;
	
	/** 전화번호 **/
	private String home_number;
	
	/** 핸드폰 번호 **/
	private String phone;
	
	/** 이메일 **/
	@Email
	@NotEmpty
	private String email;
	
	/** 프로필 **/
	private String profile;

	/** 블랙리스트 여부 **/
	private String blacklist;

	/** 블랙리스트 일자 **/
	private Date blacklist_date;
	
	/** 마지막접속일**/
	private String last_date;
	
	/** 사용여부 **/
	private String used_YN;
	
	/** 등록일 **/
	private Date reg_date;
	
	/** 수정자 **/
	private String update_id;
	
	/** 수정일 **/
	private Date update_date;

	public Long getMember_no() 
	{
		return member_no;
	}

	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getBlacklist() {
		return blacklist;
	}

	public void setBlacklist(String blacklist) {
		this.blacklist = blacklist;
	}

	public Date getBlacklist_date() {
		return blacklist_date;
	}

	public void setBlacklist_date(Date blacklist_date) {
		this.blacklist_date = blacklist_date;
	}

	public String getLast_date() {
		return last_date;
	}

	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}

	public String getUsed_YN() {
		return used_YN;
	}

	public void setUsed_YN(String used_YN) {
		this.used_YN = used_YN;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public String getUpdate_id() {
		return update_id;
	}

	public void setUpdate_id(String update_id) {
		this.update_id = update_id;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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

	public String getHome_number() {
		return home_number;
	}

	public void setHome_number(String home_number) {
		this.home_number = home_number;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UsersVo [member_no=" + member_no + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", zipcode=" + zipcode + ", address=" + address + ", address_detail="
				+ address_detail + ", home_number=" + home_number + ", phone=" + phone + ", email=" + email
				+ ", profile=" + profile + ", blacklist=" + blacklist + ", blacklist_date=" + blacklist_date
				+ ", last_date=" + last_date + ", used_YN=" + used_YN + ", reg_date=" + reg_date + ", update_id="
				+ update_id + ", update_date=" + update_date + "]";
	}
	
	
	
}
