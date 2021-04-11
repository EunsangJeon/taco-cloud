package tacos.repository;

import org.springframework.data.repository.CrudRepository;
import tacos.model.TacoDto;

public interface TacoRepository
    extends CrudRepository<TacoDto, Long> {
}
