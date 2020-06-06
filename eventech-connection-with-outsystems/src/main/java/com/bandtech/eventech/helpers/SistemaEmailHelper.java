package com.bandtech.eventech.helpers;

import com.bandtech.eventech.Repository.IEventJPA;
import com.bandtech.eventech.model.V2.EventJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component(value = "emailSistemaHelper")
public class SistemaEmailHelper {
    @Autowired
    private IEventJPA  eventJPA;

    public List<SistemaEmailHelper> getParametroByCodigo(String codigo) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("codigo", codigo);

        List<SistemaEmailHelper> parametros = (List<SistemaEmailHelper>) eventJPA
                .findByQuery(
                        "SELECT c FROM ParametroSistema c WHERE c.codigo = :codigo",
                        map);

        if (parametros.size() > 0)
            return parametros;
        else
            return null;
    }

    public SistemaEmailHelper getUniqueParametroByCodigo(String codigo) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("codigo", codigo);

        List<SistemaEmailHelper> parametros = (List<SistemaEmailHelper>) eventJPA
                .findByQuery(
                        "SELECT c FROM ParametroSistema c WHERE c.codigo = :codigo",
                        map);

        if (parametros.size() > 0)
            return parametros.get(0);
        else
            return null;
    }

    public IEventJPA getEventJPA() {
        return eventJPA;
    }

    public void setEventJPA(IEventJPA eventJPA) {
        this.eventJPA = eventJPA;
    }
}
