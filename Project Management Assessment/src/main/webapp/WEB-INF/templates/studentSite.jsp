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
    
    var groups = "${model.Groups}".split(",");
    var groupMembers = "${model.GroupMembers}".split("%");
    var name = "${model.Name}";
    var welcome = "Hello, ".concat(name);
    var map = {};
    for(i = 0; i<groups.length; i++){
        var members = groupMembers[i].split(",");
        console.log(members);
        map[groups[i]] = members;
    }
    var peerEvalOf;
    var selectedGroup;
    
     dojo.ready(function(){
        dojo.byId("header").innerHTML = welcome;
        for(i=0; i < groups.length; i++){
            var buttonId = groups[i].replace(" ","");
            var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
            var gName = groups[i];
            dojo.place(nodePath, "groupContainer", "after");
            new dijit.form.Button({
                label: groups[i],
                title: groups[i],
                name: gName,
                onClick: function(event){
                    var button = dijit.registry.getEnclosingWidget(event.target);
                    selectedGroup = button.name;
                    createAssessmentButtons(map[gName]);}
            }, buttonId).startup();
        }
    });
    
    function createAssessmentButtons(gMembers){
        var node = dojo.byId("assessmentButtonContainer");
        while(node.hasChildNodes()){
            node.destory(true);
        }
        dojo.byId("assessmentButtonContainer").innerHTML = "";
        console.log(gMembers);
        for(i=0;i < gMembers.length; i++){
            if(gMembers[i].trim() != "${model.Name}"){
                var gMember = gMembers[i];
                var buttonId = gMember.replace(" ","").concat("PeerAseessment");
                var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
                dojo.place(nodePath, "assessmentButtonContainer", "after");
                new dijit.form.Button({
                    label: "Peer Assessment of ".concat(gMember.trim()),
                    title: "peerAssessment",
                    name: gMember,
                    onClick: function(event){var button = dijit.registry.getEnclosingWidget(event.target);
                        peerEvalOf = button.name;
                        setAssessmentButtonEvent(button.title);}
                }, buttonId).startup();
            }
        }
        
        var buttonId = "${model.Name}".replace(" ","").concat("SelfEval");
        var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
        dojo.place(nodePath, "assessmentButtonContainer", "after");
        new dijit.form.Button({
            label: "Self Evaluation",
            title: "selfAssessment",
            onClick: function(event){var button = dijit.registry.getEnclosingWidget(event.target);
                setAssessmentButtonEvent(button.title)}
        }, buttonId).startup();
    }
    
    function setAssessmentButtonEvent(type){
        console.log(type);
        if(type == "peerAssessment"){
            dojo.place("<iframe id='assessmentDiv' src='/PMA/peer' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else if(type == "selfAssessment"){
            dojo.place("<iframe id='assessmentDiv' src='/PMA/self' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else{
            console.log("Nothing here");
        }
    }
    
   // dojo.ready(function(){
        
   // });
   
</script>

</head>

<body class="claro">
    <div id="appLayout" class="demoLayout"
        data-dojo-type="dijit.layout.BorderContainer"
        data-dojo-props="design: 'headline'">
        <div class="centerPanel" data-dojo-type="dijit.layout.ContentPane"
             data-dojo-props="region: 'center'">
            <div id="groupContainer"></div>
            <div id="assessmentButtonContainer"></div>
            <div id="assessmentDiv"></div>
        </div>
        <div id="header" class="edgePanel" data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'top'">STUFF</div>
    </div>
</body>
</html>