package scc.entity;

public class Guitars {

	  private String serialNumber;
	  private double price;
	  GuitarSpec spec;

	  public Guitars(String serialNumber, double price, GuitarSpec spec) {
	    this.serialNumber = serialNumber;
	    this.price = price;
	    this.spec = spec;
	  }

	  public String getSerialNumber() {
	    return serialNumber;
	  }

	  public double getPrice() {
	    return price;
	  }

	  public void setPrice(float newPrice) {
	    this.price = newPrice;
	  }

	  public GuitarSpec getSpec() {
	    return spec;
	  }
}
