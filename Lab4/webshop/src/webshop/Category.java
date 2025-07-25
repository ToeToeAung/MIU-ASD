package webshop;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class Category implements ProductCatalogComponent {
	 private String name;
	    private List<ProductCatalogComponent> children = new ArrayList<>();

	    public Category(String name) {
	        this.name = name;
	    }

		public void addProductComponent(ProductCatalogComponent product) {
			children.add(product);
		}

		
	    @Override
	    public void print() {
	        System.out.println("Category: " + name);
	        for (ProductCatalogComponent child : children) {
	            child.print();
	        }
	    }
}
