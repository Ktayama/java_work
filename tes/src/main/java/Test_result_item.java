

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test_result_item
 */
@WebServlet("/Test_result_item")
public class Test_result_item extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test_result_item() {
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
		String pram =request.getParameter("pram");
		
		if(pram.equals("top"))
		{
			request.getRequestDispatcher("./top.jsp").forward(request, response);
		}else if(pram.equals("logout"))
		{
			request.getRequestDispatcher("./logout.jsp").forward(request, response);
		}else if(pram.equals("history"))
		{
			request.getRequestDispatcher("./History_Connection").forward(request, response);
		}
	}

}
