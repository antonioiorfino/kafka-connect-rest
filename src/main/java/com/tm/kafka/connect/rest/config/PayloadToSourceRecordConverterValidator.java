/**
 * Copyright 2015 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/

package com.tm.kafka.connect.rest.config;

import com.tm.kafka.connect.rest.converter.PayloadToSourceRecordConverter;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigException;

public class PayloadToSourceRecordConverterValidator implements ConfigDef.Validator {
  @Override
  public void ensureValid(String name, Object provider) {
    if (provider != null && provider instanceof Class
        && PayloadToSourceRecordConverter.class.isAssignableFrom((Class<?>) provider)) {
      return;
    }
    throw new ConfigException(name, provider, "Class must extend: "
        + PayloadToSourceRecordConverter.class);
  }

  @Override
  public String toString() {
    return "Any class implementing: " + PayloadToSourceRecordConverter.class;
  }
}