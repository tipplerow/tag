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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Provides a base class for cellular agents in the simulation.
 *
 * @author Scott Shaffer
 */
public abstract class CellAgent extends TagAgent {
    /**
     * The unique identifier for this cellular agent.
     */
    @Getter
    @NonNull
    private final CellKey key;

    private static final Map<CellKey, CellAgent> agents = new LinkedHashMap<>();

    /**
     * Creates a new cellular agent with a fixed identifier.
     *
     * @param key the unique key for the cellular agent.
     */
    protected CellAgent(@NonNull CellKey key) {
        super();
        this.key = key;
    }

    /**
     * Returns the cellular agent with a specified key, if it exists.
     *
     * @param key the unique identifier for the cellular agent.
     *
     * @return the cellular agent with the specified key, or {@code null}
     * if there is no cellular agent with that key.
     */
    protected static CellAgent lookupAgent(CellKey key) {
        return agents.get(key);
    }

    /**
     * Adds a cellular agent to the registry so that it may be retrieved
     * later by calling {@code lookupAgent()}.
     *
     * @param agent the cellular agent to register.
     *
     * @throws IllegalStateException if another agent with the specified
     * key already exists.
     */
    protected static void registerAgent(CellAgent agent) {
        CellAgent prev = agents.put(agent.getKey(), agent);

        if (prev != null && !prev.equals(agent))
            throw new IllegalStateException("Duplicate cell key.");
    }

    @Override
    public AgentType getAgentType() {
        return AgentType.CELL;
    }
}
