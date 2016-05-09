<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- Simple page to connect and login to the database and to check for proper logins of users -->
<!-- takes user input from textboxes and sends it to the controller to be sent to the database-->

<!DOCTYPE html>
<html>
    <head> <!-- header sets various stylings, widths, and scripts -->
        <title>PM Assessment</title>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css">
        <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js" data-dojo-config="parseOnLoad: true"></script>
        <script>
		<!-- these tell the page where to get various parts-->
            dojo.require("dojo/parser");
            dojo.require("dijit/form/TextBox");
        </script>
		<style>
            body {background-color:#860038}
		</style>
    </head>
       <body class="tundra">
        <img src="https://fairmontstate.studentaidcalculator.com/1/logo.sepng" style="margin: auto;position: absolute; left:40.7%; top:0%">
		<div id="loginContainer" style="width:25%; height:20%; position:absolute; left:37.5%; top:40%; border-style:ridge; border-width:5px;border-color:#F58026;color:#F58026; " >
            <div id="nestedContainer" style=" height:25%; width:30%; position:absolute; left:20%; top:30%; ">
                <form action="/PMA/processLogin" method="POST" >
                <input type="text" name="username"
                        data-dojo-type="dijit/form/TextBox"
                        data-dojo-props="trim:true" placeholder="Username" id="username" style = "border-style:ridge; border-width:5px;border-color:#F58026;color:#F58026;" />
                <br><br>
                <input type="password" name="password" 
                data-dojo-type="dijit/form/TextBox"
                data-dojo-props="trim:true" placeholder="Password" id="password"  style = "border-style:ridge; border-width:5px;border-color:#F58026;color:#F58026;" />
                <br>
                <button type="submit">Login</button>
                </form>
            </div>
        </div>
    </body>
</html>
