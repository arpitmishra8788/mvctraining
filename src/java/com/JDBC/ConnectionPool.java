
package com.JDBC;
import java.sql.*;
import java.util.*;


public class ConnectionPool {
    static final int MAX_CONNECTIONS = 20;
    static Vector Connections = null;
    static ConnectionPool instance = null;
    
    public synchronized void removeAllConnections(){
        try{
            if(Connections == null){
                return;
            }
            int sz = Connections.size();
            for(int i =0; i< sz; i++){
                Connection c = (Connection) Connections.elementAt(i);
                c.close();
            }
            Connections.removeAllElements();
            Connections = null;
        }
            catch(Exception sqlE)
                    {
                      System.out.println(sqlE);
                    }
        }
    public synchronized void initialize(){
       
            if(Connections == null)
                try{
                    String username = "root";
                    String password = "arpit";
                    String url = "jdbc:mysql://localhost:3306/store";
                    Class.forName("com.mysql.jdbc.Driver");
                    
                    Connections = new Vector();
                    int count = 0;
                    while(count <MAX_CONNECTIONS){
                        Connection c = DriverManager.getConnection(url,username,password );
                        Connections.addElement(c);
                        count++;
                    }
                }
            catch(Exception e)
                    {
                      System.out.println(e);
                    }
        }
        public synchronized Connection getConnection(){
            Connection c =null;
            if(Connections == null){
                return null;
                }
           if(Connections.size()> 0){
               c = (Connection) Connections.elementAt(0);

                    }
           return c;
        }
        public synchronized void putConnection(Connection c){
            Connections.addElement(c);
            notifyAll();
        }
        public static synchronized ConnectionPool getInstance(){
            if( instance == null){
                instance = new ConnectionPool();
            }
            return instance;
        }
            
    }

