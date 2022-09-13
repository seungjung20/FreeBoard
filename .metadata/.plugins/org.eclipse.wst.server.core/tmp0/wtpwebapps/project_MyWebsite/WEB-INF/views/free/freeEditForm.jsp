<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@include file="../includes/header.jsp" %>

	<div class="container-fluid-editForm">
	<h1 class="h3 mb-2 text-gray-800">BOARD</h1>
		<form action="freeEditSave" method="post">
			<input type="hidden" name="fbNo" value="${freeBoard.fbNo }">
			<input type="hidden" name="curPage" value="${curPage }">
			<div class="card shadow mb-4">
				<div class="card-body">
					<table class="card-editForm">
						<tr>
							<th>Title</th>
							<td>
								<input type="text" name="fbTitle" required="required" value="${freeBoard.fbTitle }">
							</td>
						</tr>
						<tr>
							<th>Writer</th>
							<td>${freeBoard.fbWriter }</td>
						</tr>
						<tr>
							<th>Content</th>
							<td>
								<textarea rows="10" name="fbContent">${freeBoard.fbContent }</textarea>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="editBtn">
				<button type="button" class="back" onclick="history.back(-1)">BACK</button>
				<button type="submit" class="edit" onclick="return edit()">EDIT</button>
			</div>
		</form>
	</div>			
				
<%@include file="../includes/footer.jsp" %>