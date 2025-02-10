package br.com.rafaelblomer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.rafaelblomer.dao.jdbc.ConnectionFactory;
import br.com.rafaelblomer.domain.Produto;

public class ProdutoDAO implements IProdutoDAO{

	@Override
	public Integer cadastrar(Produto produto) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_PRODUTO (codigo, nome, categoria, preco) VALUES (?, ?, ?, ?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, produto.getCodigo());
			stm.setString(2, produto.getNome());
			stm.setInt(3, produto.getCategoria());
			stm.setFloat(4, produto.getPreco());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed())
				stm.close();
			if (con != null && !con.isClosed())
				con.close();
		}
	}

	@Override
	public Produto consultar(String codigo) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Produto produto = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO WHERE CODIGO = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next())
				produto = new Produto(rs.getLong("id"), rs.getString("nome"), rs.getString("codigo"), rs.getInt("categoria"), rs.getFloat("preco"));
			return produto;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null && !rs.isClosed())
				rs.close();
			if (stm != null && !stm.isClosed())
				stm.close();
			if (con != null && !con.isClosed())
				con.close();
		}
	}

	@Override
	public Integer excluir(Produto produto) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "DELETE FROM TB_PRODUTO WHERE CODIGO = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, produto.getCodigo());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed())
				stm.close();
			if (con != null && !con.isClosed())
				con.close();
		}
	}

	@Override
	public List<Produto> buscarTodos() throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		List<Produto> list = new ArrayList<>();
		ResultSet rs = null;
		Produto produto = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM TB_PRODUTO";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				produto = new Produto(rs.getLong("id"), rs.getString("nome"), rs.getString("codigo"), rs.getInt("categoria"), rs.getFloat("preco"));
				list.add(produto);
			}
			return list;
		} catch (Exception e) {
			throw e;
		} finally {
			if (rs != null && !rs.isClosed())
				rs.close();
			if (stm != null && !stm.isClosed())
				stm.close();
			if (con != null && !con.isClosed())
				con.close();
		}
	}

	@Override
	public Integer atualizar(Produto produto) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "UPDATE TB_PRODUTO SET NOME = ?, CODIGO = ?, CATEGORIA = ?, PRECO = ? WHERE ID = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, produto.getNome());
			stm.setString(2, produto.getCodigo());
			stm.setInt(3, produto.getCategoria());
			stm.setFloat(4, produto.getPreco());
			stm.setLong(5, produto.getId());
			return stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			if (stm != null && !stm.isClosed())
				stm.close();
			if (con != null && !con.isClosed())
				con.close();
		}
	}

}
