package telran.shaps.service;

import org.springframework.stereotype.Service;
import telran.shaps.entity.Shape;

import java.util.List;

@Service
public class Picture {

    public void print(List<Shape> shapesForPicture1) {
        for (Shape shape : shapesForPicture1) {
            shape.draw();
        }
    }
}
