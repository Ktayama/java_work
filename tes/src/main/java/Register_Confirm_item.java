

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register_Confirm_item
 */
@WebServlet("/Register_Confirm_item")
public class Register_Confirm_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_Confirm_item() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				request.setCharacterEncoding("UTF-8");
				//LIst.jspでhiddenで指定したパラメーターをgetParameterでString paramに代入している
				//register_confirm.jspで指定したパラメータをgetParameterでString prm_confirmに代入している
				String prm_confirm = request.getParameter("prm_confirm");
				
				//Register register = new Register();
				//submitで指定の値が押された時
				if (prm_confirm.equals("登録"))
				{
					
					//register_confirm.jspでinputに入力された値をgetParameterValuesで配列として取得する。それを、String[] answer_textに代入する
					String[] param_an =request.getParameterValues("answer");
					//setAttributeでパラメータセットさせる
					//register_confirm.jspで表示された問題文の値をgetParameterで取得
					request.setAttribute("Qusertions_text",request.getParameter("question"));
					request.setAttribute("Correct_answer_text",param_an);
					
					System.out.println("ok");
					//registerConfirm.javaに移動
					request.getRequestDispatcher("./Register").forward(request, response);
					return;
				}
				//Register.jspに戻る処理
				System.out.println("no");
				request.getRequestDispatcher("./Register.jsp").forward(request, response);
			}
	}


