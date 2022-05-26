<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>stock entry Form</title>
<style type="text/css">
    label {
        display: inline-block;
        width: 200px;
        margin: 5px;
        text-align: left;
    }
    input[type=text], input[type=password], select {
        width: 200px;  
    }
    input[type=radio] {
        display: inline-block;
        margin-left: 45px;
    }
    input[type=checkbox] {
        display: inline-block;
        margin-right: 190px;
    }  
     
    button {
        padding: 10px;
        margin: 10px;
    }
</style>
</head>
<body>
    <div align="center">
        <h2>Stock Entry</h2>
        <form:form action="enterTheProduct" method="post" modelAttribute="entry">
            <form:label path="stockDate">stock Date (dd-mm-yyyy):</form:label>
            <form:input path="stockDate"/><br/>
             
            <form:label path="warehouseId">warehouse Id:</form:label>
            <form:input path="warehouseId"/><br/>
             
            <form:label path="productId">product Id:</form:label>
            <form:input path="productId"/><br/>      
 
            <form:label path="deliveryFromProduction">delivery From Production :</form:label>
            <form:input path="deliveryFromProduction"/><br/>
                     
            <form:label path="rejection">rejection</form:label>
            <form:input path="rejection"/><br/>
            
            <form:label path="startUpLose">start Up Lose</form:label>
            <form:input path="startUpLose"/><br/>
                 
            <form:button>Submit</form:button>
        </form:form>
    </div>
</body>
</html>