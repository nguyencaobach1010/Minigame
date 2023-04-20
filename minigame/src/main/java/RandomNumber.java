import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="randomNumber", urlPatterns = {"/random"})
public class RandomNumber extends HttpServlet {
    List<Player> listPlayer = new ArrayList<Player>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String playerName = req.getParameter("playerName");
        int guessNumber = Integer.parseInt(req.getParameter("guessNumber"));
        int rank = Integer.parseInt(req.getParameter("rank"));

        Player player = new Player();
        player.setRank(rank);
        player.setName(playerName);
        player.setGuessNumber(guessNumber);

        listPlayer.add(player);

        req.setAttribute("Player", listPlayer);
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }
}
