<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipProgDetail.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
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
.mycontainer {
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
<div class="mycontainer">
    
    <!-- begin: side navigation -->
    <%@include file="leftMenu.jsp" %>
    <!-- end: side navigation -->
    
    <!--  begin: main content -->
    <div class="flex-item" align="center">
    
    <h1>Main Content</h1>
    
    <!--  Begin: Dynamic Codes -->

<%
InternshipProgDetail internshipProgDetail = (InternshipProgDetail)request.getAttribute("internshipProgDetail");
String homeURL=(String)request.getSession().getAttribute("homeURL");
%>
<form action="" id="myform"  name="myform" accept-charset="UTF-8" >

<table cellspacing="10px">
<tr>
<td align="right">
id:
</td>

<td>
<%=internshipProgDetail.getId()%>
</td>

</tr>
<tr>
<td align="right">
code:
</td>

<td>
<%=internshipProgDetail.getCode()%>
</td>

</tr>
<tr>
<td align="right">
value:
</td>

<td>
<%=internshipProgDetail.getValue()%>
</td>

</tr>
<tr>
<td align="right">
SESSIONSYEAR:
</td>

<td>
<%=internshipProgDetail.getSessionYearValue()%>
</td>

</tr>
<tr>
<td align="right">
PRGTITLE:
</td>

<td>
<%=internshipProgDetail.getPrgTitle()%>
</td>

</tr>
<tr>
<td align="right">
FORMDR:
</td>

<td>
<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getFromDt())%>
</td>

</tr>
<tr>
<td align="right">
TODT:
</td>

<td>
<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getToDt())%>
</td>

</tr>
<tr>
<td align="right">
PRGCOORD:
</td>

<td>
<%=internshipProgDetail.getPrgCoord()%>
</td>

</tr>
<tr>
<td align="right">
VENUE:
</td>

<td>
<%=internshipProgDetail.getVenue()%>
</td>

</tr>
<tr>
<td align="right">
TARGET:
</td>

<td>
<%=internshipProgDetail.getTarget()%>
</td>

</tr>
<tr>
<td align="right">
STATUS:
</td>

<td>
<%=internshipProgDetail.getStatus()%>
</td>

</tr>
<tr>
<td align="right">
COORDSTATE:
</td>

<td>
<%=internshipProgDetail.getCoordState()%>
</td>

</tr>
<tr>
<td align="right">
FACILITYLIST :
</td>

<td>
<%=internshipProgDetail.getFacultyList()%>
</td>

</tr>
<tr>
<td align="right">
NAMEEXPERT:
</td>

<td>
<%=internshipProgDetail.getNameExpert()%>
</td>

</tr>
<tr>
<td align="right">
MINSEAT:
</td>

<td>
<%=internshipProgDetail.getMinSeat()%>
</td>

</tr>
<tr>
<td align="right">
MAXSEAT:
</td>

<td>
<%=internshipProgDetail.getMaxSeat()%>
</td>

</tr>
<tr>
<td align="right">
UPDATEBY:
</td>

<td>
<%=internshipProgDetail.getUpdateBy()%>
</td>

</tr>
<tr>
<td align="right">
UPDATEDT:
</td>

<td>
<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getUpdateDt())%>
</td>

</tr>
<tr>
<td align="right">
TRAININGMODE:
</td>

<td>
<%=internshipProgDetail.getTrainingMode()%>
</td>

</tr>
<tr>
<td align="right">
CERTITEMPL:
</td>

<td>
<%=internshipProgDetail.getCertiTempl()%>
</td>

</tr>
<tr>
<td align="right">
CIRCULARNO:
</td>

<td>
<%=internshipProgDetail.getCircularNo()%>
</td>

</tr>
<tr>
<td align="right">
CIRCULARDT:
</td>

<td>
<%=DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipProgDetail.getCircularDt())%>
</td>

</tr>
<tr>
<td align="right">
TRAININGTYPE:
</td>

<td>
<%=internshipProgDetail.getTrainingType()%>
</td>

</tr>
<tr>
<td align="right">
TRAININGDURATION:
</td>

<td>
<%=internshipProgDetail.getTrainingDuration()%>
</td>

</tr>
<tr>
<td align="right">
MINQUALIFICATION:
</td>

<td>
<%=internshipProgDetail.getMinQualification()%>
</td>

</tr>
<tr>
<td align="right">
TRAININGNAME :
</td>

<td>
<%=internshipProgDetail.getTrainingName()%>
</td>

</tr>
<tr>
<td align="right">
DEPTCOORDINATING:
</td>

<td>
<%=internshipProgDetail.getDeptCoordinating()%>
</td>

</tr>

</table>

<input type="hidden" name="page" value= "viewInternshipProgDetail">
<input type="hidden" name="id" value= "<%=internshipProgDetail.getId()%>">
</form>

<button type="submit" form="myform"  name="opr" value= "print" class="form-submit-button">Print</button>
<a href="<%=homeURL%>"><button type="button" class="form-submit-button">Close</button></a> 
   <!--  End: Dynamic Codes -->
    </div>
    <!--  end: main content -->
</div>
<!--  end: container -->
</div>
</body>
</html>
