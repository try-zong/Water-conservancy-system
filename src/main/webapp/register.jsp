<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">

body {
    padding:0;  /*去除内边距袭*/
    border:1px;   /*去除边框*/
    margin:1px;   /*去除外边距*/
    background-image:url("https://i-1.lanrentuku.com/2020/12/7/a52d92a1-bdb9-4f4c-970b-aeb104472f38.jpg");
    background-repeat: top,center,no-repeat;
	background-size:100% 100%;
	background-attachment: fixed;
	}
	#container{
		
		height:1000px;
		width:1000px;
		position:absolute;

	}
	  
	#form{
		border:1px solid #DDD;
		height:318px;
		width:520px;
		margin-left:500px;
		margin-top:150px;
		position:absolute;
		text-align:center;
		background-image: linear-gradient(60deg, #29323c 0%, #485563 100%);
		border-radius: 20px;
	}
	#header{
		
		font-size:25px;
		color:#3083EF;
	}
	 hr{
         height: 2px;
		 width:300px;
         background-color:#75B6F6 ;   
            
      }
	  #xinxi{
		  font-family:Tahoma, Geneva, sans-serif;
		  font-size:15px;
		  color:#A3CCFB;
		  line-height:10px;
	  }
	  .btn{
		  background-color:pink;
		  border:0px;
		  color: pray;
		  text-align: center;
		  height:30px;
		  width:100px;
	  }


</style>

<script type="text/javascript">

function goback(url){
	question = confirm("你确认要取消注册吗，本次注册将不会被保存！");
	if (question){
		window.location.href = url;
	}
	return false;
}

function validateForm() {
    // 获取表单元素的值
    var name = document.querySelector("input[name='name']").value;
    var pwd = document.querySelector("input[name='password']").value;
    var jobNumber = document.querySelector("input[name='jobNumber']").value;
    var role = document.querySelector("input[name='role']").value;
   
          
    if(name.length == 0){
        alert("nameErr, 用户名不能为空");
        return false;
    }
    if(jobNumber.length == 0){
    	alert("jobNumberErr,工号不能为空");
        return false;
    }
    var exp=/^[a-z0-9]+$/;
	if(!exp.test(jobNumber)){
		alert("工号不符合规范");
		
		return false;
	}
    if(pwd.length == 0){
    	alert("pwdErr,密码不能为空");
        return false;
    }
    var exp=/^[a-z0-9]+$/;
	if(!exp.test(pwd)){
		alert("密码不符合规范");
		
		return false;
	}
	
   
    if(role.length == 0){
    	alert("roleErr, 角色不能为空");
        return false;
    }

}

</script>
</head>
<body>

<div id="container">
       <div id="form" >
       <p id="header" style="margin-botton:2px">注册页面</p>
       <hr/>
       <form  onsubmit="return validateForm()" action="RegisterUser" method="post" name="form" >
       
       
  	<div id="xinxi">
  		

            <div style="margin-top:15px;">用户名:&nbsp;<input type="text" name="name" id="name" value="">
       		</div>
       
           
            <div style="margin-top:15px;">工号:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="jobNumber" id="jobNumber" value="">
        	</div>
      
            
            <div style="margin-top:15px;">密码:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="password" id="password" value="">
        	</div>
         
         
            <div style="margin-top:15px;">角色:&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="role" id="role" value=""> 
    		</div>
    		<br>
    		<br>
    		<input  class="btn" type="submit" value="确认注册" >
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="btn" type="button" name="cancal" value="取消" onclick="goback('login.jsp')">
    </div>
    
            </form>         
     </div>
       

</body>
</html>