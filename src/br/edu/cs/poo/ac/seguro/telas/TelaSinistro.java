package br.edu.cs.poo.ac.seguro.telas;

import br.edu.cs.poo.ac.seguro.entidades.TipoSinistro;

import javax.swing.*;
import java.awt.*;

public class TelaSinistro extends JFrame {

    private JTextField campoNumero;
    private JTextField campoPlacaVeiculo;
    private JTextField campoDataHoraSinistro;
    private JTextField campoDataHoraRegistro;
    private JTextField campoUsuarioRegistro;
    private JTextField campoValorSinistro;

    private JComboBox<TipoSinistro> comboTipo;

    private JButton botaoCadastrar;
    private JButton botaoBuscar;
    private JButton botaoAtualizar;
    private JButton botaoExcluir;

    public TelaSinistro() {

        setTitle("Cadastro de Sinistro");
        setSize(550, 450);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painel = new JPanel();

        painel.setLayout(new GridLayout(9, 2, 10, 10));

        painel.add(new JLabel("Número:"));
        campoNumero = new JTextField();
        painel.add(campoNumero);

        painel.add(new JLabel("Placa do veículo:"));
        campoPlacaVeiculo = new JTextField();
        painel.add(campoPlacaVeiculo);

        painel.add(new JLabel("Data e hora do sinistro:"));
        campoDataHoraSinistro = new JTextField();
        painel.add(campoDataHoraSinistro);

        painel.add(new JLabel("Data e hora do registro:"));
        campoDataHoraRegistro = new JTextField();
        painel.add(campoDataHoraRegistro);

        painel.add(new JLabel("Usuário do registro:"));
        campoUsuarioRegistro = new JTextField();
        painel.add(campoUsuarioRegistro);

        painel.add(new JLabel("Valor do sinistro:"));
        campoValorSinistro = new JTextField();
        painel.add(campoValorSinistro);

        painel.add(new JLabel("Tipo do sinistro:"));
        comboTipo = new JComboBox<>(TipoSinistro.values());
        painel.add(comboTipo);

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

        new TelaSinistro();

    }
}