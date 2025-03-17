package br.com.carstore.dao;
import br.com.carstore.model.Car;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarDao {

    public void createCar(Car car) {

        String SQL = "INSERT INTO CAR (NAME) VALUES (?)";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.execute();

            System.out.println("success in insert car");

            connection.close();


        } catch (Exception e) {
            System.out.println("fail in database connection");

        }

    }

    public List<Car> findAllCars() {
        String SQL = "SELECT ID_CAR, NAME FROM CAR"; // Adiciona a coluna ID_CAR

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                int idCar = resultSet.getInt("ID_CAR"); // Obtém o ID do banco
                String carName = resultSet.getString("NAME");

                Car car = new Car(idCar, carName); // Usa o construtor correto
                cars.add(car);
            }

            System.out.println("success in select * car");

            connection.close();

            return cars;

        } catch (Exception e) {
            System.out.println("fail in database connection");
            return Collections.emptyList();
        }
    }
}
