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
        <link rel="stylesheet"  href="View/styles/responsive.css">        
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="View/styles/manage.css">
        <style>
            #myPieChart {
                width: 100px;
                height: 100px;
            }

        </style>
    </head>
    <body>
        <p class="${editSuccess==null ? " ": "alert-success alert" }" style="size: 30px">${editSuccess}</p>
        <p class="${message2==null ? " ": "alert-danger alert" }" style="size: 30px">${message2}</p>
        <p class="${message==null ? " ": "alert-success alert" }" style="size: 30px">${message}</p>
        <div class="container-xl">
            <div class="table-responsive">
                <div class="table-wrapper">
                    <div class="table-title">
                        <div class="row">
                            <div class="col-sm-3">
                                <h2>Manage</h2>
                            </div>
                            <div class="col-sm-9" style="display: flex">
                                <div style="width: 30%">
                                    <form action="ManageControl?mode=search" method="post" style="display: flex">
                                        <!--end of col-->
                                        <input style="display: none" name="mode" type="text" value="search">
                                        <input style="width: 70%" name="text" class=" form-control-borderless" type="text" placeholder="Search here" value="${value}">                                    
                                        <button class="btn btn-dark" type="submit">
                                            <i class="fa fa-search" aria-hidden="true"></i>
                                        </button>
                                    </form> 
                                </div>
                                <a href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New</span></a>
                                <a href="ManageControl?mode=schedule" class="btn btn-info"><i class="material-icons">&#xebcc;</i> <span>Schedule</span></a>
                                <a href="ManageControl?mode=viewTicket" class="btn btn-danger"><i class="material-icons">&#xf1c5;</i> <span>View Ticket</span></a>
                                <a href="ManageControl?mode=getAccounts" class="btn btn-warning"><i class="material-icons">&#xe939;</i> <span>Users</span></a>                                
                            </div>

                        </div>
                    </div>

                    <c:if test="${searched == null}">
                        <canvas id="myPieChart"></canvas>
                        <input  value="${month1.size()}" hidden="" id="month1">
                        <input  value="${month2.size()}" hidden="" id="month2">
                        <input  value="${month3.size()}" hidden="" id="month3">
                        <br>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Recent Maintenance Machine: </h5>
                                        <h1 class="card-text" style="color: red">${listR.size()}</h1>
                                        <a href="MainControl?mode=history" class="btn btn-danger">View History</a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <div class="card">
                                    <div class="card-body">
                                        <h5 class="card-title">Unsolved Ticket: </h5>
                                        <h1 class="card-text" style="color: #FFC107">${tick.size()}</h1>
                                        <a href="ManageControl?mode=viewTicket" class="btn btn-warning">View Tickets</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <br>
                        <script>
                            var month1Ele = document.getElementById('month1');
                            var month2Ele = document.getElementById('month2');
                            var month3Ele = document.getElementById('month3');

                            var month1 = month1Ele.value;
                            var month2 = month2Ele.value;
                            var month3 = month3Ele.value;
                            var ctx = document.getElementById('myPieChart').getContext('2d');
                            var myPieChart = new Chart(ctx, {
                                type: 'pie',
                                data: {
                                    labels: ['January', 'February', 'March'],
                                    datasets: [{
                                            data: [month1, month2, month3],
                                            backgroundColor: ['red', 'blue', 'green']
                                        }]
                                },
                                options: {
                                    responsive: true,
                                    title: {
                                        display: true,
                                        text: 'Maintenance Activity in 1st Quater'
                                    }
                                }
                            });
                        </script>
                    </c:if>
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <th>Location</th>
                                <th>Name</th>
                                <th>Asset No.</th>
                                <th>Department</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${listM != null}">
                                <c:forEach items="${listM}" var="l">
                                    <tr>
                                        <td>${l.getLocation()}</td>
                                        <td>${l.getName()}</td>
                                        <td>${l.getAssetNo()}</td>
                                        <td>${l.getDepartment()}</td>
                                        <td>
                                            <a href="ManageControl?mode=edit&assetNo=${l.getAssetNo()}"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                            <a href="ManageControl?mode=ViewAssetChecklist&assetNo=${l.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${listM == null}">
                                <c:forEach items="${machine}" var ="m">
                                    <tr>
                                        <td>${m.getLocation()}</td>
                                        <td>${m.getName()}</td>
                                        <td>${m.getAssetNo()}</td>
                                        <td>${m.getDepartment()}</td>
                                        <td>
                                            <a href="ManageControl?mode=edit&assetNo=${m.getAssetNo()}"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                            <a href="ManageControl?mode=ViewAssetChecklist&assetNo=${m.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>

                        </tbody>
                    </table>
                    <a href="ManageControl?mode=allMachines" class="btn btn-info">View All Machines</a>
                </div>
            </div>        
            <div><a href="HomePage.jsp">< Back to Home</a></div>
            <br>
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
                            <div class="form-group">
                                <label>Category</label>
                                <input type="text" class="form-control" required name="category">
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
