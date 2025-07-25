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
            <h1 style="text-align: center; margin-bottom: 30px; color: #333;">REGISTRATION FORM</h1>
            <form action="profile" method="post" style="display: flex; flex-direction: column; gap: 20px;">

                <label for="label_name">Full Name:</label>
                <input type="text" name="name" id="label_name" placeholder="Enter your full name" required
                    style="padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
                <br />

                <label for="label_email">Email:</label>
                <input type="email" name="email" id="label_email" placeholder="Enter your email address" required
                    style="padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
                <br />

                <label for="label_mobile">Mobile:</label>
                <input type="tel" name="mobile" id="label_mobile" pattern="[0-9]{10}"
                    placeholder="Enter 10-digit mobile number" required
                    style="padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
                <br />

                <label for="label_password">Password : </label>
                <input type="password" name="password" id="label_password" required
                    style="padding: 10px; border: 1px solid #ccc; border-radius: 5px;" />
                <br />

                <input type="submit" value="submit form"
                    style="padding: 12px; background-color: #4CAF50; color: white; font-weight: bold; border: none; border-radius: 5px; cursor: pointer;" />
            </form>
        </div>
    </body>

    </html>