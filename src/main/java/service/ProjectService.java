package service;

import BuisnessLogic.SessionUtill;
import dao.ProjectDao;
import entity.Address;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import java.sql.SQLException;
import java.util.List;

public class ProjectService extends SessionUtill implements ProjectDao {


    public void add(Project project) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.save(project);

        closeTransactionSession();

    }

    public List<Project> getAll() throws SQLException {

        openTransactionSession();

        String sql = "SELECT * FROM PROJECT";

        Session session = getSession();
        NativeQuery query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.list();


        closeTransactionSession();

        return projectList;
    }

    public Address getById(Long id) throws SQLException {

        openTransactionSession();

        String sql = "SELECT * FROM PROJECT WHERE ID = :id";
        Session session = getSession();
        NativeQuery query = session.createNativeQuery(sql).addEntity(Project.class);
        query.setParameter("ID",id);
        Address address = (Address) query.getSingleResult();

        closeTransactionSession();

        return address;
    }

    public void update(Project project) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.update(project);

        closeTransactionSession();

    }

    public void remove(Project project) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        closeTransactionSession();

    }
}
