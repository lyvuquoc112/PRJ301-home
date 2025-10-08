/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.huylvq.shop.watcher.dao;
import com.huylvq.shop.watcher.model.Account;
import jakarta.persistence.*;
/**
 *
 * @author hanly
 */
public class AccountDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("watcherManager"); // quan li cac model trong project
    
    public void create(Account acc){
        EntityManager em = emf.createEntityManager();
        // tao em tu emf. emf nhu la mot cai xuong, con em la san pham.
        // Nen facotry tao san pham
        
        EntityTransaction tx = em.getTransaction();
        //tao transaction
        
        try {
            tx.begin(); // transaction bat dau tu day
            em.persist(acc); // JPD: persist, merge, remove ->phai commit
                                // persist la create hay insert
                                // merge la update
                                // remove la delete
                                // chay thu truoc, neu success thi commit
            tx.commit();
        } catch (Exception e) {
            if(tx.isActive()) tx.rollback(); // neu fail thi rollback,  tro ve truoc khi  cau lenh bat dau
            e.printStackTrace();
        }finally{
            em.close();
        }
    }

    // Truy xuat du lieu, co thi tra, khong co thi tra ve null
    public Account findByUsername(String username){
        EntityManager em = emf.createEntityManager();
        try {
           return em.createQuery("SELECT a From Account a WHERE a.username =:u",Account.class) // tao cau lenh truy van
                   .setParameter("u",username ) // :u la tham so, setParameter la chuyen tham so vao
                   .getResultStream() // no tra ve du lieu, cau lenh nay la lum du lieu do ra
                   .findFirst() // lay thg dau tien thoa man thoi
                   .orElse(null); // neu khong lum duoc thg dau tien thi tra ve null
        
        } finally {
            em.close();
        }
    }
}
