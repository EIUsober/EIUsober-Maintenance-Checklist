<%-- 
    Document   : HomePage
    Created on : Jan 4, 2024, 9:20:26 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Cicor</title>
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
        <style>
            .numberCircle {
                border-radius: 50%;
                width: 23px;
                height: 23px;
                padding: 2px;
                background: red;
                border: 2px solid #666;
                color: white;
                text-align: center;
                font: 12px Arial, sans-serif;
            }
        </style>
    </head>

    <body>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5-qrcode/2.3.4/html5-qrcode.min.js" integrity="sha512-k/KAe4Yff9EUdYI5/IAHlwUswqeipP+Cp5qnrsUjTPCgl51La2/JhyyjNciztD7mWNKLSXci48m7cctATKfLlQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

        <div class="container">

            <!-- Header -->

            <header class="header trans_300">

                <!-- Top Navigation -->

                <div class="top_nav">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-6">
                            </div>
                            <div class="col-md-6 text-right">
                                <div class="top_nav_right">
                                    <ul class="top_nav_menu">
                                        <li class="language">
                                            <a href="#">
                                                English
                                                <i class="fa fa-angle-down"></i>
                                            </a>
                                            <ul class="language_selection">
                                                <li><a href="#">French</a></li>
                                                <li><a href="#">Italian</a></li>
                                                <li><a href="#">German</a></li>
                                                <li><a href="#">Spanish</a></li>
                                            </ul>
                                        </li>
                                        <c:if test="${sessionScope.account == null}">
                                            <li class="account">
                                                <a href="#">
                                                    My Account
                                                    <i class="fa fa-angle-down"></i>
                                                </a>
                                                <ul class="account_selection">
                                                    <li><a href="Login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i>Sign In</a></li>
                                                </ul>
                                            </li>
                                        </c:if>
                                        <c:if test="${sessionScope.account != null}">
                                            <li class="account">
                                                <a href="#">
                                                    Hi, ${sessionScope.account.getUsername()}
                                                    <i class="fa fa-angle-down"></i>
                                                </a>
                                                <ul class="account_selection">
                                                    <li><a href="LoginControl?mode=signOut"><i class="fa fa-sign-out" aria-hidden="true"></i>Log Out</a></li>
                                                </ul>
                                            </li>
                                        </c:if>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Main Navigation -->

                <div class="main_nav_container">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12 text-right">
                                <div class="logo_container">
                                    <a href="HomePage.jsp"><img src="View/images/logo.png" width="100px" height="40px"/></a>
                                </div>
                                <nav class="navbar">
                                    <ul class="navbar_menu">
                                        <li><a href="HomePage.jsp">home</a></li>
                                            <c:if test="${sessionScope.account != null}">
                                                <c:if test="${account.getIsAdmin() == 0}">
                                                <li style="display: inline-flex"><a href="ManageControl?mode=viewByDepartment">Staff Manage</a></li>
                                                </c:if>
                                                <c:if test="${account.getIsAdmin() == 1}">
                                                <li><a href="ManageControl?mode=view">Admin Manage</a></li>
                                                </c:if>
                                            </c:if>
                                        <li><a href="https://www.cicor.com/en/company/production-sites/thuan-an-city/"  target="_blank">contact</a></li>
                                    </ul>
                                    <ul class="navbar_user">
                                        <c:if test="${account.getIsAdmin() == 0}">
                                            <li><a href="ManageControl?mode=viewByDepartment"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                                                </c:if>
                                                <c:if test="${account.getIsAdmin() == 1}">
                                            <li><a href="ManageControl?mode=view"><i class="fa fa-search" aria-hidden="true"></i></a></li>
                                                </c:if>
                                        <li><a href="Login.jsp"><i class="fa fa-user" aria-hidden="true"></i></a></li>
                                    </ul>
                                    <div class="hamburger_container">
                                        <i class="fa fa-bars" aria-hidden="true"></i>
                                    </div>
                                </nav>
                            </div>
                        </div>
                    </div>
                </div>
            </header>

            <div class="main_slider" style="background: white; margin-top: 150px">
                <div class="container ">
                    <div class="row align-items-center ">
                        <div class="row">
                            <div class="main_slider_content">						
                                <div  class="main-slider" style="justify-content: center; display: inline-grid">
                                    <c:if test="${machine.getAssetNo() == null}">  
                                        <main style="margin-top: 50px">
                                            <div id="reader" style="border: 2px solid #435d7d;"></div>
                                            <div id="result"></div>
                                        </main>	
                                    </c:if>
                                    <!--             Display Item -->
                                    <c:if test="${machine.getAssetNo() != null}">  
                                        <div class="container">
                                            <div class="card-header my-3">Information</div>
                                            <table class="table table-light">
                                                <thead>
                                                    <tr>
                                                        <th scope="col">Machine Name</th>
                                                        <th scope="col">Asset No</th>
                                                        <th scope="col">Department</th>
                                                        <th scope="col">Location</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>${machine.getName()}</td>
                                                        <td>${machine.getAssetNo()}</td>
                                                        <td>${machine.getDepartment()}</td>
                                                        <td>${machine.getLocation()}</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>

                                        <!--Display check list-->                                                                       
                                        <form action="MainControl?mode=check" method="post">
                                            <input hidden="" type="text" name="assetNo" value="${machine.getAssetNo()}">
                                            <div class="container">
                                                <div class="card-header my-3">Check List</div>
                                                <table class="table-checklist" id="myTable" border="1">
                                                    <tr style="margin-left: 10px">
                                                        <th rowspan="2" style="padding-left: 5px">No.</th>
                                                        <th rowspan="2" style="padding-left: 5px">JOB DESCRIPTION</th>
                                                        <th colspan="6" style="padding-left: 5px">FREQUENCY </th>
                                                        <th colspan="1" style="width: 200px;padding-left: 5px">WORKWEEK </th>
                                                    </tr>
                                                    <tr>
                                                        <td>W</td>
                                                        <td>M</td>
                                                        <td>Q</td>
                                                        <td>B</td>
                                                        <td>A</td>
                                                        <td>Done</td>
                                                        <td>Remark</td>
                                                    </tr>
                                                    <!-- Add your rows here -->
                                                    <tr>
                                                        <td>1.</td>
                                                        <td style="text-align: left;">Delete .tmp files / Xóa file tạm</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1W" ${machine.getChecklist_1().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1M" ${machine.getChecklist_1().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1Q" ${machine.getChecklist_1().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1B" ${machine.getChecklist_1().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1A" ${machine.getChecklist_1().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1D" ${machine.getChecklist_1().contains("D")?"checked":""} </td>
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark1" value=${machine.getRemark_1()}></td>
                                                    </tr>
                                                    <tr>
                                                        <td>2.</td>
                                                        <td style="text-align: left;">Defragment file system if necessary / Chạy phân mảnh file hệ thống nếu cần thiết</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2W" ${machine.getChecklist_2().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2M" ${machine.getChecklist_2().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2Q" ${machine.getChecklist_2().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2B" ${machine.getChecklist_2().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2A" ${machine.getChecklist_2().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2D" ${machine.getChecklist_2().contains("D")?"checked":""}></td>
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark2" value=${machine.getRemark_2()}></td>
                                                    </tr>
                                                    <tr>
                                                        <td>3.</td>
                                                        <td style="text-align: left;">Check if Antivirus program is update / Kiểm tra phần mềm Antivirus đã update chưa</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3W" ${machine.getChecklist_3().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3M" ${machine.getChecklist_3().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3Q" ${machine.getChecklist_3().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3B" ${machine.getChecklist_3().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3A" ${machine.getChecklist_3().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3D" ${machine.getChecklist_3().contains("D")?"checked":""}></td>                                                        
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark3" value=${machine.getRemark_3()}></td>
                                                    </tr>
                                                    <tr>
                                                        <td>4.</td>
                                                        <td style="text-align: left;">Check backup job / Kiểm tra công việc backup</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4W" ${machine.getChecklist_4().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4M" ${machine.getChecklist_4().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4Q" ${machine.getChecklist_4().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4B" ${machine.getChecklist_4().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4A" ${machine.getChecklist_4().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4D" ${machine.getChecklist_4().contains("D")?"checked":""}></td>                                                        
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark4" value=${machine.getRemark_4()}></td>
                                                    </tr>
                                                    <tr>
                                                        <td>5.</td>
                                                        <td style="text-align: left;">Air compress inside CPU Case / Thổi bụi phía trong Case CPU</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5W" ${machine.getChecklist_5().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5M" ${machine.getChecklist_5().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5Q" ${machine.getChecklist_5().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5B" ${machine.getChecklist_5().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5A" ${machine.getChecklist_5().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5D" ${machine.getChecklist_5().contains("D")?"checked":""}></td>
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark5" value=${machine.getRemark_5()}></td>
                                                    </tr>
                                                    <tr>
                                                        <td>6.</td>
                                                        <td style="text-align: left;">Check general condition of PC / Kiểm tra điều kiện thông thường của PC</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6W" ${machine.getChecklist_6().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6M" ${machine.getChecklist_6().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6Q" ${machine.getChecklist_6().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6B" ${machine.getChecklist_6().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6A" ${machine.getChecklist_6().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6D" ${machine.getChecklist_6().contains("D")?"checked":""}></td>
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark6" value=${machine.getRemark_6()}></td>
                                                    </tr>
                                                    <tr>
                                                        <td>7.</td>
                                                        <td style="text-align: left;">Ensure that all connections are firmly fixed / Bảo đảm tất cả các kết nối đều được gắn chắc chắn</td>
                                                        <!-- Frequency columns -->
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7W" ${machine.getChecklist_7().contains("W")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7M" ${machine.getChecklist_7().contains("M")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7Q" ${machine.getChecklist_7().contains("Q")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7B" ${machine.getChecklist_7().contains("B")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7A" ${machine.getChecklist_7().contains("A")?"checked":""} <c:if test="${account.getIsAdmin() == 0}">onclick="return false;"</c:if>></td>
                                                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7D" ${machine.getChecklist_7().contains("D")?"checked":""}></td>                                                        
                                                        <!-- Workweek columns -->
                                                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark7" value=${machine.getRemark_7()}></td>
                                                    </tr>
                                                    <!-- Add more rows as needed -->
                                                </table>
                                                <br>             
                                            </div>
                                            <c:if test="${sessionScope.account == null}">
                                                <a href="Login.jsp" class="btn btn-outline-success" style="position: absolute; left: 45%" onclick="if (confirm('You need login to Submit!')) {
                                                            window.location.href = this.href;
                                                        } else {
                                                            return false;
                                                        }">Submit</a>

                                            </c:if>
                                            <c:if test="${sessionScope.account != null}">
                                                <!--<input type="checkbox" style="width: 20px; height: 20px" name="checkedbox" value="checkedAll" checked="" id="checkAll">-->
                                                <!--<label for="checkAll">Check to all</label>-->
                                                <a href="MainControl?mode=search"><button onclick="if (confirm('Update Successful!')) {
                                                            window.location.href = this.href;
                                                        } else {
                                                            return false;
                                                        }" class="btn btn-outline-success" id="btn-table" type="submit" value="Submit" style="position: absolute; left: 45%" >Submit</button></a>
                                                </c:if>
                                        </form>
                                    </c:if>

                                    <br>
                                    <br>
                                    <br>
                                    <br>

                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <!-- Slider Navigation -->

            <div class="product_slider_nav_left product_slider_nav d-flex align-items-center justify-content-center flex-column">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
            </div>
            <div class="product_slider_nav_right product_slider_nav d-flex align-items-center justify-content-center flex-column">
                <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </div>


            <!-- Footer -->

        </div>

        <script src="View/js/jquery-3.2.1.min.js"></script>
        <script src="View/styles/bootstrap4/popper.js"></script>
        <script src="View/styles/bootstrap4/bootstrap.min.js"></script>
        <script src="View/plugins/Isotope/isotope.pkgd.min.js"></script>
        <script src="View/plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
        <script src="View/plugins/easing/easing.js"></script>
        <script src="View/js/custom.js"></script>
        <script src="View/js/s.js"></script>

    </body>

</html>

