public class Tables {
    int table;
    Boolean reservation;

    public Tables(int table, Boolean reservation) {
        this.table = table;
        this.reservation = reservation;
    }

    public int getTable() {
        return table;
    }

    public void setTable(int table) {
        this.table = table;
    }

    public Boolean getReservation() {
        return reservation;
    }

    public void setReservation(Boolean reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Tables" +
                "table=" + table +
                ", reservation=" + reservation +
                '}';
    }
}
