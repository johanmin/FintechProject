package fin.hk.pro.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fin.hk.pro.model.MemberDTO;
import fin.hk.pro.service.MemberService;


@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	MemberService MemberService; // MemberService는 인터페이스이므로 결론적으로 MemberServiceImpl이 생성
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
	public String login(Model model) {
		
		logger.info("MemberController login " + new Date());
		
		return "login";
	}
	
	@RequestMapping(value="loginAf.do", method=RequestMethod.POST)
	public String loginAf(MemberDTO dto, HttpServletRequest req) throws Exception {
		
		logger.info("MemberController loginAf " + new Date());
		
		MemberDTO login = MemberService.logincheck(dto);
		
		if(login != null && !login.getId().equals("")) { // id, pwd 체크 성공 시
			
			// Session 저장 여기서
			req.getSession().setAttribute("login", login);
			
			logger.info("login success : " + login.getId());
			
			return "NewFile";
		}else {
			//return "login"; // login.jsp
			return "redirect:/login.do"; 	// sendRedirect -> 컨트롤러에서 컨트롤러로 이동 (짐없이)
			// return "forward:/login.do"; 	// forward -> 짐싸서 이동시
		}
	
	}
	
	@RequestMapping(value="regi.do", method=RequestMethod.GET)
	public String regi() {
		
		logger.info("MemberController regi " + new Date());
		
		return "regi";
	}
	
	@RequestMapping(value="regiAf.do", method=RequestMethod.POST)
	public String regiAf(MemberDTO dto) throws Exception {
		
		logger.info("MemberController regiAf " + new Date());
		
		logger.info(dto.toString());
		
		boolean b = MemberService.addmember(dto);
		
		if(b) { // 디비에 성공적으로 넣어졌을때
			return "login";
		}else {
			return "regi";
		}
		
		
	}
}

