

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class List_item
 */
@WebServlet("/List_item")
public class List_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List_item() {
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
		
		//LIst.jspでhiddenで指定したパラメーターをgetParameterでString paramに代入している
		String param = request.getParameter("parem");
	
		//新規登録画面に移動処理
		//hiddenで指定の値が押された時
				if (param.equals("1"))
				{ 
					
					//Registerの内容に出したい処理
					request.getRequestDispatcher("./Register.jsp").forward(request, response);
					
					
				}else if(param.equals("2")){
					//編集処理画面に移動[editサーブレット]
					request.getRequestDispatcher("./Edit_Connection").forward(request, response);
					
				}else if(param.equals("3"))
				{
					System.out.println(request.getParameter("questions_id"));
					request.setAttribute("Questions_id", request.getParameter("questions_id"));
					request.getRequestDispatcher("./Delete_item").forward(request, response);
				}
	}

}
