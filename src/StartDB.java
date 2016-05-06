import java.util.TreeMap;

/**
 * Created by a_pan on 05.05.2016.
 */
public class StartDB {
    public static void main(String[] args) {
        ParsingRequest pr = new ParsingRequest();
        pr.selectCommand("CREATE DATABASE %DATABASE_NAME%");
        pr.selectCommand("CREATE TABLE %FileNAME% (  INT NUMBER, STRING NAME )");
        pr.selectCommand("INSERT INTO %FileNAME% VALUES (1, 'CHECK') ");








    }
}
