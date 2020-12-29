package com.firecode.app.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.firecode.app.model.entity.UserEntity;
import com.firecode.app.model.entity.UserStatusEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author fmatheus
 */
@JsonPropertyOrder({"id", "username", "status", "avatar"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@Api(tags = "Person", description = "API Person")
public class UserDto {

    @Getter
    @Setter
    @JsonProperty("id")
    @ApiModelProperty(notes = "User ID")
    private int id;

    @Getter
    @Setter
    @NotNull(message = "{status.not.null}")
    @NotBlank(message = "{status.not.blank}")
    @JsonProperty("id_user_status")
    @ApiModelProperty(notes = "User status id", name = "id_user_status", required = true)
    private int idUserStatus;

    @Getter
    @Setter
    @NotNull(message = "{username.not.null}")
    @NotBlank(message = "{username.not.blank}")
    @Size(min = 3, max = 45, message = "{username.size}")
    @JsonProperty("username")
    @ApiModelProperty(notes = "User username", name = "username", required = true)
    private String username;

    @Getter
    @Setter
    @NotNull(message = "{password.not.null}")
    @NotBlank(message = "{password.not.blank}")
    @Size(min = 6, max = 70, message = "{password.size}")
    @JsonProperty("password")
    @ApiModelProperty(notes = "User password", name = "password", required = true)
    private String password;

    @Getter
    @Setter
    @JsonProperty("status")
    @ApiModelProperty(notes = "User status", name = "status")
    private String status;

    @Getter
    @Setter
    @JsonProperty("avatar")
    @ApiModelProperty(notes = "User avatar", name = "avatar")
    private String avatar;

    public static UserDto converterObject(UserEntity entity) {

        var user = new UserDto();

        user.setIdUserStatus(entity.getIdUserStatus().getId());
        user.setStatus(entity.getIdUserStatus().getName());
        user.setUsername(entity.getUsername());
        user.setAvatar(entity.getAvatar());

        return user;

    }

    public static UserEntity converterEntity(UserDto dto) {

        var user = new UserEntity();

        user.setIdUserStatus(new UserStatusEntity(dto.getIdUserStatus()));
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setAvatar(dto.getAvatar());

        return user;

    }

}
