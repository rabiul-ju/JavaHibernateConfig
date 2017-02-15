<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Registration Form</h1>
    <form action="register?param=create" method="post"><!-- action="save" for spring -->
        <table cellpadding="3pt">
            <tr>
                <td>First Name :</td>
                <td><input type="text" name="firstName" size="30" /></td>
            </tr>
            <tr>
                <td>Last Name :</td>
                <td><input type="text" name="lastName" size="30" /></td>
            </tr>
            <tr>
                <td>Password :</td>
                <td><input type="password" name="password" size="30" /></td> <!-- name="login.password" for spring -->
            </tr>
 
            <tr>
                <td>Confirm Password :</td>
                <td><input type="password" name="confirmPassword" size="30" /></td>
            </tr>
            <tr>
                <td>email :</td>
                <td><input type="text" name="email" size="30" /></td>
            </tr>
            <tr>
                <td>Mobile NO :</td>
                <td><input type="text" name="mobileNumber" size="30" /></td> <!--  name="login.mobileNumber" for spring-->
            </tr>
        </table>
        <p />
        <input type="submit" value="Register" />
    </form>
</body>
<!-- 
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private String mobileNumber;
	private String password;
	private Date createdDate;
	private Date upatedDate; -->
</html>