<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../layouts/taglib.jsp" %>
<p class="bg-success">
<c:if test="${param.success eq true}">Blog Saved successfull!</div>
	</c:if>
	</p>
<form:form commandName="blog" cssClass="form-horizontal editForm">
   <div class="form-group">
    <label for="name" class="col-sm-2 control-label">Title:</label>
    <div class="col-sm-10">
     <form:input path="name" value="${blog.name}" cssClass="form-control" />
    </div>
  </div>
  <div class="form-group">
    <label for="url" class="col-sm-2 control-label">URL:</label>
    <div class="col-sm-10">
     <form:input path="url" value="${blog.url}" cssClass="form-control" />
    </div>  
  </div>
  <div class="form-group">
						<label for="category" class="col-sm-2 control-label">CATEGORY:</label>
						<div class="col-sm-10">
							<form:select path="category" cssClass="form-control">
								<form:option selected="selected" value="java">JAVA</form:option>
								<form:option value="weblogic">WEBLOGIC</form:option>
								<form:option value="maven">MAVEN</form:option>
								<form:option value="informatica">INFORMATICA</form:option>
								<form:option value="ssis">SSIS</form:option>
								<form:option value="ssrs">SSRS</form:option>
								<form:option value="spring-mvc">SPRING-MVC</form:option>
								<form:option value="spring-core">SPRING-CORE</form:option>
								<form:option value="jms">JMS</form:option>
								<form:option value="others">OTHERS</form:option>
							</form:select>
						</div>
					</div>
  <div class="form-group">
    <label for="url" class="col-sm-2 control-label">Description:</label>
    <div class="col-sm-10">
     <textarea name="description" id="description" class="form-control" rows="15">${blog.description}</textarea>
 </div> 
  </div>
   <div class="form-group">
    <label for="url" class="col-sm-2 control-label">Video URL:</label>
    <div class="col-sm-10">
      <form:input path="vurl" value="${blog.vurl}" cssClass="form-control" />
 </div> 
  </div>
<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <input type="submit" value="save" class="btn btn-danger"></input>
      <a href='<spring:url value="/account/1"></spring:url>' class="btn btn-danger" >Cancel</a> 
    </div>  
  </div>
</form:form>
<script type="text/javascript">
$(document).ready(function() {
	
	$(".editForm").validate(
		{
			rules: {
				name: {
					required : true,
					minlength : 3
				},
				url: {
					required : false,
					url: true
				},
				vurl: {
					required : false,
					url: true
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			}
		}
	);
});
   CKEDITOR.replace( 'description' );
        </script>