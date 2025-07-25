package webshop;

public class Product  implements ProductCatalogComponent{
	  private String name;
	  protected double price;
	  
	    public Product(String name) {
	        this.name = name;
	    }
	    
	    public double getPrice() {
			return price;
		}


	    public void setPrice(double price) {
			this.price = price;
		}

	    @Override
	    public void print() {
	    	System.out.println("Product: " + this.name + ", price: " + getPrice());
	    }
}
