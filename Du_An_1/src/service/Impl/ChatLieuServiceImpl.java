package service.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import ultil.DBConnect;

public class ChatLieuServiceImpl {

    List<ChatLieu> listchatlieu = new ArrayList<>();

    public List<ChatLieu> getAllChatLieu() {
        listchatlieu.clear();
        try {
            String sql = "select MaChatLieu,TenChatLieu from ChatLieu";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ChatLieu chatlieu = new ChatLieu();
                chatlieu.setMaChatLieu(rs.getString(1));
                chatlieu.setTenChatLieu(rs.getString(2));
                listchatlieu.add(chatlieu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listchatlieu;
    }

    public ChatLieu getRowChatlieu(int rowChatlieu) {
        return listchatlieu.get(rowChatlieu);
    }

    public void Them(ChatLieu chatlieu) {
        try {
            String sql = "Insert into ChatLieu(MaChatLieu,TenChatLieu) VALUES(?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, chatlieu.getMaChatLieu());
            stm.setString(2, chatlieu.getTenChatLieu());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(ChatLieu chatlieu) {
        try {
            String sql = "Update ChatLieu set TenChatlieu=?  where MaChatLieu=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(2, chatlieu.getMaChatLieu());
            stm.setString(1, chatlieu.getTenChatLieu());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
