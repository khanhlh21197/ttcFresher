package Collections.Ex2;

public class Bill {
    private int id;
    private String name;
    private long money;
    private String date;

    public Bill(int id, String name, long money, String date) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return id + "    " + name + "    " + money + "   " + date;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Bill){
            Bill another = (Bill) obj;
            if (this.id == another.getId() && this.name.equals(another.getName())){
                return true;
            }
        };
        return false;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
