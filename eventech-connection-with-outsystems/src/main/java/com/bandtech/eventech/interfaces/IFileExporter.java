package com.bandtech.eventech.interfaces;

import com.bandtech.eventech.model.V2.EventJPA;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public interface IFileExporter {
   void gravaArquivo(List<EventJPA> lista) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException;

    void leArquivo(List<Objects> lista);
}
