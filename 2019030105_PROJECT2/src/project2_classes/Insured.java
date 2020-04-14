package project2_classes;

public class Insured {
	
	private long AMKA;
	private String fullInsName;
	
	public Insured(long AMKA,String fullInsName)
	{
		this.AMKA=AMKA;
		this.fullInsName=fullInsName;
	}
	public long getAMKA()
	{
		return AMKA;
	}
	
	public String getFullInsName()
	{
		return fullInsName;
	}
	

}
