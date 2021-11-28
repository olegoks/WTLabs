package by.bsuir.task.repository.impl;

import by.bsuir.task.domain.mapper.HotelRoomMapper;
import by.bsuir.task.domain.entity.HotelRoom;
import by.bsuir.task.exception.DataSourceException;
import by.bsuir.task.repository.AbstractRepository;
import by.bsuir.task.query.CustomQuery;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomRepository extends AbstractRepository<HotelRoom> {
    private static final String TABLE_NAME = " `room` ";

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String OCCUPIED = "occupied";

    private static final String SELECT_QUERY = "SELECT * FROM `room` ";

    public RoomRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(HotelRoom item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(ROOM_NUMBER, item.getRoomNumber());
        values.put(OCCUPIED, item.getOccupied());
        values.put(ID, item.getId());

        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<HotelRoom> query(CustomQuery customQuery) throws DataSourceException {
        String query = SELECT_QUERY + customQuery.toSql();
        List<Object> params = customQuery.getParameters();
        return executeQueryForSingleResult(query, new HotelRoomMapper(), params);
    }

    @Override
    public List<HotelRoom> queryAll(CustomQuery customQuery) throws DataSourceException {
        String query = SELECT_QUERY + customQuery.toSql();
        List<Object> params = customQuery.getParameters();
        return executeQuery(query, new HotelRoomMapper(), params);
    }
}
