package com.study.member.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.study.member.vo.MemberVO;

public interface MemberService {

	public MemberVO getMember(String id);

	public int insertMember(MemberVO member);

	public void memberInfo(Model model, String id);

	public String infoUpdate(MemberVO member, HttpServletRequest request);
	
	public void memberDelete(String id);

	public int idCheck(String id);

}
