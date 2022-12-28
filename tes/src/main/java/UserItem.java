

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserItem
 */
@WebServlet("/UserItem")
public class UserItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserItem() {
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
		String parem = request.getParameter("parem");
		
		if(parem.equals("1")) {
			request.getRequestDispatcher("./UsersRegister.jsp").forward(request, response);
		}else if(parem.equals("2")) {
			request.getRequestDispatcher("./UserEditConncetion").forward(request, response);
		}else if(parem.equals("3")) {
			request.getRequestDispatcher("./UserDeleteConnection").forward(request, response);
		}
		
	}

}
