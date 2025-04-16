/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.identification.JSON_Identification;
import model.identification.YAML_Identification;
import model.identification.XML_Identification;
import java.io.File;
import java.util.HashMap;
import javax.swing.JDialog;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import model.*;
import model.exportFile.FileExport;
import model.importFile.*;

/**
 *
 * @author rifa1
 */
public class Controller {

    private File file;
    private Creatures creatures = new Creatures();

    public void setFile(File file) {
        this.file = file;
    }

    public boolean formatIdentification() {
        XML_Identification handler_XML = new XML_Identification();
        JSON_Identification handler_JSON = new JSON_Identification();
        YAML_Identification handler_YAML = new YAML_Identification();
        handler_XML.setNext(handler_JSON);
        handler_JSON.setNext(handler_YAML);
        FileImport fileImport = handler_XML.importHandle(file);
        if (fileImport == null) {
            return false;
        } else {
            return importControl(fileImport);
        }
    }

    private boolean importControl(FileImport fileImport) {
        fileImport.setFile(file);
        fileImport.setCreatures(creatures);
        creatures.setSource(file.getName());
        return fileImport.parseFile();
    }

    public JTree createTree(DefaultMutableTreeNode root, JDialog informationDialog) {
        for (String source : creatures.getSources()) {
            DefaultMutableTreeNode sourceNode = new DefaultMutableTreeNode(source);
            root.add(sourceNode);
            for (String kind : creatures.getKinds(source)) {
                DefaultMutableTreeNode kindNode = new DefaultMutableTreeNode(kind);
                sourceNode.add(kindNode);
            }
        }
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        JTree creaturesTree = new JTree(treeModel);
        return creaturesTree;
    }

    public HashMap<String, Object> getInformation(String source, int index) {
        Creature creature = creatures.getCreature(source, index);
        return creature.getAllChararterictics();

    }

    public boolean setInformation(HashMap<String, Object> allCharascteristics, String selectedCreatureSourceString, int index) {
        try {
            creatures.getCreature(selectedCreatureSourceString, index).checkNewChararterictics(allCharascteristics);
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }

    }

    public boolean saveFile(String source, String fileName) {
        XML_Identification handler_XML = new XML_Identification();
        JSON_Identification handler_JSON = new JSON_Identification();
        YAML_Identification handler_YAML = new YAML_Identification();
        handler_XML.setNext(handler_JSON);
        handler_JSON.setNext(handler_YAML);
        FileExport fileExport = handler_XML.exportHandle(fileName);
        if (fileExport == null) {
            return false;
        } else {
            return fileExport.createFile(creatures.getCreatures(source));
        }
    }

}
