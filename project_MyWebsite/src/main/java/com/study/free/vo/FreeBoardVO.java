package com.study.free.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class FreeBoardVO {
	private int fbNo; /* 글 번호 */
	private String fbTitle; /* 글 제목 */
	private String fbWriter; /* 작성자명 */
	private String fbContent; /* 글 내용 */
	private String fbRegDate; /* 등록 일자 */

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	public int getFbNo() {
		return fbNo;
	}

	public void setFbNo(int fbNo) {
		this.fbNo = fbNo;
	}

	public String getFbTitle() {
		return fbTitle;
	}

	public void setFbTitle(String fbTitle) {
		this.fbTitle = fbTitle;
	}

	public String getFbWriter() {
		return fbWriter;
	}

	public void setFbWriter(String fbWriter) {
		this.fbWriter = fbWriter;
	}

	public String getFbContent() {
		return fbContent;
	}

	public void setFbContent(String fbContent) {
		this.fbContent = fbContent;
	}

	public String getFbRegDate() {
		return fbRegDate;
	}

	public void setFbRegDate(String fbRegDate) {
		this.fbRegDate = fbRegDate;
	}

}
