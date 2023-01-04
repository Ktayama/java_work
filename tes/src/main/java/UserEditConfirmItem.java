

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserEditConfirmItem
 */
@WebServlet("/UserEditConfirmItem")
public class UserEditConfirmItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditConfirmItem() {
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
		
		//userEditConfirm.jspでhiddenで指定したパラメーターをgetParameterでprm_edit_confirmに格納
		String prm_edit_confirm= request.getParameter("prm_edit_confirm");
		
		//equalsで更新の文字列比較を行う
		if(prm_edit_confirm.equals("更新")) 
		{
			
			//各々パラメータをセットさせる
			request.setAttribute("UserName",request.getParameter("userName"));
			request.setAttribute("UserId",request.getParameter("userId"));
			request.setAttribute("UserPass",request.getParameter("userPass"));
			request.setAttribute("AdminFlag",request.getParameter("adminFlag"));
			
			//UserEditに移動
			request.getRequestDispatcher("./UserEdit").forward(request, response);
			
		//equalsで更新の文字列比較を行う
		}else if(prm_edit_confirm.equals("戻る")) {
		
		
		//パラメータをuser_idに設定させる
		request.setAttribute("user_id",request.getParameter("userId"));
		System.out.println(request.getParameter("user_id"));
		
		//UserConnectionに戻る処理
		request.getRequestDispatcher("./UserEditConncetion").forward(request, response);
		}
	}
}
