package com.example.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    @NotBlank(message = "名前を入力してください")
    private String name;

    @NotBlank(message = "年齢を入力してください")
    private String age;

    @Size(min = 1, max = 127, message = "コメントは1文字以上127文字以内で記載してください")
    private String comment;
}
