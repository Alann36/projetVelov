/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projetvelov.accesBD;

/**
 *
 * @author Damien
 */


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;

public class ConnexionOracleFactory {

    private static Connection connexion;

    private ConnexionOracleFactory() {
    }

    public static Connection creerConnexion() {
        if (connexion == null) {
            try {
                Properties props = new Properties();
                FileInputStream fichier = new FileInputStream("build/classes/connexion/connexion.properties");
                props.load(fichier);
                OracleDataSource ods = new OracleDataSource();
                ods.setDriverType(props.getProperty("pilote"));
                ods.setPortNumber(new Integer(props.getProperty("port")).intValue());
                ods.setServiceName(props.getProperty("service"));
                ods.setUser(props.getProperty("user"));
                ods.setPassword(props.getProperty("pwd"));
                ods.setServerName(props.getProperty("serveur"));
                return (ods.getConnection());
            } catch (IOException | SQLException | NumberFormatException e) {
                System.err.println("Erreur lors de la lecture du fichier de configuration pour la connexion: " + e.getMessage());
                return null;
            }
        }
        return connexion;
    }
}