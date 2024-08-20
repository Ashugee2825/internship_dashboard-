package internshipCoordinator;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
public class InternshipCoordinatorDBService {
	Connection con;
	
	
	public InternshipCoordinatorDBService()
	{
		DBConnectionDTO conDTO = new DBConnectionDTO();
		con=conDTO.getConnection();
	}
	
	public void closeConnection()
	{
		try {
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
public int getTotalPages(int limit)
	{
		String query="select count(*) from Internship_coordinator";
	    int totalRecords=0;
	    int totalPages=0;
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	totalRecords= rs.getInt(1);
	    }
	    stmt.close();
	    rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		totalPages=totalRecords/limit;
		if(totalRecords%limit!=0)
		{
			totalPages+=1;
		}
		return totalPages;
	}
	
	//pagination
	public int getTotalPages(InternshipCoordinator internshipCoordinator,int limit)
	{
		String query=getDynamicQuery2(internshipCoordinator);
		int totalRecords=0;
	    int totalPages=0;
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	totalRecords= rs.getInt(1);
	    }
	    stmt.close();
	    rs.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		totalPages=totalRecords/limit;
		if(totalRecords%limit!=0)
		{
			totalPages+=1;
		}
		return totalPages;
	}
	
	
	public int getInternshipCoordinatorId(InternshipCoordinator internshipCoordinator)
	{
		int id=0;
		String query="select id from Internship_coordinator";
String whereClause = " where "+ "code=? and value=? and shortName=?";
	    query+=whereClause;
		System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipCoordinator.getCode());
pstmt.setString(2, internshipCoordinator.getValue());
pstmt.setString(3, internshipCoordinator.getShortName());
	    ResultSet rs = pstmt.executeQuery();
	    if(rs.next()) {
	       	id = rs.getInt("id");
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return id;
	}
	public void createInternshipCoordinator(InternshipCoordinator internshipCoordinator)
	{
		
String query="INSERT INTO Internship_coordinator(code,value,shortName) VALUES(?,?,?)";
	
    System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipCoordinator.getCode());
pstmt.setString(2, internshipCoordinator.getValue());
pstmt.setString(3, internshipCoordinator.getShortName());
	    int x = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	  
  	System.out.println(e);
		}
		int id = getInternshipCoordinatorId(internshipCoordinator);
		internshipCoordinator.setId(id);
	}
	public void updateInternshipCoordinator(InternshipCoordinator internshipCoordinator)
	{
		
String query="update Internship_coordinator set "+"code=?,value=?,shortName=? where id=?";
	   
 System.out.println(query);
		try {
PreparedStatement pstmt = con.prepareStatement(query);
pstmt.setString(1, internshipCoordinator.getCode());
pstmt.setString(2, internshipCoordinator.getValue());
pstmt.setString(3, internshipCoordinator.getShortName());
pstmt.setInt(4, internshipCoordinator.getId());
	    int x = pstmt.executeUpdate();
	    }
	    catch (Exception e) {
	    	System.out.println(e);
		}
		
	}
	public String getValue(String code,String table) {
		
		String value="";
		String query="select value from "+table+" where code='"+code+"'";
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	
	    	value=rs.getString("value");
	    }
		}
		catch (Exception e) {
			System.out.println(e);
		}
	    return value;
	}
	
	public InternshipCoordinator getInternshipCoordinator(int id)
	{
		InternshipCoordinator internshipCoordinator =new InternshipCoordinator();
		String query="select * from Internship_coordinator where id="+id;
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    if(rs.next()) {
	    	
	
internshipCoordinator.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipCoordinator.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipCoordinator.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipCoordinator.setShortName(rs.getString("shortName")==null?"":rs.getString("shortName"));
	    	
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipCoordinator;
	}
	
	
	public ArrayList<InternshipCoordinator> getInternshipCoordinatorList()
	{
		ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
		String query="select * from Internship_coordinator";
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    while(rs.next()) {
	    	InternshipCoordinator internshipCoordinator =new InternshipCoordinator();
internshipCoordinator.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipCoordinator.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipCoordinator.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipCoordinator.setShortName(rs.getString("shortName")==null?"":rs.getString("shortName"));
	    	internshipCoordinatorList.add(internshipCoordinator);
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipCoordinatorList;
	}
	
	public ArrayList<InternshipCoordinator> getInternshipCoordinatorList(int pageNo,int limit)
	{
		ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
String query="select * from Internship_coordinator limit "+limit +" offset "+limit*(pageNo-1);
	    System.out.println(query);
		try {
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    while(rs.next()) {
	    	InternshipCoordinator internshipCoordinator =new InternshipCoordinator();
internshipCoordinator.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipCoordinator.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipCoordinator.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipCoordinator.setShortName(rs.getString("shortName")==null?"":rs.getString("shortName"));
	    	internshipCoordinatorList.add(internshipCoordinator);
	    }
		}
	    catch (Exception e) {
	    	System.out.println(e);
		}
	    
	    return internshipCoordinatorList;
	}
	
	public void deleteInternshipCoordinator(int id) {
		
			String query="delete from Internship_coordinator where id="+id;
		    System.out.println(query);
				
			
		    try {
			Statement stmt = con.createStatement();
		    int x = stmt.executeUpdate(query);
		    }
		    catch (Exception e) {
		    	System.out.println(e);
			}
		
	}
	
public String getDynamicQuery(InternshipCoordinator internshipCoordinator)
{
String query="select * from Internship_coordinator ";
String whereClause="";
whereClause+=(internshipCoordinator.getId()==0?"":" id="+internshipCoordinator.getId());
if(!whereClause.equals(""))
query+=" where "+whereClause;
System.out.println("Search Query= "+query);
    return query;
}
public String getDynamicQuery2(InternshipCoordinator internshipCoordinator)
{
String query="select count(*) from Internship_coordinator ";
String whereClause="";
whereClause+=(internshipCoordinator.getId()==0?"":" id="+internshipCoordinator.getId());
if(!whereClause.equals(""))
query+=" where "+whereClause;
System.out.println("Search Query= "+query);
    return query;
}
public ArrayList<InternshipCoordinator> getInternshipCoordinatorList(InternshipCoordinator internshipCoordinator)
{
ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
String query=getDynamicQuery(internshipCoordinator);
System.out.println("Search Query= "+query);
try {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
InternshipCoordinator internshipCoordinator2 =new InternshipCoordinator();
internshipCoordinator2.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipCoordinator2.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipCoordinator2.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipCoordinator2.setShortName(rs.getString("shortName")==null?"":rs.getString("shortName"));
    	internshipCoordinatorList.add(internshipCoordinator2);
    }
	}
    catch (Exception e) {
    	System.out.println(e);
	}
    return internshipCoordinatorList;
}
	
public ArrayList<InternshipCoordinator> getInternshipCoordinatorList(InternshipCoordinator internshipCoordinator,int pageNo,int limit)
{
ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
String query=getDynamicQuery(internshipCoordinator);
query+= " limit "+limit +" offset "+limit*(pageNo-1);
System.out.println("Search Query= "+query);
try {
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(query);
while(rs.next()) {
InternshipCoordinator internshipCoordinator2 =new InternshipCoordinator();
internshipCoordinator2.setId(rs.getInt("id")==0?0:rs.getInt("id"));
internshipCoordinator2.setCode(rs.getString("code")==null?"":rs.getString("code"));
internshipCoordinator2.setValue(rs.getString("value")==null?"":rs.getString("value"));
internshipCoordinator2.setShortName(rs.getString("shortName")==null?"":rs.getString("shortName"));
    	internshipCoordinatorList.add(internshipCoordinator2);
    }
	}
    catch (Exception e) {
    	System.out.println(e);
	}
    return internshipCoordinatorList;
}
	
	
	public static void main(String[] args) {
		
		InternshipCoordinatorDBService internshipCoordinatorDBService =new InternshipCoordinatorDBService();
		
		
		
		 //Test-1 : Create InternshipCoordinator
		  
		  InternshipCoordinator internshipCoordinator = new InternshipCoordinator(); internshipCoordinator.setDefaultValues();
		  internshipCoordinatorDBService.createInternshipCoordinator(internshipCoordinator);
		  
		 ArrayList<InternshipCoordinator> internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList();
		InternshipCoordinatorService internshipCoordinatorService =new InternshipCoordinatorService();
		internshipCoordinatorService.displayList(internshipCoordinatorList);
		
	}
}
