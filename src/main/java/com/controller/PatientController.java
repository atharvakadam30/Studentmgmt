package com.controller;

import java.util.Scanner;

import com.pojo.Patient;
import com.service.PatientServiceImpl;

public class PatientController {
	public static void main(String[] args) {
		PatientServiceImpl pp = new PatientServiceImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for registration \n Enter 2 to check Entry \n Enter 3 for update detail \n Enter 4 to"
				+ " Delete entry \n Enter 5 to view all Data");
		int n=sc.nextInt();
		do
		{
			switch (n) {
			case 1:
				
				System.out.println("Enter Patients id,name,age,gender");
				Patient p = new Patient(sc.nextInt(), sc.next(), sc.nextInt(), sc.next());
				pp.register(p);
				break;
			case 2:
				
				System.out.println("Enter Patients id");
				Patient p1 = new Patient(sc.nextInt());
				if(pp.IsRegister(p1)) {
					System.out.println("Patient Entry already Exist");
				}else {
					System.out.println("**please register patient details**");
					System.out.println("Enter patient id,name,age,gender");
					Patient newPatient=new Patient(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
					pp.register(newPatient);
					
				}
				
				break;
				
			 case 3:
				 System.out.println("Enter Patient ID to Update:");
	             int pid = sc.nextInt();
				if( pp.IsRegister(new Patient(pid))) {
					System.out.println("Enter Updated Name, Age, Gender:");
	                String name = sc.next();
	                int age = sc.nextInt();
	                String gender = sc.next();
	                Patient updatedPatient = new Patient(pid, name, age, gender);
		            pp.updateDetails(updatedPatient);
				}
				
		            break;
		            
			 case 4:
				 System.out.println("Enter Patient Id to delete Entry");
				  pid= sc.nextInt();
				  if (pp.IsRegister(new Patient(pid))) {
				        pp.deleteEntry(pid);
				    } 
				  break;
				  
			 case 5:
				 pp.viewData();
			}
			break;
			
		}while(n!=5);

	}
}
