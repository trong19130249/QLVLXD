package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DataSignupSignin {
	final String URLFile = "src/dataSignup.txt";

	public void writeFile(Customer customer) {
		File file = null;
		FileOutputStream fileOutputStream = null;
		String data = convertToString(readFile())+"\n"+customer.toWrite();
		
		try {
			file = new File(URLFile);
			fileOutputStream = new FileOutputStream(file);
			// create file if not exists
			if (!file.exists()) {
				file.createNewFile();
			}
			// fetch bytes from data
			byte[] bs = data.getBytes();

			fileOutputStream.write(bs);
			fileOutputStream.flush();
			fileOutputStream.close();
			System.out.println("File written successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<Customer> readFile() {

		File file = new File(URLFile);

		InputStream inputStream;
		ArrayList<Customer> result = new ArrayList<Customer>();
		try {
			inputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader reader = new BufferedReader(inputStreamReader);
			String line = "";

			while ((line = reader.readLine()) != null) {
				String[] arr = line.split("#");
				Customer cus = new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);
				result.add(cus);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	public String convertToString(ArrayList<Customer> arr) {
		String result = "";
		for (int i = 0; i < arr.size(); i++) {
			result +=arr.get(i).toWrite();
			if (i<arr.size()-1) {
				result+="\n";
			}
		}
		
		return result;
	}
	public boolean signup(Customer customer) {
		ArrayList<Customer> array = readFile();
		for (int i = 0; i < array.size(); i++) {
			Customer e = array.get(i);
			if (customer.getUserName().equals(e.getUserName())) {
				return false;
			}
		}
		writeFile(customer);
		return true;
		
	}
	public boolean signin(String userName, String password) {
		ArrayList<Customer> array = readFile();
		for (int i = 0; i < array.size(); i++) {
			Customer e = array.get(i);
			if (userName.equals(e.getUserName())&&password.equals(e.getPassword())) {
				return true;
			}
		}
		return false;
		
	}
	public static void main(String[] args) {
		DataSignupSignin s = new DataSignupSignin();
		Customer cus = new Customer("b", "123", "e@gmail.com", "ass", "nam", "091", "TP");
//		System.out.println(s.readFile());
		
//		System.out.println(s.signup(cus));
		System.out.println(s.signin("a", "1123"));
//		System.out.println(s.readFile("src/dataSignup.txt"));
	}
}
