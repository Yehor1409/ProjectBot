import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


/*
сценарий работы программы

        1. Приветсвие
           Показать меню программы
           1.Список столов
           2.Сделать резерв
           3.отмена резерва
           4.закончить работу
        2. Показ свободные столы пункт 1.1
        3. Считать выбор стола
        4. Спросить
            имя
            номер телефона
        5. Обновить файл
        6. Показать меню программы
            1.Список столов
            2.отмена резерва
            3.закончить работу


 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в наш ресторан!");
        System.out.println("Выберите из предложеноего  \n" +
                "            1.Список столов\n" +
                "            2.Сделать резерв\n" +
                "            3.Отмена резерва\n" +
                "            4.Закончить работу");

        HashMap<Integer, Boolean> tables = new HashMap<Integer, Boolean>();
        tables.put(1, true);
        tables.put(2, false);
        tables.put(3, false);
        tables.put(4, true);
        tables.put(5, true);

        String path = "C:\\Users\\AIT TR Student\\Desktop\\projekt\\ProjectBot\\code\\selfDef_restaurant\\src\\";
        String file_name = "table_status.txt";
        Client client = new Client();


        Scanner scanner = new Scanner(System.in);
        int menu = scanner.nextInt();
        switch (menu){
            case 1 : // показываем свободные столы
                Table.print_table_status(tables);
            case 2 : // Бронируем стол
                String filePath = Table.create_file(path,file_name); // создали файл для хранения
                Table.save_table_status(tables,filePath); // сделали запись
                Reservation reserve_return = client.reserve_table(tables);
                String reserveInfo = reserve_return.getReserve_info();
                int chosenTable = reserve_return.getTableNumber();
                String oldState = reserve_return.getOldState();
                Table.update_table_status(tables, chosenTable, path, oldState,reserveInfo,file_name);
                Table.print_table_status(tables);
            case 3 :
                Reservation reserve_cancel = client.cancel_reserve_table(tables);
                int canceled_table = reserve_cancel.getTableNumber();
                String canceled_state = reserve_cancel.getCanceledState();
                String old_state = reserve_cancel.getOldState();
                Table.update_table_cancel_status(tables,canceled_table,path,old_state,canceled_state,file_name);
                Table.print_table_status(tables);
            case 4 :
                System.out.println("Спасибо за использование нашей программы");






        }










    }
}

















/*
public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в наш ресторан!");
        // Небольшой ресторан, в котором имеется 5 столиков, хочет внедрить у себя вежливого
        // телефонного администратора (бота), который:
        // - принимает звонок от потенциального клиента;
        // - сообщает о наличии свободных стликов;
        // - при желании клиента выполняет бронирование столика.
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Boolean> tables = new HashMap<Integer, Boolean>();
        // Подготовка к сохранению статуса столов в файле
        String path = "/Users/valentindaines/Meine Ablage/Mein Code/FullStack_23.2/Lesson 32 01.03.23/Conde/Restaurant_bot_1/src/";
        String fileName = "tables_status.txt";
        // задаем статус столиков: все столики свободны
        tables.put(1, false);
        tables.put(2, false);
        tables.put(3, false);
        tables.put(4, false);
        tables.put(5, false);
        boolean is_full = false; // инициализация переменой - в ресторане есть свободные столики

        while (!is_full) { // начало цикла
            //________________________________
            // считывание статуса столиков из файла
            // get_table_status_from_file(); - это надо реализовать
            //________________________________
            // Проверка на наличие свободных столиков
            is_full = is_full(tables, 5); // значение переменной is_full определяется в методе

            if (!is_full) {
                System.out.println("У нас есть свободные столики!");
            } else {
                System.out.println("Извините, у нас все столики заняты.");
                break;
            }

            print_table_status(tables); // метод печатает статус столов
            System.out.println("Выберите номер столика: " ); // запрос к пользователю
            int table_num = sc.nextInt();
            reserv_table(tables, table_num); // метод, который резервирует стол
            // ________________________
            create_file (path, fileName); // создаем файл
            // ________________________
            save_table_status(tables, path, fileName); // сохраняем статус столов в файле
            // ________________________
            print_table_status(tables);
        }  // конец цикла
        System.out.println("Мест нет, приходите позже.");
    }

    public static void reserv_table(HashMap<Integer, Boolean> map, int num) {
        if (map.get(num).equals(false)) {
            map.put(num,true);
            System.out.println("Столик " + num + " зарезервирован." );
            return;
        } else {
            System.out.println("Столик " + num + " уже зарезервирован." );
            return;
        }
    }

    public static void print_table_status(HashMap<Integer, Boolean> map){
        for (Object i : map.keySet()) {
            String status = "";
            if (map.get(i).equals(true)) {
                status = " зарезервирован ";
            } else {status = " свободен ";
            }
            System.out.println("Столик: " + i + " статус: " + status);
        }
    }

    public static boolean is_full(HashMap<Integer, Boolean> map, int num) {
        boolean is_full = true;
        for ( int i = 1; i < 6; i++) {
            if (map.get(i) == false) {
                is_full = false;
            }
        }
        // если все столики зарезервированы, то есть все values в map == true
        return is_full;
    }
    public static void save_table_status(HashMap<Integer, Boolean> map, String path, String file_name) {
        try {
            FileWriter myWriter = new FileWriter(path + file_name);
            // записываем статус столиков в файл
            for (Object i : map.keySet()) {
                String status = "";
                if (map.get(i).equals(true)) {
                    status = " зарезервирован ";
                } else {status = " свободен ";
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

    public static void create_file (String p, String file_name) {
        try {
            File myFile = new File(p + file_name);
            if (myFile.createNewFile()) {
                System.out.println("Файл создан: " + myFile.getName());
            } else {
                System.out.println("Файл уже существует.");
            }
        } catch (IOException e) {
            System.out.println("Произошла ошибка.");
            e.printStackTrace();
        }
    }
    //_____следующий метод ____________

}
*/

