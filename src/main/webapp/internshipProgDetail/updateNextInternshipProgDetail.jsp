<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipProgDetail.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<!-- begin: submit buttons -->
<style>
.form-submit-button {
background: #0066A2;
color: white;
border-style: outset;
border-color: #0066A2;
height: 30px;
width: 70px;
font: bold17px arial,sans-serif;
text-shadow: none;
}
</style>
<!-- end: submit buttons -->
<!--  Begin: Date Picker -->
<link href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/themes/base/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.1/jquery-ui.min.js"></script>
<script>
    $(document).ready(function () {
    	$('input[id$=fromDt]').datepicker({
    	    dateFormat: 'dd-mm-yy'
    	});
    });
    $(document).ready(function () {
    	$('input[id$=toDt]').datepicker({
    	    dateFormat: 'dd-mm-yy'
    	});
    });
    $(document).ready(function () {
    	$('input[id$=updateDt]').datepicker({
    	    dateFormat: 'dd-mm-yy'
    	});
    });
    $(document).ready(function () {
    	$('input[id$=circularDt]').datepicker({
    	    dateFormat: 'dd-mm-yy'
    	});
    });
</script>
<!-- End: Date Picker -->
 <link rel="stylesheet" href="topMenu.css">
 <link rel="stylesheet" href="leftMenu.css">
<style>
div#banner {
background-color: white;
height: 120px;
}
div#main {
border: solid 2px blue;
margin-left: 100px;
min-height: 300px;
background-color: yellow;
}
div#leftMenu {
background-color: green;
width: 80px;
position: relative;
top: 0px;
min-height: 300px;
}
div#topMenu {
border: 0px solid red;
background-color: orange;
}
div#main {
border: 2px solid red;
background-color: red;
}
div#content {
border: 2px solid red;
background-color: red;
}
.container {
    background-color:white;
    display:flex;
}
.fixed-left-menu {
    background-color:white;
    width: 200px;
}
.flex-item {
    background-color:white;
    flex-grow: 1;
}
</style>
</head>
<meta charset="ISO-8859-1">
<title>Dashboard Template</title>
</head>
<body>
<div id="outer">
<!-- begin: banner -->
<div id="banner" align="center">
<img alt="nitttr-bpl" src="banner.jpg" width="70%" height="100%" >
</div>
<!-- begin: banner -->
<br/>
<!--  begin: top menu -->
<div id="topMenu" class="topMenu">
<%@include file="topMenu.jsp" %>
</div>
<!--  end: top menu -->
<!--  begin: container -->
<div class="container">
    
    <!-- begin: side navigation -->
    <!-- end: side navigation -->
    <%@include file="leftMenu.jsp" %>
    <!--  begin: main content -->
    <div class="flex-item" align="center">
    
    <h1>Main Content</h1>
    

<%
DropDownDBService dropDownDBService =new DropDownDBService();
InternshipProgDetail internshipProgDetail = (InternshipProgDetail)request.getAttribute("internshipProgDetail");
String homeURL=(String)request.getSession().getAttribute("homeURL");
ArrayList<DropDownDTO> list = new ArrayList<DropDownDTO>();
DropDownDTO ddDto=new DropDownDTO();
Iterator<DropDownDTO> it = list.iterator();
%>
<form action="" id="myform" name="myform" accept-charset="UTF-8" >

<%if(null!=request.getSession().getAttribute("msg")){ %>
<%String msg = (String)request.getSession().getAttribute("msg");%>
<%if(!msg.equals("")){ %>
<br/><font color="red"><%=msg%></font><br/>
<%}%>
<%request.getSession().removeAttribute("msg");%>
<%}%>
<table cellspacing="10px">

<tr>

<td>ID:</td>
<td><%=internshipProgDetail.getId()%></td>
</tr>

<tr>

<td>
code<font color="red">*</font>:
</td>

<td>
<input required type="text" name="code" value="<%=internshipProgDetail.getCode()%>" size="30">
</td>

</tr>

<tr>

<td>
value<font color="red">*</font>:
</td>

<td>
<input required type="text" name="value" value="<%=internshipProgDetail.getValue()%>" size="30">
</td>

</tr>

<tr>

<td>
SESSIONSYEAR<font color="red">*</font>:
</td>

<td>

<%list = dropDownDBService.getList("dd_sessionYear");
it = list.iterator();%>
<select required name="sessionYear">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipProgDetail.getSessionYear().equals(ddDto.getCode())){
%>
<option selected value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } else { %>
<option value="<%=ddDto.getCode()%>"><%=ddDto.getValue()%></option>
<% } %>
<%}%>
</select>
</td>

</tr>

<tr>

<td>
PRGTITLE<font color="red">*</font>:
</td>

<td>
<input required type="text" name="prgTitle" value="<%=internshipProgDetail.getPrgTitle()%>" size="30">
</td>

</tr>

<tr>

<td>
FORMDR<font color="red">*</font>:
</td>

<td>
<input type="text" id="fromDt" name="fromDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt())%>">
</td>

</tr>

<tr>

<td>
TODT<font color="red">*</font>:
</td>

