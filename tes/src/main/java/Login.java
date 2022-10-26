

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.DAOException;
import tes.UsersBean;
import tes.UsersDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//パラメータを受け取る
		// ユーザーから送信されたユーザーIDとパスワードを取得する。
		
		//login.jspでinputに入力した値をgetParameterで取得してString userIdに代入している
		String userId = request.getParameter("user_id");
		//login.jspでinputに入力した値をgetParameterで取得してString passwordに代入している
		String password = request.getParameter("password");
		//実行結果で入力した値がコンソールに表示される
		System.out.println(userId);
		System.out.println(password);
		//try-catchでは実行中にtryの内で例外（エラー）が発生したときはとはcatchの中に行く
		try {
		//UsersDao型のオブジェクト、「dao」変数を用意
		UsersDao dao = new UsersDao();

		//UsersBean型のbeanを作った
		UsersBean bean;
		    //サーブレットからdaoにidとpsを渡す
		    //daoオブジェクト(UsersDaoクラス)が持つfindメソッドを実行した戻り値を格納
			bean =  dao.find(Integer.parseInt(userId));
			// 取得できたレコードの件数をコンソールに出力して確認
			System.out.println(bean.getPassword());
			System.out.println(bean.getId());
			System.out.println(bean.getName());
			//データベースにidが存在していない場合
			//if(bean.getId()==0) {
				//idがMysqlに存在していない
				//間違えているからloginjspにもどす
				//RequestDispatcher dispacher = request.getRequestDispatcher("./login.jsp");
				//dispacher.forward(request, response);
				//return;
			//
			//}
			//入力値のidとパスワードをusersのデータベースの値と一致しているか判定
		    if((Integer.parseInt(userId))==bean.getId()&&password.equals(bean.getPassword()))
			{
				//一致した場合はtopjspに行く
			    //idとpassが一致した場合
				RequestDispatcher dispacher = request.getRequestDispatcher("./top.jsp");
				dispacher.forward(request, response);
				return;
			}else {
				//idとpassが一致しない
				RequestDispatcher dispacher = request.getRequestDispatcher("./login.jsp");
				dispacher.forward(request, response);
				return;
			}
		} catch (DAOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
         
		 
	}

}