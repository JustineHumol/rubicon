package com.gabriel.draw.command;

import com.gabriel.drawfx.command.Command;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;

import java.awt.Point;

public class MoveShapeCommand implements Command {
    private AppService appService;
    private Shape shape;
    private Point oldLocation;
    private Point newLocation;

    public MoveShapeCommand(AppService appService, Shape shape, Point newLocation) {
        this.appService = appService;
        this.shape = shape;
        this.oldLocation = shape.getLocation();
        this.newLocation = newLocation;
    }

    @Override
    public void execute() {
        moveShapeTo(newLocation);
        appService.repaint();
    }

    @Override
    public void undo() {
        moveShapeTo(oldLocation);
        appService.repaint();
    }

    @Override
    public void redo() {
        execute();
    }

    private void moveShapeTo(Point target) {
        int dx = target.x - shape.getLocation().x;
        int dy = target.y - shape.getLocation().y;

        Point oldEnd = shape.getEnd();
        Point newEnd = new Point(oldEnd.x + dx, oldEnd.y + dy);

        shape.setLocation(target);
        shape.setEnd(newEnd);
    }
}
