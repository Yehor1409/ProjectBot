import java.io.*;
import java.util.HashMap;

public class Table {
    int tableNum; // номер стола

    Boolean isReserved; // показывает стотус стола

    public Table(int tableNum, Boolean isReserved) {
        this.tableNum = tableNum;
        this.isReserved = isReserved;
    }

    public int getTableNum() {
        return tableNum;
    }

    public void setTableNum(int tableNum) {
        this.tableNum = tableNum;
    }

    public Boolean getReserved() {
        return isReserved;
    }

    public void setReserved(Boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Table{" +
                "tableNum=" + tableNum +
                ", isReserved=" + isReserved +
                '}';
    }

    // Метод который обновит файл со статусом столов
    public static String create_file(String path, String file_name) {

        File myFile = null;

        try {
            myFile = new File(path + file_name);
            if (myFile.createNewFile()) {
                System.out.println("Файл создан: " + myFile.getName());

            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }
        String newPath = myFile.getPath();
        System.out.println(newPath);
        return newPath;


    }



    public static void save_table_status(HashMap<Integer, Boolean> map, String path) {
        try {
            FileWriter myWriter = new FileWriter(path);
            // записываем статус столиков в файл
            for (Object i : map.keySet()) {
                String status = "";
                if (map.get(i).equals(true)) {
                    status = " свободен ";
                } else {status = " зарезервирован ";
                }
                myWriter.write("Столик: " + i + " статус: " + status + '\n'); // запись в файл и переход на сл. строку
                // System.out.println();
            }
            myWriter.close();
            System.out.println("Успешная запись в файл.");
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }

    }
    // Перезапись статцса столов в файле
    public static void update_table_status (HashMap < Integer, Boolean > map,int tableNum, String path,
                                            String oldTableInfo, String newTableInfo, String fileName)
            throws IOException {
        map.put(tableNum,false);
        File fileToBeModified = new File(path+fileName);
        String oldContent = "";
        BufferedReader reader = null;
        System.out.println(oldTableInfo+" old info do try catch");
        System.out.println(newTableInfo+" new info do try catch");

        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            // Считываем все строки из файла в переменную oldContent
            String line = reader.readLine(); // буферная переменная для записи
            while (line != null)
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent
            // Замена oldString на newString в oldContent
            String newContent = oldContent.replaceAll(oldTableInfo, newTableInfo);

            System.out.println(oldTableInfo+" old info v try catch");
            System.out.println(newTableInfo+" new info v try catch");

            System.out.println(newContent);
            //Rewriting the input text file with newContent
            // Переписываем файл
            FileWriter myWriter = new FileWriter(path+fileName);
            System.out.println(path+fileName);
            myWriter.write(newContent);
            System.out.println(newContent);
            myWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                //Closing the resources
                reader.close();
            //    myWriter.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static void modifyFile(String filePath, String oldString, String newString){



                FileWriter writer = null;



    }


        // метод который считывает состояние столов
        public static void print_table_status (HashMap < Integer, Boolean > map){
            for (Object i : map.keySet()) {
                String status = "";
                if (map.get(i).equals(true)) {
                    status = " свободен ";
                } else {
                    status = " зарезервирован ";
                }
                System.out.println("Столик: " + i + " статус: " + status);
            }
        }


    }

