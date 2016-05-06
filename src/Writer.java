import java.io.*;
import java.util.ArrayList;


/**
 * Created by a_pan on 05.05.2016.
 */
public class Writer {

    private File list;
    private String nameDataBase;
    private RandomAccessFile raf = null;


    public void creatTabl(String nameTable) {
        try {
            list = new File(nameDataBase + System.getProperty("file.separator") + nameTable + ".txt");
            if (list.exists()) {
                list.delete();
                list.createNewFile();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void creatDBfile(String nameDB) {
        nameDataBase = nameDB;
        try {
            new File(nameDB).mkdirs();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


    public void add(Object object) {
        try {
            raf = new RandomAccessFile(list, "rw");
            String s;
            while ((s = raf.readLine()) != null) {
                raf.seek(raf.getFilePointer());
            }
            raf.writeBytes(object.toString() + "\n");
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException i) {
            }
        }
    }


    public void deleteAll(String nameTab) {
        try {
            new FileOutputStream(list, false).close();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public void renameTable(String oldName, String newName) {
        File newTabl = new File(nameDataBase + System.getProperty("file.separator") + newName + ".txt");
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(list)));
            pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(newTabl)), true);
            String str;
            while ((str = br.readLine()) != null) {
                pw.println(str);
            }
        } catch (IOException io) {
        } finally {
            try {
                if (pw != null) {
                    pw.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (IOException io) {
            }
        }
        list.delete();
        newTabl.renameTo(list);
    }


    public ArrayList<String> printData() {
        ArrayList<String> dataInTable = new ArrayList();
        try {
            raf = new RandomAccessFile(list, "r");
            String s;
            int n = 0;
            while ((s = raf.readLine()) != null) {
                dataInTable.add(s);
             }
        } catch (IOException io) {
        } finally {
            try {
                raf.close();
            } catch (IOException i) {
            }
        }
        return dataInTable;
    }

}
