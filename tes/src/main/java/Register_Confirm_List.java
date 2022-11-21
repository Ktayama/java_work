

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Register_Confirm
 */
@WebServlet("/Register_Confirm_List")
public class Register_Confirm_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_Confirm_List() {
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
		
		
		//Questions_texパラメータを/Register_itemで取得したパラメータを受け取る
		///Register_itemの55,57行からとっている
		String param = request.getParameter("questions_text");
		//getParameterValuesと書いてあるのでanswer_textの中身は[]はいらない
		String[] param_an =request.getParameterValues("answer_text");
		//結果をコンソールに表示
		System.out.println(param);
		System.out.println(param_an);
		
		//パラメータの文字数チェック
		//ここでlengthを使う
		
		//param = new Scanner(System.in).nextLine();
		//4つの条件が揃ったらif文の中身が実行される
		
		//elseの条件は4つの条件が満たなければelseに実行される
		//一軒一軒fon文(param_an.length<=200)で取得する
		String error =null;
		//配列の要素数分ループ
		for (int i = 0; i < param_an.length; i++) 
		{
			//	=をつけないと200数字も含まれる
			// <が正しい
			//200超えていればエラーにはいる
			if(param_an[i].length()>200) {
				error="条件を超えています";
				
				
			}
		}
		//文字数が500文字以内かつ入力されているかつ文字が画面に存在する場合
		if ((param.length() <= 500) && (param!="" && param!=null))
		{
			//setAttributeでパラメータをセット
			request.setAttribute("Qusertions_text",param);
			
			request.setAttribute("Correct_anser_text[]",param_an);
			
			request.setAttribute("a_text",error);
			
			System.out.println("ok");
			//文字数okならregister_confirm.jspに飛ばす
			RequestDispatcher dispacher = request.getRequestDispatcher("./register_confirm.jsp");
			dispacher.forward(request, response);
			//エラー文字をjqpに表示させる
		} else {
			request.setAttribute("a_text",error);
			//文字数オーバーだったらngでRsgister.jspに戻す
			System.out.println("no");
			RequestDispatcher dispacher = request.getRequestDispatcher("./register_confirm.jsp");
			dispacher.forward(request, response);
		}
	}

}
