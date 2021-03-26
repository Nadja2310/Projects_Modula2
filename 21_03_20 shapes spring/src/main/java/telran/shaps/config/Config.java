package telran.shaps.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import telran.shaps.entity.Line;
import telran.shaps.entity.Picture;
import telran.shaps.entity.Rectangle;
import telran.shaps.entity.Shape;

import java.util.List;
@Configuration
public class Config {
        @Bean
        @Order(1)
        public Line line1() {
            return new Line('*', 10);
        }

        @Bean
        public Line line2() { return new Line('+', 13); }

        @Bean
        public Line line3() {
            return new Line('-', 15);
        }

        @Bean
        @Qualifier("shapesForPicture")
        public Rectangle rectangle1() {
            return new Rectangle('=', 10, 5);
        }

        @Bean
        @Qualifier("shapesForPicture1")
        public Rectangle rectangle2() {
            return new Rectangle('-', 2, 5);
        }

        @Bean
        @Qualifier("shapesForPicture1")
        public Rectangle rectangle3() {
            return new Rectangle('-', 2, 3);
        }

        @Bean
        public Picture picture1(@Qualifier("shapesForPicture") List<Shape> shapesForPicture){

            return new Picture('s',shapesForPicture);
        }

        //my picture 2 rectangle und 3 line
        @Bean
        public Picture picture2(@Qualifier("shapesForPicture1") List<Shape> shapesForPicture1){
            return new Picture('s',shapesForPicture1);
        }
}
