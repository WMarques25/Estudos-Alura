package br.com.alura.bytebank.domain.conta;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import br.com.alura.bytebank.domain.cliente.Cliente;
import br.com.alura.bytebank.domain.cliente.DadosCadastroCliente;

public class ContaDAO {

    private Connection conn;
    
    ContaDAO(Connection connection) {
        this.conn = connection;
    }

    public void salvar(DadosAberturaConta dadosDaConta) {
        var cliente = new Cliente(dadosDaConta.dadosCliente());
        var conta = new Conta(dadosDaConta.numero(), BigDecimal.ZERO, cliente, true);
        
        String sql = "INSERT INTO conta (numero, saldo, cliente_nome, cliente_cpf, cliente_email)" +
            "VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, conta.getNumero());
            preparedStatement.setBigDecimal(2, BigDecimal.ZERO);
            preparedStatement.setString(3, dadosDaConta.dadosCliente().nome());
            preparedStatement.setString(4, dadosDaConta.dadosCliente().cpf());
            preparedStatement.setString(5, dadosDaConta.dadosCliente().email());
            preparedStatement.setBoolean(6, true);

            preparedStatement.execute();
            preparedStatement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    public Set<Conta> listar() {
        PreparedStatement ps;
        ResultSet rs;
        Set<Conta> contas = new HashSet<>();

        String sql = "SELECT * FROM conta WHERE esta_ativa = true";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                var numero = rs.getInt(1);
                var saldo = rs.getBigDecimal(2);
                var nome = rs.getString(3);
                var cpf = rs.getString(4);
                var email = rs.getString(5);
                var estaAtiva = rs.getBoolean(6);

                var dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);

                var cliente = new Cliente(dadosCadastroCliente);
                contas.add(new Conta(numero, saldo, cliente, estaAtiva)); 
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contas;
    }

    public Conta listarPorNumero(Integer numero){
        String sql = "SELECT * FROM conta WHERE numero = ? and esta_ativa = true";

        PreparedStatement ps;
        ResultSet rs;
        Conta conta = null;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numero);
            rs = ps.executeQuery();

            while(rs.next()){
                var numeroConta = rs.getInt(1);
                var saldo = rs.getBigDecimal(2);
                var nome = rs.getString(3);
                var cpf = rs.getString(4);
                var email = rs.getString(5);
                var estaAtiva = rs.getBoolean(6);

                var dadosCadastroCliente = new DadosCadastroCliente(nome, cpf, email);
                Cliente cliente = new Cliente(dadosCadastroCliente);

                conta = new Conta(numeroConta, saldo, cliente, estaAtiva);
            }
            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conta;
    }

    public void alterar(Integer numero, BigDecimal valor){
        
        String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ps.setBigDecimal(1, valor);
            ps.setInt(2, numero);
            ps.execute();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void deletar(Integer numero){
        String sql = "DELETE FROM conta WHERE numero = ?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numero);
            ps.execute();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarLogico(Integer numeroDaConta) {
        String sql = "UPDATE conta SET esta_ativa = false WHERE numero = ?";

        PreparedStatement ps;

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, numeroDaConta);
            ps.execute();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
