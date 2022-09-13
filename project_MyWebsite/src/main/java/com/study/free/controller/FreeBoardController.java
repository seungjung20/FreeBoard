package com.study.free.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.study.free.service.FreeBoardService;
import com.study.free.vo.FreeBoardVO;
import com.study.paging.vo.PagingVO;

@Controller
@RequestMapping("free")
public class FreeBoardController {

	@Autowired
	FreeBoardService fbs;

	// by승정-리스트페이지 요청
	@RequestMapping("freeList")
	public ModelAndView getBoardList(@RequestParam(defaultValue="1") int curPage) {	
		// getTotalRowCount 메서드에서 받아온 데이터 개수를 count에 저장
		int count = fbs.getTotalRowCount();
		// 페이지 나누기 관련 처리
		// count와 curPage를 PagingVO 객체에 넣어 페이지 시작번호(PageBegin)와 페이지 끝번호(PageEnd)를 각각 start와 end에 저장
	    PagingVO pagingVO = new PagingVO(count, curPage);
	    int start = pagingVO.getPageBegin();
	    int end = pagingVO.getPageEnd();
	    // getBoardList 메서드에서 받아온 리스트를 list에 저장
	    List<FreeBoardVO> list = fbs.getBoardList(start, end);
	    // HashMap<String(key), Object> 함수를 통해 Object를 key값으로 호출 할 수 있음
	    Map<String, Object> map = new HashMap<String, Object>();
	    // list와 페이징 처리를 위한 PagingVO 객체가 담긴 paging을 map에 저장
	    map.put("list", list);
	    map.put("paging", pagingVO);
	    // mav 변수에 freeList(view)와 view에 전달할 map을 저장 후 return
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("map", map); 
	    mav.setViewName("free/freeList"); 
	    return mav; 
	}
	
	// by승정-검색 리스트페이지 요청
	@RequestMapping("freeList.do")
	public ModelAndView SBoardList(@RequestParam String searchOption,
								   @RequestParam String keyword,
								   @RequestParam(defaultValue="1") int curPage) throws Exception {
	    // STotalRowCount 메서드에서 searchOption과 keyword를 고려한 데이터 개수를 count에 저장
	    int count = fbs.STotalRowCount(searchOption, keyword);
	    // 페이지 나누기 관련 처리
	    // count와 curPage를 PagingVO 객체에 넣어 페이지 시작번호(PageBegin)과 페이지 끝번호(PageEnd)를 각각 start와 end에 저장
	    PagingVO pagingVO = new PagingVO(count, curPage);
	    int start = pagingVO.getPageBegin();
	    int end = pagingVO.getPageEnd();
	    // SBoardList 메서드에서 searchOption과 keyword를 고려해 받아온 리스트를 list에 저장
	    List<FreeBoardVO> list = fbs.SBoardList(start, end, searchOption, keyword);
	    // HashMap<String(key), Object> 함수를 통해 Object를 key값으로 호출 할 수 있음
	    Map<String, Object> map = new HashMap<String, Object>();
	    // list, 페이징 처리를 위한 PagingVO 객체가 담긴 paging, 검색 후 list를 재 호출하기 위한 searchOption과 keyword를 map에 저장
	    map.put("Slist", list);
	    map.put("searchOption", searchOption);
	    map.put("keyword", keyword);
	    map.put("paging", pagingVO);
	    // mav 변수에 freeList(view)와 view에 전달할 map을 저장 후 return
	    ModelAndView mav = new ModelAndView();
	    mav.addObject("map", map);
	    mav.setViewName("free/freeList");
	    return mav;
	}
	
	// by승정-글작성 페이지 요청
	@RequestMapping("freeWriteForm")
	public String freeWriteForm() {
		return "free/freeWriteForm";
	}

	// by승정-글작성 완료 요청
	@RequestMapping("freeWriteSave")
	public void freeWriteSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// freeWriteSave 메서드에서 받은 alert 메시지와 경로를 message 변수에 저장
		String message = fbs.freeWriteSave(request);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	    out.print(message);
	}
	
	// by승정-글보기 페이지 요청
	@RequestMapping("freeView")
	public String freeView(int fbNo, Model model, int curPage) {
		fbs.freeView(fbNo, model, curPage);
		return "free/freeView";
	}
	
	// by승정-글보기 페이지 요청(검색 후)
	@RequestMapping("freeView.do")
	public String freeViewDo(int fbNo, Model model, int curPage, String searchOption, String keyword) {
		fbs.freeViewDo(fbNo, model, curPage, searchOption, keyword);
		return "free/freeView";
	}
	
	// by승정-글수정 페이지 요청
	@RequestMapping("freeEditForm")
	public String freeEditForm(int fbNo, Model model, int curPage) {
		fbs.freeView(fbNo, model, curPage);
		return "free/freeEditForm";
	}
	
	// by승정-글수정 완료 요청
	@RequestMapping("freeEditSave")
	public void freeEditSave(HttpServletRequest request, HttpServletResponse response, int curPage) throws IOException {
		// freeEditSave 메서드에서 받은 alert 메시지와 경로를 message 변수에 저장
		String message = fbs.freeEditSave(request, curPage);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	    out.print(message);
	}
	
	// by승정-글삭제 요청
	@RequestMapping("freeDelete")
	public void freeDelete(int fbNo, HttpServletRequest request, HttpServletResponse response) throws IOException {
		// freeDelete 메서드에서 받은 alert 메시지와 경로를 message 변수에 저장
		String message = fbs.freeDelete(fbNo, request);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	    out.print(message);
	}

}
