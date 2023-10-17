package org.vinrays.corporate.application.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.web.multipart.MultipartFile;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@JsonSerialize(using = ByteArrayMultipartFile.ByteArrayMultipartFileSerializer.class)
@JsonDeserialize(using = ByteArrayMultipartFile.ByteArrayMultipartFileDeserializer.class)
public class ByteArrayMultipartFile implements MultipartFile {

    private final String name;
    private final String originalFilename;
    private final String contentType;

    @JsonIgnore
    private final byte[] content; // @JsonIgnore will prevent this field from being serialized

    private transient InputStream inputStream; // Mark the InputStream field as transient to prevent serialization

    public ByteArrayMultipartFile(String name, String originalFilename, String contentType, byte[] content) {
        this.name = name;
        this.originalFilename = originalFilename;
        this.contentType = contentType;
        this.content = content;
        this.inputStream = new ByteArrayInputStream(content); // Initialize the InputStream
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOriginalFilename() {
        return originalFilename;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public boolean isEmpty() {
        return content == null || content.length == 0;
    }

    @Override
    public long getSize() {
        return content.length;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return content;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new ByteArrayInputStream(content);
    }

    @Override
    public void transferTo(java.io.File dest) throws IOException, IllegalStateException {
        throw new UnsupportedOperationException("TransferTo is not supported for custom ByteArrayMultipartFile");
    }
    public static class ByteArrayMultipartFileSerializer extends JsonSerializer<ByteArrayMultipartFile> {
        @Override
        public void serialize(ByteArrayMultipartFile value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeStartObject();
            gen.writeStringField("name", value.getName());
            gen.writeStringField("originalFilename", value.getOriginalFilename());
            gen.writeStringField("contentType", value.getContentType());
            // You can choose how to handle the byte array content
            // Here, we are encoding it as Base64, but you can use any other encoding or method.
            gen.writeStringField("content", Base64.getEncoder().encodeToString(value.getBytes()));
            gen.writeEndObject();
        }
    }

    public static class ByteArrayMultipartFileDeserializer extends JsonDeserializer<ByteArrayMultipartFile> {
        @Override
        public ByteArrayMultipartFile deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            ObjectCodec codec = p.getCodec();
            JsonNode node = codec.readTree(p);

            String name = node.get("name").asText();
            String originalFilename = node.get("originalFilename").asText();
            String contentType = node.get("contentType").asText();
            byte[] content = Base64.getDecoder().decode(node.get("content").asText());

            return new ByteArrayMultipartFile(name, originalFilename, contentType, content);
        }
    }
}
