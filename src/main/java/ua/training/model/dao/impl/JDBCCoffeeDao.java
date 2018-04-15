package ua.training.model.dao.impl;


import ua.training.model.dao.CoffeeDao;
import ua.training.model.dao.impl.constants.ColumnNames;
import ua.training.model.dao.impl.constants.Queries;
import ua.training.model.entity.Coffee;
import ua.training.model.entity.CoffeeState;
import ua.training.model.entity.builder.CoffeeBuilder;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCCoffeeDao implements CoffeeDao {

    private Connection connection;

    JDBCCoffeeDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Coffee coffee) {
        try (PreparedStatement ps = connection.prepareStatement
                (Queries.COFFEE_CREATE)){

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
                (Queries.COFFEE_FIND_BY_ID)){
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
        return new CoffeeBuilder().setId(id).setName(name).setWeight(weight).
                setState(CoffeeState.valueOf(state)).setPrice(new BigDecimal(price)).buildCoffee();
    }

    @Override
    public List<Coffee> findAll() {
        List<Coffee> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()){
            ResultSet rs = ps.executeQuery(Queries.COFFEE_FIND_ALL);

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
                Queries.COFFEE_UPDATE)){
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
        try (PreparedStatement ps = connection.prepareStatement(Queries.COFFEE_DELETE)){
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