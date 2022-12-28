

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEditConfirmItem
 */
@WebServlet("/UserEditConfirmItem")
public class UserEditConfirmItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditConfirmItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		String prm_edit_confirm= request.getParameter("prm_edit_confirm");
		
		if(prm_edit_confirm.equals("更新")) 
		{
			
			
			String userName = request.getParameter("userName");
			request.setAttribute("UserName",userName);
			
			request.setAttribute("UserId",request.getParameter("userId"));
			
			request.setAttribute("UserPass",request.getParameter("userPass"));
			
			request.setAttribute("AdminFlag",request.getParameter("adminFlag"));
			
			System.out.println(request.getParameter("userName"));
			System.out.println(request.getParameter("userId"));
			System.out.println(request.getParameter("userPass"));
			System.out.println(request.getParameter("adminFlag"));
			
			request.getRequestDispatcher("./UserEdit").forward(request, response);
			return;
		}
		request.getRequestDispatcher("./UserConncetin.java").forward(request, response);
	}
}
