


<%@ include file="header_user.jsp" %>
<style>

body, html {
    height: 100%;
    background-repeat: no-repeat;
    /* background-image: linear-gradient(rgb(104, 145, 162), rgb(12, 97, 33));  */
    background-image:url(resources/custom/img/loginbg.png);
    background-size:cover;
    background-position:center;
}

</style>
  
    <div class="container">
        <div class="card card-container">
             <img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form class="form-signin" action="logg"   method="post">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="email" name="inputEmail" class="form-control" placeholder="Email address" required autofocus>
                <input type="password" name="inputPassword" class="form-control" placeholder="Password" required>
                <div id="remember" class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
            </form><!-- /form -->
            <a href="#" class="forgot-password">
                Forgot the password?
            </a>
        </div><!-- /card-container -->
    </div><!-- /container -->
    
    
     