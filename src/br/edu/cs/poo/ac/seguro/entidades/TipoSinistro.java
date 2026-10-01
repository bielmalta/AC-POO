package br.edu.cs.poo.ac.seguro.entidades;

/*
 * Implementar um enum com as seguintes constantes:
 * 
 * 	COLISAO(1,"Colisão"),
	INCENDIO(2,"Incêndio"),
	FURTO(3, "Furto"),
	ENCHENTE(4, "Enchente"),
	DEPREDACAO(5, "Depredação");
 * 
 * O enum deve ter construtor privado, métodos get públicos para os atributos codigo e nome,
 * e um método público e estático TipoSinistro getTipoSinistro(int codigo), que 
 * retorna o tipo de sinistro correspondente ao código recebido como parâmetro
 */





public enum TipoSinistro {           // ENUM É UMA CLASSE ESPECIAL COM UMA LISTA FECHADA DE VALORES
    COLISAO(1,"Colisão"), 
	INCENDIO(2,"Incêndio"),
	FURTO(3, "Furto"),          // SÃO CONSTANTES E CADA UM É UM OBJETO TipoSinistro CRIADO CHAMANDO O CONSTRUTOR COM UM CODIGO E UM NOME
	ENCHENTE(4, "Enchente"),    // EM MAIÚSCULO E SEM ACENTO
	DEPREDACAO(5, "Depredação");

    private final int codigo;        //FINAL É O VALOR DEFINIDO E QUE NUNCA MAIS MUDA
    private final String nome;

    private TipoSinistro(int codigo, String nome){      // CONTRUTOR É PRIVATE PQ SO AS PROPRIAS CONTANTES LA DE CIMA O CHAMAM
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo(){
        return codigo;          // SO TEM GET PQ COMO É FINAL NÃO SE MUDA
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