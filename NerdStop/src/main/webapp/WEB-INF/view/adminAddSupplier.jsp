<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
       <%@ include file="header_admin.jsp" %>  
        
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
<header class="header">   
      <nav class="navbar navbar-expand-lg">
        <div class="search-panel">
          <div class="search-inner d-flex align-items-center justify-content-center">
            <div class="close-btn">Close <i class="fa fa-close"></i></div>
            <form id="searchForm" action="#">
              <div class="form-group">
                <input type="search" name="search" placeholder="What are you searching for...">
                <button type="submit" class="submit">Search</button>
              </div>
            </form>
          </div>
        </div>
        <div class="container-fluid d-flex align-items-center justify-content-between">
          <div class="navbar-header">
            <!-- Navbar Header--><a href="index.html" class="navbar-brand">
              <div class="brand-text brand-big visible text-uppercase"><strong class="text-primary">Admin</strong><strong>Home</strong></div>
              <div class="brand-text brand-sm"><strong class="text-primary">D</strong><strong>A</strong></div></a>
            <!-- Sidebar Toggle Btn-->
            <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
          </div>
          <div class="right-menu list-inline no-margin-bottom">    
            <!-- Log out  -->
            <div class="list-inline-item logout">                  
             <a id="logout" href="login" class="nav-link"> <span class="d-none d-sm-inline">Logout </span><i class="icon-logout"></i></a></div>
          </div> 

        </div>
      </nav>
    </header>
    <div class="d-flex align-items-stretch">
      <!-- Sidebar Navigation-->
      <nav id="sidebar">
        <!-- Sidebar Header-->
        <div class="sidebar-header d-flex align-items-center">
          <div class="avatar"><img src="img/avatar-6.jpg" alt="..." class="img-fluid rounded-circle"></div>
          <div class="title">
            <h1 class="h5">Pooja Rathdhaniya</h1>
            <p>Web Designer</p>
          </div>
        </div>
        <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
        <ul class="list-unstyled">
          <li class=""><a href="./"> <i class="icon-home"></i>Home </a></li>
           <li><a href="allUser"> <i class="fa fa-users"></i>All User </a></li>
              <!--  <li><a href="add_c"> <i class="fa fa-th"></i>Add Category </a></li>
            <li><a href="all_c"> <i class="fa fa-bars"></i>All Category </a></li>
             <li class="active"><a href="add_s"> <i class="fa fa-male"></i>Add Supplier </a></li>
             <li><a href="all_s"> <i class="fa fa-list-ul"></i>All Supplier </a></li> -->
          
          
        <li><a href="#examplex" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Product</a>
            <ul id="examplex" class="collapse list-unstyled ">
         <li><a href="adminproduct"> <i class="fa fa-product-hunt"></i>Add Product </a></li>
            <li><a href="adminallProduct"> <i class="fa fa-list-ol"></i>All Product </a></li>
            
            </ul>
          </li> 
          
          
          
                
         <li><a href="#exampley" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Category</a>
            <ul id="exampley" class="collapse list-unstyled ">
              <li><a href="admincategory"> <i class="fa fa-th"></i>Add Category </a></li>
            <li><a href="adminallcategory"> <i class="fa fa-bars"></i>All Category </a></li>
            
            </ul>
          </li> 
          
          
            
          <li><a href="#examplez" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Supplier</a>
            <ul id="examplez" class="collapse list-unstyled ">
           <li><a href="adminsupplier"> <i class="fa fa-male"></i>Add Supplier </a></li>
            <li><a href="adminallsupplier"> <i class="fa fa-list-ol"></i>All Supplier </a></li>
            
            </ul>
          </li>

          <li><a href="login"> <i class="icon-logout"></i>Login page </a></li>
        </ul>
              </nav>
      <!-- Sidebar Navigation end-->
      <div class="page-content">
        <div class="page-header">
          <div class="container-fluid">
           
            
            
            
            <!-- Basic Form-->
              <div class="col-lg-12">
                <div class="block">
                
                <% String msg=request.getParameter("s");
                		if(msg!=null){
                			
                		
               if(msg.equals("su")){
            	   %>
            	<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Supplier Added Successfully!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } }
            	   %>
                
                
                  <div class="title"><strong class="d-block text-center">Add Supplier</strong></div>
                  <div class="block-body">
                    <form:form method="post" action="${pageContext.request.contextPath}/addSupplier"  modelAttribute="supplier">
                      <c:if test="${supplier.supplierName!=null }">
                      <div class="form-group">
                      
                        <label class="form-control-label"></label>
                        <form:input path="supplierId" type="hidden"  class="form-control"/>
                      </div>
                      </c:if>
                      
                      <div class="form-group">       
                        <label class="form-control-label">Supplier Name</label>
                        <form:input path="supplierName" type="text" placeholder="Enter supplier name" class="form-control"/>
                      </div>
                      <div class="form-group">       
                        <label class="form-control-label">Supplier Address</label>
                        <form:input path="supplierAdd" type="text" placeholder="Enter supplier address" class="form-control"/>
                      </div>
                        <div class="form-group">       
                        <label class="form-control-label">Supplier Contact</label>
                        <form:input path="supplierContact" type="text" placeholder="Enter supplier contact number" class="form-control"/>
                      </div>
                      
                      
                      <c:if test="${supplier.supplierName==null }">
                      <div class="form-group text-center">       
                        <input type="submit" value="Add Supplier" class="btn btn-primary">
                      </div>
                      </c:if>
                      
                      <c:if test="${supplier.supplierName!=null }">
                      <div class="form-group text-center">       
                        <input type="submit" value="Update supplier" class="btn btn-primary">
                      </div>
                      </c:if>
                    </form:form>
                  </div>
                </div>
              </div>
              
          </div>
        </div>
       

<!-- main work here start. -->


<!-- main work here end. -->


        
        <footer class="footer">
          <div class="footer__block block no-margin-bottom">
            <div class="container-fluid text-center">
             <p class="no-margin-bottom">2020 &copy; Your company. Design by <a href="https://bootstrapious.com/p/bootstrap-4-dark-admin">PoojaRathdhaniya</a>.</p>
            </div>
          </div>
        </footer>
      </div>
    </div>