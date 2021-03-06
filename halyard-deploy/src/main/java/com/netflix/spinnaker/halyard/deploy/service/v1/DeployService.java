/*
 * Copyright 2017 Google, Inc.
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

package com.netflix.spinnaker.halyard.deploy.service.v1;

import com.netflix.spinnaker.halyard.deploy.deployment.v1.Deployment;
import com.netflix.spinnaker.halyard.deploy.provider.v1.KubernetesProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeployService {
  @Autowired
  KubernetesProvider kubernetesProvider;

  public void deploySpinnaker() {
    new Deployment(kubernetesProvider);
  }
}
