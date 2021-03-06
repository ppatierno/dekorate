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
package io.dekorate;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

import io.dekorate.project.Project;

public interface WithProject {

  AtomicReference<Project> project = new AtomicReference<>();

  default boolean projectExists() {
    return project.get() != null;
  }

  default Project getProject() {
    return WithProject.project.get();
  }

  default void setProject(Project project) {
    WithProject.project.set(project);
  }

  default void applyToProject(Function<Project, Project> function) {
    setProject(function.apply(getProject()));
  }
}
