package telran.shaps;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import telran.shaps.entity.Line;
import telran.shaps.entity.Picture;

import java.util.List;

@Component
public class ShapeFlow implements ApplicationRunner {

    private final Picture picture1;
    private final List<Line> lines;
    private final Picture picture2;

    public ShapeFlow(Picture picture1, List<Line> lines, Picture picture2) {
        this.picture1 = picture1;
        this.lines = lines;
        this.picture2 = picture2;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("task 3");
        for (Line line : lines)
            line.draw();

        picture1.draw();
        picture2.draw();


    }
}
