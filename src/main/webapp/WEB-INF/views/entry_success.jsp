<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
<style type="text/css">
    span {
        display: inline-block;
        width: 200px;
        text-align: left;
    }
</style>
</head>
<body>
    <div align="center">    <!-- stockDate, warehouseId, productId, deliveryFromProduction,rejection, startUpLose-->>
        <h2>Entry Succeeded!</h2>
        <span>stock Date:</span><span>${entry.stockDate}</span><br/>
        <span>warehouse Id:</span><span>${entry.warehouseId}</span><br/>
        <span>product Id:</span><span>${entry.productId}</span><br/>
        <span>delivery From Production:</span><span>${entry.deliveryFromProduction}</span><br/>
        <span>rejection:</span><span>${entry.rejection}</span><br/>
        <span>start Up Lose:</span><span>${entry.startUpLose}</span><br/>
        
    </div>
</body>
</html>