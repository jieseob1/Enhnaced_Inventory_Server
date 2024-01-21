package enhanced_inventory.server.dto;
 
import enhanced_inventory.server.entity.User;

import java.time.LocalDateTime;

public record UserDto(
        String userId,
        String userPassword,
        String email,
        String role,
        String memo,
        String companyId,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

    public static UserDto of(String userId, String userPassword, String email, String role, String memo, String company) {
        return new UserDto(userId, userPassword, email, role, memo,company, null, null, null, null);
    }

    public static UserDto of(String userId, String userPassword, String email, String role, String memo,String company, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
        return new UserDto(userId, userPassword, email, role, memo,company, createdAt, createdBy, modifiedAt, modifiedBy);
    }

    public static UserDto from(User entity) { //userDTO 정보 꺼내옴
        //entity로 user에 관련된 정보들 가지고 오고 객체 생ㅇ성
        return new UserDto(
                entity.getId(),
                entity.getUserPassword(),
                entity.getEmail(),
                entity.getRole(),
                entity.getMemo(),
                entity.getCompanyId(),
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
                role,
                memo,
                companyId
        );
    }

}
