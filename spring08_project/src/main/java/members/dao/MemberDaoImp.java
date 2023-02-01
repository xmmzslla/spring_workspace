package members.dao;

import org.apache.ibatis.session.SqlSession;

import members.dto.MembersDTO;

public class MemberDaoImp implements MembersDAO{

	private SqlSession sqlSession;
	
	public MemberDaoImp() {
		
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertMember(MembersDTO dto) {
		
		return sqlSession.insert("members.insertMember", dto);
	}

	@Override
	public MembersDTO selectByEmail(String memberEmail) {
		
		return sqlSession.selectOne("members.selectByEmail", memberEmail);
	}

	@Override
	public void updateMember(MembersDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateByEmail(MembersDTO dto) {
		// TODO Auto-generated method stub
		
	}
	
}
