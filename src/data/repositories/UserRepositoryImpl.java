package data.repositories;

import data.models.User;

import java.util.ArrayList;

import java.util.List;

public class UserRepositoryImpl implements UserRepository{
    private int count;

    private List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
//        boolean userHasNotBeenSaved = user.getId() ==0;
//        if (userHasNotBeenSaved) saveNew(user);
        if (user.getId() == 0) saveNewUser(user);
        return user;
    }

    private void saveNewUser(User user) {
        user.setId(generateUserId());
        users.add(user);
        count++;
    }

    private void saveNew(User user) {
        user.setId(generateUserId());
        users.add(user);
        count++;
    }

    private int generateUserId() {
        return count+1;
    }

    @Override
    public User findById(int id) {
        for (User user : users) if (user.getId() == id) return  user;
        return null;
    }

    @Override
    public long count() {
        return count;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void delete(int id) {
        for(User user : users){
            boolean userHasNotBeenSaved = user.getId() ==id;
            if (userHasNotBeenSaved){
                users.remove(user);
                count--;
                break;
            }
        }
    }

    @Override
    public void deleteAll() {

    }
}
