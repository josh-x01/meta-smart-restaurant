<%@page import="com.meta_restaurant.users.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup</title>
</head>
<body>
<% User user = (User) request.getAttribute("user"); %>
    <div>
        <form action="/metarestaurant/update" method="post">
            <div class="user-input">
                <div class="input">
                    <input type="text" name="firstName" placeholder="First Name"
                    value="${user.getFirstName() }"/>
                </div>
                <div class="input">
                    <input type="text" name="lastName" placeholder="Last Name" 
                    value="${user.getLastName() }"/>
                </div>
                <div class="input">
                    <input type="hidden" name="email" placeholder="Email"
                    value="${user.getEmail() }" />
                </div>
                <div class="input">
                    <input type="text" name="phone" placeholder="Phone Number"
                    value="${user.getPhone() }"/>
                </div>
                <div class="input">
                    <input type="password" name="password" placeholder="password"/>
                </div>
            </div>
            <div class="submit">
                <input type="submit" name="submit" value="Update">
            </div>
        </form>
    </div>
</body>
</html>