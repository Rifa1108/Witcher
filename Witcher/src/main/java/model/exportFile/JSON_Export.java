/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exportFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rifa1
 */
public class JSON_Export extends FileExport {

    @Override
    public boolean createFile(ArrayList<HashMap<String,Object>> creatures) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(fileName);
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, creatures);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

}
