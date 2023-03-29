import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Client {

    String name;
    String numTel;

    public Client() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", numTel='" + numTel + '\'' +
                '}';
    }

    // Метод резерва стола

    public Reservation reserve_table(HashMap<Integer, Boolean> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер стола:");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите Имя: ");
         name = scanner.nextLine();
        System.out.println("Введите номер телефона: ");
         numTel = scanner.nextLine();

        if (map.get(tableNumber).equals(true)) {
            map.put(tableNumber,false);
            System.out.println("Столик " + tableNumber + " зарезервирован успешно." );
        } else {
            System.out.println("Столик " + tableNumber + " уже зарезервирован." );
        }
        String reserve_info = ("Столик: " + tableNumber + " статус:  зарезервирован клиент " + name + " " + numTel);
        String oldState = ("Столик: " + tableNumber + " статус:  свободен ");
        return new Reservation(reserve_info,tableNumber,oldState);

    }
    public Reservation cancel_reserve_table(HashMap<Integer, Boolean> map) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер зарезервированого стола:");
        int tableNumber = scanner.nextInt();
        scanner.nextLine();

        if (map.get(tableNumber).equals(false)) {
            map.put(tableNumber,true);
            System.out.println("Столик " + tableNumber + " отменен успешно." );
        } else {
            System.out.println("Столик " + tableNumber + " свободен." );
        }
        String canceledState = ("Столик: " + tableNumber + " статус:  свободен ");
        String old_state = ("Столик: " + tableNumber + " статус:  зарезервирован клиент " + name + " " + numTel);
        return new Reservation(tableNumber,canceledState,old_state);

    }

}



