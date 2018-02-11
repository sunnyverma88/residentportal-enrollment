<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layouts/taglib.jsp" %>
<div class="container">
<div class="blog-header"> 
<div class="txt">
<div style="text-align: center;">
<c:if test="${param.success eq true}">
<div class="alert alert-success">${param.message}</div>
</c:if>
<c:if test="${param.success eq false}">
<div class="alert alert-warning">${param.message}</div>
</c:if>
<form:form action="/user/regeneratePwd" commandName="fp" cssClass="form-horizontal">
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email:</label>
    <div class="col-sm-10">
     <form:input path="email" cssClass="form-control" />
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10" >
      <input type="submit" value="Submit" class="btn btn-danger"></input>
    </div>
  </div>
</form:form>
</div>
</div>
</div>
</div>








