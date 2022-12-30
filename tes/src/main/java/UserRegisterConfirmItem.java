

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserRegisterConfirmItem
 */
@WebServlet("/UserRegisterConfirmItem")
public class UserRegisterConfirmItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterConfirmItem() {
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
	
	//userRegisterConfirm.jspでhiddenで指定したパラメーターをgetParameterでprm_confirmに格納
	String prm_confirm= request.getParameter("prm_confirm");
	
	//equalsで登録の文字列比較を行う
	if(prm_confirm.equals("登録")) 
	{
		//userRegisterConfirm.jspでinputに入力された値をgetParameterとして取得する。それを、userNameに格納
		String userName = request.getParameter("userName");
		
		//各々パラメータをセットさせる
		request.setAttribute("UserName",userName);
		request.setAttribute("UserPass",request.getParameter("userPass"));
		request.setAttribute("AdminFlag",request.getParameter("adminFlag"));
		
		System.out.println(request.getParameter("userName"));
		System.out.println(request.getParameter("userPass"));
		System.out.println(request.getParameter("adminFlag"));
		
		//UserRegisterに移動
		request.getRequestDispatcher("./UserRegister").forward(request, response);
		return;
	}
	//UserConnectionに戻る処理
	request.getRequestDispatcher("./UserConnection").forward(request, response);
	}

}

