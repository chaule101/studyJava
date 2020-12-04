<%@ page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
 <base href="${pageContext.servletContext.contextPath}/">
  <title>LAYOUT</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 50%}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      padding-bottom :400px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      height: auto;
      position: relative;
      bottom: 0;
    
      
  
  
      
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 5px;
        
        
      }
      .row.content {height:auto;} 
    }
    p{
    	padding : 30px;
    	font-size: 13px;
    
    }
     .registerbtn {
                  background-color: #4CAF50;
                  color: white;
                  padding: 6px 10px;
                  margin: 8px 0;
                  border: none;
                  cursor: pointer;
                  width: 10%;
                  opacity: 2;
                }
     hr {
                  border: 2px solid #black;
                 
                } 
     input[type=text], input[type=password] {
                  width: 100%;
                  padding: 5px;
                  margin: 5px 0 22px 0;
                  display: inline-block;
                  border: none;
                  background: #f1f1f1;
                }                      
   
   h5{
	color : #A52A2A;
	font-size: 10px;
	}
    	
    
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="#">Logo</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Home</a></li>
        <li><a href="#">About</a></li>
        <li><a href="#">Projects</a></li>
        <li><a href="#">Contact</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="checkLogin.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      
      <p><a href="depart/index.htm">Phòng Ban</a></p> <hr>
      <p><a href="user/index.htm">Người Dùng</a></p> <hr>
       <p><a href="staff/index.htm">Nhân Viên</a></p> <hr>
      <p><a href="record/index.htm">Thành Tích</a></p> <hr>
    </div>
    <!-- article -->
    <div class="col-sm-10 text-left"> 
     
     
      
		
    </div>
    
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
