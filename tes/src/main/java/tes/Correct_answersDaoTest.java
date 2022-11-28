package tes;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class Correct_answersDaoTest {

	//private Correct_answersDao correct_answersDao = new Correct_answersDao();
	//private ArrayList<Correct_answersBean> answers_List = new ArrayList<Correct_answersBean>();
	
	
	@Test
	public void findByQuestionsIdメソッドにDBに存在する答え番号_戻り値答え名() throws Exception{
		//ArrayList<Correct_answersBean> answers_List = new ArrayList<Correct_answersBean>();
		Correct_answersDao correct_answersDao = new Correct_answersDao();
		assertThat(correct_answersDao.findByQuestionsId(1).get(0).getAnswer(),is("じろー1"));
	}
	@Test
	public void findByQuestionsIdメソッドにDBに存在しない答え番号_戻り値答え名() throws Exception{
		Correct_answersDao correct_answersDao = new Correct_answersDao();
		ArrayList<Correct_answersBean> answers_List = new ArrayList<Correct_answersBean>();
		assertThat(correct_answersDao.findByQuestionsId(2),is(answers_List));
		
		assertThat(correct_answersDao.findByQuestionsId(-1),is(answers_List));
	}

}
