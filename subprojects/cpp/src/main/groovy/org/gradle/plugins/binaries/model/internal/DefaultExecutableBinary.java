/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.plugins.binaries.model.internal;

import org.gradle.internal.os.OperatingSystem;
import org.gradle.plugins.binaries.model.Executable;
import org.gradle.plugins.binaries.model.ExecutableBinary;

public class DefaultExecutableBinary extends DefaultNativeBinary implements ExecutableBinary {
    private final Executable executable;

    public DefaultExecutableBinary(Executable executable) {
        this.executable = executable;
    }

    public Executable getComponent() {
        return executable;
    }

    public String getName() {
        return executable.getName() + "Executable";
    }

    @Override
    public String toString() {
        return String.format("executable '%s'", executable.getName());
    }

    public String getOutputFileName() {
        return OperatingSystem.current().getExecutableName(getComponent().getBaseName());
    }
}
