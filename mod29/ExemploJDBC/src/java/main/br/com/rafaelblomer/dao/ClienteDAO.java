package br.com.rafaelblomer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.rafaelblomer.dao.jdbc.ConnectionFactory;
import br.com.rafaelblomer.domain.Cliente;

public class ClienteDAO implements IClienteDAO {

	@Override
	public Integer cadastrar(Cliente cliente) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "INSERT INTO TB_CLIENTE (codigo, nome) VALUES (?, ?)";
			stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
			stm.setString(2, cliente.getNome());
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
	public Cliente consultar(String codigo) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_cliente where codigo = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, codigo);
			rs = stm.executeQuery();
			if (rs.next())
				cliente = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getString("codigo"));
			return cliente;
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
	public Integer excluir(Cliente cliente) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "DELETE FROM tb_cliente where codigo = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getCodigo());
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
	public List<Cliente> buscarTodos() throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		List<Cliente> list = new ArrayList<>();
		ResultSet rs = null;
		Cliente cliente = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM tb_cliente";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			while (rs.next()) {
				cliente = new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getString("codigo"));
				list.add(cliente);
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
	public Integer atualizar(Cliente cliente) throws Exception {
		Connection con = null;
		PreparedStatement stm = null;
		try {
			con = ConnectionFactory.getConnection();
			String sql = "UPDATE TB_CLIENTE SET nome = ?, codigo = ? where id = ?";
			stm = con.prepareStatement(sql);
			stm.setString(1, cliente.getNome());
			stm.setString(2, cliente.getCodigo());
			stm.setLong(3, cliente.getId());
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
