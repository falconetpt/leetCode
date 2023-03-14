package exercises.linked.list;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class RabbitMQCategorizer {
  static class DataClass {
    private String queue;
    private String messageId;
    private String appId;
    private String payload;


    public String getQueue() {
      return queue;
    }

    public void setQueue(final String queue) {
      this.queue = queue;
    }

    public String getMessageId() {
      return messageId;
    }

    public void setMessageId(final String messageId) {
      this.messageId = messageId;
    }

    public String getAppId() {
      return appId;
    }

    public void setAppId(final String appId) {
      this.appId = appId;
    }

    public String getPayload() {
      return payload;
    }

    public void setPayload(final String payload) {
      this.payload = payload;
    }

    public String toString() {
      return String.join("|", queue, appId, messageId, payload);
    }
  }

  @Test
  public void categorizeLostMessages() throws IOException {
    final var fileTemplate = Files.readAllLines(
      Path.of("/Users/ricardo/Desktop/projects/bank-data-swiftref/application/src/test/resources/lost.txt")
    );

    var data = new DataClass();
    final var result = new ArrayList<String>();
    result.add("queue|app|message_id|message_payload");
    var readNext = false;

    for (final var line : fileTemplate) {
      if (line.startsWith("Message ")) readNext = false;

      if (line.startsWith("Routing Key")) {
        data.setQueue(line.replace("Routing Key", "").trim());
      }

      if (line.startsWith("message_id:")) {
        data.setMessageId(line.replace("message_id:", "").trim());
      }

      if (line.startsWith("app_id")) {
        data.setAppId(line.replace("app_id:", "").trim());
      }

      if (readNext) {
        data.setPayload(line);
        result.add(data.toString());
        data = new DataClass();
      }
      if (line.startsWith("Encoding")) readNext = true;
    }

    final var unique = result.stream()
      .distinct()
      .collect(Collectors.toList());
    System.out.println("result = " + unique.size());

    Files.write(Path.of("/Users/ricardo/Desktop/projects/bank-data-swiftref/application/src/test/resources/output.txt"),
      unique);
  }

  @Test
  public void categorizeLostMessages2() throws IOException {
    final var fileTemplate = Files.readAllLines(
      Path.of("/Users/ricardo/Desktop/projects/bank-data-swiftref/application/src/test/resources/messages.txt")
    );

    final var result = new ArrayList<String>();
    final var header = "|routing_key|exchange|message_count|payload|payload_bytes|payload_encoding|redelivered|";
    result.add(header);

    for (final var line : fileTemplate) {
      if (line.startsWith("+-----") || line.replace(" ", "").equals(header)) {

      } else {
        result.add(line);
      }
    }

    final var unique = result.stream()
      .distinct()
      .collect(Collectors.toList());
    System.out.println("result = " + unique.size());

    Files.write(Path.of("/Users/ricardo/Desktop/projects/bank-data-swiftref/application/src/test/resources/output.txt"),
      unique);
  }

  @Test
  public void categorizeLostMessages3() throws IOException {
    final var fileTemplate = Files.readAllLines(
      Path.of("/Users/ricardo/Downloads/messages.txt")
    );

    var data = new DataClass();
    final var result = new ArrayList<String>();
    result.add("queue|app|message_id|message_payload");
    final var map = new HashMap<String, Map<String, AtomicInteger>>();

    for (final var line : fileTemplate) {
      if (line.contains("routing_key")) {
        data.setQueue(line.replace("\"routing_key\":", "").trim());
      }

      if (line.contains("message_id")) {
        data.setMessageId(line.replace("message_id:", "").trim());
      }

      if (line.contains("app_id")) {
        data.setAppId(line);
        map.putIfAbsent(line, new HashMap<>());
        map.get(line).putIfAbsent(data.getQueue(), new AtomicInteger(0));
        map.get(line).get(data.getQueue()).addAndGet(1);
      }

      if (line.contains("body")) {
        data.setPayload(line);
        result.add(data.toString());
        data = new DataClass();
      }
    }

    final var unique = result.stream()
      .distinct()
      .sorted()
      .collect(Collectors.toList());
    System.out.println("result = " + unique.size());

    map.forEach(this::getPrintln);

    Files.write(Path.of("/Users/ricardo/Desktop/projects/bank-data-swiftref/application/src/test/resources/output.txt"),
      unique);
  }

  private void getPrintln(final String queue, final Map<String, AtomicInteger> values) {
    values
      .forEach((key, value) -> System.out.println(queue + " | " + key + " | COUNT = " + value));
  }
}