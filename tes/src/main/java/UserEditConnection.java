

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
		
		//usersList.jspで指定したパラメータをgetParameterでString user_idに格納
		String user_id = (String)request.getParameter("user_id");
		
		/*//user_idがnullだった場合
		if(user_id==null)
		{
			//UserEditConfirmItemで指定したパラメータをgetAttributeでuser_idに格納
			user_id = (String)request.getAttribute("user_id");
		}*/
		
		System.out.println(user_id);
		
		UsersDao usersDao;
		try {
			//UsersDaoをインスタンス化
			 usersDao = new UsersDao();
			 
			 //UsersBean型のBean変数を用意して、userDao変数のfindメソッドの引数をint型のuserIdに設定して、実行結果をBeanに格納
			 UsersBean bean = usersDao.find(Integer.parseInt(user_id));
			 
			 //JSPに渡す情報を設定する。第一引数にUsersBeanとする文字列、第二引数にBeanを設定する
			 request.setAttribute("UsersBean",bean);
			 
			 //userEdit.jspに遷移
			 request.getRequestDispatcher("./userEdit.jsp").forward(request, response);
			 
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
