package com.example.accountManagement;

import com.example.accountManagement.controller.AccountManagementController;
import com.example.accountManagement.dao.UserDao;
import com.example.accountManagement.model.User;
import com.example.accountManagement.service.AccountManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import java.util.List;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountManagementController.class)
public class ControllerTest {

    @MockBean
    private AccountManagementService accountManagementService;

    @MockBean
    private UserDao userDao;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReturn200() throws Exception {
        given(userDao.getAllUsers()).willReturn(List.of(new User(1, "Name Name"), new User(2, "Noim Noim")));
        mockMvc.perform(get("/api/user/users")).andExpect(status().isOk());
    }
}
