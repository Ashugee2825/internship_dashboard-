<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipRegd.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="tablecss1.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
  background: rgb(204,204,204); 
}
page {
  background: white;
  display: block;
  margin: 0 auto;
  margin-bottom: 0.5cm;
  
}
page[size="A4"] {  
  width: 21cm;
  height: 29.7cm; 
}
page[size="A4"][layout="landscape"] {
  width: 29.7cm;
  height: 21cm;  
}
page[size="A3"] {
  width: 29.7cm;
  height: 42cm;
}
page[size="A3"][layout="landscape"] {
  width: 42cm;
  height: 29.7cm;  
}
page[size="A5"] {
  width: 14.8cm;
  height: 21cm;
}
page[size="A5"][layout="landscape"] {
  width: 21cm;
  height: 14.8cm;  
}
@media print {
  body, page {
    margin: 0;
    box-shadow: 0;
  }
}
</style>
</head>
<body>
<page size="A4">
<div align="center">
<h1> Print Form Content </h1>
    <!--  Begin: Dynamic Codes -->

<%
InternshipRegd internshipRegd = (InternshipRegd)request.getAttribute("internshipRegd");
%>
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
</div>
</page>
<!-- <page size="A4"></page>
<page size="A4" layout="landscape"></page>
<page size="A5"></page>
<page size="A5" layout="landscape"></page>
<page size="A3"></page>
<page size="A3" layout="landscape"></page>
 -->
</body>
</html>
