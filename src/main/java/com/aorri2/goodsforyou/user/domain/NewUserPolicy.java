package com.aorri2.goodsforyou.user.domain;

import com.aorri2.goodsforyou.common.policy.Policy;
import com.aorri2.goodsforyou.user.application.command.CreateUserCommand;

public interface NewUserPolicy extends Policy<CreateUserCommand> {
}
