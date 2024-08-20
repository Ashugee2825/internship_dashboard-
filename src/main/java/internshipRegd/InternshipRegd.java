package internshipRegd;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class InternshipRegd {
 
int id;
String sessionYear;
String prgId;
int regId;
String studentName;
String email;
String mobileNo;
String fatherName;
String instituteName;
String instituteWeb;
String course;
String courseValue;
String courseYear;
String courseYearValue;
String courseBranch;
String localAddress;
String permAddress;
String city;
String distt;
String state;
String stateValue;
String pin;
String gender;
String genderValue;
String category;
String lodging;
String updatedBy;
Date updateDt;
Date updateDtFrom;
Date updateDtTo;
String updateTime;
String remark;
String batch;

public int getId()
{
return id;
}
public void setId(int id)
{
this.id=id;
}
public String getSessionYear()
{
return sessionYear;
}
public void setSessionYear(String sessionYear)
{
this.sessionYear=sessionYear;
}
public String getPrgId()
{
return prgId;
}
public void setPrgId(String prgId)
{
this.prgId=prgId;
}
public int getRegId()
{
return regId;
}
public void setRegId(int regId)
{
this.regId=regId;
}
public String getStudentName()
{
return studentName;
}
public void setStudentName(String studentName)
{
this.studentName=studentName;
}
public String getEmail()
{
return email;
}
public void setEmail(String email)
{
this.email=email;
}
public String getMobileNo()
{
return mobileNo;
}
public void setMobileNo(String mobileNo)
{
this.mobileNo=mobileNo;
}
public String getFatherName()
{
return fatherName;
}
public void setFatherName(String fatherName)
{
this.fatherName=fatherName;
}
public String getInstituteName()
{
return instituteName;
}
public void setInstituteName(String instituteName)
{
this.instituteName=instituteName;
}
public String getInstituteWeb()
{
return instituteWeb;
}
public void setInstituteWeb(String instituteWeb)
{
this.instituteWeb=instituteWeb;
}
public String getCourse()
{
return course;
}
public String getCourseValue()
{
return courseValue;
}
public void setCourse(String course)
{
this.course=course;
}
public void setCourseValue(String courseValue)
{
this.courseValue = courseValue;
}
public String getCourseYear()
{
return courseYear;
}
public String getCourseYearValue()
{
return courseYearValue;
}
public void setCourseYear(String courseYear)
{
this.courseYear=courseYear;
}
public void setCourseYearValue(String courseYearValue)
{
this.courseYearValue = courseYearValue;
}
public String getCourseBranch()
{
return courseBranch;
}
public void setCourseBranch(String courseBranch)
{
this.courseBranch=courseBranch;
}
public String getLocalAddress()
{
return localAddress;
}
public void setLocalAddress(String localAddress)
{
this.localAddress=localAddress;
}
public String getPermAddress()
{
return permAddress;
}
public void setPermAddress(String permAddress)
{
this.permAddress=permAddress;
}
public String getCity()
{
return city;
}
public void setCity(String city)
{
this.city=city;
}
public String getDistt()
{
return distt;
}
public void setDistt(String distt)
{
this.distt=distt;
}
public String getState()
{
return state;
}
public String getStateValue()
{
return stateValue;
}
public void setState(String state)
{
this.state=state;
}
public void setStateValue(String stateValue)
{
this.stateValue = stateValue;
}
public String getPin()
{
return pin;
}
public void setPin(String pin)
{
this.pin=pin;
}
public String getGender()
{
return gender;
}
public String getGenderValue()
{
return genderValue;
}
public void setGender(String gender)
{
this.gender=gender;
}
public void setGenderValue(String genderValue)
{
this.genderValue = genderValue;
}
public String getCategory()
{
return category;
}
public void setCategory(String category)
{
this.category=category;
}
public String getLodging()
{
return lodging;
}
public void setLodging(String lodging)
{
this.lodging=lodging;
}
public String getUpdatedBy()
{
return updatedBy;
}
public void setUpdatedBy(String updatedBy)
{
this.updatedBy=updatedBy;
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
public String getUpdateTime()
{
return updateTime;
}
public void setUpdateTime(String updateTime)
{
this.updateTime=updateTime;
}
public String getRemark()
{
return remark;
}
public void setRemark(String remark)
{
this.remark=remark;
}
public String getBatch()
{
return batch;
}
public void setBatch(String batch)
{
this.batch=batch;
}


public void setRequestParam(HttpServletRequest request) {

this.setId(null!=request.getParameter("id")&&!request.getParameter("id").equals("")?Integer.parseInt((String)request.getParameter("id")):0);
this.setSessionYear(null!=request.getParameter("sessionYear")?request.getParameter("sessionYear"):"");
this.setPrgId(null!=request.getParameter("prgId")?request.getParameter("prgId"):"");
this.setRegId(null!=request.getParameter("regId")&&!request.getParameter("regId").equals("")?Integer.parseInt((String)request.getParameter("regId")):0);
this.setStudentName(null!=request.getParameter("studentName")?request.getParameter("studentName"):"");
this.setEmail(null!=request.getParameter("email")?request.getParameter("email"):"");
this.setMobileNo(null!=request.getParameter("mobileNo")?request.getParameter("mobileNo"):"");
this.setFatherName(null!=request.getParameter("fatherName")?request.getParameter("fatherName"):"");
this.setInstituteName(null!=request.getParameter("instituteName")?request.getParameter("instituteName"):"");
this.setInstituteWeb(null!=request.getParameter("instituteWeb")?request.getParameter("instituteWeb"):"");
this.setCourse(null!=request.getParameter("course")?request.getParameter("course"):"");
this.setCourseYear(null!=request.getParameter("courseYear")?request.getParameter("courseYear"):"");
this.setCourseBranch(null!=request.getParameter("courseBranch")?request.getParameter("courseBranch"):"");
this.setLocalAddress(null!=request.getParameter("localAddress")?request.getParameter("localAddress"):"");
this.setPermAddress(null!=request.getParameter("permAddress")?request.getParameter("permAddress"):"");
this.setCity(null!=request.getParameter("city")?request.getParameter("city"):"");
this.setDistt(null!=request.getParameter("distt")?request.getParameter("distt"):"");
this.setState(null!=request.getParameter("state")?request.getParameter("state"):"");
this.setPin(null!=request.getParameter("pin")?request.getParameter("pin"):"");
this.setGender(null!=request.getParameter("gender")?request.getParameter("gender"):"");
this.setCategory(null!=request.getParameter("category")?request.getParameter("category"):"");
this.setLodging(null!=request.getParameter("lodging")?request.getParameter("lodging"):"");
this.setUpdatedBy(null!=request.getParameter("updatedBy")?request.getParameter("updatedBy"):"");
this.setUpdateDt(null!=request.getParameter("updateDt")&&!request.getParameter("updateDt").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("updateDt")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtFrom(null!=request.getParameter("updateDtFrom")&&!request.getParameter("updateDtFrom").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("updateDtFrom")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtTo(null!=request.getParameter("updateDtTo")&&!request.getParameter("updateDtTo").equals("")?DateService.getSTDYYYYMMDDFormat(request.getParameter("updateDtTo")):DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateTime(null!=request.getParameter("updateTime")?request.getParameter("updateTime"):"");
this.setRemark(null!=request.getParameter("remark")?request.getParameter("remark"):"");
this.setBatch(null!=request.getParameter("batch")?request.getParameter("batch"):"");

}

public void displayReqParam(HttpServletRequest request) {


System.out.println("------Begin:Request Param Values---------");
System.out.println("id = "+request.getParameter("id"));
System.out.println("sessionYear = "+request.getParameter("sessionYear"));
System.out.println("prgId = "+request.getParameter("prgId"));
System.out.println("regId = "+request.getParameter("regId"));
System.out.println("studentName = "+request.getParameter("studentName"));
System.out.println("email = "+request.getParameter("email"));
System.out.println("mobileNo = "+request.getParameter("mobileNo"));
System.out.println("fatherName = "+request.getParameter("fatherName"));
System.out.println("instituteName = "+request.getParameter("instituteName"));
System.out.println("instituteWeb = "+request.getParameter("instituteWeb"));
System.out.println("course = "+request.getParameter("course"));
System.out.println("courseYear = "+request.getParameter("courseYear"));
System.out.println("courseBranch = "+request.getParameter("courseBranch"));
System.out.println("localAddress = "+request.getParameter("localAddress"));
System.out.println("permAddress = "+request.getParameter("permAddress"));
System.out.println("city = "+request.getParameter("city"));
System.out.println("distt = "+request.getParameter("distt"));
System.out.println("state = "+request.getParameter("state"));
System.out.println("pin = "+request.getParameter("pin"));
System.out.println("gender = "+request.getParameter("gender"));
System.out.println("category = "+request.getParameter("category"));
System.out.println("lodging = "+request.getParameter("lodging"));
System.out.println("updatedBy = "+request.getParameter("updatedBy"));
System.out.println("updateDt = "+request.getParameter("updateDt"));
System.out.println("updateDtFrom = "+request.getParameter("updateDtFrom"));
System.out.println("updateDtTo = "+request.getParameter("updateDtTo"));
System.out.println("updateTime = "+request.getParameter("updateTime"));
System.out.println("remark = "+request.getParameter("remark"));
System.out.println("batch = "+request.getParameter("batch"));

System.out.println("------End:Request Param Values---------");
}

public void displayValues() {

System.out.println("Id = "+this.getId());
System.out.println("SessionYear = "+this.getSessionYear());
System.out.println("PrgId = "+this.getPrgId());
System.out.println("RegId = "+this.getRegId());
System.out.println("StudentName = "+this.getStudentName());
System.out.println("Email = "+this.getEmail());
System.out.println("MobileNo = "+this.getMobileNo());
System.out.println("FatherName = "+this.getFatherName());
System.out.println("InstituteName = "+this.getInstituteName());
System.out.println("InstituteWeb = "+this.getInstituteWeb());
System.out.println("Course = "+this.getCourse());
System.out.println("CourseYear = "+this.getCourseYear());
System.out.println("CourseBranch = "+this.getCourseBranch());
System.out.println("LocalAddress = "+this.getLocalAddress());
System.out.println("PermAddress = "+this.getPermAddress());
System.out.println("City = "+this.getCity());
System.out.println("Distt = "+this.getDistt());
System.out.println("State = "+this.getState());
System.out.println("Pin = "+this.getPin());
System.out.println("Gender = "+this.getGender());
System.out.println("Category = "+this.getCategory());
System.out.println("Lodging = "+this.getLodging());
System.out.println("UpdatedBy = "+this.getUpdatedBy());
System.out.println("UpdateDt = "+DateService.getDTSYYYMMDDFormat(this.getUpdateDt()));
System.out.println("UpdateDtFrom = "+DateService.getDTSYYYMMDDFormat(this.getUpdateDtFrom()));
System.out.println("UpdateDtTo = "+DateService.getDTSYYYMMDDFormat(this.getUpdateDtTo()));
System.out.println("UpdateTime = "+this.getUpdateTime());
System.out.println("Remark = "+this.getRemark());
System.out.println("Batch = "+this.getBatch());

}

public void setDefaultValues() {

this.setSessionYear("");
this.setPrgId("");
this.setRegId(0);
this.setStudentName("");
this.setEmail("");
this.setMobileNo("");
this.setFatherName("");
this.setInstituteName("");
this.setInstituteWeb("");
this.setCourse("");
this.setCourseYear("");
this.setCourseBranch("");
this.setLocalAddress("");
this.setPermAddress("");
this.setCity("");
this.setDistt("");
this.setState("");
this.setPin("");
this.setGender("");
this.setCategory("");
this.setLodging("");
this.setUpdatedBy("");
this.setUpdateDt(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtFrom(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateDtTo(DateService.getSTDYYYYMMDDFormat("11-11-1111"));
this.setUpdateTime("");
this.setRemark("");
this.setBatch("");

}
}