/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model.identification;

import java.io.File;
import model.exportFile.FileExport;
import model.importFile.FileImport;

/**
 *
 * @author rifa1
 */
public interface Identification {

    public void setNext(Identification next);

    public FileImport importHandle(File chosenFile);

    public FileExport exportHandle(String fileName);

    public String getExtension(String chosenFile);

}
