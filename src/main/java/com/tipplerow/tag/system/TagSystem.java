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
package com.tipplerow.tag.system;

import com.tipplerow.tag.agent.CellKey;
import com.tipplerow.tag.agent.DrugAgent;
import com.tipplerow.tag.agent.DrugKey;
import com.tipplerow.tag.agent.TargetCell;

import java.util.Set;

/**
 * @author Scott Shaffer
 */
public final class TagSystem {
    private static final DrugKey drugKeyA = DrugKey.of("A");
    private static final DrugKey drugKeyB = DrugKey.of("B");

    private static final DrugAgent drugA = DrugAgent.getAgent(drugKeyA);
    private static final DrugAgent drugB = DrugAgent.getAgent(drugKeyB);

    private static final Set<DrugKey> drugKeys = Set.of(drugKeyA, drugKeyB);
    private static final Set<DrugAgent> drugAgents = Set.of(drugA, drugB);

    private static final CellKey cellKeyNon = CellKey.of("Non");
    private static final CellKey cellKeyResA = CellKey.of("ResA");
    private static final CellKey cellKeyResB = CellKey.of("ResB");
    private static final CellKey cellKeyResAB = CellKey.of("ResAB");

    private static final TargetCell cellNon = TargetCell.create(cellKeyNon);
    private static final TargetCell cellResA = TargetCell.create(cellKeyResA, drugA);
    private static final TargetCell cellResB = TargetCell.create(cellKeyResB, drugB);
    private static final TargetCell cellResAB = TargetCell.create(cellKeyResAB, drugA, drugB);
}
