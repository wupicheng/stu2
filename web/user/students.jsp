<%--
  Created by IntelliJ IDEA.
  User: wupicheng
  Date: 15-5-13
  Time: 上午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">

    <h1 class="page-title">Users</h1>
    <ul class="breadcrumb">
        <li><a href="index.html">Home</a> </li>
        <li class="active">Users</li>
    </ul>

</div>
<div class="main-content">

    <div class="btn-toolbar list-toolbar">
        <button class="btn btn-primary"><i class="fa fa-plus"></i> New User</button>
        <button class="btn btn-default">Import</button>
        <button class="btn btn-default">Export</button>
        <div class="btn-group">
        </div>
    </div>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>学生姓名</th>
            <th>学生电话</th>
            <th>学生地址</th>
            <th>性别</th>
            <th style="width: 3.5em;"></th>
        </tr>
        </thead>
        <tbody>
         <c:forEach items="${students}" var="student">
        <tr>
            <td>${student.student_id}</td>
            <td>${student.student_name}</td>
            <td>${student.student_phone}</td>
            <td>${student.student_address}</td>
            <td>${student.student_sex}</td>
            <td>
                <a href="/user/studentAction!editStudent.do?student_id=${student.student_id}"><i class="fa fa-pencil"></i></a>
                <a href="#myModal" role="button" data-toggle="modal"><i class="fa fa-trash-o"></i></a>
            </td>
        </tr>
         </c:forEach>
        </tbody>
    </table>

    <ul class="pagination">
        <li><a href="/user/studentAction!queryAll.do?currentPageNum=1">&laquo;</a></li>
        <c:forEach begin="1" end="${pageObject.totalPageNum}" var="num">
            <li><a href="/user/studentAction!queryAll.do?currentPageNum=${num}">${num}</a></li>
        </c:forEach>


        <li><a href="/user/studentAction!queryAll.do?currentPageNum=${pageObject.totalPageNum}">&raquo;</a></li>
    </ul>

    <div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Delete Confirmation</h3>
                </div>
                <div class="modal-body">
                    <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the user?<br>This cannot be undone.</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
                    <button class="btn btn-danger" data-dismiss="modal">Delete</button>
                </div>
            </div>
        </div>
    </div>



</div>