/*
 * Copyright 2016-2020 chronicle.software
 *
 * https://chronicle.software
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package net.openhft.chronicle.core.jlbh;

import java.util.function.Consumer;
import java.util.function.Supplier;

public interface JLBHResultConsumer extends Consumer<JLBHResult>, Supplier<JLBHResult> {

    /**
     * Thread safety (when reading the result from a thread that is different from the one executing the JLBH)
     * is guaranteed by making sure that the result data is visible after being generated by JLBH.
     * Additional requirement, JLBHResult immutability is met by JLBHResult implementation used by JLBH.
     * <p>
     * When using this instance on its own, make sure the JLBHResult implementation passed to the
     * accept method is immutable.
     */
    static JLBHResultConsumer newThreadSafeInstance() {
        return new ThreadSafeJLBHResultConsumer();
    }
}

