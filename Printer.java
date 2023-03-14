public class Printer extends Product
{
    boolean color;
    String type;

    public Printer(int model, String fabricant, String category, int price, int promotionalPrice, boolean color, String type)
    {
        super(model, fabricant, category, price, promotionalPrice);
        this.color = color;
        this.type = type;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "color=" + color +
                ", type='" + type + '\'' +
                '}';
    }
}
