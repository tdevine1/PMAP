<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css" >
        <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"     
        data-dojo-config="parseOnLoad: true">
        </script>
        <script>
            dojo.require("dojo.parser");
            
            function fillPage(response){
                var el = document.getElementById("passwordContainer");
                for(i = 0; i < response.ucas.length; i++){
                    var item = document.createElement("P");
                    var t = document.createTextNode(response.ucas[i].concat(" : ".concat(response.passwords[i])));
                    item.appendChild(t);
                    el.appendChild(item);
                }
            }
            
            dojo.ready(function(){
                dojo.xhrPost({
                    url: "/PMA/instructor/getInfo",
                    handleAs: "json",
                    content:{
                        "gid": parent.selectedGroupId
                    },
                    load: fillPage
                });
            });
        </script>
    </head>
    <body>
        <h1>UCA : Password</h1>
        <div id="passwordContainer">
            uca demo : password demo
        </div>
    </body>
</html>
