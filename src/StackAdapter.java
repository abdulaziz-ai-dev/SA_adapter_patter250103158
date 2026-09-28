public class StackAdapter implements ISimpleStack {
    private LegacyArrayStack legacyStack;

    public StackAdapter(LegacyArrayStack legacyStack) {
        this.legacyStack = legacyStack;
    }

    public void push(int value) {
        legacyStack.pushInt(value);
    }

    public int pop() {
        return legacyStack.popInt();
    }

    public boolean isEmpty() {
        return legacyStack.count() == 0;
    }
}