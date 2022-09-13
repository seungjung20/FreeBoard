<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@include file="../includes/header.jsp" %>

	<div class="container-fluid-writeForm">
	<h1 class="h3 mb-2 text-gray-800">BOARD</h1>
		<form action="freeWriteSave" method="post">
			<div class="card shadow mb-4">
				<div class="card-body">
					<table class="card-writeForm">
						<tr>
							<th>Title</th>
							<td>
								<input type="text" name="fbTitle" required="required">
							</td>
						</tr>
						<tr>
							<th>Writer</th>
							<td>
								<input type="text" name="fbWriter" value="${loginUser }" readonly>
							</td>
						</tr>
						<tr>
							<th>Content</th>
							<td>
								<textarea rows="10" name="fbContent"></textarea>
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="writeBtn">
				<button type="button" class="list" onclick="location.href='freeList'">LIST</button>
				<button type="submit" class="write" onclick="return Write()">WRITE</button>
			</div>
		</form>
	</div>			
				
<%@include file="../includes/footer.jsp" %>