package service;

import vo.Employee;

public interface Manager {
    public void getFile();
    public void saveFile();
    public boolean insertEmployee(Employee employee);
    public Employee findEmployee(String eid);
    public boolean deleteEmployee(String eid);
    public void showAll();
}
