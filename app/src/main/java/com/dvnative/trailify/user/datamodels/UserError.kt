package com.dvnative.trailify.user.datamodels

import com.dvnative.trailify.user.datamodels.dto.UserErrorDTO

data class UserError(val body: UserErrorDTO) : Throwable()