package com.study.paging.vo;

public class PagingVO {

	// 페이지당 게시물 수
    public static final int PAGE_SCALE = 10;
    // 화면당 페이지 수
    public static final int BLOCK_SCALE = 10;
    private int curPage; // 현재 페이수
    private int prevPage; // 이전 페이지
    private int nextPage; // 다음 페이지
    private int totPage; // 전체 페이지 갯수
    private int totBlock; // 전체 페이지 블록 갯수
    private int curBlock; // 현재 페이지 블록 
    // WHERE rn BETWEEN #{start} AND #{end}
    private int pageBegin; // #{start}
    private int pageEnd; // #{end}
    // [이전] blockBegin -> 41 42 43 44 45 46 47 48 49 50 [다음]
    private int blockBegin; // 현재 페이지 블록의 시작번호
    // [이전] 41 42 43 44 45 46 47 48 49 50 <- blockEnd [다음]
    private int blockEnd; // 현재 페이지 블록의 끝번호
    
    // 생성자
    // PagingVO(레코드 갯수, 현재 페이지 번호)
    public PagingVO(int count, int curPage){
        curBlock = 1; // 현재 페이지 블록 번호
        this.curPage = curPage; // 현재 페이지 설정
        setTotPage(count); // 전체 페이지 갯수 계산
        setPageRange(); // 
        setTotBlock(); // 전체 페이지 블록 갯수 계산
        setBlockRange(); // 페이지 블록의 시작, 끝 번호 계산
    }
    
    public void setBlockRange(){
        // *현재 페이지가 몇번째 페이지 블록에 속하는지 계산
        curBlock = (int)Math.ceil((curPage-1) / BLOCK_SCALE)+1;
        // *현재 페이지 블록의 시작, 끝 번호 계산
        blockBegin = (curBlock-1)*BLOCK_SCALE+1;
        // 페이지 블록의 끝번호
        blockEnd = blockBegin+BLOCK_SCALE-1;
        // *마지막 블록이 범위를 초과하지 않도록 계산
        if(blockEnd > totPage) blockEnd = totPage;
        // *이전을 눌렀을 때 이동할 페이지 번호
//        prevPage = (curPage == 1)? 1:(curBlock-1)*BLOCK_SCALE;
        prevPage = (curPage == 1)? 1:curPage-1;
        // *다음을 눌렀을 때 이동할 페이지 번호
//        nextPage = curBlock > totBlock ? (curBlock*BLOCK_SCALE) : (curBlock*BLOCK_SCALE)+1;
        nextPage = curPage >= totPage ? curPage : curPage+1;
        // 마지막 페이지가 범위를 초과하지 않도록 처리
        if(nextPage >= totPage) nextPage = totPage;
    }
    
    public void setPageRange(){
    // WHERE rn BETWEEN #{start} AND #{end}
        // 시작번호 = (현재페이지-1)*페이지당 게시물수 +1
        pageBegin = (curPage-1)*PAGE_SCALE+1;
        // 끝번호 = 시작번호+페이지당 게시물수 -1
        pageEnd = pageBegin+PAGE_SCALE-1;
    }
    
