<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Insert title here</title>
    </head>

    <body
        style="margin:0; padding:0; font-family: Arial, sans-serif; background: linear-gradient(to right, #f0f2f5, #ffffff); display: flex; justify-content: center; align-items: center; height: 100vh;">

        <div
            style="background: #fff; padding: 40px; border-radius: 10px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); width: 100%; max-width: 400px;">
            <c:if test="${not empty msg}">
                <h2 style="color: crimson;">${msg}</h2>
            </c:if> 
            <h1 style="text-align: center; margin-bottom: 30px; color: #333;">Login FORM</h1>
            <form action="log-prof" method="post" style="display: flex; flex-direction: column; gap: 20px;">

                User ID : <input type="number" name="id" placeholder="Enter your user id" required
                    style="padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
                <br />

                Password : <input type="password" name="password" placeholder="Enter password" required
                    style="padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
                <br />

                <input type="submit" value="SIGN IN"
                    style="padding: 12px; background-color: #4CAF50; color: white; font-weight: bold; border: none; border-radius: 5px; cursor: pointer;" />
            </form>
        </div>
    </body>

    </html>