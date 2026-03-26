package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.JogadorDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Jogador;

@WebServlet(name = "times", value = "/times")
public class TimeServlet extends HttpServlet {
    private final List<Jogador> lista = new ArrayList<>();

    public void adicionarNoTime(Jogador jogador) throws ClassNotFoundException {
        lista.add(jogador);
        JogadorDao jogadorDao = new JogadorDao();
        jogadorDao.adicionarJogador(jogador);
    }

    public List<Jogador> listaDeJogadores() throws ClassNotFoundException {
        JogadorDao jogadorDao = new JogadorDao();
        try {
            return jogadorDao.listarJogadores();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Jogador jogador = new Jogador();
        jogador.setNome(req.getParameter("nomeJogador"));
        jogador.setApelido(req.getParameter("apelidoJogador"));
        jogador.setPosicao(req.getParameter("posicaoJogador"));
        jogador.setIdade(Integer.parseInt(req.getParameter("idadeJogador")));
        try {
            this.adicionarNoTime(jogador);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Dados Cadastrados</title>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h2>Jogador Cadastrado com Sucesso</h2>");
        try {
            for (Jogador j : this.listaDeJogadores()) {
                resp.getWriter().println("<p>Nome do Jogador: " + j.getNome() + "</p>");
                resp.getWriter().println("<p>Apelido do Jogador: " + j.getApelido() + "</p>");
                resp.getWriter().println("<p>Posição do Jogador: " + j.getPosicao() + "</p>");
                resp.getWriter().println("<p>Idade do Jogador: " + j.getIdade() + "</p>");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<html>");
        resp.getWriter().println("<head>");
        resp.getWriter().println("<title>Minha Pagina</title>");
        resp.getWriter().println("</head>");
        resp.getWriter().println("<body>");
        resp.getWriter().println("<h1>Ola Mundo</h1>");
        resp.getWriter().println("</body>");
        resp.getWriter().println("</html>");
    }
}
