<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglib.jsp"%>
<p class="bg-success">${message}</p>
<table class="table">
    <tbody>
        <tr>
            <th><img src="/images/Logo.jpg" alt="Techie"
                     style="width: 304px; height: 228px;"></th>
            <th>
                <h1>${user.name}</h1>
                <button type="button" class="btn btn-primary btn-lg"
                        data-toggle="modal" data-target="#myModal">New Article</button>
            </th>
        </tr>
    </tbody>
</table>
<!-- Button trigger modal -->

<form:form commandName="blog"
           cssClass="form-horizontal registrationForm">
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">New Article</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">Title:</label>
                        <div class="col-sm-10">
                            <form:input path="name" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="url" class="col-sm-2 control-label">URL:</label>
                        <div class="col-sm-10">
                            <form:input path="url" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="category" class="col-sm-2 control-label">CATEGORY:</label>
                        <div class="col-sm-10">
                            <form:select path="category" cssClass="form-control">
                                <form:option selected="selected" value="java">JAVA</form:option>
                                <form:option value="weblogic">WEBLOGIC</form:option>
                                <form:option value="security">SECURITY</form:option>
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
                            <textarea name="description" id="description"
                                      class="form-control" rows="15"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="url" class="col-sm-2 control-label">Video URL:</label>
                        <div class="col-sm-10">
                            <form:input path="vurl" cssClass="form-control" />
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

<script>
    CKEDITOR.replace('description');
</script>
<hr>
<!-- Nav tabs -->
<ul class="nav nav-pills" role="tablist">
    <li role="presentation" class="active"><a href="#home"
                                              aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
    <li role="presentation"><a href="#profile" aria-controls="profile"
                               role="tab" data-toggle="tab">Profile</a></li>
    <li role="presentation"><a href="#settings"
                               aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
</ul>

<!-- Tab panes -->
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
        <c:forEach items="${blogs.content}" var="blog">
            <hr>

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>${blog.name}</h3>
                    <a href="/blog/edit/${blog.blogId}"> <span
                            class="glyphicon glyphicon-edit" aria-hidden="true"></span></a>
                </div>
                <div class="panel-body">
                    <p>
                        Reference URL :<a href="${blog.url}">${blog.url}</a> <br>
                        Published Date : ${blog.publishedDate} <br>
                        <c:if test="${blog.isApproved() eq true}">	
                            Approved : YES  
                        </c:if>
                        <c:if test="${blog.isApproved() eq false}">	
                            Approved : NO 
                        </c:if>
                    </p>
                    <hr>
                </div>
                <div class="panel-body">${blog.description}</div>

            </div>

            <a
                href='<spring:url value="/blog/remove/${user.userId}/${blog.blogId}"></spring:url>'
                    class="btn btn-danger">Remove Article</a>

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
                        <c:url var="pageUrl" value="/account/${i}" />
                        <c:choose>
                            <c:when test="${i == currentIndex}">
                            <li class="active"><a href="${pageUrl}"><c:out
                                        value="${i}" /></a></li>
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
    </div>
    <div role="tabpanel" class="tab-pane" id="profile">
        <h1>${user.name}</h1>
        <p>${user.email}</p>

    </div>
    <div role="tabpanel" class="tab-pane" id="settings">...</div>
</div>

<script type="text/javascript">
    $(document).ready(function () {

        $(".registrationForm").validate(
                {
                    rules: {
                        name: {
                            required: true,
                            minlength: 3
                        },
                        url: {
                            required: false,
                            url: true
                        },
                        vurl: {
                            required: false,
                            url: true
                        }
                    },
                    highlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },
                    unhighlight: function (element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    });
</script>