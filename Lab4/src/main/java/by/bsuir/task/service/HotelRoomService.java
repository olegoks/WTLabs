package by.bsuir.task.service;

import by.bsuir.task.domain.entity.HotelRoom;
import by.bsuir.task.exception.DataSourceException;
import by.bsuir.task.exception.CustomException;
import by.bsuir.task.repository.creator.RepositoryCreator;
import by.bsuir.task.repository.impl.RoomRepository;
import by.bsuir.task.query.FindByIdQuery;
import by.bsuir.task.query.room.FindAllQuery;
import by.bsuir.task.query.room.FindFreeQuery;

import java.util.List;
import java.util.Optional;

public class HotelRoomService {

    public List<HotelRoom> findAll() throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindAllQuery());

        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public List<HotelRoom> findFree() throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            return roomRepository.queryAll(new FindFreeQuery());

        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public void save(Integer id, String roomNumber, Boolean occupied) throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            HotelRoom hotelRoom = new HotelRoom(id, roomNumber, occupied);
            roomRepository.save(hotelRoom);

        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }

    public void changeStatus(Integer id, Boolean occupied) throws CustomException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            RoomRepository roomRepository = repositoryCreator.getRoomRepository();
            Optional<HotelRoom> room = roomRepository.query(new FindByIdQuery(id));
            if (room.isPresent()) {
                room.get().setOccupied(occupied);
                roomRepository.save(room.get());
            } else {
                throw new CustomException(String.format("Room with id=%s not found.", id));
            }
        } catch (DataSourceException ex) {
            throw new CustomException(ex.getMessage());
        }
    }
}
