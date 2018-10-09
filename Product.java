package StreamImpl;

public class Product {
	
	int pid;
	String name;
	public Product(int pid, String name) {
		super();
		this.pid = pid;
		this.name = name;
	}
	public int getPid() {
		return pid;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + "]";
	}
	
	

}
