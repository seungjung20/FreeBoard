<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp" %>

                <div class="container-fluid">
                    <h1 class="h3 mb-2 text-gray-800">MYPAGE</h1>
                    <div class="card shadow mb-4">
                        <div class="card-body">
                            <div class="table-responsive-mypage">
								<div class="memberinfo">
									<a href="memberInfo?id=${loginUser }">
										<img src="/resources/img/icons8-edit-128.png"><br>
										<span>Edit Profile</span>
									</a>
								</div>
								<div class="memberdelete">
									<a href="memberDelete?id=${loginUser }" onclick="return delOk()">
										<img src="/resources/img/icons8-delete-128.png"><br>
										<span>Withdrawal</span>
									</a>
							    </div>
                            </div>
                        </div>
                    </div>
                </div>

<%@include file="../includes/footer.jsp" %>