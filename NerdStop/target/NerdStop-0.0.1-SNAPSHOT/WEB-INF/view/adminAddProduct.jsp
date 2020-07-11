<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
     
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
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
            <!-- Navbar Header--><a href="index.html" class="navbar-brand"> 
              <div class="brand-text brand-big visible text-uppercase"><strong class="text-primary">Admin</strong><strong>Home</strong></div>
              <div class="brand-text brand-sm"><strong class="text-primary">D</strong><strong>A</strong></div> </a>
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
           <li ><a href="allUser"> <i class="fa fa-users"></i>All User </a></li>
       
          
         <li><a href="#example7" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Product </a>
            <ul id="example7" class="collapse list-unstyled ">
            <li><a href="adminproduct"> <i class="fa fa-product-hunt"></i>Add Product </a></li>
            <li><a href="adminallProduct"> <i class="fa fa-list-ol"></i>All Product </a></li>
            
            </ul>
          </li> 
            
         <li><a href="#example8" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Category</a>
            <ul id="example8" class="collapse list-unstyled ">
              <li><a href="admincategory"> <i class="fa fa-th"></i>Add Category </a></li>
            <li><a href="adminallcategory"> <i class="fa fa-bars"></i>All Category </a></li>
            
            </ul>
          </li> 



  
          <li><a href="#example9" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Supplier</a>
            <ul id="example9" class="collapse list-unstyled ">
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
            <div class="row">
              <div class="col-lg-12">
                <div class="block">
                
                <% String msg=request.getParameter("p");
                		if(msg!=null){
                			
                		
               if(msg.equals("su")){
            	   %>
            	<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Product Added Successfully!</strong> 
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
	<%   
               } }
            	   %>
           
                
                  <div class="title"><strong class="d-block text-center text-white">Add Products</strong></div>
                  <div class="block-body">
                    <form:form method="post" action="${pageContext.request.contextPath}/addProduct" enctype="multipart/form-data" modelAttribute="product">
                      <c:if test="${product.productName!=null }">
                      <div class="form-group">
                      
                        <label class="form-control-label"></label>
                        <form:input path="productId" type="hidden" class="form-control"/>
                      </div>
                      </c:if>
                      <div class="form-group">       
                        <label class="form-control-label">Product Name</label>
                        <form:input path="productName" type="text" placeholder="Enter product name" class="form-control"/>
                        <form:errors path="productName" class="error" ></form:errors>
                      </div>
                      <div class="form-group">       
                        <label class="form-control-label">Product Description</label>
                        <form:input path="productDesc" type="text" placeholder="Enter product description" class="form-control"/>
                        <form:errors path="productDesc" class="error"></form:errors>
                      </div>
                      <div class="form-group">       
                        <label class="form-control-label">Product Price</label>
                        <form:input path="productPrice" type="number" id="productPrice" placeholder="Enter product price" class="form-control"/>
                        <form:errors path="productPrice" class="error"></form:errors>
                      </div>
                      <div class="form-group">       
                        <label class="form-control-label">Product Stock</label>
                        <form:input path="productStock" type="text" id="productStock" placeholder="Enter product stock" class="form-control"/>
                        <form:errors path="productStock" class="error"></form:errors>
                      </div>
                      <div class="form-group">       
                        <label class="form-control-label">Product Image</label>
                        <form:input path="productImage" type="file"  class="form-control"/>
                      </div>
                      
                      <div class="form-group">
                      <strong><label for="categoryList">Category List</label></strong>
                      
                      <form:select path="categoryId" class="form-control">
                      <c:forEach items="${categoryList}" var="category">
                      <form:option value="${category.categoryId }">
                      ${category.categoryName}
                      </form:option>
                      </c:forEach>
                     </form:select>
                      </div>
                      
                      
                      <c:if test="${product.productName==null }">
                      <div class="form-group text-center">       
                        <input type="submit" value="Add Product" class="btn btn-primary">
                      </div>
                      </c:if>
                      
                      <c:if test="${product.productName!=null }">
                      <div class="form-group text-center">       
                        <input type="submit" value="Update Product" class="btn btn-primary">
                      </div>
                      </c:if>
                    </form:form>
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
    
    
    <script>

	
    
    
    </script>
  