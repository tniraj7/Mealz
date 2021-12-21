package com.nirajtiwari.composepractise.di

import com.nirajtiwari.composepractise.network.GetMealCategoriesService
import dagger.Module
import dagger.Provides

@Module
class DependencyModule {

    @Provides
    fun provideMealCategoriesService(): GetMealCategoriesService {
        return GetMealCategoriesService()
    }
}