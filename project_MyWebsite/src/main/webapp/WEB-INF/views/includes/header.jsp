<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html lang="en">

<head>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

	<script>
	/* 로그아웃 */
	function logout(){
		if(confirm("로그아웃 하시겠습니까?")){ 			  // 메시지 확인, 취소창 출력
			location.href="${contextPath}/member/logout"; // 확인시 logout페이지 이동
		} else {
			return;
		}
	}
	
	/* 계정 삭제 */
	function delOk(){
		if(confirm("계정을 삭제하시겠습니까?")){ // 메시지 확인, 취소창 출력
			return true;
		} else{
			return false;
		}
	}
	
	/* 게시글 작성 */
	function Write() {
		if(confirm("글을 작성하시겠습니까?")){ // 메시지 확인, 취소창 출력
			return true;
		} else {
			return false;
		}
	}
	
	/* 게시글 수정 */
	function edit() {
		if(confirm("수정하시겠습니까?")){ // 메시지 확인, 취소창 출력
			return true;
		} else {
			return false;
		}
	}
	
	/* 게시글 삭제 */
	function Delete() {
		if(confirm("글을 삭제하시겠습니까?")){ // 메시지 확인, 취소창 출력
			return true;
		} else {
			return false;
		}
	}
	
	
	/* 원하는 페이지로 이동시 검색조건, 키워드 값을 유지하기 위해 */ 
    function freeListDo(page){
		// freeList.do 페이지로 이동하면서 현재페이지(curPage)와 검색옵션(searchOption)과 검색키워드(keyword)를 보냄
        location.href="${contextPath}/free/freeList.do?curPage="+page+"&searchOption=${map.searchOption}"+"&keyword=${map.keyword}";
    }
	
    function freeList(page){
    	// freeList 페이지로 이동하면서 현재페이지(curPage)를 보냄 
        location.href="${contextPath}/free/freeList?curPage="+page;
    }
	

	
	</script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>My Website</title>

    <!-- Custom fonts for this template -->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${contextPath }/index">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">HOME</div>
            </a>
            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="${contextPath }/free/freeList">
                    <i class="fas fa-fw fa-table"></i>
                    <span>BOARD</span>
                </a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>
        </ul>
        <!-- End of Sidebar -->
        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
					<c:if test="${empty loginUser }">
						<div class="right-navbar">
							<a class="link" href="${contextPath }/member/login">LOGIN</a>
							<div class="topbar-divider d-none d-sm-block"></div>
							<a class="link" href="${contextPath }/member/registForm">REGIST</a>
						</div>
					</c:if>
	              	<c:if test="${not empty loginUser }">
		              	<div class="right-navbar">
			              	<a class="link" href="#" onclick="logout()">LOGOUT</a>
			                <div class="topbar-divider d-none d-sm-block"></div>
			                <a class="link" href="${contextPath }/member/mypage">
			                    <span class="loginuser">${loginUser }</span>
			                    <img class="profile" src="/resources/img/icons8-contacts-64.png">
			                </a>
		                </div>
	                </c:if>
                </nav>
                <!-- End of Topbar -->