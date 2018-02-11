<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../layouts/taglib.jsp" %>
 <style>

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>
 
 <div class="container">
 <c:if test="${not empty error}">
		<div class="alert alert-danger">
			Your login attempt was not successful, try again. 
			Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
      <form class="form-signin" action="/j_spring_security_check" method="post">
      <c:if test="${param.success eq false}">
       <div class="alert alert-success">${param.message}</div>
      </c:if>
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" name="j_username" class="form-control" placeholder="Email" required autofocus>
        <input type="password" name="j_password" class="form-control" placeholder="Password" required>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
        <button class="btn btn-lg btn-primary btn-block" type="submit" value="Login">Sign in</button>
        <a href="/user/forgotpwd">Forgot Password ? </a> 
      </form>

    </div>