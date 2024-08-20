<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipRegd.*" %>
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
    	$('input[id$=updateDt]').datepicker({
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
InternshipRegd internshipRegd = (InternshipRegd)request.getAttribute("internshipRegd");
String homeURL=(String)request.getSession().getAttribute("homeURL");
%>
<form action="" id="myform"  name="myform" accept-charset="UTF-8" >

<table cellspacing="10px">
<tr>
<td align="right">
ID:
</td>

<td>
<%=internshipRegd.getId()%>
</td>

</tr>
<tr>
<td align="right">
SESSIONYEAR:
</td>

<td>
<%=internshipRegd.getSessionYear()%>
</td>

</tr>
<tr>
<td align="right">
PRGID:
</td>

<td>
<%=internshipRegd.getPrgId()%>
</td>

</tr>
<tr>
<td align="right">
REGID:
</td>

<td>
<%=internshipRegd.getRegId()%>
</td>

</tr>
<tr>
<td align="right">
STUDENTNAME:
</td>

<td>
<%=internshipRegd.getStudentName()%>
</td>

</tr>
<tr>
<td align="right">
EMAIL:
</td>

<td>
<%=internshipRegd.getEmail()%>
</td>

</tr>
<tr>
<td align="right">
MOBILENO:
</td>

<td>
<%=internshipRegd.getMobileNo()%>
</td>

</tr>
<tr>
<td align="right">
FATHERNAME:
</td>

<td>
<%=internshipRegd.getFatherName()%>
</td>

</tr>
<tr>
<td align="right">
INSTITUTENAME:
</td>

<td>
<%=internshipRegd.getInstituteName()%>
</td>

</tr>
<tr>
<td align="right">
INSTITUTEWEB:
</td>

<td>
<%=internshipRegd.getInstituteWeb()%>
</td>

</tr>
<tr>
<td align="right">
COURSE:
</td>

<td>
<%=internshipRegd.getCourseValue()%>
</td>

</tr>
<tr>
<td align="right">
COURSEYEAR:
</td>

<td>
<%=internshipRegd.getCourseYearValue()%>
</td>

</tr>
<tr>
<td align="right">
COURSEBRANCH:
</td>

<td>
<%=internshipRegd.getCourseBranch()%>
</td>

</tr>
<tr>
<td align="right">
LOCALADDRESS:
</td>

<td>
<%=internshipRegd.getLocalAddress()%>
</td>

</tr>
<tr>
<td align="right">
PERMADDRESS:
</td>

<td>
<%=internshipRegd.getPermAddress()%>
</td>

</tr>
<tr>
<td align="right">
CITY:
</td>

<td>
<%=internshipRegd.getCity()%>
</td>

</tr>
<tr>
<td align="right">
DISTT:
</td>

<td>
<%=internshipRegd.getDistt()%>
</td>

</tr>
<tr>
<td align="right">
STATE:
</td>

<td>
<%=internshipRegd.getStateValue()%>
</td>

</tr>
<tr>
<td align="right">
PIN:
</td>

<td>
<%=internshipRegd.getPin()%>
</td>

</tr>
<tr>
<td align="right">
GENDER:
</td>

<td>
<%=internshipRegd.getGenderValue()%>
</td>

</tr>
<tr>
<td align="right">
CATEGORY:
</td>

<td>
<%=internshipRegd.getCategory()%>
</td>

</tr>
<tr>
<td align="right">
LODGING:
</td>

<td>
<%=internshipRegd.getLodging()%>
</td>

</tr>
<tr>
<td align="right">
UPDATEBY:
</td>

<td>
<%=internshipRegd.getUpdatedBy()%>
</td>

</tr>
<tr>
<td align="right">
UPDATEDT:
</td>

<td>
<%=DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt())%>
</td>

</tr>
<tr>
<td align="right">
UPDATETIME:
</td>

<td>
<%=internshipRegd.getUpdateTime()%>
</td>

</tr>
<tr>
<td align="right">
REMARK:
</td>

<td>
<%=internshipRegd.getRemark()%>
</td>

</tr>
<tr>
<td align="right">
BATCH:
</td>

<td>
<%=internshipRegd.getBatch()%>
</td>

</tr>

</table>

<input type="hidden" name="page" value= "viewInternshipRegd">
<input type="hidden" name="id" value= "<%=internshipRegd.getId()%>">
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
