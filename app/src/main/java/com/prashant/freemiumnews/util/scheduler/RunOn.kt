package com.prashant.freemiumnews.util.scheduler

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier

@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
annotation class RunOn(val value: SchedulerType = SchedulerType.IO)