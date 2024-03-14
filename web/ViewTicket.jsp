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
        <style>
            .numberCircle {
                border-radius: 50%;
                width: 36px;
                height: 36px;
                padding: 4px;
                background: red;
                border: 2px solid #666;
                color: white;
                text-align: center;
                font: 15px Arial, sans-serif;
            }

        </style>
    </head>
    <body>
        <div class="container">
            <h2 style="text-align: center; margin-top: 20px">Ticket</h2>
            <c:if test="${account.getIsAdmin() != 1}">
                <button class="btn btn-success"><a href="ManageControl?mode=viewTask" style="color: white">Your Task </a><span class="numberCircle">${u}</span></button>
            </c:if>
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
                                        <c:if test="${account.getIsAdmin() == 1}" >
                                            <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            </button>
                                        </c:if>
                                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                            <a class="dropdown-item" href="ManageControl?mode=updateExecute&id=${l.getTicketID()}&staffID=I0001" onclick="updateSuccess()">I0001</a>
                                            <a class="dropdown-item" href="ManageControl?mode=updateExecute&id=${l.getTicketID()}&staffID=I0002" onclick="updateSuccess()">I0002</a>
                                            <a class="dropdown-item" href="ManageControl?mode=updateExecute&id=${l.getTicketID()}&staffID=I0003" onclick="updateSuccess()">I0003</a>                                            
                                            <!-- Add more options as needed -->
                                        </div>
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
                            </tr>
                        </c:forEach>
                    </tbody>    
                </table>
                <c:if test="${account.getIsIT() == 0}">
                    <a href="ManageControl?mode=view" class="btn btn-info"> Cancel</a>
                </c:if>
                <c:if test="${account.getIsAdmin() == 0}">
                    <a href="ManageControl?mode=viewByDepartment" class="btn btn-info"> Cancel</a>
                </c:if>
                <a href="ManageControl?mode=viewTicket" class="btn btn-success"> Refresh</a>
            </form>
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
