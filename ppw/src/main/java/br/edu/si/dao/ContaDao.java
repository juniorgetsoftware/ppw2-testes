package br.edu.si.dao;

import java.util.ArrayList;
import java.util.List;

import br.edu.si.modelo.Conta;

public class ContaDao {

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

}
