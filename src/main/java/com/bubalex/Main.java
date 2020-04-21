package com.bubalex;

import com.bubalex.entity.Library;
import com.bubalex.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Library library = new Library();
        library.setName("Number 1");
        library.setAdress("Number 1");
        Library library2 = new Library();
        library2.setName("Number 2");
        library2.setAdress("Number 2");
        session.save(library);
        library.setAdress("ADdress 2");
        session.save(library);
        session.save(library2);
        session.getTransaction().commit();

        session.beginTransaction();
        List libraryList = session
                .createQuery("from Library where name='Number 1'")
                .list();
        session.getTransaction().commit();

        session.close();
    }
}
