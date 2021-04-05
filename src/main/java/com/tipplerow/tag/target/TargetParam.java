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
package com.tipplerow.tag.target;

import com.tipplerow.jam.bravais.UnitCellType;

import lombok.Builder;
import lombok.Value;

/**
 * Encapsulates the parameters for a therapeutic target simulation.
 *
 * @author Scott Shaffer
 */
@Value
@Builder
public class TargetParam {
    /**
     * The enumerated type for the unit cell of the lattice.
     */
    UnitCellType unitCellType;

    /**
     * The length of one side of the periodic box.
     */
    int periodLength;

    /**
     * The maximum number of cells at a single lattice site.
     */
    int siteCapacity;

    /**
     * The birth rate of non-resistant tumor cells.
     */
    double nonResistantBirthRate;

    /**
     * The birth rate of resistant tumor cells.
     */
    double resistantBirthRate;

    /**
     * The death rate of non-resistant tumor cells in the absence of a
     * therapeutic agent.
     */
    double nonResistantDeathRate;

    /**
     * The death rate of resistant tumor cells.
     */
    double resistantDeathRate;

    /**
     * The death rate of non-resistant tumor cells in the presence of a
     * therapeutic agent.
     */
    double killingRate;
}
