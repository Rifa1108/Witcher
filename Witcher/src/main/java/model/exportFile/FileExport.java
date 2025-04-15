/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exportFile;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author rifa1
 */
public abstract class FileExport {

    protected String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public abstract boolean createFile(ArrayList<HashMap<String, Object>> creatures);

}
