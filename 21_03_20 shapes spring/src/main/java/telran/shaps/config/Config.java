package telran.shaps.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import telran.shaps.ShapeFlow;
import telran.shaps.entity.Line;
import telran.shaps.entity.Rectangle;
import telran.shaps.entity.Shape;
import telran.shaps.service.Picture;

import java.util.List;

@Configuration
public class Config {

    @Bean
    @Order(1)
    @Qualifier("shapesForPicture1")
    public Line line1() {
        return new Line('*', 10);
    }

    @Bean
    @Order(2)
    @Qualifier("shapesForPicture1")
    public Line line2() {
        return new Line('+', 13);
    }

    @Bean
    @Order(3)
    @Qualifier("line")
    public Line line3() {
        return new Line('-', 15);
    }

    @Bean
    @Qualifier("shapesForPicture1")
    public Rectangle rectangle1() {
        return new Rectangle('=', 10, 5);
    }

    @Bean
    @Qualifier("rectangle")
    public Rectangle rectangle2() {
        return new Rectangle('-', 2, 5);
    }

    @Bean
    @Qualifier("rectangle")
    public Rectangle rectangle3() {
        return new Rectangle('-', 2, 3);
    }


    @Bean
    public ShapeFlow shapeFlow1(@Qualifier("shapesForPicture1") List<Shape> shapesForPicture,
                                Line line1,
                                Line line2,
                                Line line3,
                                Picture picture) {
        shapesForPicture.add(line1);
        shapesForPicture.add(line2);
        shapesForPicture.add(line3);
        return new ShapeFlow(shapesForPicture, picture);
    }

    //my picture 2 rectangle und 3 line
    @Bean
    public ShapeFlow shapeFlow2(@Qualifier("rectangle") List<Shape> rectangle,
                                Line line1,
                                Line line3,
                                Picture picture) {
        rectangle.add(line1);
        rectangle.add(line3);
        return new ShapeFlow(rectangle, picture);
    }
}