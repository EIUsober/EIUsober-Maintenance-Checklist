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
        <c:set var="m" value="${machine}"/>
        <form role="form" action="ManageControl?mode=editing" method="post" style="margin-left: 200px; width: 600px">
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Name</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getName()}" name="name"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Asset No.</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getAssetNo()}" name="assetNo"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Department</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getDepartment()}" name="department"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label">Location</label>
                <div class="col-lg-9">
                    <input class="form-control" type="text" value="${m.getLocation()}" name="location"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-lg-3 col-form-label form-control-label"></label>
                <div class="col-lg-9">
                    <a href="ManageControl?mode=view" class="btn btn-dark">Cancel</a>
                    <input type="submit" class="btn btn-primary" value="Save Changes" />
                    <a href="ManageControl?mode=delete&assetNo=${m.getAssetNo()}" class="btn btn-danger" onclick="if (confirm('Are you sure to delete this item?')) { window.location.href = this.href; } else { return false; }">Delete</a>
                </div>
            </div>
        </form>
    </div>
</div>
    </body>
</html>
