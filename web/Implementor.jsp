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
        <style>
            .pagination {
                float: right;
                margin: 0 0 5px;
            }
            .pagination li a {
                border: none;
                font-size: 13px;
                min-width: 30px;
                min-height: 30px;
                color: #999;
                margin: 0 2px;
                line-height: 30px;
                border-radius: 2px !important;
                text-align: center;
                padding: 0 6px;
            }
            .pagination li a:hover {
                color: #666;
            }
            .pagination li.active a, .pagination li.active a.page-link {
                background: #03A9F4;
            }
            .pagination li.active a:hover {
                background: #0397d6;
            }
            .pagination li.disabled i {
                color: #ccc;
            }
            .pagination li i {
                font-size: 16px;
                padding-top: 6px
            }
            .hint-text {
                float: left;
                margin-top: 10px;
                font-size: 13px;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h2 style="text-align: center; margin-top: 30px">Ticket</h2>
            <form action="ManageControl?mode=viewTicket" method="get">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Ticket ID</th>
                            <th>Requester ID</th>
                            <th>Date</th>
                            <th>Status</th>
                            <th>Description</th>                             
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
                                        <input type="text" class="form-control" id="selectedItem" placeholder="${l.getStatus()}" disabled="">
                                        <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        </button>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="ManageControl?mode=updateStatus&id=${l.getTicketID()}&status=Executing" onclick="updateStatus()">Executing</a>
                                            <a class="dropdown-item" href="ManageControl?mode=updateStatus&id=${l.getTicketID()}&status=Done" onclick="updateStatus()">Done</a>
                                            <!-- Add more options as needed -->
                                        </div>
                                    </div>
                                </td>
                                <td>${l.getDescription()}</td>
                            </tr>
                            </c:forEach>
                        </tbody>    
                    </table>
                    <a href="ManageControl?mode=viewByDepartment" class="btn btn-info"> Cancel</a>
                    <a href="ManageControl?mode=viewTask" class="btn btn-success"> Refresh</a>
                </form>
            </div>
            <script>
                function updateStatus() {
                    if (confirm('Update Success!')) {
                        window.location.href = 'ManageControl?mode=viewTask';
                    } else {
                        return false;
                    }
                }
            </script>

        </body>

    </html>
