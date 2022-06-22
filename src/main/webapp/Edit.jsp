<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<Link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
<%
if(session.getAttribute("arg")==null)
{
response.sendRedirect("LoginPage.jsp");	
}

%>
<form method="post" action="edit">
	<h4 style="font-weight: bold;">Please Enter Product Details to add in the stock</h4>
  <div class="form-group row mb-2">
    <label for="" class="col-sm-1 col-form-label">Title</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="title" required="required">
    </div>
  </div>
  <div class="form-group row mb-2">
    <label for="" class="col-sm-1 col-form-label">Quantity</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="quantity" required="required">
    </div>
  </div>
  <div class="form-group row mb-2">
    <label for="" class="col-sm-1 col-form-label">Size</label>
    <div class="col-sm-10">
      <input type="number" class="form-control" name="size" required="required">
    </div>
  </div>

<input type="submit" class="btn btn-primary"></input>
<% %>
</form>
</body>
</html>