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
            dojo.require("dijit/form/DateTextBox");
            dojo.require("dijit.dijit");
            dojo.require("dojox.layout.TableContainer");
            dojo.require("dijit.form.TextBox");
            //dojo.require("dijit.form.Checkbox");
            
            dojo.ready(function(){
                document.getElementById("A2").value=parent.peerEvalOf;
                document.getElementById("A3").value=parent.selectedGroup;
            });
        </script>
    </head>
    <body class="claro">
        <div style="width: 150px; margin: auto;">Peer Evaluation Form</div>
        <br><br>
        <div style="width: 80%; margin: auto;">
            <label for="date">Date:</label>
            <input type="text" name="date" id="A1" title="Date"
            data-dojo-type="dijit/form/DateTextBox"
            required="true" />
            <label for="teamMemberName" >Team Member Name:</label>
            <input type="text" name="teamMemberName" title="Team Member Name"
            data-dojo-type="dijit/form/TextBox"
            data-dojo-props="trim:true" id="A2" />
            <label for="project" >Project:</label>
            <input type="text" name="project" title="Project"
            data-dojo-type="dijit/form/TextBox"
            data-dojo-props="trim:true" id="A3" />
        </div>
        <br><br>
        <div style="font-weight: bold;">1.  Please rate your peer on the following*:</div>
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
        2.  Please provide a narrative with evidence to support any factors for which you have rated your peer as Excellent or Unacceptable.
        </div>
        <br>
        <textarea id="A12" name="textarea1" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        3.  Please list any additional factors that you believe are important for consideration in assessing the performance of your peer to date.
        </div>
        <br>
        <textarea id="A13" name="textarea2" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        4. Describe two strengths that this team member brings to your team.
        </div>
        <br>
        <textarea id="A14" name="textarea3" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        5. Describe the two most significant areas for improvement for this team member.
        </div>
        <br>
        <textarea id="A15" name="textarea4" style="width:50%;"></textarea>
        <br><br>
        <hr>
        <br>
        <div>*Adapted from the "Management Communications for Undergraduates" (15.279), Sloan School of Management, MIT, by Dr. Lori Breslow, 2000</div>
        
    </body>
</html>
