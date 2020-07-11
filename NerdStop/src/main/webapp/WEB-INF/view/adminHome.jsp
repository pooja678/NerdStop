   
	 
  <%@ include file="header_admin.jsp" %>  
  </head>
  <body>
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
          <div class="avatar"><img src="resources/custom/img/p.jpg" alt="..." class="img-fluid rounded-circle"></div>
          <div class="title">
            <h1 class="h5">Pooja Rathdhaniya</h1>
            <p>Web Designer</p>
          </div>
        </div>
        <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
        <ul class="list-unstyled">
          <li class="active"><a href="./"> <i class="icon-home"></i>Home </a></li>
           <li class=""><a href="allUser"> <i class="fa fa-users"></i>All User </a></li>
        
          
           <li><a href="#example1" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Product</a>
            <ul id="example1" class="collapse list-unstyled ">
           <li><a href="adminproduct"> <i class="fa fa-product-hunt"></i>Add Product </a></li>
            <li><a href="adminallProduct"> <i class="fa fa-list-ol"></i>All Product </a></li>
            
            </ul>
          </li> 
          
          <li><a href="#example2" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Category</a>
            <ul id="example2" class="collapse list-unstyled ">
              <li><a href="admincategory"> <i class="fa fa-th"></i>Add Category </a></li>
            <li><a href="adminallcategory"> <i class="fa fa-bars"></i>All Category </a></li>
            
            </ul>
          </li> 
          
           
          <li><a href="#example3" aria-expanded="false" data-toggle="collapse"> <i class="icon-windows"></i>Supplier</a>
            <ul id="example3" class="collapse list-unstyled ">
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
            <h2 class="h5 no-margin-bottom">Dashboard</h2>
            
            
            
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
    
    