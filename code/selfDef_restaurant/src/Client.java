public class Client {

    String name;
    int id;
    String numTel;

    public Client(String name, int id, String numTel) {
        this.name = name;
        this.id = id;
        this.numTel = numTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumTel() {
        return numTel;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    @Override
    public String toString() {
        return "Client name = " + name +  " id = " + id +  " numTel='" + numTel ;
    }
}
