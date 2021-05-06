package ru.kisusil.icecreamrose;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import ru.kisusil.icecreamrose.model.CollectionInfo;
import ru.kisusil.icecreamrose.model.HumanBeingRepository;
import ru.kisusil.icecreamrose.model.humanbeing.HumanBeing;

import java.lang.reflect.Type;
import java.util.LinkedHashSet;

public class HumanBeingRepositoryJsonDeserializer implements JsonDeserializer<HumanBeingRepository> {
    @Override
    public HumanBeingRepository deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        LinkedHashSet<HumanBeing> linkedHashSet = context.deserialize(jsonObject.get("linkedHashSet"),  new TypeToken<LinkedHashSet<HumanBeing>>() {}.getType());
        CollectionInfo collectionInfo = context.deserialize(jsonObject.get("collectionInfo"), CollectionInfo.class);

        return new HumanBeingRepository(collectionInfo, linkedHashSet);
    }
}
