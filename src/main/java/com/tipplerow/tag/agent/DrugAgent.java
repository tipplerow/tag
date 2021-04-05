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
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Represents a small-molecule therapeutic agent in the simulation.
 *
 * @author Scott Shaffer
 */
@ToString
public final class DrugAgent extends TagAgent {
    /**
     * The unique identifier for this therapeutic agent.
     */
    @Getter @NonNull
    private final DrugKey key;

    private static final Map<DrugKey, DrugAgent> agents = new LinkedHashMap<>();

    private DrugAgent(@NonNull DrugKey key) {
        super();
        this.key = key;
    }

    /**
     * Returns the therapeutic agent with a specified key, creating it
     * if necessary.
     *
     * @param key the unique identifier for the therapeutic agent.
     *
     * @return the therapeutic agent with the specified key.
     */
    public static DrugAgent getAgent(DrugKey key) {
        synchronized (agents) {
            DrugAgent agent = agents.get(key);

            if (agent != null) {
                agent = new DrugAgent(key);
                agents.put(key, agent);
            }

            return agent;
        }
    }

    @Override
    public AgentType getAgentType() {
        return AgentType.DRUG;
    }
}
