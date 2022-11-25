<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Entity.WaterGate" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		height:518px;
		width:520px;
		margin-left:500px;
		margin-top:50px;
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
	question = confirm("确认取消修改？，本次修改将不会被保存！");
	if (question){
		window.location.href = url;
	}
	return false;
}
function validateForm() {
    // 获取表单元素的值
    
    var name_gate = document.querySelector("input[name='name_gate']").value;
    var buildtime = document.querySelector("input[name='buildtime']").value;
    var responsible = document.querySelector("input[name='responsible']").value;
    var longitude = document.querySelector("input[name='longitude']").value;
    var dimensionality = document.querySelector("input[name='dimensionality']").value;
    var intro = document.querySelector("input[name='intro']").value;
   
          
   
    if(name_gate.length == 0){
    	alert("name_getaErr,水闸名不能为空");
        return false;
    }
    if(buildtime.length == 0){
    	alert("buildtimeErr,建成时间不能为空");
        return false;
    }
    if(responsible.length == 0){
    	alert("responsibleErr,负责人不能为空");
        return false;
    }
    if(longitude.length == 0){
    	alert("longitudeErr,经度不能为空");
        return false;
    }
    if(dimensionality.length == 0){
    	alert("dimensionalityErr,纬度不能为空");
        return false;
    }
    if(intro.length == 0){
    	alert("introErr, 简介不能为空");
        return false;
    }

}



</script>


</head>
<body>
<br>
<br>
<%
String getid=request.getParameter("getid");
String name_gate="";
String buildtime="";
String responsible="";
String longitude="";
String dimensionality="";
String intro="";

@SuppressWarnings("unchecked")//忽略警告
ArrayList<WaterGate>array=(ArrayList<WaterGate>)getServletContext().getAttribute("WaterGate");
for(WaterGate waterGate1: array) {	  
	if(waterGate1.getId().equals(getid)){
		name_gate=waterGate1.getName_gate();
		buildtime=waterGate1.getBuildtime();
		responsible=waterGate1.getResponsible();
		longitude=waterGate1.getLongitude();
		dimensionality=waterGate1.getDimensionality();
		intro=waterGate1.getIntro();
	}
}
%>

    
<br>
<div id="container">
       <div id="form">
       <h2 >修改水闸记录</h2>
       <form  onsubmit="return validateForm()" action="ModifyGateServlet" method="post" name="form" >
       
       <input type="hidden" name="getid" id="getid" value="<%=getid%>" ><br>
	<div id="xinxi">
  		<div style="margin-top:15px;">id<%=getid%></div>
       
        <div style="margin-top:15px;">水闸名:&nbsp;&nbsp;&nbsp;<input type="text" name="name_gate" id="name_gate" value="<%=name_gate%>"></div>
        
      <br>
        <div style="margin-top:15px;">建成时间:<input type="text" name="buildtime" id="buildtime" value="<%=buildtime%>"></div>
      <br>
        <div style="margin-top:15px;">负责人:&nbsp;&nbsp;&nbsp;<input type="text" name="responsible" id="responsible" value="<%=responsible%>"></div>
        <br>
        <div style="margin-top:15px;">经度:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="longitude" value="<%=longitude%>"></div>
        <br>
        <div style="margin-top:15px;">纬度:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dimensionality" value="<%=dimensionality%>"></div>
       <br>
        <div style="margin-top:15px;">简介:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="intro" value="<%=intro%>"></div>
    </div>
    <br><br><br>
    <input  class="btn" type="submit" value="确认修改">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input class="btn" type="button" name="cancal" value="取消" onclick="goback('main.jsp')">
                     </form>
       </div>
 </div>
</body>
</html>