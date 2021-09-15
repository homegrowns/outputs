package person.Item;

public class Item {
    public String name;
    public int categoryNum;
    public int price;


    public Item() {
        this.categoryNum = categoryNum;
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public int getCategoryNum() {
        return categoryNum;
    }

    public int getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCategory(Integer categoryNum) {
        this.categoryNum = categoryNum;
    }


}
