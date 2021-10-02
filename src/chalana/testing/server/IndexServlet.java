package chalana.testing.server;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "IndexServlet",
        urlPatterns = {"/"})

public class IndexServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String url = request.getRequestURI();
        PrintWriter out = response.getWriter();

        if(url.equalsIgnoreCase("/")){
            //out.println("Server up and running...");
            out.println(index("Server Up and Running..."));
        } else {
            out.println(index("Invalid request"));
        }

    }

    private String index(String str){
        return "<html><head><title>MobAppTestingServer</title></head>" +
                "<body style=\"text-align:center;height: 200px;width: 400px;position: fixed;top: 50%;left: 50%;margin-top: -100px;margin-left: -200px; font-family: verdana;font-size: large;\">" +
                ""+str+"</body>" +
                "</html>";
    }




}