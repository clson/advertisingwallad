package manager;

import model.Manager;

public class ManagerService {
    private MangerDaoImpl managerDao=new MangerDaoImpl();

    public Manager login(Manager manager) {
        managerDao.setLogin(manager);
      return managerDao.login(manager);
    }

    public boolean deleteUser(Manager manager,String id) {
        managerDao.setLogin(manager);
        return managerDao.deleteUser(id);
    }

    public boolean deleteAdvertisement(Manager manager,String serialNumber) {
        managerDao.setLogin(manager);
        return managerDao.deleteAdvertisement(serialNumber);
    }
    public boolean updatePw(Manager manager,String pw) {
        managerDao.setLogin(manager);
        return managerDao.updatePw(pw);
    }

    public boolean register(Manager manager) {
        return managerDao.register(manager);
    }
}
