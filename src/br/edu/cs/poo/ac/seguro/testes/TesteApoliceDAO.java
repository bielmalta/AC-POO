package br.edu.cs.poo.ac.seguro.testes;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.cs.poo.ac.seguro.daos.ApoliceDAO;
import br.edu.cs.poo.ac.seguro.entidades.Apolice;

public class TesteApoliceDAO extends TesteDAO {
    private ApoliceDAO dao = new ApoliceDAO();

    protected Class getClasse() {
        return Apolice.class;
    }

    private Apolice criarApolice(String numero) {
        Apolice apo = new Apolice(null, BigDecimal.TEN, BigDecimal.TEN, BigDecimal.TEN);
        apo.setNumero(numero);
        return apo;
    }

    @Test
    public void teste01() {
        String numero = "00000000";
        cadastro.incluir(criarApolice(numero), numero);
        Apolice apo = dao.buscar(numero);
        Assertions.assertNotNull(apo);
    }

    @Test
    public void teste02() {
        String numero = "10000000";
        cadastro.incluir(criarApolice(numero), numero);
        Apolice apo = dao.buscar("11000000");
        Assertions.assertNull(apo);
    }

    @Test
    public void teste03() {
        String numero = "20000000";
        cadastro.incluir(criarApolice(numero), numero);
        boolean ret = dao.excluir(numero);
        Assertions.assertTrue(ret);
    }

    @Test
    public void teste04() {
        String numero = "30000000";
        cadastro.incluir(criarApolice(numero), numero);
        boolean ret = dao.excluir("31000000");
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste05() {
        String numero = "40000000";
        boolean ret = dao.incluir(criarApolice(numero));
        Assertions.assertTrue(ret);
        Apolice apo = dao.buscar(numero);
        Assertions.assertNotNull(apo);
    }

    @Test
    public void teste06() {
        String numero = "50000000";
        Apolice apo = criarApolice(numero);
        cadastro.incluir(apo, numero);
        boolean ret = dao.incluir(apo);
        Assertions.assertFalse(ret);
    }

    @Test
    public void teste07() {
        String numero = "60000000";
        boolean ret = dao.alterar(criarApolice(numero));
        Assertions.assertFalse(ret);
        Apolice apo = dao.buscar(numero);
        Assertions.assertNull(apo);
    }

    @Test
    public void teste08() {
        String numero = "70000000";
        Apolice apo = criarApolice(numero);
        cadastro.incluir(apo, numero);
        apo = criarApolice(numero);
        apo.setValorPremio(new BigDecimal("500.00"));
        boolean ret = dao.alterar(apo);
        Assertions.assertTrue(ret);
    }
}