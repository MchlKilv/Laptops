import java.util.*;
import java.util.stream.Collectors;

class LaptopStore {
    private List<Laptop> laptops;

    public LaptopStore() {
        laptops = generateSampleLaptops(15);
    }

    private List<Laptop> generateSampleLaptops(int count) {
        List<Laptop> sampleLaptops = new ArrayList<>();
        String[] brands = {"Dell", "HP", "Lenovo", "Asus", "Acer"};
        String[] models = {"Model A", "Model B", "Model C", "Model D", "Model E"};

        for (int i = 0; i < count; i++) {
            String randomBrand = brands[(int) (Math.random() * brands.length)];
            String randomModel = models[(int) (Math.random() * models.length)];
            Laptop laptop = new Laptop(randomBrand, randomModel);
            sampleLaptops.add(laptop);
        }

        return sampleLaptops;
    }

    public void filterLaptops() {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Object> filters = new HashMap<>();
        List<Integer> availableCriteria = Arrays.asList(1, 2, 3, 4);
        List<Integer> selectedCriteria = new ArrayList<>();

        System.out.println("Доступные критерии фильтрации:");
        System.out.println("1 - ОЗУ (минимальное количество ГБ)");
        System.out.println("2 - Объем жесткого диска (минимальное количество ГБ)");
        System.out.println("3 - Производитель процессора (AMD или Intel)");
        System.out.println("4 - Цена (максимальная цена в USD)");

        System.out.println("Выберите критерии (введите номер критерия, 0 чтобы завершить выбор):");

        int selectedCriterion;
        while (true) {
            selectedCriterion = scanner.nextInt();
            if (selectedCriterion == 0) {
                break;
            } else if (availableCriteria.contains(selectedCriterion)) {
                selectedCriteria.add(selectedCriterion);
            } else {
                System.out.println("Неверный номер критерия. Пожалуйста, введите правильный номер.");
            }
        }

        for (int criterion : selectedCriteria) {
            switch (criterion) {
                case 1:
                    System.out.println("Введите минимальное количество ОЗУ (в ГБ):");
                    filters.put(1, scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Введите минимальное количество жесткого диска (в ГБ):");
                    filters.put(2, scanner.nextInt());
                    break;
                case 3:
                    System.out.println("Введите производителя процессора (0 - AMD, 1 - Intel):");
                    int manufacturer = scanner.nextInt();
                    filters.put(3, manufacturer);
                    break;
                case 4:
                    System.out.println("Введите максимальную цену (в USD):");
                    filters.put(4, scanner.nextDouble());
                    break;
                default:
                    break;
            }
        }

        List<Laptop> filteredLaptops = laptops.stream().filter(laptop -> {
            boolean passesFilter = true;
            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int criterion = entry.getKey();
                Object value = entry.getValue();

                switch (criterion) {
                    case 1:
                        if (laptop.getRam() < (int) value) {
                            passesFilter = false;
                        }
                        break;
                    case 2:
                        if (laptop.getStorage() < (int) value) {
                            passesFilter = false;
                        }
                        break;
                    case 3:
                        if ((int) value == 0 && !laptop.getManufacturer().equalsIgnoreCase("AMD")) {
                            passesFilter = false;
                        } else if ((int) value == 1 && !laptop.getManufacturer().equalsIgnoreCase("Intel")) {
                            passesFilter = false;
                        }
                        break;
                    case 4:
                        if (laptop.getPrice() > (double) value) {
                            passesFilter = false;
                        }
                        break;
                    default:
                        break;
                }
            }
            return passesFilter;
        }).collect(Collectors.toList());

        if (filteredLaptops.isEmpty()) {
            System.out.println("По заданным критериям не найдено ни одного ноутбука.");
        } else {
            System.out.println("Результаты фильтрации:");
            for (Laptop laptop : filteredLaptops) {
                laptop.displayDetails();
                System.out.println();
            }
        }
    }
}