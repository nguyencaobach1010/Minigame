package servlet;

import model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@WebServlet(urlPatterns = {"/random"})
public class RandomNumber extends HttpServlet {
    List<Player> players = new ArrayList<>();
    Random random = new Random();
    int numberRandom = (int) Math.round(Math.random() * 1000);
    int guessCount = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        System.out.println(numberRandom);
        req.getRequestDispatcher("guessNumber.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String strGuessNumber = req.getParameter("guessNumber");
        int guessNumber = 0;
        String message = "";

        if(!strGuessNumber.isEmpty()) {
            guessNumber = Integer.parseInt(strGuessNumber);
        }
         else {
            message = "Vui lòng nhập số bất kì từ 1-1000 !";
            req.setAttribute("players", players);
            req.setAttribute("msg", message);
            req.getRequestDispatcher("guessNumber.jsp").forward(req, resp);
            return;
        }
        if (guessNumber > 1000 || guessNumber < 0) {
            message = "Chỉ nhập số trong phạm vi từ 1 - 1000";
            req.setAttribute("players", players);
            req.setAttribute("msg", message);
            req.getRequestDispatcher("guessNumber.jsp").forward(req, resp);
            return;
        }

        guessCount++;

        if (guessNumber < numberRandom) {
            message = "Số của bạn vừa nhập nhỏ hơn kết quả";
        } else if (guessNumber > numberRandom) {
            message = "Số của bạn vừa nhập lớn hơn kết quả";
        }

        if (guessNumber == numberRandom) {
            message = "CHÚC MỪNG BẠN ĐÃ ĐOÁN ĐÚNG!!";
            Player player = new Player();
            player.setGuessCount(guessCount);
            players.add(player);
            Collections.sort(players);
            numberRandom = (int) Math.round(Math.random() * 1000);
            guessCount = 0;
        }
        req.setAttribute("players", players);
        req.setAttribute("msg", message);
        req.getRequestDispatcher("guessNumber.jsp").forward(req, resp);
    }
}
