package telran.shaps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import telran.shaps.entity.Line;
import telran.shaps.entity.Rectangle;
import telran.shaps.entity.Shape;
import telran.shaps.service.Picture;

import java.util.List;

@Component
public class ShapeFlow implements ApplicationRunner {

    Shape[] shapesForPicture;
    Line line1;
    Line line2;
    Line line3;
    Picture picture;


   public ShapeFlow(@Qualifier("shapesForPicture1") Shape[] shapesForPicture,
                     Line line1, Line line2, Line line3, Picture picture) {
        this.shapesForPicture = shapesForPicture;
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.picture = picture;
    }
/*
    public ShapeFlow(Line line1, Line line2, Line line3, Picture picture) {
        this.line1 = line1;
        this.line2 = line2;
        this.line3 = line3;
        this.picture = picture;
    }
*/

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("task 3");
        picture.print(shapesForPicture);
       line1.draw();
       line2.draw();
       line3.draw();
    }
}
