package com.nirajtiwari.composepractise.di

import com.nirajtiwari.composepractise.model.MealsRepository
import com.nirajtiwari.composepractise.network.GetMealCategoriesService
import dagger.Component

@Component(modules = [DependencyModule::class])
interface DependencyComponent {

    fun inject(repository: MealsRepository)

    fun inject(service: GetMealCategoriesService)
}