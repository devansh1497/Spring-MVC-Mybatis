<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add employee</h1>
	<s:form modelAttribute="employee" action="saveProcess">
		<input type="hidden" id="hidden-text" value="${employee.hobbies}"/> 
		<s:hidden path="id"/>
		Name: <s:input path="fullName"/><br/>
		Email: <s:input path="email"/><br/>
		Gender: <s:radiobutton path="gender" value="Male"/>Male<br/>
		<s:radiobutton path="gender" value="Female"/>Female<br/>
		Interests: <s:checkbox path="hobbies" value="Sports"/>Sports<br/>
		<s:checkbox path="hobbies" value="Coding"/>Coding<br/>
		<s:checkbox path="hobbies" value="Reading"/>Reading<br/>
		<s:checkbox path="hobbies" value="Writing"/>Writing<br/>
		Country: <s:select path="country">
			<s:option value="India">India</s:option>
			<s:option value="USA">USA</s:option>
			<s:option value="Japan">Japan</s:option>
			<s:option value="UK">UK</s:option>
			<s:option value="Russia">Russia</s:option>
		</s:select>
		Address: <s:textarea path="address"/>
		<input type="submit" value="Save">
	</s:form>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	
	<script>
	
		$(document).ready(function(){
			var hobbies = $("#hidden-text").val().split(",");
			var $checkboxes = $("input[type=checkbox]");
			$checkboxes.each(function(id, element){
				if(hobbies.indexOf(element.value) != -1){
					element.setAttribute("checked", "checked");
				}else{
					element.removeAttribute("checked");
				}
			});
		});
	
	</script>
		
	
	
</body>
</html>