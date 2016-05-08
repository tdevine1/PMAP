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
    background-color: #860038;
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
    
    /**
     * Function is fired after the HTML page has been loaded.  Assigns a Welcome message for the user,
     * and creates buttons for eash course the user teaches using parameters from the model passed to the
     * web page from the controller.
     * 
     * @returns void
     */
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
    
    /**
     * Function will populate the the select element associated with the
     * selectId attribute of the response, with an array attribute of the response
     * 
     * @param response
     * @returns void
     */
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
    
    /**
     * Empties the options of the select element associated with the
     * id parameter
     * 
     * @param id
     * @returns void
     */
    function emptySelect(id){
        var sel = document.getElementById(id);
        for(i = 1; i < sel.length;){
            sel.remove(i);
        }     
    }
    
    /**
     * Function that clears the buttons from the HTML DOM element with the id of
     * "buttonContainer"
     * 
     * @returns void
     */
    function emptyButtonContainer(){
        var div = document.getElementById("buttonContainer");
        while (div.hasChildNodes()) {
            div.removeChild(div.firstChild);
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
    function setAssessmentButtonEvent(type, label){
        if(type == 2){
            peerEvalOf = label.replace("PeerEvalOf ", "");
            dojo.place("<iframe id='assessmentDiv' src='/PMA/peer' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else if(type == 1){
            dojo.place("<iframe id='assessmentDiv' src='/PMA/self' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
        }
        else{
            console.log("Nothing here");
        }
    }
    
    /**
     * Function is called when the Passwords button is clicked.
     * The function replaces the HTML DOM element with id "assessmentDiv" with an iframe element 
     * with the same id, loading in that iframe the .jsp page of the login and password for the currently selected group.
     * 
     * @returns 
     */
    function getPasswords(){
        dojo.place("<iframe id='assessmentDiv' src='/PMA/instructor/groupInfo' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
    }
    
    /**
     * Function is called when the Presentation Grade button is clicked.
     * The function replaces the HTML DOM element with id "assessmentDiv" with an iframe element 
     * with the same id, loading in that iframe the .jsp page of the grading table.
     * 
     * @returns 
     */
    function getTable(){
        dojo.place("<iframe id='assessmentDiv' src='/PMA/instructor/weightedGradeTable' style='height:100%;width:100%;'></iframe>", "assessmentDiv", "replace");
    }
    
    /**
     * Function is called when a new selection is made in the group member select input.
     * Will send the name of the currently selected group to the server to get the list
     * of members in the group.  The response will be sent to the populateSelect() function
     * 
     * @returns void
     */
    function groupChangeEvent(){
        selectedGroupId = document.getElementById("groups").value;
        selectedGroup = document.getElementById("groups").options[document.getElementById("groups").selectedIndex].text;
        console.log(selectedGroup);
        if(selectedGroupId != "placehold"){
            document.getElementById("addGroupButton").disabled = false;
            document.getElementById("getPasswordButton").disabled = false;
            document.getElementById("getTableButton").disabled = false;
            dojo.xhrPost({
                url: "/PMA/instructor/membersForGroup",
                handleAs: "json",
                content:{
                    "gid": selectedGroupId
                },
                load:populateSelect});
        }
        else{
            document.getElementById("addGroupButton").disabled = true;
            document.getElementById("getPasswordButton").disabled = true;
            document.getElementById("getTableButton").disabled = true;
        }
    }
    
    /**
     * Function called when the Add Group button is clicked
     * While send the name of the group that the users wishes to add to the 
     * currently selected group.  The response from the server will be sent
     * to the populateSelect() function
     * 
     * @returns void
     */
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
    
    /**
     * Function that is called when the Add Member button is clicked.
     * It will pass the string of new member ucas for the selected group to the controller on the server,
     * as well as their roles which is defined by the radio button selection.  The
     * server response will be sent to the handleExistResponse() function
     * 
     * @returns void
     */
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
    
    /**
     * The function receives a response from the controller on the server.
     * If the error flag of the response is set to "y" then the user will be notified and error has occurred
     * Otherwise, if there are users who do no exist in the database that the user wishes to add to the selected group,
     * the user will be asked to give their names so that they can be added. A call will then be sent to the controller on
     * the server to create these new users and the response from the server will be sent to the insertToGroup() function.
     * 
     * If no new users need to be created, the insertToGroup() function is called passing it true as an argument
     * 
     * @param response
     * @returns void
     */
    function handleExistResponse(response){
        if(response.error == "y"){
            alert("ERROR ENCOUNTERED ADDING MEMBERS!! PROCESS ABANDONED!!");
        }
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
    
    /**
     * Function receives a response from the controller on the server.
     * If the response is true, then the page will make a call to the server
     * to finish adding members to the group and the server response will be sent
     * to the populateSelect() function
     * If the response if false, then an alert will be given letting the user
     * know that a problem has occurred.
     * 
     * @param response
     * @returns void
     */
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
    
    /**
     * Function is called when the selection for the member select input changes.
     * If the selection is not the placeholder item, the function sends an ajax
     * call to the server to get the assessments taken by the student.
     * The resonse from this call will then be sent to the createAssessmentButtons() function
     * 
     * @param
     * @returns void
     */
    function memberSelectEvent(){
        name = document.getElementById("members").options[document.getElementById("members").selectedIndex].text;
        username = document.getElementById("members").value;
        emptyButtonContainer();
        if(username != "placehold"){
            document.getElementById("addMemberButton").disabled = false;
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
        else{
            document.getElementById("addMemberButton").disabled = true;
        }
    }
    
    /**
     * Function receives response from the controller on the server.
     * Using this reponse object it creates buttons for assessments that have answers
     * for the currently selected student.
     * 
     * @param response
     * @returns void
     */
    function createAssessmentButtons(response){
        for(i=0;i<response.aids.length; i++){
            var btn = document.createElement("BUTTON");
            var text = document.createTextNode(response.assessmentNames[i]);
            btn.appendChild(text);
            btn.label = response.assessmentNames[i];
            btn.title = response.aids[i];
            btn.addEventListener("click", function(event){var button = event.target;
                    setAssessmentButtonEvent(button.title, button.label);
                });
            document.getElementById("buttonContainer").appendChild(btn);  
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
                    <button id="getPasswordButton" onclick="getPasswords();" title="Get Passwords for Selected Groups Members" disabled="true">Passwords</button>
                    <button id="getTableButton" onclick="getTable();" title="Weighted Presentation Grading Table" disabled="true">Presentation Grade</button>
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
                    <button id="addGroupButton" onclick="addGroup();" disabled="true">Add Group To Course</button>
                </div>
            </div>
            <div style="height: 45%; position: relative;">
                <div>Students in Selected Group</div>
                <div id="memberList" onchange="memberSelectEvent()">
                    <select id="members">
                        <option value="placehold" >Select Member From Group</option>
                    </select>
                </div>
                <div style="height: 30%; position: absolute; bottom: 0; left: 0;" >
                    <input id="addMemberInput" type="text" placeholder="Add members to group" title="enter ucas, for mutliple entries separate them by comma">
                    <button id="addMemberButton" onclick="addMember();" disabled="true">Add Members To Group</button><br>
                    <input id="pm" type="radio" name="role" value="PM" checked>Project Manager<br>
                    <input id="dev" type="radio" name="role" value="DEV">Developer<br>
                </div>
            </div>
        </div>
    </div>
</body>
</html>