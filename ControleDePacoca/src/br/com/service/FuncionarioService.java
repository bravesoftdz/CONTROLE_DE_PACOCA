package br.com.service;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.model.Funcionario;
import br.com.repository.FuncionarioRepository;

public class FuncionarioService {
	
	private FuncionarioRepository repository;
	
	public FuncionarioService() throws ClassNotFoundException, SQLException {
		
		repository = new FuncionarioRepository(); 
	}
	
	public void salvar(Funcionario func) throws ClassNotFoundException, SQLException {
		this.repository.salvar(func);
	}
	
	public void deletar(Long idFunc) throws ClassNotFoundException, SQLException {
		this.repository.deletar(idFunc);
	}
	
	public ArrayList<Funcionario> listar() throws ClassNotFoundException, SQLException{
		return this.repository.listar();
	}
	
	public Funcionario buscar(Long idFunc) throws ClassNotFoundException, SQLException {
		return this.repository.buscar(idFunc);
	}
	
	public void alterar(Funcionario func) throws ClassNotFoundException, SQLException {
		this.repository.alterar(func);
	}
	
	public void adcPacoca(Funcionario func) throws ClassNotFoundException, SQLException {
		this.repository.adcPacoca(func);
	}
}
