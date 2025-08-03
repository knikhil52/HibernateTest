package org.nikhil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Properties;

public class Main {
    private static Properties getProperties() {
        Properties mysql_properties= new Properties();
        mysql_properties.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        mysql_properties.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/rdb");
        mysql_properties.setProperty("hibernate.connection.username", "user");
        mysql_properties.setProperty("hibernate.connection.password", "password");
        mysql_properties.setProperty("hibernate.hbm2ddl.auto", "update");
        //mysql_properties.setProperty("hibernate.show_sql", "true");
        return mysql_properties;
    }

    public static void main(String[] args) {
        HbmManager orm=new HbmManager();

        orm.setConfiguration(new Configuration().setProperties(getProperties()));
        orm.AddEntityClass(org.nikhil.Student.class);
        orm.Initialise_Session_Transaction();

        Session session = orm.getSession();
        Transaction transaction = orm.getTransaction();

        //Student st4=session.get(Student.class,6);
        List<Student> st5=session.createQuery("from Student where name like :name",Student.class).setParameter("name","%Nikhil%").getResultList();
        st5.forEach(System.out::println);

    }
}