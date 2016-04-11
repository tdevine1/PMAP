<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html lang="en">
<head>
<meta charset="utf-8">
<title>PM Assessment</title>

<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css" > 

<style type="text/css">
html, body { 
    height: 100%; 
    margin: 0; 
    overflow: hidden; 
    padding: 0; 
} 

#appLayout { 
    height: 100%; 
} 
#leftCol { 
    width: 14em; 
}
</style>

 <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"     
    data-dojo-config="parseOnLoad: true">
 </script>  

<script>
    dojo.require("dojo.parser");
    dojo.require("dojo.query");
    dojo.require("dojo.dom-attr");
    dojo.require("dojo.ready");
    dojo.require("dijit.layout.BorderContainer");
    dojo.require("dijit.layout.TabContainer");
    dojo.require("dijit.layout.ContentPane");
    
    var classes = "${model.classes}".split(",");
    for(i=0; i< classes.length; i++){
        console.log(classes[i]);
    }
    
//    require(["dijit/layout/TabContainer", "dijit/layout/ContentPane", "dojo/domReady!"], function(TabContainer, ContentPane){
//    var tc = new TabContainer({
//        style: "height: 100%; width: 100%;"
//    }, "tabContainer");
//    
//    for(i=0; i< classes.length; i++){
//    var cp = new ContentPane({
//         title: classes[i],
//         id: classes[i],
//         content: "Will contain Buttons for each assessment in the class"
//    });
//    tc.addChild(cp);
//    
//    tc.startup();
//    }
//});
   
</script>

</head>

<body class="claro">
    <div id="appLayout" class="demoLayout"
        data-dojo-type="dijit.layout.BorderContainer"
        data-dojo-props="design: 'headline'">
        <div class="centerPanel" data-dojo-type="dijit.layout.ContentPane"
             data-dojo-props="region: 'center'" href="/PMA/instructorTabContainer">
            <div id="tabContainer"></div>
        </div>
        <div class="edgePanel" data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'top'">Header</div>
        <div id="leftCol" class="edgePanel"
            data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'right', splitter: true">
                <div style="width: 300px; height: 300px">
                    <div data-dojo-type="dijit/layout/AccordionContainer" style="height: 300px;">
                        <div data-dojo-type="dijit/layout/ContentPane" title="Instructor Options" selected="true">
                            Feature to be implemented in future release
                        </div>
                        <div data-dojo-type="dijit/layout/ContentPane" title="Instructor Options">
                            Feature to be implemented in future release
                        </div>
                        <div data-dojo-type="dijit/layout/ContentPane" title="Instructor Options">
                            Feature to be implemented in future release
                        </div>
                    </div>
                </div>
        </div>
    </div>
</body>
</html>