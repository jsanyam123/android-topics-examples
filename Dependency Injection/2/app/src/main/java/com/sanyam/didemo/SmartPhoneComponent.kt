package com.sanyam.didemo

import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {
   fun getSmartPhone() : SmartPhone
}