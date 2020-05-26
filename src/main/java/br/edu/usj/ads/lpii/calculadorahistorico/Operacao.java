package br.edu.usj.ads.lpii.calculadorahistorico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Operacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String operacao;

    public String toString() {
        return operacao;
    }
}