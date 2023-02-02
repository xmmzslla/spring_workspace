package members.dto;

import java.net.PasswordAuthentication;

import common.exception.WrongEmailPasswordException;

public class MembersDTO {

	private String memberEmail; //이메일
	private String memberPass; //비밀번호
	private String memberName; //이름
	private String memberPhone; //전화번호
	private String memberType; //회원 구분 일반회원1, 관리자2 
	private boolean rememberEmail; //자동 로그인
	
	
	public MembersDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberPass() {
		return memberPass;
	}


	public void setMemberPass(String memberPass) {
		this.memberPass = memberPass;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberType() {
		return memberType;
	}


	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	
	public boolean isRememberEmail() {
		return rememberEmail;
	}

	public void setRememberEmail(boolean rememberEmail) {
		this.rememberEmail = rememberEmail;
	}
	
	public boolean matchPassword(String memberPass) {
		return this.memberPass.equals(memberPass);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if(!memberPass.equals(oldPassword))
			throw new WrongEmailPasswordException();
		this.memberPass = newPassword;
	}
	
}//c
