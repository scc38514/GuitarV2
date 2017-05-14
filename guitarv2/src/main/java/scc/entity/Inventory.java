package scc.entity;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Guitars> guitar;

	  public Inventory() {
	    guitar = new LinkedList<Guitars>();
	  }

	  public void addGuitars(String serialNumber, double price,
	                        GuitarSpec spec) {
	    Guitars guitars = new Guitars(serialNumber, price, spec);
	     guitar.add(guitars);
	  }

	  public Guitars getGuitars(String serialNumber) {
	    for (Iterator<Guitars> i = guitar.iterator(); i.hasNext(); ) {
	      Guitars guitars = (Guitars)i.next();
	      if (guitars.getSerialNumber().equals(serialNumber)) {
	        return guitars;
	      }
	    }
	    return null;
	  }

	  public List<Guitars> search(GuitarSpec searchSpec) {
	    List<Guitars> matchingGuitar = new LinkedList<Guitars>();
	    for (Iterator<Guitars> i = guitar.iterator(); i.hasNext(); ) {
	      Guitars guitars = (Guitars)i.next();
	      if (guitars.getSpec().matches(searchSpec))
	        matchingGuitar.add(guitars);
	    }
	    return matchingGuitar;
	  }
	}
