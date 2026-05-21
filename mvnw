#!/bin/sh
# ----------------------------------------------------------------------------
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements. See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership. The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License. You may obtain a copy of the License at
#
#    https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied. See the License for the
# specific language governing permissions and limitations
# under the License.
# ----------------------------------------------------------------------------

# ----------------------------------------------------------------------------
# Apache Maven Wrapper startup batch script, version 3.2.0
# ----------------------------------------------------------------------------

set -e

MAVEN_WRAPPER_PROPERTIES=".mvn/wrapper/maven-wrapper.properties"

DISTRIBUTION_URL=$(grep "distributionUrl" "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2 | tr -d '\r')
WRAPPER_URL=$(grep "wrapperUrl" "$MAVEN_WRAPPER_PROPERTIES" | cut -d'=' -f2 | tr -d '\r')

MAVEN_USER_HOME="${MAVEN_USER_HOME:-$HOME/.m2/wrapper}"
MAVEN_HOME="$MAVEN_USER_HOME/dists/$(basename $DISTRIBUTION_URL .zip)"

if [ ! -d "$MAVEN_HOME" ]; then
    echo "Downloading Maven..."
    mkdir -p "$MAVEN_USER_HOME/dists"
    TEMP_ZIP="$MAVEN_USER_HOME/maven-dist.zip"
    curl -fsSL "$DISTRIBUTION_URL" -o "$TEMP_ZIP"
    unzip -q "$TEMP_ZIP" -d "$MAVEN_USER_HOME/dists"
    rm "$TEMP_ZIP"
    # rename extracted folder
    EXTRACTED=$(ls "$MAVEN_USER_HOME/dists" | grep "apache-maven" | head -1)
    mv "$MAVEN_USER_HOME/dists/$EXTRACTED" "$MAVEN_HOME" 2>/dev/null || true
    echo "Maven downloaded to $MAVEN_HOME"
fi

exec "$MAVEN_HOME/bin/mvn" "$@"
