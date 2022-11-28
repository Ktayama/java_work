

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tes.Correct_answersDao;
import tes.QuestionsDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
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
		
		
		//パラメータの値を受け取る
		//Rsgisterのjspから受け取る受けとてる
		request.setCharacterEncoding("UTF-8");
		//新規登録メソッド
		String questions_text = (String)request.getAttribute("Qusertions_text");
		String[] answer_text = (String[])request.getAttribute("Correct_answer_text");
		//編集メソッド
		String[] edit_answer = (String[])request.getAttribute("Edit_answer");
		String[] edit_answer_id = (String[])request.getAttribute("Edit_answer_id");
		String edit_questions = (String)request.getAttribute("Edit_questions");
		String edit_questions_id= (String)request.getAttribute("Edit_questions_id");
	
		
		
		//受け取ったパラメータを表示
		System.out.println(questions_text);
		System.out.println(answer_text);
		System.out.println(edit_questions);
		System.out.println(edit_answer);
		System.out.println(edit_questions_id);
		System.out.println(edit_answer_id);
		
		
		
		
		//questionテーブルの登録の処理
		try {
			//問題の登録
			//answerテーブルの登録
			//question_textと
			
			//QuestionsDaoの中身から呼び出せるようになった
			//QuestionDao型のオブジェクト「dao」用意
			QuestionsDao dao = new QuestionsDao();
			//Correct_answersDao型のオブジェクト「dao_an」用意
			Correct_answersDao dao_an = new Correct_answersDao();
			
			//edit_question_idが入っていなければ新規登録処理
			//編集問題番号が入っていれば編集登録処理
			if(edit_questions_id ==null) {
					
				//int edit_questions_id =Integer.parseInt(request.getParameter("edit_questions_id"));
				
				//*新規登録*//
				
				//新規登録の問題文
				//QuesstionDaoの65行でINSERでquestions_textの処理を行っている
				dao.Insert(questions_text);
				
				//新規登録の答え文
				//dao.getmax_question_idでは最新のレコードに付与されたidを取得している
				//最新のレコードに付与されたidとは、doa.Insert(question_text)で最後に追加した問題文のidのことを指している
				int questions_id =  dao.getmax_question_id();
				//for文でanswer_text配列の要素数分だけループする
				for (int i = 0; i < answer_text.length; i++) 
				{//Correct_answersDao型のInsertメソッドに要素数分の答えと問題番号を入れる
					dao_an.Insert(answer_text[i],questions_id);
				}
			}else{
					// Integer.parseIntを宣言すればいちいち書く必要はない
					
					
					//*編集*//
					
					//編集をして保存をUPDATEDに
					dao.UPDATED(edit_questions,Integer.parseInt(edit_questions_id));
					//answerから編集対象の該当問題をとる
					//Correct_answersDaooの65行でINSERでanswer_texttの処理を行っている
					
					//編集の答え
					//for文でedit_answer_id配列の要素数分だけループする
					for (int i1 = 0; i1 <edit_answer_id.length; i1++) {
						//edit_answer_idのidがnullだったらインサートする
						//テーブルの中にedit_answer_idが存在してなくて、かつ画面上に入力された文字があればINSERT
						if(edit_answer_id[i1].equals("") && !edit_answer[i1].equals("")){
							//Correct_answersDao型のInsertメソッドに答えの編集とint型の問題番号
							dao_an.Insert(edit_answer[i1], Integer.parseInt(edit_questions_id));
							//edit_answerが空文字の場合
							//テーブルの中にedit_answer_idが存在していて、かつ画面上に入力値がなければdeleteする
							//edit_answer_idがDB側でfor文でサイズを書く
						}else if(edit_answer_id[i1] != null && edit_answer[i1].equals("")) {
							//edit_answer_idが一件一件デリートされていく
							
							//編集の答え番号が一件一件deleteされていく
							dao_an.DELETE(Integer.parseInt(edit_answer_id[i1]));
							//テーブルにidが存在していて入力されていれば
							//idではどの答えが更新されるのかを指定している
							//idと答えが、どちらもあればupdate
							//テーブルの中にedit_answer_idが存在していて、かつ画面上に入力された文字があればupdate
						}else {//更新	
							dao_an.UPSATED(edit_answer[i1], Integer.parseInt(edit_answer_id[i1]));
						}
						
					}
				}
			} catch (Exception e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		//データベースに登録する
		//InsertRegisterDao dao = new InsertRegisterDao();
	try{
		
		//Beanクラスのインスタンス
		//RegisterBean input_register = new RegisterBean();
		
		//Beanクラスに入力したquestionsやanswerをセットする
		//input_register.setQuestions_text(questions_text);
		//input_register.setAnswer_text(answer_text);
		
		//List.javaに飛ばす
		RequestDispatcher dispacher = request.getRequestDispatcher("./List_Connection");
		dispacher.forward(request, response);
		}catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}

}
