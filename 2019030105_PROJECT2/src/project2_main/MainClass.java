package project2_main;

import java.util.Date;
import java.util.Scanner;
import java.util.Calendar;


import project2_classes.MySystem;
public class MainClass {

	public static void main(String[] args) {
		
		MySystem SystemObj = new MySystem("PRESCRIPTION SYSTEM","https://www.prescriptionsystemtuc.gr/");
		SystemObj.insertInsured(123, "Vasilis Georgiou");
		SystemObj.insertInsured(124, "Kostas Galanos");
		SystemObj.insertInsured(125, "Michail Papanastasopoulos");
		SystemObj.insertInsured(126, "Maria Nikolaidou");
		SystemObj.insertInsured(127, "Georgia Nestoraki");
		SystemObj.insertInsured(128, "Foteini Triposkoufi");
		
		SystemObj.insertMedicine(1, "Depon", 2.5f);
		SystemObj.insertMedicine(2, "Ponstan", 3.5f);
		SystemObj.insertMedicine(3, "Panadol", 4.5f);
		SystemObj.insertMedicine(4, "Xanax", 5.5f);
		SystemObj.insertMedicine(5, "Morphene", 105.5f);
		
		SystemObj.insertDoctors(1233, "Panagiotis Mavrotsoukalos", "Otorinolarigkologos");
		SystemObj.insertDoctors(1234, "Nikoleta Stamatidou", "Gynaikologos");
		SystemObj.insertDoctors(1235, "Kostantinos Garefakakis", "Pathologos");
		SystemObj.insertDoctors(1236, "Sotiris Tsiordas", "Fashion Icon");
		mainMenu(SystemObj);
		
			
		
		
	}
	
	@SuppressWarnings({ "deprecation" })
	
