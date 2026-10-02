package br.edu.cs.poo.ac.seguro.telas;

import javax.swing.*;
import java.awt.*;

public class TelaSeguradoEmpresa extends JFrame {

    private JTextField campoNome;
    private JTextField campoCnpj;
    private JTextField campoFaturamento;
    private JTextField campoDataAbertura;
    private JTextField campoBonus;

    private JTextField campoLogradouro;
    private JTextField campoCep;
    private JTextField campoNumero;
    private JTextField campoComplemento;
    private JTextField campoPais;
    private JTextField campoEstado;
    private JTextField campoCidade;

    private JRadioButton radioSim;
    private JRadioButton radioNao;
    private ButtonGroup grupoLocadora;

    private JButton botaoCadastrar;
    private JButton botaoBuscar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    public TelaSeguradoEmpresa() {

        setTitle("Cadastro de Segurado Empresa");
        setSize(600, 650);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(17, 2, 10, 10));

        painel.add(new JLabel("Nome:"));
        campoNome = new JTextField();
        painel.add(campoNome);

        painel.add(new JLabel("CNPJ:"));
        campoCnpj = new JTextField();
        painel.add(campoCnpj);

        painel.add(new JLabel("Data de abertura:"));
        campoDataAbertura = new JTextField();
        painel.add(campoDataAbertura);

        painel.add(new JLabel("Faturamento:"));
        campoFaturamento = new JTextField();
        painel.add(campoFaturamento);

        painel.add(new JLabel("Bônus:"));
        campoBonus = new JTextField();
        painel.add(campoBonus);

        painel.add(new JLabel("É locadora de veículos?"));

        JPanel painelLocadora = new JPanel();

        radioSim = new JRadioButton("Sim");
        radioNao = new JRadioButton("Não");

        grupoLocadora = new ButtonGroup();
        grupoLocadora.add(radioSim);
        grupoLocadora.add(radioNao);

        painelLocadora.add(radioSim);
        painelLocadora.add(radioNao);

        painel.add(painelLocadora);

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

        new TelaSeguradoEmpresa();

    }
}