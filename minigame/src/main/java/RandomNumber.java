import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "randomNumber", urlPatterns = {"/random"})
public class RandomNumber extends HttpServlet {
    List<Player> listPlayer = new ArrayList<>();
    int random = (int) Math.round( Math.random() * 1000);
    int numOfGuess = 0;
    String message = "";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.out.println(random);
        req.getRequestDispatcher("guessNumber.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");

        String playerName = req.getParameter("name");
        String strGuessNumber = req.getParameter("guessNumber");
        int guessNumber = 0;

        if(!strGuessNumber.isEmpty()){
            guessNumber = Integer.parseInt(strGuessNumber);
        }


        Player player = new Player();
        player.setName(playerName);
        player.setGuessNumber(guessNumber);
        if (guessNumber < random) {
            numOfGuess++;
            message="Số của bạn nhỏ hơn của tôi";
        }
        else if (guessNumber > random) {
            numOfGuess++;
            message="Số của bạn lớn hơn của tôi";

        }
        else {
            numOfGuess++;
            message="Chúc mừng " + playerName + " đã đoán chính xác.";
            player.setName(playerName);
            player.setGuessNumber(guessNumber);
            player.setNumOfGuess(numOfGuess);
            listPlayer.add(player);
        }

        req.setAttribute("Player", listPlayer);
        req.setAttribute("message",message);
        req.getRequestDispatcher("guessNumber.jsp").forward(req, resp);

    }
}
