<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../includes/header.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">BOARD</h1>
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-body">
	                        <form class="d-none d-sm-inline-block form-inline mr-auto my-2 my-md-0 mw-100 navbar-search pb-fr" 
	                        action="${contextPath }/free/freeList.do" method="get">
						        <div class="input-group">
							        <select name="searchOption" class="bg-light border-1">
							            <option value="fb_title" <c:out value="${map.searchOption == 'fb_title'?'selected':''}"/> >Title</option>
							            <option value="fb_content" <c:out value="${map.searchOption == 'fb_content'?'selected':''}"/> >Content</option>
							            <option value="fb_writer" <c:out value="${map.searchOption == 'fb_writer'?'selected':''}"/> >Writer</option>
							            <option value="all" <c:out value="${map.searchOption == 'all'?'selected':''}"/> >Title+Content+Writer</option>
							        </select>
							        <input class="form-control bg-light border-0 small" name="keyword" value="${map.keyword}">
							        <div class="input-group-append">
							        	<button class="btn btn-primary" type="submit">
							        		<i class="fas fa-search fa-sm"></i>
							        	</button>
							        </div>	
						        </div>
						    </form>
	                        <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>Writer</th>
                                            <th class="list-title">Title</th>
                                            <th>Date</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<!-- 검색 후 리스트 -->
                                    	<c:forEach items="${map.Slist }" var="search">
                                    		<tr>
										 		<td>${search.fbWriter }</td>
										 		<td class="list-title"><a href="freeView.do?fbNo=${search.fbNo }
										 		&searchOption=${map.searchOption }&keyword=${map.keyword }&curPage=${map.paging.curPage }">${search.fbTitle }</a></td>
										 		<td>${search.fbRegDate }</td>
										 	</tr>
                                    	</c:forEach>
                                        <!-- 검색 전 리스트 -->
                                        <c:forEach items="${map.list }" var="freeBoard">
											<tr>
										 		<td>${freeBoard.fbWriter }</td>
										 		<td class="list-title"><a href="freeView?fbNo=${freeBoard.fbNo }&curPage=${map.paging.curPage }">${freeBoard.fbTitle }</a></td>
										 		<td>${freeBoard.fbRegDate }</td>
										 	</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                                <c:if test="${map.Slist.size()==0 }">
                               		<div class="searchNone">검색 결과가 없습니다</div>
                               	</c:if>
                            </div>
                        </div>
                    </div>
                    <!-- 검색 후 페이징 -->
                    <c:if test="${map.searchOption != null }">
                    	<div class="listPaging">
			                <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면 "<<" 하이퍼링크를 화면에 출력-->
			                <c:if test="${map.paging.curPage > 1}">
			                    <a href="javascript:freeListDo('1')">&lt;&lt;</a>
			                </c:if>
			                <!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 "<" 하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.paging.curPage > 1}">
			                    <a href="javascript:freeListDo('${map.paging.prevPage}')">&lt;</a>
			                </c:if>
			                <!-- 하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 -->
			                <c:forEach var="num" begin="${map.paging.blockBegin}" end="${map.paging.blockEnd}">
			                    <!-- 현재페이지이면 하이퍼링크 제거 -->
			                    <c:choose>
			                        <c:when test="${num == map.paging.curPage}">
			                            <span style="color: red">${num}</span>&nbsp;
			                        </c:when>
			                        <c:otherwise>
			                            <a href="javascript:freeListDo('${num}')">${num}</a>&nbsp;
			                        </c:otherwise>
			                    </c:choose>
			                </c:forEach>
			                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 ">" 하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.paging.curPage < map.paging.totPage}">
			                    <a href="javascript:freeListDo('${map.paging.nextPage}')">&gt;</a>
			                </c:if>
			                <!-- **끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 ">>" 하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.paging.curPage < map.paging.totPage}">
			                    <a href="javascript:freeListDo('${map.paging.totPage}')">&gt;&gt;</a>
			                </c:if>
			                <c:if test="${not empty loginUser }">
			                	<button type="button" onclick="location.href='freeWriteForm'">WRITE</button>
			                </c:if>
				    	</div>
                    </c:if>
                    <!-- 검색 전 페이징 -->
                    <c:if test="${map.searchOption == null }">
	                    <div class="listPaging">
			                <!-- 처음페이지로 이동 : 현재 페이지가 1보다 크면  "<<" 하이퍼링크를 화면에 출력-->
			                <c:if test="${map.paging.curPage > 1}">
			                    <a href="javascript:freeList('1')">&lt;&lt;</a>
			                </c:if>
			                <!-- 이전페이지 블록으로 이동 : 현재 페이지 블럭이 1보다 크면 "<" 하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.paging.curPage > 1}">
			                    <a href="javascript:freeList('${map.paging.prevPage}')">&lt;</a>
			                </c:if>
			                <!-- 하나의 블럭에서 반복문 수행 시작페이지부터 끝페이지까지 -->
			                <c:forEach var="num" begin="${map.paging.blockBegin}" end="${map.paging.blockEnd}">
			                    <!-- 현재페이지이면 하이퍼링크 제거 -->
			                    <c:choose>
			                        <c:when test="${num == map.paging.curPage}">
			                            <span style="color: red">${num}</span>&nbsp;
			                        </c:when>
			                        <c:otherwise>
			                            <a href="javascript:freeList('${num}')">${num}</a>&nbsp;
			                        </c:otherwise>
			                    </c:choose>
			                </c:forEach>
			                <!-- 다음페이지 블록으로 이동 : 현재 페이지 블럭이 전체 페이지 블럭보다 작거나 같으면 ">" 하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.paging.curPage < map.paging.totPage}">
			                    <a href="javascript:freeList('${map.paging.nextPage}')">&gt;</a>
			                </c:if>
			                <!-- 끝페이지로 이동 : 현재 페이지가 전체 페이지보다 작거나 같으면 ">>" 하이퍼링크를 화면에 출력 -->
			                <c:if test="${map.paging.curPage < map.paging.totPage}">
			                    <a href="javascript:freeList('${map.paging.totPage}')">&gt;&gt;</a>
			                </c:if>
			                <c:if test="${not empty loginUser }">
			                	<button type="button" onclick="location.href='freeWriteForm'">WRITE</button>
			                </c:if>
	                    </div>
                    </c:if>
                </div>

<%@include file="../includes/footer.jsp" %>