

public class Reservation {

    String canceledState;
    String reserve_info;

       int tableNumber;

       String oldState;



    public Reservation(String reserve_info, int tableNumber, String oldState) {
        this.reserve_info = reserve_info;
        this.tableNumber = tableNumber;
        this.oldState = oldState;
    }

    public Reservation() {
    }

    public Reservation(int tableNumber, String canceledState, String oldState) {
        this.canceledState = canceledState;
        this.tableNumber = tableNumber;
        this.oldState = oldState;

    }

    public String getCanceledState() {
        return canceledState;
    }

    public void setCanceledState(String canceledState) {
        this.canceledState = canceledState;
    }

    public String getReserve_info() {
        return reserve_info;
    }

    public void setReserve_info(String reserve_info) {
        this.reserve_info = reserve_info;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getOldState() {
        return oldState;
    }

    public void setOldState(String oldState) {
        this.oldState = oldState;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reserve_info='" + reserve_info + '\'' +
                ", tableNumber=" + tableNumber +
                '}';
    }
}
