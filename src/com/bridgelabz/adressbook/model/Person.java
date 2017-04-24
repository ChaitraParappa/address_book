package com.bridgelabz.adressbook.model;

import java.io.Serializable;
import java.util.Comparator;

public class Person implements Serializable {
	  private static final long serialVersionUID = -8032093493591150109L;
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phonenumber;

	public String getFirstname() {
		return firstname;
	}

	@Override
	public String toString() {
		return "[name=" + firstname + " lastname=" + lastname + ","
				+ " address=" + address + "," + " city=" + city + ","
				+ " state=" + state + "," + " zip=" + zip + ","
				+ " phonenumber=" + phonenumber + "]";

	}

	public static Comparator<Person> PersonNameComparator = new Comparator<Person>() {

		public int compare(Person p1, Person p2) {
			String personName1 = p1.getFirstname();
			String personName2 = p2.getFirstname();

			return personName1.compareTo(personName2);

		}
	};
	public static Comparator<Person> personZipComparator = new Comparator<Person>() {
		public int compare(Person p1, Person p2) {
			int personzip1 = p1.getZip();
			int personzip2 = p2.getZip();
			return personzip1-personzip2;
		}
	};

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

}
