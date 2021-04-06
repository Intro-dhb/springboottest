<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<script type="text/javascript" src="js/jquery.min.js">
		$(function(){
			$(".delete").click (function(){
				var href=$(this).attr("href");
				$("#formdelete").attr("action",href).submit;
				return false;
			})
			
		})
	</script>
<body>
<div style="width:500px;margin:20px auto;text-align: center">
<table align="center" cellspacing="0" border="1">
	<tr>
		<td>id</td>
		<td>name</td>
		<td>编辑</td>
        <td>删除</td>
	</tr>	
	<c:forEach items="${page.content}" var="c" varStatus="st">
		<tr>
			<td>${c.id }</td>
			<td>${c.name }</td>
			<td><a href="categories/${c.id}">编辑</a></td>
            <td><a class="delete" href="categories/${c.id}">删除</a></td>
		</tr>
	</c:forEach>
			
</table>
	<div align="center">
                <a href="?start=0">[首  页]</a>
            <a href="?start=${page.number-1}">[上一页]</a>
            <a href="?start=${page.number+1}">[下一页]</a>
            <a href="?start=${page.totalPages-1}">[末  页]</a>
    </div>
    <br>
    <form action="categories" method="post">
     
    name: <input name="name"> <br><br>
    <button type="submit">增加种类</button>   
    </form>
    
    <form id="formdelete" action="" method="POST" >
       <input type="hidden" name="_method" value="DELETE">
   </form>
    </div>
</body>
</html>