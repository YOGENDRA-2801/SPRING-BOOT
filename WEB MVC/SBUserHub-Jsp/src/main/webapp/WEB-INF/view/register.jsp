<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #f0f2f5, #ffffff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        body > div {
            background: #fff;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 400px;
        }

        h1 {
            text-align: center;
            margin-bottom: 30px;
            color: #333;
        }

        h2 {
            color: crimson;
            text-align: center;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="password"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            padding: 12px;
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

    <div>
        <%-- JSP: Show error message if 'msg' is not empty --%>
        <c:if test="${not empty msg}">
            <h2>${msg}</h2>
        </c:if>

        <h1>REGISTRATION FORM</h1>

        <form action="reg-prof" method="post">
            Full Name:
            <input type="text" name="name" placeholder="Enter your full name" required />

            Email:
            <input type="email" name="email" placeholder="Enter your email address" required />

            Mobile:
            <input type="tel" name="mobile" pattern="[0-9]{10}" placeholder="Enter 10-digit mobile number" required />

            Password:
            <input type="password" name="password" placeholder="Enter password" required />

            <input type="submit" value="SIGN UP" />
        </form>
    </div>

</body>

</html>
