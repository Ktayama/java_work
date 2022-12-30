

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
		
		//usersRegisterConfirm.jspでsubmitで指定したパラメータを各々指定して格納
		String userName = (String) request.getAttribute("UserName");
		String userPass = (String) request.getAttribute("UserPass");
		String adminFlag = (String) request.getAttribute("AdminFlag");
		System.out.println(adminFlag);
		//adminFlagが「あり」の場合
		if(adminFlag.equals("あり")) {
			//adminFlagを0と表示
			adminFlag ="1";
		}else {
			//adminFlagを1と表示
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
