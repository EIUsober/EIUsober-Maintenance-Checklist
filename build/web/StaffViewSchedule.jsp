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
        <div class="container" style="text-align: center; margin-top: 30px">
            <h2>Schedule</h2>                
        </div>
        <button style="max-height: 30px; border: none; border-radius: 5px; width: 70px;margin-left: 190px" class="btn-danger"><a style="color: white" href="MainControl?mode=history">History</a></button>
        <div class="container">
            <div class="card-header my-3">Information</div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Machine Name</th>
                        <th scope="col">Asset No</th>
                        <th scope="col">Assigned</th>
                        <th scope="col">Date</th>                        
                        <th scope="col">Status</th>
                        <th></th>
                    </tr>
                </thead>
                <c:forEach items="${listStaff}" var="s">
                    <tbody>
                        <tr>
                            <td>${s.getName()}</td>
                            <td>${s.getAssetNo()}</td>
                            <td>${s.getAssigned()}</td>
                            <td>${s.getDate()}</td>
                            <td>
                                <div class="dropdown" style="display: flex; width: 170px">
                                    <input type="text" class="form-control" id="selectedItem" placeholder="${s.getStatus()}" disabled="">
                                    <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    </button>
                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                        <a class="dropdown-item" href="MainControl?mode=updateScheduleStatus&id=${s.getId()}" onclick="updateSuccess()">Done</a>
                                        <!-- Add more options as needed -->
                                    </div>
                                </div>
                            </td>
                            <td><a href="ManageControl?mode=StaffViewCheckList&assetNo=${s.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                            </td>
                        </tr>
                    </tbody>
                </c:forEach>
            </table>
            <a href="ManageControl?mode=viewByDepartment">< Back to Staff Manage</a>
            <br>
            <a href="MainControl?mode=viewScheduleByStaff">🔄 Refresh</a>
        </div>
        <script>
            function updateSuccess() {
                if (confirm('Update Success!')) {
                    window.location.href = 'MainControl?mode=viewScheduleByMonth&month';
                } else {
                    return false;
                }
            }
        </script>
    </body>
</html>
