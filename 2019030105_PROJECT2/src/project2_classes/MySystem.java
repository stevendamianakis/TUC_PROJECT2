package project2_classes;

public class MySystem {
	
	private String name;
	private String url;
	private Insured[] ins;
	private int insNum;
	private Medicine[] med;
	private int medNum;
	private Doctors[] doc;
	private int docNum;
	private Prescriptions[] pre;
	private int preNum;
	
	
	public MySystem(String name,String url)
	{
		this.name=name;
		this.url=url;
		ins=new Insured[100];
		insNum=0;
		med=new Medicine[50];
		medNum=0;
		doc=new Doctors[100];
		docNum=0;
		pre=new Prescriptions[400];
		preNum=0;
	}
	
	public void insertInsured(long AMKA,String fullInsName)
	{
		if (insNum>=100)
			System.out.println("Cannot store more than 100 insured.");
		else
		{
			ins[insNum]=new Insured(AMKA,fullInsName);
			insNum++;
		}
	}
	
	public void printInsured()
	{	System.out.println("\nINSURED AMKA: ");
		for(int i=0; i<insNum; i++)
			System.out.println(ins[i].getAMKA());
		System.out.println("");
	}
	
	public int controlInsured(long AMKA)
	{
		for(int i=0; i<insNum; i++)
		{
			if (AMKA==ins[i].getAMKA())
				return 0;
				
		}
		return 1;
		
	}
	
	public void insertMedicine(long medCode,String name,float price)
	{
		if (medNum>=50)
			System.out.println("Cannot store more than 50 medicine.");
		else
		{
			med[medNum]=new Medicine(medCode,name,price);
			medNum++;
		}
	}
	
	public void printMedicine()
	{	System.out.println("\nMEDICINE NAMES: ");
		for(int i=0; i<medNum; i++)
			System.out.println(med[i].getName());
		System.out.println("");
	}
	
	public int controlMedName(String name)
	{
		for(int i=0; i<medNum; i++)
		{
			if (name.equals(med[i].getName()))
				return 0;
		}
		return 1;
		
	}
	
	public float calculateTotalMedCost(String[] names,int amount)
	{
		float totalCost=0;
		for (int i=0; i<amount; i++)
		{
			for (int k=0; k<medNum; k++)
			{
				if(names[i].equals(med[k].getName()))
					totalCost += med[i].getPrice();

			}
		}
		return totalCost;
	}
	
	public void insertDoctors(long AAAE,String fullDocName,String specialty)
	{
		if (docNum>=100)
			System.out.println("Cannot store more than 100 doctors.");
		else
		{
			doc[docNum]=new Doctors(AAAE,fullDocName,specialty);
			docNum++;
		}
	}
	
	public void printDoctors()
	{	System.out.println("\nDOCTORS FULL NAMES: ");
		for(int i=0; i<docNum; i++)
			System.out.println(doc[i].getFullDocName());
		System.out.println("");
	}
	
	public int controlDoctors(String name)
	{
		for(int i=0; i<docNum; i++)
		{
			if (name.equals(doc[i].getFullDocName()))
				return 0;
				
		}
		return 1;
		
	}
	
	public void insertPrescriptions(long code,String date,String exp_date,long insAMKA,String doctorsFullName,float medCost,int time,int amount,String[] names)
	{
		if (preNum>=400)
			System.out.println("Cannot store more than 400 prescriptions.");
		else
		{
			pre[preNum]=new Prescriptions(code,date,exp_date,insAMKA,doctorsFullName,medCost,time,amount,names);
			preNum++;
			
		}
	}
	
	public void printPrescriptions()
	{	System.out.println("\nPRESCRIPTIONS CODES: ");
		for(int i=0; i<preNum; i++)
			System.out.println(pre[i].getCode());
		System.out.println("");
	}
	
	public void search_AMKA(long AMKA)
	{
		int k=0;
		for(int i=0; i<preNum; i++)
		{
			if(AMKA==pre[i].getInsAMKA())
				k++;
				System.out.println("\nPrescription found with code: "+(pre[i].getCode()));
		}
		if(k==0)
			System.out.println("Prescription not found.");
	}
	
	public void search_AAAE(long AAAE)
	{
		int k=0;
		for(int i=0; i<docNum; i++)
		{
			if(AAAE==doc[i].getAAAE())
			{
				for(int j=0; j<preNum; j++)
				{
					if(pre[j].getDoctorsFullName().equals(doc[i].getFullDocName())) 
						{
						k++;
						System.out.println("\nPrescription found with code: "+(pre[j].getCode()));
						}
						
				}
					
			}		
		}
		if(k==0)
			System.out.println("Prescription not found.");
	}
	
	
	public void search_code(long code)
	{
		int k=0;
		for(int i=0; i<medNum; i++)
		{
			if(med[i].getMedCode()==code)
			{
				for(int m=0; m<preNum; m++) 
						
				{
					for(int j=0; j<pre[m].getMedNameAmount(); j++)
							
					{
							if(pre[m].getMedName(j).equals(med[i].getName()))	
							{
								k++;
								System.out.println("\nPrescription found with code: "+(pre[m].getCode()));
							}
										
					}
				}
						
			}
					
						
		}
		if(k==0)
			System.out.println("Prescription not found.");
	}
	
	
	public void search_date(String date1,String date2)
	{
		int k=0;
		for(int i=0; i<preNum; i++)
		{
			if(!(((pre[i].getDate()).compareTo(date1)>=0 && (pre[i].getDate()).compareTo(date2)>=0)||((pre[i].getExp_Date()).compareTo(date2)<0 && (pre[i].getExp_Date()).compareTo(date1)<0)))
				{
					k++;
					System.out.println("\nPrescription found with code: "+(pre[i].getCode()));
				}
		}
		if(k==0)
			System.out.println("Prescription not found.");
	}
	
	public void deleteInsured(long AMKA)
	{
		int i=0,m=0;
		while((i<insNum)&&(AMKA!=ins[i].getAMKA()))
			i++;
		if(i<insNum)
		{
			for(int k=i; k<insNum-1; k++)
				ins[k]=ins[k+1];
		    ins[insNum-1]=null;
		    insNum--;
		}
		while((m<preNum)&&(AMKA!=pre[i].getInsAMKA()))
			m++;
		if(m<preNum)
		{
			for(int p=m; p<preNum-1; p++)
				pre[p]=pre[p+1];
			pre[preNum-1]=null;
			preNum--;
		}
		System.out.println("Insured with AMKA: "+AMKA+" has been completely deleted.");
		
		
	}
	
	public int generateCode()
	{
		return preNum+1;
	}
	
	public String getName()
	{
		return name; 
	}
	public int getMedNum()
	{
		return medNum; 
	}
	public int getInsNum()
	{
		return insNum; 
	}
	public String getUrl()
	{
		return url;
	}
	public Insured getIns(int i)
	{
		return ins[i];
		
	}
	public Medicine getMed(int i)
	{
		return med[i];
		
	}
	public Doctors getDoc(int i)
	{
		return doc[i];
		
	}
	public int getDocNum()
	{
		return docNum; 
	}
	public Prescriptions getPre(int i)
	{
		return pre[i];
		
	}
	public int getPreNum()
	{
		return preNum;
		
	}
	
	
	

}
