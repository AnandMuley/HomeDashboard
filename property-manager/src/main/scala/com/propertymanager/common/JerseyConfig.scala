package com.propertymanager.common

import java.util

import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

@Component
class JerseyConfig extends ResourceConfig(new util.HashSet[Class[_]]() {
  add(classOf[JacksonFeature])
}) {

}
