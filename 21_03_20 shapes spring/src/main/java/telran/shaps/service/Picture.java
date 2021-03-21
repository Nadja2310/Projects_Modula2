package telran.shaps.service;

import org.springframework.stereotype.Service;
import telran.shaps.entity.Shape;

@Service
public class Picture {

    public void print(Shape[] shapesForPicture1) {
        for (Shape shape : shapesForPicture1) {
            shape.draw();
        }
    }
}
