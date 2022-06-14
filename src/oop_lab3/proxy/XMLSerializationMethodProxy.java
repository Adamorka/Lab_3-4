package oop_lab3.proxy;

import javafx.collections.ObservableList;
import oop_lab3.entity.Worker;
import oop_lab3.serialization.SerializationDeserializationService;
import oop_lab3.serialization.XMLSerializationDeserialization;
import oop_lab3.services.ConvertXMLToJSONService;
import oop_lab3.services.ZipService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class XMLSerializationMethodProxy implements SerializationDeserializationService {

    SerializationDeserializationService serializationService = new XMLSerializationDeserialization();

    @Override
    public void serialize(ObservableList<Worker> workers, File file) {
        serializationService.serialize(workers,file);
        ZipService.getInstance().convertToZip(file);
        try {
            ConvertXMLToJSONService.getInstance().convert(file);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Worker> deserialize(File file) throws FileNotFoundException {
        return serializationService.deserialize(file);
    }
}
