

<%-- 
    Document   : login
    Created on : Feb 22, 2020, 9:18:42 AM
  
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Check Login</title>
    <link rel="stylesheet" href="css/c06.css" />
    <style>
    @import url(http://fonts.googleapis.com/css?family=Oswald);

body {
  background-color: #000;
  font-family: 'Oswald', 'Futura', sans-serif;
  margin: 0; 
  padding: 0;}

#page {
  background-color: #403c3b;
  margin: 0 auto 0 auto;}
  /* Responsive page rules at bottom of style sheet */

h1 {
  background-image: url(../images/kinglogo.png);
  background-repeat: no-repeat;
  background-position: center center;
  text-align: center;
  text-indent: -1000%;
  height: 75px;
  line-height: 75px;
  width: 117px;
  margin: 0 auto 0 auto;
  padding: 30px 10px 20px 10px;}

h2 {
  color: #fff;
  font-size: 24px;
  font-weight: normal;
  text-align: center;
  text-transform: uppercase;
  letter-spacing: .3em;
  margin: 0 0 23px 0;}

h2 span {
  background-color: #fff;
  color: #000;
  font-size: 12px;
  text-align: center;
  letter-spacing: 0;
  display: inline-block;
  position: relative;
  border-radius: 50%;
  top: -5px;
  height: 22px;
  width: 26px;
  padding: 4px 0 0 0;}

ul {
  background-color: #584f4d;
  border:none;
  padding: 0;
  margin: 0;}

li {
  background-color: #ec8b68;
  color: #fff;
  border-top: 1px solid #fe9772;
  border-bottom: 1px solid #9f593f;
  font-size: 24px;
  letter-spacing: .05em;
  list-style-type: none;
  text-shadow: 2px 2px 1px #9f593f;
  height: 50px;
  padding-left: 1em;
  padding-top: 10px;}

li a {
  color: #fff;
  background-image: url('../images/icon-link.png');
  background-position: right, center;
  background-repeat: no-repeat;
  text-decoration: none;
  padding-right: 36px;}

li.complete a {
  background-image: none;}

p {
  background-color: #7f675c;
  color: #e3dfdd; 
  padding: 10px;
  margin: 20px auto;
  min-width: 20%; 
  max-width: 80%; 
  border-radius: 5px;
  text-align: center;
  text-shadow: -1px 1px 0 #333;
  -webkit-box-shadow: inset 1px -1px 0 0 #a5948c;
  box-shadow: inset 1px -1px 0 0 #a5948c;}

.hot {
  background-color: #d7666b;
  color: #fff;
  text-shadow: 2px 2px 1px #914141;
  border-top: 1px solid #e99295;
  border-bottom: 1px solid #914141;}

.cool {
  background-color: #6cc0ac;
  color: #fff;
  text-shadow: 2px 2px 1px #3b6a5e;
  border-top: 1px solid #7ee0c9;
  border-bottom: 1px solid #3b6a5e;}

.complete {
  background-color: #999;
  color: #fff;
  background-image: url("../images/icon-trash.png");
  background-position: right, center;
  background-repeat: no-repeat;
  border-top: 1px solid #666;
  border-bottom: 1px solid #b0b0b0;
  text-shadow: 2px 2px 1px #333;}

.complete a {display:block;}


/* Form styles */

form {
  padding: 0 60px 65px 60px;}

label {
  color: #fff;
  display: block;
  margin: 10px 0 10px 0;
  font-size: 24px;}

input[type='text'], input[type='password'], textarea {
  background-color: #999;
  color: #666;
  font-family: 'Oswald', 'Futura', sans-serif;
  font-size: 24px;
  width: 96%;
  padding: 4px 6px;
  border: 1px solid #999;
  border-radius: 8px;}

input[type='text']:focus, input[type='password']:focus, textarea:focus {
  border: 1px solid #fff;
  background-color: #fff;
  outline: none;}

input[type='button'], a.add {
  background-color: #cb6868;
  color: #f3dad1;
  border: none;
  border-radius: 5px;
  padding: 8px 10px;
  margin-top: 10px;
  float: right;
  font-size: 18px;
  text-decoration: none;
  text-transform: uppercase;}

input[type='submit']:hover, a.add:hover {
  background-color: #d75359;
  color: #f3dad1;
  cursor: pointer;
  box-shadow: none;
  position: relative;
  top: 1px;}

textarea {
  width: 96%;
  height: 5em;
  line-height: 1.4em;}

select, option {
  font-size: 16px;}


#feedback, #termsHint {
  color: #fff;
  background-image: url('../images/warning.png');
  background-repeat: no-repeat;
  background-position: 2px 14px;
  padding: 10px 0 0 22px;}

#feedback.warning {background-image: url('../images/warning.png');}
#feedback.tip {background-image: url('../images/tip.png');}

#packageHint {
  color: #fff;
  background-image: url('../images/hint.png');
  background-repeat: no-repeat;
  background-position: 2px 5px;
  padding-left: 22px;}

.selectbox {
  display: inline;}

.checkbox {
  display: inline;
  font-size: 16px;}

/* Click event example - note style */
#note {
  color: #fff;
  background-color: #000;
  opacity: 0.9;
  box-shadow: -3px 3px 6px #000;
  padding: 1em 1em 2em 1em;
  height: 95%;
  width: 95%;
  position: absolute;
  top: 1em;
  left: 0;}

#note .header + div {
  background: rgb(255, 255, 255);
  background: rgba(255, 255, 255, 1);
  position: relative;
  text-align: center;
  top: 1px;
  color: #d7666b;
  padding: 20px;
  margin: 30px;
  border: 1px solid #d7666b;}

#note h2 {
  color: #d7666b;
  padding-top: 20px;
  padding-bottom: 20px;}

