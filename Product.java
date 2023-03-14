public class Product implements Comparable<Product>
{
    public int model;
    public String fabricant;
    public String category;
    public int price;
    public int promotionalPrice;

    public Product(int model, String fabricant, String category, int price, int promotionalPrice) {
        this.model = model;
        this.fabricant = fabricant;
        this.category = category;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public int getPromotionalPrice() {
        return promotionalPrice;
    }

    public void setPromotionalPrice(int promotionalPrice) {
        this.promotionalPrice = promotionalPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "model=" + model +
                ", fabricant='" + fabricant + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o)
    {
        if (price == o.price)
        {
            return 0;
        }
        else if (price > o.price)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
