<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Welcome Page</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
</head>

<body style="margin: 0; padding: 0; font-family: Arial, sans-serif; background: linear-gradient(to right, #f0f2f5, #e6f7ff); display: flex; justify-content: center; align-items: center; height: 100vh;">

    <div style="background-color: #fff; padding: 40px 50px; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); text-align: center; max-width: 400px; width: 100%;">

        <h2 style="color: #333; margin-bottom: 30px;">WELCOME TO OUR WEBSITE</h2>

        <div style="display: flex; justify-content: center; gap: 20px;">
            <a href="/login"
                style="padding: 12px 25px; background-color: #4CAF50; color: white; border-radius: 5px; text-decoration: none; font-weight: bold; font-size: 16px;">
                Login
            </a>

            <a href="/register"
                style="padding: 12px 25px; background-color: #2196F3; color: white; border-radius: 5px; text-decoration: none; font-weight: bold; font-size: 16px;">
                Register
            </a>
        </div>

    </div>

</body>

</html>