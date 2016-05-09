<!--This page is the main view for the site when logged in as a student-->

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
	background-color:#860038
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
    var username = "${model.username}";
    var flag = false;
    var map = {};
    for(i = 0; i<groups.length; i++){
        var members = groupMembers[i].split(",");
        console.log(members);
        map[groups[i]] = members;
    }
    var peerEvalOf;
    var selectedGroup;
    var selectedGroupId;
    
    
    /**
     * Upon loading the page, this function is called and creates buttons for each group
     * the logged in user belongs to. 
     * 
     * @returns void
     */
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
    
    /**
     * Function receives response from the controller on the server.
     * Using this reponse object it creates buttons for the assessments
     * the user need to take for the currently selected group
     * 
     * @param response
     * @returns void
     */
    function createAssessmentButtons(gMembers){
        while (document.getElementById("assessmentButtonContainer").hasChildNodes()) {   
            document.getElementById("assessmentButtonContainer").removeChild(list.firstChild);
        }
        var btn = document.createElement("BUTTON");
        var text = document.createTextNode("Self Evaluation");
        btn.appendChild(text);
        btn.title = "selfAssessment";
        btn.addEventListener("click", function(event){var button = event.target;
            setAssessmentButtonEvent(button.title);});
        document.getElementById("assessmentButtonContainer").appendChild(btn);
        for(i=0;i < gMembers.length; i++){
            if(gMembers[i].trim() != "${model.Name}"){
                var gMember = gMembers[i];
                var btn = document.createElement("BUTTON");
                var text = document.createTextNode("Peer Assessment of ".concat(gMember.trim()));
                btn.appendChild(text);
                btn.name = gMember;
                btn.title = "peerAssessment";
                btn.addEventListener("click", function(event){var button = event.target;
                        peerEvalOf = button.name;
                        console.log(button.title);
                        console.log(button.name);
                        setAssessmentButtonEvent(button.title);});
                document.getElementById("assessmentButtonContainer").appendChild(btn);
            }
        }
    }
    
    /**
     * Function that is called when any of the assessment buttons are clicked.
     * Depending upon the button type attribute, the function replaces the HTML DOM element 
     * with id "assessmentDiv" with an iframe element with the same id, loading in that iframe the .jsp page of the
     * appropriate assessment.
     * 
     * @param type, label
     * @returns void
     */
    function setAssessmentButtonEvent(type){
        dojo.xhrPost({
            url:  "/PMA/student/getGroupInfo",
            handleAs: "json",
            content: {
                "Name": name,
                "Group": selectedGroup,
                "Type": type
            },
            load: function(response){
                selectedGroupId = response.groupID;
                console.log(response);
                if(response.type == "peerAssessment"){
                    dojo.place("<iframe id='assessmentDiv' src='/PMA/peer' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
                }
                else if(response.type == "selfAssessment"){
                    dojo.place("<iframe id='assessmentDiv' src='/PMA/self' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
                }
                else{
                    console.log("Nothing here");
                }
        }});
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