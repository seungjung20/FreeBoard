package com.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.study.member.vo.MemberVO;

@Mapper
public interface MemberDao {

	public MemberVO getMember(String id);
	
	public int insertMember(MemberVO member);

	public MemberVO memberInfo(String id);

	public int infoUpdate(MemberVO member);
	
	public void memberDelete(String id);

	public int idCheck(String id);
	
}
