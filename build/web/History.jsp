<%-- 
    Document   : Schedule
    Created on : Jan 22, 2024, 8:42:28 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Schedule</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="Colo Shop Template">
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
        <div class="container" style="text-align: center; margin-top: 30px">
            <h2>History</h2>
            <form action="MainControl?mode=history" method="post">
                <input style="max-height: 30px; min-width: 60px;" type="month" id="start" name="month" min="2024-01" max="2030-12" value="${month}"/>
                <button style="max-height: 30px; border: none; border-radius: 5px; width: 70px" type="submit" class="btn-success">Search</button>
            </form>
        </div>
        <c:if test="${listAll != null}">
            <div class="container">
                <div class="card-header my-3">Information</div>
                <table class="table table-light">
                    <thead>
                        <tr>
                            <th scope="col">Machine Name</th>
                            <th scope="col">Asset No</th>
                            <th scope="col">Date</th>
                            <th scope="col">Done By</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach items="${listAll}" var="h">
                        <tbody>
                            <tr>
                                <td>${h.getMachineName()}</td>
                                <td>${h.getAssetNo()}</td>
                                <td>${h.getDate()}</td>
                                <td>${h.getPerformedBy()}</td>
                                <td><a href="ManageControl?mode=StaffViewSchedule&assetNo=${h.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </div>
        </c:if>
        <c:if test="${listH != null}">
            <div class="container">
                <div class="card-header my-3">Search Results</div>
                <table class="table table-light">
                    <thead>
                        <tr>
                            <th scope="col">Machine Name</th>
                            <th scope="col">Asset No</th>
                            <th scope="col">Date</th>
                            <th scope="col">Done By</th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach items="${listH}" var="h">
                        <tbody>
                            <tr>
                                <td>${h.getMachineName()}</td>
                                <td>${h.getAssetNo()}</td>
                                <td>${h.getDate()}</td>
                                <td>${h.getPerformedBy()}</td>
                                <td><a href="ManageControl?mode=StaffViewSchedule&assetNo=${h.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
                <a href="ManageControl?mode=schedule">< Back to Schedule</a>
            </div>
        </c:if>
    </body>
</html>
