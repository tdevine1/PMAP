<!DOCTYPE html>
<!-- simple presentation grading tool, requested by Girocialli-->
<html>
<head>
    <link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dijit/themes/claro/claro.css" >
    <script src="http://ajax.googleapis.com/ajax/libs/dojo/1.10.4/dojo/dojo.js"     
        data-dojo-config="parseOnLoad: true">
    </script>
<style> <!-- Styles the background, change background style here-->
input[type=text] {
    background-color: #860038;
    color: #FFDE00;
    border: none;
}
body{
    background-color: #860038;
}
</style>
<script>
    dojo.require("dojo.parser");
    
    var gid;
//These functions, gradingFunctions 1- 10, grade each individual line once stuff is entered into the lines, then calls addValues to compute the total.
function gradingFunction1() {
    document.getElementById("weighted1").value = document.getElementById("grade1").value / document.getElementById("possible1").value * document.getElementById("weight1").value;
    addValues();
}
function gradingFunction2() {
    document.getElementById("weighted2").value = document.getElementById("grade2").value / document.getElementById("possible2").value * document.getElementById("weight2").value;
    addValues();
}
function gradingFunction3() {
    document.getElementById("weighted3").value = document.getElementById("grade3").value / document.getElementById("possible3").value * document.getElementById("weight3").value;
    addValues();
}
function gradingFunction4() {
    document.getElementById("weighted4").value = document.getElementById("grade4").value / document.getElementById("possible4").value * document.getElementById("weight4").value;
    addValues();
}
function gradingFunction5() {
    document.getElementById("weighted5").value = document.getElementById("grade5").value / document.getElementById("possible5").value * document.getElementById("weight5").value;
    addValues();
}
function gradingFunction6() {
    document.getElementById("weighted6").value = document.getElementById("grade6").value / document.getElementById("possible6").value * document.getElementById("weight6").value;
    addValues();
}
function gradingFunction7() {
    document.getElementById("weighted7").value = document.getElementById("grade7").value / document.getElementById("possible7").value * document.getElementById("weight7").value;
    addValues();
}
function gradingFunction8() {
    document.getElementById("weighted8").value = document.getElementById("grade8").value / document.getElementById("possible8").value * document.getElementById("weight8").value;
    addValues();
}
function gradingFunction9() {
    document.getElementById("weighted9").value = document.getElementById("grade9").value / document.getElementById("possible9").value * document.getElementById("weight9").value;
    addValues();
}
function gradingFunction10() {
    document.getElementById("weighted10").value = document.getElementById("grade10").value / document.getElementById("possible10").value * document.getElementById("weight10").value;
    addValues();
}
function addValues() //computes the final total by addding each of the weighted grades and multiplying by 100.
{
    document.getElementById("total").value = (Number(document.getElementById("weighted1").value) + Number(document.getElementById("weighted2").value) + Number(document.getElementById("weighted3").value) + Number(document.getElementById("weighted4").value)+ Number(document.getElementById("weighted5").value)+ Number(document.getElementById("weighted6").value)+ Number(document.getElementById("weighted7").value)+ Number(document.getElementById("weighted8").value)+ Number(document.getElementById("weighted9").value)+ Number(document.getElementById("weighted10").value)) * 100 + "%";
}

function populateTable(response){
    if(response.recordsExist){
        for(i = 0; i < response.evaluators.length; i++){
            document.getElementById("teachName".concat(i+1)).value = response.evaluators[i];
            document.getElementById("grade".concat(i+1)).value = response.pointsEarned[i];
            document.getElementById("possible".concat(i+1)).value = response.pointsTotal[i];
            document.getElementById("weight".concat(i+1)).value = response.weighting[i];
            fireRowMath(i+1);
        }
    }
}

function fireRowMath(row){
    if(row==1){
        gradingFunction1();
    }
    else if(row==2){
        gradingFunction2();
    }
    else if(row==3){
        gradingFunction3();
    }
    else if(row==4){
        gradingFunction4();
    }
    else if(row==5){
        gradingFunction5();
    }
    else if(row==6){
        gradingFunction6();
    }
    else if(row==7){
        gradingFunction7();
    }
    else if(row==8){
        gradingFunction8();
    }
    else if(row==9){
        gradingFunction9();
    }
    else if(row==10){
        gradingFunction10();
    }
}

