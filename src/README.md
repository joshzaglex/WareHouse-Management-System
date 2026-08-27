# Warehouse Management System

A Java 17 inventory management engine that models real-world warehouse operations — product tracking, inventory valuation, and automated reorder recommendations — built with clean OOP principles and a dedicated business logic layer.

## Overview

This project simulates the core logic a warehouse system needs to manage stock: calculating inventory value, breaking down holdings by category, and flagging products that need to be reordered before they run out. It's built as the first phase of a larger system that will eventually include order processing and multi-warehouse company-level aggregation.

## Features

- **Inventory valuation** — calculates total cost value and total retail value across all stock
- **Category breakdown** — aggregates retail value by product category
- **Reorder recommendations** — flags products that have dropped below their individual reorder threshold
- **Immutable domain models** — `Product` objects are immutable to prevent accidental state mutation
- **Layered architecture** — business logic is fully separated from domain models

## Architecture

```
com.yourname.warehouse
├── model/
│   ├── Product.java            # Domain object — product data + simple derived values
│   ├── Warehouse.java          # Domain object — holds products, delegates logic
│   └── WarehouseSummary.java   # DTO returned by warehouseSummary()
├── service/
│   └── WarehouseService.java   # Business logic: valuation, breakdown, reorder rules
└── Main.java                   # Sample data + demo run
```

**Design flow:** `Main` builds sample data → `Warehouse` holds it → `Warehouse` delegates all analysis to `WarehouseService` → `WarehouseService` returns a `WarehouseSummary` DTO or a filtered `List<Product>`.

## Sample Output

```
Warehouse Summary [Dallas-TX-01]
  Distinct products: 5
  Total units in stock: 346
  Total cost value: $3,196.50
  Total retail value: $5,589.25
  Retail value by category:
    - Electronics: $2,533.65
    - Furniture: $2,099.90
    - Stationery: $1,300.00

Reorder Recommendations:
  - Product{id=2, name='USB-C Cable', category='Electronics', price=8.99, cost=3.00, qty=15, reorderAt=30}
  - Product{id=3, name='Office Chair', category='Furniture', price=149.99, cost=80.00, qty=8, reorderAt=5}
  - Product{id=4, name='Standing Desk', category='Furniture', price=299.99, cost=180.00, qty=3, reorderAt=5}
```

## Tech Stack

- Java 17
- Streams API
- Object-Oriented Design (encapsulation, immutability, separation of concerns)

## How to Run

```bash
git clone https://github.com/your-username/warehouse-management-system.git
cd warehouse-management-system/src/main/java/com/yourname/warehouse
javac Main.java model/*.java service/*.java
java Main
```

## Design Decisions

- **Service layer over "fat" domain classes** — `Warehouse` never computes its own statistics; all business logic lives in `WarehouseService`. This keeps domain models simple and logic independently testable.
- **Immutable `Product`** — all fields are `final`, preventing accidental mutation once a product is created.
- **DTO for summaries** — `warehouseSummary()` returns a dedicated `WarehouseSummary` object rather than a raw map or string, keeping the return type strongly typed and self-documenting.
- **Pure functions** — business logic methods derive new results without mutating the original warehouse or product state.

## Roadmap

- [ ] **Phase 2:** Introduce `Order` and `Company` classes for multi-warehouse aggregation
- [ ] Company-level business rules: best-selling product, profit across warehouses, order fulfillment tracking
- [ ] Unit tests (JUnit 5)
- [ ] Input validation on `Product` construction

## Author

Built by Joshua as part of a structured Java backend development learning path.
