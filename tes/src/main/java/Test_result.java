

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tes.Correct_answersBean;
import tes.Correct_answersDao;
import tes.HistoriesBean;
import tes.HistoriesDao;
import tes.UsersBean;
import tes.UsersDao;
/**
 * Servlet implementation class Test_result
 */
@WebServlet("/Test_result")
public class Test_result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test_result() {
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
		
		String[] question_id = request.getParameterValues("questions_id");
		String[] corrct_answer = request.getParameterValues("correct_answer");
		
		HttpSession session = request.getSession(false);
		String userId = (String) session.getAttribute("Login_id");
		//ログインしてなかった場合.ログイン時間が30分
		
		
		int userIdNum = Integer.parseInt(userId);
	try {
		HistoriesDao historiesdao =new HistoriesDao();
		HistoriesBean historiesBean = new HistoriesBean();
		Correct_answersDao codao = new Correct_answersDao();
		UsersDao usersdao = new UsersDao();
		
		long result =0;
		int Point =0;
		
		for(int i = 0; i < question_id.length; i++)
		{
			ArrayList<Correct_answersBean> list = codao.findByQuestionsId(Integer.parseInt(question_id[i]));
			for(int j = 0;j< list.size(); j++)
			{
				System.out.println(list.get(j).getAnswer());
				System.out.println(corrct_answer[i]); 
				if(list.get(j).getAnswer().equals(corrct_answer[i]))
				{
					Point++;
					break;
				}
				
			}
		}
		
		result = Math.round((100 * Point) / question_id.length);
		Date dateObj = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );
		String date = dateFormat.format(dateObj);
		
		UsersBean user = usersdao.find(userIdNum);
		
		
		historiesBean.setUserId(user.getId());
		
		historiesBean.setPoint((int)result);
		historiesdao.Insert(historiesBean); 
		
		
		request.setAttribute("GetName", user.getName());
		//問題数を画面に送るためlengthを使用
		request.setAttribute("Question_cnt", question_id.length);
		request.setAttribute("Point", Point);
		request.setAttribute("Result",(int)result);
		request.setAttribute("Date", date);
		
		
		request.getRequestDispatcher("./test_result.jsp").forward(request, response);
		
	} catch (Exception e1) {
		// TODO 自動生成された catch ブロック
		e1.printStackTrace();
	}
	}

}
