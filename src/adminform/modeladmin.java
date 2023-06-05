/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminform;

public class modeladmin {
    private static String sql = null;
    private static String sqltabel = null;
    private static String id = null;
    public static void setSQL(String SQL){
        sql = SQL;
    }
    public static String getSQL(){
    return sql;
    } 
    public static void setSQLtabel(String SQLtabel){
    sqltabel = SQLtabel;
    }
    public static String getSQLtabel(){
    return sqltabel;
    }
    public static void setId(String ID){
    id = ID;
    }
    public static String getID(){
    return id;
    }
    
}
