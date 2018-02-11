<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp" %>
<h1 class="page-header">Unapproved Articles</h1>
<c:forEach items="${blogs.content}" var="blog">

<div class="panel panel-info">
  <div class="panel-heading">
    <h3><a href="${blog.url}" target="_blank">${blog.name}</a></h3>
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
</div>

<c:if test="${blog.isApproved() eq false}">		
<security:authorize access="hasRole('ROLE_ADMIN')">
<a href='<spring:url value="/blog/approve/${blog.blogId}"></spring:url>' class="btn btn-danger" >Approve Article</a>
</security:authorize>
</c:if>
<hr>

</c:forEach>
<c:url var="firstUrl" value="/unapproved/1" />
<c:url var="lastUrl" value="/unapproved/${blogs.totalPages}" />
<c:url var="prevUrl" value="/unapproved/${currentIndex - 1}" />
<c:url var="nextUrl" value="/unapproved/${currentIndex + 1}" />

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
            <c:url var="pageUrl" value="/unapproved/${i}" />
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
             <c:when test="${blogs.totalPages == 0}">
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



