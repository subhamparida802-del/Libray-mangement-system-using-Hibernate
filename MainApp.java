package com.example;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {

    public static void main(String[] args) {

        
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Issue.class)
                .buildSessionFactory();

        
        Session session = factory.openSession();

        Transaction tx = session.beginTransaction();

    
        User u = new User( "Rahul",101);
        session.save(u);

        
        Book b = new Book("Java Programming", "James Gosling");
        session.save(b);
      
          Book b1 = new Book("Atomic Habits", "James Gosling");
        session.save(b1);
        
          Book b2 = new Book("Nation Built With Pride", "James Gosling");
        session.save(b2);
        
          Book b3 = new Book("Think likk Programmer", "James Gosling");
        session.save(b3);

          Book b4= new Book("Code with fun", "James Gosling");
        session.save(b4);
        
          Book b5 = new Book("Fun Loving", "James Gosling");
        session.save(b5);

        
        Issue issue = new Issue();
        issue.setUser(u);
        issue.setBook(b);
        issue.setIssueDate(new Date());

        session.save(issue);

        tx.commit();

        session.close();
        factory.close();

        System.out.println("Data Inserted Successfully");
    }
}