    // Getter/Setter
    public int getCurPage() {
        return curPage;
    }
    public void setCurPage(int curPage) {
        this.curPage = curPage;
    }
    public int getPrevPage() {
        return prevPage;
    }
    public void setPrevPage(int prevPage) {
        this.prevPage = prevPage;
    }
    public int getNextPage() {
        return nextPage;
    }
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }
    public int getTotPage() {
        return totPage;
    }
    public void setTotPage(int count) {
        // Math.ceil(실수) 올림 처리
        totPage = (int) Math.ceil(count*1.0 / PAGE_SCALE);
    }
    public int getTotBlock() {
        return totBlock;
    }
    // 페이지 블록의 갯수 계산(총 100페이지라면 10개의 블록)
    public void setTotBlock() {
        // 전체 페이지 갯수 / 10
        // 91 / 10 => 9.1 => 10개
        totBlock = (int)Math.ceil(totPage / BLOCK_SCALE);
    }
    
    public int getCurBlock() {
        return curBlock;
    }
    public void setCurBlock(int curBlock) {
        this.curBlock = curBlock;
    }
    public int getPageBegin() {
        return pageBegin;
    }
    public void setPageBegin(int pageBegin) {
        this.pageBegin = pageBegin;
    }
    public int getPageEnd() {
        return pageEnd;
    }
    public void setPageEnd(int pageEnd) {
        this.pageEnd = pageEnd;
    }
    public int getBlockBegin() {
        return blockBegin;
    }
    public void setBlockBegin(int blockBegin) {
        this.blockBegin = blockBegin;
    }
    public int getBlockEnd() {
        return blockEnd;
    }
    public void setBlockEnd(int blockEnd) {
        this.blockEnd = blockEnd;
    }
	
	
//	// 입력받는 데이터
//	private int curPage = 1; // 현재 페이지 번호
//	private int rowSizePerPage = 10; // 한 페이지당 레코드 수. 기본10
//	private int pageSize = 5; // 페이지 리스트에서 보여줄 페이지 갯수. 보통 10 or 5 안 변함
//	private int totalRowCount; // 총 레코드 건수
//
//	// 입력받는 데이터를 통해 계산되는 값
//	private int firstRow; // 시작 레크드 번호
//	private int lastRow; // 마지막 레크드 번호
//	private int totalPageCount; // 총 페이지 건수
//	private int firstPage; // 페이지 리스트에서 시작 페이지 번호
//	private int lastPage; // 페이지 리스트에서 마지막 페이지 번호
//
//	public void pageSetting() {
//		totalPageCount = (totalRowCount - 1) / rowSizePerPage + 1;
//		firstRow = (curPage - 1) * rowSizePerPage + 1;
//		lastRow = firstRow + rowSizePerPage - 1;
//		if (lastRow >= totalRowCount) {
//			lastRow = totalRowCount;
//		}
//
//		firstPage = ((curPage - 1) / pageSize) * pageSize + 1;
//
//		lastPage = firstPage + pageSize - 1;
//		if (lastPage > totalPageCount) {
//			lastPage = totalPageCount;
//		}
//
//		
//	}
//
//	@Override
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//	}
//
//	public int getCurPage() {
//		return curPage;
//	}
//
//	public void setCurPage(int curPage) {
//		this.curPage = curPage;
//	}
//
//	public int getRowSizePerPage() {
//		return rowSizePerPage;
//	}
//
//	public void setRowSizePerPage(int rowSizePerPage) {
//		this.rowSizePerPage = rowSizePerPage;
//	}
//
//	public int getFirstRow() {
//		return firstRow;
//	}
//
//	public void setFirstRow(int firstRow) {
//		this.firstRow = firstRow;
//	}
//
//	public int getLastRow() {
//		return lastRow;
//	}
//
//	public void setLastRow(int lastRow) {
//		this.lastRow = lastRow;
//	}
//
//	public int getTotalRowCount() {
//		return totalRowCount;
//	}
//
//	public void setTotalRowCount(int totalRowCount) {
//		this.totalRowCount = totalRowCount;
//	}
//
//	public int getTotalPageCount() {
//		return totalPageCount;
//	}
//
//	public void setTotalPageCount(int totalPageCount) {
//		this.totalPageCount = totalPageCount;
//	}
//
//	public int getPageSize() {
//		return pageSize;
//	}
//
//	public void setPageSize(int pageSize) {
//		this.pageSize = pageSize;
//	}
//
//	public int getFirstPage() {
//		return firstPage;
//	}
//
//	public void setFirstPage(int firstPage) {
//		this.firstPage = firstPage;
//	}
//
//	public int getLastPage() {
//		return lastPage;
//	}
//
//	public void setLastPage(int lastPage) {
//		this.lastPage = lastPage;
//	}

}
