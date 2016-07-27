package camel;

/**
 * Created by jszybisty on 7/27/2016.
 */
public class Transformer {

    public String transform(String body) {
        return "Dodano nowy wynik do bazy " + body;
    }
}
