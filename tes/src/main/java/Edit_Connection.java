

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.Correct_answersBean;
import tes.Correct_answersDao;
import tes.QuestionsBean;
import tes.QuestionsDao;

/**
 * Servlet implementation class Edit_item
 */
@WebServlet("/Edit_Connection")
public class Edit_Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit_Connection() {
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
		String questios_id = (String)request.getParameter("questions_id");
		
		if(questios_id==null)
		{
			questios_id = (String)request.getAttribute("questions_id");
		}
		System.out.println(questios_id);
		//５３行目のfindを使うためQuestionsDao Daoをnew=インスタンス化させる
		//=で値を定義していないとnullしか入っていない
		QuestionsDao Dao;
		try {
			//QuestionsDaoに入ってるのが使える
			 Dao = new QuestionsDao();
			 //Integer.parseIntは文字列を数値型に変換
			 //QuestionBeanのbeanからはquestios_idを持ってきたいため数値型にする
			QuestionsBean Bean = Dao.find(Integer.parseInt(questios_id));
			
			//Correct_answersDao型の変数「caDao」用意
			Correct_answersDao caDao = new Correct_answersDao();
			//ArrayList(配列)としてCorrect_answersBaen型のlist_answerを作り、そこにcaDaoオブジェクト(Correct_answersDaoクラス)が持つfindByQuestionsIdメソッドを実行した戻り値を格納
			ArrayList<Correct_answersBean> list_answer = caDao.findByQuestionsId(Integer.parseInt (questios_id));
			
			
			//setAttributeでセット
			request.setAttribute("Qusertions_list",Bean);
			
			request.setAttribute("Correct_anser_list",list_answer);
			
			//Edit.jspに移動
			request.getRequestDispatcher("./Edit.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
	}

}
