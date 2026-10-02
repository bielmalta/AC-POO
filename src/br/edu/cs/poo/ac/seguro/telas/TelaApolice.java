package br.edu.cs.poo.ac.seguro.telas;

import javax.swing.*;
import java.awt.*;

public class TelaApolice extends JFrame {

    private JTextField campoPlacaVeiculo;
    private JTextField campoValorFranquia;
    private JTextField campoValorPremio;
    private JTextField campoValorMaximoSegurado;

    private JButton botaoCadastrar;
    private JButton botaoBuscar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    public TelaApolice() {

        setTitle("Cadastro de Apólice");
        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(6, 2, 10, 10));

        painel.add(new JLabel("Placa do veículo:"));
        campoPlacaVeiculo = new JTextField();
        painel.add(campoPlacaVeiculo);

        painel.add(new JLabel("Valor da franquia:"));
        campoValorFranquia = new JTextField();
        painel.add(campoValorFranquia);

        painel.add(new JLabel("Valor do prêmio:"));
        campoValorPremio = new JTextField();
        painel.add(campoValorPremio);

        painel.add(new JLabel("Valor máximo segurado:"));
        campoValorMaximoSegurado = new JTextField();
        painel.add(campoValorMaximoSegurado);

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

        new TelaApolice();

    }
}