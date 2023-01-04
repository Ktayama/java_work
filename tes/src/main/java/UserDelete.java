

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.UsersDao;

/**
 * Servlet implementation class UserDelete
 */
@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDelete() {
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
		
		//userDeleteConfirm.jspでsubmit指定したパラメーターをgetParameterでuserIdに格納
		String UserId =  (String)request.getAttribute("UserId");
		
	try {
		
		//UsersDaoのインスタンス化
		UsersDao userDao = new UsersDao();
		
		//UserIdがnullの場合
		if(UserId != null) {
		//usersDaoのDeleteserUpdataメソットを呼び出して、int型のidををセットさせる
		userDao.DeleteserUpdata(Integer.parseInt(UserId));
		}
		//UserConnectionに遷移
		RequestDispatcher dispacher = request.getRequestDispatcher("./UserConnection");
		dispacher.forward(request, response);
		
	} catch (Exception e1) {
	// TODO 自動生成された catch ブロック
	e1.printStackTrace();
	}
	}

}
