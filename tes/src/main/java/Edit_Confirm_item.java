

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit_Confirm_List_item
 */
@WebServlet("/Edit_Confirm_List_item")
public class Edit_Confirm_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_Confirm_item() {
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
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		String prm_edit_confirm = request.getParameter("prm_edit_confirm");
		if(prm_edit_confirm.equals("更新")) {
			
					
			//answerの答えとidのパラメータを受け取る
			String[] prm_answer =request.getParameterValues("edit_answer");
			String[] prm_answer_id =request.getParameterValues("edit_answer_id");
			
			//questionsの問題文とidパラメータをセットさせる
			//questionsの問題文とidのパラメータを受け取る	
			request.setAttribute("Edit_questions",request.getParameter("edit_questions"));
			request.setAttribute("Edit_questions_id",request.getParameter("edit_questions_id"));
			//answerの答えとidをパラメータをセットさせる
			request.setAttribute("Edit_answer",prm_answer);
			request.setAttribute("Edit_answer_id",prm_answer_id);
			//okならRegister.javaに移動
			System.out.println("ok");
			request.getRequestDispatcher("./Register").forward(request, response);
		}else {
			//noならEditに移動
			System.out.println("no");
			request.getRequestDispatcher("./Edit.jsp").forward(request, response);
		}
		
	}

}
