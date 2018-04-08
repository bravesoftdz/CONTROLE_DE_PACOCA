package br.com.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.connection.Conexao;
import br.com.model.Funcionario;

public class FuncionarioRepository {
	
	private Connection con;
	
	public FuncionarioRepository() throws ClassNotFoundException, SQLException {
		
		con = Conexao.getConnection();
	}
	
	public boolean salvar(Funcionario func) throws ClassNotFoundException, SQLException {
		
		this.con = Conexao.getConnection();
		String insert = "INSERT INTO funcionarioXpacoca (nome,setor,quantPacocas) VALUES(?,?,?) ";
		PreparedStatement state = this.con.prepareStatement(insert);
		
		state.setString(1, func.getNome());
		state.setString(2, func.getSetor());
		state.setInt(3, func.getQuantPacocas());
		
		boolean salvo = state.executeUpdate() > 0;
		state.close();
		this.con.close();
		
		return salvo;
	}
	
	public ArrayList<Funcionario> listar() throws ClassNotFoundException, SQLException{
		
		this.con = Conexao.getConnection();
		ArrayList <Funcionario> funcionarios = new ArrayList();
		String select = "SELECT * FROM funcionarioXpacoca ";
		PreparedStatement state = this.con.prepareStatement(select);
		
		ResultSet res = state.executeQuery();
		
		while(res.next()) {
			
			Funcionario func = new Funcionario();
			func.setId(res.getLong("id"));
			func.setNome(res.getString("nome"));
			func.setSetor(res.getString("setor"));
			func.setQuantPacocas(res.getInt("quantPacocas"));
			
			funcionarios.add(func);
		}
		
		res.close();
		state.close();
		this.con.close();
		
		return funcionarios;
	}
	
	public boolean deletar(Long idFunc) throws ClassNotFoundException, SQLException {
		
		this.con = Conexao.getConnection();
		String delete = "DELETE FROM funcionarioXpacoca WHERE id = ? ";
		PreparedStatement state = this.con.prepareStatement(delete);
		
		state.setLong(1, idFunc);
		
		boolean deletado = state.executeUpdate() > 0;
		
		state.close();
		this.con.close();
		
		return deletado;
	}
	
	public Funcionario buscar(Long idFunc) throws ClassNotFoundException, SQLException {
		
		this.con = Conexao.getConnection();
		Funcionario func = new Funcionario();
		String busca = "SELECT * FROM funcionarioXpacoca WHERE id = ? ";
		PreparedStatement state = this.con.prepareStatement(busca);
		
		state.setLong(1, idFunc);
		
		ResultSet res = state.executeQuery();
		
		while(res.next()) {
			
			func.setId(res.getLong("id"));
			func.setNome(res.getString("nome"));
			func.setSetor(res.getString("setor"));
			func.setQuantPacocas(res.getInt("quantPacocas"));
		}
		
		res.close();
		state.close();
		this.con.close();
		
		return func;
	}
	
	public boolean alterar(Funcionario func) throws ClassNotFoundException, SQLException {
		
		this.con = Conexao.getConnection();
		String update = "UPDATE funcionarioXpacoca SET nome = ?, setor = ?, quantPacocas = ? WHERE id = ? ";
		PreparedStatement state = this.con.prepareStatement(update);
		
		state.setString(1, func.getNome());
		state.setString(2, func.getSetor());
		state.setInt(3, func.getQuantPacocas());
		state.setLong(4, func.getId());
		
		boolean alterado = state.executeUpdate() > 0;
		state.close();
		this.con.close();
		
		return alterado;
	}
	
	public boolean adcPacoca(Funcionario func) throws ClassNotFoundException, SQLException {
		
		this.con = Conexao.getConnection();
		String adcPacocas = "UPDATE funcionarioXpacoca SET quantPacocas = ? WHERE id = ? ";
		PreparedStatement state = this.con.prepareStatement(adcPacocas);
		
		state.setInt(1, func.getQuantPacocas());
		state.setLong(2, func.getId());
		
		boolean incrementado = state.executeUpdate() > 0;
		
		state.close();
		this.con.close();
		
		return incrementado;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
}
