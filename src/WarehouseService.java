import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WarehouseService {

    public WarehouseSummary generateSummary(Warehouse warehouse) {
        List<Product> products = warehouse.getListOfProduct();

        int totalUnits = products.stream().mapToInt(Product::getQuantity).sum();
        double totalCostValue = products.stream().mapToDouble(Product::getTotalCostValue).sum();
        double totalRetailValue = products.stream().mapToDouble(Product::getTotalRetailValue).sum();

        Map<String, Double> retailByCategory = products.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.summingDouble(Product::getTotalRetailValue)));

        return new WarehouseSummary(
                warehouse.getLocation(),
                products.size(),
                totalUnits,
                totalCostValue,
                totalRetailValue,
                retailByCategory
        );
    }

    /**
     * Reorder recommendation logic: any product below its reorder threshold.
     * This is the "business logic" behind getOrderInfoBasedOnBusinessLogic().
     */
    public List<Product> getReorderRecommendations(Warehouse warehouse) {
        return warehouse.getListOfProduct().stream()
                .filter(Product::isLowStock)
                .collect(Collectors.toList());
    }
}