package com.interviewprep.clean_architecture.data.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val interviewPrepDispatchers: InterviewPrepDispatchers)

enum class InterviewPrepDispatchers {
    IO, Main, Default, Unconfined
}