<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@include file="../includes/header.jsp" %>
	
	<div class="container-fluid">
	<h1 class="h3 mb-2 text-gray-800">BOARD</h1>
		<div class="card shadow mb-4">
			<div class="card-body">
				<table class="card-viewTable">
					<thead>
						<tr>
							<th>Title</th>
							<td class="title">${freeBoard.fbTitle }</td>
							<th>Writer</th>
							<td>${freeBoard.fbWriter }</td>
							<th>Date</th>
							<td>${freeBoard.fbRegDate }</td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6" >${freeBoard.fbContent }</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="viewBtn">
			<c:if test="${loginUser == freeBoard.fbWriter }">
				<button type="button" class="edit" onclick="location.href='freeEditForm?fbNo=${freeBoard.fbNo }&curPage=${curPage }'">EDIT</button>
				<a href="freeDelete?fbNo=${freeBoard.fbNo }" onclick="return Delete()"><button type="button" class="delete">DELETE</button></a>
			</c:if>	
			<!-- 검색 전 -->
			<c:if test="${searchOption == null }">
				<button type="button" class="list" onclick="location.href='freeList?curPage=${curPage }'">LIST</button>
			</c:if>
			<!-- 검색 후 -->
			<c:if test="${searchOption != null }">
				<button type="button" class="list" onclick="location.href='freeList.do?curPage=${curPage }&searchOption=${searchOption }&keyword=${keyword }'">LIST</button>
			</c:if>	
		</div>				
	</div>
	
	
	
<%@include file="../includes/footer.jsp" %>