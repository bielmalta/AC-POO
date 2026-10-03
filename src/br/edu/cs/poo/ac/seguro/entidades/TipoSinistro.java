package br.edu.cs.poo.ac.seguro.entidades;

/*
 * Implementar um enum com as seguintes constantes:
 * 
 * 	COLISAO(1,"Colis\u00e3o"),
	INCENDIO(2,"Inc\u00eandio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depreda\u00e7\u00e3o");
 * 
 * O enum deve ter construtor privado, metodos get publicos para os atributos codigo e nome,
 * e um metodo publico e estatico TipoSinistro getTipoSinistro(int codigo), que 
 * retorna o tipo de sinistro correspondente ao codigo recebido como parametro
 */





public enum TipoSinistro {           // ENUM E UMA CLASSE ESPECIAL COM UMA LISTA FECHADA DE VALORES
    COLISAO(1,"Colis\u00e3o"), 
	INCENDIO(2,"Inc\u00eandio"),
	FURTO(3, "Furto"),          // SAO CONSTANTES E CADA UM E UM OBJETO TipoSinistro CRIADO CHAMANDO O CONSTRUTOR COM UM CODIGO E UM NOME
	ENCHENTE(4, "Enchente"),    // EM MAIUSCULO E SEM ACENTO
	DEPREDACAO(5, "Depreda\u00e7\u00e3o");

    private final int codigo;        //FINAL E O VALOR DEFINIDO E QUE NUNCA MAIS MUDA
    private final String nome;

    private TipoSinistro(int codigo, String nome){      // CONTRUTOR E PRIVATE PQ SO AS PROPRIAS CONTANTES LA DE CIMA O CHAMAM
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo(){
        return codigo;          // SO TEM GET PQ COMO E FINAL NAO SE MUDA
    }

    public String getNome(){
        return nome;
    }

    public static TipoSinistro getTipoSinistro(int codigo){
        for (TipoSinistro tipo : TipoSinistro.values()){
            if (tipo.getCodigo() == codigo){
                return tipo;
            }
        }
        return null;
    }
}