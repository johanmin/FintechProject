package fin.hk.pro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fin.hk.pro.dao.MemberDAO;
import fin.hk.pro.model.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired // new KhMemberDaoImple() 을 생성한것과 같은 효과. 하지만 autowired 없애고 객체 생성만 해주면 작동안함
	MemberDAO memberDAO;

	@Override
	public boolean addmember(MemberDTO mem) throws Exception {
		// TODO Auto-generated method stub
		return memberDAO.addmember(mem);
	}

	@Override
	public MemberDTO logincheck(MemberDTO mem) throws Exception {
		
		return memberDAO.logincheck(mem);
	}

}
