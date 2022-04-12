package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {
	public static void main(String[] Args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Employee> employee = new ArrayList<>();
		
		System.out.printf("How manu employees will be registered? ");
		int N = sc.nextInt();
		
		for (int i = 0; i<N ; i++) {
			System.out.println("Employee #" + (i+1));
			System.out.printf("Id: ");
			Integer id = sc.nextInt();
			while (hasID(employee, id)) {
				System.out.println("Id already taken! Try again");
				id = sc.nextInt();
			}
			System.out.printf("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.printf("Salary: ");
			Double salary = sc.nextDouble();
			System.out.println("");
			
			Employee emp = new Employee(id, name, salary);
			
			employee.add(emp);
		}
		
		System.out.printf("Enter the employee id that will have salary increase: ");
		int idSalary = sc.nextInt();
		Integer pos = position(employee, idSalary);
		if (pos == null) {
			System.out.println("This id does not exist!");

		}
		else {
			System.out.printf("Enter the percentage: ");
			double percent = sc.nextDouble();
			employee.get(pos).increaseSalary(percent);			
		}
		
		System.out.println("\nList of employees:");
		for(Employee e : employee) {
			System.out.println(e);
		}
		
				/*Employee emp = employee.stream().filter( x -> x.getId() == idSalary).findFirst().orElse(null);
				
				if (emp == null) {
					System.out.println("This id does not exist!");
				}
				else {
					System.out.println("Enter the percentage:");
				}*/
		
		sc.close();
	}
	
	public static Integer position(List<Employee> list, int id){
		for(int i = 0; i<list.size(); i++) {
			if (list.get(i).getId() == id) {
				return i;
			}
		}
		return null;	
	}
	
	public static boolean hasID(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
	
}
