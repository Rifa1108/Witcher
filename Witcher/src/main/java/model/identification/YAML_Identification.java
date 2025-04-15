/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.identification;

import model.exportFile.YAML_Export;
import model.importFile.YAML_Import;

/**
 *
 * @author rifa1
 */
public class YAML_Identification extends BaseIdentification {

    public YAML_Identification() {
        super.rightExtension = ".yml";
        super.fileImport = new YAML_Import();
        super.fileExport = new YAML_Export();
    }

}
