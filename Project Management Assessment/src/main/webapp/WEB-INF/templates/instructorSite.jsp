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
    dojo.require("dojo.on");
    dojo.require("dojo.ready");
    dojo.require("dijit.layout.BorderContainer");
    dojo.require("dijit.layout.TabContainer");
    dojo.require("dijit.layout.ContentPane");
    dojo.require("dijit.form.Button")
    dojo.require("dijit.registry")
    
    
    var classes = "${model.classes}".split(",");
    var assessments = "${model.assessments}".split(",");
    var map = {};
    map[classes[0]] = assessments;
    

//    require(["dijit/layout/AccordionContainer", "dijit/layout/ContentPane", "dojo/domReady!"],
//        function(AccordionContainer, ContentPane){
//            var aContainer = new AccordionContainer({style: "height:20%;"}, "tabContainer");
//            for(i=0; i< classes.length; i++){
//                aContainer.addChild(new ContentPane({
//                title: classes[i],
//                id: classes[i].replace(" ","")
//                }));
//                
//                console.log(dijit.byId(classes[i].replace(" ","")).get("id"));
//            }
//            aContainer.startup();
//            createButtons();
//    });
    dojo.ready(function(){
        for(i=0; i< classes.length; i++){
            var buttonId = classes[i].replace(" ","");
            var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
            dojo.place(nodePath, "courseContainer", "after");
            new dijit.form.Button({
                label: classes[i],
                title: classes[i],
                onClick: function(){
                    createAssessmentButtons(map[classes[0]]);}
            }, buttonId).startup();
        }
    });
    
    
    function createLabel(type) {
        if(type == "peer"){
            return "Peer Assessment";
        }
        else if(type == "self"){
            return "Self Evaluation";
        }
        else{
            return "Assessment not found";
        }
    }
    
    function setAssessmentButtonEvent(type){
        console.log(type);
        if(type == "peer"){
            dojo.place("<iframe id='assessmentDiv' src='/PMA/peer' style='height:75%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else if(type == "self"){
            dojo.place("<iframe id='assessmentDiv' src='/PMA/self' style='height:75%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else{
            console.log("Nothing here");
        }
    }
    
    function createAssessmentButtons(classAssessments){
//        dojo.place("<button id='"classes[0].replace(" ","") + i"' type='button'></button>", classes[0].replace(" ",""), "after");
        var node = dojo.byId("buttonContainer");
        while(node.hasChildNodes()){
            node.destory(true);
        }
        dojo.byId("buttonContainer").innerHTML = "";
        for(i=0;i<classAssessments.length; i++){
            var buttonId = classAssessments[i].replace(" ","").concat(i);
            var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
            dojo.place(nodePath, "buttonContainer", "after");
            new dijit.form.Button({
                label: createLabel(assessments[i]),
                title: assessments[i],
                onClick: function(event){var button = dijit.registry.getEnclosingWidget(event.target);
                    setAssessmentButtonEvent(button.title)}
            }, buttonId).startup();
            
            //dojo.on(dijit.byId(buttonId), "click", setAssessmentButtonEvent(assessments[i]));
//            dojo.place(myButton, classes[0].replace(" ",""), "after");
        }
    }
   
</script>

</head>

<body class="claro">
    <div id="appLayout" class="demoLayout"
        data-dojo-type="dijit.layout.BorderContainer"
        data-dojo-props="design: 'headline'">
        <div class="centerPanel" data-dojo-type="dijit.layout.ContentPane"
             data-dojo-props="region: 'center'">
            <div id="courseContainer" style="width:100%; height:10;"></div>
            <div id="buttonContainer" style="width:100%; height:10;"></div>
            <div id='assessmentDiv'>No assessment is currently selected</div>
        </div>
        <div class="edgePanel" data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'top'">Header</div>
        <div id="leftCol" class="edgePanel"
            data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'right', splitter: true">
                <div style="width: auto; height: 300px">
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