package br.edu.cs.poo.ac.seguro.telas;

import br.edu.cs.poo.ac.seguro.entidades.CategoriaVeiculo;

import javax.swing.*;
import java.awt.*;

public class TelaVeiculo extends JFrame {

    private JTextField campoPlaca;
    private JTextField campoAno;

    private JComboBox<CategoriaVeiculo> comboCategoria;

    private JTextField campoProprietarioPessoa;
    private JTextField campoProprietarioEmpresa;

    private JButton botaoCadastrar;
    private JButton botaoBuscar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    public TelaVeiculo() {

        setTitle("Cadastro de Veículo");
        setSize(500, 350);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(7, 2, 10, 10));

        painel.add(new JLabel("Placa:"));

        campoPlaca = new JTextField();
        painel.add(campoPlaca);


        painel.add(new JLabel("Ano:"));

        campoAno = new JTextField();
        painel.add(campoAno);


        painel.add(new JLabel("Categoria:"));

        comboCategoria = new JComboBox<>(CategoriaVeiculo.values());
        painel.add(comboCategoria);


        painel.add(new JLabel("CPF do proprietário:"));

        campoProprietarioPessoa = new JTextField();
        painel.add(campoProprietarioPessoa);


        painel.add(new JLabel("CNPJ do proprietário:"));

        campoProprietarioEmpresa = new JTextField();
        painel.add(campoProprietarioEmpresa);


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

        new TelaVeiculo();

    }
}