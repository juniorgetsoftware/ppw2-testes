package br.edu.si.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.si.modelo.Conta;

public class ContaDao {

	private static ContaDao dao;

	public static ContaDao abrirConexao() {
		if (dao == null) {
			dao = new ContaDao();
		}
		return dao;
	}
	
	public static void fecharConexao() {
		dao = null;
	}

	private ContaDao() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private List<Conta> contas = new ArrayList<Conta>();

	public void salvar(Conta conta) {
		contas.add(conta);
	}

	public void editar(Conta conta) {
		int posicao = contas.indexOf(conta);
		contas.set(posicao, conta);
	}

	public void excluir(Conta conta) {
		contas.remove(conta);
	}

	public List<Conta> listar() {
		return contas;
	}

	public int quantidadeDeRegistros() {
		return contas.size();
	}

	public void excluirTudo() {
		contas = new ArrayList<Conta>();
	}

}
