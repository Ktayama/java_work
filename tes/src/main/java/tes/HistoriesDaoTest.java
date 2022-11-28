package tes;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class HistoriesDaoTest {

	@Test
	public void findAll() throws Exception{
		HistoriesDao historiesDao = new HistoriesDao();
		assertThat(historiesDao.findAll("11").get(0).getUserId(),is(11));
	}
	@Test
	public void findAllマイナス() throws Exception{
		HistoriesDao historiesDao = new HistoriesDao();
		ArrayList<HistoriesBean> histories_List = new ArrayList<HistoriesBean>();
		assertThat(historiesDao.findAll("-11"),is(histories_List));
	}
	@Test
	public void findAllカタカナ() throws Exception{
		HistoriesDao historiesDao = new HistoriesDao();
		ArrayList<HistoriesBean> histories_List = new ArrayList<HistoriesBean>();
		assertThat(historiesDao.findAll("ジュウイチ"),is(histories_List));
	}
}