<td>
<input type="text" id="toDt" name="toDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt())%>">
</td>

</tr>

<tr>

<td>
PRGCOORD<font color="red">*</font>:
</td>

<td>
<input required type="text" name="prgCoord" value="<%=internshipProgDetail.getPrgCoord()%>" size="30">
</td>

</tr>

<tr>

<td>
VENUE<font color="red">*</font>:
</td>

<td>
<input required type="text" name="venue" value="<%=internshipProgDetail.getVenue()%>" size="30">
</td>

</tr>

<tr>

<td>
TARGET<font color="red">*</font>:
</td>

<td>
<input required type="text" name="target" value="<%=internshipProgDetail.getTarget()%>" size="30">
</td>

</tr>

<tr>

<td>
STATUS<font color="red">*</font>:
</td>

<td>
<input required type="text" name="status" value="<%=internshipProgDetail.getStatus()%>" size="30">
</td>

</tr>

<tr>

<td>
COORDSTATE<font color="red">*</font>:
</td>

<td>
<input required type="text" name="CoordState" value="<%=internshipProgDetail.getCoordState()%>" size="30">
</td>

</tr>

<tr>

<td>
FACILITYLIST <font color="red">*</font>:
</td>

<td>
<input required type="text" name="facultyList" value="<%=internshipProgDetail.getFacultyList()%>" size="30">
</td>

</tr>

<tr>

<td>
NAMEEXPERT<font color="red">*</font>:
</td>

<td>
<input required type="text" name="nameExpert" value="<%=internshipProgDetail.getNameExpert()%>" size="30">
</td>

</tr>

<tr>

<td>
MINSEAT<font color="red">*</font>:
</td>

<td>
<input required type="text" name="minSeat" value="<%=internshipProgDetail.getMinSeat()%>" size="30">
</td>

</tr>

<tr>

<td>
MAXSEAT<font color="red">*</font>:
</td>

<td>
<input required type="text" name="maxSeat" value="<%=internshipProgDetail.getMaxSeat()%>" size="30">
</td>

</tr>

<tr>

<td>
UPDATEBY<font color="red">*</font>:
</td>

<td>
<input required type="text" name="updateBy" value="<%=internshipProgDetail.getUpdateBy()%>" size="30">
</td>

</tr>

<tr>

<td>
UPDATEDT<font color="red">*</font>:
</td>

<td>
<input type="text" id="updateDt" name="updateDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt())%>">
</td>

</tr>

<tr>

<td>
TRAININGMODE<font color="red">*</font>:
</td>

<td>
<input required type="text" name="trainingMode" value="<%=internshipProgDetail.getTrainingMode()%>" size="30">
</td>

</tr>

<tr>

<td>
CERTITEMPL<font color="red">*</font>:
</td>

<td>
<input required type="text" name="certiTempl" value="<%=internshipProgDetail.getCertiTempl()%>" size="30">
</td>

</tr>

<tr>

<td>
CIRCULARNO<font color="red">*</font>:
</td>

<td>
<input required type="text" name="circularNo" value="<%=internshipProgDetail.getCircularNo()%>" size="30">
</td>

</tr>

<tr>

<td>
CIRCULARDT:
</td>

<td>
<input type="text" id="circularDt" name="circularDt" value="<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt())%>">
</td>

</tr>

<tr>

<td>
TRAININGTYPE<font color="red">*</font>:
</td>

<td>
<input required type="text" name="trainingType" value="<%=internshipProgDetail.getTrainingType()%>" size="30">
</td>

</tr>

<tr>

<td>
TRAININGDURATION<font color="red">*</font>:
</td>

<td>
<input required type="text" name="trainingDuration" value="<%=internshipProgDetail.getTrainingDuration()%>" size="30">
</td>

</tr>

<tr>

<td>
MINQUALIFICATION<font color="red">*</font>:
</td>

<td>
<input required type="text" name="minQualification" value="<%=internshipProgDetail.getMinQualification()%>" size="30">
</td>

</tr>

<tr>

<td>
TRAININGNAME <font color="red">*</font>:
</td>

<td>
<input required type="text" name="trainingName" value="<%=internshipProgDetail.getTrainingName()%>" size="30">
</td>

</tr>

<tr>

<td>
DEPTCOORDINATING<font color="red">*</font>:
</td>

<td>
<input required type="text" name="deptCoordinating" value="<%=internshipProgDetail.getDeptCoordinating()%>" size="30">
</td>

</tr>

</table>

<input type="hidden" name="page" value= "updateNextInternshipProgDetail">
<input type="hidden" name="id" value= "<%=internshipProgDetail.getId()%>">
</form>

<button type="submit" form="myform"  name="opr" value= "update" class="form-submit-button">Save</button>
<a href="<%=homeURL%>"><button type="button" class="form-submit-button">Close</button></a>
<a href=""><button type="button" class="form-submit-button">Next</button></a>
<% dropDownDBService.closeConnection(); %>
    
    </div>
    <!--  end: main content -->
</div>
<!--  end: container -->
</div>
</body>
</html>
