<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
 <%@ include file="header_user.jsp" %>
  
  
  <head>
  
<!-- <link rel="stylesheet"  type="text/css"  href="resources/vendor/css/slick.css">

<link rel="stylesheet"  type="text/css"  href="resources/vendor/css/slick-theme.css"> -->

  

 <style>
 .shop {
  position: relative;
  overflow: hidden;
  margin: 15px 0px;
}

.shop:before {
  content: "";
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0px;
  width: 60%;
  background: #D10024;
  opacity: 0.9;
  -webkit-transform: skewX(-45deg);
  -ms-transform: skewX(-45deg);
  transform: skewX(-45deg);
}

.shop:after {
  content: "";
  position: absolute;
  top: 0;
  bottom: 0;
  left: 1px;
  width: 100%;
  background: #D10024;
  opacity: 0.9;
  -webkit-transform: skewX(-45deg) translateX(-100%);
  -ms-transform: skewX(-45deg) translateX(-100%);
  transform: skewX(-45deg) translateX(-100%);
}

.shop .shop-img {
  position: relative;
  background-color: #E4E7ED;
  z-index: -1;
 width:330px;
 height:219px ;
}

.shop .shop-img>img {
  width: 100%;
  -webkit-transition: 0.2s all;
  transition: 0.2s all;
  height:inherit;
  
}

.shop:hover .shop-img>img {
  -webkit-transform: scale(1.1);
  -ms-transform: scale(1.1);
  transform: scale(1.1);
}

.shop .shop-body {
  position: absolute;
  top: 0;
  width: 75%;
  padding: 30px;
  z-index: 10;
}

.shop .shop-body h3 {
  color: #FFF;
}

.shop .shop-body .cta-btn {
  color: #FFF;
  text-transform: uppercase;
}



#hot-deal.section {
  padding: 60px 0px;
  margin: 30px 0px;
  background-color: #E4E7ED;
  background-image: url('resources/custom/img/hotdeal.png');
  background-position: center;
  background-repeat: no-repeat;
}

.hot-deal {
  text-align: center;
}

.hot-deal .hot-deal-countdown {
  margin-bottom: 30px;
}

.hot-deal .hot-deal-countdown>li {
  position: relative;
  display: inline-block;
  width: 100px;
  height: 100px;
  background: #D10024e6;
  text-align: center;
  border-radius: 50%;
  margin: 0px 5px;
}

.hot-deal .hot-deal-countdown>li>div {
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  -webkit-transform: translateY(-50%);
  -ms-transform: translateY(-50%);
  transform: translateY(-50%);
}

.hot-deal .hot-deal-countdown>li>div h3 {
  color: #FFF;
  margin-bottom: 0px;
}

.hot-deal .hot-deal-countdown>li>div span {
  display: block;
  font-size: 10px;
  text-transform: uppercase;
  color: #FFF;
}

.hot-deal p {
  text-transform: uppercase;
  font-size: 24px;
}

.hot-deal .cta-btn {
  margin-top: 15px;
}


.primary-btn {
    display: inline-block;
    padding: 12px 30px;
    background-color: #D10024;
    border: none;
    border-radius: 40px;
    color: #FFF;
    text-transform: uppercase;
    font-weight: 700;
    text-align: center;
    -webkit-transition: 0.2s all;
    transition: 0.2s all;
}

.hot-deal .cta-btn:hover,.hot-deal .cta-btn:focus {
  color:white;
  text-decoration: none;
  outline: none;
}




/*  */

 </style>

 </head>

 <div class="container-fluid">
 
 
<div id="hot-deal" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<div class="hot-deal">
							<ul class="hot-deal-countdown">
								<li>
									<div>
										<h3>02</h3>
										<span>Days</span>
									</div>
								</li>
								<li>
									<div>
										<h3>10</h3>
										<span>Hours</span>
									</div>
								</li>
								<li>
									<div>
										<h3>34</h3>
										<span>Mins</span>
									</div>
								</li>
								<li>
									<div>
										<h3>60</h3>
										<span>Secs</span>
									</div>
								</li>
							</ul>
							<h2 class="text-uppercase">hot deal this week</h2>
							<p>New Collection Up to 50% OFF</p>
							<a class="primary-btn cta-btn" href="#">Shop now</a>
						</div>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>

 
 <!-- product test by pooja start here -->
<div class="row">
    <c:if test="${productList !=null}">         
            <c:forEach items="${productList}" var="product"> 
            <div class="col-sm-12 col-md-3 col-xl-3">             
            <div class="product-main-box">            
            <div class="inner-product-box">
            <div class="product-details">          
             <img src="resources/images/${product.productId}.jpg" style="height:219px">
            <ul>               
         <li><strong>${product.productName }</strong></li>
            <li>${product.productDesc }</li>           
            <li class="text-danger h5"><i class="fas fa-rupee-sign"> ${product.productPrice}</i></li>       
            </ul>   
            </div>   
            <a class="btn-view w-100 rounded-0 text-white" href="${pageContext.request.contextPath}/view-product/${product.productId}"> <b class="bg-info"><i class="far fa-eye"> Quick View </i></b></a>
			</div> 
			<a class="btn-hover w-100 rounded-0 text-white" href="${pageContext.request.contextPath}/addToCart/${id}"> <b><i class="fas fa-shopping-cart"> Add to Cart </i></b></a>
			</div>
			</div>			   
      </c:forEach>
     </c:if>
</div>
  <hr style="border-bottom: 2px solid #E4E7ED; width:100%">

<!--  --> <div class="row">
 <div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="resources/custom/img/shop01.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Accessories<br>Collection</h3>
								<a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="resources/custom/img/shop02.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Accessories<br>Collection</h3>
								<a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
					
					<div class="col-md-4 col-xs-6">
						<div class="shop">
							<div class="shop-img">
								<img src="resources/custom/img/shop03.png" alt="">
							</div>
							<div class="shop-body">
								<h3>Accessories<br>Collection</h3>
								<a href="#" class="cta-btn">Shop now <i class="fa fa-arrow-circle-right"></i></a>
							</div>
						</div>
					</div>
 </div>



 </div>

<%@ include file="footer_user.jsp" %>

