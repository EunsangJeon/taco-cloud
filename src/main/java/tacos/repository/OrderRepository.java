package tacos.repository;

import tacos.model.OrderDto;

public interface OrderRepository {
    OrderDto save(OrderDto order);
}
