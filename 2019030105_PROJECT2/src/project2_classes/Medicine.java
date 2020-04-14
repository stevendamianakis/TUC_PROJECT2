package project2_classes;

public class Medicine {
	
	private long medCode;
	private String name;
	private float price;
	
	public Medicine(long medCode,String name,float price)
	{
		this.medCode=medCode;
		this.name=name;
		this.price=price;
	}
	public long getMedCode()
	{
		return medCode;
	}
	
	public String getName()
	{
		return name;
	}
	
	public float getPrice()
	{
		return price;
	}
	

}
