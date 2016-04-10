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
            dojo.require("dijit.form.Checkbox");
        </script>
    </head>
    <body class="claro">
        <div style="width: 150px; margin: auto;">Self-Assessment Form</div>
        <br><br>
        <div style="width: 800%; margin: auto;">
            <label for="date">Date:</label>
            <input type="text" name="date" id="date1" title="Date"
            data-dojo-type="dijit/form/DateTextBox"
            required="true" />
            <label for="teamMemberName" >Team Member Name:</label>
            <input type="text" name="teamMemberName" title="Team Member Name"
            data-dojo-type="dijit/form/TextBox"
            data-dojo-props="trim:true" id="teamMember" />
            <label for="project" >Project:</label>
            <input type="text" name="project" title="Project"
            data-dojo-type="dijit/form/TextBox"
            data-dojo-props="trim:true" id="project" />
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
                <td class="tg-yw4l"><input type="checkbox" id="MA5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="MA4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="MA3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="MA2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="MA1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Preparation for meeting</td>
                <td class="tg-yw4l"><input type="checkbox" id="PFM5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="PFM4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="PFM3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="PFM2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="PFM1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Efficiency of meeting</td>
                <td class="tg-yw4l"><input type="checkbox" id="EOM5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="EOM4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="EOM3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="EOM2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="EOM1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Communication skills</td>
                <td class="tg-yw4l"><input type="checkbox" id="CS5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="CS4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="CS3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="CS2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="CS1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Equal sharing of workload</td>
                <td class="tg-yw4l"><input type="checkbox" id="ES5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="ES4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="ES3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="ES2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="ES1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Motivation</td>
                <td class="tg-yw4l"><input type="checkbox" id="M5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="M4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="M3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="M2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="M1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Supportiveness</td>
                <td class="tg-yw4l"><input type="checkbox" id="S5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="S4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="S3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="S2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="S1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
            <tr>
                <td class="tg-yw4l">Overall performance</td>
                <td class="tg-yw4l"><input type="checkbox" id="OP5" data-dojo-type="dijit/form/CheckBox" value="5" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="OP4" data-dojo-type="dijit/form/CheckBox" value="4" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="OP3" data-dojo-type="dijit/form/CheckBox" value="3" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="OP2" data-dojo-type="dijit/form/CheckBox" value="2" /></td>
                <td class="tg-yw4l"><input type="checkbox" id="OP1" data-dojo-type="dijit/form/CheckBox" value="1" /></td>
            </tr>
        </table>
        <br><br>
        <div style="font-weight: bold;">
        2.  Please provide a narrative with evidence to support any factors for which you have rated yourself as Excellent or Unacceptable.
        </div>
        <br>
        <textarea id="textarea2" name="textarea2" data-dojo-type="dijit.form.Textarea" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        3.  Please list any additional factors that you believe are important for consideration in assessing your performance to date.
        </div>
        <br>
        <textarea id="textarea2" name="textarea2" data-dojo-type="dijit.form.Textarea" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        4. Describe two strengths that you bring to your team.
        </div>
        <br>
        <textarea id="textarea2" name="textarea2" data-dojo-type="dijit.form.Textarea" style="width:50%;"></textarea>
        <br><br>
        <div style="font-weight: bold;">
        5. Describe the two most significant areas for improvement for yourself as a team member.
        </div>
        <br>
        <textarea id="textarea2" name="textarea2" data-dojo-type="dijit.form.Textarea" style="width:50%;"></textarea>
        <br><br>
        <hr>
        <br>
        <div>*Adapted from the "Management Communications for Undergraduates" (15.279), Sloan School of Management, MIT, by Dr. Lori Breslow, 2000</div>
        
    </body>
</html>
