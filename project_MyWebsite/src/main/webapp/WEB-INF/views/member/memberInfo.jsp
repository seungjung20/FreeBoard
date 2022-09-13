

<%@include file="../includes/imgHeader.jsp" %>

    <div class="container">
        <!-- Outer Row -->
        <div class="row justify-content-center">
            <div class="col-xl-10 col-lg-12 col-md-9">
                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-password-image"></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-2">Profile</h1>
                                    </div>
                                    <form class="user" action="infoUpdate" method="post">
										<div class="form-group">
											ID<input type="text" class="form-control form-control-user" 
												name="memId" required="required" value="${info.memId }" readonly>
										</div>
										<div class="form-group">
											PW<input type="password" class="form-control form-control-user"
												name="memPass" required="required" value="${info.memPass }">
										</div>
										<div class="form-group">		
											NAME<input type="text" class="form-control form-control-user"
												name="memName" required="required" value="${info.memName }" readonly>
										</div>
										<div class="form-group">			
											EMAIL<input type="text" class="form-control form-control-user"
												name="memMail" value="${info.memMail }">
										</div>
										<hr>
										<button type="submit" class="btn btn-primary btn-user btn-block" onclick="return edit()">edit</button>
										<button type="button" class="btn btn-google btn-user btn-block" onclick="location.href='mypage'">back</button>
									</form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
<%@include file="../includes/imgFooter.jsp" %> 
    
