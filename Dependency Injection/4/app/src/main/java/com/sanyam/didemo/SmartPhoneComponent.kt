package com.sanyam.didemo

import dagger.Component

@Component(modules = [MemoryCardModule::class,NCBatteryModule::class])
interface SmartPhoneComponent {

   fun inject(mainActivity: MainActivity)
}

