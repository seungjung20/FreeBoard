package com.study.free.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.study.free.vo.FreeBoardVO;

public interface FreeBoardService {

	public int getTotalRowCount();
	
	public List<FreeBoardVO> getBoardList(int start, int end);
	
	public int STotalRowCount(String searchOption, String keyword);
	
	public List<FreeBoardVO> SBoardList(int start, int end, String searchOption, String keyword);
	
	public String freeWriteSave(HttpServletRequest request);

	public void freeView(int fbNo, Model model, int curPage);

	public void freeViewDo(int fbNo, Model model, int curPage, String searchOption, String keyword);
	
	public String freeEditSave(HttpServletRequest request, int curPage);
	
	public String freeDelete(int fbNo, HttpServletRequest request);

}
