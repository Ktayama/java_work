

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
		
		//userList.jspでhiddenで指定したパラメーターをgetParameterでString paramに格納
		String parem = request.getParameter("parem");
		
		//hiddenで指定の値が押された時equalsで文字列比較を行う
		if(parem.equals("1")) {
			//UsersRegisterの内容に出したい処理
			request.getRequestDispatcher("./UsersRegister.jsp").forward(request, response);
		}else if(parem.equals("2")) {
			//編集処理画面に移動[UserEditConncetionサーブレット]
			request.getRequestDispatcher("./UserEditConncetion").forward(request, response);
		}else if(parem.equals("3")) {
			//削除処理画面に移動[UserDeleteConnectionサーブレット]
			request.getRequestDispatcher("./UserDeleteConnection").forward(request, response);
		}
		
	}

}
