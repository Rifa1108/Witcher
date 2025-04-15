/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.identification;

import model.exportFile.JSON_Export;
import model.importFile.JSON_Import;

/**
 *
 * @author rifa1
 */
public class JSON_Identification extends BaseIdentification {

    public JSON_Identification() {
        super.rightExtension = ".json";
        super.fileImport = new JSON_Import();
        super.fileExport = new JSON_Export();
    }

}
