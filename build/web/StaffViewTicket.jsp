<%-- 
    Document   : ViewTicket
    Created on : Feb 1, 2024, 12:09:55 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ticket</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="View/styles/bootstrap4/bootstrap.min.css">
        <link href="View/plugins/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="View/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet"  href="View/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet"  href="View/plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet"  href="View/styles/main_styles.css">
        <link rel="stylesheet"  href="View/styles/responsive.css">
        <link rel="stylesheet" href="View/styles/scanner.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="View/styles/paging.css">
    </head>
    <body>
        <p class="${editSuccess==null ? " ": "alert-success alert" }" style="size: 30px">${editSuccess}</p>
        <p class="${deleteSuccess==null ? " ": "alert-danger alert" }" style="size: 30px">${deleteSuccess}</p>
        <div class="container">
            <h2 style="text-align: center; margin-top: 20px">Ticket</h2>
            <form action="ManageControl?mode=viewTicket" method="get">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Ticket ID</th>
                            <th>Requester ID</th>
                            <th>Date</th>
                            <th>Agent</th>
                            <th>Status</th>
                            <th>Description</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listT}" var="l">                          
                            <tr>
                                <td>${l.getTicketID()}</td>
                                <td>${l.getStaffID()}</td>
                                <td>${l.getDateTicket()}</td>
                                <td>
                                    <div class="dropdown" style="display: flex; width: 170px">
                                        <input type="text" class="form-control" id="selectedItem" placeholder="${l.getMaintenance()}" disabled="">
                                    </div>
                                </td>
                                <c:if test="${l.getStatus().equals('Undone')}">
                                    <td style="background-color: lightcoral">${l.getStatus()}</td>
                                </c:if>
                                <c:if test="${l.getStatus().equals('Done')}">
                                    <td style="background-color: lightgreen">${l.getStatus()}</td>
                                </c:if>
                                <c:if test="${l.getStatus().equals('Executing')}">
                                    <td style="background-color: yellow">${l.getStatus()}</td>
                                </c:if>
                                <td>${l.getDescription()}</td>
                                <td>
                                    <a href="ManageControl?mode=editTicket&id=${l.getTicketID()}"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>    
                </table>
                <a href="ManageControl?mode=viewByDepartment" class="btn btn-info"> Cancel</a>
                <a href="ManageControl?mode=staffViewTicket" class="btn btn-success"> Refresh</a>
            </form>
        </div>
        <div id="editTicket" class="modal fade">
            <div class="modal-dialog">
                <div class="modal-content">
                    <c:set var="l" value="${t}" />
                    <form action="ManageControl?mode=editingTicket" method="post">
                        <div class="modal-header">						
                            <h4 class="modal-title">Edit</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label>ID</label>
                                <input type="text" class="form-control" value="${l.getAccountID()}" name="id">
                            </div>
                            <div class="form-group">
                                <label>Date</label>
                                <input type="text" class="form-control" value="${l.getDateTicket()}" name="dateTicket">
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input type="text" class="form-control" value="${l.getDescription()}" name="description">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
                            <input type="submit" class="btn btn-success" value="Submit">
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <script>
            function updateSuccess() {
                if (confirm('Update Success!')) {
                    window.location.href = 'ManageControl?mode=viewTicket';
                } else {
                    return false;
                }
            }
        </script>

    </body>

</html>
