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

import lombok.Getter;
import lombok.NonNull;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Represents tumor cells that are targets for therapeutic agents.
 *
 * <p>When a simulation begins, target cells originate are susceptible
 * to every therapeutic agent that is administered.  Target cells may
 * develop resistance to one or more therapeutic agents by acquiring
 * resistance mutations during the course of the simulation.</p>
 *
 * @author Scott Shaffer
 */
public final class TargetCell extends CellAgent {
    /**
     * The therapeutic agents to which this target cell has developed
     * resistance.
     */
    @Getter
    @NonNull
    private final Set<DrugAgent> resistantTo;

    /**
     * Creates a new cellular agent with a fixed identifier and resistance
     * phenotype.
     *
     * @param key the unique key for the cellular agent.
     *
     * @param resistantTo the therapeutic agents to which the cell has
     *                    developed resistance.
     */
    protected TargetCell(@NonNull CellKey key, @NonNull Collection<DrugAgent> resistantTo) {
        super(key);
        this.resistantTo = Set.copyOf(resistantTo);
        registerAgent(this);
    }

    /**
     * Creates a new cellular agent with a fixed identifier and resistance
     * phenotype.
     *
     * @param key the unique key for the cellular agent.
     *
     * @param resistantTo the therapeutic agents to which the cell has
     *                    developed resistance.
     *
     * @return the new cellular agent.
     */
    public static TargetCell create(CellKey key, Collection<DrugAgent> resistantTo) {
        return new TargetCell(key, resistantTo);
    }

    /**
     * Creates a new cellular agent with a fixed identifier and resistance
     * phenotype.
     *
     * @param key the unique key for the cellular agent.
     *
     * @param resistantTo the therapeutic agents to which the cell has
     *                    developed resistance.
     *
     * @return the new cellular agent.
     */
    public static TargetCell create(CellKey key, DrugAgent... resistantTo) {
        return new TargetCell(key, List.of(resistantTo));
    }

    /**
     * Identifies the therapeutic agents to which this cell has developed
     * resistance.
     *
     * @param drugAgent the therapeutic agent in question.
     *
     * @return {@code true} iff this target cell is resistant to the drug.
     */
    public boolean isResistantTo(DrugAgent drugAgent) {
        return resistantTo.contains(drugAgent);
    }
}
