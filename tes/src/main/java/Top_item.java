

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TOP
 */
@WebServlet("/Top_item")
public class Top_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Top_item() {
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
		
		//top.jspでhiddenで設定したパラメータをgetParameterで取得してString paramに代入している
		String param = request.getParameter("param");
		//hiddenの指定の値が押された時
        if (param.equals("1"))
         {
        	//listの内容に出したい処理
        	response.sendRedirect("./List_Connection");
        	return;
         } else if (param.equals("2")) {
             request.getRequestDispatcher("./Test_Connection").forward(request, response);
         } else if (param.equals("3")) {
             request.getRequestDispatcher("./History_Connection").forward(request, response);

         }
	}

}
