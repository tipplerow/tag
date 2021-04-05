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

import com.tipplerow.jam.bravais.Lattice;
import com.tipplerow.jam.bravais.Period;
import com.tipplerow.jam.bravais.UnitCell;

import com.tipplerow.tag.agent.CellKey;
import com.tipplerow.tag.agent.DrugAgent;
import com.tipplerow.tag.agent.DrugKey;

import java.util.Set;

/**
 * @author Scott Shaffer
 */
public final class TargetSystem {
    public static final DrugKey drugKeyA = DrugKey.of("A");
    public static final DrugKey drugKeyB = DrugKey.of("B");

    public static final DrugAgent drugA = DrugAgent.getAgent(drugKeyA);
    public static final DrugAgent drugB = DrugAgent.getAgent(drugKeyB);

    public static final Set<DrugKey> drugKeys = Set.of(drugKeyA, drugKeyB);
    public static final Set<DrugAgent> drugAgents = Set.of(drugA, drugB);

    public static final CellKey cellKeyNon = CellKey.of("Non");
    public static final CellKey cellKeyResA = CellKey.of("ResA");
    public static final CellKey cellKeyResB = CellKey.of("ResB");
    public static final CellKey cellKeyResAB = CellKey.of("ResAB");

    public static final TargetCell cellNon = TargetCell.create(cellKeyNon);
    public static final TargetCell cellResA = TargetCell.create(cellKeyResA, drugA);
    public static final TargetCell cellResB = TargetCell.create(cellKeyResB, drugB);
    public static final TargetCell cellResAB = TargetCell.create(cellKeyResAB, drugA, drugB);

    public static final UnitCell unitCell = UnitCell.square(1.0);
    public static final Period   period   = Period.square(100);
    public static final Lattice  lattice  = Lattice.create(unitCell, period);
}
