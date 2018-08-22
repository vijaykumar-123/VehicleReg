<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vehicle List</title>
<style type="text/css">
body {
    font-family: Raleway, verdana, sans-serif;
    background: #3696c2;
}
table {
    border-collapse: collapse;
    width: 70%;
    background: #c6c9ca;
}
table, th, td {
    border: 1px solid black;
    font-size: 15px;
}
th {
    height: 40px;
}
td {
    height: 20px;
}
</style>
</head>
<body>
    <div align="center">
        <h1>Vehicle List</h1>
        <h3>
            <p>Click here to register <a href="newVehicle">New Vehicle</a>
        </h3>
        <table>
 
            <th>Vehicle Number</th>
            <th>Model</th>
            <th>Engine</th>
            <th>&emsp;Owner Name&emsp;</th>
            <th>Apprx.Price</th>
            <th>Brand</th>
            
 
            <c:forEach var="vehicle" items="${listVehicle}">
                <tr>
 
                    <td>${vehicle.vehiclenumber}</td>
                    <td>${vehicle.model}</td>
                    <td>${vehicle.engine}</td>
                    <td>${vehicle.ownername}</td>
                    <td>${vehicle.price}</td>
                    <td>${vehicle.cars}</td>
                    
                    <td>&emsp;<a href="editVehicle?vid=${vehicle.vid}">Edit</a>
                             <a href="deleteVehicle?vid=${vehicle.vid}">Delete</a>
                    </td>
 
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>