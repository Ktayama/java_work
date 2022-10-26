

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Dlete_Confirm_item
 */
@WebServlet("/Delete_Confirm_item")
public class Delete_Confirm_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delete_Confirm_item() {
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
		
		String delete_prm_confirm = (String)request.getParameter("delete_prm_confirm");
		
		if(delete_prm_confirm.equals("削除")) {
			request.setAttribute("Delete_questions", request.getParameter("delete_questions"));
			request.setAttribute("Delete_answer", request.getParameterValues("delete_answers"));
			request.setAttribute("Delete_questions_id", request.getParameter("delete_questions_id"));
			request.setAttribute("Delete_answer_id", request.getParameterValues("delete_answers_id"));
			request.getRequestDispatcher("./Delete").forward(request, response);
			return;
		}
		System.out.println("no");
		//noだったらList.jspに移動する
		request.getRequestDispatcher("./List.jsp").forward(request, response);
	}
}

