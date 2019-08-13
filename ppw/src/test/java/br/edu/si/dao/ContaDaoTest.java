package br.edu.si.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import br.edu.si.modelo.Conta;

public class ContaDaoTest {

	@Test
	public void deveSalvarContaNoBancoDeDados() {
		ContaDao dao = new ContaDao();
		Conta conta = new Conta();

		conta.setId(1L);
		conta.setDescricao("Conta de energia");
		conta.setValor(BigDecimal.valueOf(50.00));
		conta.setVencimento(new Date());

		dao.salvar(conta);

		Assert.assertEquals(1, dao.quantidadeDeRegistros());
	}

	@Test
	public void deveEditarContaNoBancoDeDados() {
		ContaDao dao = new ContaDao();
		Conta conta = new Conta();

		conta.setId(1L);
		conta.setDescricao("Conta de energia");
		conta.setValor(BigDecimal.valueOf(50.00));
		conta.setVencimento(new Date());

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
		ContaDao dao = new ContaDao();
		Conta conta = new Conta();

		conta.setId(1L);
		conta.setDescricao("Conta de energia");
		conta.setValor(BigDecimal.valueOf(50.00));
		conta.setVencimento(new Date());

		dao.salvar(conta);
		Assert.assertEquals(1, dao.quantidadeDeRegistros());

		dao.excluir(conta);
		Assert.assertEquals(0, dao.quantidadeDeRegistros());

	}

}
