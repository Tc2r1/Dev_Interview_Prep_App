package com.interviewprep.clean_architecture.data.di

import android.content.Context
import com.interviewprep.clean_architecture.data.QuizRepositoryImp
import com.interviewprep.clean_architecture.domain.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    @Provides
    fun provideQuizRepository(@ApplicationContext context: Context): QuizRepository =
        QuizRepositoryImp(context)
}



