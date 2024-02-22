<%-- 
    Document   : Edit
    Created on : Jan 9, 2024, 4:50:02 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
                <link rel="stylesheet" type="text/css" href="View/styles/bootstrap4/bootstrap.min.css">

    </head>
    <body>
        <div class="container">
    <!-- edit form column -->
    <div class="col-lg-12 text-lg-center">
        <br>
        <br>
        <br>
        <h2>Edit Information</h2>
        <br>
        <br>
    </div>
    <div class="col-lg-8 push-lg-4 personal-info">
        <c:set var="m" value="${acc}"/>
        <form action="ManageControl?mode=editUser" method="post" style="margin-left: 200px; width: 600px">
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Username</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getUsername()}" name="username"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Password</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getPassword()}" name="password"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Department</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getDepartment()}" name="department"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Account ID</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getAccountID()}" name="accountID" disabled=""/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label"></label>
                <div class="col-lg-9">
                    <a href="ManageControl?mode=getAccounts" class="btn btn-dark">Cancel</a>
                    <input type="submit" class="btn btn-primary" value="Save Changes" />
                </div>
            </div>
        </form>
    </div>
</div>
    </body>
</html>
