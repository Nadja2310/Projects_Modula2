package telran.shaps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import telran.shaps.entity.Line;
import telran.shaps.entity.Shape;
import telran.shaps.service.Picture;

import java.util.List;

@Component
public class ShapeFlow implements ApplicationRunner {

    List<Shape> shapesForPicture;
    Line line1;
    Line line2;
    Line line3;
    Picture picture;


    public ShapeFlow(@Qualifier("shapesForPicture1") List<Shape> shapesForPicture, Picture picture) {
        this.shapesForPicture = shapesForPicture;
        this.picture = picture;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("task 3");
        picture.print(shapesForPicture);
    }
}
