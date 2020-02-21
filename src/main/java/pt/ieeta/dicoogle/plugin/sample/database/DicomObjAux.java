package pt.ieeta.dicoogle.plugin.sample.database;

import com.mongodb.*;
import com.mongodb.client.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Indexes;
import com.mongodb.util.JSON;
import com.mongodb.gridfs.*;
import org.bson.Document;
import org.bson.types.ObjectId;

import org.dcm4che2.data.DicomObject;
import org.dcm4che2.io.DicomOutputStream;
import org.dcm4che2.data.Tag;

import java.util.*;
import java.util.logging.*;
import java.lang.reflect.Field;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class DicomObjAux{

    private Map<Integer, String> tagsDicom;
    private Field [] tags;

    /**
     * Construtor
     */
    public DicomObjAux(){
      this.tagsDicom = new HashMap<>();
      this.tags = Tag.class.getFields();
    }


    /**
     * Obtém todas as tags possíveis que um DicomObject pode ter
     */
    public Map<Integer, String> getAllDicomObjTags(){

      for (int i = 0 ; i<tags.length; i++){
        try{
          this.tagsDicom.put(tags[i].getInt(null), tags[i].getName());
        }
        catch (IllegalAccessException ex) {
          Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IllegalArgumentException ex) {
          Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

      return this.tagsDicom;
    }

    /**
     * Extrai os metadados do DicomObject para um mapa
     * @param dcmObj
     * @return
     */
    public Map<String, String> getFieldsDicomObj(DicomObject dcmObj){
      Map<String, String> dcmObjMap = new HashMap<>();

      for (Map.Entry<Integer, String> entry : this.tagsDicom.entrySet()) {
          Integer tag = entry.getKey();
          String tagName = entry.getValue();

          try{
            if(dcmObj.getString(tag) != null){
              dcmObjMap.put(tagName, dcmObj.getString(tag).toString());
            }
          }catch(UnsupportedOperationException ex){
            System.out.println("[ERROR ON] TAG: " + tagName);
            Logger.getLogger(DatabaseInterface.class.getName()).log(Level.SEVERE, null, ex);
          }


      }

      return dcmObjMap;

    }

}
