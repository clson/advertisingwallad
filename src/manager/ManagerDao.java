package manager;

import model.Manager;

public interface ManagerDao {
    Manager login(Manager manager);

    boolean updatePw(String pw);

    boolean deleteUser(String id);

    boolean deleteAdvertisement(String serialNumber);

    boolean register(Manager manager);
}
