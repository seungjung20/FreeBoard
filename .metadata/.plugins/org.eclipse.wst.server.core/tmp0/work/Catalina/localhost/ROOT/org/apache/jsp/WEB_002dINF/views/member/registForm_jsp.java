/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.60
 * Generated at: 2022-09-14 04:29:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class registForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/member/../includes/imgFooter.jsp", Long.valueOf(1661409177888L));
    _jspx_dependants.put("/WEB-INF/views/member/../includes/imgHeader.jsp", Long.valueOf(1663129605898L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("	<script>\r\n");
      out.write("	\r\n");
      out.write("	var idC = false; // 회원가입시 아이디가 중복일 경우 회원가입이 안되게 설정하기 위한 값\r\n");
      out.write("					 // (아이디 중복=false=회원가입 불가, 아이디 사용가능=true=회원가입 가능)\r\n");
      out.write("	var pwC = false; // 회원가입시 비밀번호 확인에서 불일치 할 경우 회원가입이 안되게 설정하기 위한 값\r\n");
      out.write("					 // (비밀번호 불일치=false=회원가입 불가, 비밀번호 일치=true=회원가입 가능)\r\n");
      out.write("	\r\n");
      out.write("	/* 비밀번호 확인 */\r\n");
      out.write("	function passConfirm() {\r\n");
      out.write("	// 비밀번호, 비밀번호 확인 입력창에 입력된 값을 비교해서 같다면 비밀번호 일치(correct), 그렇지 않으면 불일치(wrong) 라는 텍스트 출력\r\n");
      out.write("		var pw = document.getElementById(\"pw1\").value;				// 비밀번호 value의 값\r\n");
      out.write("		var pwConfirm = document.getElementById(\"pw2\").value;		// 비밀번호 확인 value의 값\r\n");
      out.write("		var pwConfirmMsg = document.getElementById(\"pwConfirmMsg\");	// 확인 메시지\r\n");
      out.write("		var correctColor = \"#4e73df\";								// 맞았을 때 출력되는 색깔\r\n");
      out.write("		var wrongColor = \"#ff0000\";									// 틀렸을 때 출력되는 색깔\r\n");
      out.write("		\r\n");
      out.write("		if(pw == pwConfirm){						 // pw 변수의 값과 pwConfirm 변수의 값이 동일하다면\r\n");
      out.write("			pwConfirmMsg.style.color = correctColor; // span 태그의 ID(pwConfirmMsg)를 사용하여 style.color 적용\r\n");
      out.write("			pwConfirmMsg.innerHTML =\"correct\";		 // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용\r\n");
      out.write("			pwC = true; 							 // 비밀번호 확인에서 일치하여 회원가입 가능하도록 설정\r\n");
      out.write("			return pwC; \r\n");
      out.write("		}else{									   // pw 변수의 값과 pwConfirm 변수의 값이 다르다면						\r\n");
      out.write("			pwConfirmMsg.style.color = wrongColor; // span 태그의 ID(confirmMsg) 사용하여 style.color 적용\r\n");
      out.write("			pwConfirmMsg.innerHTML =\"wrong\";       // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용\r\n");
      out.write("			pwC = false; 						   // 비밀번호 확인에서 불일치하여 회원가입 불가능하도록 설정\r\n");
      out.write("			return pwC;\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 아이디 확인 */\r\n");
      out.write("	function idCheck() {\r\n");
      out.write("	// 아이디 입력창에 입력된 값이 DB테이블에 mem_id와 같다면 아이디 사용가능(can be used), 그렇지 않으면 사용불가(can't be used) 라는 텍스트 출력\r\n");
      out.write("		var id = $(\"#id\").val(); 			  						// 아이디 value의 값\r\n");
      out.write("		var idConfirmMsg = document.getElementById(\"idConfirmMsg\"); // 확인 메시지\r\n");
      out.write("		var correctColor = \"#4e73df\"; 		  						// 맞았을 때 출력되는 색깔\r\n");
      out.write("		var wrongColor = \"#ff0000\";   		   						// 틀렸을 때 출력되는 색깔\r\n");
      out.write("		\r\n");
      out.write("		$.ajax({\r\n");
      out.write("			url : \"/member/idCheck\", 	 // 요청이 전송될 url 주소\r\n");
      out.write("			type : \"post\",           	 // HTTP 요청 방식 (default : 'get')\r\n");
      out.write("			data : {id: id},         	 // 요청시 포함되어질 데이터\r\n");
      out.write("			success : function(result) { // 정상적으로 응답 받았을 경우 success 콜백이 호출됨\r\n");
      out.write("				if(result == 0) {							 // result 값이 0일 경우\r\n");
      out.write("					idConfirmMsg.style.color = correctColor; // span 태그의 ID(idConfirmMsg)를 사용하여 style.color 적용\r\n");
      out.write("					idConfirmMsg.innerHTML = \"can be used\";  // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용\r\n");
      out.write("					idC = true; 						  	 // 아이디 중복확인에서 중복되지 않아 회원가입 가능하도록 설정\r\n");
      out.write("					return idC;\r\n");
      out.write("				} else {									  // result 값이 0이 아닐 경우\r\n");
      out.write("					idConfirmMsg.style.color = wrongColor;    // span 태그의 ID(idConfirmMsg)를 사용하여 style.color 적용\r\n");
      out.write("					idConfirmMsg.innerHTML = \"can't be used\"; // innerHTML : HTML 내부에 추가적인 내용을 넣을 때 사용\r\n");
      out.write("					idC = false; 							  // 아이디 중복확인에서 중복되어 회원가입 불가능하도록 설정\r\n");
      out.write("					return idC;\r\n");
      out.write("				}\r\n");
      out.write("			},\r\n");
      out.write("			error:function(){ 		 // 응답을 받지 못하였다거나 정상적인 응답이지만 데이터 형식을 확인할 수 없는 경우 error 콜백이 호출됨\r\n");
      out.write("	            alert(\"에러입니다\"); // 메시지 알람 출력\r\n");
      out.write("			}    \r\n");
      out.write("		})\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	/* 회원가입 */\r\n");
      out.write("	function formCheck(form){\r\n");
      out.write("	// 회원가입 요청시 이하 조건문에 해당하는 경우 포커스되며 모든 조건문에 해당하지 않을 경우 form을 submit함	\r\n");
      out.write("		if(form.name.value == \"\"){ // 이름 value의 값이 null 일 경우\r\n");
      out.write("			form.name.focus();     // 이름 입력란으로 커서 이동\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		if(form.id.value == \"\" || idC == false){ // 아이디 value의 값이 null 이거나 아이디 중복확인에서 중복일 경우\r\n");
      out.write("			form.id.focus();					 // 아이디 입력란으로 커서 이동 \r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		if(form.pw1.value == \"\"){ // 비밀번호 value의 값이 null 일 경우\r\n");
      out.write("			form.pw1.focus();	  // 비밀번호 입력란으로 커서 이동\r\n");
      out.write("			return ;		\r\n");
      out.write("		}\r\n");
      out.write("		if(form.pw2.value == \"\" || pwC == false){ // 비밀번호 확인 value의 값이 null 이거나 비밀번호 확인에서 불일치한 경우\r\n");
      out.write("			form.pw2.focus();					  // 비밀번호 확인 입력란으로 커서 이동\r\n");
      out.write("			return ;		\r\n");
      out.write("		}\r\n");
      out.write("		if(form.email.value == \"\"){ // 이메일 value의 값이 null 일 경우\r\n");
      out.write("			form.email.focus();		// 이메일 입력란으로 커서 이동\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		alert(\"회원가입이 완료되었습니다.\"); // 메시지 알람 출력\r\n");
      out.write("		form.submit();						 \r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	/* 회원정보 수정 */\r\n");
      out.write("	function edit() {\r\n");
      out.write("		if(confirm(\"수정 하시겠습니까?\")){ // 메시지 확인, 취소창 출력\r\n");
      out.write("			return true;\r\n");
      out.write("		} else {\r\n");
      out.write("			return false;\r\n");
      out.write("		}\r\n");
      out.write("	}\r\n");
      out.write("	\r\n");
      out.write("	</script>\r\n");
      out.write("\r\n");
      out.write("    <meta charset=\"utf-8\">\r\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("    <meta name=\"description\" content=\"\">\r\n");
      out.write("    <meta name=\"author\" content=\"\">\r\n");
      out.write("    <title>My Website</title>\r\n");
      out.write("    <!-- Custom fonts for this template-->\r\n");
      out.write("    <link href=\"/resources/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- Custom styles for this template-->\r\n");
      out.write("    <link href=\"/resources/css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body class=\"bg-gradient-primary\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"card o-hidden border-0 shadow-lg my-5\">\r\n");
      out.write("            <div class=\"card-body p-0\">\r\n");
      out.write("                <!-- Nested Row within Card Body -->\r\n");
      out.write("                <div class=\"row\">\r\n");
      out.write("                    <div class=\"col-lg-5 d-none d-lg-block bg-register-image\"></div>\r\n");
      out.write("                    <div class=\"col-lg-7\">\r\n");
      out.write("                    	<div class=\"text-center\">\r\n");
      out.write("                            <h1 class=\"h4 text-gray-900 mb-4 registTitle\">Create an Account!</h1>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"p-5-registForm\">\r\n");
      out.write("                            <form class=\"user registForm\" action=\"regist\" method=\"post\">\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <input type=\"text\" class=\"form-control form-control-user\" name=\"memName\"\r\n");
      out.write("                                    id=\"name\" placeholder=\"Name\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group registIdDiv\">\r\n");
      out.write("                                    <div class=\"registInput\">\r\n");
      out.write("                                    	<input type=\"text\" class=\"form-control form-control-user\" name=\"memId\"\r\n");
      out.write("                                    	id=\"id\" placeholder=\"Id\" oninput=\"idCheck()\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"registSpan\">\r\n");
      out.write("                                    	<span id=\"idConfirmMsg\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group registPwDiv\">\r\n");
      out.write("                                    <div class=\"registPw registInput\">\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control form-control-user\" name=\"memPass\"\r\n");
      out.write("                                        id=\"pw1\" placeholder=\"Password\">\r\n");
      out.write("                                        <input type=\"password\" class=\"form-control form-control-user\"\r\n");
      out.write("                                        id=\"pw2\" placeholder=\"Repeat Password\" onkeyup=\"passConfirm()\">\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"registSpan\">\r\n");
      out.write("                                    	<span id=\"pwConfirmMsg\"></span>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <div class=\"form-group\">\r\n");
      out.write("                                    <input type=\"email\" class=\"form-control form-control-user\" name=\"memMail\"\r\n");
      out.write("                                    id=\"email\" placeholder=\"Email Address\">\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-primary btn-user btn-block\" onclick=\"formCheck(this.form)\">Register Account</button>\r\n");
      out.write("                            </form>\r\n");
      out.write("                            <hr>\r\n");
      out.write("                            <div class=\"text-center\">\r\n");
      out.write("                                <a class=\"small\" href=\"login\">Already have an account? Login!</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"text-center\">\r\n");
      out.write("                                <a class=\"small\" href=\"../index\">Home!</a>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("	\r\n");
      out.write("    <!-- Bootstrap core JavaScript-->\r\n");
      out.write("    <script src=\"/resources/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"/resources/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    <!-- Core plugin JavaScript-->\r\n");
      out.write("    <script src=\"/resources/vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("    <!-- Custom scripts for all pages-->\r\n");
      out.write("    <script src=\"/resources/js/sb-admin-2.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("    \r\n");
      out.write("    \r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
