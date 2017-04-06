/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sqeteam.sqerecruitment.action;

import com.sqeteam.sqerecruitment.hibernate.HibernateUtil;
import com.sqeteam.sqerecruitment.pojo.EmploymentLevels;
import org.hibernate.Session;

/**
 *
 * @author Dinuzhka
 */
public class WelcomeUserAction {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // all struts logic here
    public String execute() {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        EmploymentLevels em = new EmploymentLevels("emlevel");
        session.save(em);
        
        session.getTransaction().commit();
        session.close();

        return "SUCCESS";
        
      
        

    }
}
