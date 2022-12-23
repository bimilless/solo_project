package soloProject.todo.exception;

import lombok.Getter;

public enum ExceptionCode {
    SCHEDULE_NOT_FOUND(404, "Schedule not found"),
    SCHEDULE_EXISTS(409, "Schedule exists"),
    CANNOT_CHANGE_ORDER(403, "Order can not change"),
    NOT_IMPLEMENTATION(501, "Not Implementation");

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int code, String message) {
        this.status = code;
        this.message = message;
    }
}
