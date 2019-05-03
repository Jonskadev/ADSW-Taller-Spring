package com.adsw.ADSWDemo.DAO;

import com.adsw.ADSWDemo.model.User;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.*;


@Repository("fakeUserDAO")
public class FakeUserDaoImpl implements UserDAO{

    private final Map<UUID, User> database;

    public FakeUserDaoImpl() {
        database = new HashMap<>();
        UUID userId = UUID.randomUUID();
        database.put(userId, new User(userId, 26,"Juanito", "Perez", "cocina avanzada con microondas"));
    }


    @Override
    public int insertNewUser(UUID userId, User user) {
        database.put(userId, user);
        return 1;
    }

    @Override
    public User selectUserById(UUID userId) {
        return database.get(userId);
    }

    @Override
    public List<User> selectAllUsers() {
        return new ArrayList<>(database.values());
    }

    @Override
    public int updateUserById(UUID userId, User userUpdate) {
        database.put(userId, userUpdate);
        return 1;
    }

    @Override
    public int deleteUserById(UUID userId) {
        database.remove(userId);
        return 0;
    }

}
