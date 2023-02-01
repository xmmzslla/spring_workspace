package members.service;

import members.dao.MembersDAO;
import members.dto.AuthInfo;
import members.dto.ChangePwdCommand;
import members.dto.MembersDTO;

public class MembersServiceImp implements MembersService{

	private MembersDAO membersDao;
	
	public MembersServiceImp() {
		// TODO Auto-generated constructor stub
	}
	
	public void setMembersDao(MembersDAO membersDao) {
		this.membersDao = membersDao;
	}

	@Override
	public AuthInfo addMemberProcess(MembersDTO dto) {
		membersDao.insertMember(dto);
		return new  AuthInfo(dto.getMemberEmail(), dto.getMemberName(), dto.getMemberPass());
	}

	@Override
	public AuthInfo lodinProcess(MembersDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembersDTO updateMemberProcess(String memberEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMemberProcess(MembersDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateMemberProcess(String memberEmail, ChangePwdCommand ChangePwd) {
		// TODO Auto-generated method stub
		
	}
	
	
}
