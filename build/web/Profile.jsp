<%-- 
    Document   : newjsp
    Created on : Jan 9, 2024, 2:21:14 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Machine"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Manage</title>
        <link rel="stylesheet"  href="View/styles/responsive.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>
        /* Style for the fake password input */
        .fake-password {
            font-family: monospace; /* Use a monospace font for consistent character width */
            letter-spacing: 0.5em; /* Increase spacing between characters */
        }
    </style>
    </head>
    <body>
 <input type="password" value="YourActualPassword" id="myInput" class="fake-password">

    <!-- Toggle password visibility button -->
    <button onclick="togglePasswordVisibility()">Show Password</button>

    <script>
        function togglePasswordVisibility() {
            var passwordInput = document.getElementById("myInput");
            if (passwordInput.type === "password") {
                // If currently showing the password, hide it
                passwordInput.type = "text";
            } else {
                // Otherwise, show the password
                passwordInput.type = "password";
            }
        }
    </script>

        
    </body>
</html>
