<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
    <head>
    
    <style>
    .cc-img {
        margin: 0 auto;
    }
</style>
    </head>

<link rel="stylesheet"  type="text/css"  href="<c:url value="/resources/payment/bootstrap/css/bootstrap.min.css"/>">

<link rel='stylesheet' href="<c:url value="/resources/vendor/font-awesome/css/all.min.css"/>">

   <script src="<c:url value="/resources/payment/bootstrap/js/jquery-1.10.2.min.js"/>"> </script>
 <script src="<c:url value="/resources/payment/bootstrap/js/bootstrap.min.js"/>"> </script>
   

<div class="container">

<div class="page-header">

<h1 class="text-center ">Credit Card Payment Form </h1>

	
	<table class="table table-bordered " style="width:70rem;margin:0 auto; margin-bottom:2rem;"> 
	 <tbody>
	 <tr> 	 
	  <td>Name  </td> <td>${name}</td>	  
	  </tr>
	  
	  <tr> 	 
	  <td>Email Id  </td> <td>${email}</td>	  
	  </tr>
	  
	  <tr> 	 
	  <td>Grand Total  </td> <td>${total}</td>	  
	  </tr>
	   
	   
	   </tbody> 
	   </table> 

  
</div>

<!-- Credit Card Payment Form - START -->

<div class="container">
                <% String msg=request.getParameter("checkout");
                		if(msg!=null){
                			
                		
               if(msg.equals("su")){
            	   %>
            	<div class="alert alert-primary alert-dismissible fade show" role="alert">
  <strong>Order Placed Successfully !</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } }
            	   %>
    <div class="row">
        <div class="col-xs-12 col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h3 class="text-center">Payment Details</h3>
                        <img class="img-responsive cc-img" src="http://prepbootstrap.com/Content/images/shared/misc/creditcardicons.png">
                    </div>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label>CARD NUMBER</label>
                                    <div class="input-group">
                                        <input type="tel" class="form-control" placeholder="Valid Card Number" />
                                        <span class="input-group-addon"><span class="fa fa-credit-card"></span></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-7 col-md-7">
                                <div class="form-group">
                                    <label><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
                                    <input type="tel" class="form-control" placeholder="MM / YY" />
                                </div>
                            </div>
                            <div class="col-xs-5 col-md-5 pull-right">
                                <div class="form-group">
                                    <label>CV CODE</label>
                                    <input type="tel" class="form-control" placeholder="CVC" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="form-group">
                                    <label>CARD OWNER</label>
                                    <input type="text" class="form-control" placeholder="Card Owner Names" />
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="panel-footer">
                    <div class="row">
                        <div class="col-xs-12">
                            <a href="${pageContext.request.contextPath}/order/${cartId}" style="text-decoration:none"><button class="btn btn-warning btn-lg btn-block">Process payment</button></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Credit Card Payment Form - END -->

</div>

