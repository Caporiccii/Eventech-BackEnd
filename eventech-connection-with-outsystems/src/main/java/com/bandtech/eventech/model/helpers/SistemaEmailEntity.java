package com.bandtech.eventech.model.helpers;

import lombok.*;
import org.springframework.beans.factory.support.AbstractBeanFactory;

import javax.persistence.*;

@ToString
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQueries(value = {
        @NamedQuery(name = "ParametroSistema.findByCodigo", query =
                "SELECT c FROM ParametroSistema c WHERE c.codigo = :codigo"),
        @NamedQuery(name = "ParametroSistema.findAll", query =
                "SELECT c FROM ParametroSistema c") })
@Table(name = "parametros_email")
public class SistemaEmailEntity {
    public static final String FIND_BY_CODIGO = "SistemaEmailEntity.findByCodigo";
    public static final String FIND_ALL = "SistemaEmailEntity.findAll";

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private Integer id;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
//Rever Implementação deste metodo
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof AbstractBeanFactory) && (this.id != null) ? id
                .equals(((AbstractBeanFactory) obj).getType("")) : (obj == this);
    }

    @Column(length = 255, nullable = false)
    private String codigo;

    @Column(length = 255)
    private String descricao;

    @Column(length = 255, nullable = false)
    private String descricao_campo1;

    @Column(length = 255, nullable = false)
    private String valor_campo1;

    @Column(length = 255)
    private String descricao_campo2;

    @Column(length = 255)
    private String valor_campo2;

    @Column(length = 255)
    private String descricao_campo3;

    @Column(length = 255)
    private String valor_campo3;
}
