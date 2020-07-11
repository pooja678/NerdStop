<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    


<body class="form-v10">
 <%@ include file="header_user.jsp" %>
	<div class="page-content">
		<div class="form-v10-content">
		
		  <% String register=request.getParameter("u");
                		if(register!=null){
                			
                		
               if(register.equals("su")){
            	   %>
            	<div class="alert alert alert-primary text-center alert-dismissible fade show" role="alert">
  <strong>Registered Successfully!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } }
            	   %>
		
		
			<form:form class="form-detail" action="${pageContext.request.contextPath}/addUser" modelAttribute="user"  method="post" id="myform">
				<div class="form-left">
					<h2>General Infomation</h2>
					<div class="form-row">
						<form:input path="userEmail" placeholder="Enter your email"/>
										</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<form:input path="userName" type="text"  id="first_name" class="input-text" placeholder="Enter Name" />
						</div>
						<div class="form-row form-row-2">
							<form:input path="userPassword" type="password" id="last_name" class="input-text" placeholder="Enter Password"/>
						</div>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<form:input path="userMobile" type="tel"  id="phone_number" class="input-text" placeholder="Enter Contact no."  />
						</div>
						<div class="form-row form-row-2">
							<form:input path="shipping.houseNumber" type="text"  id="house" class="input-text" placeholder="Enter house no."/>
						</div>
					</div>
					<div class="form-row">
						<form:input path="shipping.street" type="number" class="company" id="street" placeholder="Enter street no"/>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<form:input path="shipping.city" type="text"  id="cities" placeholder="Enter your city" />
						</div>
						<div class="form-row form-row-2">
					  <form:input path="shipping.landMark" placeholder="Enter landmark" id="landmark"/>
							
						</div>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<form:input path="shipping.state" type="text" id="state" class="input-text" placeholder="Enter state" />
						</div>
						<div class="form-row form-row-2">
							<form:input path="shipping.pinCode" type="number"  id="pincode" class="input-text" placeholder="Pin Code"/>
						</div>
					</div>
					
					
					<div class="form-checkbox">
						<label class="container"><p>Same as Above</p>
						  	<input type="checkbox" name="checkbox"  id="Same_as_Above">
						  	<span class="checkmark"></span>
						</label>
					</div>
					
					
					</div>
				
					
				<!-- ============================================================================ -->
				<div class="form-right">
					<h2>Contact Details</h2>
					<div class="form-row">
						<form:input path="billing.houseNumber" type="text" name="street" id="billing_house" placeholder="House +Nr" />
					</div>
					<div class="form-row">
						<form:input path="billing.street" type="number" name="additional"  id="billing_streetNo" placeholder="Street + Nr"/>
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<form:input path="billing.pinCode" type="number" name="zip" id="billing_pincode" placeholder="Pin Code" />
						</div>
						<div class="form-row form-row-2">
							
							<form:input path="billing.city" type="text" name="zip" id="billing_city" placeholder="City" />
						</div>
					</div>
					<div class="form-row">
					<form:input path="billing.landMark" type="text" name="zip"  id="billing_landmark" placeholder="Landmark" />
					</div>
					<div class="form-group">
						<div class="form-row form-row-1">
							<form:input path="billing.state" type="text" name="code" id="billing_state" placeholder="State" />
						</div>
						<div class="form-row form-row-2">
							<form:input path="userMobile" type="tel" name="phone" id="contact_no" placeholder="Phone Number"/>
						</div>
					</div>
					<div class="form-row-last">
						<input type="submit" name="register" class="register" value="Register">
					</div>
					
					<div class="col-sm-12">
<b style="color:white;padding-left:144px;">Already User? <a href=login style="color:white;"><u>Login</u></a></b>
</div>
					
					
					
				</div>
			</form:form>
		</div>
	</div>

	<script>
/* 	$('#contact_no').val(null);
	$('#pincode').val(null);
	$('#billing_pincode').val(null);

	$('#phone_number').val(null); */
	
	$('#Same_as_Above').click(function(){
	if($("#Same_as_Above")[0].checked)
		{
	$('#billing_state').val($('#state').val());

	$('#contact_no').val($('#phone_number').val());

	$('#billing_landmark').val($('#landmark').val());

    $('#billing_city').val($('#cities').val());

	$('#billing_pincode').val($('#pincode').val());

	$('#billing_streetNo').val($('#street').val());

	$('#billing_house').val($('#house').val());
	

	
	
		}
	else
		
		{
		
		$('#contact_no').val(null);
		$('#billing_state').val(null);
		$('#billing_landmark').val(null);
		$('#billing_city').val(null);		
		$('#billing_pincode').val(null);
		$('#billing_streetNo').val(null);
		$('#billing_house').val(null);
		
		}
	});
	
	</script>