/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.identification;

import java.io.File;
import model.exportFile.FileExport;
import model.importFile.FileImport;

/**
 *
 * @author rifa1
 */
public abstract class BaseIdentification implements Identification {

    protected Identification next;
    protected String rightExtension;
    protected FileImport fileImport;
    protected FileExport fileExport;

    @Override
    public void setNext(Identification next) {
        this.next = next;
    }

    @Override
    public String getExtension(String chosenFile) {
        int dotIndex = chosenFile.lastIndexOf('.');
        String extension = (dotIndex == -1) ? "" : chosenFile.substring(dotIndex);
        return extension;
    }

    @Override
    public FileImport importHandle(File chosenFile) {
        if (getExtension(chosenFile.getName()).equals(rightExtension)) {
            fileImport.setFile(chosenFile);
            return fileImport;
        } else if (next != null) {
            return next.importHandle(chosenFile);
        } else {
            return null;
        }

    }

    @Override
    public FileExport exportHandle(String fileName) {
        if (getExtension(fileName).equals(rightExtension)) {
            fileExport.setFileName(fileName);
            return fileExport;
        } else if (next != null) {
            return next.exportHandle(fileName);
        } else {
            return null;
        }

    }
}
