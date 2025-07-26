<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ page isELIgnored="false" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>User Profile</title>
        </head>

        <body
            style="margin: 0; padding: 0; font-family: Arial, sans-serif; background: linear-gradient(to right, #f9f9f9, #e6f7ff); display: flex; justify-content: center; align-items: center; height: 100vh;">

            <div
                style="background-color: #fff; padding: 40px 50px; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1); width: 100%; max-width: 500px; text-align: left;">

                <h2 style="color: #333; text-align: center; margin-bottom: 20px;">Welcome, ${user.getName()}!</h2>
                
                <h3
                    style="color: #555; border-bottom: 1px solid #ddd; padding-bottom: 10px; margin-bottom: 20px; text-align: center;">
                    Your Profile Details
                </h3>

                <p style="font-size: 16px; margin: 10px 0;"><strong>ID:</strong> ${user.getId()}</p>
                <p style="font-size: 16px; margin: 10px 0;"><strong>Name:</strong> ${user.getName()}</p>
                <p style="font-size: 16px; margin: 10px 0;"><strong>Email:</strong> ${user.getEmail()}</p>
                <p style="font-size: 16px; margin: 10px 0;"><strong>Mobile:</strong> ${user.getMobile()}</p>

            </div>

        </body>

        </html>