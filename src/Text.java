import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
    private String text;

    public Text() {
    }

    public Text(String text) {
        this.text = text;
    }

    public Map<Character, Integer> charCount() {
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if (isSupportedChar(text.charAt(i))) {
                Integer n = map.get(Character.toLowerCase(text.charAt(i)));
                if (n == null) map.put(Character.toLowerCase(text.charAt(i)), 1);
                else map.put(Character.toLowerCase(text.charAt(i)), ++n);
            }
        }
        return getSortedMap(map);
    }

    private Map<Character, Integer> getSortedMap(Map<Character, Integer> map) {
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        Map<Character, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());

        }
        return result;
    }

    private boolean isSupportedChar(char ch) {
        Pattern p = Pattern.compile("^[a-z]$");
        Matcher m = p.matcher(ch + "");
        return m.matches();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return Objects.equals(text, text1.text);
    }

    @Override
    public int hashCode() {

        return Objects.hash(text);
    }

    @Override
    public String toString() {
        return "Text{" +
                "text='" + text + '\'' +
                '}';
    }
}
