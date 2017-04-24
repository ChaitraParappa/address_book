package com.bridgelabz.adressbook.Service;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.bridgelabz.adressbook.model.Person;

public interface AddressBook {

	/**
	 * the method to add address to the adressbook
	 * @param adressname 
	 * the addressname
	 * @throws FileNotFoundException 
	 * @throws Exception 
	 */
	void add(String addressname) throws Exception;

	/**
	 * the method to edit the data in the adressbook
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void edit(String addressname) throws ClassNotFoundException, IOException;

	/**
	 * the method to delete the address from the adressbook
	 * @param adressname
	 * the adressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void delete(String addressname) throws ClassNotFoundException, IOException;

	/**
	 * the method to sort the address by the name
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void sortName(String addressname) throws ClassNotFoundException, IOException;

	/**
	 * the method to sort the address by the zip
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void sortZip(String addressname) throws ClassNotFoundException, IOException;

	/**
	 * the method to display the addressbook
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void addressDisplay() throws FileNotFoundException, IOException, ClassNotFoundException;

	/**
	 * the method to delete the perticular addressbook
	 * @param adressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void deleteAddressBook(String addressname) throws ClassNotFoundException, IOException;

	/**
	 * the method to delete the perticular addressbook
	 * @param adressname
	 * the addressname
	 * @throws IOException s
	 * @throws ClassNotFoundException 
	 */
	void display() throws ClassNotFoundException, IOException;

	/**
	 * the method to search the address by name
	 * @param addressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void searchByName(String addressname) throws ClassNotFoundException, IOException;

	/**
	 * the method to search the address by phonenumber
	 * @param addressname
	 * the addressname
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	void searchByPhoneNumber(String addressname) throws ClassNotFoundException, IOException;
}
