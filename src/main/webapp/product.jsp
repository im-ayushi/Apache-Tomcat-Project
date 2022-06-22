<%@page import="controller.HibernateUtility"%>
<%@page import="javax.persistence.criteria.CriteriaQuery"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="domain.UserProduct"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="domain.UserDetails"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<!DOCTYPE web-app

<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="product.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Welcome</title>
</head>
<body>
<%
if(session.getAttribute("arg")==null)
{
response.sendRedirect("LoginPage.jsp");	
}

%>
<div class="row mx-auto d-flex justify-content-between">
<div class="col-lg-10 d-flex justify-content-center">
<h2 style="text-align: center; font-weight: bold;" class="prohead">Product Management Tool</h2>
</div>
<div class="col-lg-2">
<div class="row mt-2">
<div class="col-lg-7">
<h5 style="text-align: center; font-weight: bold;">Hello  <%=(String)session.getAttribute("username")%> </h5>
</div>
<div class="col-lg-5">
<form action="logout" method="post">
<input type="submit" value="Logout" class="btn btn-danger"></input>
</form>
</div>
</div>
</div>
</div>
<section>

<form method="post" action="addDetails">
	<h4 style="font-weight: bold;">Please Enter Product Details to add in the stock</h4>
  <div class="form-group row mb-2">
    <label for="" class="col-sm-1 col-form-label">Title</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  name="title" required="required">
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
    <div class="form-group row mb-2">
    <label for="" class="col-sm-1 col-form-label">Image</label>
    <div class="col-sm-10">
      <input type="file" class="form-control"  name="image">
    </div>
  </div>
<input type="submit" class="btn btn-primary"></input>
</form>
</section>
<table class="w3-table-all">
<thead>
<tr class="w3-green">
<th>Sno</th>
<th>Title</th>
<th>Quantity</th>
<th>Size</th>
<th>Image</th>
<th>Action</th>
</tr>
</thead>
<tr>
<%
Session sess=HibernateUtility.getSessionFactory().getCurrentSession();	
Transaction tx=sess.beginTransaction();
String name=(String)session.getAttribute("username");
String str="from UserProduct p where p.details_id="+"'"+name+"'";
TypedQuery<UserProduct> t2=sess.createQuery(str);


List<UserProduct> li=t2.getResultList();
tx.commit();
int count=1;
for(UserProduct p:li)
{
%>
<tr>
<td><%=count%></td>
<td><%=p.getName() %></td>
<td><%=p.getQuantity() %></td>
<td><%=p.getSize() %></td>
<td><img src="data:image/jpg;base64,<%=p.getBase64Image() %>" style="width:100px;height:100px"></td>
 <td>
 <form action="del" method="post">
 <input type="submit" class="btn btn-danger" value="Delete"></input>
   <input type="hidden" id="custId" name="pid" value=<%=p.getSno() %>></input>
 </form>
<form action="Edit.jsp" method="post">
<input type="submit" class="btn btn-primary" value="edit"></input>
<% session.setAttribute("pid",p.getSno());%>
 <input type="hidden" id="custId" name="pid" value=<%=p.getSno() %>></input>
</form>
 </td>
</tr>

<%
count+=1;
}
%>
</table>
</body>
</html>
