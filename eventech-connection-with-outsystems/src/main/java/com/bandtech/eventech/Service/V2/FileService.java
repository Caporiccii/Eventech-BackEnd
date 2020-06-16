package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.interfaces.IFileExporter;
import com.bandtech.eventech.Repository.IEventRepository;
import com.bandtech.eventech.model.V1.Event;
import com.bandtech.eventech.model.V2.EventJPA;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
@Service
public class FileService implements IFileExporter {
    @Autowired
    private IEventRepository repository;
    @Autowired
    private DateFormatService formatService;

    private final String NAME_ARCHIVE = "eventos.csv";
    private BufferedWriter writer;
    private EventJPA eventJPA;

// metodo para montar o objeto JPA

    public List<EventJPA> consultaBanco(List<EventJPA> lista){
        eventJPA = new EventJPA();
        lista = repository.findAll();

        for (EventJPA eventJPA : lista) {
            eventJPA.getId();
            eventJPA.getName();
        }

        lista.add(eventJPA);

        return lista;
    }
    @Override
    public void gravaArquivo(List<EventJPA> lista) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
     /*   eventJPA = new EventJPA();

        lista = repository.findAll();
        lista.add(eventJPA);

        Writer writer = Files.newBufferedWriter(Paths.get(NAME_ARCHIVE));

        StatefulBeanToCsv<EventJPA> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

        beanToCsv.write(lista);
        System.out.println(lista);
        writer.flush();
        writer.close();
    */
    }

    @Override
    public void gravaRegistro(String nomeArquivo, String header) {
        try {

            writer = new BufferedWriter(new FileWriter(nomeArquivo, true));
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
        }

        try {
            writer.append(header + "\n");
            writer.close();

        } catch (IOException e) {
            System.err.printf("Erro ao gravar arquivo: %s.\n", e.getMessage());
        }
    }

    @Override
    public void montaArquivo(String nomeArquivo, String header, String corpo, String trailer, int contaRegistroDados,
                             List<EventJPA> lista) {
        nomeArquivo = NAME_ARCHIVE;

        header += "Dados dos Eventos";
        header += formatService.formatDate();
        header += "01";

        gravaRegistro(nomeArquivo,header);

        corpo = "02";
        corpo += "";

    }

}
