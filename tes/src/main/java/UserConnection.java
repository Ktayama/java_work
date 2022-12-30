


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.UsersBean;
import tes.UsersDao;

/**
 * Servlet implementation class UserConnection
 */
@WebServlet("/UserConnection")
public class UserConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserConnection() {
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
		
		
		try {
			//UsersDaoをインスタンス化
			UsersDao usersdao= new UsersDao();
		
			//ArrayList(配列)としてUsersBean型のlistを作り、そこにusersdaoオブジェクト(UsersDaoクラス)が持つfindAllメソッドを実行した戻り値を格納
			ArrayList<UsersBean> list = usersdao.findAll();
			
			//パラメーター名UsersListとしてUserの一覧を設定
			request.setAttribute("UsersList",list);
			//userLists.jspに移動
			request.getRequestDispatcher("./userLists.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}