function save(){
    var evaluators = "";
    var ptsErnd = "";
    var ptsPos = "";
    var weights = "";
    for(i = 1; i<=10; i++){
        if(document.getElementById("teachName".concat(i)).value.trim() != "" || document.getElementById("grade".concat(i)).value.trim() != "" ||
           document.getElementById("possible".concat(i)).value.trim() != "" || document.getElementById("weight".concat(i)).value.trim() != ""){
            if(evaluators == ""){
                evaluators = document.getElementById("teachName".concat(i)).value.trim();
            }
            else{
                evaluators = evaluators.concat(",").concat(document.getElementById("teachName".concat(i)).value.trim());
            }
            if(ptsErnd == ""){
                ptsErnd = document.getElementById("grade".concat(i)).value.trim();
            }
            else{
                ptsErnd = ptsErnd.concat(",").concat(document.getElementById("grade".concat(i)).value.trim());
            }
            if(ptsPos == ""){
                ptsPos = document.getElementById("possible".concat(i)).value.trim();
            }
            else{
                ptsPos = ptsPos.concat(",").concat(document.getElementById("possible".concat(i)).value.trim());
            }
            if(weights == ""){
                weights = document.getElementById("weight".concat(i)).value.trim();
            }
            else{
                weights = weights.concat(",").concat(document.getElementById("weight".concat(i)).value.trim());
            }
            
            dojo.xhrPost({
                url: "/PMA/instructor/savePresentationGrades",
                handleAs: "json",
                content:{
                  "gid": gid,
                  "evaluators": evaluators, 
                  "ptsErnd": ptsErnd,
                  "ptsPos": ptsPos,
                  "weights": weights
                },
                load: saveResponse
            });
        }
    }
}

function saveResponse(response){
    if(!response){
        alert("Save Unsuccessful");
    }
}

dojo.ready(function(){
    gid = parent.selectedGroupId;
    dojo.xhrPost({
        url: "/PMA/instructor/presentationGrades",
        handleAs: "json",
        content:{
            "gid": gid
        },
        load: populateTable
    });
});

</script>
</head>
<body>
<!--Building the table row by row. Each <tr> tag is a new row, each <td> tag is a new cell -->
<table border = 1 style="width:10%; border-color:#F58026 ; color:#FFDE00; border-width:5px"> 
  <tr>
	<td style= "background-color:#860038"> Evaluator</td>
	<td style= "background-color:#860038"> Points Earned</td>
	<td style= "background-color:#860038"> Points Possible </td>
	<td style= "background-color:#860038"> Weighting</td>
	<td style= "background-color:#860038"> Weighted Grade</td>
	
  </tr>
  <tr>
    <td><input type = "text" id="teachName1" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade1" value="" style="width:auto;"></td>
    <td><input type = "text" id="possible1" value="" style="width:auto;"></td>
	<td><input type = "text" id="weight1" value="" onblur="gradingFunction1()" style="width:auto;"></td>
    <td><input type = "text" id="weighted1" value="" style="width:auto;"></td>
  </tr>
  <tr>
    <td><input type = "text" id="teachName2" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade2" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible2" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight2" value="" onblur="gradingFunction2()"style="width:auto;"></td>
    <td><input type = "text" id="weighted2" value="" style="width:auto;"></td>
  </tr>
  <tr>
    <td><input type = "text" id="teachName3" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade3" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible3" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight3" value="" onblur="gradingFunction3()"style="width:auto;"></td>
    <td><input type = "text" id="weighted3" value="" style="width:auto;"></td>
  </tr>
  <tr>
    <td><input type = "text" id="teachName4" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade4" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible4" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight4" value="" onblur="gradingFunction4()"style="width:auto;"></td>
    <td><input type = "text" id="weighted4" value="" style="width:auto;"></td>
  </tr>
    <tr>
    <td><input type = "text" id="teachName5" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade5" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible5" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight5" value="" onblur="gradingFunction5()"style="width:auto;"></td>
    <td><input type = "text" id="weighted5" value="" style="width:auto;"></td>
  </tr>
    <tr>
    <td><input type = "text" id="teachName6" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade6" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible6" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight6" value="" onblur="gradingFunction6()"style="width:auto;"></td>
    <td><input type = "text" id="weighted6" value="" style="width:auto;"></td>
  </tr>
    <tr>
    <td><input type = "text" id="teachName7" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade7" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible7" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight7" value="" onblur="gradingFunction7()"style="width:auto;"></td>
    <td><input type = "text" id="weighted7" value="" style="width:auto;"></td>
  </tr>
    <tr>
    <td><input type = "text" id="teachName8" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade8" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible8" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight8" value="" onblur="gradingFunction8()"style="width:auto;"></td>
    <td><input type = "text" id="weighted8" value="" style="width:auto;"></td>
  </tr>
    <tr>
    <td><input type = "text" id="teachName9" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade9" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible9" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight9" value="" onblur="gradingFunction9()"style="width:auto;"></td>
    <td><input type = "text" id="weighted9" value="" style="width:auto;"></td>
  </tr>
    <tr>
    <td><input type = "text" id="teachName10" value="" style="width:auto;"></td>
	<td><input type = "text" id="grade10" value="" style="width:auto;"></td>
	<td><input type = "text" id="possible10" value="" style="width:auto;"></td>
    <td><input type = "text" id="weight10" value="" onblur="gradingFunction10()"style="width:auto;"></td>
    <td><input type = "text" id="weighted10" value="" style="width:auto;"></td>
  </tr>
  <tr>
	<th colspan="4" style= "background-color:#860038">Weighted Total</th>
	<td><input type = "text" id="total" value="0" ></td>
</table>
<button onclick="save();" title="Save Grades">Save</button>

</body>
</html>
