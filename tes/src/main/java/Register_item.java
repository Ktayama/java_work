

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register_item
 */
@WebServlet("/Register_item")
public class Register_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_item() {
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
		
		//value=確認ボタンが押されたらのparemが実行される処理
		//registerConfirm.javaに移動
		
		request.setCharacterEncoding("UTF-8");
		
		//分岐
		//Register.jspでsubmitで指定したパラメータをgetParameterでString prmに代入している
		String prm = request.getParameter("prm");
		//Register register = new Register();
		//submitで指定の値が押された時
		if (prm.equals("確認"))
		{
			
			//getParameterでパラメータを持ってくる
			//Register.jspでinputに入力した値をgetParameterで取得してString question_textに代入している
			String questions_text= request.getParameter("questions_text");
			//Register.jspでinputに入力した値をgetParameterValuesで配列として取得する。それを、String[] answer_textに代入する
			//Steing[](文字配列型にしてる)型をjspにわたしてる
			String[] answers_text = request.getParameterValues("answer_text");
			
			
			
			//setパラメータでセットする
			request.setAttribute("Qusertions_text",questions_text);
			//
			request.setAttribute("Correct_anser_text[]",answers_text);
			
			//param = request.getParameter("questions_text");
			//param_an =request.getParameter("answer_text");
			//setパラメータでセットする
			//request.setAttribute("Qusertions_text",param);
			
			//request.setAttribute("Correct_anser_text",param_an);
			
			//確認ボタンが押されたらRegister_Confirm.javaに移動
			System.out.println("ok_next");
			request.getRequestDispatcher("./Register_Confirm_List").forward(request, response);
			return;		
		
		}else 
			//if(prm.equals("削除"))
		{
			//request.getParameter("questions_text");
			//request.getParameter("answer_text");
			//setパラメータでセットする
			//request.setAttribute("Qusertions_text",request.getParameter("questions_text"));
			//request.setAttribute("Correct_anser_text[]",request.getParameter("answer_text[]"));
			
			//System.out.println("delete");
			//request.getRequestDispatcher("./Delete_Confirm").forward(request, response);
		}
		//elseで追加処理
		//判定をjavaScriptファイルで作ってパラメータを追加処理の方に追加する
		
		//確認・追加・削除以外押されたら戻るボタンに入るように表示をnoにしている
		System.out.println("no");
		request.getRequestDispatcher("./List").forward(request, response);
	}

}
