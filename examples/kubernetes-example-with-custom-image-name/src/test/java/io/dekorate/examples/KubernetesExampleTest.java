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

package io.dekorate.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import io.dekorate.utils.Serialization;
import io.dekorate.deps.kubernetes.api.model.Container;
import io.dekorate.deps.kubernetes.api.model.KubernetesList;
import io.dekorate.deps.kubernetes.api.model.apps.Deployment;

class KubernetesExampleTest {

  @Test
  public void shouldUseCustomImageName() {
    KubernetesList list = Serialization.unmarshalAsList(KubernetesExampleTest.class.getClassLoader().getResourceAsStream("META-INF/dekorate/kubernetes.yml"));
    assertNotNull(list);
    assertEquals(1, list.getItems().size());
    Deployment deployment = (Deployment) list.getItems().get(0);
    assertNotNull(deployment);
    Container container = deployment.getSpec().getTemplate().getSpec().getContainers().get(0);
    assertNotNull(container);
    assertEquals("foo/bar:baz", container.getImage());

  }
}
