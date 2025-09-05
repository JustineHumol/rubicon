package com.gabriel.draw.command;

import com.gabriel.drawfx.command.Command;
import com.gabriel.drawfx.model.Shape;
import com.gabriel.drawfx.service.AppService;

import java.awt.*;

public class SetColorCommand implements Command {
    private AppService appService;
    private Shape shape;
    private Color oldColor;
    private Color newColor;

    public SetColorCommand(AppService appService, Shape shape, Color newColor) {
        this.appService = appService;
        this.shape = shape;
        this.oldColor = shape.getColor();
        this.newColor = newColor;
    }

    @Override
    public void execute() {
        shape.setColor(newColor);
        appService.repaint();
    }

    @Override
    public void undo() {
        shape.setColor(oldColor);
        appService.repaint();
    }

    @Override
    public void redo() {
        execute();
    }
}
