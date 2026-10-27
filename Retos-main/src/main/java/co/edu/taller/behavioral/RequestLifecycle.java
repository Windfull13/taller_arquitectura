package co.edu.taller.behavioral;

public class RequestLifecycle {
    public enum Status {RECEIVED, IN_REVIEW, APPROVED, REJECTED}

    private Status status = Status.RECEIVED;

    public Status status() {
        return status;
    }

    public void review() {
        requireStatus(Status.RECEIVED);
        status = Status.IN_REVIEW;
    }

    public void approve() {
        requireStatus(Status.IN_REVIEW);
        status = Status.APPROVED;
    }

    public void reject() {
        requireStatus(Status.IN_REVIEW);
        status = Status.REJECTED;
    }

    private void requireStatus(Status expectedStatus) {
        if (status != expectedStatus) {
            throw new IllegalStateException("Invalid transition from " + status);
        }
    }
}