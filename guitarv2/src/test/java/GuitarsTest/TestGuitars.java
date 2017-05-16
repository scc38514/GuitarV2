package GuitarsTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import scc.dbutil.DbUtil;
import scc.entity.GuitarSpec;
import scc.entity.Guitars;
import scc.entity.Inventory;

public class TestGuitars {
	@Test public void testGetallMethod() {
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
	        GuitarSpec spec=new GuitarSpec("Martin","","","","","");
			List<Guitars> list=new LinkedList();
	        list=inventory.search(spec);
	        if (!list.isEmpty()) {
	            System.out.println("Erin, you might like these guitars:");
	            for (Iterator i = list.iterator(); i.hasNext(); ) {
	              Guitars guitars = (Guitars)i.next();
	              GuitarSpec specs = guitars.getSpec();
	              System.out.println("  We have a " +
	            		  " " + specs.getModel() + " " +
	            		  specs.getType() + " guitar:" + specs.getNumStrings()+ 
	            		  specs.getBackWood() + " back and sides," +
	            		  specs.getTopWood() + " top.\n  You can have it for only $" +
	                guitars.getPrice() + "!\n  ----");
	            }
	          } else {
	            System.out.println("Sorry, Erin, we have nothing for you.");
	          }		
	}
}
