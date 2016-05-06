import java.util.ArrayList;

/**
 * Created by a_pan on 06.05.2016.
 */
public class ParsingRequest {
    Writer writer;
    ParsingRequest(){
        writer = new Writer();
    }

    private int libraryCommand(String command){
        ArrayList library = new ArrayList();
        library.add("CREATE DATABASE");
        library.add("CREATE TABLE");
        library.add("INSERT INTO");
        library.add("DELETE ALL FROM");
        library.add("RENAME TABLE");
        library.add("SELECT * FROM");

        return library.indexOf(command);

    }

    public void selectCommand(String request){
        switch (libraryCommand(getCommand(request))){
            case 0: creatDB(request);
                break;
            case 1: creatTable(request);
                break;
            case 2: insertInto(request);
                break;
            case 3: deleteAllFrom(request);
                break;
            case 4: renameTable(request);
                break;
            case 5: selectAllData(request);
                break;
            default:
                System.out.println("Sorry, You command is bad!");
                break;
        }
    }

    private String getCommand(String request){
        return request.substring(0, request.indexOf("%")-1);
    }

    private String getName(String request){
        return request.substring(request.indexOf("%")+1, request.indexOf("%", request.indexOf("%")+1));
    }
    private void creatDB(String request){
        writer.creatDBfile(getName(request));
    }

    private void creatTable(String request){
        writer.creatTabl(getName(request));
    }

    private void insertInto(String request){
        String nameTab = getName(request);
        int values1 = Integer.parseInt(request.substring((request.indexOf("(")+1), request.indexOf(",")));
        String values2 = request.substring(request.indexOf("'")+1, request.indexOf(("'"),request.indexOf("'")+1) );
        writer.add(values1 + "#" + values2);
    }

    private void deleteAllFrom (String request){
        writer.deleteAll(request);

    }

    private void renameTable(String request){
        String oldName = getName(request);
        String newName = request.substring(request.lastIndexOf(("%"), request.lastIndexOf("%")-1)+1, request.lastIndexOf("%"));
        writer.renameTable(oldName, newName);
    }
    private void selectAllData(String request){
        ArrayList <String> getData = writer.printData();
        for (int i = 0; i < getData.size(); i++){
            System.out.println(getData.get(i).substring(0, getData.get(i).indexOf("#")) + "   " + getData.get(i).substring(getData.get(i).indexOf("#")+1));
        }
    }
}
