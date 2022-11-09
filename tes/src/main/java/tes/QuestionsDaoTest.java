package tes;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.jupiter.api.Test;


public class QuestionsDaoTest {


	@Test
	public void findメソッドにDBに存在する問題番号_戻り値問題名() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		
		assertThat(questionsDao.find(1).getQuestion(),is("ジロー問題"));
	}
	
	public void findメソッドにDBに存在しない問題番号_戻り値問題名() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		
		assertThat(questionsDao.find(-1).getQuestion(),is("ジロー問題"));
	}
	/*	@Test
		public void Insertメソッドにユーザーの入力値が500文字以内_戻り値問題番号() throws Exception{
			QuestionsDao questionsDao = new QuestionsDao();
			
			assertThat(questionsDao.find(1).getQuestion(),is(500)); 
			
		}*/
	/**
	 *  * 正常系
	 *  */
	/*@ParameterizedTest
	@ValueSource(strings = {"タロー問題"})
	*/
	//@Test
	/*public void Insertメソッドにユーザーの入力値が500文字以内_戻り値問題番号() throws Exception{
		QuestionsDao questionsDao = new QuestionsDao();
		
		
		assertThat(questionsDao.find(1).getQuestion(),((CharSequence) questionsDao).length() <=500);
	}
*/
}
