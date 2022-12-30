

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.UsersBean;
import tes.UsersDao;

/**
 * Servlet implementation class UserEditConncetion
 */
@WebServlet("/UserEditConncetion")
public class UserEditConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditConnection() {
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
		String user_id = (String)request.getParameter("user_id");
		
		UsersDao usersDao;
		try {
			//QuestionsDaoに入ってるのが使える
			 usersDao = new UsersDao();
			 
			 UsersBean bean = usersDao.find(Integer.parseInt(user_id));
			 
			 request.setAttribute("UsersBean",bean);
			 
			 request.getRequestDispatcher("./userEdit.jsp").forward(request, response);
			 
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
