package com.bridgelabz.csvjson;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class AddressBookMainTest {
	@Test
	public void given_Contacts_Should_Write_To_A_File() {
		Address[] contacts = {
				new Address("Jitu", "Patel", "Lunawas Khara", "Jodhpur", "Rajasthan", "342014", "9636638082","jitu@gmail.com"),
				new Address("Ram", "Narayan", "Jhanwar", "Jodhpur", "Rajasthan", "342001", "9571908082","ram@gmail.com") };
		ArrayList<Address> arraylist = new ArrayList<>();
		arraylist.add(contacts[0]);
		arraylist.add(contacts[1]);
		AddressBookMain addressBook = new AddressBookMain();
		addressBook.writeData(arraylist);
		long entries = addressBook.countEntries();
		Assert.assertEquals(2, entries);

	}

	@Test
	public void given_Contacts_Should_Read_A_File_And_Give_Count() {
		Address[] contacts = {
				new Address("Jitu", "Patel", "Lunawas Khara", "Jodhpur", "Rajasthan", "342014", "9636638082","jitu@gmail.com"),
				new Address("Ram", "Narayan", "Jhanwar", "Jodhpur", "Rajasthan", "342001", "9571908082","ram@gmail.com") };
		ArrayList<Address> arraylist = new ArrayList<>();
		arraylist.add(contacts[0]);
		arraylist.add(contacts[1]);
		AddressBookMain addressBook = new AddressBookMain();
		addressBook.writeData(arraylist);
		long entries = addressBook.readData(arraylist);
		Assert.assertEquals(2, entries);

	}

	@Test
	public void writeInto_CSVFileShouldReturnTotalCountTrue() throws IOException {
		Address addr1 = new Address("Jitu", "Patel", "Lunawas Khara", "Jodhpur", "Rajasthan", "342014", "9636638082","jitu@gmail.com");
		Address addr2 = new Address("Ram", "Narayan", "Jhanwar", "Jodhpur", "Rajasthan", "342001", "9571908082","ram@gmail.com");
		ArrayList<Address> addressBook = new ArrayList<>();
		addressBook.add(addr1);
		addressBook.add(addr2);
		int count = AddressBookMain.writeCsv(addressBook);
		Assert.assertEquals(2, count);
	}

	@Test
	public void readCSVFileShouldReturnTotalCountTrue() throws IOException {
		int count = AddressBookMain.readCsv();
		Assert.assertEquals(2, count);
	}
	
	@Test
	public void writeInto_JSONFileShouldReturnTotalCountTrue() throws IOException {
		Address addr1 = new Address("Jitu", "Patel", "Lunawas Khara", "Jodhpur", "Rajasthan", "342014", "9636638082","jitu@gmail.com");
		Address addr2 = new Address("Ram", "Narayan", "Jhanwar", "Jodhpur", "Rajasthan", "342001", "9571908082","ram@gmail.com");
		ArrayList<Address> addressBook = new ArrayList<>();
		addressBook.add(addr1);
		addressBook.add(addr2);
		int count = AddressBookMain.writeJson(addressBook);
		Assert.assertEquals(2, count);
	}
	
	@Test
	public void readJSONFileShouldReturnTotalCountTrue() throws IOException {
		int count = AddressBookMain.readJson();
		Assert.assertEquals(2, count);
	}
}
