

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEditItem
 */
@WebServlet("/UserEditItem")
public class UserEditItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditItem() {
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
		
		String userId = (String)request.getParameter("userId");
		String userName = (String)request.getParameter("userName");
		String userPass = (String)request.getParameter("userPass");
		String userPassCheck = (String)request.getParameter("userPassCheck");
		String adminFlag =(String)request.getParameter("admin_flag");
		if (adminFlag == null) {
		    adminFlag = "0";
		}else {
			 adminFlag = "1";
		}
		byte adminFlagByte = Byte.parseByte(adminFlag);
		
		request.setAttribute("UserId", (userId));
		request.setAttribute("UserName", userName);
		request.setAttribute("UserPass", userPass);
		request.setAttribute("UserPassCheck", userPassCheck);
		request.setAttribute("AdminFlagByte", adminFlagByte);
		
		request.getRequestDispatcher("./userEditConfirm.jsp").forward(request, response);
	
	}

}