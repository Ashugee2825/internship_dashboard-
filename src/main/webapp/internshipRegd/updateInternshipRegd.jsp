<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipRegd.*" %>
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
    	$('input[id$=updateDt]').datepicker({
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
InternshipRegd internshipRegd = (InternshipRegd)request.getAttribute("internshipRegd");
String homeURL=(String)request.getSession().getAttribute("homeURL");
ArrayList<DropDownDTO> list = new ArrayList<DropDownDTO>();
DropDownDTO ddDto=new DropDownDTO();
Iterator<DropDownDTO> it = list.iterator();
%>
<form action="" id="myform" name="myform" accept-charset="UTF-8" >

<table cellspacing="10px">

<tr>

<td>ID:</td>
<td><%=internshipRegd.getId()%></td>
</tr>

<tr>

<td>
SESSIONYEAR<font color="red">*</font>:
</td>

<td>
<input required type="text" name="sessionYear" value="<%=internshipRegd.getSessionYear()%>" size="30">
</td>

</tr>

<tr>

<td>
PRGID<font color="red">*</font>:
</td>

<td>
<input required type="text" name="prgId" value="<%=internshipRegd.getPrgId()%>" size="30">
</td>

</tr>

<tr>

<td>
REGID<font color="red">*</font>:
</td>

<td>
<input required type="text" name="regId" value="<%=internshipRegd.getRegId()%>" size="30">
</td>

</tr>

<tr>

<td>
STUDENTNAME<font color="red">*</font>:
</td>

<td>
<input required type="text" name="studentName" value="<%=internshipRegd.getStudentName()%>" size="30">
</td>

</tr>

<tr>

<td>
EMAIL<font color="red">*</font>:
</td>

<td>
<input required type="text" name="email" value="<%=internshipRegd.getEmail()%>" size="30">
</td>

</tr>

<tr>

<td>
MOBILENO<font color="red">*</font>:
</td>

<td>
<input required type="text" name="mobileNo" value="<%=internshipRegd.getMobileNo()%>" size="30">
</td>

</tr>

<tr>

<td>
FATHERNAME<font color="red">*</font>:
</td>

<td>
<input required type="text" name="fatherName" value="<%=internshipRegd.getFatherName()%>" size="30">
</td>

</tr>

<tr>

<td>
INSTITUTENAME<font color="red">*</font>:
</td>

<td>
<input required type="text" name="instituteName" value="<%=internshipRegd.getInstituteName()%>" size="30">
</td>

</tr>

<tr>

<td>
INSTITUTEWEB<font color="red">*</font>:
</td>

<td>
<input required type="text" name="instituteWeb" value="<%=internshipRegd.getInstituteWeb()%>" size="30">
</td>

</tr>

<tr>

<td>
COURSE<font color="red">*</font>:
</td>

<td>

<%list = dropDownDBService.getList("dd_course");
it = list.iterator();%>
<select required name="course">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getCourse().equals(ddDto.getCode())){
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
COURSEYEAR<font color="red">*</font>:
</td>

<td>

<%list = dropDownDBService.getList("dd_courseYear");
it = list.iterator();%>
<select required name="courseYear">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getCourseYear().equals(ddDto.getCode())){
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
COURSEBRANCH<font color="red">*</font>:
</td>

<td>
<input required type="text" name="courseBranch" value="<%=internshipRegd.getCourseBranch()%>" size="30">
</td>

</tr>

<tr>

<td>
LOCALADDRESS<font color="red">*</font>:
</td>

<td>
<input required type="text" name="localAddress" value="<%=internshipRegd.getLocalAddress()%>" size="30">
</td>

</tr>

<tr>

<td>
PERMADDRESS<font color="red">*</font>:
</td>

<td>
<input required type="text" name="permAddress" value="<%=internshipRegd.getPermAddress()%>" size="30">
</td>

</tr>

<tr>

<td>
CITY<font color="red">*</font>:
</td>

<td>
<input required type="text" name="city" value="<%=internshipRegd.getCity()%>" size="30">
</td>

</tr>

<tr>

<td>
DISTT<font color="red">*</font>:
</td>

<td>
<input required type="text" name="distt" value="<%=internshipRegd.getDistt()%>" size="30">
</td>

</tr>

<tr>

<td>
STATE<font color="red">*</font>:
</td>

<td>

<%list = dropDownDBService.getList("dd_state");
it = list.iterator();%>
<select required name="state">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getState().equals(ddDto.getCode())){
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
PIN<font color="red">*</font>:
</td>

<td>
<input required type="text" name="pin" value="<%=internshipRegd.getPin()%>" size="30">
</td>

</tr>

<tr>

<td>
GENDER<font color="red">*</font>:
</td>

<td>

<%list = dropDownDBService.getList("dd_gender");
it = list.iterator();%>
<select required name="gender">
<%while(it.hasNext())
{
ddDto= (DropDownDTO)it.next();
if(internshipRegd.getGender().equals(ddDto.getCode())){
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
CATEGORY<font color="red">*</font>:
</td>

<td>
<input required type="text" name="category" value="<%=internshipRegd.getCategory()%>" size="30">
</td>

</tr>

<tr>

<td>
LODGING<font color="red">*</font>:
</td>

<td>
<input required type="text" name="lodging" value="<%=internshipRegd.getLodging()%>" size="30">
</td>

</tr>

<tr>

<td>
UPDATEBY<font color="red">*</font>:
</td>

<td>
<input required type="text" name="updatedBy" value="<%=internshipRegd.getUpdatedBy()%>" size="30">
</td>

</tr>

<tr>

<td>
UPDATEDT<font color="red">*</font>:
</td>

<td>
<input type="text" id="updateDt" name="updateDt" value="<%=DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt()).equals("11-11-1111")?"":DateService.getDTSDDMMYYYY(internshipRegd.getUpdateDt())%>">
</td>

</tr>

<tr>

<td>
UPDATETIME<font color="red">*</font>:
</td>

<td>
<textarea required col="50" row="10" name="updateTime" id="updateTime"><%=internshipRegd.getUpdateTime()%></textarea>
</td>

</tr>

<tr>

<td>
REMARK<font color="red">*</font>:
</td>

<td>
<textarea required col="50" row="10" name="remark" id="remark"><%=internshipRegd.getRemark()%></textarea>
</td>

</tr>

<tr>

<td>
BATCH<font color="red">*</font>:
</td>

<td>
<input required type="text" name="batch" value="<%=internshipRegd.getBatch()%>" size="30">
</td>

</tr>

</table>

<input type="hidden" name="page" value= "updateInternshipRegd">
<input type="hidden" name="id" value= "<%=internshipRegd.getId()%>">
</form>

<button type="submit" form="myform"  name="opr" value= "update" class="form-submit-button">Update</button>
<a href="<%=homeURL%>"><button type="button" class="form-submit-button">Close</button></a>
<% dropDownDBService.closeConnection(); %>
    
    </div>
    <!--  end: main content -->
</div>
<!--  end: container -->
</div>
</body>
</html>
