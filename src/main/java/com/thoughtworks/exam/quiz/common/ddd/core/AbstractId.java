package com.thoughtworks.exam.quiz.common.ddd.core;

import com.thoughtworks.exam.quiz.common.ddd.annotation.ValueObject;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;

@ValueObject
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class AbstractId implements Serializable {
    private String value;

    protected AbstractId() {

    }
}
