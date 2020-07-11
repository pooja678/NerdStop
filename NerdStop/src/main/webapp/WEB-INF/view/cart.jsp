<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
    
  
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@ include file="header_user.jsp" %>
    

    <%@ page import="com.ecom.model.Cart" %>
    
    <head>
    <style>
    .product-box{
   background-image:url(${pageContext.request.contextPath}/resources/custom/img/light.jpg);
    background-size:cover;
    bockground-repeat:repeat;
     
    }
    </style>
    </head>


 <div class="product-box p-4">
 <div class="container">
  <c:if test="${item!=null}">  
 
<h2 class="text-center shadow bg-info mt-3 mb-3 text-white p-2 rounded border-primary border-bottom " style="border-bottom-width: 5px !important;">CART ITEMS</h2>
<div class="text-center d-flex justify-content-between">

<strong class="m-1  bg-warning text-white p-2 rounded">Grand Total : <i>${total}</i></strong> <a class=" m-1 btn btn-success text-white" href="${pageContext.request.contextPath}/checkout">Check Out</a>
</div>
 
                <% String msg=request.getParameter("remove");
                		if(msg!=null){
                			
                		
               if(msg.equals("su")){
            	   %>
            	<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <strong>Item Removed Successfully !</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } }
            	   %>



 <table class="table table-bordered mt-2 shadow bg-white">
  <thead class="bg-dark text-white">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Product Image</th>
      <th scope="col">Product Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Price</th>
      <th scope="col">Product Remove</th>
      
    </tr>
  </thead>
    
 
  <tbody>
  <% int i = 0; %>
  <c:forEach items="${item}" var="item">
<% i++;%>
   <tr>	

	<th scope="row"><% out.println(i); %></th>
	<td>
<img src="${pageContext.request.contextPath}/resources/images/${item.product.productId}.jpg" class="w-25 rounded">
	</td>
	<td>${item.product.productName}</td>
	<td>${item.quantity}</td>
	<td>${item.totalPrice}</td>
	<td><a href="${pageContext.request.contextPath}/remove/${item.cartItemID}" class="btn btn-danger">Remove</a></td>
 
 
  
    </tr> 
    </c:forEach> 
  </tbody>  
		
</table>
</c:if>	
<div class="text-center d-flex justify-content-between">

<strong class="m-1  bg-warning text-white p-2 rounded">Grand Total : <i>${total}</i></strong> <a class=" m-1 btn btn-success text-white" href="${pageContext.request.contextPath}/checkout">Check Out</a>
</div>
</div>
 </div>
 
   <%@ include file="footer_user.jsp" %>