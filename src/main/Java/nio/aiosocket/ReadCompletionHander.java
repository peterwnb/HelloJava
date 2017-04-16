package nio.aiosocket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Created by zzqno on 2017-4-13.
 */
public class ReadCompletionHander implements CompletionHandler<Integer, ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;

    public ReadCompletionHander(AsynchronousSocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try {
            String req = new String(body, "UTF-8");
            System.out.println("The time Server receive order:" + req);
            String currtime = "QUERY TIME ORDER:".equalsIgnoreCase(req) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
            doWrite(currtime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {

    }


    private void doWrite(String currTime) {
        if (currTime != null && currTime.trim().length() > 0) {
            byte[] bytes = currTime.getBytes();
            ByteBuffer writeBuff = ByteBuffer.allocate(bytes.length);
            writeBuff.put(bytes);
            writeBuff.flip();
            socketChannel.write(writeBuff, writeBuff, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    if (attachment.hasRemaining()) {
                        socketChannel.write(attachment, attachment, this);
                    }
                }
                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    try {
                        socketChannel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
