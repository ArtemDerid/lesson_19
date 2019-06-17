package ua.lviv.lgs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Methods {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File file = new File("serializedEmployee.txt");
		Employee employee = new Employee("Tomas", 1, 4300.00);
		
		System.out.println(employee);
		
		serialize(employee, file);
		System.out.println(deserialize(file));
		System.out.println();
		
		File file1 = new File("serializedEmployee1.txt");
		List<Employee> listOfEmployees = new ArrayList<>();
		listOfEmployees.add(employee);
		listOfEmployees.add(new Employee("Frank", 2, 2800));
		listOfEmployees.add(new Employee("Bill", 3, 3800));
		listOfEmployees.add(new Employee("Fill", 4, 2500));
		listOfEmployees.add(new Employee("Anna", 5, 3700));
		listOfEmployees.add(new Employee("Lily",6, 1500));
		System.out.println(listOfEmployees);
		
		serialize((Serializable) listOfEmployees, file1);
		System.out.println(deserialize(file1));
		
	}

	public static void serialize(Serializable object, File file) throws IOException {
		OutputStream os = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(object);
		oos.close();
		os.close();
	}

	public static Serializable deserialize(File file) throws IOException, ClassNotFoundException {
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		Serializable object = (Serializable) ois.readObject();
		ois.close();
		is.close();

		return object;
	}

}
