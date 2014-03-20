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
public class ArrondissementVilleDAO extends DAO<ArrondissementVille> {


    public ArrondissementVilleDAO(Connection conn) {
       
        
        super(conn);
    }

  public boolean create(ArrondissementVille obj) {
                return false;
        }

        public boolean delete(ArrondissementVille obj) {
                return false;
        }

        public ArrondissementVille find(int id) {
                
                ArrondissementVille arrondissement = new ArrondissementVille();                
                
                try {
                        ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
                        if(result.first())
                          arrondissement=null;//station = new Station(id, result.getString("elv_nom"), result.getString("elv_prenom"));
                        
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return arrondissement;
        }

        public boolean update(ArrondissementVille obj) {
                return false;
        }
    }

    
    
    

