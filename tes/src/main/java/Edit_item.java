

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit_Confirm_item
 */
@WebServlet("/Edit_item")
public class Edit_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_item() {
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
		//分岐
		//すでにパラメータの中身は入力されている状態だからgetParameterは定義しなくてもよい
		//getParameterでパラメータを持ってくる
		//request.getParameter("questions_text");
		//reques[] answer_text = request.getParameterValues("answer_text");
		
		//Edit.jspでhiddenで指定したパラメーターをgetParameterでStringedit_prm_confirm に代入している
		String edit_prm_confirm = request.getParameter("edit_prm_confirm");
		////submitで指定の値が押された時
		if(edit_prm_confirm.equals("確認")) {
			
			////Register.jspでinputに入力した値をgetParameterで取得してString question_textに代入している
			//Edit.jspでinputに入力した値をgetParameterValuesで配列型に取得してString[] answerに代入している
			String[] answer = request.getParameterValues("answer_text");
			//Edit.jspでinputに入力した値をgetParameterValuesで配列型に取得してString[] answer_idに代入している
			String[] answer_id = request.getParameterValues("answer_id");
			
			//setAttributeでパラメータをセットする
			request.setAttribute("Questions",request.getParameter("questions_text"));
			request.setAttribute("Answer[]",answer);
			request.setAttribute("Questions_id",request.getParameter("questions_id"));
			request.setAttribute("Answer_id[]",answer_id);
			
			//okだったらEdit_Listに移動する
			request.getRequestDispatcher("./Edit_List").forward(request, response);
			return;
		}
		
		//noだったらList.jspに移動する
		request.getRequestDispatcher("./List_Connection").forward(request, response);
	}

}