	public static void mainMenu(MySystem obj)
	{
		int number,number2,number3,amount,duration,control1,control2,control3,uniqueCode;
		int days,months,years,last_days,last_months,last_years;
		float medPrice,totalCost;
	 	long insAMKA,preInsAMKA,delete_AMKA,search_AMKA,search_AAAE,search_code,AAAE,medCode;
		String insFullName,docName,preDocName,medName,specialty,my_date,date1,date2,last_date;
		String[] medNames;
		
		Date date = new Date();
		
		Scanner option = new Scanner(System.in);
		Scanner option2 = new Scanner(System.in);
		Scanner option3 = new Scanner(System.in);
		Scanner amount_scanner = new Scanner(System.in);
		Scanner insAMKA_scanner = new Scanner(System.in);
		Scanner PreInsAMKA_scanner = new Scanner(System.in);
		Scanner insFullName_scanner = new Scanner(System.in);
		Scanner AAAE_scanner = new Scanner(System.in);
		Scanner docName_scanner = new Scanner(System.in);
		Scanner PreDocName_scanner = new Scanner(System.in);
		Scanner specialty_scanner = new Scanner(System.in);
		Scanner medPrice_scanner = new Scanner(System.in);
		Scanner medName_scanner = new Scanner(System.in);
		Scanner PreMedName_scanner = new Scanner(System.in);
		Scanner duration_scanner = new Scanner(System.in);
		Scanner medCode_scanner = new Scanner(System.in);
		Scanner medNames_scanner = new Scanner(System.in);
		Scanner search_AAAE_scanner = new Scanner(System.in);
		Scanner search_AMKA_scanner = new Scanner(System.in);
		Scanner search_code_scanner = new Scanner(System.in);
		Scanner date1_scanner = new Scanner(System.in);
		Scanner date2_scanner = new Scanner(System.in);
		Scanner delete_AMKA_scanner = new Scanner(System.in);
		
		
		while(true)
		{
			System.out.println("\nWelcome to the main menu!");
			System.out.println("1: IMPORT INSURED");
			System.out.println("2: IMPORT MEDICINE");
			System.out.println("3: IMPORT DOCTORS");
			System.out.println("4: IMPORT PRESCRIPTIONS");
			System.out.println("5: FIND AND PRINT PRESCRIPTIONS");
			System.out.println("6: PRINT INSURED MEDICINE DOCTORS OR PRESCRIPTIONS ");
			System.out.println("7: DELETE INSURED");
			System.out.println("8: EXIT");
			System.out.println("Enter the appropriate number:");
			number=option.nextInt();
			switch (number)
			{
			
			case 1:
				
				System.out.println("Enter insured AMKA: ");
				insAMKA=insAMKA_scanner.nextLong();
				System.out.println("Enter insured full name: ");
				insFullName=insFullName_scanner.nextLine();
				obj.insertInsured(insAMKA,insFullName);
				System.out.println("Returning to the main menu...");
				
				break;
			case 2:
				
				System.out.println("Enter the code of the medicine: ");
				medCode=medCode_scanner.nextLong();
				System.out.println("Enter the name of the medicine: ");
				medName=medName_scanner.nextLine();
				System.out.println("Enter the price of the medicine: ");
				medPrice=medPrice_scanner.nextFloat();
				obj.insertMedicine(medCode,medName,medPrice);
				System.out.println("Returning to the main menu...");
				
				break;
			case 3:
				
				System.out.println("Enter doctors AAAE: ");
				AAAE=AAAE_scanner.nextLong();
				System.out.println("Enter doctors name: ");
				docName=docName_scanner.nextLine();
				System.out.println("Enter doctors specialty: ");
				specialty=specialty_scanner.nextLine();
				obj.insertDoctors(AAAE,docName,specialty);
				System.out.println("Returning to the main menu...");
				
				break;
			case 4:
				
				obj.printInsured();
				System.out.println("Enter AMKA of the insured you are insterested in: ");
				preInsAMKA=PreInsAMKA_scanner.nextLong();
				control1=obj.controlInsured(preInsAMKA);
				controllerAMKA(control1,obj);
				
				obj.printDoctors();
				System.out.println("Enter name of the doctor you are interested in: ");
				preDocName=PreDocName_scanner.nextLine();
				control2=obj.controlDoctors(preDocName);
				controllerDocName(control2,obj);
				
				obj.printMedicine();
				System.out.println("Enter medicine amount(maximum 4): ");
				amount=amount_scanner.nextInt();
				if (amount<1 || amount>4)
				{
					System.out.println("Wrong amount!");
					System.out.println("Returning to the main menu...");
					break;
				}
				medNames = new String[amount];
				for (int d=0;d<amount;d++)
				{
					System.out.println("Enter name of medicine number "+(d+1)+" : ");
					medNames[d]=medNames_scanner.nextLine();
					control3=obj.controlMedName(medNames[d]);
					controllerMedName(control3,obj);
					
					
				}
				
				totalCost=obj.calculateTotalMedCost(medNames,amount);
				uniqueCode=obj.generateCode();
				
				days=date.getDate();
				months=date.getMonth()+1;
				years=date.getYear()+1900;
				my_date=days+"."+months+"."+years;
				
				System.out.println("Enter the duration(in days) of the prescription(maximum 10 days): ");
				duration=duration_scanner.nextInt();
				
				if(duration<1 || duration>10)
				{
					System.out.println("Wrong duration value!");
					System.out.println("Returning to the main menu...");
					break;
				}
					
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, duration);
				Date exp_date = c.getTime();
				last_days=exp_date.getDate();
				last_months=exp_date.getMonth()+1;
				last_years=exp_date.getYear()+1900;
				last_date=last_days+"."+last_months+"."+last_years;
				
				obj.insertPrescriptions(uniqueCode,my_date,last_date,preInsAMKA,preDocName,totalCost,duration,amount,medNames);
				System.out.println("Returning to the main menu...");
				
				break;
			case 5:
				System.out.println("Print prescriptions based on: ");
				System.out.println("1: Insured AMKA");
				System.out.println("2: 2 dates");
				System.out.println("3: Doctors AAAE");
				System.out.println("4: Medicine code");
				number3=option3.nextInt();
				switch(number3)
				{
				case 1:
					System.out.println("Enter AMKA to search Prescriptions: ");
					search_AMKA=search_AMKA_scanner.nextLong();
					obj.search_AMKA(search_AMKA);
					System.out.println("\nReturning to the main menu...");
					
					break;
				case 2:
					System.out.println("Enter first date(e.g 11.4.2020): ");
					date1=date1_scanner.nextLine();
					
					
					System.out.println("Enter second date(follow the same form): ");
					date2=date2_scanner.nextLine();
					obj.search_date(date1, date2);
					System.out.println("\nReturning to the main menu...");
					
					break;
				case 3:
					System.out.println("Enter doctor's AAAE to search Prescriptions: ");
					search_AAAE=search_AAAE_scanner.nextLong();
					obj.search_AAAE(search_AAAE);
					System.out.println("\nReturning to the main menu...");
					
					break;
				case 4:
					System.out.println("Enter medicine's code to search Prescriptions: ");
					search_code=search_code_scanner.nextLong();
					obj.search_code(search_code);
					System.out.println("\nReturning to the main menu...");
					
					break;
				default:
					System.out.println("Wrong option!");
					System.out.println("Returning to the main menu...");
				}
				
				break;
			case 6:
				System.out.println("\n1: PRINT INSURED");
				System.out.println("2: PRINT MEDICINE");
				System.out.println("3: PRINT DOCTORS");
				System.out.println("4: PRINT PRESCRIPTIONS");
				System.out.println("Enter the appropriate number:");
				number2=option2.nextInt();
				switch(number2)
				{
				case 1:
					obj.printInsured();
					break;
				case 2:
					obj.printMedicine();
					break;
				case 3:
					obj.printDoctors();
					break;
				case 4:
					obj.printPrescriptions();
					break;
				default:
					System.out.println("Wrong option!");
					System.out.println("Returning to the main menu...");
				}
				break;
			case 7:
				System.out.println("Enter AMKA of the insured that you want to delete: ");
				delete_AMKA=delete_AMKA_scanner.nextLong();
				obj.deleteInsured(delete_AMKA);
				break;
			case 8:
				
				
				option.close();
				option2.close();
				option3.close();
				amount_scanner.close();
				AAAE_scanner.close();
				docName_scanner.close();
				specialty_scanner.close();
				insAMKA_scanner.close();
				insFullName_scanner.close();
				medName_scanner.close();
				medPrice_scanner.close();
				medCode_scanner.close();
				PreInsAMKA_scanner.close();
				PreDocName_scanner.close();
				PreMedName_scanner.close();
				duration_scanner.close();
				medNames_scanner.close();
				search_AMKA_scanner.close();
				search_AAAE_scanner.close();
				search_code_scanner.close();
				date1_scanner.close();
				date2_scanner.close();
				delete_AMKA_scanner.close();
				
				
				
				
				
				System.exit(0);
			default:
				System.out.println("Wrong option!");
				System.out.println("Returning to the main menu...");
				
			}
			
			
			
		}
	}
	
	public static void controllerAMKA(int i,MySystem obj)
	{
		if (i==1) 
		{
			System.out.println("\nThis AMKA is not available!");
			System.out.println("Returning to the main menu...");
			mainMenu(obj);
		}
	}
	
	public static void controllerDocName(int i,MySystem obj)
	{
		if (i==1) 
		{
			System.out.println("\nThis name is not available!");
			System.out.println("Returning to the main menu...");
			mainMenu(obj);
		}
	}
	
	public static void controllerMedName(int i,MySystem obj)
	{
		if (i==1) 
		{
			System.out.println("\nThis name is not available!");
			System.out.println("Returning to the main menu...");
			mainMenu(obj);
		}
		
	}
	


}
