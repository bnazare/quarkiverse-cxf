package io.quarkiverse.cxf.transport;

import org.apache.cxf.Bus;
import org.apache.cxf.message.Message;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.cxf.transport.AbstractConduit;
import org.apache.cxf.transport.http.Address;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transport.https.HttpsURLConnectionInfo;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.EndpointReferenceType;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.logging.Logger;

public class UndertowConduit extends AbstractConduit {

    public UndertowConduit(EndpointReferenceType t) {
        super(t);
    }
    //TODO call onMessage()
    @Override
    protected Logger getLogger() {
        return null;
    }

    @Override
    public void prepare(Message message) throws IOException {

    }
    @Override
    public void close(Message msg) throws IOException {
        InputStream in = (InputStream)msg.getContent(InputStream.class);

        try {
            if (in != null) {
                int count = 0;

                for(byte[] buffer = new byte[1024]; in.read(buffer) != -1 && count < 25; ++count) {
                }
            }
        } finally {
            super.close(msg);
        }

    }
}
