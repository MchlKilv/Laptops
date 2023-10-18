import java.text.DecimalFormat;

class Laptop {
    private String brand;
    private String model;
    private double price;
    private int ram;
    private int storage;
    private String processor;
    private String graphicsCard;
    private String operatingSystem;
    private String manufacturer;

    public Laptop(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.price = generateRandomPrice();
        this.ram = generateRandomRam();
        this.storage = generateRandomStorage();
        this.processor = generateRandomProcessor();
        this.graphicsCard = generateRandomGraphicsCard();
        this.operatingSystem = generateRandomOperatingSystem();
        this.manufacturer = generateRandomManufacturer();
    }

    private double generateRandomPrice() {
        return 300 + Math.random() * (2000 - 300);
    }

    private int generateRandomRam() {
        return (int) (4 + Math.random() * (32 - 4 + 1));
    }

    private int generateRandomStorage() {
        return (int) (128 + Math.random() * (2048 - 128 + 1));
    }

    private String generateRandomProcessor() {
        String[] processors = {"Intel Core i5", "Intel Core i7", "AMD Ryzen 5", "AMD Ryzen 7"};
        int randomIndex = (int) (Math.random() * processors.length);
        return processors[randomIndex];
    }

    private String generateRandomGraphicsCard() {
        String[] graphicsCards = {"NVIDIA GeForce GTX 1650", "NVIDIA GeForce RTX 3060", "Intel UHD Graphics", "AMD Radeon RX 5600M"};
        int randomIndex = (int) (Math.random() * graphicsCards.length);
        return graphicsCards[randomIndex];
    }

    private String generateRandomOperatingSystem() {
        String[] operatingSystems = {"Windows 10", "Windows 11", "macOS Big Sur", "Linux Ubuntu"};
        int randomIndex = (int) (Math.random() * operatingSystems.length);
        return operatingSystems[randomIndex];
    }

    private String generateRandomManufacturer() {
        String[] manufacturers = {"AMD", "Intel"};
        int randomIndex = (int) (Math.random() * manufacturers.length);
        return manufacturers[randomIndex];
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        DecimalFormat df = new DecimalFormat("0.00"); // Форматирование цены до двух знаков после запятой
        System.out.println("Price: $" + df.format(price));
        System.out.println("RAM: " + ram + " GB");
        System.out.println("Storage: " + storage + " GB");
        System.out.println("Processor: " + processor);
        System.out.println("Graphics Card: " + graphicsCard);
        System.out.println("Operating System: " + operatingSystem);
        System.out.println("Manufacturer: " + manufacturer);
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getProcessor() {
        return processor;
    }

    public String getManufacturer() {
        return manufacturer;
    }
}