package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal; /*Precisa do LocalDate e do BigDecimal porque eles aparecem nos parametros do construtor.*/
import java.time.LocalDate;

public class SeguradoPessoa extends Segurado { /*O extends e a heranca: o SeguradoPessoa e um Segurado.
     Ele ganha automaticamente tudo o que o Segurado tem: nome, endereco, bonus, getIdade(), creditarBonus() etc.*/

    private String cpf;  
    private double renda; //Os atributos que so pessoa fisica tem.

    public SeguradoPessoa(String nome, Endereco endereco, LocalDate dataNascimento, BigDecimal bonus, String cpf, double renda) {
        super(nome, endereco, dataNascimento, bonus); //chama o construtor do Segurado (a classe "m\u00e3e") e passa para ele os 4 valores que sao dele
        /*O super(...) tem que ser a primeira linha do construtor. Ele e obrigatorio aqui, porque o Segurado nao tem um construtor vazio. */
        this.cpf = cpf; 
        this.renda = renda; //o construtor guarda o cpf e a renda nos atributos da propria classe.
    }

    //get/set de cpf e renda. Iguais aos do Endereco: leem e alteram os atributos.

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }

    public LocalDate getDataNascimento() {
        return getDataCriacao();
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        setDataCriacao(dataNascimento);  //O SeguradoPessoa nao pode acessar dataCriacao direto, porque o atributo e private no Segurado. 
        // Por isso usa os metodos protegidos.
    }
}