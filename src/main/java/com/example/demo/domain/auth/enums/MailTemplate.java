package com.example.demo.domain.auth.enums;

import com.example.demo.common.properties.MailProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
@AllArgsConstructor
public enum MailTemplate {
    NewMember("invite", MailProperties.url + "/signUp?c=");

    private final String templateName;
    private final String link;
}
