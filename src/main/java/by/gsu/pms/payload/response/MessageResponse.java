package by.gsu.pms.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponse {
    private String message;
    private Long userId;

    public MessageResponse(String message) {
        this.message = message;
    }

    public MessageResponse(String message, Long userId) {
        this.message = message;
        this.userId = userId;
    }
}
