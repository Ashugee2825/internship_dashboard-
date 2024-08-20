package internshipRegd;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class InternshipRegdCntrl
 */
@WebServlet("/internship/internshipRegd/internshipRegdCntrl")
public class InternshipRegdCntrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InternshipRegdCntrl() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page= request.getParameter("page");
		String opr = request.getParameter("opr");
		int pageNo = (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("pageNo")));
		int limit= (null==request.getParameter("pageNo")?0:Integer.parseInt(request.getParameter("limit")));
		
		RequestDispatcher rd;
		InternshipRegdDBService internshipRegdDBService =new InternshipRegdDBService();
		InternshipRegd internshipRegd =new InternshipRegd();
		//Action for close buttons
		String homeURL=(null==request.getSession().getAttribute("homeURL")?"":(String)request.getSession().getAttribute("homeURL"));		
		if(page.equals("internshipRegdDashboard"))
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipRegdCntrl?page="+page+"&opr=showAll&pageNo="+pageNo+"&limit="+limit;
			request.getSession().setAttribute("homeURL",homeURL);
			
			if(opr.equals("showAll")) 
			{
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList();
				else { //pagination
					int totalPages= internshipRegdDBService.getTotalPages(limit);
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("internshipRegdDashboard.jsp");
				rd.forward(request, response);
			} 
			else if(opr.equals("addNew")) //CREATE
			{
				internshipRegd.setDefaultValues();
				internshipRegd.displayValues();
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("addNewInternshipRegd.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("edit")) //UPDATE
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("updateInternshipRegd.jsp");
				rd.forward(request, response);
			}
			//Begin: modified by Dr PNH on 06-12-2022
			else if(opr.equals("editNext")) //Save and Next
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("updateNextInternshipRegd.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("saveShowNext")) //Save, show & next
			{
				internshipRegd.setDefaultValues();
				internshipRegd.displayValues();
				request.setAttribute("internshipRegd",internshipRegd);
				
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList();
				else { //pagination
					int totalPages= internshipRegdDBService.getTotalPages(limit);
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("saveShowNextInternshipRegd.jsp");
				rd.forward(request, response);
			}
			//End: modified by Dr PNH on 06-12-2022
			else if(opr.equals("delete")) //DELETE
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd.setId(id);
				internshipRegdDBService.deleteInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("deleteInternshipRegdSuccess.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("view")) //READ
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("viewInternshipRegd.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(page.equals("addNewInternshipRegd")) 
		{
			if(opr.equals("save"))
			{
				internshipRegd.setRequestParam(request);
				internshipRegd.displayValues();
				internshipRegdDBService.createInternshipRegd(internshipRegd);
				request.setAttribute("internshipRegd",internshipRegd);
				if(pageNo!=0) {//pagination
					int totalPages= internshipRegdDBService.getTotalPages(limit);
					homeURL="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo="+totalPages+"&limit="+limit;
					request.getSession().setAttribute("homeURL", homeURL);
				}
				rd = request.getRequestDispatcher("addNewInternshipRegdSuccess.jsp");
				rd.forward(request, response);
			}
		}
		//Begin: modified by Dr PNH on 06-12-2022
		else if(page.equals("updateNextInternshipRegd")) 
		{
			if(opr.equals("update"))
			{
				internshipRegd.setRequestParam(request);
				internshipRegdDBService.updateInternshipRegd(internshipRegd);
				request.setAttribute("internshipRegd",internshipRegd);
				request.getSession().setAttribute("msg", "Record saved successfully");
				response.sendRedirect("internshipRegdCntrl?page=internshipRegdDashboard&opr=editNext&pageNo=0&limit=0&id=10");			}
		}
		else if(page.equals("saveShowNextInternshipRegd")) 
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipRegdCntrl?page=internshipRegdDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0";
			request.getSession().setAttribute("homeURL",homeURL);
			if(opr.equals("addNew")) //save new record
			{
				internshipRegd.setRequestParam(request);
				internshipRegd.displayValues();
				internshipRegdDBService.createInternshipRegd(internshipRegd);
				request.setAttribute("internshipRegd",internshipRegd);
				if(pageNo!=0) {//pagination
					int totalPages= internshipRegdDBService.getTotalPages(limit);
					homeURL="internshipRegdCntrl?page=internshipRegdDashboard&opr=showAll&pageNo="+totalPages+"&limit="+limit;
					request.getSession().setAttribute("homeURL", homeURL);
				}
				request.getSession().setAttribute("msg", "Record saved successfully");
				response.sendRedirect("internshipRegdCntrl?page=internshipRegdDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
				//rd = request.getRequestDispatcher("internshipRegdCntrl?page=internshipRegdDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
				//rd.forward(request, response);
			}
			else if(opr.equals("edit"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList();
				else { //pagination
					int totalPages= internshipRegdDBService.getTotalPages(limit);
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("saveShowNextInternshipRegd.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("update"))
			{
				internshipRegd.setRequestParam(request);
				internshipRegdDBService.updateInternshipRegd(internshipRegd);
				request.setAttribute("internshipRegd",internshipRegd);
				request.getSession().setAttribute("msg", "Record updated successfully");
				response.sendRedirect("internshipRegdCntrl?page=internshipRegdDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
			}
			else if(opr.equals("delete"))
			{
					int id = Integer.parseInt(request.getParameter("id"));
					internshipRegd.setId(id);
					internshipRegdDBService.deleteInternshipRegd(id);
					request.setAttribute("internshipRegd",internshipRegd);
					request.getSession().setAttribute("msg", "Record deleted successfully");
					response.sendRedirect("internshipRegdCntrl?page=internshipRegdDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");		
			}
			else if(opr.equals("reset")||opr.equals("cancel"))
			{
					response.sendRedirect("internshipRegdCntrl?page=internshipRegdDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");		
			}
			
		}
		//End: modified by Dr PNH on 06-12-2022
		else if(page.equals("updateInternshipRegd")) 
		{
			if(opr.equals("update"))
			{
				internshipRegd.setRequestParam(request);
				internshipRegdDBService.updateInternshipRegd(internshipRegd);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("updateInternshipRegdSuccess.jsp");
				rd.forward(request, response);
			}
		}
		else if(page.equals("viewInternshipRegd")) 
		{
			if(opr.equals("print")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("printInternshipRegd.jsp");
				rd.forward(request, response);
			}
		}
		else if(page.equals("searchInternshipRegd"))
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipRegdCntrl?page="+page+"&opr=showAll&pageNo="+pageNo+"&limit="+limit;
			request.getSession().setAttribute("homeURL",homeURL);
			if(opr.equals("search")) 
			{
				internshipRegd.setRequestParam(request);
				internshipRegd.displayValues();
				request.getSession().setAttribute("internshipRegdSearch",internshipRegd);
				request.setAttribute("opr","search");
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd);
				else { //pagination
					int totalPages=0;
					if(limit==0)
					totalPages=0;
					else
					totalPages=internshipRegdDBService.getTotalPages(internshipRegd,limit);
					pageNo=1;
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("searchInternshipRegd.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
//begin:code for download/print button
			else if(opr.equals("downloadPrint")) 
			{
				internshipRegd.setRequestParam(request);
				internshipRegd.displayValues();
				request.getSession().setAttribute("internshipRegdSearch",internshipRegd);
				request.setAttribute("opr","internshipRegd");
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd);
				else { //pagination
					int totalPages=0;
					if(limit==0)
					totalPages=0;
					else
					totalPages=internshipRegdDBService.getTotalPages(internshipRegd,limit);
					pageNo=1;
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("searchInternshipRegdDownloadPrint.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			//end:code for download/print button
			
			else if(opr.equals("showAll")) 
			{
				internshipRegd=(InternshipRegd)request.getSession().getAttribute("internshipRegdSearch");
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd);
				else { //pagination
					int totalPages= internshipRegdDBService.getTotalPages(internshipRegd,limit);
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("searchInternshipRegd.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("searchNext")||opr.equals("searchPrev")||opr.equals("searchFirst")||opr.equals("searchLast")) 
			{
				request.setAttribute("opr","search");
				internshipRegd=(InternshipRegd)request.getSession().getAttribute("internshipRegdSearch");
				ArrayList<InternshipRegd> internshipRegdList =new ArrayList<InternshipRegd>();
				if(pageNo==0)
				internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd);
				else { //pagination
					int totalPages= internshipRegdDBService.getTotalPages(internshipRegd,limit);
					internshipRegdList = internshipRegdDBService.getInternshipRegdList(internshipRegd,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipRegdList",internshipRegdList);
				rd = request.getRequestDispatcher("searchInternshipRegd.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("showNone"))
			{
				internshipRegd.setDefaultValues();
				internshipRegd.displayValues();
				request.getSession().setAttribute("internshipRegdSearch",internshipRegd);
				request.setAttribute("opr","showNone");
				rd = request.getRequestDispatcher("searchInternshipRegd.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("edit")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("updateInternshipRegd.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("delete")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd.setId(id);
				internshipRegdDBService.deleteInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("deleteInternshipRegdSuccess.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("view")) 
			{
 			int id = Integer.parseInt(request.getParameter("id"));
				internshipRegd = internshipRegdDBService.getInternshipRegd(id);
				request.setAttribute("internshipRegd",internshipRegd);
				rd = request.getRequestDispatcher("viewInternshipRegd.jsp");
				rd.forward(request, response);
			}
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public static void main(String[] args) throws URISyntaxException {
		URI uri = new URI("page=updateInternshipRegd&opr=close&homePage=internshipRegdDashboard");
		String v = uri.getQuery();
		
	}
}
