<%
String app = request.getParameter("application");
	System.out.println("web/naviox/signIn.jsp,  request.getParameter(application)" + request.getParameter("application"));
%>
<div id="sign_in_box">
	<jsp:include page='<%="../xava/module.jsp?application=" + app + "&module=SignIn"%>'/>
</div>

