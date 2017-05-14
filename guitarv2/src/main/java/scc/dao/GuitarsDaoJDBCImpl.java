package scc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import scc.dbutil.DbUtil;
import scc.entity.GuitarSpec;
import scc.entity.Guitars;
import scc.entity.Inventory;

public class GuitarsDaoJDBCImpl implements GuitarsDao {
	@Override
	public List<Guitars> search(GuitarSpec spec) {
        DbUtil dbUtil=new DbUtil();
        Inventory inventory=new Inventory();
        ResultSet rs=dbUtil.executeQuery("select * from guitar",new Object[]{});
        try {
            while(rs.next()){
                String serialNumber=rs.getString(1);
                Double price=rs.getDouble(2);
                GuitarSpec spec1=new GuitarSpec();	
                spec1.setBuilder(rs.getString(3));
                spec1.setModel(rs.getString(4));
                spec1.setType( rs.getString(5));
                spec1.setNumStrings(rs.getString(6));
                spec1.setBackWood( rs.getString(7));
                spec1.setTopWood( rs.getString(8));
                inventory.addGuitars(serialNumber, price, spec1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        @SuppressWarnings({ "rawtypes", "unchecked" })
		List<Guitars> list=new LinkedList();
        list=inventory.search(spec);
        return list;
    }
}
