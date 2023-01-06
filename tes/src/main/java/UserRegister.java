

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.UsersDao;

/**
 * Servlet implementation class UserRegister
 */
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegister() {
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
			//usersRegisterConfirm.jspでsubmitで指定したパラメータを各々指定して格納
			String userName = (String) request.getParameter("userName");
			String userPass = (String) request.getParameter("userPass");
			String adminFlag = (String) request.getParameter("adminFlag");
			System.out.println(adminFlag);
			
			//adminFlagが「あり」の場合
			if(adminFlag.equals("あり")) {
			//adminFlagに１の文字列を設定
				adminFlag ="1";
			}else {
			//adminFlagに0の文字列を設定
			adminFlag ="0";
			}
			//byte型のadminFlagByte変数を用意して、byte型に変換したadminFlag設定してadminFlagByteに格納
			byte adminFlagByte = Byte.parseByte(adminFlag);
			
			System.out.println(userName);
			System.out.println(userPass);
			System.out.println(adminFlagByte);
			
			try {
				//UsersDaoのインスタンス化
				UsersDao usersDao = new UsersDao();
			
				//usersDaoのInsertメソットを呼び出して、userPass, userName, adminFlagByteをセットさせる
				usersDao.Insert(userPass, userName, adminFlagByte);
			
				} catch (Exception e1) {
			
				e1.printStackTrace();
			}
			try {
				//UserConnectionに遷移
				RequestDispatcher  dispacher = request.getRequestDispatcher("./UserConnection");
				dispacher.forward(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
