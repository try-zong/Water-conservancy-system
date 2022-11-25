<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆界面</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css">
<style type="text/css">
body{
	margin: 0;
	padding: 0;
	background-image: url(https://i-1.lanrentuku.com/2020/12/7/a52d92a1-bdb9-4f4c-970b-aeb104472f38.jpg);
	background-repeat: top,center,no-repeat;
	background-size:100% 100%;
	background-attachment: fixed;
	
}
a{
	color: #666;
	text-decoration: none;
}
#bigBox
{
	margin: 0 auto;
	margin-top: 100px;
	padding: 20px 50px;
	background-color:rgba(240,255,255,0.25);
	width: 550px;
	height: 500px;
	border-radius: 20px;
	text-align: center;
	color:#ffffff;
	background-image: linear-gradient(60deg, #29323c 0%, #485563 100%);
}
#bigBox h1
{
	font-size: 40px;
	color: pink;
}
#bigBox .inputBox
{
	margin-top: 35px;
}
#bigBox .inputBox .inputText
{
	margin-top: 20px;
}
#bigBox .inputBox .inputText1
{
	margin-top: 20px;
	margin-left:100px;
}
#bigBox .inputBox .inputText input
{
	border: 0;
	padding: 10px 10px;
	border-bottom: 1px solid white;
	background-color: #00000000;
	color: white;
	width: 200px;
	height: 40px;
	font-size: 20px;
}#bigBox .inputBox .inputText1 input
{
	border: 0;
	padding: 10px 10px;
	border-bottom: 1px solid white;
	background-color: #00000000;
	color: white;
	width: 200px;
	height: 40px;
	font-size: 20px;
}

#bigBox .inputBox .inputText i
{
	color: white;
	
}#bigBox .inputBox .inputText1s i
{
	color: white;
}
#bigBox .inputBox .inputButton
{
	border: 0;
	width: 200px;
	height: 50px;
	color: white;
	margin-top: 55px;
	border-radius:20px;
	text-align:center;
	background-image: linear-gradient(to right, #b8cbb8 0%, #b8cbb8 0%,#b465da 0%, #cf6cc9 33%, #ee609c 66%, #ee609c 100%);
}
#bigBox .inputBox .ared
{
	border: 0;
	width: 200px;
	height: 50px;
	color: white;
	margin-top: 45px;
	border-radius:20px;
	text-align:left;
}

</style>
<script type="text/javascript">

function refreshCode(){
	document.getElementById("code").src="SecurityCode?t="+Math.random();
}

</script>
</head>
<body>
	<div id="bigBox">
		<form action="loginServlet" method="post">
	
			<h1>LOGIN</h1>
			<div class="inputBox">
			
					<div class="inputText">
						<i class="fa fa-user-circle" style="color: pink;"></i>
						<input type="text" placeholder="用户名" name="user"/>
					</div>
					<div class="inputText">
						<i class="fa fa-key" style="color: pink;"></i>
						<input type="password" placeholder="密码" name="pwd"/>
					</div>
					<div class="inputText1">
						<i class="fa fa-linode" style="color: pink;"></i>
						<input type="text" placeholder="验证码" name="code"/>
	
					<tr>
				<td>
					<img id="code" src="SecurityCode"/>
				</td>
			<td class="ared">
				<a href="javascript:refreshCode();"><font color="yellow">vary</font></a>
			</td>
			</tr>
					</div>
			
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="submit" class="inputButton" style="text-align:center" value="LOGIN" />
					&nbsp;&nbsp;&nbsp;
					<a href="register.jsp"><font color="yellow">注册</font></a>
			 
			</div>
			
			</form>
		</div>
		
</body>
<script> 
	var errori ='<%=request.getParameter("error")%>';
	if(errori=='nameError'){
 		alert("用户名不正确，请重新输入!");
	}else if(errori=='pwdError'){
	 	alert("密码错误，请重新输入!");
	}else if(errori=='securitycodeError'){
 		alert("验证码错误，请重新输入!");
	}else if(errori=='stateError'){
 		alert("该用户信息已停用，请重新输入!");
	}

</script>

</html>