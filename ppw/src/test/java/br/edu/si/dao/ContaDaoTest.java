package br.edu.si.dao;

import static br.edu.si.dao.ContaDao.abrirConexao;
import static br.edu.si.dao.ContaDao.fecharConexao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.si.modelo.Conta;

public class ContaDaoTest {

	private static ContaDao dao;
	private Conta conta;

	@BeforeClass
	public static void executaAntesDaClasse() {
		dao = abrirConexao();
	}

	@AfterClass
	public static void executaDepoisDaClass() {
		fecharConexao();
	}

	@Before
	public void executaAntes() {
		dao.excluirTudo();

		conta = new Conta();
		conta.setId(1L);
		conta.setDescricao("Conta de energia");
		conta.setValor(BigDecimal.valueOf(50.00));
		conta.setVencimento(new Date());
	}

	@After
	public void executaDepois() {
		conta = null;
	}

	@Test
	public void deveSalvarContaNoBancoDeDados() {
		dao.salvar(conta);
		Assert.assertEquals(1, dao.quantidadeDeRegistros());
	}

	@Test
	public void deveEditarContaNoBancoDeDados() {
		dao.salvar(conta);
		Assert.assertEquals(1, dao.quantidadeDeRegistros());
		conta.setValor(BigDecimal.valueOf(40.00));
		conta.setDescricao("Conta de água");
		dao.editar(conta);
		Assert.assertEquals("Conta de água", dao.listar().get(0).getDescricao());
		Assert.assertEquals(BigDecimal.valueOf(40.00), dao.listar().get(0).getValor());
		Assert.assertEquals(1, dao.quantidadeDeRegistros());
	}

	@Test
	public void deveExcluirContaDoBancoDeDados() {
		dao.salvar(conta);
		Assert.assertEquals(1, dao.quantidadeDeRegistros());
		dao.excluir(conta);
		Assert.assertEquals(0, dao.quantidadeDeRegistros());
	}
}
