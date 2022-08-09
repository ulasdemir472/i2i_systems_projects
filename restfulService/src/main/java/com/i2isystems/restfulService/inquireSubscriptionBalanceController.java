package com.i2isystems.restfulService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class inquireSubscriptionBalanceController {


    @GetMapping("/giveTelNo")
    public PreparedStatement giveTelNo(int tel_no) throws SQLException {
        tel_no = 171600198;
        Connection connection = DriverManager.getConnection("jdbc:voltdb://localhost:49153");
        PreparedStatement statement = connection.prepareStatement("select * from abone where telno=(?)");
        statement.setInt(1,tel_no);
        statement.executeUpdate();
        return statement;
    }

}
