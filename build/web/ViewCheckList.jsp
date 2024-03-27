<%-- 
    Document   : ViewCheckList
    Created on : Jan 17, 2024, 10:08:34 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    </head>
    <body>
        <div class="container">
            <div class="card-header my-3"><p>Information<p>
            </div>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th scope="col">Machine Name</th>
                        <th scope="col">Asset No</th>
                        <th scope="col">Date Plan</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${machine.getName()}</td>
                        <td>${machine.getAssetNo()}</td>
                        <td>${machine.getDatePlan()}</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <form action="ManageControl?mode=StaffViewCheckList" method="post">
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
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1W" ${his.getChecklist_1().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1M" ${his.getChecklist_1().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1Q" ${his.getChecklist_1().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1B" ${his.getChecklist_1().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1A" ${his.getChecklist_1().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check1D" ${his.getChecklist_1().contains("D")?"checked":""}> </td>
                            <!-- Workweek columns -->
                            <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark1" value=${machine.getRemark_1()}></td>
                    </tr>
                    <tr>
                        <td>2.</td>
                        <td style="text-align: left;">Defragment file system if necessary / Chạy phân mảnh file hệ thống nếu cần thiết</td>
                        <!-- Frequency columns -->
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2W" ${his.getChecklist_2().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2M" ${his.getChecklist_2().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2Q" ${his.getChecklist_2().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2B" ${his.getChecklist_2().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2A" ${his.getChecklist_2().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check2D" ${his.getChecklist_2().contains("D")?"checked":""}></td>
                            <!-- Workweek columns -->
                            <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark2" value=${machine.getRemark_2()}></td>
                    </tr>
                    <tr>
                        <td>3.</td>
                        <td style="text-align: left;">Check if Antivirus program is update / Kiểm tra phần mềm Antivirus đã update chưa</td>
                        <!-- Frequency columns -->
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3W" ${his.getChecklist_3().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3M" ${his.getChecklist_3().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3Q" ${his.getChecklist_3().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3B" ${his.getChecklist_3().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3A" ${his.getChecklist_3().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check3D" ${his.getChecklist_3().contains("D")?"checked":""}></td>                                                        
                            <!-- Workweek columns -->
                            <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark3" value=${machine.getRemark_3()}></td>
                    </tr>
                    <tr>
                        <td>4.</td>
                        <td style="text-align: left;">Check backup job / Kiểm tra công việc backup</td>
                        <!-- Frequency columns -->
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4W" ${his.getChecklist_4().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4M" ${his.getChecklist_4().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4Q" ${his.getChecklist_4().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4B" ${his.getChecklist_4().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4A" ${his.getChecklist_4().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check4D" ${his.getChecklist_4().contains("D")?"checked":""}></td>  
                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark4" value=${machine.getRemark_4()}></td>
                    </tr>
                    <tr>
                        <td>5.</td>
                        <td style="text-align: left;">Air compress inside CPU Case / Thổi bụi phía trong Case CPU</td>
                        <!-- Frequency columns -->
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5W" ${his.getChecklist_5().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5M" ${his.getChecklist_5().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5Q" ${his.getChecklist_5().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5B" ${his.getChecklist_5().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5A" ${his.getChecklist_5().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check5D" ${his.getChecklist_5().contains("D")?"checked":""}></td>  
                        <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark5" value=${machine.getRemark_5()}></td>
                    </tr>
                    <tr>
                        <td>6.</td>
                        <td style="text-align: left;">Check general condition of PC / Kiểm tra điều kiện thông thường của PC</td>
                        <!-- Frequency columns -->
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6W" ${his.getChecklist_6().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6M" ${his.getChecklist_6().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6Q" ${his.getChecklist_6().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6B" ${his.getChecklist_6().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6A" ${his.getChecklist_6().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check6D" ${his.getChecklist_6().contains("D")?"checked":""}></td>
                            <!-- Workweek columns -->
                            <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark6" value=${machine.getRemark_6()}></td>
                    </tr>
                    <tr>
                        <td>7.</td>
                        <td style="text-align: left;">Ensure that all connections are firmly fixed / Bảo đảm tất cả các kết nối đều được gắn chắc chắn</td>
                        <!-- Frequency columns -->
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7W" ${his.getChecklist_7().contains("W")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7M" ${his.getChecklist_7().contains("M")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7Q" ${his.getChecklist_7().contains("Q")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7B" ${his.getChecklist_7().contains("B")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7A" ${his.getChecklist_7().contains("A")?"checked":""}></td>
                        <td><input type="checkbox" style="width: 30px; height: 30px" name="checkedbox" value="check7D" ${his.getChecklist_7().contains("D")?"checked":""}></td>                                                        
                            <!-- Workweek columns -->
                            <td style="padding: 0px"><input style="height: 62px;border: white; margin-left: 5px" type="text" name="remark7" value=${machine.getRemark_7()}></td>
                    </tr>                                  
                    <!-- Add more rows as needed -->
                </table>
                <br>
                <!--                <a href="MainControl?mode=search"><button onclick="if (confirm('Update Successful!')) {
                                            window.location.href = this.href;
                                        } else {
                                            return false;
                                        }" class="btn btn-outline-success" id="btn-table" type="submit" value="Submit" style="position: absolute; left: 45%" >Submit</button></a>-->
                <a href="MainControl?mode=viewScheduleByMonth">< Back to Schedule </a></div>
        <br>
    </form>
    <script>
        const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        checkboxes.forEach((checkbox) => {
            checkbox.onclick = function () {
                return false;
            };
        });
        const inputs = document.querySelectorAll('input[type="text"]');
        inputs.forEach((textInput) => {
            textInput.onclick = function () {
                return false;
            };
        });
    </script>
</body>
</html>
