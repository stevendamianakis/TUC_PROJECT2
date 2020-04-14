package project2_classes;

public class Prescriptions {
	
	private long code;
	private String date,exp_date;
	private long insAMKA;
	private String doctorsFullName;
	private String[] medName;
	private float medCost;
	private int time;
	private int medNameAmount;
	
	public Prescriptions(long code,String date,String exp_date,long insAMKA,String doctorsFullName,float medCost,int time,int medNameAmount,String[] medName)
	{
		this.code=code;
		this.date=date;
		this.exp_date=exp_date;
		this.insAMKA=insAMKA;
		this.doctorsFullName=doctorsFullName;
		this.medNameAmount=medNameAmount;
		this.medName = medName;
		this.medCost=medCost;
		this.time=time;
	}
	
	public long getCode()
	{
		return code;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getExp_Date()
	{
		return exp_date;
		
	}
	
	public long getInsAMKA()
	{
		return insAMKA;
	}
	
	public String getDoctorsFullName()
	{
		return doctorsFullName;
	}
	
	public String getMedName(int i)
	{
		return medName[i];
	}
	
	
	public float getMedCost()
	{
		return medCost;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public int getMedNameAmount()
	{
		return medNameAmount;
	}
	
	
	
	
	 
	
	

}
