import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by a_pan on 05.05.2016.
 */
public class StartDB {
    public static void main(String[] args) {
        ParsingRequest pr = new ParsingRequest();
        Scanner in = new Scanner(System.in);
        pr.selectCommand(in.nextLine());
        pr.selectCommand("CREATE DATABASE %DATABASE_NAME%");
        pr.selectCommand("CREATE TABLE %FileNAME% (  INT NUMBER, STRING NAME )");
        pr.selectCommand("INSERT INTO %FileNAME% VALUES (1, 'CHECK') ");
        pr.selectCommand("INSERT INTO %FileNAME% VALUES (2, 'qqq') ");
        pr.selectCommand("INSERT INTO %FileNAME% VALUES (3, 'wwww') ");
        pr.selectCommand("INSERT INTO %FileNAME% VALUES (4, 'rrrr') ");
        //pr.selectCommand("DELETE ALL FROM %TABLE_NAME%");

        pr.selectCommand("RENAME TABLE %FileNAME% INTO %popops%");
        pr.selectCommand(in.nextLine());
        //pr.selectCommand("SELECT * FROM %popops%");









    }
}
