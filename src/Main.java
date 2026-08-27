import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "Wireless Mouse", "Electronics", 1934.99,
                        980.50, 120, 20),
                new Product(2, "USB-C Cable", "Electronics", 620.99, 320.00,
                        15, 30),
                new Product(3, "Office Chair", "Furniture", 13250.99,
                        8000.00, 8, 5),
                new Product(4, "Standing Desk", "Furniture", 12599.99,
                        7800.00, 3, 5),
                new Product(5, "Notebook Pack", "Stationery", 1500.50,
                        1200.50, 200, 50)
        );

        Warehouse warehouse = new Warehouse(products, "Dallas-TX-01");

        System.out.println(warehouse.warehouseSummary());

        System.out.println("Reorder Recommendations:");
        List<Product> lowStock = warehouse.getOrderInfoBasedOnBusinessLogic();
        if (lowStock.isEmpty()) {
            System.out.println("  None. All products above reorder threshold.");
        } else {
            lowStock.forEach(p -> System.out.println("  - " + p));
        }
    }
}