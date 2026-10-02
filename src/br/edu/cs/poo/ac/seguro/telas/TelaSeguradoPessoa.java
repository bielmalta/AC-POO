package br.edu.cs.poo.ac.seguro.telas;

import javax.swing.*;
import java.awt.*;

public class TelaSeguradoPessoa extends JFrame {

    private JTextField campoNome;
    private JTextField campoCpf;
    private JTextField campoRenda;
    private JTextField campoDataNascimento;
    private JTextField campoBonus;

    private JTextField campoLogradouro;
    private JTextField campoCep;
    private JTextField campoNumero;
    private JTextField campoComplemento;
    private JTextField campoPais;
    private JTextField campoEstado;
    private JTextField campoCidade;

    private JButton botaoCadastrar;
    private JButton botaoBuscar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    public TelaSeguradoPessoa() {

        setTitle("Cadastro de Segurado Pessoa");
        setSize(600, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(16, 2, 10, 10));

        painel.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("CPF:"));
        campoCpf = new JTextField();
        painel.add(campoCpf);

        painel.add(new JLabel("Data de nascimento:"));
        campoDataNascimento = new JTextField();
        painel.add(campoDataNascimento);

        painel.add(new JLabel("Renda:"));
        campoRenda = new JTextField();
        painel.add(campoRenda);

        painel.add(new JLabel("Bônus:"));
        campoBonus = new JTextField();
        painel.add(campoBonus);

        painel.add(new JLabel("Logradouro:"));
        campoLogradouro = new JTextField();
        painel.add(campoLogradouro);

        painel.add(new JLabel("CEP:"));
        campoCep = new JTextField();
        painel.add(campoCep);

        painel.add(new JLabel("Número:"));
        campoNumero = new JTextField();
        painel.add(campoNumero);

        painel.add(new JLabel("Complemento:"));
        campoComplemento = new JTextField();
        painel.add(campoComplemento);

        painel.add(new JLabel("País:"));
        campoPais = new JTextField();
        painel.add(campoPais);

        painel.add(new JLabel("Estado:"));
        campoEstado = new JTextField();
        painel.add(campoEstado);

        painel.add(new JLabel("Cidade:"));
        campoCidade = new JTextField();
        painel.add(campoCidade);

        botaoCadastrar = new JButton("Cadastrar");
        botaoBuscar = new JButton("Buscar");
        botaoAtualizar = new JButton("Atualizar");
        botaoExcluir = new JButton("Excluir");

        painel.add(botaoCadastrar);
        painel.add(botaoBuscar);

        painel.add(botaoAtualizar);
        painel.add(botaoExcluir);

        add(painel);

        setVisible(true);
    }

    public static void main(String[] args) {

        new TelaSeguradoPessoa();

    }
}