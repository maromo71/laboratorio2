package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Jogador;

public class JogadorDao {
 private final Connection connection;

    public JogadorDao() throws ClassNotFoundException {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adicionarJogador(Jogador jogador) {
        String sql = "insert into jogadores(nomeJogador, "
        + " apelidoJogador, posicaoJogador, idadeJogador) "
                +
                " values(?,?,?,?);";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, jogador.getNome());
            stmt.setString(2, jogador.getApelido());
            stmt.setString(3, jogador.getPosicao());
            stmt.setInt(4, jogador.getIdade());
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Jogador> listarJogadores() throws SQLException {
        List<Jogador> lista = new ArrayList<>();
        String sql = "Select * from jogadores";
        ResultSet resultSet = null;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                Jogador jogador = new Jogador();
                jogador.setNome(resultSet.getString("nomeJogador"));
                jogador.setApelido(resultSet.getString("apelidoJogador"));
                jogador.setPosicao(resultSet.getString("posicaoJogador"));
                jogador.setIdade(resultSet.getInt("idadeJogador"));
                lista.add(jogador);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            if (resultSet != null)
                resultSet.close();
        }
        return lista;
    }
}
