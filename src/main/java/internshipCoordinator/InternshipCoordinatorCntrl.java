package internshipCoordinator;
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
 * Servlet implementation class InternshipCoordinatorCntrl
 */
@WebServlet("/intership/internshipCoordinator/internshipCoordinatorCntrl")
public class InternshipCoordinatorCntrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InternshipCoordinatorCntrl() {
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
		InternshipCoordinatorDBService internshipCoordinatorDBService =new InternshipCoordinatorDBService();
		InternshipCoordinator internshipCoordinator =new InternshipCoordinator();
		//Action for close buttons
		String homeURL=(null==request.getSession().getAttribute("homeURL")?"":(String)request.getSession().getAttribute("homeURL"));		
		if(page.equals("internshipCoordinatorDashboard"))
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipCoordinatorCntrl?page="+page+"&opr=showAll&pageNo="+pageNo+"&limit="+limit;
			request.getSession().setAttribute("homeURL",homeURL);
			
			if(opr.equals("showAll")) 
			{
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList();
				else { //pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(limit);
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("internshipCoordinatorDashboard.jsp");
				rd.forward(request, response);
			} 
			else if(opr.equals("addNew")) //CREATE
			{
				internshipCoordinator.setDefaultValues();
				internshipCoordinator.displayValues();
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("addNewInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("edit")) //UPDATE
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("updateInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			//Begin: modified by Dr PNH on 06-12-2022
			else if(opr.equals("editNext")) //Save and Next
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("updateNextInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("saveShowNext")) //Save, show & next
			{
				internshipCoordinator.setDefaultValues();
				internshipCoordinator.displayValues();
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList();
				else { //pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(limit);
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("saveShowNextInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			//End: modified by Dr PNH on 06-12-2022
			else if(opr.equals("delete")) //DELETE
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator.setId(id);
				internshipCoordinatorDBService.deleteInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("deleteInternshipCoordinatorSuccess.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("view")) //READ
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("viewInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			
		}
		else if(page.equals("addNewInternshipCoordinator")) 
		{
			if(opr.equals("save"))
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinator.displayValues();
				internshipCoordinatorDBService.createInternshipCoordinator(internshipCoordinator);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				if(pageNo!=0) {//pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(limit);
					homeURL="internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=showAll&pageNo="+totalPages+"&limit="+limit;
					request.getSession().setAttribute("homeURL", homeURL);
				}
				rd = request.getRequestDispatcher("addNewInternshipCoordinatorSuccess.jsp");
				rd.forward(request, response);
			}
		}
		//Begin: modified by Dr PNH on 06-12-2022
		else if(page.equals("updateNextInternshipCoordinator")) 
		{
			if(opr.equals("update"))
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinatorDBService.updateInternshipCoordinator(internshipCoordinator);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				request.getSession().setAttribute("msg", "Record saved successfully");
				response.sendRedirect("internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=editNext&pageNo=0&limit=0&id=10");			}
		}
		else if(page.equals("saveShowNextInternshipCoordinator")) 
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0";
			request.getSession().setAttribute("homeURL",homeURL);
			if(opr.equals("addNew")) //save new record
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinator.displayValues();
				internshipCoordinatorDBService.createInternshipCoordinator(internshipCoordinator);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				if(pageNo!=0) {//pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(limit);
					homeURL="internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=showAll&pageNo="+totalPages+"&limit="+limit;
					request.getSession().setAttribute("homeURL", homeURL);
				}
				request.getSession().setAttribute("msg", "Record saved successfully");
				response.sendRedirect("internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
				//rd = request.getRequestDispatcher("internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
				//rd.forward(request, response);
			}
			else if(opr.equals("edit"))
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList();
				else { //pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(limit);
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("saveShowNextInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("update"))
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinatorDBService.updateInternshipCoordinator(internshipCoordinator);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				request.getSession().setAttribute("msg", "Record updated successfully");
				response.sendRedirect("internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");
			}
			else if(opr.equals("delete"))
			{
					int id = Integer.parseInt(request.getParameter("id"));
					internshipCoordinator.setId(id);
					internshipCoordinatorDBService.deleteInternshipCoordinator(id);
					request.setAttribute("internshipCoordinator",internshipCoordinator);
					request.getSession().setAttribute("msg", "Record deleted successfully");
					response.sendRedirect("internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");		
			}
			else if(opr.equals("reset")||opr.equals("cancel"))
			{
					response.sendRedirect("internshipCoordinatorCntrl?page=internshipCoordinatorDashboard&opr=saveShowNext&id=10&pageNo=0&limit=0");		
			}
			
		}
		//End: modified by Dr PNH on 06-12-2022
		else if(page.equals("updateInternshipCoordinator")) 
		{
			if(opr.equals("update"))
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinatorDBService.updateInternshipCoordinator(internshipCoordinator);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("updateInternshipCoordinatorSuccess.jsp");
				rd.forward(request, response);
			}
		}
		else if(page.equals("viewInternshipCoordinator")) 
		{
			if(opr.equals("print")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("printInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
		}
		else if(page.equals("searchInternshipCoordinator"))
		{
			request.getSession().setAttribute("homePage",page);
			homeURL="internshipCoordinatorCntrl?page="+page+"&opr=showAll&pageNo="+pageNo+"&limit="+limit;
			request.getSession().setAttribute("homeURL",homeURL);
			if(opr.equals("search")) 
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinator.displayValues();
				request.getSession().setAttribute("internshipCoordinatorSearch",internshipCoordinator);
				request.setAttribute("opr","search");
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator);
				else { //pagination
					int totalPages=0;
					if(limit==0)
					totalPages=0;
					else
					totalPages=internshipCoordinatorDBService.getTotalPages(internshipCoordinator,limit);
					pageNo=1;
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("searchInternshipCoordinator.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
//begin:code for download/print button
			else if(opr.equals("downloadPrint")) 
			{
				internshipCoordinator.setRequestParam(request);
				internshipCoordinator.displayValues();
				request.getSession().setAttribute("internshipCoordinatorSearch",internshipCoordinator);
				request.setAttribute("opr","internshipCoordinator");
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator);
				else { //pagination
					int totalPages=0;
					if(limit==0)
					totalPages=0;
					else
					totalPages=internshipCoordinatorDBService.getTotalPages(internshipCoordinator,limit);
					pageNo=1;
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("searchInternshipCoordinatorDownloadPrint.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			//end:code for download/print button
			
			else if(opr.equals("showAll")) 
			{
				internshipCoordinator=(InternshipCoordinator)request.getSession().getAttribute("internshipCoordinatorSearch");
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator);
				else { //pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(internshipCoordinator,limit);
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("searchInternshipCoordinator.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("searchNext")||opr.equals("searchPrev")||opr.equals("searchFirst")||opr.equals("searchLast")) 
			{
				request.setAttribute("opr","search");
				internshipCoordinator=(InternshipCoordinator)request.getSession().getAttribute("internshipCoordinatorSearch");
				ArrayList<InternshipCoordinator> internshipCoordinatorList =new ArrayList<InternshipCoordinator>();
				if(pageNo==0)
				internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator);
				else { //pagination
					int totalPages= internshipCoordinatorDBService.getTotalPages(internshipCoordinator,limit);
					internshipCoordinatorList = internshipCoordinatorDBService.getInternshipCoordinatorList(internshipCoordinator,pageNo,limit);
					request.setAttribute("totalPages",totalPages);
				}
				request.setAttribute("internshipCoordinatorList",internshipCoordinatorList);
				rd = request.getRequestDispatcher("searchInternshipCoordinator.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("showNone"))
			{
				internshipCoordinator.setDefaultValues();
				internshipCoordinator.displayValues();
				request.getSession().setAttribute("internshipCoordinatorSearch",internshipCoordinator);
				request.setAttribute("opr","showNone");
				rd = request.getRequestDispatcher("searchInternshipCoordinator.jsp?pageNo="+pageNo+"&limit="+limit);
				rd.forward(request, response);
			}
			else if(opr.equals("edit")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("updateInternshipCoordinator.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("delete")) 
			{
				int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator.setId(id);
				internshipCoordinatorDBService.deleteInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("deleteInternshipCoordinatorSuccess.jsp");
				rd.forward(request, response);
			}
			else if(opr.equals("view")) 
			{
 			int id = Integer.parseInt(request.getParameter("id"));
				internshipCoordinator = internshipCoordinatorDBService.getInternshipCoordinator(id);
				request.setAttribute("internshipCoordinator",internshipCoordinator);
				rd = request.getRequestDispatcher("viewInternshipCoordinator.jsp");
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
		URI uri = new URI("page=updateInternshipCoordinator&opr=close&homePage=internshipCoordinatorDashboard");
		String v = uri.getQuery();
		
	}
}
