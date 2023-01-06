

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.Correct_answersDao;
import tes.QuestionsDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		request.setCharacterEncoding("UTF-8");
		
		String delete_prm_confirm = (String)request.getParameter("delete_prm_confirm");
		
		if(delete_prm_confirm.equals("削除")) {
			
			
		
		String[] delete_answers =  (String[])request.getParameterValues("delete_answers");
		String[] delete_answers_id =  (String[])request.getParameterValues("delete_answers_id");
		String delete_questions =  (String)request.getParameter("delete_questions");
		String delete_questions_id =  (String)request.getParameter("delete_questions_id");
		
	try {
		
		QuestionsDao dao = new QuestionsDao();
		Correct_answersDao dao_an = new Correct_answersDao();
		
		dao.DELETE(Integer.parseInt(delete_questions_id));
		for(int i=0; i < delete_answers_id.length; i++)
		{
			dao_an.DELETE(Integer.parseInt(delete_answers_id[i]));
		}
		
		RequestDispatcher dispacher = request.getRequestDispatcher("./List_Connection");
		dispacher.forward(request, response);
		
	} catch (Exception e1) {
	// TODO 自動生成された catch ブロック
	e1.printStackTrace();
}
	}
	}

}
