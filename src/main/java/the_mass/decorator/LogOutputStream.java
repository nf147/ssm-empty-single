package the_mass.decorator;

import java.io.IOException;
import java.io.OutputStream;

public class LogOutputStream extends OutputStream {
    private OutputStream os;

    public LogOutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        this.os.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        System.out.println("开始了啊！");
        super.write(b);
        System.out.println("结束了啊~");
    }
}
