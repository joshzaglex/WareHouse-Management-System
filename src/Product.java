 public class Product {
        private final int id;
        private final String name;
        private final String category;
        private final double price;      // retail price
        private final double cost;       // cost to warehouse
        private final int quantity;
        private final int reorderThreshold;

        public Product(int id, String name, String category, double price,
                       double cost, int quantity, int reorderThreshold) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.cost = cost;
            this.quantity = quantity;
            this.reorderThreshold = reorderThreshold;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
        public double getCost() { return cost; }
        public int getQuantity() { return quantity; }
        public int getReorderThreshold() { return reorderThreshold; }

        public double getTotalCostValue() { return cost * quantity; }
        public double getTotalRetailValue() { return price * quantity; }

        public boolean isLowStock() { return quantity < reorderThreshold; }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name='%s', category='%s', " +
                            "price=%.2f, cost=%.2f, qty=%d, reorderAt=%d}",
                    id, name, category, price, cost, quantity, reorderThreshold);
        }
    }

