package tes;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class List
 */
@WebServlet("/List")
public class List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public List() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPostと同じ処理が動く
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//QuestionsDao型のオブジェクト、「dao」変数を用意
			//QuestionsDaoの中の値を呼び出せるようにした
			QuestionsDao dao = new QuestionsDao();
			//ArrayList(配列)としてQuestionBean型のlistを作り、そこにdaoオブジェクト(QuestionsDaoクラス)が持つfindAllメソッドを実行した戻り値を格納
			//QuestionDaoでArrayList<QuestionBean> list = new ArrayList<QuestionBean>で定義しているからdao.findAll();の型にしている
			ArrayList<QuestionsBean> list =  dao.findAll();
			//Correct_answersDao型のオブジェクト、「dao_answer」変数を用意
			Correct_answersDao dao_answer = new Correct_answersDao();
			//ArrayList(配列)としてCorrect_answersBaen型のlist_answerを作り、そこにdao_answerオブジェクト(Correct_answersDaoクラス)が持つfindAllメソッドを実行した戻り値を格納
			ArrayList<Correct_answersBean> list_answer = dao_answer.findAll();
			//
			request.setAttribute("Qusertions_list",list);
			//パラメーター名Correct_anser_listとして答え一覧を設定
			request.setAttribute("Correct_anser_list",list_answer);
			//LIst.jspに移動
			request.getRequestDispatcher("./LIst.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
}
