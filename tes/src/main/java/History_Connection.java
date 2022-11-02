

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tes.HistoriesBean;
import tes.HistoriesDao;
import tes.UsersBean;
import tes.UsersDao;

/**
 * Servlet implementation class History_Connection
 */
@WebServlet("/History_Connection")
public class History_Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public History_Connection() {
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
		HistoriesDao historiesDao;
		try {
			
			historiesDao = new HistoriesDao();
			
			HttpSession session = request.getSession(false);
			String userId = (String) session.getAttribute("Login_id");
			
			
			int userIdNum = Integer.parseInt(userId);
			ArrayList<HistoriesBean> list = historiesDao.findAll();
			UsersDao usersdao = new UsersDao();
			
			
			UsersBean user = usersdao.find(userIdNum);
			HistoriesBean historiesBean = new HistoriesBean();
			
			historiesBean.setUserId(user.getId());
			
			request.setAttribute("GetName", user.getName());
			request.setAttribute("Qusertions_list",list);
			
			request.getRequestDispatcher("./history.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}

}