#note a {
  text-decoration: none;
  color: #fff;}

#note .header {
  text-align: right;
  background-color: #000;
  border: none;
  padding: 0 0 0 10px;}

.shown {
  visibility: visible;}

.hidden {
  visibility: hidden;}


/* Position Example */
#stats {
  background-color: #6cc0ac;
  color: #ffffff; 
  position: fixed; 
  top: 0; 
  left: 0; 
  padding: 20px; 
  width: 100%;}

#stats input[type="text"] {
  width: 80px;
  margin: 0 10px 0 10px;
  background-color: #fff;
  border-color: #fff;}

#body #page {margin-top: 130px;}

.divider {
  margin: 0 40px; 
  border-left: 1px solid #fff; 
  border-right: 1px solid #fff; 
  color: #6cc0ac;}


/* Character Counter */
#charactersLeft {
  color: #fff;
  font-size: 24px;}
#lastKey {
  color: #fff;
  margin-top: 10px;}


/* Membership Options */
#packageHint, #termsHint {
  color: #fff;
  text-shadow: -1px 1px 2px #000;}

#terms {
  margin-top: 30px;}

/* Mutation */
#list, #list2 {
  margin-bottom: 10px;}
div.button {
  height: 65px;
  padding-right: 10px;}

/* Example */
a[data-state='stop'] {background-image: url('../images/pause.png');}
a[data-state='record'] {background-image: url('../images/record.png');}
#buttons {
  height: 100px;
  width: 100px;
  margin: 0 auto;}
#buttons a {
  width: 100px;
  height: 100px; 
  text-indent: 100%;
  margin-top: 20px;
  display: inline-block;
  white-space: nowrap;
  overflow: hidden;}


/* Small screen - acts like the app would */
@media only screen and (max-width: 500px) {
  body {
    background-color: #403c3b;
  }
  #page {
    max-width: 480px;
  }
}
@media only screen and (min-width: 501px) and (max-width: 767px) {
  #page {
    max-width: 480px;
    margin: 20px auto 20px auto;
  }
}
@media only screen and (min-width: 768px) and (max-width: 959px) {
  #page {
    max-width: 480px;
    margin: 20px auto 20px auto;
  }
}
/* Larger screens act like a demo for the app */
@media only screen and (min-width: 960px) {
  #page {
    max-width: 480px;
    margin: 20px auto 20px auto;
  }
}
@media (-webkit-min-device-pixel-ratio: 2), (min-resolution: 192dpi) { 
  h1{
    background-image: url("files/2xkinglogo.png");
     
    background-size: 72px 72px;
  }
}
    
    
    </style>
    
  </head>
  <body>
    <div id="page">
      <h1>List King</h1>
      <h2>Account</h2>
      <form method="post" action="http://www.example.org/register">

        <label for="username">USERNAME: </label>
        <input type="text" id="username" />

        <label for="password">PASSWORD: </label>
        <input type="text" id="password" />

        <input type="button" value="Login" id="submit" onclick="validate()"/>

      </form>
    </div>
    
    <script>
    //var attempt = 5; // Variable to count number of attempts.
 // Below function Executes on click of login button.
 function validate(){
 var username = document.getElementById("username").value;
 var password = document.getElementById("password").value;
 if ( username == "admin" && password == "admin123"){
 //alert ("Login successfully");
 window.location = "index.jsp"; // Redirecting to other page.
 return false;
 }else{
	 alert ("Login Failed");
	 // document.write('Login Failed');
	 // prompt('Login failed');
	 return true;
// attempt --;// Decrementing by one.
 //alert("You have left "+attempt+" attempt;");
 // Disabling fields after 3 attempts.
 if( attempt == 0){
 document.getElementById("username").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("submit").disabled = true;
return false;
 }
 }
 }
    
    </script>
    
  </body>
</html>
