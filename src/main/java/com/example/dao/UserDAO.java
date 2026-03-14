package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;
import com.example.util.DataBaseUtil;

public class UserDAO implements IUserDAO{

    @Override
    public void create(User user) {
  
        try(Connection connection=DataBaseUtil.getConnection()){

             final String SQLsentencia = "INSERT INTO usuario(nombre,apellido,edad) VALUES (?,?,?)";

            try(PreparedStatement pre_statement = connection.prepareStatement(SQLsentencia,Statement.RETURN_GENERATED_KEYS)){

            pre_statement.setString(1, user.getNombre());
            pre_statement.setString(2, user.getApellido());
            pre_statement.setInt(3, user.getEdad());

            pre_statement.executeUpdate();

                try(ResultSet resultadoDeSql = pre_statement.getGeneratedKeys()){
                    if(resultadoDeSql.next()){
                        int id = resultadoDeSql.getInt(1);
                        user.setId(id);
                    }
                }
            }    

        } catch (Exception e) {
            System.err.println(e);
        }     
    }

    @Override
    public void update(User user) {

         try(Connection connection=DataBaseUtil.getConnection()){
         
            final String SQLsentencia = "UPDATE usuario SET nombre=?,apellido=?,edad=? WHERE id=?";

            try(PreparedStatement pre_statement = connection.prepareStatement(SQLsentencia)){
            
            pre_statement.setString(1, user.getNombre());
            pre_statement.setString(2, user.getApellido());
            pre_statement.setInt(3, user.getEdad());
            pre_statement.setInt(4, user.getId());

            pre_statement.executeUpdate();
            }
        }catch (Exception e) {
            System.err.println(e);
        } 
    }
    @Override
    public void delete(User user) {
        
        try(Connection connection=DataBaseUtil.getConnection()){

            final String SQLsentencia = "DELETE FROM usuario WHERE id=?";

            try(PreparedStatement pre_statement = connection.prepareStatement(SQLsentencia)){
            
                pre_statement.setInt(1, user.getId());

                pre_statement.executeUpdate();
            }

        }catch (Exception e) {
            System.err.println(e);
        }   
    }

    @Override
    public List<User> findAll() {
        
        List<User> usuarios = new ArrayList<User>();

        try(Connection connection=DataBaseUtil.getConnection()){
            
            final String SQLsentencia = "SELECT * FROM USUARIO";
            
            try(Statement cre_statement = connection.createStatement()){
                
                try(ResultSet resultadoDeSql = cre_statement.executeQuery(SQLsentencia);){
                    
                    while (resultadoDeSql.next()) {
                    int id          = resultadoDeSql.getInt("id");
                    String nombre   = resultadoDeSql.getString("nombre");
                    String apellido = resultadoDeSql.getString("apellido");
                    int edad        = resultadoDeSql.getInt("edad");

                    User user = new User(id,nombre,apellido,edad);
                    usuarios.add(user);
                    }
                }
            }
             
        }catch (Exception e) {
            System.err.println(e);
        } 
        return usuarios;
    }

    @Override
    public User findById(Integer id) {
        
        User usuario = null;

        try(Connection connection=DataBaseUtil.getConnection()){

            final String SQLsentencia = "SELECT * FROM usuario WHERE id=?";

            try(PreparedStatement pre_statement = connection.prepareStatement(SQLsentencia);){
                
                pre_statement.setInt(1, id);

                try(ResultSet resultadoDeSql = pre_statement.executeQuery();){

                     while (resultadoDeSql.next()) {

                        int id_actual      = resultadoDeSql.getInt("id");
                        String nombre       = resultadoDeSql.getString("nombre");
                        String apellido     = resultadoDeSql.getString("apellido");
                        int edad            = resultadoDeSql.getInt("edad");

                        usuario = new User(id_actual,nombre,apellido,edad);

                    }
                }
            }

        }catch (Exception e) {
            System.err.println(e);
        } 

         return usuario;
    }
}
