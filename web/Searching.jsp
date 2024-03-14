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
        <title>Manage</title>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="View/styles/manage.css">
    </head>
    <body>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-6">
                                <h2>Manage</h2>
                            </div>
                            <div class="col-sm-6">
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New</span></a>                                                      						
                            </div>
                            <div style="position: absolute; left: 35%">
                                <form action="ManageControl" method="get">
                                    <!--end of col-->
                                    <input style="display: none" name="mode" type="text" value="search">
                                    <input name="text" class=" form-control-borderless" type="text" placeholder="Search by Name" value="${value}">
                                    <button class="btn btn-dark" type="submit">
                                        <i class="fa fa-search" aria-hidden="true"></i>
                                    </button>
                                </form> 
                            </div>
                        </div>
                    </div>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Location</th>
                                <th>Name</th>
                                <th>Asset No.</th>
                                <th>Department</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listM}" var="m">
                                <tr>
                                    <td>${m.getLocation()}</td>
                                    <td>${m.getName()}</td>
                                    <td>${m.getAssetNo()}</td>
                                    <td>${m.getDepartment()}</td>
                                    <td>
                                        <a href="ManageControl?mode=edit&assetNo=${m.getAssetNo()}"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                        <a href="ManageControl?mode=StaffViewCheckList&assetNo=${m.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                                    </td>
                                </tr>
                            </c:forEach>                         
                        </tbody>
                    </table>
                    <div class="clearfix">
                        <div><a href="HomePage.jsp">< Back to Home</a></div>
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
        <!-- Edit Modal HTML -->
        <div id="addEmployeeModal" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <form action="ManageControl?mode=add" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Add New</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">					
                            <div class="form-group">
                                <label>Name</label>
                                <input type="text" class="form-control" required name="name">
                            </div>
                            <div class="form-group">
                                <label>Asset No.</label>
                                <input type="text" class="form-control" required name="assetNo">
                            </div>
                            <div class="form-group">
                                <label>Department</label>
                                <input type="text" class="form-control" required name="department">
                            </div>
                            <div class="form-group">
                                <label>Location</label>
                                <input type="text" class="form-control" required name="location">
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
    </body>
</html>
