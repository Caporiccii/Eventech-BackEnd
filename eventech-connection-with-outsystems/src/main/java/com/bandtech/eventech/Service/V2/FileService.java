package com.bandtech.eventech.Service.V2;

import com.bandtech.eventech.Repository.IAdressRepository;
import com.bandtech.eventech.Repository.ICategoryRepository;
import com.bandtech.eventech.Repository.ICompanyRepository;
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
    private IEventRepository repository;
    @Autowired
    private DateFormatService formatService;
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private  ICategoryRepository categoryRepository;
    @Autowired
    private IAdressRepository adressRepository;

    private final String NAME_ARCHIVE = "eventos.txt";
    private BufferedWriter writer;
    private EventJPA eventJPA;
    private Integer idEvent;
    private String nameEvent;
    private String descriptionEvent;
    private boolean isCancelled;
    private String ageRange;
    private String company;
    private String place;
    private String categoria;
    private String header;
    private String corpo;
    private String trailer;
    private int contaRegistroDados;
    private List<EventJPA> lista;
    private String initialDate;
    private String finalDate;


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

    @Override
    public void montaArquivo() {
        //nomeArquivo = NAME_ARCHIVE;
        idEvent = repository.getIdEvent();
        nameEvent = repository.getNameEvent();
        descriptionEvent = repository.getDescriptionEvent();
        isCancelled = repository.getIsCancelledEvent();
        ageRange = repository.getAgeRangeEvent();
        company = companyRepository.getNameCompany();
        place = adressRepository.getStreet();
        categoria = categoryRepository.getCategoryEvent();
        initialDate = repository.getInitialDate();
        finalDate = repository.getFinalDate();



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
        corpo += String.format(" %-10s ", categoria);
        corpo += String.format(" %-10s ",place);
        corpo += String.format(" %-10s ",company);
        corpo += String.format(" %-10s ",descriptionEvent);
        corpo += String.format(" %-3s ",isCancelled);
        corpo += String.format(" %-2s ",ageRange);

        contaRegistroDados++;
        gravaRegistro(NAME_ARCHIVE,corpo);

        trailer += " 01 ";
        trailer += String.format(" %010d ", contaRegistroDados);
        gravaRegistro(NAME_ARCHIVE,trailer);

    }

}
