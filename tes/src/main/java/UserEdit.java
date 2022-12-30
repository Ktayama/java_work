

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.UsersDao;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/UserEdit")
public class UserEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEdit() {
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
		
		String userId = (String)request.getAttribute("UserId");
		String userName = (String) request.getAttribute("UserName");
		String userPass = (String) request.getAttribute("UserPass");
		String adminFlag = (String) request.getAttribute("AdminFlag");
		System.out.println(adminFlag);
		if(adminFlag.equals("あり")) {
			adminFlag ="1";
		}else {
			adminFlag ="0";
		}
		byte adminFlagByte = Byte.parseByte(adminFlag);
		
		System.out.println(userName);
		System.out.println(userPass);
		System.out.println(adminFlagByte);
		
			try {
			UsersDao usersDao = new UsersDao();
			
			usersDao.UPDATAD(userPass,adminFlagByte,Integer.parseInt(userId));
			
			} catch (Exception e1) {
			
				e1.printStackTrace();
			}
	try {
		
		RequestDispatcher  dispacher = request.getRequestDispatcher("./UserConnection");
		dispacher.forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
