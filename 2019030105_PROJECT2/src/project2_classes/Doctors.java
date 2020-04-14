package project2_classes;

public class Doctors {
	
	private long AAAE;
	private String fullDocName;
	private String specialty;
	
	public Doctors(long AAAE,String fullDocName,String specialty)
	{
		this.AAAE=AAAE;
		this.fullDocName=fullDocName;
		this.specialty=specialty;
	}
	public long getAAAE()
	{
		return AAAE;
	}
	
	public String getFullDocName()
	{
		return fullDocName;
		
	}
	
	public String getSpecialty()
	{
		return specialty;
	}

}
