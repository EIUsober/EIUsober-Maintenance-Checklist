<%-- 
    Document   : newjsp
    Created on : Jan 9, 2024, 2:21:14 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Machine"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Manage Account</title>
        <link rel="stylesheet"  href="View/styles/responsive.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="View/styles/manage.css">
        <style>
            /*            input[type="password"] {
                            -webkit-text-security: square;
                        }*/
        </style>
    </head>
    <body>
        <p class="${messageDis==null ? " ": "alert-success alert" }" style="size: 30px">${messageDis}</p>
        <p class="${messagePass==null ? " ": "alert-success alert" }" style="size: 30px">${messagePass}</p>
        <p class="${message==null ? " ": "alert-success alert" }" style="size: 30px">${message}</p>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage Account</h2>
                            </div>
                            <div class="col-sm-6">

                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add User</span></a>
                                <a href="ManageControl?mode=getAccounts" class="btn btn-danger"><i class="material-icons">&#xe5d5;</i> <span>Refresh</span></a>
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Username</th>
                                <th><div style="display: flex" id="show_hide_password">
                                        Password
                                        <div class="input-group-addon">
                                            <a href=""><i class="fa fa-eye-slash" aria-hidden="true"></i></a>
                                        </div>
                                    </div></th>
                                <th>Department</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${acc}" var ="m">
                                <tr>
                                    <td>${m.getAccountID()}</td>
                                    <td>${m.getUsername()}</td>
                                    <td  style="display: inline-flex"><div class="input-group" id="show_hide_password">
                                            <input type="password" value="${m.getPassword()}" style="width: 80px" disabled="">
                                        </div>
                                        <a href="LoginControl?mode=resetPassword&accountID=${m.getAccountID()}" onclick="if (confirm('Are you sure to reset password this user?')) {
                                                    window.location.reload();
                                                } else {
                                                    return false;
                                                }"><i class="fa fa-wrench" aria-hidden="true"></i></a> </td>
                                    <td>${m.getDepartment()}</td>
                                    <td>
                                        <c:if test="${m.getIsActive() == 1}">
                                            <a href="LoginControl?mode=disableUser&accountID=${m.getAccountID()}" class="material-icons" data-toggle="tooltip" title="Disable" onclick="if (confirm('Are you sure to disable this item?')) {
                                                        window.location.reload();
                                                    } else {
                                                        return false;
                                                    }">&#xf230;</a>
                                        </c:if>
                                        <c:if test="${m.getIsActive() != 1}">
                                            <a href="LoginControl?mode=enableUser&accountID=${m.getAccountID()}" class="material-icons" data-toggle="tooltip" title="Enable" onclick="if (confirm('Are you sure to enable this item?')) {
                                                        window.location.reload();
                                                    } else {
                                                        return false;
                                                    }">&#xe876;</a>
                                        </c:if>                                        
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div><a href="ManageControl?mode=view">< Back to Manage</a></div>
                        <ul class="pagination">
                            <li class="page-item disabled"><a href="#">Previous</a></li>
                            <li class="page-item"><a href="#" class="page-link">1</a></li>
                            <li class="page-item"><a href="#" class="page-link">2</a></li>
                            <li class="page-item active"><a href="#" class="page-link">3</a></li>
                            <li class="page-item"><a href="#" class="page-link">4</a></li>
                            <li class="page-item"><a href="#" class="page-link">5</a></li>
                            <li class="page-item"><a href="#" class="page-link">Next</a></li>
                        </ul>
                    </div>
                </div>
            </div>        
        </div>
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="LoginControl?mode=addUser" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add New</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Username</label>
                                <input type="text" class="form-control" required name="username">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="text" class="form-control" required name="password">
                            </div>
                            <div class="form-group">
                                <label>Department</label>
                                <input type="text" class="form-control" required name="department">
                            </div>
                            <div class="form-group">
                                <label>Account ID</label>
                                <input type="text" class="form-control" required name="accountID">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Add">
                        </div>
                    </form>
                </div>
            </div>
        </div>


        <script>
            $(document).ready(function () {
                $("#show_hide_password a").on('click', function (event) {
                    event.preventDefault();
                    if ($('#show_hide_password input').attr("type") == "text") {
                        $('#show_hide_password input').attr('type', 'password');
                        $('#show_hide_password i').addClass("fa-eye-slash");
                        $('#show_hide_password i').removeClass("fa-eye");
                    } else if ($('#show_hide_password input').attr("type") == "password") {
                        $('#show_hide_password input').attr('type', 'text');
                        $('#show_hide_password i').removeClass("fa-eye-slash");
                        $('#show_hide_password i').addClass("fa-eye");
                    }
                });
            });
        </script>
    </body>
</html>
