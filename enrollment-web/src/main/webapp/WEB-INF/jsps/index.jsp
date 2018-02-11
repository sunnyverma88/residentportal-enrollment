<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>

<c:forEach items="${blogs.content}" var="blog">

<div class="panel panel-info">
  <div class="panel-heading">
    <h3><a href="/blog/${blog.blogId}" target="_blank">${blog.name}</a>
    <a href="/blog/${blog.blogId}">
 <span class="glyphicon glyphicon-new-window" aria-hidden="true"></span></a>
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
    Published Date : ${blog.publishedDate}
   </p> 
   <hr> 
<%-- <p>${blog.description} </p> --%>

<%-- <c:set var="string1" value="${blog.description}"/>
<c:set var="string2" value="${fn:substring(string1, 0,300)}" />
${string2} --%>
<a href="/blog/${blog.blogId}">
 Read More .....</a>
<c:if test="${not empty blog.vurl}">
   <!-- 4:3 aspect ratio -->
<div class="embed-responsive embed-responsive-4by3">
  <iframe class="embed-responsive-item" src="${blog.vurl}"></iframe>
</div>
</c:if>
</div>
</div>

<hr>
</c:forEach>

<c:url var="firstUrl" value="/index/1" />
<c:url var="lastUrl" value="/index/${blogs.totalPages}" />
<c:url var="prevUrl" value="/index/${currentIndex - 1}" />
<c:url var="nextUrl" value="/index/${currentIndex + 1}" />

<nav>
  <ul class="pagination">
    
        <c:choose>
            <c:when test="${currentIndex == 1}">
                <li class="disabled"><a href="#">&lt;&lt;</a></li>
                <li class="disabled"><a href="#">&lt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${firstUrl}">&lt;&lt;</a></li>
                <li><a href="${prevUrl}">&lt;</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach var="i" begin="${beginIndex}" end="${endIndex}">
            <c:url var="pageUrl" value="/index/${i}" />
            <c:choose>
                <c:when test="${i == currentIndex}">
                    <li class="active"><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="${pageUrl}"><c:out value="${i}" /></a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:choose>
            <c:when test="${currentIndex == blogs.totalPages}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:when test="${blogs.totalPages== 0}">
                <li class="disabled"><a href="#">&gt;</a></li>
                <li class="disabled"><a href="#">&gt;&gt;</a></li>
            </c:when>
            <c:otherwise>
                <li><a href="${nextUrl}">&gt;</a></li>
                <li><a href="${lastUrl}">&gt;&gt;</a></li>
            </c:otherwise>
        </c:choose>
   </ul>
</nav>

	
	<!-- Your share button code -->
	
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
  

  function submitAction(pageUrl)
  {	
  window.location.href=pageUrl; 
  }	

</script>



