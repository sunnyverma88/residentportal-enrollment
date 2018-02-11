<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layouts/taglib.jsp" %>

<table class="table table-bordered table-striped table-hover">
<thead>
<tr>
<th>UserName</th>
<th>Opertaion</th>
</tr>
</thead>

<tbody>
<c:forEach items="${users}" var="user">
<tr>
<td>
<a href="<spring:url value="/users/${user.userId}/1"/> ">
${user.name}
</a>
</td>
<td>
<a href='<spring:url value="/users/remove/${user.userId}"></spring:url>' class="btn btn-danger" >Remove User</a>
</td>
</c:forEach>
</tbody>
</table>