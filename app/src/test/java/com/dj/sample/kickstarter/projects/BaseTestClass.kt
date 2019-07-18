package com.dj.sample.kickstarter.projects

import com.dj.sample.kickstarter.projects.utils.KickstarterLogger

abstract class BaseTestClass {
    init {
        KickstarterLogger.TEST_MODE  = true;
    }
}