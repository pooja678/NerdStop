<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    
    
 <%@ include file="header_admin.jsp" %>  
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
            <!-- Navbar Header--> <a href="index.html" class="navbar-brand"> 
              <div class="brand-text brand-big visible text-uppercase"><strong class="text-primary">Admin</strong><strong>Home</strong></div>
              <div class="brand-text brand-sm"><strong class="text-primary">D</strong><strong>A</strong></div></a> 
            <!-- Sidebar Toggle Btn-->
            <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
          </div>
          <div class="right-menu list-inline no-margin-bottom">    
            <!-- Log out  -->
            <div class="list-inline-item logout">                  
             <a id="logout" href="login.html" class="nav-link"> <span class="d-none d-sm-inline">Logout </span><i class="icon-logout"></i></a></div>
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
           <li class=""><a href="allUser"> <i class="fa fa-users"></i>All User </a></li>
             <!--   <li><a href="add_c"> <i class="fa fa-th"></i>Add Category </a></li>
               <li><a href="add_s"> <i class="fa fa-male"></i>Add Supplier </a></li>
             <li><a href="all_s"> <i class="fa fa-list-ul"></i>All Supplier </a></li>
           -->
       <li><a href="#example4" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Product</a>
            <ul id="example4" class="collapse list-unstyled ">
         <li><a href="adminproduct"> <i class="fa fa-product-hunt"></i>Add Product </a></li>
            <li><a href="adminallProduct"> <i class="fa fa-list-ol"></i>All Product </a></li>
            
            </ul>
          </li> 
          
          <li><a href="#example5" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Category</a>
            <ul id="example5" class="collapse list-unstyled ">
              <li><a href="admincategory"> <i class="fa fa-th"></i>Add Category </a></li>
            <li><a href="adminallcategory"> <i class="fa fa-bars"></i>All Category </a></li>
            
            </ul>
          </li> 
          
            
          <li><a href="#example6" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Supplier</a>
            <ul id="example6" class="collapse list-unstyled ">
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
           
            <div class="row">
            <div class="col-lg-12">
                <div class="block">
                
                <p class="details"><a href="adminproduct" class="text-white"><i class="fa fa-plus text-left  rounded-circle  p-2 border border-white"></i></a></p>
                <!-- "redirect:/add_all?er_mes=su"; -->
                <% String msg=request.getParameter("msg");
                		if(msg!=null){
                			
                		
               if(msg.equals("deletesuccess")){
            	   %>
            	<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Product Deleted Successfully!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } 
               
         		
               if(msg.equals("deleteer")){
            	   %>
            	<div class="alert alert-danger alert-dismissible fade show" role="alert">
  <strong>Product Not Deleted!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } 
               if(msg.equals("successupdate")){
            	   %>
            	<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Product Updated Successfully!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } 
             
                		
                		}
            	   %>
            	   
            	   
            	   
            	   
            	   
            	
            	   
                  <div class="title text-center"><strong>Product Details</strong></div>
                  <div class="table-responsive"> 
                  
              <c:if test="${productList !=null}">
                    <table class="table table-striped table-hover">
                      <thead>
                        <tr>
                          <th scope="col">Product Id</th>
                          <th scope="col">Product Name</th>
                          <th scope="col">Product Desc</th>
                          <th scope="col">Product Price</th>
                          <th scope="col">Product Stock</th>
                          <th scope="col">Action</th>
                          
                         
                       </tr>
                      </thead>
                      
    <c:forEach items="${productList}" var="product" >
                      <tbody>
                        <tr>
                          <th scope="row">${pro.productId}</th>
                          
                  
                  <td>${product.productName }</td>
                  <td>${product.productDesc }</td>
                  <td>${product.productPrice}</td>
                  
                  <td>${product.productStock }</td>
                 <td>
                 
                 <div class="btn-group" role="group" aria-label="Basic example">
           <a href="${pageContext.request.contextPath}/updateProduct/${product.productId}" class="btn btn-secondary ">
	       <i class="fa fa-edit"></i>
           </a>

           <a href="${pageContext.request.contextPath}/deleteProduct/${product.productId}" class="btn btn-secondary " onclick="return confirm('Are you sure you want to delete this item?');">
           <i class="fa fa-trash"></i></a>
</div>
                 </td>                       
                           </tr>
                       </tbody>
                       </c:forEach>
                    </table>
                    </c:if>
                  </div>
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
    
    
    
   