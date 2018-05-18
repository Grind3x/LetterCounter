import javax.servlet.http.HttpServletRequest;

public class TextDAOHttpImplementation implements TextDAO {
    private HttpServletRequest req;

    public TextDAOHttpImplementation(HttpServletRequest req) {
        this.req = req;
    }

    @Override
    public Text loadText() {
        Text text;
        text = new Text(req.getParameter("text"));
        return text;
    }
}
