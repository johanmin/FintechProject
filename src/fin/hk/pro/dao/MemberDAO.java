package fin.hk.pro.dao;

import fin.hk.pro.model.MemberDTO;

public interface MemberDAO {

	public boolean addmember(MemberDTO mem) throws Exception;
	
	public MemberDTO logincheck(MemberDTO mem) throws Exception;
	
	
}
