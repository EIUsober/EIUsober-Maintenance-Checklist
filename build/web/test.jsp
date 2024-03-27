<%-- 
    Document   : test
    Created on : Mar 12, 2024, 2:21:23 PM
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
        <style>
            #myPieChart {
                width: 300px;
                height: 300px;
            }

        </style>
    </head>
    <body>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
        <canvas id="myPieChart"></canvas>
        <input  value="${month1.size()}" hidden="" id="month1">
        <input  value="${month2.size()}" hidden="" id="month2">
        <input  value="${month3.size()}" hidden="" id="month3">
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
                        text: 'Maintenance Activity'
                    }
                }
            });

        </script>
    </body>
</html>
