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
            <div data-dojo-type="dijit/layout/TabContainer" title="Project Management Assessment" nested="true" id="nestedTabs" >
                <div data-dojo-type="dijit/layout/ContentPane" title="Self Evaluation" href="/PMA/self" selected="true">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment of Student A" href="/PMA/peer">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment of Student B" href="/PMA/peer">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment of Student C" href="/PMA/peer">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment of Student D" href="/PMA/peer">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment of Student E" href="/PMA/peer">
                </div>
                <div data-dojo-type="dijit/layout/ContentPane" title="Peer Assessment of Student F" href="/PMA/peer">
                </div>
            </div>
        </div>
    </body>
</html>