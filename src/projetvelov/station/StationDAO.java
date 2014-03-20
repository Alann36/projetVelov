/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetvelov.station;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Damien
 */
public class StationDAO extends DAO<Station> {
    private static StationDAO instance=null;
    
    private StationDAO(Connection conn){
        super(conn);
    }

    public static StationDAO getInstance(Connection conn){
       if(instance == null)
           instance = new StationDAO(conn);
       return instance;
    }
    
  public boolean create(Station obj) {
                return false;
        }

        public boolean delete(Station obj) {
                return false;
        }

        public Station find(int id) {
                
                Station station = new Station();                
                
                try {
                        ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
                        if(result.first())
                          station=null;//station = new Station(id, result.getString("elv_nom"), result.getString("elv_prenom"));
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return station;
        }

        public boolean update(Station obj) {
                return false;
        }
    
    
}
