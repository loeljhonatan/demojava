package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;
import com.example.util.DataBaseUtil;

public class UserDAO implements IUserDAO{

    @Override
    public void create(User user) {
  
        Connection connection=null;

        try {
            connection=DataBaseUtil.getConnection();

            String sql = "INSERT INTO usuario(nombre,apellido,edad) VALUES (?,?,?)";

            PreparedStatement pre_statement = connection.prepareStatement(sql);

            pre_statement.setString(1, user.getNombre());
            pre_statement.setString(2, user.getApellido());
            pre_statement.setInt(3, user.getEdad());

            pre_statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("El Driver no existe");
        } catch (SQLException e) {
            System.out.println("no se establecio la conexión");
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    @Override
    public void update(User user) {

        Connection connection=null;

        try {
            connection=DataBaseUtil.getConnection();

            String sql = "UPDATE usuario SET nombre=?,apellido=?,edad=? WHERE id=?";

            PreparedStatement pre_statement = connection.prepareStatement(sql);

            pre_statement.setString(1, user.getNombre());
            pre_statement.setString(2, user.getApellido());
            pre_statement.setInt(3, user.getEdad());
            pre_statement.setInt(4, user.getId());

            pre_statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("El Driver no existe");
        } catch (SQLException e) {
            System.out.println("no se establecio la conexión");
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    @Override
    public void delete(User user) {
        Connection connection=null;

        try {
            connection=DataBaseUtil.getConnection();

            String sql = "DELETE FROM usuario WHERE id=?";

            PreparedStatement pre_statement = connection.prepareStatement(sql);

            pre_statement.setInt(1, user.getId());

            pre_statement.executeUpdate();

        } catch (ClassNotFoundException e) {
            System.out.println("El Driver no existe");
        } catch (SQLException e) {
            System.out.println("no se establecio la conexión");
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

    @Override
    public List<User> findAll() {
        
        List<User> usuarios = new ArrayList<User>();

        Connection connection=null;

        try {
            connection=DataBaseUtil.getConnection();

            String sql = "SELECT * FROM USUARIO";

            Statement cre_statement = connection.createStatement();

            ResultSet resultSet = cre_statement.executeQuery(sql);

           while (resultSet.next()) {
            int id=resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            int edad = resultSet.getInt("edad");

            User user = new User(id,nombre,apellido,edad);
            usuarios.add(user);
            
           }


        } catch (ClassNotFoundException e) {
            System.out.println("El Driver no existe");
        } catch (SQLException e) {
            System.out.println("no se establecio la conexión");
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

         return usuarios;
    }

    @Override
    public User findById(Integer id) {
        
        User user = null;

        Connection connection=null;

        try {
            connection=DataBaseUtil.getConnection();

            String sql = "SELECT * FROM usuario WHERE id=?";

            PreparedStatement pre_statement = connection.prepareStatement(sql);

            pre_statement.setInt(1, id);

            ResultSet resultSet = pre_statement.executeQuery();

            while (resultSet.next()) {

            int current_id=resultSet.getInt("id");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            int edad = resultSet.getInt("edad");

             user = new User(current_id,nombre,apellido,edad);
           ;
            
           }
        
        }catch (ClassNotFoundException e) {
            System.out.println("El Driver no existe");
        } catch (SQLException e) {
            System.out.println("no se establecio la conexión");
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

         return user;
    }

  

}
