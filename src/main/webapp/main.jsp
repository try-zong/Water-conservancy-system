<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
window.onload = function() { //页面加载完成后触发事件
	jQueryAjax();
}
function linkok(url){
	question = confirm("你确认要删除该条水库记录吗？该操作将不可逆！");
	if (question){
		window.location.href = url;
	}
	return false;
}
function gook(url){
	question = confirm("你确认要登出吗？");
	if (question){
		window.location.href = url;
	}
}
function jQueryAjax(){
	$.ajax({
		url:"GetGatesServlet",
		type:"get",
		dataType:"text",
		 data:{
			 id:$("").val(),
			 name_gate:$("").val(),
			 buildtime:$("").val(),
			 responsible:$("").val()
		 },
	success:function(data){
		var WaterGate =eval("("+data+")");
		jQuery.each(WaterGate, function(i,item){
			$("#table1").append("<tbody id='studentTable' style='border-collapse: collapse;'>"
							   +"<tr id='sign' class='bg'>"
					 		   +" <td class='left2'><h2>"+WaterGate[i].name_gate+"</h2></td>"
							   +" <td class='left1'><h2>"+WaterGate[i].id+"</h2></td>"
							   +" <td class='left3'><h2>"+WaterGate[i].buildtime+"</h2></td>"
							   +" <td class='left4'><h2>"+WaterGate[i].responsible+"</h2></td>"
		   +"<td class='left5'><h2><a class='left' href='modifyGate.jsp?getid="+WaterGate[i].id+"'><font color=green>修改</font></a><a href=javascript:linkok('DeleteGateServlet?getid="+WaterGate[i].id+"')><font color=red>删除</font></a></h2></td>"
		+"</tr>"
		+"</tbody>");
			});
	}, 
	error:function(){
		alert("处理异常");
	}
	});
}
$(function () {
    
    $('#sign').hover(function () {
        $('#sign').addClass('over');
       
    },function(){
    	$('#sign').removeClass('over').addClass('out');
    	
    });
});


$(function () {
    var oldColor = "";
    $("#studentTable tbody tr").mouseover(function () {
        oldColor = $(this).css("background-color");
    $(this).css("background-color","#d9e8fb");
    }).mouseout(function () {
        $(this).css("background-color",oldColor);
    });
});




</script>
	<style type="text/css">
		body{
		margin: 0;
		padding: 0;
		background-image: url(https://i-1.lanrentuku.com/2020/12/7/a52d92a1-bdb9-4f4c-970b-aeb104472f38.jpg);
		background-repeat: top,center,no-repeat;
		background-size:100% 100%;
		background-attachment: fixed;
}
#studentTable tbody tr:nth-child(odd) {
		background-color:#F2F2F2;
	}

.over{
		background-color:red;
		}
.out{
		background-color:yellow;
		}
		
		
		.mainBox {
		height:220px;
		width:80%;
		float: center;
		margin-right:auto;
		margin-left:auto;
		}
		.mainh{
		margin-left:170px;
		}
		.mainh a {	
		margin-left:800px;
		}
		table.ys{
        border:1;
        border-color:white;
		
		}
		tr.bg{
		background-color:pink;
		
		height:80px;
		}
		tr.bg2{
		background-color:#ff8800;
		height:70px;
		}
		h2.back{
		background:blue;
		}
		td.left1{
		width:200px;
		text-align:center;
		height:40px;
		}
		td.left2{
		width:100px;
		text-align:center;
		height:40px;
		}
		td.left3{
		width:250px;
		text-align:center;
		height:40px;
		}
		td.left4{
		width:150px;
		text-align:center;
		height:40px;
		}
		td.left5{
		width:150px;
		text-align:center;
		height:40px;
		
		}
		a.left{
		float:left;
		margin-left:15px;
		}
		a.right{
		float:right;
		
		margin-right:15px;
		}
		
		h2.center{
		text-align:center;
		float:center;
		}
		.back{
		background-color:pink;
		}
		</style>	
</head>
<body >
<div  class="mainBox">
<img  width=100% height=100% src="https://img.zcool.cn/community/03750ee59478580a8012193a369e52f.jpg"><br>
</div>
<%String name =(String)session.getAttribute("user");  %>
<div  class="mainh">
<h1>欢迎回来,用户:<%=name %><a href="javascript:gook('LogoutServlet')"><font color="yellow">登出系统</font></a></h1>
</div>
<table  align="center" class="ys"  id="table1">
<tr class="bg2">
<td class="left1"><h2>水闸名</h2></td>
<td class="left2"><h2>id</h2></td>   
<td class="left3"><h2>建成时间</h2></td>
<td class="left4"><h2>负责人</h2></td>
<td class="left5"><h2>操作</h2></td>
</tr>
</table>
<h2 class="center"><a href="addGate.jsp">新建闸站</a></h2>

</body>
</html>





