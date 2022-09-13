<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>registerView</title>
<script>
	$(document).ready(function() {

	});
	function duplicate() {
		var memberEamil = $("#memberEmail").val();

		/* var submitObj에 입력한 email값이 담기고, ajax부분이 실행되어 /member/emailCnt컨트롤러로 json문자열로 값을 변환한다. */
		var submitObj = new Object();
		submitObj.memberEmail = memberEmail;

		$.ajax({
			url : "/member/emailCnt",
			type : "POST",
			contentType : "application/json; charset-utf-8",
			data : JSON.stringify(submitObj),
			dataType : "json"
		/* 컨트롤러로부터 넘어온 resMap이라는 결과값을 done 함수에 파라미터로 넣어주고, 
		아까 키로 설정했던 res와 iniCnt를 이용해서 중복여부를 검사한다. */
		}).done(function(resMap) {
			if (resMap.res == "ok") {
				if (resMap.emailCnt == 0) {
					/* Y가 담기면 뒤의 y n여부를 따지는 fuSubmit()에서 넘어가게 된다. */
					alert("사용할 수 있는 이메일입니다.");
					$("#memberEmail_check").val("Y");
				} else {
					alert("중복된 이메일입니다.");
					$("#memberEmail_check").val("N");
				}
			}
		}).fail(function(e) {
			alert("등록 시도에 실패하였습니다." + e);
		}).always(function() {
			pass = false;
		});
	}

	function fnSubmit() {
		var email_rule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

		if ($("#memberEmail").val() == null || $("#memberEmail").val() == "") {
			alert("이메일을 입력하세요.");
			$("#memberEmail").focus();
			return false;
		}

		if ($("#memberPw").val() == null || $("#memberPw").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#memberPw").focus();
			return false;
		}

		if ($("#memberPw2").val() == null || $("#memberPw2").val() == "") {
			alert("비밀번호 확인을 입력하세요.");
			$("#memberPw2").focus();
			return false;
		}

		if ($("#memberPw").val() != $("#memberPw2").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#memberPw2").focus();
			return false;
		}

		if (confirm("회원가입 하겠습니까?")) {
			$("#join").submit();
			return false;
		}
	}
</script>
</head>
<body>
	<form id="join" method="post" action="/member/register">
		<input type="hidden" id="memberEmail_check" name="memberEamil_check"
			value="N" />
		<div class="form-group row">
			<div class="col-sm-6 mb-3 mb-sm-0">
				<input type="text" class="form-control form-control-user"
					name="memberEmail" placeholder="이메일을 입력하세요" id="memberEmail">
			</div>
			<div class="col-sm-4 mb-3 mb-sm-0">
				<a href="#" class="btn btn-success btn-icon-split"
					style="text-align: center;" onclick="duplicate(); return false;">
					<span class="icon text-white-30"><i class="fas fa-check"></i>
				</span> <span class="text">중복체크</span>
				</a>
			</div>
		</div>

		<div class="mb-4">
			<input type="text" class="form-control form-control-user"
				name="memberPw" placeholder="비밀번호를 입력하세요" id="memberPw">
		</div>
		<div class="mb-4">
			<input type="text" class="form-control form-control-user"
				name="memberPw2" placeholder="비밀번호를 확인" id="memberPw2">
		</div>
		<div class="checkbox emailCheck">
			<label> <input type="checkbox"><a href="#">약관</a>에 동의
			</label>
		</div>
		<button class="btn btn-primary btn-user btn-block" type="button"
			onclick="fnSubmit(); return false;">가입</button>
	</form>
</body>
</html>