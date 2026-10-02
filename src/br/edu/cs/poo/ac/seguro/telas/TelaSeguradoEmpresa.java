package br.edu.cs.poo.ac.seguro.telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.edu.cs.poo.ac.seguro.entidades.Endereco;
import br.edu.cs.poo.ac.seguro.entidades.SeguradoEmpresa;
import br.edu.cs.poo.ac.seguro.mediators.SeguradoEmpresaMediator;

public class TelaSeguradoEmpresa extends JFrame implements ActionListener {

    private static final String[] ESTADOS = {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA",
            "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"};
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private SeguradoEmpresaMediator mediator = SeguradoEmpresaMediator.getInstancia();

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
    private JComboBox<String> campoEstado;
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

        painel.add(new JLabel("Data de abertura (dd/mm/aaaa):"));
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
        radioNao.setSelected(true);

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
        SeguradoEmpresa seg = montarSegurado();
        if (seg != null) {
            mostrarResultado(mediator.incluirSeguradoEmpresa(seg), "Segurado cadastrado com sucesso");
        }
    }

    private void atualizar() {
        SeguradoEmpresa seg = montarSegurado();
        if (seg != null) {
            mostrarResultado(mediator.alterarSeguradoEmpresa(seg), "Segurado atualizado com sucesso");
        }
    }

    private void excluir() {
        String msg = mediator.excluirSeguradoEmpresa(campoCnpj.getText().trim());
        mostrarResultado(msg, "Segurado excluído com sucesso");
        if (msg == null) {
            limparCampos();
        }
    }

    private void buscar() {
        SeguradoEmpresa seg = mediator.buscarSeguradoEmpresa(campoCnpj.getText().trim());
        if (seg == null) {
            JOptionPane.showMessageDialog(this, "Segurado não encontrado");
            return;
        }
        campoNome.setText(seg.getNome());
        campoFaturamento.setText(String.valueOf(seg.getFaturamento()));
        campoBonus.setText(seg.getBonus() == null ? "" : seg.getBonus().toString());
        campoDataAbertura.setText(seg.getDataAbertura() == null ? "" : seg.getDataAbertura().format(FORMATO_DATA));
        if (seg.isEhLocadoraDeVeiculos()) {
            radioSim.setSelected(true);
        } else {
            radioNao.setSelected(true);
        }
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

    private SeguradoEmpresa montarSegurado() {
        LocalDate dataAbertura = null;
        if (!campoDataAbertura.getText().trim().isEmpty()) {
            try {
                dataAbertura = LocalDate.parse(campoDataAbertura.getText().trim(), FORMATO_DATA);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Data de abertura deve estar no formato dd/mm/aaaa");
                return null;
            }
        }
        double faturamento;
        BigDecimal bonus;
        try {
            faturamento = Double.parseDouble(campoFaturamento.getText().trim().replace(",", "."));
            String textoBonus = campoBonus.getText().trim().replace(",", ".");
            bonus = textoBonus.isEmpty() ? BigDecimal.ZERO : new BigDecimal(textoBonus);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Faturamento e bônus devem ser números");
            return null;
        }
        Endereco endereco = new Endereco(campoLogradouro.getText(), campoCep.getText(), campoNumero.getText(),
                campoComplemento.getText(), campoPais.getText(), (String) campoEstado.getSelectedItem(),
                campoCidade.getText());
        return new SeguradoEmpresa(campoNome.getText(), endereco, dataAbertura, bonus,
                campoCnpj.getText().trim(), faturamento, radioSim.isSelected());
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
        campoCnpj.setText("");
        campoFaturamento.setText("");
        campoDataAbertura.setText("");
        campoBonus.setText("");
        campoLogradouro.setText("");
        campoCep.setText("");
        campoNumero.setText("");
        campoComplemento.setText("");
        campoPais.setText("");
        campoCidade.setText("");
        radioNao.setSelected(true);
    }

    public static void main(String[] args) {

        new TelaSeguradoEmpresa();

    }
}