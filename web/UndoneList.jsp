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

    </head>
    <body>
        <div class="container" style="text-align: center; margin-top: 30px">
            <h2>Has Not Maintained</h2>
        </div>

        <div class="container">
            <div class="card-header my-3">Information</div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Machine Name</th>
                        <th scope="col">Asset No</th>
                        <th scope="col">Status</th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach items="${listUD}" var="h">
                    <tbody>
                        <tr>
                            <td>${h.getMachineName()}</td>
                            <td>${h.getAssetNo()}</td>
                            <td>${h.getStatus()}</td>
                            <td><a href="ManageControl?mode=StaffViewCheckList&assetNo=${m.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
