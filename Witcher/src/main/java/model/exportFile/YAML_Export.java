/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exportFile;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author rifa1
 */
public class YAML_Export extends FileExport {

    @Override
    public boolean createFile(ArrayList<HashMap<String, Object>> creatures) {
        try {
            Yaml yaml = new Yaml();
            FileWriter writer = new FileWriter(fileName);
            yaml.dump(creatures, writer);
            return true;
        } catch (IOException ex) {
            return false;
        }

    }

}
