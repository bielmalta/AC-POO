package br.edu.cs.poo.ac.seguro.entidades;

import java.math.BigDecimal; /*Precisa do LocalDate e do BigDecimal porque eles aparecem nos parâmetros do construtor.*/
import java.time.LocalDate;

public class SeguradoPessoa extends Segurado { /*O extends é a herança: o SeguradoPessoa é um Segurado.
     Ele ganha automaticamente tudo o que o Segurado tem: nome, endereço, bônus, getIdade(), creditarBonus() etc.*/

    private String cpf;  
    private double renda; //Os atributos que só pessoa física tem.

    public SeguradoPessoa(String nome, Endereco endereco, LocalDate dataNascimento, BigDecimal bonus, String cpf, double renda) {
        super(nome, endereco, dataNascimento, bonus); //chama o construtor do Segurado (a classe "mãe") e passa para ele os 4 valores que são dele
        /*O super(...) tem que ser a primeira linha do construtor. Ele é obrigatório aqui, porque o Segurado não tem um construtor vazio. */
        this.cpf = cpf; 
        this.renda = renda; //o construtor guarda o cpf e a renda nos atributos da própria classe.
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
        setDataCriacao(dataNascimento);  //O SeguradoPessoa não pode acessar dataCriacao direto, porque o atributo é private no Segurado. 
        // Por isso usa os métodos protegidos.
    }
}