<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<div class="panel panel-info">
   <div class="panel-heading">
    <h3><a href="/blog/${blog.blogId}" target="_blank">${blog.name}</a>
    <a href="/">
 <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a>
    <br>
    <div class="fb-share-button pull-right"
		data-href="http://www.techieonthenet.com/blog/${blog.blogId}"
		data-desc="${blog.name}"
		data-layout="button_count">
	</div>
                 <div class="pull-right">
            <a href="https://www.linkedin.com/shareArticle?mini=true&url=http://www.techieonthenet.com/blog/${blog.blogId}&title=${blog.name}" target="_blank">
                <img src="/images/ldinlogo.jpg" style="width:100px;height20px" border="0" alt="Linkedin Logo"></a>
        </div>
	</h3>
  </div>
  <div class="panel-body" style="font-family: 'Lucida Bright', Georgia, serif;">
   <p>Reference URL :<a href="${blog.url}" target="_blank">${blog.url}</a>
   <br>
    Published By : ${blog.getUser().name} |
   Published Date : ${blog.publishedDate}</p> 
   <hr>
<p>${blog.description} </p>

<c:if test="${not empty blog.vurl}">
   <!-- 4:3 aspect ratio -->
<div class="embed-responsive embed-responsive-4by3">
  <iframe class="embed-responsive-item" src="${blog.vurl}"></iframe>
</div>
</c:if> 
</div>
<div class="panel-heading" style="font-family: 'Lucida Bright', Georgia, serif;">
<h4><b>Comments</b></h4>
 <security:authorize access="isAuthenticated()">
<button type="button" class="btn btn-sm btn-primary pull-right"  data-toggle="modal" data-target="#commentModal">
  Add Comment
</button>
<!-- <button type="button" class="btn btn-sm btn-primary pull-right"  data-toggle="modal" data-target="#documentModal">
  Add Document
</button> -->
</security:authorize>
</div>
<hr>
<c:forEach items="${comments}" var="comment">
<div class="well well-sm">
<p><b>${comment.getUser().name} :</b>  ${comment.commentDesc} 
</p>
</div>
</c:forEach>

<%-- <c:forEach items="${documents}" var="document">
<div class="well well-sm">
<a href='<spring:url value="/download/${blog.blogId}/${document.id}"></spring:url>'><p><b>${document.filename} </b></a>
</p>
</div>
</c:forEach> --%>

</div>
<form:form commandName="comment" cssClass="form-horizontal registrationForm">
<!-- Modal -->
<div class="modal fade" id="commentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="commentModalLabel">New Comment</h4>
      </div>
  <div class="modal-body">
  <div class="form-group">
    <label for="CommentDesc" class="col-sm-2 control-label">Comment:</label>
    <div class="col-sm-10">
     <form:textarea path="CommentDesc" cssClass="form-control" />
    </div>  
  </div>
  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" value="Save" class="btn btn-danger"></input>
      </div>
    </div>
  </div>
</div>
</form:form>
<%-- <form:form commandName="document"  cssClass="form-horizontal registrationForm" enctype="multipart/form-data">
<!-- Modal -->
<div class="modal fade" id="documentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="documentModalLabel">New Document</h4>
      </div>
  <div class="modal-body">
  <div class="form-group">
    <label for="content" class="col-sm-2 control-label">Upload File:</label>
    <div class="col-sm-10">
    <input type="file" name="file" id="file"></input>
    </div>  
  </div>
  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" value="Save" class="btn btn-danger"></input>
      </div>
    </div>
  </div>
</div>
</form:form>
 --%>
<script>

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '1498415003789263',
      xfbml      : true,
      version    : 'v2.5'
    });
  };

  (function(d, s, id){
     var js, fjs = d.getElementsByTagName(s)[0];
     if (d.getElementById(id)) {return;}
     js = d.createElement(s); js.id = id;
     js.src = "//connect.facebook.net/en_US/sdk.js";
     fjs.parentNode.insertBefore(js, fjs);
   }(document, 'script', 'facebook-jssdk'));
</script>


