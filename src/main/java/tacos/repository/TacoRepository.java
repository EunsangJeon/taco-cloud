package tacos.repository;

import tacos.model.TacoDto;

public interface TacoRepository {
    TacoDto save(TacoDto design);
}
