package br.edu.cs.poo.ac.seguro.entidades;

public class Endereco {
    private String logradouro;   // ATRIBUTOS DA CLASSE 
    private String cep;
    private String numero;      // PRIVATE POIS SÓ A PRÓPRIA CLASSE ENXERGA ESSE DADO DIRETAMENTE, QUEM TÁ DE FORA TEM QUE PASSAR PELO GET/SET, ISSO É ENCAPSULAMENTO
    private String complemento;
    private String pais;
    private String estado;
    private String cidade;
    public Endereco(String logradouro, String cep, String numero, String complemento, String pais, String estado,
            String cidade) {
        this.logradouro = logradouro;
        this.cep = cep;
        this.numero = numero;       // CONSTRUTOR: É CHAMADO QUANDO ALGUÉM FAZ new Endereco(...), E TEM O MESMO NOME DA CLASSE
        this.complemento = complemento;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
    }
    public String getLogradouro() {         // GET PERMITE LER O VALOR FORA DA CLASSE, E PUBLIC É PRA QUALQUER CLASSE CHAMAR
        return logradouro;
    }
    public void setLogradouro(String logradouro) {      // SET PERMITE ALTERAR O VALOR DE FORA DA CLASSE E VOID NÃO DEVOLVE NADA
        this.logradouro = logradouro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

}