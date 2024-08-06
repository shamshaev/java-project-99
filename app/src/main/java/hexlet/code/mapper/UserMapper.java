package hexlet.code.mapper;

import hexlet.code.dto.UserDTO;
import hexlet.code.dto.UserCreateDTO;
import hexlet.code.dto.UserUpdateDTO;
import hexlet.code.model.User;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;

@Mapper(
        uses = { JsonNullableMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class UserMapper {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Mapping(source = "password", target = "passwordDigest")
    public abstract User map(UserCreateDTO dto);

    public abstract UserDTO map(User model);

    @Mapping(source = "password", target = "passwordDigest")
    public abstract void update(UserUpdateDTO dto, @MappingTarget User model);

    @AfterMapping
    public void encryptPassword(User data) {
        var password = data.getPasswordDigest();
        data.setPasswordDigest(password);
        //data.setPasswordDigest(passwordEncoder.encode(password));
    }
}
