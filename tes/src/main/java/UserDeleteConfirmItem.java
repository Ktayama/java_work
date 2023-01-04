

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserDeleteConfirmItem
 */
@WebServlet("/UserDeleteConfirmItem")
public class UserDeleteConfirmItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDeleteConfirmItem() {
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
		
		
		//userDeleteConfirm.jspで指定したidのパラメーターをgetParameterでuserIdに格納
		String userId = (String)request.getParameter("userId");
		
		//パラメーターをuserIdに設定する
		request.setAttribute("UserId", userId);
	
		
		//UserDeleteに移動
		request.getRequestDispatcher("./UserDelete").forward(request, response);
		return;
	
	}

}
