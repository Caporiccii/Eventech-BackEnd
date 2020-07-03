package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Service.V1.EventService;
import com.bandtech.eventech.interfaces.IFileExporter;
import com.bandtech.eventech.model.V1.Event;
import com.bandtech.eventech.model.V2.EventJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
@Service
public class FileService implements IFileExporter {

    @Autowired
    private DateFormatService formatService;
    EventService eventService = new EventService();
    Event event;
    private final String NAME_ARCHIVE = "eventos.txt";

    public String getNAME_ARCHIVE() {
        return NAME_ARCHIVE;
    }

    public String getConteudoArquivo() throws IOException {
       FileInputStream bis = new FileInputStream(new File(NAME_ARCHIVE));

       byte[] conteudoArquivo = new byte[bis.available()];
       bis.read(conteudoArquivo);

       return new String(conteudoArquivo);
    }

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

        corpo += String.format(" %-10s ",place);
        corpo += String.format(" %-10s ",company);
        corpo += String.format(" %-10s ",descriptionEvent);

        contaRegistroDados++;
        gravaRegistro(NAME_ARCHIVE,corpo);

        trailer += " 01 ";
        trailer += String.format(" %010d ", contaRegistroDados);
        gravaRegistro(NAME_ARCHIVE,trailer);

    }

}
