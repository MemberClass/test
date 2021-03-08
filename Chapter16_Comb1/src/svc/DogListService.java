package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import dao.DogDAO;
import vo.Dog;

public class DogListService {

	public ArrayList<Dog> getDogList() {
		ArrayList<Dog> dogList= null;
		DogDAO dogDAO = DogDAO.getInstance();
		Connection con=null;
		
		try {
			con=getConnection();
			dogDAO.setConnection(con);
			dogList=dogDAO.selectDogList();
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close(con);
		}
		
		return dogList;
	}

}
