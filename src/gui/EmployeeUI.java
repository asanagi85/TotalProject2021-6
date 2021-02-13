package gui;

import service.EmployeeManger;
import service.Manager;
import vo.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeUI implements UI{
    Scanner scanner;
    Manager manager;

    public EmployeeUI() {
        scanner = new Scanner(System.in);
        manager = new EmployeeManger();

        while(true){
            printMainMenu();
            String select = scanner.nextLine();

            switch (select){
                case "1":
                    insertEmployee();
                    break;
                case "2":
                    findEmployee();
                    break;
                case "3":
                    deleteEmployee();
                    break;
                case "4":
                    manager.showAll();
                    break;
                case "9":
                    System.out.println("Exit this application.");
                    System.out.println("Data will be saved the place.");
                    manager.saveFile();
                    System.exit(0);
            }
        }
    }

    @Override
    public void printMainMenu() {
        System.out.println("===================================");
        System.out.println("========[KIta emp manage app]======");
        System.out.println("===================================");
        System.out.println("1. add new emp");
        System.out.println("2. find emp");
        System.out.println("3. delete emp");
        System.out.println("4. show all emp");
        System.out.println("9. exit");
        System.out.println("===================================");
        System.out.println("select menu : ");
    }

    @Override
    public void insertEmployee() {
        System.out.println("===================================");
        System.out.println("========[KIta emp manage app]======");
        System.out.println("===================================");
        System.out.println("1. emp ID : " + Employee.serial + 1);
        System.out.println("2. emp name : ");
        String name = scanner.nextLine();

        System.out.println("3. emp salary : ");
        int salary = scanner.nextInt();

        ArrayList<String> license = new ArrayList<String>();
        while (true) {
            Scanner scnForLicense = new Scanner(System.in);
            System.out.println("4. emp license >>> ");
            String temp = scnForLicense.nextLine();

            if (temp.length() == 0) {
                break;
            }
            license.add(temp);
        }
        Employee employee = new Employee(name,salary,license);
    }

    @Override
    public void findEmployee() {
        System.out.println("input emp ID you want : ");
        String eid = scanner.nextLine();

        Employee resultEmp = manager.findEmployee(eid);
        System.out.println(resultEmp);
    }

    @Override
    public void deleteEmployee() {
        System.out.println("input emp ID you want to delete : ");
        String eid = scanner.nextLine();
        Employee resultEmp = manager.findEmployee(eid);
        if(resultEmp == null){
            System.out.println("there is no emp who you find.");
        }
        else{
            System.out.println("are you sure delete this emp?(Y/N)");
            String answer = scanner.nextLine();

            if(answer.equalsIgnoreCase("y")){
                manager.deleteEmployee(eid);
                return;
            }
            else{
                System.out.println("delete process canceled.");
            }
        }

    }
}
