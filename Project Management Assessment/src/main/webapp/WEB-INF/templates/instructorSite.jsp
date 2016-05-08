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
    width: 100%;
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
    dojo.require("dijit.form.Button");
    dojo.require("dijit.registry");
    dojo.require("dojox.grid.DataGrid");
    dojo.require("dojo.store.Memory");
    
    
    var classes = "${model.classes}".split(",");
    var assessments = "${model.assessments}".split(",");
    var welcome = "Hello, ".concat("${model.FirstName}".concat(" ".concat("${model.LastName}")));
    var flag = true;
    var username;
    var selectedGroupId;
    var selectedGroup;
    var peerEvalOf;
    var cid;
    var name;
    var memberString;
    var role;
    
    
    dojo.ready(function(){
        dojo.byId("header").innerHTML = welcome;
        for(i=0; i< classes.length; i++){
            var buttonId = classes[i].replace(" ","");
            var nodePath = "<button id='".concat(buttonId.concat("' type='button'></button>"));
            dojo.place(nodePath, "courseContainer", "after");
            new dijit.form.Button({
                label: classes[i],
                title: classes[i],
                onClick: function(event){
                    var button = dijit.registry.getEnclosingWidget(event.target);
                    document.getElementById("courseIdent").innerHTML = "Course:".concat(button.label);
                    cid = button.label;
                    dojo.xhrPost({
                        url: "/PMA/instructor/groupsForClass",
                        handleAs: "json",
                        content:{
                          "course": button.id
                        },
                        load:populateSelect});}
            }, buttonId).startup();
        }
    });
    
    function populateSelect(response){
        emptySelect(response.selectId);
        console.log(response.selectId);
        var sel = document.getElementById(response.selectId);
        if(response.selectId == "groups"){
            for(i = 0; i < response.groups.length; i++){
                var opt = document.createElement("option");
                opt.value = response.gids[i];
                opt.text = response.groups[i];
                sel.add(opt);
            }
        }
        else if(response.selectId == "members"){
            for(i = 0; i < response.ucas.length; i++){
                var opt = document.createElement("option");
                opt.value = response.ucas[i];
                opt.text = response.names[i];
                sel.add(opt);
            }
        }
    }
    
    function emptySelect(id){
        var sel = document.getElementById(id);
        for(i = 1; i < sel.length;){
            sel.remove(i);
        }     
    }
    
    function emptyButtonContainer(){
        var div = document.getElementById("buttonContainer");
        while (div.hasChildNodes()) {
            div.removeChild(div.firstChild);
        }
    }
    
    function setAssessmentButtonEvent(type, label){
        if(type == 2){
            peerEvalOf = label.replace("PeerEvalOf ", "");
            dojo.place("<iframe id='assessmentDiv' src='/PMA/peer' style='height:75%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else if(type == 1){
            dojo.place("<iframe id='assessmentDiv' src='/PMA/self' style='height:75%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else{
            console.log("Nothing here");
        }
    }
    
    function getPasswords(){
        dojo.place("<iframe id='assessmentDiv' src='/PMA/instructor/groupInfo' style='height:75%;width:100%;'></iframe>", "assessmentDiv", "replace");
    }
    
    function groupChangeEvent(){
        selectedGroupId = document.getElementById("groups").value;
        selectedGroup = document.getElementById("groups").options[document.getElementById("groups").selectedIndex].text;
        console.log(selectedGroup);
        if(selectedGroupId != "placehold"){
            dojo.xhrPost({
                url: "/PMA/instructor/membersForGroup",
                handleAs: "json",
                content:{
                    "gid": selectedGroupId
                },
                load:populateSelect});
        }
    }
    
    function addGroup(){
        var newGroup = document.getElementById("addGroupInput").value;
        if(newGroup.trim() != ""){
            dojo.xhrPost({
                url: "/PMA/instructor/newGroup",
                handleAs: "json",
                content:{
                    "group": newGroup,
                    "cid": cid
                },
                load:populateSelect});
        }
    }
    
    function addMember(){
        if(document.getElementById("pm").checked){
            role = "PM";
        }
        else{
            role = "DEV";
        }
        
        memberString = document.getElementById("addMemberInput").value;
        if(memberString.trim() != ""){
            dojo.xhrPost({
                url: "/PMA/instructor/ucaExistCheck",
                handleAs: "json",
                content:{
                    "ucas": memberString
                },
                load:handleExistResponse});
        }
        
    }
    
    function handleExistResponse(response){
        if(response.error == "y"){
            alert("ERROR ENCOUNTERED ADDING MEMBERS!! PROCESS ABANDONED!!");
        }
        console.log(response);
        var newUCAs = "";
        var newNames = "";
        if(response.ucas.length != 0){
            for(i = 0; i< response.ucas.length; i++){
                if(newUCAs == ""){newUCAs = response.ucas[i].trim();}
                else{newUCAs = newUCAs.concat(",".concat(response.ucas[i].trim()));}
                if(newNames == ""){newNames = prompt("Enter first and last name for ".concat(response.ucas[i].trim()).concat(". (Separate names with one whitespace)"),"");}
                else{newNames = newNames.concat(",".concat(prompt("Enter first and last name for ".concat(response.ucas[i].trim()).concat(". (Separate names with one whitespace)"),"")));}
            }
            dojo.xhrPost({
                url: "/PMA/instructor/newUCAs",
                handleAs: "json",
                content:{
                    "ucas": newUCAs,
                    "names": newNames
                },
                load: insertToGroup
            });
        }
        else{
            insertToGroup(true)
        }
    }
    function insertToGroup(response){
        console.log(response);
        if(response == true){
            dojo.xhrPost({
                url: "/PMA/instructor/addMembers",
                handleAs: "json",
                content:{
                    "gid": selectedGroupId,
                    "role": role,
                    "ucas": memberString
                },
                load: populateSelect
            });
        }
        else{
            alert("ERROR ENCOUNTERED ADDING NEW USERS!! PROCESS ABANDONED!!");
        }
    }
    
    function memberSelectEvent(){
        name = document.getElementById("members").options[document.getElementById("members").selectedIndex].text;
        username = document.getElementById("members").value;
        //console.log(name);
        //console.log(username);
        //console.log(selectedGroupId);
        emptyButtonContainer();
        if(username != "placehold"){
            dojo.xhrPost({
                url: "/PMA/instructor/assessmentsTaken",
                handleAs: "json",
                content:{
                    "name": name,
                    "uca": username,
                    "gid": selectedGroupId
                },
                load:createAssessmentButtons});
        }
    }
    
    function createAssessmentButtons(response){
        //console.log(response);
        for(i=0;i<response.aids.length; i++){
            //var buttonId = classAssessments[i].replace(" ","").concat(i);
            var nodePath = "<button id='".concat(response.assessmentNames[i].replace(" ","").concat("' type='button'></button>"));
            dojo.place(nodePath, "buttonContainer", "after");
            new dijit.form.Button({
                label: response.assessmentNames[i],
                title: response.aids[i],
                onClick: function(event){var button = dijit.registry.getEnclosingWidget(event.target);
                    setAssessmentButtonEvent(button.title, button.label);
                }
            }, response.assessmentNames[i].replace(" ","")).startup();      
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
            <div id='assessmentDiv'></div>
        </div>
        <div id="header" class="edgePanel" data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'top'">Header</div>
        <div id="leftCol" class="edgePanel"
            data-dojo-type="dijit.layout.ContentPane"
            data-dojo-props="region: 'right', splitter: true">
            <div style="height: 10%;">
                <div>Tools</div>
                <div>
                    <button onclick="getPasswords();" title="Get Passwords for Selected Groups Members">Passwords</button>
                </div>
            </div>
            <div style="height: 45%; position: relative;">
                <div id="courseIdent">Course:</div>
                <div>Groups</div>
                <div id="groupList">
                    <select id="groups" onchange="groupChangeEvent();">
                        <option value="placehold">Select Group From Class</option>
                    </select>
                </div>
                <div style="height: 15%; position: absolute; bottom: 0; left: 0;">
                    <input id="addGroupInput" type="text" placeholder="Group To Add to Course">
                    <button onclick="addGroup();">Add Group To Course</button>
                </div>
            </div>
            <div style="height: 45%; position: relative;">
                <div>Students in Selected Group</div>
                <div id="memberList" onchange="memberSelectEvent()">
                    <select id="members">
                        <option value="placehold">Select Member From Group</option>
                    </select>
                </div>
                <div style="height: 30%; position: absolute; bottom: 0; left: 0;" >
                    <input id="addMemberInput" type="text" placeholder="Add members to group" title="enter ucas, for mutliple entries separate them by comma">
                    <button onclick="addMember();">Add Members To Group</button><br>
                    <input id="pm" type="radio" name="role" value="PM" checked>Project Manager<br>
                    <input id="dev" type="radio" name="role" value="DEV">Developer<br>
                </div>
            </div>
        </div>
    </div>
</body>
</html>