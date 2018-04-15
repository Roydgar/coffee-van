package ua.training.model.dao.impl;


import ua.training.model.dao.CoffeesDao;
import ua.training.model.dao.impl.constants.ColumnNames;
import ua.training.model.dao.impl.constants.Queries;
import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeState;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCoffeesDao implements CoffeesDao {

    private Connection connection;

    JDBCCoffeesDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Coffee coffee) {
        try (PreparedStatement ps = connection.prepareStatement
                (Queries.CREATE)){

            ps.setString(1 , coffee.getName());
            ps.setInt(2 , coffee.getWeight());
            ps.setString(3 , coffee.getState().toString());
            ps.setString(4, coffee.getPrice().toString());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Coffee findById(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                (Queries.FIND_BY_ID)){
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                Coffee result = extractFromResultSet(rs);
                return result;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Coffee extractFromResultSet(ResultSet rs)
            throws SQLException {
        int id       =  rs.getInt(ColumnNames.COFFEE_ID);
        String name  =  rs.getString(ColumnNames.COFFEE_NAME) ;
        int weight   =  rs.getInt(ColumnNames.COFFEE_WEIGHT);
        String state =  rs.getString(ColumnNames.COFFEE_STATE);
        String price =  rs.getString(ColumnNames.COFFEE_PRICE);
        return new Coffee(id, name, weight, CoffeeState.valueOf(state), new BigDecimal(price));
    }

    @Override
    public List<Coffee> findAll() {
        List<Coffee> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.FIND_ALL);

            while ( rs.next() ){
                resultList.add(extractFromResultSet(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(Coffee coffee) {
        try (PreparedStatement ps = connection.prepareStatement(
                Queries.UPDATE)){
            ps.setString(1 , coffee.getName());
            ps.setInt(2 , coffee.getWeight());
            ps.setString(3 , coffee.getState().toString());
            ps.setString(4, coffee.getPrice().toString());
            ps.setInt(5, coffee.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(Queries.DELETE)){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}