public class Chifoumi {
    public static ChifoumiAction getActionBeatenBy(ChifoumiAction chifoumiAction) {
        switch (chifoumiAction) {
            case ROCK: return chifoumiAction.SCISSOR;
            case PAPER: return chifoumiAction.ROCK;
            case SCISSOR: return chifoumiAction.PAPER;
            default: 
            return chifoumiAction;
        }
    }
}