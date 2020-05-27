package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Interfaces.IFileExporter;
import com.bandtech.eventech.Repository.IEventJPA;
import com.bandtech.eventech.model.V2.EventJPA;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import javassist.bytecode.StackMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
@Service
public class FileService implements IFileExporter {
    @Autowired
    private IEventJPA repository;
     private final String NAME_ARCHIVE = "eventos.csv";


    @Override
    public void gravaArquivo(List<EventJPA> lista) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        EventJPA eventJPA = new EventJPA();

      lista = repository.findAll();
   lista.add(eventJPA);



        Writer writer = Files.newBufferedWriter(Paths.get(NAME_ARCHIVE));

        StatefulBeanToCsv<EventJPA> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(lista);
            System.out.println(lista);
        writer.flush();
        writer.close();

    }

    @Override
    public void leArquivo(List<Objects> lista) {

    }
}
