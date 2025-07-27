<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
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

        form {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        input[type="number"],
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
        }

        input[type="submit"]:hover {
            opacity: 0.9;
        }

        h2 {
            color: crimson;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>

<body>

    <div>
        <%-- JSP: Show error message if 'msg' attribute is not empty --%>
        <c:if test="${not empty msg}">
            <h2>${msg}</h2>
        </c:if>

        <h1>Login FORM</h1>

        <form action="log-prof" method="post">
            User ID:
            <input type="number" name="id" placeholder="Enter your user id" required />

            Password:
            <input type="password" name="password" placeholder="Enter password" required />

            <input type="submit" value="SIGN IN" />
        </form>
    </div>

</body>

</html>
