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
    

    require(["dijit/layout/AccordionContainer", "dijit/layout/ContentPane", "dojo/domReady!"],
        function(AccordionContainer, ContentPane){
            var aContainer = new AccordionContainer({style: "height:20%;"}, "tabContainer");
            for(i=0; i< classes.length; i++){
                aContainer.addChild(new ContentPane({
                title: classes[i],
                id: classes[i].replace(" ","")
                }));
                
                console.log(dijit.byId(classes[i].replace(" ","")).get("id"));
            }
            aContainer.startup();
            createButtons();
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
    
    function createButtons(){
//        dojo.place("<button id='"classes[0].replace(" ","") + i"' type='button'></button>", classes[0].replace(" ",""), "after");
        for(i=0;i<assessments.length; i++){
            var buttonId = classes[0].replace(" ","").concat(i);
            var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
            dojo.place(nodePath, classes[0].replace(" ",""), "after");
            var myButton = new dijit.form.Button({
                label: createLabel(assessments[i]),
                title: assessments[i],
                onClick: function(event){var button = dijit.registry.getEnclosingWidget(event.target);
                    setAssessmentButtonEvent(button.title)}
            }, buttonId).startup();
            
            //dojo.on(dijit.byId(buttonId), "click", setAssessmentButtonEvent(assessments[i]));
//            dojo.place(myButton, classes[0].replace(" ",""), "after");
        }
    }
	function gradingFunction() {
    document.getElementById(
"weighted1").value = document.getElementById("weight1").value * document.getElementById("grade1").value;
    document.getElementById(
"weighted2").value = document.getElementById("weight2").value * document.getElementById("grade2").value;
    document.getElementById(
"weighted3").value = document.getElementById("weight3").value * document.getElementById("grade3").value;
    document.getElementById(
"weighted4").value = document.getElementById("weight4").value * document.getElementById("grade4").value;
    document.getElementById(
"total").value = Number(document.getElementById("weighted1").value) + Number(document.getElementById("weighted2").value) + Number(document.getElementById("weighted3").value) + Number(document.getElementById("weighted4").value);
}
   
</script>

</head>

<body class="claro">
    <div id="appLayout" class="demoLayout"
        data-dojo-type="dijit.layout.BorderContainer"
        data-dojo-props="design: 'headline'">
        <div class="centerPanel" data-dojo-type="dijit.layout.ContentPane"
             data-dojo-props="region: 'center'"> <!-- href="/PMA/instructorTabContainer"-->
            <div id="tabContainer" style="width:100%; height:25%;"></div>
            <div id='assessmentDiv'>No assessment is currently selected</div>
        </div>
        <div class="edgePanel" data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'top'">Header</div>
        <div id="leftCol" class="edgePanel"
            data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'right', splitter: true">
                <div style="width: auto; height: 300px">
                    <div data-dojo-type="dijit/layout/AccordionContainer" style="height: 300px;">
                        <div data-dojo-type="dijit/layout/ContentPane" title="Presentation Grade" selected="true">
                            <form>
							<table border = 1 style="width:10%">
							  <tr>
								<td><input type = "text" id="teachName1" value="Prof. Devine" style="width:auto;"</td>
								<td><input type = "text" id="grade1" value="" style="width:auto;"</td>
								<td><input type = "text" id="weight1" value="" onblur="gradingFunction()" style="width:auto;"</td>
								<td><input type = "text" id="weighted1" value="" style="width:auto;"</td>
							  </tr>
							  <tr>
								<td><input type = "text" id="teachName2" value="Dr. Giorcelli" style="width:auto;"</td>
								<td><input type = "text" id="grade2" value="" style="width:auto;"</td>
								<td><input type = "text" id="weight2" value="" onblur="gradingFunction()"style="width:auto;"</td>
								<td><input type = "text" id="weighted2" value="" style="width:auto;"</td>
							  </tr>
							  <tr>
								<td><input type = "text" id="teachName3" value="Ms. RaeAnne" style="width:auto;"</td>
								<td><input type = "text" id="grade3" value="" style="width:auto;"</td>
								<td><input type = "text" id="weight3" value="" onblur="gradingFunction()"style="width:auto;"</td>
								<td><input type = "text" id="weighted3" value="" style="width:auto;"</td>
							  </tr>
							  <tr>
								<td><input type = "text" id="teachName4" value="Ms. Jennifer" style="width:auto;"</td>
								<td><input type = "text" id="grade4" value="" style="width:auto;"</td>
								<td><input type = "text" id="weight4" value="" onblur="gradingFunction()"style="width:auto;"</td>
								<td><input type = "text" id="weighted4" value="" style="width:auto;"</td>
							  </tr>
							  <tr>
								<th colspan="3">Weighted Total</th>
								<td><input type = "text" id="total" value="0" </td>
							</table>
							</form>
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