import java.util.Map;

public class WarehouseSummary {
    private final String location;
    private final int totalProducts;
    private final int totalUnits;
    private final double totalCostValue;
    private final double totalRetailValue;
    private final Map<String, Double> retailValueByCategory;

    public WarehouseSummary(String location, int totalProducts, int totalUnits,
                             double totalCostValue, double totalRetailValue,
                             Map<String, Double> retailValueByCategory) {
        this.location = location;
        this.totalProducts = totalProducts;
        this.totalUnits = totalUnits;
        this.totalCostValue = totalCostValue;
        this.totalRetailValue = totalRetailValue;
        this.retailValueByCategory = retailValueByCategory;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Warehouse Summary [").append(location).append("]\n")
          .append(String.format("  Distinct products: %d%n", totalProducts))
          .append(String.format("  Total units in stock: %d%n", totalUnits))
          .append(String.format("  Total cost value: #%.2f%n", totalCostValue))
          .append(String.format("  Total retail value: #%.2f%n", totalRetailValue))
          .append("  Retail value by category:\n");
        retailValueByCategory.forEach((cat, val) ->
                sb.append(String.format("    - %s: #%.2f%n", cat, val)));
        return sb.toString();
    }
}