package tes;
 
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class UsersDaoTest {
	
	@Test
	public void findメソッドにDBに存在するユーザーIDを入れる_戻り値ユーザー名() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThat(usersDao.find(11).getName(),is("コル"));
		 
		assertThat(usersDao.find(2).getName(),is("コジ"));
		
		assertThat(usersDao.find(17).getName(),is("コール"));
	}
	@Test   //(expected = IllegalArgumentException.class)
	public void findメソッドにDBに存在しないユーザーIDを入れる_戻り値ユーザー名() throws Exception{
		UsersDao usersDao = new UsersDao();
		
		assertThat(usersDao.find(12).getName(),nullValue());
		
		assertThat(usersDao.find(0).getName(),nullValue());
		
		assertThat(usersDao.find(-1).getName(),nullValue());
		

	
	}
/*	@Test
	void findメソッドにDBに存在しないユーザーIDを入れる_戻り値ユーザー名() throws Exception{
		UsersDao usersDao = new UsersDao();
		assertThrows(IndexOutOfBoundsException.class,  usersDao.find(12).getName(),Matcher<"コル">) ;
	}

*/}
