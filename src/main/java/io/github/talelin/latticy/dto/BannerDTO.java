package io.github.talelin.latticy.dto;

import org.hibernate.validator.constraints.Length;  // 使用这个Length
// io.github.talelin.autoconfigure.validator.Length 这个目前不好使
import lombok.Data;

import javax.validation.constraints.NotBlank;

// 用于put post接口中的body数据传输
@Data
public class BannerDTO {
    @NotBlank
    @Length(min = 2, max = 20)
    private String name;

    @Length(min = 2, max = 30)
    private String title;

    @Length(min = 2, max = 256)
    private String description;

    @Length(min = 2, max = 256)
    private String img;
}
