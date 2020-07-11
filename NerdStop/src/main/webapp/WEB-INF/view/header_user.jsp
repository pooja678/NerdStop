
   <%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 
<head>
<link rel="stylesheet"  type="text/css"  href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css"/>">

<link rel='stylesheet' href="<c:url value="/resources/vendor/font-awesome/css/all.min.css"/>">



<link rel="stylesheet"  type="text/css"  href="<c:url value="/resources/vendor/css/user.css"/>">

<link rel="stylesheet"  type="text/css"  href="<c:url value="/resources/vendor/css/product.css"/>">

<link href="https://fonts.googleapis.com/css2?family=Caveat:wght@700&display=swap" rel="stylesheet">

<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/css/montserrat-font.css"/>">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/fonts/material-design-iconic-font/css/material-design-iconic-font.min.css"/>">
	<!-- Main Style Css -->
    <link rel="stylesheet" href="<c:url value="/resources/vendor/css/style.css"/>">
    
      <script src="<c:url value="/resources/vendor/jquery/jquery.slim.min.js"/>"> </script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>"> </script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"> </script>
      
    

</head>

<nav class="navbar navbar-expand-lg navbar navbar-light " style="background-color: #e3f2fd; border-bottom: 5px solid #929fba;">
  <a class="navbar-brand" href="./"><img src="${pageContext.request.contextPath}\resources\custom\img\demo.svg" height="30px" width="50px"><b>
  <i style="font-family:Caveat;font-size: x-large;">NerdStop</i></b></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

<div> 
    
 </div> 

      

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
<ul class="navbar-nav mr-auto">
     
    
      
      
     <!--    Level one dropdown -->
        <li class="nav-item dropdown ">
          <a id="dropdownMenu1" href="#" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" class="nav-link dropdown-toggle">
          
          <strong>
            <% String category=request.getParameter("c");
                		if(category!=null)
                		out.println(category);
                		else
                			out.println("Category");
                		
 
                		
             
            	   %> 
          </strong>
         </a>
          <ul aria-labelledby="dropdownMenu1" class="dropdown-menu border-0 shadow">
          
            
           <c:if test="${categoryList !=null}">
          <c:forEach var="category" items="${categoryList}">
            <li><a href="${pageContext.request.contextPath}/${category.categoryId}?c=${category.categoryName}" class="dropdown-item">${category.categoryName}</a></li>
        </c:forEach>
         </c:if>
         
      
           
           
           
          </ul>
        </li>
 <!--        End Level one -->

        
      </ul> 
     <!--  -->
  

        
    <div class="search-box">
    <form class="form-inline my-2 my-lg-0" style="margin-left:-34px">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0 " type="submit">Search</button>
    </form>
    </div>
     <ul class="nav navbar-nav navbar-right">
     <security:authorize access="hasRole('ROLE_ADMIN')"><li><a href="adminhome" class="nav-link" ><span></span> <i class="fas fa-user-shield"></i><strong> Admin</strong></a></security:authorize>
       
       <c:if test="${pageContext.request.userPrincipal.name != null}">
        <li><a class="nav-link"  href="#"><strong>Welcome:</strong> <b class="text-danger">${pageContext.request.userPrincipal.name}</b></a></li>
       <li><a class="nav-link"  href="${pageContext.request.contextPath}/cart"><i class="fas fa-cart-plus"></i><strong> Cart</strong></a></li>
       </c:if>
         <li><a href="register" class="nav-link"  > <i class="fas fa-users"></i><strong> SignUp</strong></a></li>
         <security:authorize access="isAnonymous()"><li><a href="login" class="nav-link"  > <i class="fas fa-sign-in-alt"></i><strong> Login</strong></a></li></security:authorize>
       
       <security:authorize access="isAuthenticated()"><li><a href="logout" class="nav-link"  ><i class="fas fa-sign-out-alt"></i><strong> Logout</strong></a></li></security:authorize> 
     
     
    
    </ul>
    
    
    
     </div>
</nav>


 
 <script type="text/javascript">

$(function() {
	  // ------------------------------------------------------- //
	  // Multi Level dropdowns
	  // ------------------------------------------------------ //
	  $("ul.dropdown-menu [data-toggle='dropdown']").on("click", function(event) {
	    event.preventDefault();
	    event.stopPropagation();

	    $(this).siblings().toggleClass("show");


	    if (!$(this).next().hasClass('show')) {
	      $(this).parents('.dropdown-menu').first().find('.show').removeClass("show");
	    }
	    $(this).parents('li.nav-item.dropdown.show').on('hidden.bs.dropdown', function(e) {
	      $('.dropdown-submenu .show').removeClass("show");
	    });

	  });
	});

</script>
