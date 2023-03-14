public class Laptop extends Product
{
    double processorSpeed;
    int ram;
    int hardDrive;
    double screenSize;

    public Laptop(int model, String fabricant, String category, int price, int promotionalPrice, double processorSpeed, int ram, int hardDrive, double screenSize)
    {
        super(model, fabricant, category, price, promotionalPrice);
        this.processorSpeed = processorSpeed;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.screenSize = screenSize;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(double processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "processorSpeed=" + processorSpeed +
                ", ram=" + ram +
                ", hardDrive=" + hardDrive +
                ", screenSize=" + screenSize +
                '}';
    }
}
