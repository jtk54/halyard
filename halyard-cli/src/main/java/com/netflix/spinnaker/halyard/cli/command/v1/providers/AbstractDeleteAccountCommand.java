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

package com.netflix.spinnaker.halyard.cli.command.v1.providers;

import com.beust.jcommander.Parameters;
import com.netflix.spinnaker.halyard.cli.command.v1.NestableCommand;
import com.netflix.spinnaker.halyard.cli.services.v1.Daemon;
import com.netflix.spinnaker.halyard.cli.ui.v1.AnsiUi;
import java.util.HashMap;
import java.util.Map;
import lombok.AccessLevel;
import lombok.Getter;

/**
 * Delete a specific PROVIDER account
 */
@Parameters()
public abstract class AbstractDeleteAccountCommand extends AbstractHasAccountCommand {
  @Getter(AccessLevel.PROTECTED)
  private Map<String, NestableCommand> subcommands = new HashMap<>();

  @Getter(AccessLevel.PUBLIC)
  private String commandName = "delete-account";

  public String getDescription() {
    return "Delete a specific " + getProviderName() + " account by name.";
  }

  @Override
  protected void executeThis() {
    deleteAccount(getAccountName());
    AnsiUi.success("Deleted " + getAccountName());
  }

  private void deleteAccount(String accountName) {
    String currentDeployment = Daemon.getCurrentDeployment();
    Daemon.deleteAccount(currentDeployment, getProviderName(), accountName, !noValidate);
  }
}
