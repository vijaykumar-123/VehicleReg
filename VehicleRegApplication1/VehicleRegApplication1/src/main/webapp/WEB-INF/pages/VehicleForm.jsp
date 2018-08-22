<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='https://fonts.googleapis.com/css?family=Raleway' rel='stylesheet'>
<title>New/Edit Vehicle</title>
<style type="text/css">
 body {
    font-family: Raleway, verdana, sans-serif;
    background: #256d8f;
}
.container {
    padding: 14px;
    background-color: #70c1e6; 
    align-self: center;
    margin-left: 150px;
    margin-right: 150px;
    font-size: 18px;
}
.vehi{
    padding: 1px;
    background-color: lightgrey;  
    align-self: center;
    margin-left: 150px;
    margin-right: 150px;
}
error {
color: red;
font-style: italic;
width: 120%;
}
span{
margin-left: 140px;
color: red;
}
input[type=text]{
    width: 160%;
    padding: 10px;
    margin: 5px 0 22px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 3px;
    background: #F5F5F5;
    
}
input.btn {
    border: 0;
    display: block;
    padding: 1em 3em;
    background: #a5f883;
    color: black;
    margin-bottom: 1em;
    cursor: pointer;
}
</style>
<script type="text/javascript">
function validateForm() {
     var alphaExp = /^[\s+a-zA-Z]+$/;
     
    if(document.forms["myForm"]["ownername"].value.match(alphaExp))
    {
    	document.getElementById('nameid').innerHTML="";
    	 
    }
    else
    {
    	document.getElementById('nameid').innerHTML = "Your name has Numbers or Special characters. These are not allowed.";
    	document.forms["myForm"]["ownername"].select();
    	return false;
    }
   
    if(isNaN(document.forms["myForm"]["price"].value))
    {
		document.getElementById('priceid').innerHTML="Apporoximate price should be a number";
		document.forms["myForm"]["price"].select();
		return false;
    }
    else
	{
    	document.getElementById("priceid").innerHTML="";
         
	}
    
    return true;
}
</script>
</head>
<body>
        <div class="vehi"><p>${errorvn}</p>
        <h1><center>Vehicle Registration</center></h1>
        </div>
        <form:form name="myForm" action="saveVehicle" method="post" onsubmit="return validateForm()" modelAttribute="vehicle">
        <div class="container" >
        <table>
            <form:hidden path="vid"/>
             <tr>
             <div>
             <span>${errorMsg}</span></div> </tr>
            <tr>
                <td><form:label path = "vehiclenumber">Vehicle Number</form:label></td>
                <td><form:input path="vehiclenumber" required="required" maxlength="12"/></td>
                <td><form:errors path = "vehiclenumber" cssClass = "error" /></td>               
            </tr>
            <tr>
                <td>Model</td>
                <td><form:input path="model" required="required" maxlength="15"/></td>
                <td><form:errors path = "model" cssClass = "error" /></td>
            </tr>
            <tr>
                <td>Engine</td>
                <td><form:input path="engine" required="required" maxlength="20"/></td>
                <td><form:errors path = "engine" cssClass = "error" /></td>
            </tr>
            <tr>
                <td>Owner Name</td>
                <td><form:input id= "ownername" path="ownername" required="required" maxlength="45"/></td>
                <td><span id="nameid"></span></td>
            </tr>
            <tr>
                <td>Apprx.Price</td>
                <td><form:input id= "price" path="price" required="required" maxlength="15"/></td>
                <td><form:errors path = "engine" cssClass = "error" /><span id="priceid"></span></td>
            </tr>
            <tr>
                <td>Brand</td>
                <td><form:select path="cars" required="required">
                <form:option value="">-- Select --</form:option>
                <form:option value="Volvo">Volvo</form:option>
                <form:option value="Audi">Audi</form:option>
                <form:option value="Mercedes">Mercedes</form:option>
                <form:option value="Jeep">Jeep</form:option>
                <form:option value="Spyker">Spyker</form:option>
                <form:option value="Benz">Benz</form:option>
                 </form:select>
                </td>
                
            </tr>
            <tr><td></td>
                <td></td>
                <td><input type="submit" class="btn" style="margin-left: 10px" value="Save Vehicle"></td>
            </tr>
            
        </table></div>
        </form:form>
    </div>
</body>