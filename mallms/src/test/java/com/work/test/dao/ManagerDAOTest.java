package com.work.test.dao;

import com.work.mallms.dao.ManagerDAO;
import com.work.mallms.dto.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerDAOTest {
    private ManagerDAO managerDAO = new ManagerDAO();
    @Test
    public void selectManagerByLoginName() {
        Manager manager = managerDAO.selectManagerByLoginName("admin");
        assertNotNull(manager);
    }
}