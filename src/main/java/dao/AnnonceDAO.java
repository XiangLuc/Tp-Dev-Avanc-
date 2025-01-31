package dao;

import entities.Annonce;
import utils.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;

public class AnnonceDAO extends DAO<Annonce> {

    public AnnonceDAO() throws SQLException, ClassNotFoundException {
        super(ConnectionDB.getInstance());
    }

    @Override
    public boolean create(Annonce obj) {
        try (PreparedStatement ps = connect.prepareStatement("INSERT INTO annonce (title, description, adress, mail, date) VALUES (?, ?, ?, ?, ?)")) {
            ps.setString(1, obj.getTitle());
            ps.setString(2, obj.getDescription());
            ps.setString(3, obj.getAdress());
            ps.setString(4, obj.getMail());
            ps.setTimestamp(5, obj.getDate());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(Annonce obj) {
        try (PreparedStatement ps = connect.prepareStatement("UPDATE annonce SET title = ?, description = ?, adress = ?, mail = ?, date = ? WHERE id = ?")) {

            ps.setString(1, obj.getTitle());
            ps.setString(2, obj.getDescription());
            ps.setString(3, obj.getAdress());
            ps.setString(4, obj.getMail());
            ps.setTimestamp(5, obj.getDate());
            ps.setInt(6, obj.getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(Annonce obj) {
        try (PreparedStatement ps = connect.prepareStatement("DELETE FROM annonce WHERE id = ?")) {

            ps.setInt(1, obj.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Annonce find(int id) {
        Annonce annonce = null;
        try (PreparedStatement ps = connect.prepareStatement("SELECT * FROM annonce WHERE id = ?")) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    annonce = new Annonce(
                            rs.getInt("id"),
                            rs.getString("title"),
                            rs.getString("description"),
                            rs.getString("adress"),
                            rs.getString("mail"),
                            rs.getTimestamp("date")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonce;
    }

    @Override
    public ArrayList<Annonce> list() {
        ArrayList<Annonce> annonces = new ArrayList<>();
        try (Statement stmt = connect.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM annonce")) {

            while (rs.next()) {
                Annonce annonce = new Annonce(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("adress"),
                        rs.getString("mail"),
                        rs.getTimestamp("date")
                );
                annonces.add(annonce);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonces;
    }
}
