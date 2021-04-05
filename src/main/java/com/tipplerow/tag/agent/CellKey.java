/*
 * Copyright (C) 2021 Scott Shaffer - All Rights Reserved
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
package com.tipplerow.tag.agent;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

/**
 * Uniquely identifies a cellular species (genotype and/or phenotype) in
 * the simulation.
 *
 * @author Scott Shaffer
 */
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
@ToString
public final class CellKey {
    /**
     * The unique identifier.
     */
    @Getter
    @NonNull
    private final String key;

    /**
     * Returns the key for a given identifier string.
     *
     * @param key the unique drug identifier string.
     *
     * @return the key for the specified identifier string.
     */
    public static CellKey of(String key) {
        return new CellKey(key);
    }
}
