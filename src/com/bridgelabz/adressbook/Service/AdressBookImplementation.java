package com.bridgelabz.adressbook.Service;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import com.bridgelabz.adressbook.model.Person;

public class AdressBookImplementation implements AddressBook {
	Scanner scanner = new Scanner(System.in);
	int number;
	int temp=0;

	ArrayList<Person> arraylist = null;
	HashMap<String, ArrayList<Person>> hashmap1 = new HashMap<String, ArrayList<Person>>();

	public void add(String addressname) throws Exception {
		
		HashMap<String, ArrayList<Person>> hashmap = fileread();

		Person person = new Person();

		System.out.println("Enter the name");
		String firstname = scanner.next();
		person.setFirstname(firstname);

		System.out.println("Enter the last name");
		String lastname = scanner.next();
		person.setLastname(lastname);

		System.out.println("Enter the address");
		String address = scanner.next();
		person.setAddress(address);

		System.out.println("Enter the city");
		String city = scanner.next();
		person.setCity(city);

		System.out.println("Enter the State");
		String state = scanner.next();
		person.setState(state);

		System.out.println("Enter the zip");
		int zip = scanner.nextInt();
		person.setZip(zip);

		System.out.println("Enter the phonenumber");
		long phonenumber = scanner.nextLong();
		person.setPhonenumber(phonenumber);

		if (hashmap.get(addressname) == null)
			hashmap.put(addressname, new ArrayList<Person>());
		hashmap.get(addressname).add(person);

		filewrite(hashmap);

		System.out.println("");
		System.out.println("****************Successfully Added****************");
		System.out.println("");

	}

