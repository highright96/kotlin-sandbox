package chapter04;

import org.jetbrains.annotations.NotNull;

public class Button2 implements View {
    @NotNull
    @Override
    public State getCurrentState() {
        return new ButtonState();
    }

    public static class ButtonState implements State {}
}
