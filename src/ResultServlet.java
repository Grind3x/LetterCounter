import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/result")
public class ResultServlet extends HttpServlet {
    private static final String HEADER = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "<head>\n" +
            "<title>Letter Counter: result</title>\n" +
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
            "table, th, td {\n" +
            "    padding: 2px\n" +
            "}" +
            "</style>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div class=\"topnav\">\n" +
            "<h4 align=\"center\">The program for counting the number of letters in the text</h4>\n" +
            "</div>\n" +
            "\n" +
            "<div class=\"content\">";
    private static final String FOOTER = "</div>\n" +
            "<div class=\"footer\">\n" +
            "&copy; Grind3x\n" +
            "</div>\n" +
            "</body>\n" +
            "</html>";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String body = "<h4 style=\"color:red\">You must go to the <a href=\"/\">start page</a></h4>";
        PrintWriter pw = resp.getWriter();
        pw.write(HEADER + body + FOOTER);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TextDAO textDAO = new TextDAOHttpImplementation(req);
        TextController textController = new TextController(textDAO);
        Text text = textController.loadText();
        Map<Character, Integer> chars = new LinkedHashMap<>(text.charCount());
        PrintWriter pw = resp.getWriter();
        pw.println(HEADER + "<table>");
        for (Character character : chars.keySet()) {
            pw.println("<tr>\n<td>" + character + "</td>" + "<td>" + chars.get(character) + "</td>\n</tr>\n");
        }
        pw.println("</table><br><br><a href=\"/\">Go back</a>" + FOOTER);
    }
}
