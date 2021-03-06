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

package com.netflix.spinnaker.halyard.deploy.provider.v1;

import com.netflix.spinnaker.halyard.deploy.component.v1.ComponentService;
import com.netflix.spinnaker.halyard.deploy.component.v1.ComponentType;
import com.netflix.spinnaker.halyard.deploy.job.v1.JobExecutor;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A Provider is an abstraction for communicating with a specific cloud-provider's installation
 * of Spinnaker.
 */
public abstract class Provider {
  @Autowired
  JobExecutor jobExecutor;

  abstract public ComponentService connectTo(ComponentType componentType);

  abstract public void bootstrapClouddriver();
}
