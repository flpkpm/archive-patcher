// Copyright 2014 Google Inc. All rights reserved.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.archivepatcher.delta;

import com.google.archivepatcher.compat.Implementation;
import com.google.archivepatcher.util.IOUtils;
import com.nothome.delta.GDiffPatcher;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Implementation of a {@link DeltaApplier} based on javaxdelta.
 */
public class JxdDeltaApplier implements DeltaApplier {
    @Implementation
    public void applyDelta(InputStream oldData, InputStream deltaData,
            OutputStream newOut) throws IOException {
        new GDiffPatcher().patch(IOUtils.readAll(oldData), deltaData, newOut);
    }

    @Implementation
    public int getId() {
        return BuiltInDeltaEngine.JAVAXDELTA.getId();
    }
}