/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.identification;

import model.exportFile.XML_Export;
import model.importFile.*;

/**
 *
 * @author rifa1
 */
public class XML_Identification extends BaseIdentification {

    public XML_Identification() {
        super.rightExtension = ".xml";
        super.fileImport = new XML_Import();
        super.fileExport = new XML_Export();
    }

}
