package com.bridgelabz.adressbook.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.bridgelabz.adressbook.Service.AddressBook;
import com.bridgelabz.adressbook.Service.AdressBookImplementation;
import com.bridgelabz.adressbook.model.Person;

public class AddressBookController {
	
	AddressBook addressbook=new AdressBookImplementation();

	/**
	 * the method to add the address to the addressbook 
	 * @param adressname
	 * the addressname
	 * @throws Exception 
	 */
	public void add(String addressname) throws Exception {
		
		addressbook.add(addressname);
		
	}

	/**
	 * the method to edit the address in the addressbook
	 * @param addressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void edit(String addressname) throws ClassNotFoundException, IOException {
		addressbook.edit(addressname);
	}

	/**
	 * the method to delete the address from the addressbook
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void delete(String addressname) throws ClassNotFoundException, IOException {
		addressbook.delete(addressname);
		
	}

	/**
	 * the method to sort the address by the name
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void sortByName(String addressname) throws ClassNotFoundException, IOException {
		addressbook.sortName( addressname);		
	}

	/**
	 * the method to sort the address by the zip
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void sortByZip(String addressname) throws ClassNotFoundException, IOException {
		addressbook.sortZip(addressname);
	}

	/**
	 * the method to diaplay the addressbook
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 * @throws FileNotFoundException 
	 */
	public void addressDisplay() throws FileNotFoundException, ClassNotFoundException, IOException {
		addressbook.addressDisplay();
		
	}

	/**
	 * the method to delete the perticular addressbook
	 * @param addressname the addressbookname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void deleteAdressBook(String addressname) throws ClassNotFoundException, IOException {
		addressbook.deleteAddressBook(addressname);
	}

	/**
	 * the method to display the perticular addressbook
	 * @param addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void display() throws ClassNotFoundException, IOException {
		addressbook.display();
	}

	/**
	 * the method to search the perticular address by name
	 * @param addressname the addressbook name
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void searchByName(String addressname) throws ClassNotFoundException, IOException {
		addressbook.searchByName(addressname);
	}

	/**
	 * the method to search the perticular address by phonenumber
	 * @param addressname the addressbook name
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public void searchByPhoneNumber(String addressname) throws ClassNotFoundException, IOException {
		addressbook.searchByPhoneNumber(addressname);
		
	}
	
	
	
	

}
