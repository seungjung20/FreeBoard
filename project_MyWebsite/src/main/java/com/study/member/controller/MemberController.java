package com.study.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.study.member.interceptor.SessionNames;
import com.study.member.service.MemberService;
import com.study.member.vo.MemberVO;

@Controller
@RequestMapping("member")
public class MemberController implements SessionNames {

	@Autowired
	MemberService ms;
	
	// by승정-로그인페이지 요청
	@RequestMapping("login")
	public String login() {
		return "member/login";
	}
	
	// by승정-아이디, 비밀번호 확인 요청 
	@RequestMapping("loginCheck")
	public ModelAndView loginCheck(String id, String pw, HttpSession session, HttpServletResponse response, HttpServletRequest request) throws IOException {
		ModelAndView mv=new ModelAndView();
		session=request.getSession();
		// 요청 매개변수 id로 DB 데이터에 동일한 mem_id의 정보를 가져옵니다.
		MemberVO member=ms.getMember(id); 
		// 동일한 mem_id의 정보가 없다면 “회원정보가 없습니다.＂알람을 띄우고 다시 login.jsp로 돌아갑니다.
		if(member==null) { 
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('회원정보가 없습니다.');</script>");
			out.flush();
			mv.setViewName("/member/login");
			return mv;
		// 동일한 mem_id의 정보가 있다면 비밀번호를 확인합니다.
		} else { 
			// 동일한 mem_id의 mem_pass와 요청 매개변수 pw가 다르다면 “비밀번호가 틀립니다.” 알람을 띄우고 다시 login.jsp로 돌아갑니다.
			if(!member.getMemPass().equals(pw)) { 
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>alert('비밀번호가 틀립니다.');</script>");
				out.flush();
				mv.setViewName("/member/login");
				return mv;
			// 동일한 mem_id의 mem_pass와 요청 매개변수 pw가 같다면 mem_id를 session에 추가하고 index.jsp로 이동합니다.
			} else { 
				session.setAttribute(LOGIN, member.getMemId());
				mv.addObject("session",session);
				mv.setViewName("redirect:/index");
				return mv;
			}
		}
	}
	
	// by승정-로그아웃 요청
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		// LOGIN(지정된 이름)에 해당하는 객체를 세션에서 제거
		session.removeAttribute(SessionNames.LOGIN);
		// session의 모든 데이터를 삭제
		session.invalidate();
		// index.jsp로 이동
		return "redirect:/index";
	}
	
	// by승정-회원가입 페이지 요청
	@RequestMapping("registForm")
	public String registForm() {
		return "member/registForm";
	}
	
	// by승정-회원가입 확인 요청
	@RequestMapping("regist")
	public ModelAndView regist(MemberVO member, HttpServletResponse response) throws IOException {
		ModelAndView mv=new ModelAndView();
		// insertMember 메서드에 form 데이터를 보내고 받은 결과를 result 변수에 저장
		int result=ms.insertMember(member);
		// result 값이 1이라면 index.jsp로 이동합니다
		if(result==1) {
			mv.setViewName("redirect:/index");
			return mv;
		// result 값이 1이 아니라면 '오류가 발생하였습니다.' 알람을 띄우고 registForm.jsp로 돌아갑니다.
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>alert('오류가 발생하였습니다.');</script>");
			out.flush();
			mv.setViewName("/member/registForm");
			return mv;
		}
	}
	
	// by승정-아이디 중복확인 요청
	@RequestMapping("idCheck")
	@ResponseBody
	public int idCheck(@RequestParam("id")String id) {
		// 요청 매개변수 id를 idCheck 메서드에 보내고 받은 결과를 result 변수에 저장 후 return
		int result = ms.idCheck(id);
		return result;
	}
	
	// by승정-마이페이지 요청
	@RequestMapping("mypage")
	public String mypage() throws Exception {
		return "member/mypage";
	}
	
	// by승정-회원정보수정 페이지 요청
	@RequestMapping("memberInfo")
	public String memberInfo(Model model, @RequestParam("id")String id) {
		// memberInfo 메서드에 Model 객체와 요청 매개변수 id를 보내고 memberInfo.jsp로 이동
		ms.memberInfo(model, id);
		return "member/memberInfo";
	}
	
	// by승정-회원정보수정 확인 요청
	@RequestMapping("infoUpdate")
	public void infoUpdate(MemberVO member, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// infoUpdate 메서드에 form 데이터와 request를 보내고 받은 alert 메시지와 경로를 message 변수에 저장
		String message=ms.infoUpdate(member, request);
		response.setContentType("text/html; charset=utf-8"); 
		PrintWriter out=response.getWriter();
		out.print(message);
	}
	
	// by승정-회원탈퇴 요청
	@RequestMapping("memberDelete")
	public String memberDelete(@RequestParam("id")String id, HttpSession session)throws Exception {
		// memberDelete 메서드에 요청 매개변수 id를 보냄 
		ms.memberDelete(id);
		// LOGIN(지정된 이름)에 해당하는 객체를 세션에서 제거
		session.removeAttribute(SessionNames.LOGIN);
		// session의 모든 데이터를 삭제
		session.invalidate();
		// index.jsp로 이동
		return "redirect:/index";
	}
	
}
