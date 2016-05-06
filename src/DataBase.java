import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by a_pan on 05.05.2016.
 */
public class DataBase implements Command {
    private CommmandForDB currentCommand;
    private Object key;
    private Object value;
    private String nameDB;
    List<DataBase> allDB = new ArrayList<DataBase>();
    Writer writer = new Writer();



    @Override
    public void insert(String nameDB, Object values) {

        writer.add(values.toString());


    }

    @Override
    public void createTable(String dataBase) {
        try {
            writer.creatTabl(allDB.get(allDB.size()-1).getNameDB(), dataBase);
        }catch (Exception i){
            i.printStackTrace();
              }


    }

    @Override
    public void createDB(String nameDB) {
        DataBase newDB = new DataBase();
        newDB.setNameDB(nameDB);
        allDB.add(newDB);

        try {
            writer.creatFile(nameDB);
        } catch (Exception io) {
            io.printStackTrace();
        }



    }

    @Override
    public void createTable(DataBase dataBase) {


    }

    @Override
    public void cleanDB(String nameDB) {

    }

    @Override
    public void rename(String oldNameDB, String newNameDb) {

    }

    @Override
    public void selectAll(String nameDB) {

    }

    public String getNameDB() {
        return nameDB;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }
}
