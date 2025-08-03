package org.nikhil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HbmManager {
    private Configuration configuration;
    private SessionFactory sessionfactory;
    private Session session;
    private Transaction transaction;

    public void Initialise_Session_Transaction(){
        this.setSessionfactory(this.getConfiguration().buildSessionFactory());
        this.setSession(this.getSessionfactory().openSession());
        this.setTransaction(this.getSession().beginTransaction());
    }

    public void AddEntityClass(Class<?> entityClass){
        this.configuration.addAnnotatedClass(entityClass);
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public SessionFactory getSessionfactory() {
        return sessionfactory;
    }

    public void setSessionfactory(SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
