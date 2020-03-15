package com.DAOS;

import com.JDBC.*;
import com.Beans.*;
import com.mysql.jdbc.PreparedStatement;
import java.rmi.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonDao {

    public boolean add(Person person) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {

                String sql = "insert into person(name, fname, age, gender, hobbies,userid,password, image)values(?,?,?,?,?,?,?,?)";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                smt.setString(1, person.getName());
                smt.setString(2, person.getFname());
                smt.setInt(3, person.getAge());
                smt.setString(4, person.getGender());

                smt.setString(5, person.getHobbies());
                smt.setString(6, person.getUserid());
                smt.setString(7, person.getPassword());
                smt.setString(8, person.getImage());

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Inserted!!");
                    cp.putConnection(con);
                    smt.close();
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
        return status;
    }

    public boolean removeById(int id) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from person where id=?";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                smt.setInt(1, id);

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return status;
    }

    public boolean remove(Person person) {
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "Delete from person where id=?";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                smt.setInt(1, person.getId());

                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Removed !!");
                }

                cp.putConnection(con);
                smt.close();

            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }

    public Person getById(int id) {
        Person person = null;

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person where id=?";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                smt.setInt(1, id);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setFname(rs.getString("fname"));
                    person.setAge(rs.getInt("age"));
                    person.setGender(rs.getString("gender"));
                    person.setHobbies(rs.getString("hobbies"));
                    person.setImage(rs.getString("image"));
                    person.setUserid(rs.getString("userid"));
                    person.setPassword(rs.getString("password"));
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return person;
    }

    public ArrayList<Person> getAllRecords() {
        ArrayList<Person> persons = new ArrayList();

        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = smt.executeQuery();
                while (rs.next()) {
                    Person person = new Person();
                    person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setFname(rs.getString("fname"));
                    person.setAge(rs.getInt("age"));
                    person.setGender(rs.getString("gender"));
                    person.setHobbies(rs.getString("hobbies"));
                    person.setImage(rs.getString("image"));
                    person.setUserid(rs.getString("userid"));
                    person.setPassword(rs.getString("password"));

                    persons.add(person);
                }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return persons;
    }
    public boolean isUseridExist(String userid){
        boolean status = false;
         try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {
                String sql = "select * from person where userid=?";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                smt.setString(1, userid);
                ResultSet rs = smt.executeQuery();
                if (rs.next()) {
                    status = true;
                    }
                cp.putConnection(con);
                smt.close();
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }

        return status;
    }
    public boolean update(Person person){
        boolean status = false;
        try {
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con != null) {

                String sql = "update person set name=?,fname=?,age=?,gender=?,hobbies=?,userid=?,password=?,image=? where id=?";
                PreparedStatement smt = (PreparedStatement) con.prepareStatement(sql);
                smt.setString(1, person.getName());
                smt.setString(2, person.getFname());
                smt.setInt(3, person.getAge());
                smt.setString(4, person.getGender());

                smt.setString(5, person.getHobbies());
                smt.setString(6, person.getUserid());
                smt.setString(7, person.getPassword());
                smt.setString(8, person.getImage());
                smt.setInt(9, person.getId());
                int n = smt.executeUpdate();
                if (n > 0) {
                    status = true;
                    System.out.println("Record Updated!!");
                    cp.putConnection(con);
                    smt.close();
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR" + e);
        }
        return status;
    
    }
    public ArrayList<Person> getRowsByLimit(int start,int end){
     ArrayList<Person> persons=new ArrayList();
    
          try{
            ConnectionPool cp = ConnectionPool.getInstance();
            cp.initialize();
            Connection con = cp.getConnection();
            if (con!=null){
                String sql = "select * from person limit ?,?";
                java.sql.PreparedStatement smt = con.prepareStatement(sql);
                smt.setInt(1, start);
                smt.setInt(2, end);
                
                ResultSet rs = smt.executeQuery();
                while(rs.next()){
                    Person person = new Person();
                    person=new Person();
                    person.setId(rs.getInt("id"));
                    person.setName(rs.getString("name"));
                    person.setFname(rs.getString("fname"));
                    person.setAge(rs.getInt("age"));
                    person.setGender(rs.getString("gender"));
                    person.setHobbies(rs.getString("hobbies"));
                    person.setImage(rs.getString("image"));
                    person.setUserid(rs.getString("userid"));
                    person.setPassword(rs.getString("password"));
                    
                    persons.add(person);
                }
               cp.putConnection(con);
               smt.close();
              }
         }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
 
    return persons; 
}

    public int getRecordCount(){
        int  total =0;
        try{
        ConnectionPool cp = ConnectionPool.getInstance();
        cp.initialize();
        Connection con = cp.getConnection();
    if (con!=null){
                String sql = "select count(*) from person ";
                java.sql.PreparedStatement smt = con.prepareStatement(sql);
                
                ResultSet rs = smt.executeQuery();
                if(rs.next()){
                     
                  total = rs.getInt(1);
                  System.out.println("total record:"+total);
                }
               cp.putConnection(con);
               smt.close();
              }
         }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
 
    return total; 
    }
    
    public static void main(String args[])
    {
        PersonDao pd = new PersonDao();
    }
       
}
