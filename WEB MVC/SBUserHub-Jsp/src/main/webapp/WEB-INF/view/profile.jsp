<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: linear-gradient(to right, #f9f9f9, #e6f7ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        body > div {
            background-color: #fff;
            padding: 40px 50px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
            text-align: left;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        h3 {
            color: #555;
            border-bottom: 1px solid #ddd;
            padding-bottom: 10px;
            margin-bottom: 20px;
            text-align: center;
        }

        p {
            font-size: 16px;
            margin: 10px 0;
        }

        strong {
            font-weight: bold;
        }

        form {
            text-align: center;
            margin-top: 30px;
        }

        input[type="submit"] {
            padding: 10px 25px;
            background-color: #ff4d4d;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
            font-size: 16px;
        }

        input[type="submit"]:hover {
            opacity: 0.9;
        }
    </style>
</head>

<body>

    <div>
        <%-- JSP: Display user name dynamically --%>
        <h2>Welcome, ${user.getName()}!</h2>

        <h3>Your Profile Details</h3>

        <%-- JSP: Show user details using EL --%>
        <p><strong>ID:</strong> ${user.getId()}</p>
        <p><strong>Name:</strong> ${user.getName()}</p>
        <p><strong>Email:</strong> ${user.getEmail()}</p>
        <p><strong>Mobile:</strong> ${user.getMobile()}</p>

        <form action="/" method="post">
            <input type="submit" value="Logout" />
        </form>
    </div>

</body>

</html>
