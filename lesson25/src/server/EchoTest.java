package server;

import java.io.IOException;

public class EchoTest {

    Process server;
    NIOClient client;

    public static void main(String[] args) throws IOException, InterruptedException {
        EchoTest echoTest = new EchoTest();
        echoTest.setup();
        echoTest.givenServerClient__whenServerEchosMessage__thenCorrect();
        echoTest.teardown();

    }

    public void setup() throws IOException, InterruptedException {
        server = NIOServer.start();
        client = NIOClient.start();
    }

    public void givenServerClient__whenServerEchosMessage__thenCorrect() {
        String resp1 = client.sendMessage("hello");
        String resp2 = client.sendMessage("world");
        System.out.println(resp1);
        System.out.println(resp2);
    }

    public void teardown() throws IOException {
        server.destroy();
        NIOClient.stop();
    }
}