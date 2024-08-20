<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="internshipProgDetail.*" %>
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
InternshipProgDetail internshipProgDetail = (InternshipProgDetail)request.getAttribute("internshipProgDetail");
%>
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
