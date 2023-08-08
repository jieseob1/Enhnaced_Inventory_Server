package enhanced_inventory.server.dto;
 
import enhanced_inventory.server.domain.User;

import java.time.LocalDateTime;

public record UserDto(
        String userId,
        String userPassword,
        String email,
        String nickname,
        String memo,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserDto of(String userId, String userPassword, String email, String nickname, String memo) {
        return new UserDto(userId, userPassword, email, nickname, memo, null, null, null, null);
    }

    public static UserDto of(String userId, String userPassword, String email, String nickname, String memo, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserDto(userId, userPassword, email, nickname, memo, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserDto from(User entity) {
        return new UserDto(
                entity.getUserId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getNickname(),
                entity.getMemo(),
                entity.getCreatedAt(),
                entity.getCreatedBy(),
                entity.getModifiedAt(),
                entity.getModifiedBy()
        );
    }

    public User toEntity() {
        return User.of(
                userId,
                userPassword,
                email,
                nickname,
                memo
        );
    }

}
