<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layouts/taglib.jsp" %>
<div class="container">
<div class="blog-header"> 
<div class="txt">
<div style="text-align: center;">
        <span style="font-family:'Lucida Bright', Georgia, serif;">
        <span style="font-size:55px;">
<p class="lead blog-description"><u><b>Please post your technical queries below. Our Experts will email you with the advise as soon as possible.</u></p>
</span>
</span>
<hr>
<form:form commandName="contact" cssClass="form-horizontal">

<c:if test="${param.success eq true}">
<div class="alert alert-success">${param.message}</div>
</c:if>
  <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Name:</label>
    <div class="col-sm-10">
     <form:input path="name" cssClass="form-control" />
    </div>
  </div>
  <div class="form-group">
    <label for="email" class="col-sm-2 control-label">Email:</label>
    <div class="col-sm-10">
     <form:input path="email" cssClass="form-control" />
    </div>
  </div>
  <div class="form-group">
    <label for="query" class="col-sm-2 control-label">Query:</label>
    <div class="col-sm-10">
     <textarea name="query" id="query" class="form-control" rows="5"></textarea>
    </div>
    <div>
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

<script>
            CKEDITOR.replace( 'query' );
        </script>







