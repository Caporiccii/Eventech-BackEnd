package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.IAdressRepository;
import com.bandtech.eventech.Repository.ICategoryRepository;
import com.bandtech.eventech.Repository.ICompanyRepository;
import com.bandtech.eventech.Service.V1.EventService;
import com.bandtech.eventech.interfaces.IFileExporter;
import com.bandtech.eventech.Repository.IEventRepository;
import com.bandtech.eventech.model.V1.Event;
import com.bandtech.eventech.model.V2.CompanyJPA;
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
    private DateFormatService formatService;
    EventService eventService = new EventService();
    Event event;
    private final String NAME_ARCHIVE = "eventos.txt";
    private BufferedWriter writer;
    private Integer idEvent;
    private String nameEvent;
    private String descriptionEvent;
    private boolean isCancelled;
    private String ageRange;
    private int company;
    private int place;
    private String categoria;
    private String header;
    private String corpo;
    private String trailer;
    private int contaRegistroDados;
    private List<EventJPA> lista;
    private String initialDate;
    private String finalDate;

    @Override
    public void gravaRegistro(String nomeArquivo, String header) {
        nomeArquivo = NAME_ARCHIVE;
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

    public Event GetDataEvent(Long id){
         event = new Event();

       event = eventService.getForEntity(id);

        return event;
    }
    @Override
    public void montaArquivo(Long eventId) {

        idEvent = GetDataEvent(eventId).getId();
        nameEvent = GetDataEvent(eventId).getName();
        descriptionEvent = GetDataEvent(eventId).getDescription();
        ageRange = GetDataEvent(eventId).getAgeRange();
        company = GetDataEvent(eventId).getCreatedBy();
        place = GetDataEvent(eventId).getPlaceId();
        initialDate = GetDataEvent(eventId).getInitialDate();
        finalDate = GetDataEvent(eventId).getFinalDate();

        header += " Dados dos Eventos ";
        header += formatService.formatDate();
        header += " 01";

        gravaRegistro(NAME_ARCHIVE,header);
//corpo += String.format("ID,  Nome Evento, Inicio,     Término,    Categoria,  Lugar,      Empresa,    Descrição,  Cancelado, Idade");

        corpo = "02  ";
        corpo += String.format("%03d",idEvent);
        corpo += String.format( "  %-10s " ,nameEvent);
        corpo += String.format( "  %-10s " ,initialDate);
        corpo += String.format( "  %-10s " ,finalDate);
      //  corpo += String.format(" %-10s ", categoria);
        corpo += String.format(" %-10s ",place);
        corpo += String.format(" %-10s ",company);
        corpo += String.format(" %-10s ",descriptionEvent);
        //corpo += String.format(" %-3s ",isCancelled);
        corpo += String.format(" %-2s ",ageRange);

        contaRegistroDados++;
        gravaRegistro(NAME_ARCHIVE,corpo);

        trailer += " 01 ";
        trailer += String.format(" %010d ", contaRegistroDados);
        gravaRegistro(NAME_ARCHIVE,trailer);

    }

}
