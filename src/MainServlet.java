import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class MainServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "<title>Letter Counter: home page</title>\n" +
                "<meta charset=\"utf-8\">\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "<style>\n" +
                "\n" +
                "body {\n" +
                "  margin: 0;\n" +
                "  font-family: Arial, Helvetica, sans-serif;\n" +
                "}\n" +
                ".topnav {\n" +
                "    color: white;\n" +
                "    overflow: hidden;\n" +
                "    background-color: lightblue;\n" +
                "}\n" +
                ".content {\n" +
                "    background-color: #ddd;\n" +
                "    padding: 10px;\n" +
                "}\n" +
                ".footer {\n" +
                "    background-color: lightgreen;\n" +
                "    padding: 10px;\n" +
                "}\n" +
                "textarea\n" +
                "{\n" +
                "  width:100%;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"topnav\">\n" +
                "<h4 align=\"center\">The program for counting the number of letters in the text</h4>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\"content\">\n" +
                "  <form action=\"/result\" method=\"post\">\n" +
                "      <textarea name=\"text\" rows=\"10\"></textarea><br><br>\n" +
                "      <input type=\"submit\" value=\"Count\" style=\"position: absolute; right: 0;\"><br>\n" +
                "  </form>\n" +
                "</div>\n" +
                "<div class=\"footer\">\n" +
                "&copy; Grind3x\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";

        PrintWriter pw = resp.getWriter();
        pw.write(html);
    }
}
