package service;

import java.util.List;

import scc.dao.GuitarsDaoJDBCImpl;
import scc.entity.GuitarSpec;
import scc.entity.Guitars;

public class GuitarsService {

	private GuitarsDaoJDBCImpl guitarsDao=new GuitarsDaoJDBCImpl();
	
	public List<Guitars> search(GuitarSpec spec) {
		// TODO Auto-generated method stub
		return guitarsDao.search(spec);
	}

	public GuitarsDaoJDBCImpl getGuitarsDaoJDBCImpl() {
		return guitarsDao;
	}

	public void setGuitarsDaoJDBCImpl(GuitarsDaoJDBCImpl guitarsDaoJDBCImpl) {
		this.guitarsDao = guitarsDaoJDBCImpl;
	}
}