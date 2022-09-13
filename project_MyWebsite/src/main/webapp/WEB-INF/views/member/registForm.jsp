
<%@include file="../includes/imgHeader.jsp" %>

    <div class="container">
        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                    <div class="col-lg-7">
                    	<div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4 registTitle">Create an Account!</h1>
                        </div>
                        <div class="p-5-registForm">
                            <form class="user registForm" action="regist" method="post">
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" name="memName"
                                    id="name" placeholder="Name">
                                </div>
                                <div class="form-group registIdDiv">
                                    <div class="registInput">
                                    	<input type="text" class="form-control form-control-user" name="memId"
                                    	id="id" placeholder="Id" oninput="idCheck()">
                                    </div>
                                    <div class="registSpan">
                                    	<span id="idConfirmMsg"></span>
                                    </div>
                                </div>
                                <div class="form-group registPwDiv">
                                    <div class="registPw registInput">
                                        <input type="password" class="form-control form-control-user" name="memPass"
                                        id="pw1" placeholder="Password">
                                        <input type="password" class="form-control form-control-user"
                                        id="pw2" placeholder="Repeat Password" onkeyup="passConfirm()">
                                    </div>
                                    <div class="registSpan">
                                    	<span id="pwConfirmMsg"></span>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" name="memMail"
                                    id="email" placeholder="Email Address">
                                </div>
                                <button type="button" class="btn btn-primary btn-user btn-block" onclick="formCheck(this.form)">Register Account</button>
                            </form>
                            <hr>
                            <div class="text-center">
                                <a class="small" href="login">Already have an account? Login!</a>
                            </div>
                            <div class="text-center">
                                <a class="small" href="../index">Home!</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
<%@include file="../includes/imgFooter.jsp" %>    
    
