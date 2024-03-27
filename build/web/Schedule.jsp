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
            <form action="MainControl?mode=viewScheduleByMonth" method="post">
                <input style="max-height: 30px; min-width: 60px;" type="month" id="start" name="month" min="2024-01" max="2030-12" value="${month}"/>
                <button style="max-height: 30px; border: none; border-radius: 5px; width: 70px" type="submit" class="btn-success">Search</button>
            </form>                
        </div>
        <button style="max-height: 30px; border: none; border-radius: 5px; width: 70px;margin-left: 190px" class="btn-danger"><a style="color: white" href="MainControl?mode=history">History</a></button>
        <button style="max-height: 30px; border: none; border-radius: 5px; width: 70px;margin-left: 5px" class="btn-warning"><a style="color: white" href="ManageControl?mode=view">Manage</a></button>
        <c:if test="${month != null}">
            <div class="container">
                <c:if test="${!month.equals('2024-03')}">
                    <div>
                        <a style="color: red">Maintained machines: 0</a>
                        <br>
                        <a style="color: red">Remaining: 17 </a>
                    </div>
                    <div class="card-header my-3">Information</div>
                    <table class="table table-light">
                        <thead>
                            <tr>
                                <th scope="col">Machine Name</th>
                                <th scope="col">Asset No</th>
                                <th scope="col">Status</th>
                                <th scope="col">Assigned</th>
                                <th></th>
                            </tr>
                        </thead>
                        <c:forEach items="${listSamp}" var="s">
                            <tbody>
                                <tr>
                                    <td>${s.getName()}</td>
                                    <td>${s.getAssetNo()}</td>
                                    <c:if test="${s.getStatus().equals('Undone')}">
                                        <td style="background-color: lightcoral">${s.getStatus()}</td>
                                    </c:if>
                                    <c:if test="${s.getStatus().equals('Done')}">
                                        <td style="background-color: lightgreen">${s.getStatus()}</td>
                                    </c:if>
                                    <td>
                                        <div class="dropdown" style="display: flex; width: 170px">
                                            <input type="text" class="form-control" id="selectedItem" placeholder="${s.getAssigned()}" disabled="">
                                            <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            </button>
                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item" href="MainControl?mode=updateScheduleExecute&id=${s.getId()}&staffID=I0001" onclick="updateSuccess()">I0001</a>
                                                <a class="dropdown-item" href="MainControl?mode=updateScheduleExecute&id=${s.getId()}&staffID=I0002" onclick="updateSuccess()">I0002</a>
                                                <a class="dropdown-item" href="MainControl?mode=updateScheduleExecute&id=${s.getId()}&staffID=I0003" onclick="updateSuccess()">I0003</a>                                            
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
                </c:if>
                    <c:if test="${month.equals('2024-03')}">
                        <div>
                            <a style="color: red">Maintained machines: ${done3.size()}</a>
                            <br>
                            <a style="color: red">Remaining: ${17 - done3.size()} </a>
                        </div>
                        <div class="card-header my-3">Information</div>
                        <table class="table table-light">
                            <thead>
                                <tr>
                                    <th scope="col">Machine Name</th>
                                    <th scope="col">Asset No</th>
                                    <th scope="col">Status</th>
                                    <th scope="col">Date Plan</th>
                                    <th scope="col">Date Complete</th>
                                    <th scope="col">Date Gap</th>
                                    <th scope="col">Performed By</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <c:forEach items="${listHis3}" var="h">
                                <tbody>
                                    <tr>
                                        <td>${h.getName()}</td>
                                        <td>${h.getAssetNo()}</td>
                                        <c:if test="${h.getStatus().equals('Undone')}">
                                            <td style="background-color: lightcoral">${h.getStatus()}</td>
                                        </c:if>
                                        <c:if test="${h.getStatus().equals('Done')}">
                                            <td style="background-color: lightgreen">${h.getStatus()}</td>
                                        </c:if>
                                        <td>
                                            ${h.getDatePlan()}
                                        </td>
                                        <td>${h.getDateComplete()}</td>
                                        <c:if test="${h.getDateGap() < -3}"><td style="background-color: orange"><c:if test="${h.getDateGap() != 0}">${h.getDateGap()}</c:if></td></c:if>
                                        <c:if test="${h.getDateGap() > -3}"><td><c:if test="${h.getDateGap() != 0}">${h.getDateGap()}</c:if></td></c:if>
                                                <td>${h.getPerformedBy()}</td>
                                        <td></td>
                                        <td><a href="MainControl?mode=search&search=${h.getAssetNo()}" ><i class="material-icons" data-toggle="tooltip" title="View">&#xf1c5;</i></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </c:forEach>
                        </c:if>
                    </table>
                    <c:if test="${account.getIsAdmin() != 1}">
                        <a href="ManageControl?mode=viewByDepartment">< Back to Staff Manage</a>
                    </c:if>
                    <c:if test="${account.getIsAdmin() == 1}">
                        <a href="ManageControl?mode=view">< Back to Manage</a>
                        <br>
                        <a href="MainControl?mode=viewScheduleByMonth">🔄 Refresh</a>
                    </c:if>
            </div>
        </c:if>
        <script>
            function updateSuccess() {
                if (confirm('Update Success!')) {
                    window.location.href = 'MainControl?mode=viewScheduleByMonth&month';
                } else {
                    return false;
                }
            }
            $(document).ready(function () {
                // Activate tooltip
                $('[data-toggle="tooltip"]').tooltip();
                // Select/Deselect checkboxes
                var checkbox = $('table tbody input[type="checkbox"]');
                $("#selectAll").click(function () {
                    if (this.checked) {
                        checkbox.each(function () {
                            this.checked = true;
                        });
                    } else {
                        checkbox.each(function () {
                            this.checked = false;
                        });
                    }
                });
                checkbox.click(function () {
                    if (!this.checked) {
                        $("#selectAll").prop("checked", false);
                    }
                });
            });
            $(document).ready(function () {
                $(".dropdown-menu a").click(function () {
                    var selectedItem = $(this).text();
                    $("#selectedItem").val(selectedItem);
                });
            });
        </script>
    </body>
</html>
