/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ad.cdm.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.LogManager;

/**
 *
 * @author maria
 */
public class LogUtil {

    public static void setLogger() {
        try {
            LogManager.getLogManager().readConfiguration(new FileInputStream(Paths.get("src", "mylogging.properties").toString()));
        } catch (SecurityException | IOException e1) {
            e1.printStackTrace();
        }

    }
}
