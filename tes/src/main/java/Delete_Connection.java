

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.Correct_answersBean;
import tes.Correct_answersDao;
import tes.QuestionsBean;
import tes.QuestionsDao;

/**
 * Servlet implementation class Delete_item
 */
@WebServlet("/Delete_Connection")
public class Delete_Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Connection() {
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
		
		String questions_id = (String)request.getAttribute("Questions_id");
		
		QuestionsDao Dao;
		
		try {
			Dao =new QuestionsDao();
			
			QuestionsBean Bean = Dao.find(Integer.parseInt(questions_id));
			
			Correct_answersDao correct_anDao = new Correct_answersDao();
			
			ArrayList<Correct_answersBean> list_answer = correct_anDao.findByQuestionsId(Integer.parseInt(questions_id));
			
			request.setAttribute("Questions_list", Bean);
			request.setAttribute("Answers_list",list_answer);
			
			//Edit.jspに移動
			request.getRequestDispatcher("./Delete_Confirm.jsp").forward(request, response);
			
			
		}catch(Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
