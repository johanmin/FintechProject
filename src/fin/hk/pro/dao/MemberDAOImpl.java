package fin.hk.pro.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fin.hk.pro.model.MemberDTO;
@Repository
public class MemberDAOImpl implements MemberDAO{

	// 상속받은 클래스를 찾아서 자동적으로 생성해줌
	 	@Autowired // DI = Dependency Injection(의존성) 
		SqlSession sqlSession;
	 	
	 	String namespace = "Member."; // khMember.xml에서 mapper namespace와 같아야함
	 	
	 	@Override
		public boolean addmember(MemberDTO mem) throws Exception {
			
	 		int n = sqlSession.insert(namespace + "addmember", mem);
	 		
			return n>0?true:false;
		}

		@Override
		public MemberDTO logincheck(MemberDTO mem) throws Exception {	
			
			return sqlSession.selectOne(namespace + "logincheck", mem);
		}

}
