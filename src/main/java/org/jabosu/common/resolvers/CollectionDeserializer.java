package org.jabosu.common.resolvers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author satya
 */
public class  CollectionDeserializer extends JsonDeserializer<Collection> {

        private Class collectionClazz;
        private Class elementClazz;
        private ObjectMapper mapper;
        
        public CollectionDeserializer(Class collectionClazz, Class elementClazz, ObjectMapper objectMapper) {
            this.collectionClazz = collectionClazz;
            this.elementClazz = elementClazz;
            this.mapper = objectMapper;
        }
        
        @Override
        public Collection deserialize(JsonParser jp, DeserializationContext dc) throws IOException, JsonProcessingException {
            ObjectCodec codec = jp.getCodec();
            JsonNode node = codec.readTree(jp);
            if (node != null    )
            {           
                return (Collection)mapper.readValue(node.traverse(), mapper.getTypeFactory().constructCollectionType(collectionClazz, elementClazz));
            }
            return null; // or return null, if preferred
        }
        
    }
   