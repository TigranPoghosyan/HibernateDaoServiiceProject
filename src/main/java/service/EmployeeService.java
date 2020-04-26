package service;

import BuisnessLogic.SessionUtill;
import dao.EmployeeDao;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService extends SessionUtill implements EmployeeDao {

    public void add(Employee employee) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        closeTransactionSession();


    }

    public List<Employee> getAll() throws SQLException {

        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE";

        Session session = getSession();
        NativeQuery query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        closeTransactionSession();
        return employeeList;
    }

    public Employee getById(Long id) throws SQLException {

        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";
        Session session = getSession();
        NativeQuery query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id",id);

        Employee employee = (Employee) query.getSingleResult();

        closeTransactionSession();

        return null;
    }

    public void update(Employee employee) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        closeTransactionSession();

    }

    public void remove(Employee employee) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        closeTransactionSession();


    }
}
