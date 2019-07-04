package threads.mainTask.Models;

import threads.mainTask.Enum.LocomotiveName;

public class Locomotive {
    private LocomotiveName locomotiveName;

    public Locomotive(LocomotiveName locomotiveName) {
        this.locomotiveName = locomotiveName;
    }

    public LocomotiveName getLocomotiveName() {
        return locomotiveName;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "locomotiveName=" + locomotiveName +
                '}';
    }
}
