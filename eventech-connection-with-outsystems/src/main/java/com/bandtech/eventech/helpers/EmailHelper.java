package com.bandtech.eventech.helpers;

import com.bandtech.eventech.model.helpers.SistemaEmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.Session;

@Component(value = "emailHelper")
public class EmailHelper {

 //   private static Logger logger = Logger.getLogger(EmailHelper.class);

    @Autowired
    private SistemaEmailHelper parametroSistemaHelper;

    public void enviarEmail(String email, String assunto, String msg) {

    }

    private Session criarSessionMail() {
        return null;
    }

    public SistemaEmailHelper getParametroSistemaHelper() {
        return parametroSistemaHelper;
    }

    public void setParametroSistemaHelper(
            SistemaEmailHelper parametroSistemaHelper) {
        this.parametroSistemaHelper = parametroSistemaHelper;
    }

}
