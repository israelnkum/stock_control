package com.israel;

import com.config.Base;
import com.config.FormatDisplay;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;

    @OneToOne
    private Vehicle vehicle;

    @Temporal(TemporalType.DATE)
    private Date joinedDate;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    //display individual user details
    public static Users getUserData(int id) {
        try (Session session = Base.getSession()) {
            session.beginTransaction();
            return session.get(Users.class, id);
        }
    }

    public static void allUsers() {
        try (Session session = Base.getSession()) {
            session.beginTransaction();
            FormatDisplay st = new FormatDisplay();
            @SuppressWarnings("unchecked")
            List<Users> usersList = session.createQuery("FROM Users").list();
            //functional operation


            st.setShowVerticalLines(true);
            st.setHeaders("ID", "Username");
            usersList.forEach((user) -> {
                st.addRow(Integer.toString(user.getId()),
                        user.getUsername());
            });

            st.print();

        }
    }

}

