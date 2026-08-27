import java.util.List;

public class Warehouse {
    private final List<Product> listOfProduct;
    private final String location;
    private final WarehouseService warehouseService = new WarehouseService();

    public Warehouse(List<Product> listOfProduct, String location) {
        this.listOfProduct = listOfProduct;
        this.location = location;
    }

    public List<Product> getListOfProduct() { return listOfProduct; }
    public String getLocation() { return location; }

    public WarehouseSummary warehouseSummary() {
        return warehouseService.generateSummary(this);
    }

    public List<Product> getOrderInfoBasedOnBusinessLogic() {
        return
                warehouseService.getReorderRecommendations(this);
    }

    @Override
    public String toString() {
        return "Warehouse{location='" + location + "', productCount=" + listOfProduct.size() + "}";
    }
}