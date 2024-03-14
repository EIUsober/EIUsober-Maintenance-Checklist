<%-- 
    Document   : Login
    Created on : Jan 9, 2024, 1:29:55 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <!-- Design by foolishdeveloper.com -->
        <title>Login Form</title>
        <link rel="stylesheet" type="text/css" href="View/styles/bootstrap4/bootstrap.min.css">
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
        <link rel="stylesheet"  href="View/styles/main_styles.css">
        <link rel="stylesheet" href="View/styles/scanner.css">
        <style media="screen"></style>
        <link rel="stylesheet" href="View/styles/login.css">
    </head>
    <body>
        <p class="${mess==null ? " ": "alert-danger alert" }">${mess}</p>
        <div class="background">
            <div class="shape"></div>
            <div class="shape"></div>
        </div>
        <form action="LoginControl?mode=login" method="post"> 
            <h3>Login</h3>

            <label for="username">Username</label>
            <input type="text" placeholder="Username" id="username" name="username">

            <label for="password">Password</label>
            <input type="password" placeholder="Password" id="password" name="password">

            <button type="submit">Log In</button>      
        </form>
    </body>
</html>

