public class PC extends Product
{
    double processorSpeed;
    int ramNumber;
    int hardDrive;

    public PC(int model, String fabricant, String category, int price, int promotionalPrice, double processorSpeed, int ramNumber, int hardDrive)
    {
        super(model, fabricant, category, price, promotionalPrice);
        this.processorSpeed = processorSpeed;
        this.ramNumber = ramNumber;
        this.hardDrive = hardDrive;
    }

    public double getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(double processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public int getRamNumber() {
        return ramNumber;
    }

    public void setRamNumber(int ramNumber) {
        this.ramNumber = ramNumber;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    @Override
    public String toString() {
        return "PC{" +
                "processorSpeed=" + processorSpeed +
                ", ramNumber=" + ramNumber +
                ", hardDrive=" + hardDrive +
                '}';
    }
}
