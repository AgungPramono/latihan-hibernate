/*
 * Silahkan digunakan dengan bebas / dimodifikasi
 * Dengan tetap mencantumkan nama @author dan Referensi / Source
 * Terima Kasih atas Kerjasamanya.
 */
package com.agung.java.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Personal
 */
public class MainHibernate {
    private static SessionFactory sessionFactory;
    public static void main(String[] args){
        
        sessionFactory = new Configuration().configure().buildSessionFactory();
        
        Person p = new Person();
        p.setNama("Arman");
        p.setAlamat("Jombang");
        p.setPhone("085235217669");
       
        Session session = sessionFactory.openSession();
        try{
            session.beginTransaction();//mulai lakukan transaksi
            session.save(p);//simpan data
            session.getTransaction().commit();//lakukan commit
        }catch(HibernateException he){
            he.printStackTrace();
            session.getTransaction().rollback();//jika gagal lakukan rollback
        }
        session.close();
        
        session = sessionFactory.openSession();
        Query query = session.createQuery("from Person");
        List<Person>persons = query.list();
        for(Person person : persons){
            System.out.println("id : "+person.getId());
            System.out.println("Nama : "+person.getNama());
            System.out.println("Alamat : "+person.getAlamat());
            System.out.println("No.Telepon : "+person.getPhone());
        }
        session.close();
        
        sessionFactory.close();
    }

}