	private void filewrite(HashMap<String, ArrayList<Person>> hashmap)
			throws IOException {
		
		FileOutputStream fos = new FileOutputStream("/home/bridgelabz6/javaprograms/AddressBook_Proj/src/com/bridgelabz/adressbook/main/map.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(hashmap);
		oos.flush();
		oos.close();
	}

	private HashMap<String, ArrayList<Person>> fileread() throws IOException,
			ClassNotFoundException {

		FileInputStream fis = new FileInputStream("/home/bridgelabz6/javaprograms/AddressBook_Proj/src/com/bridgelabz/adressbook/main/map.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		HashMap<String, ArrayList<Person>> hashmap = (HashMap<String, ArrayList<Person>>) ois.readObject();

		return hashmap;

	}

	public void edit(String addressname) throws ClassNotFoundException,IOException {
		
		HashMap<String, ArrayList<Person>> hashmap = fileread();

		System.out.println(hashmap.get(addressname));
		
		Person person1 = null;
		
		ArrayList<Person> arraylist1 = hashmap.get(addressname);
		System.out.println("Enter the first name");
		String firstname = scanner.next();
		System.out.println("Enter the Last name");
		String lastname = scanner.next();

		for (int i = 0; i < arraylist1.size(); i++) {
			System.out.println(arraylist1.size());
			person1 = arraylist1.get(i);

			if (firstname.equals(person1.getFirstname())
					&& lastname.equals(person1.getLastname())) {
				display(arraylist1.get(i));

				System.out.println("What u have to update");
				do {
					System.out.println("1-Firstname");
					System.out.println("2-Lastname");
					System.out.println("3-Address");
					System.out.println("4-City");
					System.out.println("5-State");
					System.out.println("6-Zip");
					System.out.println("7-Phonenumber");
					System.out.println("8-To Exit");
					number = scanner.nextInt();
					switch (number) {
					case 1:
						System.out.println("Enter the new name");
						String newfirstname = scanner.next();
						person1.setFirstname(newfirstname);
						break;

					case 2:
						System.out.println("Enter the new name");
						String newlastname = scanner.next();
						person1.setLastname(newlastname);
						break;

					case 3:
						System.out.println("Enter the new adress");
						String newaddress = scanner.next();
						person1.setAddress(newaddress);
						break;

					case 4:
						System.out.println("Enter the new city");
						String newcity = scanner.next();
						person1.setCity(newcity);
						break;
					case 5:
						System.out.println("Enter the new State");
						String newstate = scanner.next();
						person1.setState(newstate);
						break;

					case 6:
						System.out.println("Enter the new zip");
						int newzip = scanner.nextInt();
						person1.setZip(newzip);
						break;

					case 7:
						System.out.println("Enter the new phonenumber");
						long newphonenumber = scanner.nextLong();
						person1.setPhonenumber(newphonenumber);
						break;
					}
				} while (number < 8);

				filewrite(hashmap);

			}
		}
		System.out
				.println("****************Successfully Edited****************");
		System.out.println("");

	}

	public void delete(String adressname) throws ClassNotFoundException,
			IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();

		Person person1 = null;
		ArrayList<Person> arraylist1 = hashmap.get(adressname);
		System.out.println(arraylist1);
		System.out.println("Enter the First name");
		String firstname = scanner.next();
		System.out.println("Enter the Last name");
		String lastname = scanner.next();

		for (int i = 0; i < arraylist1.size(); i++) {
			person1 = arraylist1.get(i);
			display(person1);

			if (firstname.equals(person1.getFirstname())
					&& lastname.equals(person1.getLastname())) {
				arraylist1.remove(person1);
			}

			System.out.println(hashmap);
			System.out.println("");
			filewrite(hashmap);

			System.out
					.println("****************Successfully Deleted****************");
			System.out.println("");
		}

	}

	private void display(Person person1) throws IOException,
			ClassNotFoundException {

		System.out
				.println("---------------------------------------------------------------------------------------------");
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", "SL.NO",
				"FirstName", "LastName", "Address", "City", "State", "Zip",
				"PhoneNumber");
		System.out
				.println("---------------------------------------------------------------------------------------------");
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", temp,
				person1.getFirstname(), person1.getLastname(),
				person1.getAddress(), person1.getCity(), person1.getState(),
				person1.getZip(), person1.getPhonenumber());
		System.out.println("");

	}

	public void sortName(String addressname) throws ClassNotFoundException,
			IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();
		ArrayList<Person> arraylist1 = hashmap.get(addressname);
		Collections.sort(arraylist1, Person.PersonNameComparator);
		int j = 1;
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", "SL.NO",
				"FirstName", "LastName", "Address", "City", "State", "Zip",
				"PhoneNumber");
		System.out
				.println("---------------------------------------------------------------------------------------------");

		for (Person person1 : arraylist1) {
			System.out.printf(
					"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", j,
					person1.getFirstname(), person1.getLastname(),
					person1.getAddress(), person1.getCity(),
					person1.getState(), person1.getZip(),
					person1.getPhonenumber());
			j++;
		}
		System.out.println("");

	}

	public void sortZip(String addressname) throws ClassNotFoundException,
			IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();
		ArrayList<Person> arraylist1 = hashmap.get(addressname);
		Collections.sort(arraylist1, Person.personZipComparator);

		int j = 1;
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", "SL.NO",
				"FirstName", "LastName", "Address", "City", "State", "Zip",
				"PhoneNumber");
		System.out
				.println("---------------------------------------------------------------------------------------------");

		for (Person person1 : arraylist1) {
			System.out.printf(
					"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", j,
					person1.getFirstname(), person1.getLastname(),
					person1.getAddress(), person1.getCity(),
					person1.getState(), person1.getZip(),
					person1.getPhonenumber());
			j++;
		}
		System.out.println("");

	}

	public void addressDisplay() throws IOException, ClassNotFoundException {

		HashMap<String, ArrayList<Person>> hashmap = fileread();
		System.out.println(hashmap);

		for (String key : hashmap.keySet()) {
			System.out
					.println("----------------------------------------------------------------------------------------------");
			System.out.println("                                       " + key);
			System.out
					.println("----------------------------------------------------------------------------------------------");
			ArrayList<Person> arraylist1 = hashmap.get(key);
			System.out.printf(
					"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ",
					"SL.NO", "FirstName", "LastName", "Address", "City",
					"State", "Zip", "PhoneNumber");
			System.out
					.println("---------------------------------------------------------------------------------------------");

			for (int j = 0; j < arraylist1.size(); j++) {
				Person person1 = arraylist1.get(j);

				System.out.printf(
						"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ",
						(j + 1), person1.getFirstname(), person1.getLastname(),
						person1.getAddress(), person1.getCity(),
						person1.getState(), person1.getZip(),
						person1.getPhonenumber());
				temp++;
			}
		}

		System.out
				.println("*********************************************************************************************");
		System.out.println("");

	}

	public void deleteAddressBook(String addressname)
			throws ClassNotFoundException, IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();

		if (hashmap.containsKey(addressname)) {
			hashmap.remove(addressname);
		} else {
			System.out.println("key not present");
		}

		System.out.println(hashmap);
		System.out.println("");
		filewrite(hashmap);

		System.out
				.println("****************Successfully Deleted****************");
		System.out.println("");
	}

	public void display() throws ClassNotFoundException,
			IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();
		/*for(int i=0;i<hashmap.size();i++)
		{
			System.out.print(hashmap.)
		}*/
		Set<String> keys = hashmap.keySet();
		System.out.println("The adressbook names are: ");
		for(String key: keys){
			System.out.print(key+" ");
		}
		System.out.println();
		System.out.println("Enter the addressbook name");
		String addressname = scanner.next();
		Person person1 = null;
		System.out
				.println("---------------------------------------------------------------------------------------------");
		System.out
				.println("                                    " + addressname);
		System.out
				.println("---------------------------------------------------------------------------------------------");
		System.out.printf(
				"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ", "SL.NO",
				"FirstName", "LastName", "Address", "City", "State", "Zip",
				"PhoneNumber");
		System.out
				.println("---------------------------------------------------------------------------------------------");

		ArrayList<Person> arraylist1 = hashmap.get(addressname);
		for (int i = 0; i < arraylist1.size(); i++) {
			person1 = arraylist1.get(i);

			System.out.printf(
					"%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n ",
					(i + 1), person1.getFirstname(), person1.getLastname(),
					person1.getAddress(), person1.getCity(),
					person1.getState(), person1.getZip(),
					person1.getPhonenumber());

		}
		System.out.println("");

	}

	public void searchByName(String addressname) throws ClassNotFoundException,
			IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();
		ArrayList<Person> arraylist1 = hashmap.get(addressname);

		System.out.println("Enter the name to search");
		String firstname = scanner.next();
		for (int i = 0; i < arraylist1.size(); i++) {
			Person person1 = arraylist1.get(i);

			if (person1.getFirstname().equalsIgnoreCase(firstname)) {
				display(person1);
			}
		}
		System.out.println("");
	}

	public void searchByPhoneNumber(String adressname)
			throws ClassNotFoundException, IOException {
		HashMap<String, ArrayList<Person>> hashmap = fileread();
		ArrayList<Person> arraylist1 = hashmap.get(adressname);

		System.out.println("Enter the phonenumber to search");
		Long phonenumber = new Long(scanner.nextLong());
		for (int i = 0; i < arraylist1.size(); i++) {
			Person person1 = arraylist1.get(i);
			Long phonenumber1 = new Long(person1.getPhonenumber());
			int res = phonenumber1.compareTo(phonenumber);
			if (res == 0) {
				display(person1);
			}

		}
		System.out.println("");
	}
}
