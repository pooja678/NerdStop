<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <%@ include file="header_user.jsp" %>
    
    <style>
    .product  .add-to-cart-btn {
  position: relative;
  border: 2px solid transparent;
  height: 40px;
  padding: 0 30px;
  background-color: #ef233c;
  color: #FFF;
  text-transform: uppercase;
  font-weight: 700;
  border-radius: 40px;
  -webkit-transition: 0.2s all;
  transition: 0.2s all;
}

.product  .add-to-cart-btn>i {
  position: absolute;
  left: 0;
  top: 0;
  width: 40px;
  height: 40px;
  line-height: 38px;
  color: white;
  opacity: 0;
  visibility: hidden;
}

.product .add-to-cart-btn:hover {
  background-color: #FFF;
  color: white;
  border-color: gray;
  padding: 0px 30px 0px 50px;
}

.product  .add-to-cart-btn:hover>i {
  opacity: 1;
  visibility: visible;
}
    body, html {
    
    background-repeat:repeat;
    /* background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));
    
    linear-gradient(38deg, rgba(0,14,36,0.3) 0%, rgba(5,213,255,0.3) 100%),  */

    background-image: url(${pageContext.request.contextPath}/resources/custom/img/img1.jpg);
    background-size:50%;
    background-position:center;
}
    
.product-details{
background-color:white;
margin-top:2rem;
margin-bottom:5rem;

}
    </style>
    
<div class="container">

 
                <% String msg=request.getParameter("cartItem");
                		if(msg!=null){
                			
                		
               if(msg.equals("su")){
            	   %>
            	<div class="alert alert-primary mt-3 alert-dismissible fade show" role="alert">
  <strong>Item Successfully Added To The Cart!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } }
            	   %>

<div class="row  product-details rounded shadow p-3 border border-primary">
<c:if test="${product!=null}"> 

<div class="col-md-6">
<div class="m-2 p-1 text-right">	
 <img src="${pageContext.request.contextPath}/resources/images/${product.productId}.jpg" class="w-100 rounded">
</div>
</div>
<div class="col-md-6">
<div class="m-2 p-1">

<h2 class=" mt-2 text-info"><strong>${product.productName }</strong></h2>

          <p><strong>Description :- ${product.productDesc }</strong> </p>           
           <p class="text-danger h5">Price :- <i class="fas fa-rupee-sign"> ${product.productPrice}</i></p> 
         
         <div class="product">
         	<strong>Quantity :-</strong>
         	<input type="number" value="${product.quantity }">
         	<br>
         	<br> 
         	<a href="${pageContext.request.contextPath}/add/${product.productId}"><button class="add-to-cart-btn m-1 bg-info" ><i class="fa fa-shopping-cart"></i> add to cart</button></a>
         	<a href="${pageContext.request.contextPath}/cart"><button class="add-to-cart-btn ml-2 m-1 bg-info" ><i class="far fa-credit-card"></i> Buy Now</button></a>
         	</div>
</div>

 </div> 

                  
</c:if>
        
</div>

</div>



<%@ include file="footer_user.jsp" %>