<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<script>
	
	var idC = false; // 회원가입시 아이디가 중복일 경우 회원가입이 안되게 설정하기 위한 값
					 // (아이디 중복=false=회원가입 불가, 아이디 사용가능=true=회원가입 가능)
	var pwC = false; // 회원가입시 비밀번호 확인에서 불일치 할 경우 회원가입이 안되게 설정하기 위한 값
					 // (비밀번호 불일치=false=회원가입 불가, 비밀번호 일치=true=회원가입 가능)
	
	/* 비밀번호 확인 */
	function passConfirm() {
	// 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치(correct), 그렇지 않으면 불일치(wrong) 라는 텍스트 출력
		var pw = document.getElementById("pw1").value;				// 비밀번호 value의 값
		var pwConfirm = document.getElementById("pw2").value;		// 비밀번호 확인 value의 값
		var pwConfirmMsg = document.getElementById("pwConfirmMsg");	// 확인 메시지
		var correctColor = "#4e73df";								// 맞았을 때 출력되는 색깔
		var wrongColor = "#ff0000";									// 틀렸을 때 출력되는 색깔
		
		if(pw == pwConfirm){						 // pw 변수의 값과 pwConfirm 변수의 값이 동일하다면
			pwConfirmMsg.style.color = correctColor; // span 태그의 ID(pwConfirmMsg)를 사용하여 style.color 적용
			pwConfirmMsg.innerHTML ="correct";		 // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용
			pwC = true; 							 // 비밀번호 확인에서 일치하여 회원가입 가능하도록 설정
			return pwC; 
		}else{									   // pw 변수의 값과 pwConfirm 변수의 값이 다르다면						
			pwConfirmMsg.style.color = wrongColor; // span 태그의 ID(confirmMsg) 사용하여 style.color 적용
			pwConfirmMsg.innerHTML ="wrong";       // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용
			pwC = false; 						   // 비밀번호 확인에서 불일치하여 회원가입 불가능하도록 설정
			return pwC;
		}
	}
	
	/* 아이디 확인 */
	function idCheck() {
	// 아이디 입력창에 입력된 값이 DB테이블에 mem_id와 같다면 아이디 사용가능(can be used), 그렇지 않으면 사용불가(can't be used) 라는 텍스트 출력
		var id = $("#id").val(); 			  						// 아이디 value의 값
		var idConfirmMsg = document.getElementById("idConfirmMsg"); // 확인 메시지
		var correctColor = "#4e73df"; 		  						// 맞았을 때 출력되는 색깔
		var wrongColor = "#ff0000";   		   						// 틀렸을 때 출력되는 색깔
		
		$.ajax({
			url : "/member/idCheck", 	 // 요청이 전송될 url 주소
			type : "post",           	 // HTTP 요청 방식 (default : 'get')
			data : {id: id},         	 // 요청시 포함되어질 데이터
			success : function(result) { // 정상적으로 응답 받았을 경우 success 콜백이 호출됨
				if(result == 0) {							 // result 값이 0일 경우
					idConfirmMsg.style.color = correctColor; // span 태그의 ID(idConfirmMsg)를 사용하여 style.color 적용
					idConfirmMsg.innerHTML = "can be used";  // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용
					idC = true; 						  	 // 아이디 중복확인에서 중복되지 않아 회원가입 가능하도록 설정
					return idC;
				} else {									  // result 값이 0이 아닐 경우
					idConfirmMsg.style.color = wrongColor;    // span 태그의 ID(idConfirmMsg)를 사용하여 style.color 적용
					idConfirmMsg.innerHTML = "can't be used"; // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용
					idC = false; 							  // 아이디 중복확인에서 중복되어 회원가입 불가능하도록 설정
					return idC;
				}
			},
			error:function(){ 		 // 응답을 받지 못하였다거나 정상적인 응답이지만 데이터 형식을 확인할 수 없는 경우 error 콜백이 호출됨
	            alert("에러입니다"); // 메시지 알람 출력
			}    
		})
	}
	
	/* 회원가입 */
	function formCheck(form){
	// 회원가입 요청시 이하 조건문에 해당하는 경우 포커스되며 모든 조건문에 해당하지 않을 경우 form을 submit함	
		if(form.name.value == ""){ // 이름 value의 값이 null 일 경우
			form.name.focus();     // 이름 입력란으로 커서 이동
			return;
		}
		if(form.id.value == "" || idC == false){ // 아이디 value의 값이 null 이거나 아이디 중복확인에서 중복일 경우
			form.id.focus();					 // 아이디 입력란으로 커서 이동 
			return;
		}
		if(form.pw1.value == ""){ // 비밀번호 value의 값이 null 일 경우
			form.pw1.focus();	  // 비밀번호 입력란으로 커서 이동
			return ;		
		}
		if(form.pw2.value == "" || pwC == false){ // 비밀번호 확인 value의 값이 null 이거나 비밀번호 확인에서 불일치한 경우
			form.pw2.focus();					  // 비밀번호 확인 입력란으로 커서 이동
			return ;		
		}
		if(form.email.value == ""){ // 이메일 value의 값이 null 일 경우
			form.email.focus();		// 이메일 입력란으로 커서 이동
			return;
		}
		alert("회원가입이 완료되었습니다."); // 메시지 알람 출력
		form.submit();						 
	}
	
	
	/* 회원정보 수정 */
	function edit() {
		if(confirm("수정 하시겠습니까?")){ // 메시지 확인, 취소창 출력
			return true;
		} else {
			return false;
		}
	}
	
	</script>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>My Website</title>
    <!-- Custom fonts for this template-->
    <link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="/resources/css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body class="bg-gradient-primary">
