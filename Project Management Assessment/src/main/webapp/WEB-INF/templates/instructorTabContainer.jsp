<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css" >
        <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"     
        data-dojo-config="parseOnLoad: true">
        </script>
        
        <script>
            dojo.require("dojo.parser");
            dojo.require("dijit.layout.TabContainer");
            dojo.require("dijit.layout.ContentPane");
        </script>
        
        <style>
            html, body {
                width: 100%;
                height: 100%;
                margin: 0;
                padding: 0;
            }
            
            #tabContainer {
                height: 100%;
                width: 100%;
            }
            
            #nestedTabs {
                height:100%;
                width:100%;
            }
        </style>
    </head>
    <body class="claro">
        <div data-dojo-type="dijit/layout/TabContainer" id="tabContainer">
            <div data-dojo-type="dijit/layout/TabContainer" title="Project Management" nested="true" id="nestedTabs" >
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment" href="/PMA/peer" selected="true">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Self Evaluation" href="/PMA/self">
                </div>
            </div>
        </div>
    </body>
</html>