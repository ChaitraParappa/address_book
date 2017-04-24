package com.bridgelabz.adressbook.main;

import java.util.Scanner;

import com.bridgelabz.adressbook.Controller.AddressBookController;
import com.bridgelabz.adressbook.model.Person;

class Test {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		AddressBookController addressbookcontroller = new AddressBookController();
		int number,number1;
		String addressname = null;

		do {
			System.out.println("           Address Book                ");
			System.out.println("----------------------------------------------");
			System.out.println("Press 1- To Add the address to the AdressBook");
			System.out.println("Press 2- To Edit to address in AdressBook");
			System.out.println("Press 3- To Delete the address in AddressBook");
			System.out.println("Press 4- To Display the AddressBook");
			System.out.println("Press 5- To sort the Address");
			System.out.println("Press 6- To search the Address");
			System.out.println("Press 7- To Exit");
			number = scanner.nextInt();
			
			
			switch (number) {
			
			case 1:
				System.out.println("Enter the adressbook name ");
				addressname = scanner.next();
				addressbookcontroller.add(addressname);
				System.out.println("");
				break;
				
			case 2:
				System.out.println("Enter the addressbook name to edit");
				addressname = scanner.next();
				addressbookcontroller.edit(addressname);
				System.out.println("");
				break;
				
			case 3:
				System.out.println("Press 1- to remove the  addressbook ");
				System.out.println("Press 2- to remove the perticular address in perticular addressbook ");
				number1=scanner.nextInt();
				if(number1==1)
				{
					System.out.println("Enter the addressbook name");
					addressname = scanner.next();
					addressbookcontroller.deleteAdressBook(addressname);
				}else if(number1==2)
				{
					System.out.println("Enter the addressbook name");
					addressname = scanner.next();
					addressbookcontroller.delete(addressname);
				}
				else{
					System.out.println("Enter the correct option");
				}
				System.out.println("");
				break;
				
			case 4:
				System.out.println("Press 1- to display perticular AddressBook");
				System.out.println("Press 2- to display full AddressBook");
				 number1=scanner.nextInt();
				if(number1==1)
				{
					/*System.out.println("Enter the addressbook name");
					addressname = scanner.next();*/
					addressbookcontroller.display();
					
				}else if(number1==2){
					addressbookcontroller.addressDisplay();
				}else{
				System.out.println("Enter correct option");
				}
				System.out.println("");
				break;
				
			case 5:
				System.out.println("Enter the addressbook name to sort");
				addressname = scanner.next();
				System.out.println("Press 1-  to sort on name");
				System.out.println("Press 2-  to sort on zip");
				number1 = scanner.nextInt();
				if (number1 == 1) {
					addressbookcontroller.sortByName(addressname);
				} else if (number1 == 2) {
					addressbookcontroller.sortByZip(addressname);
				} else {
					System.out.println("press the correct number");
				}

				break;
			case 6:
				System.out.println("Enter the addressbook name to search");
				addressname = scanner.next();
				System.out.println("Press 1-  to search by name");
				System.out.println("Press 2-  to search by phonenumber");
				number1 = scanner.nextInt();
				if (number1 == 1) {
					addressbookcontroller.searchByName(addressname);
				} else if (number1 == 2) {
					addressbookcontroller.searchByPhoneNumber(addressname);
				} else {
					System.out.println("press the correct number");
				}

				break;
				

			}
		} while (number < 7);
		System.out.println("*************Address book closed*****************");

	}

}
