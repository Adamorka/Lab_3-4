package oop_lab3.proxy;

import javafx.collections.ObservableList;
import oop_lab3.entity.Worker;
import oop_lab3.serialization.SerializationDeserializationService;
import oop_lab3.serialization.TextSerializationDeserialization;
import oop_lab3.services.ZipService;

import java.io.File;
import java.io.FileNotFoundException;

public class TextSerializationMethodProxy implements SerializationDeserializationService {

    SerializationDeserializationService serializationService = new TextSerializationDeserialization();

    @Override
    public void serialize(ObservableList<Worker> workers, File file) {
        serializationService.serialize(workers,file);
        ZipService.getInstance().convertToZip(file);
    }

    @Override
    public ObservableList<Worker> deserialize(File file) throws FileNotFoundException {
        return serializationService.deserialize(file);
    }
}
