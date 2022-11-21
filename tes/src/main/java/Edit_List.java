

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edit_Confirm_List
 */
@WebServlet("/Edit_List")
public class Edit_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_List() {
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
		
		
		//Edit.jspで定義したパラメータを受け取っている
		String param = (String)request.getAttribute("Questions");
		String[] param_an =(String[])request.getAttribute("Answer[]");
		String param_questions_id =(String)request.getAttribute("Questions_id");
		String[] param_anwer_id =(String[])request.getAttribute("Answer_id[]");
		//コンソールに問題文と答えを表示している
		System.out.println(param);
		System.out.println(param_an);
		
		String error =null;
		
		//配列の要素数分だけループ
		for (int i = 0; i < param_an.length; i++) 
		{
			//	=をつけないと200数字も含まれる
			// <が正しい
			//200文字超えていればエラーに入る
			if(param_an[i].length()>200) {
				error="条件を超えています";
				
			}
		}
		//文字数が500文字以内かつ入力されているかつ文字が画面に存在する場合
		if ((param.length() <= 500) && (param!="" && param!=null))
		{
			//文字数okならconfirm.jspに飛ばす
			request.setAttribute("Questions",param);
			
			request.setAttribute("Answer[]",param_an);
			
			request.setAttribute("Questions_id",param_questions_id);
			
			request.setAttribute("Answer_id[]",param_anwer_id);
			
			request.setAttribute("a_text",error);
			
			System.out.println("ok");
			//文字数okならEdit_Confirm.jspに飛ばす
			RequestDispatcher dispacher = request.getRequestDispatcher("./Edit_Confirm.jsp");
			dispacher.forward(request, response);
			//エラー文字をjqpに表示させる
		} else {
			
			request.setAttribute("a_text",error);
			//文字数オーバーだったらngでRsgister.jspに戻す
			System.out.println("no");
			RequestDispatcher dispacher = request.getRequestDispatcher("./Register.jsp");
			dispacher.forward(request, response);
		}
		
	}
}
