package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.OrderDto;

public interface OrderRepository
    extends CrudRepository<OrderDto, Long> {
}
