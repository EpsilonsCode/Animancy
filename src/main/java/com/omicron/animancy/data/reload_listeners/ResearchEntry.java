package com.omicron.animancy.data.reload_listeners;

import com.google.gson.*;

import java.lang.reflect.Type;

public class ResearchEntry
{


    public static class Serializer implements JsonDeserializer<ResearchEntry>, JsonSerializer<ResearchEntry>
    {

        @Override
        public ResearchEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return null;
        }

        @Override
        public JsonElement serialize(ResearchEntry src, Type typeOfSrc, JsonSerializationContext context) {
            return null;
        }
    }
}
