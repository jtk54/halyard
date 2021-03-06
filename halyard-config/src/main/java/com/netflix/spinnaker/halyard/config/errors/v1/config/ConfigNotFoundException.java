/*
 * Copyright 2016 Google, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License")
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.halyard.config.errors.v1.config;

import com.netflix.spinnaker.halyard.config.errors.v1.HalconfigException;
import com.netflix.spinnaker.halyard.config.model.v1.problem.Problem;
import lombok.Getter;

import javax.servlet.http.HttpServletResponse;

/**
 * This is meant for requests that Halyard cannot figure out how to handle.
 * For example: Asking to load an account that isn't in your config.
 */
public class ConfigNotFoundException extends HalconfigException {
  @Getter
  private int responseCode = HttpServletResponse.SC_NOT_FOUND;

  public ConfigNotFoundException(Problem problem) {
    super(problem);
  }
}
