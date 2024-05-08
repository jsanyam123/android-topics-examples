package com.sanyam.didemo

import dagger.Component

@Component
interface SmartPhoneComponent {
   fun getSmartPhone() : SmartPhone
}