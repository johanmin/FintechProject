package fin.hk.pro.service;

import fin.hk.pro.model.MemberDTO;

public interface MemberService {

	public boolean addmember(MemberDTO mem) throws Exception;
	
	public MemberDTO logincheck(MemberDTO mem) throws Exception;
	
}
