/**
 * Copyright 2018 The original authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.dekorate.openshift;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import io.dekorate.kubernetes.config.BaseConfig;
import io.dekorate.openshift.config.EditableOpenshiftConfig;
import io.dekorate.openshift.config.OpenshiftConfig;
import io.dekorate.openshift.handler.OpenshiftHandler;

class OpenshiftHandlerTest {

  @Test
  public void shouldAcceptOpenshiftConfig() {
    OpenshiftHandler generator = new OpenshiftHandler();
    assertTrue(generator.canHandle(OpenshiftConfig.class));
  }

  @Test
  public void shouldAcceptEditableOpenshiftConfig() {
    OpenshiftHandler generator = new OpenshiftHandler();
    assertTrue(generator.canHandle(EditableOpenshiftConfig.class));
  }

  @Test
  public void shouldNotAcceptKubernetesConfig() {
    OpenshiftHandler generator = new OpenshiftHandler();
    assertFalse(generator.canHandle(BaseConfig.class));
  }
}
