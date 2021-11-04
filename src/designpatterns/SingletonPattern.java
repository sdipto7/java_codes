/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatterns;

/**
 *
 * @author DIPTO
 */
class DataBaseConnection {
    
    private static DataBaseConnection db;
    
    private DataBaseConnection(){
        
    }
    
    public static DataBaseConnection getInstance(){
        if (db == null){
            db = new DataBaseConnection();
        }
        return db;
    }
    
    public String ExecuteQuery(String q){
        String result = ""; // executing query and creating result
        return result;
    }
    
}

class Main{
    public static void main(String[] args){
        DataBaseConnection db = DataBaseConnection.getInstance();
        String query = "";
        db.ExecuteQuery(query);
    }
}
