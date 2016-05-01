<!DOCTYPE html>
<html>
    <head>
        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}
            .tg .tg-yfvh{font-weight:bold;font-style:italic;vertical-align:top}
            .tg .tg-yw4l{vertical-align:top}
        </style>
        <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css" >
        <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"     
        data-dojo-config="parseOnLoad: true">
        </script>
        <script>
            dojo.require("dojo.parser");
            dojo.require("dijit.form.DateTextBox");
            dojo.require("dijit.dijit");
            dojo.require("dojox.layout.TableContainer");
            dojo.require("dijit.form.TextBox");
            dojo.require("dijit.form.Button");
            
            var answerMap = {
                AID: 1,
                UCA: parent.username,
                GID: parent.selectedGroupId,
                Name: (parent.name).concat(" SelfEval"),
                A1: "",
                A2: "",
                A3: "",
                A4: "",
                A5: "",
                A6: "",
                A7: "",
                A8: "",
                A9: "",
                A10: "",
                A11: "",
                A12: "",
                A13: "",
                A14: "",
                A15: ""
            };
            
            function saveSelfAssessment(){
                if(document.getElementById("A1").value.trim() != ""){
                    answerMap.A1 = document.getElementById("A1").value.trim();
                }
                answerMap.A2 = document.getElementById("A2").value.trim();
                answerMap.A3 = document.getElementById("A3").value.trim();
                answerMap.A4 = getCheckBoxAnswer("A4");
                answerMap.A5 = getCheckBoxAnswer("A5");
                answerMap.A6 = getCheckBoxAnswer("A6");
                answerMap.A7 = getCheckBoxAnswer("A7");
                answerMap.A8 = getCheckBoxAnswer("A8");
                answerMap.A9 = getCheckBoxAnswer("A9");
                answerMap.A10 = getCheckBoxAnswer("A10");
                answerMap.A11 = getCheckBoxAnswer("A11");
                if(document.getElementById("A12").value.trim() != ""){
                    answerMap.A12 = document.getElementById("A12").value.trim();
                }
                if(document.getElementById("A13").value.trim() != ""){
                    answerMap.A13 = document.getElementById("A13").value.trim();
                }
                if(document.getElementById("A14").value.trim() != ""){
                    answerMap.A14 = document.getElementById("A14").value.trim();
                }
                if(document.getElementById("A15").value.trim() != ""){
                    answerMap.A15 = document.getElementById("A15").value.trim();
                }
                
                console.log(answerMap);
                
                dojo.xhrPost({
                   url:  "/PMA/student/saveSelf",
                   handleAs: "json",
                   content: {
                       "AID": answerMap.AID,
                       "UCA": answerMap.UCA,
                       "GID": answerMap.GID,
                       "Name": answerMap.Name,
                       "A1": answerMap.A1,
                       "A2": answerMap.A2,
                       "A3": answerMap.A3,
                       "A4": answerMap.A4,
                       "A5": answerMap.A5,
                       "A6": answerMap.A6,
                       "A7": answerMap.A7,
                       "A8": answerMap.A8,
                       "A9": answerMap.A9,
                       "A10": answerMap.A10,
                       "A11": answerMap.A11,
                       "A12": answerMap.A12,
                       "A13": answerMap.A13,
                       "A14": answerMap.A14,
                       "A15": answerMap.A15,
                       "answers": 15
                   },
                   load: test
                });
            }
            
            function test(response){
                console.log("I got a response");
                console.log(response);
                //var json = JSON.parse(response);
                console.log(response.a15);
            }
            function getCheckBoxAnswer(question){
                if(document.getElementById(question.concat("-5")).checked){
                    return 5;
                }
                else if(document.getElementById(question.concat("-4")).checked){
                    return 4;
                }
                else if(document.getElementById(question.concat("-3")).checked){
                    return 3;
                }
                else if(document.getElementById(question.concat("-2")).checked){
                    return 2;
                }
                else if(document.getElementById(question.concat("-1")).checked){
                    return 1;
                }
                else{
                    return null;
                }
            }
            
            function loadAssessment(response){
                if(response.answers == "Y"){
                    answerMap.A1 = response.a1;
                    answerMap.A2 = response.a2;
                    answerMap.A3 = response.a3;
                    answerMap.A4 = response.a4;
                    answerMap.A5 = response.a5;
                    answerMap.A6 = response.a6;
                    answerMap.A7 = response.a7;
                    answerMap.A8 = response.a8;
                    answerMap.A9 = response.a9;
                    answerMap.A10 = response.a10;
                    answerMap.A11 = response.a11;
                    answerMap.A12 = response.a12;
                    answerMap.A13 = response.a13;
                    answerMap.A14 = response.a14;
                    answerMap.A15 = response.a15;
                }
                
                if(response.msg == "Display"){
                    display();
                }
            }
            
            function display(){
                document.getElementById("A1").value = answerMap.A1;
                document.getElementById("A2").value = answerMap.A2;
                document.getElementById("A3").value = answerMap.A3;
                if(answerMap.A4 != ""){
                    document.getElementById("A4-".concat(answerMap.A4)).checked = true;
                }
                if(answerMap.A5 != ""){
                    document.getElementById("A5-".concat(answerMap.A5)).checked = true;
                }
                if(answerMap.A6 != ""){
                    document.getElementById("A6-".concat(answerMap.A6)).checked = true;
                }
                if(answerMap.A7 != ""){
                    document.getElementById("A7-".concat(answerMap.A7)).checked = true;
                }
                if(answerMap.A8 != ""){
                    document.getElementById("A8-".concat(answerMap.A8)).checked = true;
                }
                if(answerMap.A9 != ""){
                    document.getElementById("A9-".concat(answerMap.A9)).checked = true;
                }
                if(answerMap.A10 != ""){
                    document.getElementById("A10-".concat(answerMap.A10)).checked = true;
                }
                if(answerMap.A11 != ""){
                    document.getElementById("A11-".concat(answerMap.A11)).checked = true;
                }
                document.getElementById("A12").value = answerMap.A12;
                document.getElementById("A13").value = answerMap.A13;
                document.getElementById("A14").value = answerMap.A14;
                document.getElementById("A15").value = answerMap.A15;
            }
            
            
            dojo.ready(function(){
                dojo.xhrPost({
                   url:  "/PMA/student/getAssessment",
                   handleAs: "json",
                   content: {
                       "AID": answerMap.AID,
                       "UCA": answerMap.UCA,
                       "GID": answerMap.GID,
                       "Name": answerMap.Name
                   },
                   load: loadAssessment
                });
            });
        </script>
    </head>
    <body class="claro">
        <div style="width: 150px; margin: auto;">Self-Assessment Form</div>
        <br><br>
        <div style="width: 70%; margin: auto;">
            <label for="date">Date:</label>
            <input type="text" name="date" id="A1" title="Date"
            data-dojo-type="dijit.form.DateTextBox"
            required="true" />
            <label for="teamMemberName" >Name:</label>
            <input type="text" name="teamMemberName" title="Team Member Name"
            data-dojo-type="dijit.form.TextBox"
            data-dojo-props="trim:true" id="A2" />
            <label for="project" >Project:</label>
            <input type="text" name="project" title="Project"
            data-dojo-type="dijit.form.TextBox"
            data-dojo-props="trim:true" id="A3" />
            <button data-dojo-type="dijit/form/Button" type="button" id="saveButton" label="Save" onclick="saveSelfAssessment"></button>
        </div>
        <br><br>
        <div style="font-weight: bold;">1.  Please rate yourself on the following*:</div>
        <br>
        <table class="tg">
            <tr>
                <th class="tg-yw4l"></th>
                <th class="tg-yfvh">Excellent</th>
                <th class="tg-yfvh">Good</th>
                <th class="tg-yfvh">Average</th>
                <th class="tg-yfvh">Poor</th>
                <th class="tg-yfvh">Unacceptable</th>
            </tr>
            <tr>
                <td class="tg-yw4l">Meeting attendance</td>
                <td class="tg-yw4l"><input type="checkbox" id="A4-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A4-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A4-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A4-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A4-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Preparation for meeting</td>
                <td class="tg-yw4l"><input type="checkbox" id="A5-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A5-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A5-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A5-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A5-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Efficiency of meeting</td>
                <td class="tg-yw4l"><input type="checkbox" id="A6-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A6-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A6-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A6-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A6-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Communication skills</td>
                <td class="tg-yw4l"><input type="checkbox" id="A7-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A7-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A7-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A7-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A7-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Equal sharing of workload</td>
                <td class="tg-yw4l"><input type="checkbox" id="A8-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A8-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A8-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A8-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A8-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Motivation</td>
                <td class="tg-yw4l"><input type="checkbox" id="A9-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A9-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A9-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A9-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A9-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Supportiveness</td>
                <td class="tg-yw4l"><input type="checkbox" id="A10-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A10-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A10-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A10-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A10-1" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Overall performance</td>
                <td class="tg-yw4l"><input type="checkbox" id="A11-5" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A11-4" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A11-3" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A11-2" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="A11-1" value="1" /></td>
            </tr>
        </table>
        <br><br>
        <div style="font-weight: bold;">
        2.  Please provide a narrative with evidence to support any factors for which you have rated yourself as Excellent or Unacceptable.
        </div>
        <br>
        <textarea id="A12" name="textarea1" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        3.  Please list any additional factors that you believe are important for consideration in assessing your performance to date.
        </div>
        <br>
        <textarea id="A13" name="textarea2" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        4. Describe two strengths that you bring to your team.
        </div>
        <br>
        <textarea id="A14" name="textarea3" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        5. Describe the two most significant areas for improvement for yourself as a team member.
        </div>
        <br>
        <textarea id="A15" name="textarea4" style="width:50%;"></textarea>
        <br><br>
        <hr>
        <br>
        <div>*Adapted from the "Management Communications for Undergraduates" (15.279), Sloan School of Management, MIT, by Dr. Lori Breslow, 2000</div>
        
    </body>
</html>
