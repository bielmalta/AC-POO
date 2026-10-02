package br.edu.cs.poo.ac.seguro.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.cs.poo.ac.seguro.entidades.Endereco;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoPessoa;
import br.edu.cs.poo.ac.seguro.mediators.SeguradoPessoaMediator;

public class TelaSeguradoPessoa extends JFrame implements ActionListener {

    private static final String[] ESTADOS = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private SeguradoPessoaMediator mediator = SeguradoPessoaMediator.getInstancia();

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
    private JComboBox<String> campoEstado;
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

        painel.add(new JLabel("Data de nascimento (dd/mm/aaaa):"));
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
        campoEstado = new JComboBox<>(ESTADOS);
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

        botaoCadastrar.addActionListener(this);
        botaoBuscar.addActionListener(this);
        botaoAtualizar.addActionListener(this);
        botaoExcluir.addActionListener(this);

        add(painel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoCadastrar) {
            cadastrar();
        } else if (e.getSource() == botaoBuscar) {
            buscar();
        } else if (e.getSource() == botaoAtualizar) {
            atualizar();
        } else if (e.getSource() == botaoExcluir) {
            excluir();
        }
    }

    private void cadastrar() {
        SeguradoPessoa seg = montarSegurado();
        if (seg != null) {
            mostrarResultado(mediator.incluirSeguradoPessoa(seg), "Segurado cadastrado com sucesso");
        }
    }

    private void atualizar() {
        SeguradoPessoa seg = montarSegurado();
        if (seg != null) {
            mostrarResultado(mediator.alterarSeguradoPessoa(seg), "Segurado atualizado com sucesso");
        }
    }

    private void excluir() {
        String msg = mediator.excluirSeguradoPessoa(campoCpf.getText().trim());
        mostrarResultado(msg, "Segurado excluído com sucesso");
        if (msg == null) {
            limparCampos();
        }
    }

    private void buscar() {
        SeguradoPessoa seg = mediator.buscarSeguradoPessoa(campoCpf.getText().trim());
        if (seg == null) {
            JOptionPane.showMessageDialog(this, "Segurado não encontrado");
            return;
        }
        campoNome.setText(seg.getNome());
        campoRenda.setText(String.valueOf(seg.getRenda()));
        campoBonus.setText(seg.getBonus() == null ? "" : seg.getBonus().toString());
        campoDataNascimento.setText(seg.getDataNascimento() == null ? "" : seg.getDataNascimento().format(FORMATO_DATA));
        Endereco end = seg.getEndereco();
        if (end != null) {
            campoLogradouro.setText(end.getLogradouro());
            campoCep.setText(end.getCep());
            campoNumero.setText(end.getNumero());
            campoComplemento.setText(end.getComplemento());
            campoPais.setText(end.getPais());
            campoEstado.setSelectedItem(end.getEstado());
            campoCidade.setText(end.getCidade());
        }
    }

    private SeguradoPessoa montarSegurado() {
        LocalDate dataNascimento = null;
        if (!campoDataNascimento.getText().trim().isEmpty()) {
            try {
                dataNascimento = LocalDate.parse(campoDataNascimento.getText().trim(), FORMATO_DATA);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Data de nascimento deve estar no formato dd/mm/aaaa");
                return null;
            }
        }
        double renda;
        BigDecimal bonus;
        try {
            renda = Double.parseDouble(campoRenda.getText().trim().replace(",", "."));
            String textoBonus = campoBonus.getText().trim().replace(",", ".");
            bonus = textoBonus.isEmpty() ? BigDecimal.ZERO : new BigDecimal(textoBonus);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Renda e bônus devem ser números");
            return null;
        }
        Endereco endereco = new Endereco(campoLogradouro.getText(), campoCep.getText(), campoNumero.getText(),
                campoComplemento.getText(), campoPais.getText(), (String) campoEstado.getSelectedItem(),
                campoCidade.getText());
        return new SeguradoPessoa(campoNome.getText(), endereco, dataNascimento, bonus,
                campoCpf.getText().trim(), renda);
    }

    private void mostrarResultado(String msgErro, String msgSucesso) {
        if (msgErro == null) {
            JOptionPane.showMessageDialog(this, msgSucesso);
        } else {
            JOptionPane.showMessageDialog(this, msgErro, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        campoNome.setText("");
        campoCpf.setText("");
        campoRenda.setText("");
        campoDataNascimento.setText("");
        campoBonus.setText("");
        campoLogradouro.setText("");
        campoCep.setText("");
        campoNumero.setText("");
        campoComplemento.setText("");
        campoPais.setText("");
        campoCidade.setText("");
    }

    public static void main(String[] args) {

        new TelaSeguradoPessoa();

    }
}