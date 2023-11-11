package com.omicron.animancy.data.research;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.PlayerAdvancements;

public interface ResearchRequirement<T> {
    T get();

    ResourceLocation getId();
    class Listener<T extends ResearchRequirement<?>> {
        private final T requirement;
        private final ResearchEntry entry;
        private final String criterion;

        public Listener(T requirement, ResearchEntry entry, String criterion) {
            this.requirement = requirement;
            this.entry = entry;
            this.criterion = criterion;
        }

        public T getTriggerInstance() {
            return this.requirement;
        }

        public void run(PlayerAdvancements pPlayerAdvancements) {
//            pPlayerAdvancements.award(this.entry, this.criterion);
        }

        public boolean equals(Object pOther) {
            if (this == pOther) {
                return true;
            } else if (pOther != null && this.getClass() == pOther.getClass()) {
                Listener<?> listener = (Listener<?>)pOther;
                if (!this.requirement.equals(listener.requirement)) {
                    return false;
                } else {
                    return this.entry.equals(listener.entry) && this.criterion.equals(listener.criterion);
                }
            } else {
                return false;
            }
        }

        public int hashCode() {
            int i = this.requirement.hashCode();
            i = 31 * i + this.entry.hashCode();
            return 31 * i + this.criterion.hashCode();
        }
    }
}
