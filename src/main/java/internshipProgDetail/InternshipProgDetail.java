package internshipProgDetail;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class InternshipProgDetail {
 
int id;
String code;
String value;
String sessionYear;
String sessionYearValue;
String prgTitle;
Date fromDt;
Date fromDtFrom;
Date fromDtTo;
Date toDt;
Date toDtFrom;
Date toDtTo;
int prgCoord;
String venue;
String target;
String status;
String CoordState;
int facultyList;
String nameExpert;
int minSeat;
int maxSeat;
String updateBy;
Date updateDt;
Date updateDtFrom;
Date updateDtTo;
String trainingMode;
String certiTempl;
String circularNo;
Date circularDt;
Date circularDtFrom;
Date circularDtTo;
String trainingType;
String trainingDuration;
String minQualification;
String trainingName;
String deptCoordinating;

public int getId()
{
return id;
}
public void setId(int id)
{
this.id=id;
}
public String getCode()
{
return code;
}
public void setCode(String code)
{
this.code=code;
}
public String getValue()
{
return value;
}
public void setValue(String value)
{
this.value=value;
}
public String getSessionYear()
{
return sessionYear;
}
public String getSessionYearValue()
{
return sessionYearValue;
}
public void setSessionYear(String sessionYear)
{
this.sessionYear=sessionYear;
}
public void setSessionYearValue(String sessionYearValue)
{
this.sessionYearValue = sessionYearValue;
}
public String getPrgTitle()
{
return prgTitle;
}
public void setPrgTitle(String prgTitle)
{
this.prgTitle=prgTitle;
}
public Date getFromDt()
{
return fromDt;
}
public Date getFromDtFrom()
{
return fromDtFrom;
}
public Date getFromDtTo()
{
return fromDtTo;
}
public void setFromDt(Date fromDt)
{
this.fromDt=fromDt;
}
public void setFromDtFrom(Date fromDtFrom)
{
this.fromDtFrom=fromDtFrom;
}
public void setFromDtTo(Date fromDtTo)
{
this.fromDtTo=fromDtTo;
}
public Date getToDt()
{
return toDt;
}
public Date getToDtFrom()
{
return toDtFrom;
}
public Date getToDtTo()
{
return toDtTo;
}
public void setToDt(Date toDt)
{
this.toDt=toDt;
}
public void setToDtFrom(Date toDtFrom)
{
this.toDtFrom=toDtFrom;
}
public void setToDtTo(Date toDtTo)
{
this.toDtTo=toDtTo;
}
public int getPrgCoord()
{
return prgCoord;
}
public void setPrgCoord(int prgCoord)
{
this.prgCoord=prgCoord;
}
public String getVenue()
{
return venue;
}
public void setVenue(String venue)
{
this.venue=venue;
}
public String getTarget()
{
return target;
}
public void setTarget(String target)
{
this.target=target;
}
public String getStatus()
{
return status;
}
public void setStatus(String status)
{
this.status=status;
}
public String getCoordState()
{
return CoordState;
}
public void setCoordState(String CoordState)
{
this.CoordState=CoordState;
}
public int getFacultyList()
{
return facultyList;
}
public void setFacultyList(int facultyList)
{
this.facultyList=facultyList;
}
public String getNameExpert()
{
return nameExpert;
}
public void setNameExpert(String nameExpert)
{
this.nameExpert=nameExpert;
}
public int getMinSeat()
{
return minSeat;
}
public void setMinSeat(int minSeat)
{
this.minSeat=minSeat;
}
public int getMaxSeat()
{
return maxSeat;
}
public void setMaxSeat(int maxSeat)
{
this.maxSeat=maxSeat;
}
public String getUpdateBy()
{
return updateBy;
}
public void setUpdateBy(String updateBy)
{
this.updateBy=updateBy;
}
public Date getUpdateDt()
{
return updateDt;
}
public Date getUpdateDtFrom()
{
return updateDtFrom;
}
public Date getUpdateDtTo()
{
return updateDtTo;
}
public void setUpdateDt(Date updateDt)
{
this.updateDt=updateDt;
}
public void setUpdateDtFrom(Date updateDtFrom)
{
this.updateDtFrom=updateDtFrom;
}
public void setUpdateDtTo(Date updateDtTo)
{
this.updateDtTo=updateDtTo;
}
public String getTrainingMode()
{
return trainingMode;
}
public void setTrainingMode(String trainingMode)
{
this.trainingMode=trainingMode;
}
public String getCertiTempl()
{
return certiTempl;
}
public void setCertiTempl(String certiTempl)
{
this.certiTempl=certiTempl;
}
public String getCircularNo()
{
return circularNo;
}
public void setCircularNo(String circularNo)
{
this.circularNo=circularNo;
}
public Date getCircularDt()
{
return circularDt;
}
public Date getCircularDtFrom()
{
return circularDtFrom;
}
public Date getCircularDtTo()
{
return circularDtTo;
}
public void setCircularDt(Date circularDt)
{
this.circularDt=circularDt;
}
public void setCircularDtFrom(Date circularDtFrom)
{
this.circularDtFrom=circularDtFrom;
}
public void setCircularDtTo(Date circularDtTo)
{
this.circularDtTo=circularDtTo;
}
public String getTrainingType()
{
return trainingType;
}
public void setTrainingType(String trainingType)
{
this.trainingType=trainingType;
}
public String getTrainingDuration()
{
return trainingDuration;
}
public void setTrainingDuration(String trainingDuration)
{
this.trainingDuration=trainingDuration;
}
public String getMinQualification()
{
return minQualification;
}
public void setMinQualification(String minQualification)
{
this.minQualification=minQualification;
}
public String getTrainingName()
{
return trainingName;
}
public void setTrainingName(String trainingName)
{
this.trainingName=trainingName;
}
public String getDeptCoordinating()
{
return deptCoordinating;
}
public void setDeptCoordinating(String deptCoordinating)
{
this.deptCoordinating=deptCoordinating;
}


public void setRequestParam(HttpServletRequest request) {

this.setId(null!=request.getParameter("id")&&!request.getParameter("id").equals("")?Integer.parseInt((String)request.getParameter("id")):0);
this.setCode(null!=request.getParameter("code")?request.getParameter("code"):"");
this.setValue(null!=request.getParameter("value")?request.getParameter("value"):"");
this.setSessionYear(null!=request.getParameter("sessionYear")?request.getParameter("sessionYear"):"");
this.setPrgTitle(null!=request.getParameter("prgTitle")?request.getParameter("prgTitle"):"");
this.setFromDt(null!=request.getParameter("fromDt")&&!request.getParameter("fromDt").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("fromDt")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setFromDtFrom(null!=request.getParameter("fromDtFrom")&&!request.getParameter("fromDtFrom").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("fromDtFrom")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setFromDtTo(null!=request.getParameter("fromDtTo")&&!request.getParameter("fromDtTo").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("fromDtTo")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setToDt(null!=request.getParameter("toDt")&&!request.getParameter("toDt").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("toDt")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setToDtFrom(null!=request.getParameter("toDtFrom")&&!request.getParameter("toDtFrom").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("toDtFrom")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setToDtTo(null!=request.getParameter("toDtTo")&&!request.getParameter("toDtTo").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("toDtTo")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setPrgCoord(null!=request.getParameter("prgCoord")&&!request.getParameter("prgCoord").equals("")?Integer.parseInt((String)request.getParameter("prgCoord")):0);
this.setVenue(null!=request.getParameter("venue")?request.getParameter("venue"):"");
this.setTarget(null!=request.getParameter("target")?request.getParameter("target"):"");
this.setStatus(null!=request.getParameter("status")?request.getParameter("status"):"");
this.setCoordState(null!=request.getParameter("CoordState")?request.getParameter("CoordState"):"");
this.setFacultyList(null!=request.getParameter("facultyList")&&!request.getParameter("facultyList").equals("")?Integer.parseInt((String)request.getParameter("facultyList")):0);
this.setNameExpert(null!=request.getParameter("nameExpert")?request.getParameter("nameExpert"):"");
this.setMinSeat(null!=request.getParameter("minSeat")&&!request.getParameter("minSeat").equals("")?Integer.parseInt((String)request.getParameter("minSeat")):0);
this.setMaxSeat(null!=request.getParameter("maxSeat")&&!request.getParameter("maxSeat").equals("")?Integer.parseInt((String)request.getParameter("maxSeat")):0);
this.setUpdateBy(null!=request.getParameter("updateBy")?request.getParameter("updateBy"):"");
this.setUpdateDt(null!=request.getParameter("updateDt")&&!request.getParameter("updateDt").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("updateDt")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtFrom(null!=request.getParameter("updateDtFrom")&&!request.getParameter("updateDtFrom").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("updateDtFrom")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtTo(null!=request.getParameter("updateDtTo")&&!request.getParameter("updateDtTo").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("updateDtTo")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setTrainingMode(null!=request.getParameter("trainingMode")?request.getParameter("trainingMode"):"");
this.setCertiTempl(null!=request.getParameter("certiTempl")?request.getParameter("certiTempl"):"");
this.setCircularNo(null!=request.getParameter("circularNo")?request.getParameter("circularNo"):"");
this.setCircularDt(null!=request.getParameter("circularDt")&&!request.getParameter("circularDt").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("circularDt")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setCircularDtFrom(null!=request.getParameter("circularDtFrom")&&!request.getParameter("circularDtFrom").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("circularDtFrom")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setCircularDtTo(null!=request.getParameter("circularDtTo")&&!request.getParameter("circularDtTo").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("circularDtTo")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setTrainingType(null!=request.getParameter("trainingType")?request.getParameter("trainingType"):"");
this.setTrainingDuration(null!=request.getParameter("trainingDuration")?request.getParameter("trainingDuration"):"");
this.setMinQualification(null!=request.getParameter("minQualification")?request.getParameter("minQualification"):"");
this.setTrainingName(null!=request.getParameter("trainingName")?request.getParameter("trainingName"):"");
this.setDeptCoordinating(null!=request.getParameter("deptCoordinating")?request.getParameter("deptCoordinating"):"");

}

public void displayReqParam(HttpServletRequest request) {


System.out.println("------Begin:Request Param Values---------");
System.out.println("id = "+request.getParameter("id"));
System.out.println("code = "+request.getParameter("code"));
System.out.println("value = "+request.getParameter("value"));
System.out.println("sessionYear = "+request.getParameter("sessionYear"));
System.out.println("prgTitle = "+request.getParameter("prgTitle"));
System.out.println("fromDt = "+request.getParameter("fromDt"));
System.out.println("fromDtFrom = "+request.getParameter("fromDtFrom"));
System.out.println("fromDtTo = "+request.getParameter("fromDtTo"));
System.out.println("toDt = "+request.getParameter("toDt"));
System.out.println("toDtFrom = "+request.getParameter("toDtFrom"));
System.out.println("toDtTo = "+request.getParameter("toDtTo"));
System.out.println("prgCoord = "+request.getParameter("prgCoord"));
System.out.println("venue = "+request.getParameter("venue"));
System.out.println("target = "+request.getParameter("target"));
System.out.println("status = "+request.getParameter("status"));
System.out.println("CoordState = "+request.getParameter("CoordState"));
System.out.println("facultyList = "+request.getParameter("facultyList"));
System.out.println("nameExpert = "+request.getParameter("nameExpert"));
System.out.println("minSeat = "+request.getParameter("minSeat"));
System.out.println("maxSeat = "+request.getParameter("maxSeat"));
System.out.println("updateBy = "+request.getParameter("updateBy"));
System.out.println("updateDt = "+request.getParameter("updateDt"));
System.out.println("updateDtFrom = "+request.getParameter("updateDtFrom"));
System.out.println("updateDtTo = "+request.getParameter("updateDtTo"));
System.out.println("trainingMode = "+request.getParameter("trainingMode"));
System.out.println("certiTempl = "+request.getParameter("certiTempl"));
System.out.println("circularNo = "+request.getParameter("circularNo"));
System.out.println("circularDt = "+request.getParameter("circularDt"));
System.out.println("circularDtFrom = "+request.getParameter("circularDtFrom"));
System.out.println("circularDtTo = "+request.getParameter("circularDtTo"));
System.out.println("trainingType = "+request.getParameter("trainingType"));
System.out.println("trainingDuration = "+request.getParameter("trainingDuration"));
System.out.println("minQualification = "+request.getParameter("minQualification"));
System.out.println("trainingName = "+request.getParameter("trainingName"));
System.out.println("deptCoordinating = "+request.getParameter("deptCoordinating"));

System.out.println("------End:Request Param Values---------");
}

public void displayValues() {

System.out.println("Id = "+this.getId());
System.out.println("Code = "+this.getCode());
System.out.println("Value = "+this.getValue());
System.out.println("SessionYear = "+this.getSessionYear());
System.out.println("PrgTitle = "+this.getPrgTitle());
System.out.println("FromDt = "+DateService.getDTSYYYMMDDFormat(this.getFromDt()));
System.out.println("FromDtFrom = "+DateService.getDTSYYYMMDDFormat(this.getFromDtFrom()));
System.out.println("FromDtTo = "+DateService.getDTSYYYMMDDFormat(this.getFromDtTo()));
System.out.println("ToDt = "+DateService.getDTSYYYMMDDFormat(this.getToDt()));
System.out.println("ToDtFrom = "+DateService.getDTSYYYMMDDFormat(this.getToDtFrom()));
System.out.println("ToDtTo = "+DateService.getDTSYYYMMDDFormat(this.getToDtTo()));
System.out.println("PrgCoord = "+this.getPrgCoord());
System.out.println("Venue = "+this.getVenue());
System.out.println("Target = "+this.getTarget());
System.out.println("Status = "+this.getStatus());
System.out.println("CoordState = "+this.getCoordState());
System.out.println("FacultyList = "+this.getFacultyList());
System.out.println("NameExpert = "+this.getNameExpert());
System.out.println("MinSeat = "+this.getMinSeat());
System.out.println("MaxSeat = "+this.getMaxSeat());
System.out.println("UpdateBy = "+this.getUpdateBy());
System.out.println("UpdateDt = "+DateService.getDTSYYYMMDDFormat(this.getUpdateDt()));
System.out.println("UpdateDtFrom = "+DateService.getDTSYYYMMDDFormat(this.getUpdateDtFrom()));
System.out.println("UpdateDtTo = "+DateService.getDTSYYYMMDDFormat(this.getUpdateDtTo()));
System.out.println("TrainingMode = "+this.getTrainingMode());
System.out.println("CertiTempl = "+this.getCertiTempl());
System.out.println("CircularNo = "+this.getCircularNo());
System.out.println("CircularDt = "+DateService.getDTSYYYMMDDFormat(this.getCircularDt()));
System.out.println("CircularDtFrom = "+DateService.getDTSYYYMMDDFormat(this.getCircularDtFrom()));
System.out.println("CircularDtTo = "+DateService.getDTSYYYMMDDFormat(this.getCircularDtTo()));
System.out.println("TrainingType = "+this.getTrainingType());
System.out.println("TrainingDuration = "+this.getTrainingDuration());
System.out.println("MinQualification = "+this.getMinQualification());
System.out.println("TrainingName = "+this.getTrainingName());
System.out.println("DeptCoordinating = "+this.getDeptCoordinating());

}

public void setDefaultValues() {

this.setCode("");
this.setValue("");
this.setSessionYear("");
this.setPrgTitle("");
this.setFromDt(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setFromDtFrom(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setFromDtTo(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setToDt(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setToDtFrom(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setToDtTo(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setPrgCoord(0);
this.setVenue("");
this.setTarget("");
this.setStatus("");
this.setCoordState("");
this.setFacultyList(0);
this.setNameExpert("");
this.setMinSeat(0);
this.setMaxSeat(0);
this.setUpdateBy("");
this.setUpdateDt(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtFrom(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtTo(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setTrainingMode("");
this.setCertiTempl("");
this.setCircularNo("");
this.setCircularDt(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setCircularDtFrom(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setCircularDtTo(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setTrainingType("");
this.setTrainingDuration("");
this.setMinQualification("");
this.setTrainingName("");
this.setDeptCoordinating("");

}
}