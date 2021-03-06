package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V1.Event;
import com.bandtech.eventech.model.V2.EventJPA;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public interface IFileExporter {
    void gravaRegistro(String nomeArq, String header);

    void montaArquivo(Long eventId);
}
