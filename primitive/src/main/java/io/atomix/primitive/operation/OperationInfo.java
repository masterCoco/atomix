/*
 * Copyright 2018-present Open Networking Foundation
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
 */
package io.atomix.primitive.operation;

import io.atomix.utils.Version;

import java.util.Objects;

import static com.google.common.base.MoreObjects.toStringHelper;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Operation info.
 */
public final class OperationInfo {
  private final OperationId operationId;
  private final Version version;

  public OperationInfo(OperationId operationId, Version version) {
    this.operationId = checkNotNull(operationId, "operationId cannot be null");
    this.version = version;
  }

  /**
   * Returns the operation identifier.
   *
   * @return the operation identifier
   */
  public OperationId operationId() {
    return operationId;
  }

  /**
   * Returns the operation version.
   *
   * @return the operation version
   */
  public Version version() {
    return version;
  }

  @Override
  public int hashCode() {
    return Objects.hash(operationId, version);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof OperationInfo) {
      OperationInfo that = (OperationInfo) object;
      return this.operationId.equals(that.operationId) && Objects.equals(this.version, that.version);
    }
    return false;
  }

  @Override
  public String toString() {
    return toStringHelper(this)
        .add("operationId", operationId)
        .add("version", version)
        .toString();
  }
}
