package br.com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.model.Funcionario;
import br.com.service.FuncionarioService;

@WebServlet("/FuncionarioController")
public class FuncionarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private FuncionarioService service;
	private Funcionario func;
	
    public FuncionarioController() throws ClassNotFoundException, SQLException {
    	
    	this.service = new FuncionarioService();
    	this.func = new Funcionario();

    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		System.out.println(action);
		
		//if(action == null)	
			//action = "atualizar";
		
		
		try {
			switch (action) {
				
			case "buscar":
				buscar(request, response);
				break;
					
			case "deletar": 
				deletar(request, response);
				break;
					
			case "alterar":
				alterar(request, response);
				break;
			
			case "adcpacoca":
				adcPacoca(request, response);
				break;
					
			case "listar":
				listar(request, response);
				break;
				
			case "redirect":
				redirect(request, response);
				break;
					
			default:
				listar(request, response);
				break;
			}
				
		}catch (SQLException | ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}
		
    public void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	ArrayList<Funcionario> funcs = this.service.listar();
    	request.setAttribute("funcs", funcs);
    	RequestDispatcher rd = request.getRequestDispatcher("cadastro_funcionario.jsp");
    	rd.forward(request, response);
    }
    
    public void redirect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	ArrayList<Funcionario> funcsa = this.service.listar();
    	request.setAttribute("funcsa", funcsa);
    	RequestDispatcher rd = request.getRequestDispatcher("acoes_funcionario.jsp");
    	rd.forward(request, response);
    }
    
    public void deletar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
    	long idFunc = Long.parseLong(request.getParameter("id"));
    	this.service.deletar(idFunc);
    	listar(request,response);
    }
	
	public void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
		long id = Long.parseLong(request.getParameter("id"));
		Funcionario funcB = this.service.buscar(id);
		request.setAttribute("func", funcB);
		RequestDispatcher rd = request.getRequestDispatcher("acoes_funcionario.jsp");
		rd.forward(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Chegou para Salvar");
		String nome = request.getParameter("nome");
		System.out.println(nome);
		String setor = request.getParameter("setor");
		System.out.println(setor);
		int quantPacocas = Integer.parseInt(request.getParameter("quant"));
		System.out.println(quantPacocas);
		
		
		this.func.setNome(nome);
		this.func.setSetor(setor);
		this.func.setQuantPacocas(quantPacocas);
		
		try {
			this.service.salvar(this.func);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error ao Gravar no Funcionario -> " +e);
		}
		
		try {
			listar(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error ao Listar Funcionario(s) -> " +e);
		}
		
	}
	
	public void alterar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
    	
		long id = Long.parseLong(request.getParameter("id"));
		
		String nome = request.getParameter("nome");
		String setor = request.getParameter("setor");
		int quantPacocas = Integer.parseInt(request.getParameter("quant"));
		
		Funcionario funcAlt = new Funcionario();
		
		funcAlt.setNome(nome);
		funcAlt.setSetor(setor);
		funcAlt.setQuantPacocas(quantPacocas);
		funcAlt.setId(id);
		
		this.service.alterar(funcAlt);
		
		listar(request, response);
    }
	
	public void adcPacoca(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		long id = Long.parseLong(request.getParameter("id"));
		int quantPacocas;
		
		int quantPacocasN = 1;
		
		Funcionario funcAdcP = this.service.buscar(id);
		
		int auxQuantPacocas = funcAdcP.getQuantPacocas();
		
		quantPacocas = quantPacocasN + auxQuantPacocas;
		
		funcAdcP.setQuantPacocas(quantPacocas);
		
		this.service.adcPacoca(funcAdcP);
		listar(request, response);
    }
}
