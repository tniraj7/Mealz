package com.nirajtiwari.composepractise.di

import com.nirajtiwari.composepractise.model.MealsRepository
import dagger.Component

@Component(modules = [DependencyModule::class])
interface DependencyComponent {

    fun inject(repository: MealsRepository)
}