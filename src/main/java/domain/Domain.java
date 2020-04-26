package domain;

import buisnesslogic.HibernateUtill;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Domain {
    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("GER");
        address.setCity("Munchen");
        address.setStreet("Hoffenhime");
        address.setPost_code("4561237");

        Project project = new Project();
        project.setTitle("Ok!!!!");

        Employee employee = new Employee();
        employee.setFirst_name("Frank");
        employee.setLast_name("Ribery");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1876,Calendar.APRIL,8);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

        Set<Project> projectSet = new HashSet<Project>();
        projectSet.add(project);
        employee.setProjects(projectSet);


        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

        Address address1 = addressService.getById(1L);
        System.out.println(address1);

        HibernateUtill.shutDown();


    }
}
